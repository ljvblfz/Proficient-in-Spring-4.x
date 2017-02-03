package sample.testng;

import org.testng.annotations.Test;


@Test(groups = {"class-group"})
public class TestNGGroupsTest2 {

    @Test(groups = {"group1", "group2"})
    public void testMethod3() {
    }

    @Test(groups = {"group1", "group2"})
    public void testMethod4() {
    }

    @Test(groups = {"group1"})
    public void testMethod5() {
    }

}
