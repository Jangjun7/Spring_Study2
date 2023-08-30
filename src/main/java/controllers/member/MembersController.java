package controllers.member;

import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/members")
public class MembersController {
    public String list(@ModelAttribute @Valid SearchForm form, Error errors){
        System.out.println(form);
        return "member/list";
    }
    @GetMapping("/info/{id}")
    public String info(@PathVariable("id") String userId){
        System.out.println("userId : " + userId);

        boolean result = false;
        if(!result){
            throw new RuntimeException("예외 발생.....!!!");
        }

        return "member/info";
    }


}
