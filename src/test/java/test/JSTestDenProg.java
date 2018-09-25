package test;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import page.AlertPage;

public class JSTestDenProg extends BaseTest{
    @DataProvider
    public Object[][] data() {
        return new Object[][]{
                {"9","2013","13","Поздравляю"},
                {"9","2012","12","Поздравляю"},
                {"10","2012","12","Неверный месяц"},
                {"8","2012","12","Неверный месяц"},
                {"8","2013","12","Неверный месяц"},
                {"1","2012","13","Неверный месяц"},
                {"9","2013","12","Ошибка"},
                {"9","2013","12","Ошибка"},
        };
    }
    @Test(dataProvider = "data")
    public void testDenProg(String mounth,String year,String day,String alertText){
        AlertPage alertPage = new AlertPage(browser);
        Assert.assertEquals(alertPage.alert.getText(),"ВВЕДИТЕ МЕСЯЦ","Alert box is not loaded");
        alertPage.dataAlert(mounth);
        Assert.assertEquals(alertPage.alert.getText(),"введите год","Alert box is not loaded");
        alertPage.dataAlert(year);
        Assert.assertEquals(alertPage.alert.getText(),"Введите день","Alert box is not loaded");
        alertPage.dataAlert(day);
        Assert.assertEquals(alertPage.alert.getText(),alertText,"Alert box is not loaded");
    }
}
