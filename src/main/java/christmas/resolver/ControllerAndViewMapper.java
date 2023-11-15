package christmas.resolver;

import christmas.controller.ChristmasController;
import christmas.converter.Converter;
import christmas.view.output.OutputView;

public class ControllerAndViewMapper {

    private final ChristmasController controller;
    private final Converter converter = new Converter();
    private final OutputView view = new OutputView();

    public ControllerAndViewMapper(ChristmasController christmasController) {
        this.controller = christmasController;
    }

    public void viewText(){
        view.displayOutText();
    }

    public void runDisplayOrderMenu() {
        view.displayOrderMenu(
            converter.orderMenuConvertToString(controller.getOrderMenuResult())
        );
    }

    public void runDisplayTotalAmount() {
        view.displayTotalAmount(
            controller.getTotalAmountResult().getTotalAmount()
        );
    }

    public void runDisplayGiftEvent() {
        view.displayGiftEvent(
            controller.getGiftResult().getGift()
        );
    }

    public void runDisplayDiscountHistory() {
        var response = controller.getDiscountHistory();
        if (response.getChrisMasCountDownDiscount() == 0 && response.getSpecialDiscount() == 0
            && response.getGiftDiscountResult().equals("없음") && response.getWeekDiscount() == 0) {
            view.displayDiscountHistory("없음");
            return;
        }

        view.displayDiscountHistory(
            converter.discountHistoryConvertToString(response)
        );
    }

    public void runDisplayTotalDiscountAmount() {
        view.displayTotalDiscountAmount(
            converter.convertMinusMoneyFormat(
                controller.getTotalDiscountAmountResult().getTotalDiscountAmount())
        );
    }

    public void runDisplayDiscountedTotalAmount() {
        view.displayDiscountedTotalAmount(
            converter.convertMoneyFormat(
                controller.getDiscountedTotalAmountResult().getDiscountedTotalAmount())

        );
    }

    public void runDisplayBadge() {
        view.displayBadge(controller.getBadgeResult().getBadge());
    }
}
