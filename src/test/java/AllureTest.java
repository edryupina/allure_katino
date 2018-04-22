import org.junit.Test;
import org.openqa.selenium.By;
import ru.yandex.qatools.allure.annotations.Title;
import steps.BaseSteps;
import steps.MainSteps;
import steps.StrahSteps;
import steps.SummaSteps;
import steps.ParametrSteps;

import java.util.HashMap;

public class AllureTest extends BaseSteps {
    MainSteps mainSteps = new MainSteps();
    HashMap<String, String> testData = new HashMap<>();
    @Test
    @Title("Оформление страхования")
    public void Test(){
        MainSteps mainSteps = new MainSteps();
        StrahSteps strahSteps =new StrahSteps();
        SummaSteps summaSteps = new SummaSteps();
        ParametrSteps parametrSteps = new ParametrSteps();
        HashMap<String, String> testData = new HashMap<>();

        testData.put("Фамилия застрахованного", "Dryupina");
        testData.put("Имя застрахованного", "Ekaterina");
        testData.put("Дата рождения застрахованного", "23.03.1985");
        testData.put("Фамилия страхователя", "Фадеева");
        testData.put("Имя страхователя", "Екатерина");
        testData.put("Отчество страхователя", "Игоревна");
        testData.put("Дата рождения страхователя", "23.03.1995");
        testData.put("Пол страхователя","");
        testData.put("Серия паспорта", "3609");
        testData.put("Номер паспорта", "123456");
        testData.put("Дата выдачи паспорта", "01.12.2017");
        testData.put("Кем выдан", "ОФМС России по МО");

        mainSteps.stepSelectMainMenu("Застраховать");
        mainSteps.setSelectSubMenu();

        strahSteps.stepCheckTitle("Страхование путешественников");
        strahSteps.stepSendButton();

        for (String winHandle : driver.getWindowHandles()) {
            driver.switchTo().window(winHandle);
        }

        summaSteps.stepChooseSumma();
        summaSteps.stepClickButton();

        parametrSteps.stepFillFields(testData);
    //    testData.put("Дата выдачи паспорта", "12.05.2010");
        parametrSteps.checkFillFields(testData);
        parametrSteps.stepClickButtonNextReg();
        parametrSteps.stepCheckMassegeError("Заполнены не все обязательные поля");
    }
}
