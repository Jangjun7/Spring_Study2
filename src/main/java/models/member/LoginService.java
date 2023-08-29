package models.member;

import controllers.member.LoginForm;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LoginService {

    private final MemberDao memberDao;
    private final HttpSession session;
    private final HttpServletResponse response;

    public void login(LoginForm form){
        /**
         * 1. 회원정보 조회
         * 2. 세션에 데이터 유지
         */
        Member member = memberDao.get(form.getUserId());
        session.setAttribute("member", member);

        Cookie cookie = new Cookie("saveId", member.getUserId());
        if(form.isSaveId()) { // 쿠키 아이디 저장
            cookie.setMaxAge(60*60*24*365);
        } else{ // 쿠키에서 아이디 삭제
            cookie.setMaxAge(0);
        }

        response.addCookie(cookie);
    }
}
