package cleancode.studycafe.tobe.model.pass;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class StudyCafeSeatPassesTest {

    //6. hourly 좌석권만 필터링 테스트
    @Test
    void findPassBy_returnsMatchingPassesOnly() {
        // given (hourly 패스권2, weekly 패스권1 생성)
        StudyCafeSeatPass hourlyPass1 = StudyCafeSeatPass.of(StudyCafePassType.HOURLY, 1, 5000, 0.0);
        StudyCafeSeatPass hourlyPass2 = StudyCafeSeatPass.of(StudyCafePassType.HOURLY, 2, 9000, 0.1);
        StudyCafeSeatPass weeklyPass = StudyCafeSeatPass.of(StudyCafePassType.WEEKLY, 1, 20000, 0.2);

        StudyCafeSeatPasses passes = StudyCafeSeatPasses.of(List.of(hourlyPass1, hourlyPass2, weeklyPass));

        // when (hourly만 필터링)
        List<StudyCafeSeatPass> result = passes.findPassBy(StudyCafePassType.HOURLY);

        // then (2개만 필터링되고 그 안에 알맞은 패스권이 들어가있는지 확인)
        assertEquals(2, result.size());
        assertTrue(result.contains(hourlyPass1));
        assertTrue(result.contains(hourlyPass2));
        assertFalse(result.contains(weeklyPass));
    }
}
