package christmas.view.input;

import static camp.nextstep.edu.missionutils.Console.*;

import christmas.filter.BlankInputFilter;

public class InputView extends BlankInputFilter {

    public String reserveReservationDay() {
        System.out.println("안녕하세요! 우테코 식당 12월 이벤트 플래너입니다.");
        return blankInputReservationDayFilter(readLine());
    }

    public String reserveOrderMenu() {
        System.out.println("주문하실 메뉴를 메뉴와 개수를 알려 주세요. (e.g. 해산물파스타-2,레드와인-1,초코케이크-1)");
        return blankInputOrderMenuFilter(readLine());
    }
}