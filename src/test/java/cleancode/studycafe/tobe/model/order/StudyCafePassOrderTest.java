package cleancode.studycafe.tobe.model.order;

import cleancode.studycafe.tobe.model.pass.StudyCafeSeatPass;
import cleancode.studycafe.tobe.model.pass.StudyCafePassType;
import cleancode.studycafe.tobe.model.pass.locker.StudyCafeLockerPass;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class StudyCafePassOrderTest {

    //1. 전체할인금액 테스트
    @Test
    void getDiscountPrice_returnsCorrectDiscount() {
        // given (시간단위 이용, 1시간, 좌석권: 10000원, 할인율:20%, 라커 이용안함)
        StudyCafeSeatPass seatPass = StudyCafeSeatPass.of(StudyCafePassType.HOURLY, 1, 10000, 0.2);
        StudyCafePassOrder order = StudyCafePassOrder.of(seatPass, null);

        // when (할인 금액 계산 메소드 호출)
        int discountPrice = order.getDiscountPrice();

        // then (할인금액이 2000원이 ㄴ아ㅗ는지 검증)
        assertEquals(2000, discountPrice);
    }


    //2. 총금액 테스트
    @Test
    void getTotalPrice_withLocker_returnsCorrectTotal() {
        // given ( 주단위, 좌석권 : 12000원, 할인율 : 10%, 1주이용)
        // 사물함 이용, 고정석 전용, 1개월, 가격: 3000원
        StudyCafeSeatPass seatPass = StudyCafeSeatPass.of(StudyCafePassType.WEEKLY, 1, 12000, 0.1); // 할인 1200
        StudyCafeLockerPass lockerPass = StudyCafeLockerPass.of(StudyCafePassType.FIXED, 1, 3000);
        StudyCafePassOrder order = StudyCafePassOrder.of(seatPass, lockerPass);

        // when
        int totalPrice = order.getTotalPrice();

        // then
        // 좌석권 + 사물함 -할인 = 12000+3000 -1200=13800 검증
        assertEquals(12000 + 3000 - 1200, totalPrice);
    }
}
