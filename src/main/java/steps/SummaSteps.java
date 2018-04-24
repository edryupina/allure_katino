package steps;
import pages.ChoosePage;
import ru.yandex.qatools.allure.annotations.Step;

import static steps.BaseSteps.driver;

public class SummaSteps {
    @Step("Выбрана максимальная сумма")
    public void stepChooseSumma() {
        new ChoosePage(driver).summa.click();
    }
    @Step("Нажата кнопка - Оформить")
    public void stepClickButton() {
        new ChoosePage(driver).Button.click();
    }
}
