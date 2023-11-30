package dbdip.demo.users;

import dbdip.demo.users.dto.UsersDto;
import dbdip.demo.users.entity.Users;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

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
    @GetMapping("/loginpro")
    public HttpEntity<List<UsersDto>> loginPro(
            @RequestParam("email") String email,
            @RequestParam("password") String password)
    {
        return new HttpEntity<>(userService.login(email, password));
    }

    // 회원 정보 조회
    @GetMapping("/{userId}/information")
    @ResponseBody
    public UsersDto gerUserInformation(
            @PathVariable("userId") Integer userId
    ) {
        return userService.getInformation(userId);
    }

    // 회원 정보 수정
    // 하나만 수정!
    @PostMapping("/{userId}/modification")
    public ResponseEntity<String> modificationInformation(
            @PathVariable("userId") Integer userId,
            @RequestParam(value="name", required = false) String name,
            @RequestParam(value="email", required = false) String email,
            @RequestParam(value="phoneNumber", required = false) String phoneNumber,
            @RequestParam(value="sex", required = false) Character sex,
            @RequestParam(value="birthDate", required = false) @DateTimeFormat(pattern="yyyy-MM-dd") LocalDate birthDate,
            @RequestParam(value="password", required = false) String password
    ) {
        int result = userService.infoModification(userId, name, email, phoneNumber, sex, birthDate, password);
        if (result == 0)
            return new ResponseEntity<>("Information Modification Success", HttpStatus.CREATED);
        else
            return new ResponseEntity<>("Information Modification Failed", HttpStatus.OK);
    }

}
