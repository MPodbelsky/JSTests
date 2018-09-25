package test;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import page.AlertPage;

public class JSTaskTestSobes extends BaseTest {
    @DataProvider
    public Object[][] validData() {
        return new Object[][]{
                {"Сколько вам лет?","69","Вы владеете английским языком?","да", "Какой уровень вашего английского?(высокий,средний,низкий)", "высокий","Есть ли у вас опыт работы в этой сфере?","да","Вы нам подходите,ваша зарплата будет составлять 400$"},
                {"Сколько вам лет?","74","Вы владеете английским языком?","да", "Какой уровень вашего английского?(высокий,средний,низкий)", "средний","Есть ли у вас опыт работы в этой сфере?","да","Вы нам подходите,ваша зарплата будет составлять 400$"},
                {"Сколько вам лет?","23","Вы владеете английским языком?","да", "Какой уровень вашего английского?(высокий,средний,низкий)", "высокий","Есть ли у вас опыт работы в этой сфере?","нет","Вы нам подходите,но ваша зарплата будет составлять 300$"},
                {"Сколько вам лет?","100","Вы владеете английским языком?","ДА", "Какой уровень вашего английского?(высокий,средний,низкий)", "высокий","Есть ли у вас опыт работы в этой сфере?","нет","Вы нам подходите,но ваша зарплата будет составлять 300$"},
                {"Сколько вам лет?","18","Вы владеете английским языком?","да", "Какой уровень вашего английского?(высокий,средний,низкий)", "ВЫСОКИЙ","Есть ли у вас опыт работы в этой сфере?","нет","Вы нам подходите,но ваша зарплата будет составлять 300$"},
                {"Сколько вам лет?","22","Вы владеете английским языком?","да", "Какой уровень вашего английского?(высокий,средний,низкий)", "высокий","Есть ли у вас опыт работы в этой сфере?","НЕТ","Вы нам подходите,но ваша зарплата будет составлять 300$"},
                {"Сколько вам лет?","95","Вы владеете английским языком?","да", "Какой уровень вашего английского?(высокий,средний,низкий)", "средний","Есть ли у вас опыт работы в этой сфере?","нет","Вы нам подходите,но ваша зарплата будет составлять 300$"},
                {"Сколько вам лет?","18","Вы владеете английским языком?","да", "Какой уровень вашего английского?(высокий,средний,низкий)", "низкий","Есть ли у вас опыт работы в этой сфере?","да","Вы нам подходите,ваша зарплата будет составлять 250$"},
                {"Сколько вам лет?","17","Вы владеете английским языком?","да", "Какой уровень вашего английского?(высокий,средний,низкий)", "","","","Извините но вы не подходите"},
                {"Сколько вам лет?","20","Вы владеете английским языком?","нет", "Какой уровень вашего английского?(высокий,средний,низкий)", "","","","Извините но вы не подходите"},
                {"Сколько вам лет?","10","Вы владеете английским языком?","нет", "Какой уровень вашего английского?(высокий,средний,низкий)", "","","","Извините но вы не подходите"},
                {"Сколько вам лет?","вапролчсм","Вы владеете английским языком?","да", "Какой уровень вашего английского?(высокий,средний,низкий)", "","","","Извините но вы не подходите"},
                {"Сколько вам лет?","18","Вы владеете английским языком?","да", "Какой уровень вашего английского?(высокий,средний,низкий)", "низкий","Есть ли у вас опыт работы в этой сфере?","нет","Извините,но мы вас не можем взять"},

        };
    }
    @Test (dataProvider = "validData")
    public void positiveJSTest(String eageAlertText, String eageParam, String engAlertText, String isEng,
                               String urovenEngAlertText, String urovenEngParam, String alertOputGetText,
                               String oputParam,String alertZpText) {
        AlertPage sobesPage = new AlertPage(browser);
        Assert.assertEquals(sobesPage.alert.getText(), eageAlertText,"Alert box is not loaded");
        sobesPage.dataAlert(eageParam);
        Assert.assertEquals(sobesPage.alert.getText(), engAlertText,"Alert box is not loaded");
        sobesPage.dataAlert(isEng);
        if (sobesPage.alert.getText().contains(urovenEngAlertText)){
        Assert.assertEquals(sobesPage.alert.getText(), urovenEngAlertText,"Alert box is not loaded");
        sobesPage.dataAlert(urovenEngParam);
        Assert.assertEquals(sobesPage.alert.getText(), alertOputGetText,"Alert box is not loaded");
        sobesPage.dataAlert(oputParam);}
        Assert.assertEquals(sobesPage.alert.getText(), alertZpText,"Alert box is not loaded");
    }
}