package controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController {
    /**
    @GetMapping("/greet") // 찾기 위한 정보
    public String hello() {
        return "hello"; // /WEB-INF/view/hello.jsp
    }
    */

    @GetMapping("/greet")
    public ModelAndView hello() {
        ModelAndView mv = new ModelAndView();
        mv.addObject("name", "이이름");
        mv.setViewName("hello");

        return mv;
    }
}
