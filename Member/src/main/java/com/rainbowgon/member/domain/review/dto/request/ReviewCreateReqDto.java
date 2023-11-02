package com.rainbowgon.member.domain.review.dto.request;

import com.rainbowgon.member.domain.bookmark.entity.EscapeStatus;
import com.rainbowgon.member.domain.bookmark.entity.SpoilStatus;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.time.LocalTime;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ReviewCreateReqDto {

    private Long themeId;
    private Double rating;
    private EscapeStatus isEscaped;
    private Integer myLevel;
    private Integer hintCount;
    private String content;
    private SpoilStatus isSpoiler;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate performedDate;
    @DateTimeFormat(pattern = "hh:mm")
    private LocalTime performedTime;
    private Integer performedHeadcount;
}
