package salestaxes.cucumber;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

/**
 * Created by lorentz on 28/04/16.
 */
@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/cucumber")
public class SalesTaxesCucumberTest {
}