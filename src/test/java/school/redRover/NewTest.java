package school.redRover;

import org.junit.jupiter.api.Test;
import org.testng.Assert;

/**
 * @Author boyko
 */
public class NewTest extends BaseTest{

    @Test
        public void test1() {

    driver.get("https://redrover.school/");
    String title = driver.getTitle();
    Assert.assertTrue(title.equals("RedRover | Non-commercial it-school"));


}
    @Test
    public void test2() {

        driver.get("https://redrover.school/");
        String title = driver.getTitle();
        Assert.assertTrue(title.equals("RedRover | Non-commercial it-school"));

    }

}
