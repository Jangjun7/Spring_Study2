package models.member;

import commons.CommonException;
import org.springframework.http.HttpStatus;

public class DuplicateMemberException extends CommonException {
    public DuplicateMemberException(){
        super("이미 등록된 회원 입니다.", HttpStatus.BAD_REQUEST);
    }
}
