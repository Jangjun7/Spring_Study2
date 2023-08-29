package controllers.member;

import lombok.RequiredArgsConstructor;
import models.member.Member;
import models.member.MemberDao;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
@RequiredArgsConstructor
public class LoginValidator implements Validator {

    private final MemberDao memberDao;

    @Override
    public boolean supports(Class<?> clazz) {
        return clazz.isAssignableFrom(LoginForm.class);
    }

    @Override
    public void validate(Object target, Errors errors) {
        LoginForm loginForm = (LoginForm) target;

        /**
         * 1. 아이디로 조회되는 회원이 있는지?
         * 2. 검색된 회원이 있으면, 비밀번호 검증
         */

        String userId = loginForm.getUserId();
        String userPw = loginForm.getUserPw();

        Member member = memberDao.get(userId);
        if(member == null){
            errors.rejectValue("userId", "login.validation.fail");
        }

        if(member != null) {
            String hash = member.getUserPw();
            boolean match = BCrypt.checkpw(userPw, hash);

            if (!match) {
                errors.rejectValue("userPw", "login.validation.fail");
            }
        }
    }
}
