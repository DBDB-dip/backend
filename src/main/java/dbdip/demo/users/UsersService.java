package dbdip.demo.users;

import dbdip.demo.users.dto.UsersDto;
import dbdip.demo.users.entity.Users;
import dbdip.demo.users.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import springfox.documentation.swagger2.mappers.ModelMapper;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UsersService {
    @Autowired
    private UsersRepository usersRepository;

    // DB에 user insert
    public void write(Users user)
    {
        int max_id = usersRepository.findMaxId();
        user.setId(max_id + 1);
        usersRepository.save(user);
    }

    // DB에 해당 이메일, 비밀번로를 가진 user 있으면 userid리턴
    // 없으면 -1 리턴
    public List<UsersDto> login(String email, String passwd)
    {
        return usersRepository.findByEmailAndPassword(email, passwd).stream()
                .map(UsersDto::new).toList();
    }

    public boolean isEmailOverlap(String email)
    {
        List<Users> list = usersRepository.findByEmail(email);

        return !list.isEmpty();
    }

    public UsersDto getInformation(Integer userId)
    {


        Optional<Users> user = usersRepository.findById(userId);

        return user.map(UsersDto::new).orElse(null);
    }

    public int infoModification(Integer userId, String name, String phoneNumber, Character sex, LocalDate birthDate, String password)
    {
        System.out.println(name);
        System.out.println(phoneNumber);
        System.out.println(sex);
        System.out.println(password);

        if(userId == null)
            return -1;

        Optional<Users> optionalUser = usersRepository.findById(userId);
        Users user = optionalUser.orElse(null);

        if(user == null)
            return -1;

        if(name != null)
        {
            user.setName(name);
        }

        if(phoneNumber != null)
        {
            user.setPhoneNumber(phoneNumber);
        }

        if(sex != null)
        {
            if(sex.equals('M') || sex.equals('F'))
                user.setSex(sex);

            else return -1;
        }

        if(birthDate != null)
        {
            user.setBirthdate(birthDate);
        }

        if(password != null)
        {
            user.setPassword(password);
        }

        usersRepository.save(user);

        // 디버깅용
        System.out.println(user.getName());
        System.out.println(user.getPassword());
        System.out.println(user.getPhoneNumber());
        System.out.println(user.getSex());
        System.out.println(user.getBirthdate());


        return 0;
    }

    public void resign(Integer userId)
    {
        usersRepository.deleteById(userId);
    }
}
