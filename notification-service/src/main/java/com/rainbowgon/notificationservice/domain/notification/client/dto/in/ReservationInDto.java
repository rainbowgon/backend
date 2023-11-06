package com.rainbowgon.notificationservice.domain.notification.client.dto.in;

import com.rainbowgon.notificationservice.domain.notification.entity.Type;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ReservationInDto {

    private Long profileId;
    private String fcmToken;
    private Long themeId;
    private String themeName;
    private LocalDate reservationDate;
    private LocalTime reservationTime;
    private Type reservationType;

}
