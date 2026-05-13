package zl11;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public class Main {
    public static void main(String[] args) {
        LaptopStore store = new LaptopStore(10);
        List<Order> orders = new ArrayList<>();

        orders.add(Order.of("Mateusz", 3));
        orders.add(Order.of("Marcin", 4));
        orders.add(Order.of("Włodek", 2));
        orders.add(Order.of("Kazimierz", 10));

        orders.stream()
                .map(order -> CompletableFuture.supplyAsync(() -> store.buy(order)))
                .map(CompletableFuture::join)
                .forEach(System.out::println);


        System.out.println("Sprzedano: " + store.getSoldLaptops() + " laptopów");
        System.out.println("Pozostało na stanie: " + store.getAvailableLaptops() + " laptopów");
    }
}
