package steps;
import pages.Choose2Page;
import ru.yandex.qatools.allure.annotations.Step;

import static steps.BaseSteps.driver;

public class SummaSteps {
    @Step("Выбрана максимальная сумма")
    public void stepChooseSumma() {
        new Choose2Page(driver).summa.click();
    }
    @Step("Нажата кнопка - Оформить")
    public void stepClickButton() {
        new Choose2Page(driver).Button.click();
    }
}
