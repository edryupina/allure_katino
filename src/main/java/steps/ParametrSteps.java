package steps;
import org.openqa.selenium.WebElement;
import pages.ParametrPage;
import ru.yandex.qatools.allure.annotations.Step;
import java.util.HashMap;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ParametrSteps extends BaseSteps {
    @Step("Поле {0} заполняется значением {1}")
    public void stepFillField(String fieldName, String value) {
                new ParametrPage(driver).filledData(fieldName, value);
    }

    @Step("Заполняются поля:")
    public void stepFillFields(HashMap<String, String> fields) {
        fields.forEach(this::stepFillField);
    }

    @Step("поле {0} заполнено значением {1}")
    public void stepCheckFillField(String field, String value) {

        String actual = new ParametrPage(driver).getCheckField(field);
        assertTrue(String.format("Значение поля [%s] равно [%s]. Ожидалось - [%s]", field, actual, value),
                actual.equals(value));
    }

    @Step("Поля заполнены верно:")
    public void checkFillFields(HashMap<String, String> fields) {
        fields.forEach((k, v) -> stepCheckFillField(k, v));
    }

    @Step("Поле заполнено верно")
    public void stepCheckMale(WebElement female){
        new ParametrPage(driver).female.click();
        assertTrue("Неверно заполнено поле", female.isSelected());
    }

    @Step("Выполнено нажатие на кнопку - Продолжить")
    public void stepClickButtonNextReg() {
        new ParametrPage(driver).nextReg.click();
    }

    @Step("Выполнена проверка наличия ошибки на странице")
    public void stepCheckMassegeError(String expecteErrorMassage) {
        String actualErrorMassage = new ParametrPage(driver).errorMassage.getText();
        assertEquals(String.format("Заголовок равен [%s]. Ожидалось - [%s]", actualErrorMassage, expecteErrorMassage), expecteErrorMassage, actualErrorMassage);
    }
}
