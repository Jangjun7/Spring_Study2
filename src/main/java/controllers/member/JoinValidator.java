package controllers.member;

import lombok.RequiredArgsConstructor;
import models.member.MemberDao;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
@RequiredArgsConstructor
public class JoinValidator implements Validator {

    private final MemberDao memberDao;

    @Override
    public boolean supports(Class<?> clazz) {
        return clazz.isAssignableFrom(JoinForm.class);
    }

    @Override
    public void validate(Object target, Errors errors) {
        JoinForm joinForm = (JoinForm) target;

        /**
         * 1. 아이디 중복 여부 체크
         * 2. 비번(userPw)과 비번 확인(userPwRe) 일치 여부
         * 3. 휴대전화번호(필수 X) -> 입력된 경우는 형식 체크
         */

        String userId = joinForm.getUserId();

        // 1. 아이디 중복 여부 체크
        if(memberDao.exists(userId)){
            errors.rejectValue("userId", "duplicate");
        }
    }
}
