package cleancode.studycafe.tobe.model.pass;

import cleancode.studycafe.tobe.model.pass.locker.StudyCafeLockerPass;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StudyCafeSeatPassTest {

    //3. 좌석권 필드 값 확인
    @Test
    void createSeatPass_andVerifyFields() {
        // given
        //주단위, 2주, 15000원, 할인율 10%
        StudyCafePassType passType = StudyCafePassType.WEEKLY;
        int duration = 2;
        int price = 15000;
        double discountRate = 0.1;

        // when (인스턴스 생성)
        StudyCafeSeatPass pass = StudyCafeSeatPass.of(passType, duration, price, discountRate);

        // then (각 필드가 정확히 저장되었는지 검증)
        assertEquals(passType, pass.getPassType());
        assertEquals(duration, pass.getDuration());
        assertEquals(price, pass.getPrice());
        assertEquals(1500, pass.getDiscountPrice()); // 10% 할인
    }

    //4. FIXED가 아닌 이용자는 사물함 사용 불가잉ㄴ지 확인
    @Test
    void cannotUseLocker_returnsTrueForNonLockerType() {
        // given (시간단위 이용권)
        StudyCafeSeatPass pass = StudyCafeSeatPass.of(StudyCafePassType.HOURLY, 1, 5000, 0.0);

        // when & then ( 사물함 사용 불가 true로 반환되는지 확인)
        assertTrue(pass.cannotUseLocker());
    }

}
