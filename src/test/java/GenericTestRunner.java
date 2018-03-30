import cucumber.api.CucumberOptions;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import cucumber.api.junit.Cucumber;
import cucumber.api.SnippetType;
import services.DataAccess;

@RunWith(Cucumber.class)
@CucumberOptions ( features = "features" ,
        format = {"pretty" ,
                "html:target/site/cucumber-pretty" ,
                "json:target/cucumber.json "} ,
        snippets = SnippetType.CAMELCASE ,
        glue = "steps")
public class GenericTestRunner {

    @BeforeClass
    public static void restoreDatabase(){
        DataAccess.deleteAllOwner();
    }
}
