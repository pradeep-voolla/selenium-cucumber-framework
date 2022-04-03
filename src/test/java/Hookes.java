import io.cucumber.java.After;
import io.cucumber.java.Before;
import utility.CommonLibrary;

public class Hookes extends CommonLibrary {
    @Before
    public void beforeMethod() {
        openBroswer();
    }
    @After
    public void afterMethod() {
        closeBroser();
    }

}
