package salestaxes.cucumber;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.junit.Assert;
import salestaxes.Receipt;
import salestaxes.ReceiptItem;
import salestaxes.SALES_TAX_TYPE;

import java.util.List;

/**
 * Created by lorentz on 28/04/16.
 */
public class MyStepDef {

    private static final String REGEX_WORD = "[A-Z a-z]+";
    private static final String REGEX_SINGLE_DIGIT = "\\d+";
    private static final String REGEX_DOT_DIGIT = REGEX_SINGLE_DIGIT + "." + REGEX_SINGLE_DIGIT;

    private Receipt receipt;

    private int counter = 0;

    @Given("^(" + REGEX_SINGLE_DIGIT + ") (" + REGEX_WORD + ") at (" + REGEX_DOT_DIGIT + ") with sales tax (.*)")
    public void receipt_item_with_price(Integer number, String name, Double price, List<String> salesTaxTypesStr) {
        if (receipt == null) {
            receipt = new Receipt();
        }

        SALES_TAX_TYPE[] salesTaxTypes = new SALES_TAX_TYPE[salesTaxTypesStr.size()];

        for (int i = 0; i < salesTaxTypes.length; i++) {
            salesTaxTypes[i] = SALES_TAX_TYPE.getSalesTaxType(salesTaxTypesStr.get(i));
        }

        ReceiptItem item = new ReceiptItem(number, name, price, salesTaxTypes);
        receipt.addItem(item);
    }

    @Then("^total price is (" + REGEX_DOT_DIGIT + ") and total sales tax is (" + REGEX_DOT_DIGIT + ")")
    public void total_receipt_price_and_taxes(Double totalPrice, Double totalTaxes) {
        Assert.assertEquals(totalPrice, receipt.getTotalPrice(), 0);
        Assert.assertEquals(totalTaxes, receipt.getTotalTaxes(), 0);
    }

    @Given("^(" + REGEX_SINGLE_DIGIT + ") (" + REGEX_WORD + "): (" + REGEX_DOT_DIGIT + ")")
    public void total_receipt_item_price(Integer number, String name, Double price) {

        List<ReceiptItem> items = receipt.getItems();
        int size = items.size();

        for (int i = 0; i < items.size(); i++) {
            ReceiptItem item = items.get(i);
            if (item.getName().equals(name)) {
                Assert.assertEquals(price, item.getTotalPrice(), 0);
                if (counter == size) {
                    counter = 0;
                    receipt = null;
                } else {
                    counter++;
                }
                break;
            }
        }
    }

    /* public MyStepDef() {
        Given("^(" + REGEX_SINGLE_DIGIT + ") (" + REGEX_WORD + ") at (" + REGEX_DOT_DIGIT + ") with sales tax (" + REGEX_WORD + ")",
              (Integer number, String name, Double price, String salesTaxTypeStr) -> {
              if(receipt == null) {
                  receipt = new Receipt();
              }
              ReceiptItem item = new ReceiptItem(number, name, price, SALES_TAX_TYPE.getSalesTaxType(salesTaxTypeStr));
                  receipt.addItem(item);
        });

        Then("^total price is (\\d+) and the total sales tax is (\\d+)", (Double totalPrice, Double totalTaxes) -> {
            printOutput = true;
            Assert.assertEquals(totalPrice, receipt.getTotalPrice(), 0);
            Assert.assertEquals(totalTaxes, receipt.getTotalTaxes(), 0);
        });

        Given("^\\d{1}) ([A-Za-Z]+): (\\d+)", (Integer number, String name, Double price) -> {
            for(ReceiptItem item : receipt.getItems()) {
                if(item.getName().equals(name)) {
                    Assert.assertEquals(price, item.getTotalPrice(), 0);
                    break;
                }
            }
        });
    } */
}