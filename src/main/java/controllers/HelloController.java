package controllers;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;

@Controller
@RequiredArgsConstructor
public class HelloController {

    //@Autowired
    private final HttpServletResponse response;

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
    @GetMapping("/test")
    public String test(HttpServletRequest request, HttpSession session){

        System.out.println(request.getContextPath());
        System.out.println(session);

        try {
            response.sendRedirect("https://www.naver.com");
        } catch (IOException e) {}

        return "hello";
    }
}
