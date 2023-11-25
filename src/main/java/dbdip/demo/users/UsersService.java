package dbdip.demo.users;

import dbdip.demo.users.entity.Users;
import dbdip.demo.users.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
    public int login(String email, String passwd)
    {
        List<Users> list = usersRepository.findByEmailAndPassword(email, passwd);

        if(list.isEmpty())
            return -1;

        else
            return list.get(0).getId();
    }
}
