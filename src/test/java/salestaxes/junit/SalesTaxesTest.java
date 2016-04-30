package salestaxes.junit;

import org.junit.Assert;
import org.junit.Test;
import salestaxes.Receipt;
import salestaxes.ReceiptItem;
import salestaxes.SALES_TAX_TYPE;

/**
 * Created by lorentz on 27/04/16.
 */
public class SalesTaxesTest {

    @Test
    public void testInput1() {

        double expectedBookPrice = 12.49;
        double expectedMusicPrice = 16.49;
        double expectedChocolatePrice = 0.85;
        double totalTaxes = 1.50;
        double totalPrices = 29.83;

        Receipt receipt1 = new Receipt();
        ReceiptItem bookItem = new ReceiptItem(1, "book", 12.49, SALES_TAX_TYPE.EXEMPT);
        receipt1.addItem(bookItem);

        Assert.assertEquals(expectedBookPrice, bookItem.getTotalPrice(), 0);

        ReceiptItem musicCdItem = new ReceiptItem(1, "music CD", 14.99, SALES_TAX_TYPE.BASIC);
        receipt1.addItem(musicCdItem);

        Assert.assertEquals(expectedMusicPrice, musicCdItem.getTotalPrice(), 0);

        ReceiptItem chocolateItem = new ReceiptItem(1, "chocolate bar", 0.85, SALES_TAX_TYPE.EXEMPT);
        receipt1.addItem(chocolateItem);

        Assert.assertEquals(expectedChocolatePrice, chocolateItem.getTotalPrice(), 0);
        Assert.assertEquals(totalTaxes, receipt1.getTotalTaxes(), 0);
        Assert.assertEquals(totalPrices, receipt1.getTotalPrice(), 0);

        System.out.println(receipt1);
    }

    @Test
    public void testInput2() {

        double expectedimportedChocolatePrice = 10.50;
        double expectedImportedBottlePerfumePrice = 54.65;
        double totalTaxes = 7.65;
        double totalPrices = 65.15;

        Receipt receipt2 = new Receipt();
        ReceiptItem importedChocolateItem = new ReceiptItem(1, "imported box of chocolate", 10.00, SALES_TAX_TYPE.IMPORTED);
        receipt2.addItem(importedChocolateItem);

        Assert.assertEquals(expectedimportedChocolatePrice, importedChocolateItem.getTotalPrice(), 0);

        ReceiptItem importedBottlePerfumeItem = new ReceiptItem(1, "imported bottle of perfume", 47.50, SALES_TAX_TYPE.IMPORTED, SALES_TAX_TYPE.BASIC);
        receipt2.addItem(importedBottlePerfumeItem);

        Assert.assertEquals(expectedImportedBottlePerfumePrice, importedBottlePerfumeItem.getTotalPrice(), 0);

        Assert.assertEquals(totalTaxes, receipt2.getTotalTaxes(), 0);
        Assert.assertEquals(totalPrices, receipt2.getTotalPrice(), 0);


        System.out.println(receipt2);
    }

    @Test
    public void testInput3() {

        double expectedImportedBottlePerfumePrice = 32.19;
        double expectedBottlePerfumePrice = 20.89;
        double expectedPacketHeadachePillsPrice = 9.75;
        double expectedimportedChocolatePrice = 11.85;
        double totalTaxes = 6.70;
        double totalPrices = 74.68;

        Receipt receipt3 = new Receipt();

        ReceiptItem importedBottlePerfumeItem = new ReceiptItem(1, "imported bottle of perfume", 27.99, SALES_TAX_TYPE.IMPORTED, SALES_TAX_TYPE.BASIC);
        receipt3.addItem(importedBottlePerfumeItem);

        Assert.assertEquals(expectedImportedBottlePerfumePrice, importedBottlePerfumeItem.getTotalPrice(), 0);

        ReceiptItem bottlePerfumeItem = new ReceiptItem(1, "bottle of perfume", 18.99, SALES_TAX_TYPE.BASIC);
        receipt3.addItem(bottlePerfumeItem);

        Assert.assertEquals(expectedBottlePerfumePrice, bottlePerfumeItem.getTotalPrice(), 0);

        ReceiptItem headachePillsItem = new ReceiptItem(1, "packet of headache pills ", 9.75, SALES_TAX_TYPE.EXEMPT);
        receipt3.addItem(headachePillsItem);

        Assert.assertEquals(expectedPacketHeadachePillsPrice, headachePillsItem.getTotalPrice(), 0);

        ReceiptItem importedChocolateItem = new ReceiptItem(1, "imported box of chocolate", 11.25, SALES_TAX_TYPE.IMPORTED);
        receipt3.addItem(importedChocolateItem);

        Assert.assertEquals(expectedimportedChocolatePrice, importedChocolateItem.getTotalPrice(), 0);

        Assert.assertEquals(totalTaxes, receipt3.getTotalTaxes(), 0);
        Assert.assertEquals(totalPrices, receipt3.getTotalPrice(), 0);

        System.out.println(receipt3);
    }
}