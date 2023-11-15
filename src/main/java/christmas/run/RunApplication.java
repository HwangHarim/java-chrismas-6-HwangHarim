package christmas.run;

import camp.nextstep.edu.missionutils.Console;
import christmas.controller.ChristmasController;
import christmas.dto.request.OrderMenuRequest;
import christmas.dto.request.ReservationDayRequest;
import christmas.resolver.ControllerAndViewMapper;
import christmas.view.input.InputView;
import java.util.function.Supplier;

public class RunApplication {

    private final InputView view = new InputView();
    private final ChristmasController controller = new ChristmasController();
    private final ControllerAndViewMapper result = new ControllerAndViewMapper(controller);

    public void run() {

        checkReserveReservationDay();
        checkReserveOrderMenu();
        Console.close();

        result.viewText();
        result.runDisplayOrderMenu();
        result.runDisplayTotalAmount();
        result.runDisplayGiftEvent();
        result.runDisplayDiscountHistory();
        result.runDisplayTotalDiscountAmount();
        result.runDisplayDiscountedTotalAmount();
        result.runDisplayBadge();
    }

    public void checkReserveReservationDay() {
        try {
            var day = view.reserveReservationDay();
            controller.receiveReservationDay(new ReservationDayRequest(day));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            checkReserveReservationDay();
        }
    }

    public void checkReserveOrderMenu() {
        try {
            var order = view.reserveOrderMenu();
            controller.receiveOrderMenu(new OrderMenuRequest(order));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            checkReserveOrderMenu();
        }
    }
}