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

    public int infoModification(Integer userId, String name, String email, String phoneNumber, Character sex, LocalDate birthDate, String password)
    {
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

        else if(email != null)
        {
            if(!isEmailOverlap(email))
                user.setEmail(email);

            else return -1;
        }

        else if(phoneNumber != null)
        {
            user.setPhoneNumber(phoneNumber);
        }

        else if(sex != null)
        {
            if(sex == 'M' || sex == 'F')
                user.setSex(sex);

            else return -1;
        }

        else if(birthDate != null)
        {
            user.setBirthdate(birthDate);
        }

        else if(password != null)
        {
            user.setPassword(password);
        }

        // 전부 null
        else
        {
            return -1;
        }

        usersRepository.save(user);
        return 0;
    }
}
