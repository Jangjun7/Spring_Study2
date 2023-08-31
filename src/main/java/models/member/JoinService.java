package models.member;

import controllers.member.JoinForm;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class JoinService {

    private final MemberDao memberDao;

    public void join(JoinForm joinForm){
        String userId = joinForm.getUserId();
        if(memberDao.exists(userId)){
            throw new DuplicateMemberException();
        }

        Member member = new ModelMapper().map(joinForm,Member.class);

        memberDao.register(member);
    }
}
