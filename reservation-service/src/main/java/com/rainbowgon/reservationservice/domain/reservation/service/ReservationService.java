package com.rainbowgon.reservationservice.domain.reservation.service;

import com.rainbowgon.reservationservice.domain.reservation.dto.request.ReservationReqDto;
import com.rainbowgon.reservationservice.domain.reservation.dto.response.ReservationBaseInfoResDto;
import com.rainbowgon.reservationservice.domain.reservation.dto.response.ReservationResultResDto;

public interface ReservationService {

    ReservationBaseInfoResDto getReservationBaseInfo(String memberId, String themeId);

    ReservationBaseInfoResDto getReservationBaseInfo(String themeId);

    ReservationResultResDto makeReservation(String memberId, ReservationReqDto reservationReqDto);

    ReservationResultResDto makeReservation(ReservationReqDto reservationReqDto);

}
