package models.member;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data @Builder
@NoArgsConstructor @AllArgsConstructor
public class Member {
    private long userNo;
    private String userId;
    private String userPw;
    private String userNm;
    private LocalDateTime regDt;
}
