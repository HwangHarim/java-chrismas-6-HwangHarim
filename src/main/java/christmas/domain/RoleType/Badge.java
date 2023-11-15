package christmas.domain.RoleType;

import christmas.domain.money.TotalDiscountAmount;
import java.util.Arrays;

public enum Badge {
    STAR("산타", 20000),
    TREE("트리", 10000),
    SANTA("별", 5000),
    NOTTING("없음", 0),
    ;

    private final String value;
    private final int limit;

    private Badge(String value, int limit) {
        this.value = value;
        this.limit = limit;
    }

    public static Badge searchBadge(TotalDiscountAmount amount) {
        return Arrays.stream(Badge.values())
            .filter(limit -> limit.getLimit() <= amount.getTotalDiscountAmount())
            .findFirst().get();
    }

    public String getValue() {
        return value;
    }

    public int getLimit() {
        return limit;
    }
}