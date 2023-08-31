package models.member;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
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

    @JsonIgnore // 번역 배제
    private String userPw;
    private String userNm;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime regDt;
}
