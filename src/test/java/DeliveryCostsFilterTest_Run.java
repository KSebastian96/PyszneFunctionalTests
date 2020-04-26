import cucumber.api.CucumberOptions;
import cucumber.api.junit.*;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/features/deliveryCostsFilter.feature",
        plugin = {"pretty", "html:report"})
public class DeliveryCostsFilterTest_Run {
}
