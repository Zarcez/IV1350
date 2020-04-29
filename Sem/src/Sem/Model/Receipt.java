package Sem.Model;

import java.time.LocalDateTime;

public class Receipt {
    private Sale sale;

    /**
     * Creates a new instance.
     *
     * @param sale The rental proved by this receipt.
     */
    public Receipt(Sale sale) {
        this.sale = sale;
    }

    /**
     * Creates the string for that is used for the printer
     * @return The string used
     */
    public String createReceiptString() {
        StringBuilder builder = new StringBuilder();
        appendLine(builder, "Store: ");
        //builder.append(builder);
        endSection(builder);

        LocalDateTime purchaseTime = LocalDateTime.now();
        builder.append("Time of purchase: ");
        appendLine(builder, purchaseTime.toString());
        endSection(builder);

        builder.append(sale.toString());

        return builder.toString();
    }

    private void appendLine(StringBuilder builder, String line) {
        builder.append(line);
        builder.append("\n");
    }

    private void endSection(StringBuilder builder) {
        builder.append("\n");
    }
}

