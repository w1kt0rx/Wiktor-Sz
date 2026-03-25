package zl7;

public class FoodProduct extends Product {
    private static final double VAT = 1.05;
    private final int expiryDate;

    public FoodProduct(String name, double price, String category, int expiryDate) {
        super(name, price, category);
        this.expiryDate = expiryDate;
    }

    public static FoodProduct of(final String name, final double price, final String category, final int expiryDate) {
        return new FoodProduct(name, price, category, expiryDate);
    }

    @Override
    public double calculateFinalPrice() {
        return price * VAT;
    }

    @Override
    public String getDescription() {
        return String.format("Nazwa urządzenia: %s, cena: %.2fzl, cena finalna: %.2f, kategoria: %s, data ważności: %s tygodni%n", name, price, calculateFinalPrice(), category, expiryDate);
    }
}
