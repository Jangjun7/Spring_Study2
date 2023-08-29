package controllers.member;

import jakarta.validation.constraints.Null;
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
        String userPw = joinForm.getUserPw();
        String userPwRe = joinForm.getUserPwRe();
        String mobile = joinForm.getMobile();

        // 1. 아이디 중복 여부 체크
        if(memberDao.exists(userId)){
            errors.rejectValue("userId", "duplicate");
        }

        // 2. 비번(userPw)과 비번 확인(userPwRe) 일치 여부
        if(userPw != null && !userPw.isBlank() && userPwRe != null && !userPwRe.isBlank()
        && !userPw.equals(userPwRe)){
            errors.rejectValue("userPwRe", "mismatch");
        }

        // 3. 휴대전화번호(필수 X) -> 입력된 경우는 형식 체크
        if(mobile != null && !mobile.isBlank()){
            /**
             * 1) 형식 통일화 010-0000-0000 010.0000.0000 -> 숫자로 변환
             * 2) 패턴
             *      010,016,011
             */

            mobile = mobile.replaceAll("\\D", "");

            String pattern = "^01[016]\\d{3,4}\\d{4}$";
            if(!mobile.matches(pattern)) { // 휴대전화 번호 형식이 아닌 경우
                errors.rejectValue("mobile", "format");
            }

            //errors.reject("commonError", "공통 오류 출력!!");
        }
    }
}
