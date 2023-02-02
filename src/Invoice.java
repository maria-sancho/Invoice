import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Invoice {
    private int invoiceNumber;
    private Date invoiceDate;
    private String billingAddress;
    private String shippingAddress;
    private String salesPerson;
    private String shippingMethod;
    private String shippingTerms;
    private Date deliveryDate;
    private String paymentTerms;
    private Date dueDate;
    private float totalDiscount;
    private List<InvoiceLine> lines;

    public Invoice(int invoiceNumber, Date invoiceDate, String billingAddress, String shippingAddress,
                   String salesPerson, String shippingMethod, String shippingTerms, Date deliveryDate,
                   String paymentTerms, Date dueDate, float totalDiscount) {
        this.invoiceNumber = invoiceNumber;
        this.invoiceDate = invoiceDate;
        this.billingAddress = billingAddress;
        this.shippingAddress = shippingAddress;
        this.salesPerson = salesPerson;
        this.shippingMethod = shippingMethod;
        this.shippingTerms = shippingTerms;
        this.deliveryDate = deliveryDate;
        this.paymentTerms = paymentTerms;
        this.dueDate = dueDate;
        this.totalDiscount = totalDiscount;
        lines = new ArrayList<>();
    }

    public void addInvoiceLine(InvoiceLine line) {
        lines.add(line);
    }

    public void print() {
        System.out.println("Invoice number: " + invoiceNumber);
        System.out.println("DATE: " + invoiceDate);
        System.out.println("TO: " + billingAddress);
        System.out.println("SHIP TO: " + shippingAddress);
        System.out.println("...........................................................................................................................");
        System.out.println("| SALES PERSON | SHIPPING METHOD | SHIPPING TERMS | DELIVERY DATE | PAYMENT TERMS | DUE DATE |");
        System.out.println("...........................................................................................................................");
        System.out.println(String.format("| %s | %s | %s | %s | %s | %s |", salesPerson, shippingMethod, shippingTerms, deliveryDate, paymentTerms, dueDate));
        System.out.println("...........................................................................................................................");
        System.out.println("");
        System.out.println("...........................................................................................................................");
        System.out.println("| QTY | Item # | DESCRIPTION | UNIT PRICE | DISCOUNT | LINE TOTAL |");
        System.out.println("...........................................................................................................................");
        for (InvoiceLine line : lines) {
            System.out.println(line);
        }
        System.out.println("...........................................................................................................................");
        float subtotal = 0;
        for (InvoiceLine line : lines) {
            subtotal += line.getTotal();
        }
        float discountAmount = subtotal * totalDiscount / 100;
        float total = subtotal - discountAmount;
        System.out.println("| TOTAL DISCOUNT | " + InvoiceLine.customFormat("###,###.00", totalDiscount) + "% | $" + InvoiceLine.customFormat("###,###.00", discountAmount) + " |");
        System.out.println(".................");
        System.out.println("| SUBTOTAL | $" + InvoiceLine.customFormat("###,###.00", subtotal) + " |");
        System.out.println(".................");
        System.out.println("| GST | $" + InvoiceLine.customFormat("###,###.00", total * 0.21) + " |");
        System.out.println("-.................");
        System.out.println("| TOTAL | $" + InvoiceLine.customFormat("###,###.00", total) + " |");
        System.out.println(".................");
    }
}