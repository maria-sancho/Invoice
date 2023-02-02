import java.text.DecimalFormat;

public class InvoiceLine {
    private int quantity;
    private String itemCode;
    private String itemDescription;
    private float unitPrice;
    private float discountRate;

    public InvoiceLine(int quantity, String itemCode, String itemDescription, float unitPrice, float discountRate) {
        this.quantity = quantity;
        this.itemCode = itemCode;
        this.itemDescription = itemDescription;
        this.unitPrice = unitPrice;
        this.discountRate = discountRate;
    }

    public float getTotal() {
        return quantity * unitPrice * (1 - discountRate / 100);
    }

    public String toString() {
        return String.format("          | %d | %s | %s | $%s | %.2f%% | $%s |",
                quantity, itemCode, itemDescription, customFormat("###,###.00", unitPrice), discountRate, customFormat("###,###.00", getTotal()));
    }

    public static String customFormat(String pattern, double value ){
        DecimalFormat myFormatter = new DecimalFormat(pattern);
        String output = myFormatter.format(value);
        return output;
    }
}
