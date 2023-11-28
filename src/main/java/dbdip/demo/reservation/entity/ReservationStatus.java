package dbdip.demo.reservation.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum ReservationStatus {
    BEFORE_TODAY("오늘보다 이전에 예약 되었습니다."),
    TODAY("오늘은 예약 당일 입니다."),
    AFTER_TODAY("오늘보다 이후에 예약 되었습니다.");

    private final String title;
}
