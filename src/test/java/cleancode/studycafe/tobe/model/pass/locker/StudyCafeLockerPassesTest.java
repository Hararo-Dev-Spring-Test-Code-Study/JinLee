package cleancode.studycafe.tobe.model.pass.locker;

import cleancode.studycafe.tobe.model.pass.StudyCafePassType;
import cleancode.studycafe.tobe.model.pass.StudyCafeSeatPass;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class StudyCafeLockerPassesTest {

    //7. findLockerPassBy 검증
    @Test
    void findLockerPassBy_returnsMatchingLockerPass() {
        // given (이용권 타입, 기간이 같은 좌석 이용권 생성 + 아닌 좌석 이용권)
        StudyCafeSeatPass seatPass = StudyCafeSeatPass.of(StudyCafePassType.FIXED, 3, 20000, 0.0);
        StudyCafeLockerPass matchingLocker = StudyCafeLockerPass.of(StudyCafePassType.FIXED, 3, 5000);
        StudyCafeLockerPass nonMatchingLocker = StudyCafeLockerPass.of(StudyCafePassType.FIXED, 2, 4000);

        StudyCafeLockerPasses lockerPasses = StudyCafeLockerPasses.of(List.of(matchingLocker, nonMatchingLocker));

        // when (seatPass와 매칭되는 사물함 찾음 passType, duration 같은것)
        Optional<StudyCafeLockerPass> result = lockerPasses.findLockerPassBy(seatPass);

        // then
        assertTrue(result.isPresent()); //결과가 존재해야함
        assertEquals(matchingLocker, result.get()); // 반환된 사물함이 matchingLocker가 맞는지 검증
    }
}
