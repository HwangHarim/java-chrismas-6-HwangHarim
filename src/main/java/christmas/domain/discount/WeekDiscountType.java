package christmas.domain.discount;

import christmas.domain.menu.FoodCategory;

public enum WeekDiscountType {
    NOTTING(null, FoodCategory.NOTTING, 0),
    WEEKDAY_DISCOUNT("평일 할인", FoodCategory.DESSERT, 2_023),
    WEEKEND_DISCOUNT("주말 할인", FoodCategory.MAIN, 2_023),
    ;

    private final String type;
    private final FoodCategory foodCategory;
    private final int discount;

    WeekDiscountType(String type, FoodCategory foodCategory, int discount) {
        this.type =type;
        this.foodCategory = foodCategory;
        this.discount = discount;
    }

    public String getType() {
        return type;
    }

    public FoodCategory getFoodCategory() {
        return foodCategory;
    }

    public int getDiscount() {
        return discount;
    }
}