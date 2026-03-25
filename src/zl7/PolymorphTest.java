package zl7;

import java.util.ArrayList;
import java.util.List;

public class PolymorphTest {
    public static void main(String[] args) {
        List<Product> productList = new ArrayList<>();
        productList.add(Electronics.of("Nokia 3310", 23.33, "Telefon", 6));
        productList.add(Electronics.of("Logitech", 50.55, "Klawiatura", 12));
        productList.add(Electronics.of("Samsung", 153.33, "Lodówka", 24));
        productList.add(FoodProduct.of("Salami", 10.00, "Mięso", 3));
        productList.add(FoodProduct.of("Ser gołda", 5.00, "Nabiał", 2));
        for (Product product : productList) {
            System.out.print(product.getDescription());
        }
        int countElectronics = 0;

        for (Product product : productList) {
            if (product instanceof Electronics) {
                countElectronics++;
            }
        }
        System.out.println(countElectronics);

    }
}
