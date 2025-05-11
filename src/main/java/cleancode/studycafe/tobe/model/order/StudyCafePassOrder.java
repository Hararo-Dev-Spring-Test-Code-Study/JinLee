package cleancode.studycafe.tobe.model.order;

import cleancode.studycafe.tobe.model.pass.StudyCafeSeatPass;
import cleancode.studycafe.tobe.model.pass.locker.StudyCafeLockerPass;

import java.util.Optional;

public class StudyCafePassOrder {

    private final StudyCafeSeatPass seatPass;
    private final StudyCafeLockerPass lockerPass;

    private StudyCafePassOrder(StudyCafeSeatPass seatPass, StudyCafeLockerPass lockerPass) {
        this.seatPass = seatPass;
        this.lockerPass = lockerPass;
    }

    //두 객체를 받아 인스턴스 생성
    public static StudyCafePassOrder of(StudyCafeSeatPass seatPass, StudyCafeLockerPass lockerPass) {
        return new StudyCafePassOrder(seatPass, lockerPass);
    }

    //할인금액 반환
    public int getDiscountPrice() {
        return seatPass.getDiscountPrice();
    }

    //전체금액=좌석권 가격+ 사물함 가격- 할인금액
    public int getTotalPrice() {
        int lockerPassPrice = lockerPass != null ? lockerPass.getPrice() : 0;
        int totalPassPrice = seatPass.getPrice() + lockerPassPrice;

        return totalPassPrice - getDiscountPrice();
    }

    //좌석권 반환
    public StudyCafeSeatPass getSeatPass() {
        return this.seatPass;
    }

    //사물함권 존재시 Optional로 감싸서 반환(없을시 Optional.empty 반환)
    public Optional<StudyCafeLockerPass> getLockerPass() {
        return Optional.ofNullable(lockerPass);
    }

}
