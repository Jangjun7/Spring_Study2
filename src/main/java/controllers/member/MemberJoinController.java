package controllers.member;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/member/join") // 공통적인 주소
public class MemberJoinController {
    @GetMapping // /member/join
    // @RequestMapping(method = RequestMethod.GET, path="/member/join")
    public String join(){
        return "member/join";
    }

    @PostMapping  // /member/join
    public String joinPs(@RequestParam(value = "userId", required = false, defaultValue = "없는 아이디") String memId, String userPw, boolean agree){
        System.out.printf("userId=%s, userPw=%s, agree=%s%n", memId, userPw, agree);
        return null;
    }
}
