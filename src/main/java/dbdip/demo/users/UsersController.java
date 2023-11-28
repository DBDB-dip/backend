package dbdip.demo.users;

import dbdip.demo.users.entity.Users;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UsersController {

    @Autowired
    private UsersService userService;

    @GetMapping("/join")
    public String userJoinForm()
    {
        // 가입 양식 html 파일 전송
        return "";
    }

    // 가입 양식에 맞춰 user가 post 방식으로 데이터 전송
    @PostMapping("/joinpro")
    @Transactional
    public String userJoinPro(Users user)
    {
        // ㅠㅠ if문에서 이메일이 중복되는 걸 검사하면 어떻게 처리해야할지 모르겠어요
        if(userService.isEmailOverlap(user.getEmail()))
            return "";

        // 이메일이 중복되지 않으면 회원 가입
        userService.write(user);

        // ㅠㅠ 다시 메인페이지 ("/")로 돌아가야하는데 그 처리를 못 하겠어요..
        return "";
    }

    @GetMapping("/")
    public String mainPage()
    {
        // ㅠㅠ 메인 페이지 html? 을 받아야 하는데 없어서 비워놓았어요
        return "";
    }

    // 로그인 시 email, 비밀번호가 해당 경로로 전송
    // 로그인 실패시 -1, 성공시 uid 리턴
    @PostMapping("/login")
    @ResponseBody
    public Integer loginPro(
            @RequestParam("email") String email,
            @RequestParam("password") String password)
    {
        return userService.login(email, password);
    }
}
