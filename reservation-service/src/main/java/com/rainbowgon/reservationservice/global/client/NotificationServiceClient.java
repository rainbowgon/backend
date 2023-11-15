package com.rainbowgon.reservationservice.global.client;

import com.rainbowgon.reservationservice.global.client.dto.output.SuccessNotificationOutDto;
import com.rainbowgon.reservationservice.global.response.ResponseWrapper;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.lang.Nullable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(name = "notification-service")
@RequestMapping("/clients/notifications")
public interface NotificationServiceClient {

    @PostMapping("/reservation")
    ResponseWrapper<Nullable> notifyReservationSuccess(
            @RequestBody SuccessNotificationOutDto notificationOutDto);
}
