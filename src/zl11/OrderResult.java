package zl11;


public record OrderResult(String clientName, int requestedQuantity, boolean success, String message) {
}
