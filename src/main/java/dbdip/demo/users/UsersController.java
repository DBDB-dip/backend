package dbdip.demo.users;

import dbdip.demo.users.entity.Users;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UsersController {

    private UsersService userService;

    @GetMapping("/join")
    public String userJoinForm()
    {
        // 가입 양식 html 파일 전송
        return "";
    }

    // 가입 양식에 맞춰 user가 post 방식으로 데이터 전송
    @PostMapping("/joinpro")
    public String userJoinPro(Users user)
    {
        userService.write(user);

        // ㅠㅠ 다시 메인페이지 ("/")로 돌아가야함
        return "";
    }

    @GetMapping("/")
    public String mainPage()
    {
        // ㅠㅠ 메인 페이지 html리턴
        return "";
    }

    // 로그인 시 email, 비밀번호가 해당 경로로 전송
    @PostMapping("/login")
    public String loginPro(String email, String password)
    {
        int uid = userService.login(email, password);

        // 로그인 실패
        if(uid == -1)
            // ㅠㅠ 로그인 실패 시 메인페이지로 돌아가야 함
            return "";

        // 로그인 성공 시 uid 리턴 받음
        // ㅠㅠ 이에 대해 어떻게 처리해야할지 모르겠습니다
        return "";
    }
}
