package com.rainbowgon.reservationservice.global.client;

import com.rainbowgon.reservationservice.global.client.dto.input.ThemeBreifInfoInDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "search-service")
public interface SearchServiceClient {

    // TODO URL 수정하기
    @GetMapping("/{theme-id}")
    ThemeBreifInfoInDto getThemeInfoForReservation(@PathVariable("theme-id") String themeId);

}