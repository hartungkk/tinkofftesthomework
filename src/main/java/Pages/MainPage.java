package Pages;

import com.codeborne.selenide.*;
import ru.yandex.qatools.allure.annotations.Description;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;


public class MainPage {
    public SelenideElement footer = $(byClassName("footer__Footer__navFullItem_20o5I"));
    public SelenideElement desktopBanner = $(by("data-qa-file", "DesktopBannerSlider"));
    public SelenideElement header = $(by("data-qa-file", "FirstMenu"));
    public SelenideElement telephone = $(by("data-qa-file", "FooterMobile"));

    public void checkMainPageOpened() {
        desktopBanner.should(Condition.visible);
        header.should(Condition.visible);
        telephone.should(Condition.visible);
    }

}
