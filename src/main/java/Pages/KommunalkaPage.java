package Pages;

import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.*;
import ru.yandex.qatools.allure.annotations.Description;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;


public class KommunalkaPage {
    public SelenideElement header = $(byClassName("PaymentsCatalogHeader__regionSelect_1Muyd"));
    public ElementsCollection companyMenu = $$(by("data-qa-file", "UIMenuItemProvider"));
    public SelenideElement selectRegionText = $(by("data-qa-file", "UIRegions"));
    public SelenideElement selectRegionTable = $(byClassName("UiRegions__uiRegions__layout_2wFF-"));
}
