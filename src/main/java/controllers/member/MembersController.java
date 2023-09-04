package controllers.member;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import models.member.Member;
import models.member.MemberDao;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/members")
@RequiredArgsConstructor
public class MembersController {

    private final MemberDao memberDao;

    @GetMapping("/list")
    public String list2(Model model){
        List<Member> members = memberDao.getList();
        model.addAttribute("members", members);
        model.addAttribute("menuCode", "member");
        return "member/list";
    }

    public String list(@ModelAttribute @Valid SearchForm form, Error errors){
        System.out.println(form);
        return "member/list";
    }
    @GetMapping("/info/{id}")
    public String info(@PathVariable("id") String userId, Model model){

        Member member = memberDao.get(userId);
        model.addAttribute("member", member);
        model.addAttribute("title","<h1>제목</h1>");

        /*
        boolean result = false;
        if(!result){
            throw new RuntimeException("예외 발생.....!!!");
        }
        */

        return "member/info";
    }

    @ResponseBody
    @GetMapping("/members2")
    public List<Member> members2(){
        List<Member> members = memberDao.getList();

        return members;
    }

}
