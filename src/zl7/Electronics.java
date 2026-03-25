package zl7;

public class Electronics extends Product {
    private static final double VAT = 1.23;
    private final int warranty;

    public Electronics(String name, double price, String category, int warranty) {
        super(name, price, category);
        this.warranty = warranty;
    }

    public static Electronics of(final String name, final double price, final String category, final int warranty) {
        return new Electronics(name, price, category, warranty);
    }

    @Override
    public double calculateFinalPrice() {
        return price * VAT;
    }

    @Override
    public String getDescription() {
        return String.format("Nazwa urządzenia: %s, cena: %.2fzl, cena finalna: %.2f, kategoria: %s, gwarancja: %s miesięcy%n", name, price, calculateFinalPrice(), category, warranty);
    }
}
