package com.rainbowgon.memberservice.global.client.dto.output;

import lombok.*;

import java.util.List;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
public class ThemeListOutDto {

    private List<String> themeIdList;
}
