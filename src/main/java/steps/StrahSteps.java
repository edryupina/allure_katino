package steps;
import pages.TravelPage;
import ru.yandex.qatools.allure.annotations.Step;
import static org.junit.Assert.assertEquals;

public class StrahSteps extends BaseSteps {
    @Step("Выполнена проверка наличия на странице заголовка - Страхование путешественников")
    public void stepCheckTitle(String expectedTitle) {
        String actualTitle = new TravelPage(driver).title.getText();
        //String actualTitle = new TravelInsurancePage(driver).title.getText();
        assertEquals(String.format("Заголовок равен [%s]. Ожидалось - [%s]", actualTitle, expectedTitle), expectedTitle, actualTitle);
    }
    @Step("Выполнено нажатие на кнопку - Оформить Онлайн")
    public void stepSendButton() {
        new TravelPage(driver).sendButton.click();
    }
}
