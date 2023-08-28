package controllers.member;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/member/join")
@RequiredArgsConstructor
public class MemberJoinController {

    private final JoinValidator joinValidator;

    @GetMapping
    public String join(@ModelAttribute JoinForm joinForm, Model model) {


        return "member/join2";
    }

    @PostMapping
    public String joinPs(@Valid JoinForm form, Errors errors, Model model) {

        joinValidator.validate(form, errors);

        if (errors.hasErrors()) { // reject, rejectValue -> true
            return "member/join2";
        }


        return "redirect:/member/login";
    }

    private void commonProcess(Model model) {
        List<Item> hobbies = getHobbies();
        model.addAttribute("hobbies", hobbies);

        List<Item> types = getMemberTypes();
        model.addAttribute("types", types);
    }

    private List<Item> getMemberTypes() {
        List<Item> types = Arrays.asList(
                new Item("개인회원", "private"),
                new Item("사업자회원", "company")
        );

        return types;
    }

    private List<Item> getHobbies() {
        List<Item> hobbies = Arrays.asList(
                new Item("자바", "JAVA"),
                new Item("JSP", "JSP"),
                new Item("스프링", "SPRING"),
                new Item("스프링부트", "SPRINGBOOT")
        );

        return hobbies;
    }

    /*
    @InitBinder
    public void InitBinder(WebDataBinder binder) {
        binder.setValidator(joinValidator);
    }
     */

}