package com.rainbowgon.searchservice.domain.theme.controller;

import com.rainbowgon.searchservice.domain.theme.dto.request.ThemeCheckReqDtoList;
import com.rainbowgon.searchservice.domain.theme.dto.response.ThemeDetailResDto;
import com.rainbowgon.searchservice.domain.theme.dto.response.ThemeSimpleResDto;
import com.rainbowgon.searchservice.domain.theme.service.ThemeService;
import com.rainbowgon.searchservice.global.response.JsonResponse;
import com.rainbowgon.searchservice.global.response.ResponseWrapper;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/themes")
public class ThemeController {

    private final ThemeService themeService;

    @GetMapping("/searches")
    public ResponseEntity<ResponseWrapper<List<ThemeSimpleResDto>>> searchThemes(
            @RequestParam(required = false, defaultValue = "") String keyword,
            @RequestParam(required = false, defaultValue = "0") int page,
            @RequestParam(required = false, defaultValue = "10") int size) {
        Page<ThemeSimpleResDto> searchList = themeService.searchThemes(keyword, page, size);

        return JsonResponse.ok("성공적으로 검색이 완료되었습니다.", searchList);
    }

    @GetMapping("/sorts")
    public ResponseEntity<ResponseWrapper<List<ThemeSimpleResDto>>> sortThemes(
            @RequestParam(required = false, defaultValue = "") String keyword,
            @RequestParam(required = false, defaultValue = "RECOMMEND") String sortBy,
            @RequestParam(required = false, defaultValue = "0") int page,
            @RequestParam(required = false, defaultValue = "10") int size) {
        Page<ThemeSimpleResDto> searchList = themeService.sort(keyword, sortBy, page, size);


        return JsonResponse.ok("성공적으로 정렬 검색이 완료되었습니다.", searchList);
    }

    @GetMapping("/{theme-id}")
    public ResponseEntity<ResponseWrapper<ThemeDetailResDto>> selectTheme(
            @PathVariable("theme-id") String themeId) {
        ThemeDetailResDto searchTheme = themeService.selectOneThemeById(themeId);

        return JsonResponse.ok("성공적으로 조회가 완료되었습니다.", searchTheme);
    }

    @GetMapping("/lists")
    public ResponseEntity<ResponseWrapper<List<ThemeDetailResDto>>> selectThemes(
            @RequestBody ThemeCheckReqDtoList themeCheckReqDtoList) {
        List<ThemeDetailResDto> themeDetailResDtoList = themeService.selectThemesById(themeCheckReqDtoList);

        return JsonResponse.ok("성공적으로 조회(리스트)가 완료되었습니다.", themeDetailResDtoList);
    }

    @GetMapping("/review/{theme-id}")
    public ResponseEntity<?> review(@PathVariable("theme-id") String themeId) {
        themeService.reviewCnt(themeId);

        return JsonResponse.ok("리뷰 완료되었습니다.");
    }

    @GetMapping("/bookmark/{theme-id}")
    public ResponseEntity<?> bookmark(@PathVariable("theme-id") String themeId) {
        themeService.bookmarkCnt(themeId);

        return JsonResponse.ok("북마크 완료되었습니다.");
    }

}
