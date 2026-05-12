package zl11;

import lombok.Getter;

@Getter
public class LaptopStore {
    private int availableLaptops;
    private int soldLaptops;

    public LaptopStore(int availableLaptops) {
        this.availableLaptops = availableLaptops;
    }

    public synchronized OrderResult buy(Order order) {
        if (order.getQuantity() <= availableLaptops) {
            availableLaptops -= order.getQuantity();
            soldLaptops += order.getQuantity();

            return new OrderResult(order.getClientName(), order.getQuantity(), true, "Udało się kupić");
        }
        return new OrderResult(order.getClientName(), order.getQuantity(), false, "Nie udało się stworzyć zamówienia");
    }

}
