package Pages;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.*;
import ru.yandex.qatools.allure.annotations.Description;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;


public class ZhkuMskPage {
    public SelenideElement titleText = $(by("data-qa-file","PageTitleContainer"));
    public ElementsCollection paymentTab = $$(by("data-qa-file","Tabs"));
    public SelenideElement inputPayer = $(byId("payerCode"));
    public SelenideElement inputPeriod= $(byId("period"));
    public SelenideElement inputSum = $(byCssSelector("body > div.application > div > div > div.PlatformLayout__layoutPage_WoIKN > div.PortalContainer__container_lyBzt > div.UILayoutPage__page_19-Kp > div:nth-child(1) > div.PlatformLayout__layoutPageComponent_3W4dc > div > div:nth-child(2) > div:nth-child(1) > div > div > div > div.Grid__root_1nlgc.Grid__root_display_block_lwIvG > div.Grid__column_3qcJA.Grid__column_size_8_13Rlm > form > div:nth-child(4) > div > div > div > div > div > div > div > div > label > div > input"));
    public SelenideElement inputInsurance = $(byCssSelector("body > div.application > div > div > div.PlatformLayout__layoutPage_WoIKN > div.PortalContainer__container_lyBzt > div.UILayoutPage__page_19-Kp > div:nth-child(1) > div.PlatformLayout__layoutPageComponent_3W4dc > div > div:nth-child(2) > div:nth-child(1) > div > div > div > div.Grid__root_1nlgc.Grid__root_display_block_lwIvG > div.Grid__column_3qcJA.Grid__column_size_8_13Rlm > form > div.ui-form__row.ui-form__row_amount > div > div > label > div > input"));
    public SelenideElement error = $(by("data-qa-file","UIFormRowError"));



}
