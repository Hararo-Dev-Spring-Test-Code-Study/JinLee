package cleancode.studycafe.tobe.model.pass.locker;

import cleancode.studycafe.tobe.model.pass.StudyCafePassType;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StudyCafeLockerPassTest {
    //5. isSamePassType 메소드 검증
    @Test
    void isSamePassType_returnsTrueWhenMatch() {
        // given ( 고정석으로 사물함 이용권 생성)
        StudyCafeLockerPass lockerPass = StudyCafeLockerPass.of(StudyCafePassType.FIXED, 1, 5000);

        // when & then (lockerpass의 유형이 FIXE인지 검증)
        assertTrue(lockerPass.isSamePassType(StudyCafePassType.FIXED));
        assertFalse(lockerPass.isSamePassType(StudyCafePassType.WEEKLY));
    }
}
