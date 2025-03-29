package advanced.chapter05;

import me.bossm0n5t3r.advanced.chapter05.Exercise01Money;
import me.bossm0n5t3r.advanced.chapter05.Exercise01Money.Money;

import java.math.BigDecimal;
import java.util.List;

public class Exercise01MoneyJavaClass {
    public static void main(String[] args) {
        Money money1 = Money.eur("10.00");
        Money money2 = Money.eur("29.99");

        List<Money> moneyList = List.of(money1, money2, money1);

        System.out.println(Exercise01Money.plus(money1, money2)); // Money(amount=39.99, currency=EUR)

        Money money3 = Money.usd("10.00");
        Money money4 = new Money();
        Money money5 = new Money(BigDecimal.ONE);
        Money money6 = Money.ZERO_EUR;
    }
}
