import Driver.DriverFactory.DriverFactory;
import Driver.DriverFactory.DriverManager;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.*;

@CucumberOptions(
        features = "Feature_Files",
        glue = {"stepDefinition"},
        tags = "@Task2",
        plugin = {"pretty",
                "summary",
                "html:target/cucumber/cucumber-reports.html",
                "html:target/cucumber-reports",
                "json:target/cucumber/cucumber-json-report.json"},
    monochrome = false,publish = true )

public class TestRunner extends AbstractTestNGCucumberTests {

    @BeforeMethod(alwaysRun = true)
    public void setUp(){
        DriverManager.initDriver();
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown() {
        try{
        if (DriverFactory.getDriver() != null){
            DriverFactory.getDriver().quit();
            DriverFactory.setDriver(null);
        }
    }
        catch (Exception e){
        }

        }

}