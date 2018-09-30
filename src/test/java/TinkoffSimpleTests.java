import Enums.ErrorsEnum;
import Pages.KommunalkaPage;
import Pages.MainPage;
import Pages.PaymentsPage;
import Pages.ZhkuMskPage;
import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.*;


public class TinkoffSimpleTests {

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:/Users/Home/Desktop/chromedriver.exe");
        Configuration.browser = "chrome";
        Configuration.baseUrl = "https://www.tinkoff.ru";

    }

    @Test
    public void TestViewMskCompanyInSpbRegion() {
        final String payment = "Платежи";
        final String JKH = "ЖКХ";
        final String firmName = "ЖКУ-Москва";
        final String payJKH = "Оплатить ЖКУ в Москве ";
        final String selectRegion = "Выбор региона";
        final String learnToDebet = "Узнайте задолженность по ЖКУ в Москве";
        final String payWithoutTax = "Оплатите ЖКУ в Москве без комиссии";
        MainPage mainPage = open("/", MainPage.class);
        mainPage.checkMainPageOpened();
        mainPage.telephone.scrollTo();
        mainPage.footer.find(By.linkText(payment)).click();
        PaymentsPage paymentsPage = new PaymentsPage();
        paymentsPage.paymentsCategoryItem.filterBy(Condition.text(JKH)).first().should(Condition.visible);
        paymentsPage.paymentsCategoryItem.filterBy(Condition.text(JKH)).first().click();
        KommunalkaPage kommunalkaPage = new KommunalkaPage();
        kommunalkaPage.header.should(Condition.visible);
        if (!kommunalkaPage.header.getText().equals("в Москве")) {
            kommunalkaPage.header.click();
            kommunalkaPage.selectRegionText.should(Condition.visible);
            kommunalkaPage.selectRegionText.should(Condition.text(selectRegion));
            kommunalkaPage.selectRegionTable.find(By.partialLinkText("Москва")).click();
        }
        kommunalkaPage.header.should(Condition.visible);
        kommunalkaPage.companyMenu.find(Condition.text(firmName)).should(Condition.visible);
        String expectedText = kommunalkaPage.companyMenu.find(Condition.text(firmName)).getText();
        kommunalkaPage.companyMenu.find(Condition.text(firmName)).click();
        ZhkuMskPage zhkuMskPage = new ZhkuMskPage();
        zhkuMskPage.titleText.should(Condition.visible);
        zhkuMskPage.titleText.should(Condition.text(learnToDebet));
        zhkuMskPage.paymentTab.find(Condition.text(payJKH)).should(Condition.visible);
        zhkuMskPage.paymentTab.find(Condition.text(payJKH)).click();
        zhkuMskPage.titleText.shouldHave(Condition.text(payWithoutTax));

        zhkuMskPage.inputPayer.setValue("3333");
        zhkuMskPage.titleText.click();
        zhkuMskPage.error.shouldHave(Condition.text(ErrorsEnum.INVALID_FIELD.toString()));
        zhkuMskPage.inputPayer.setValue("4444444444");
        zhkuMskPage.inputPeriod.setValue("00222");
        zhkuMskPage.titleText.click();
        zhkuMskPage.error.shouldHave(Condition.text(ErrorsEnum.NOT_CORRECT_FIELD.toString()));
        zhkuMskPage.inputPeriod.setValue("06.2013");
        zhkuMskPage.inputInsurance.setValue("-19");
        zhkuMskPage.titleText.click();
        zhkuMskPage.error.shouldHave(Condition.text(ErrorsEnum.WRONG_FIELD.toString()));
        zhkuMskPage.inputInsurance.setValue("100");
        zhkuMskPage.inputSum.waitWhile(Condition.visible, 30L);
        zhkuMskPage.inputSum.doubleClick().sendKeys("4");// Пожалуйста сделайте клик в область инпута, по этому поводу есть issue https://github.com/codeborne/selenide/issues/201
        zhkuMskPage.titleText.click();
        zhkuMskPage.error.shouldHave(Condition.text(ErrorsEnum.AMOUNT_WRONG_FIELD.toString()));
        zhkuMskPage.inputInsurance.setValue("2");
        zhkuMskPage.titleText.click();
        zhkuMskPage.error.shouldHave(Condition.text(ErrorsEnum.MIN_FIELD.toString()));
        zhkuMskPage.inputInsurance.setValue("2");
        zhkuMskPage.inputSum.pressEnter().setValue("20000");
        zhkuMskPage.titleText.click();
        zhkuMskPage.error.shouldHave(Condition.text(ErrorsEnum.MAX_FIELD.toString()));
        zhkuMskPage.inputSum.pressEnter().setValue("10");
        zhkuMskPage.titleText.click();


        mainPage.footer.find(By.linkText(payment)).click();
        paymentsPage.searchInput.setValue(expectedText);
        paymentsPage.searchSuggest.filterBy(Condition.text(expectedText)).first().click();

        zhkuMskPage.titleText.should(Condition.visible);
        zhkuMskPage.titleText.should(Condition.text(learnToDebet));
        zhkuMskPage.paymentTab.find(Condition.text(payJKH)).should(Condition.visible);
        zhkuMskPage.paymentTab.find(Condition.text(payJKH)).click();
        zhkuMskPage.titleText.shouldHave(Condition.text(payWithoutTax));

        mainPage.footer.find(By.linkText(payment)).click();


        paymentsPage.paymentsCategoryItem.filterBy(Condition.text(JKH)).first().should(Condition.visible);
        paymentsPage.paymentsCategoryItem.filterBy(Condition.text(JKH)).first().click();

        kommunalkaPage.header.should(Condition.visible);

        kommunalkaPage.header.click();
        kommunalkaPage.selectRegionText.should(Condition.visible);
        kommunalkaPage.selectRegionText.should(Condition.text(selectRegion));
        kommunalkaPage.selectRegionTable.find(By.partialLinkText("Санкт-Петербург")).click();

        paymentsPage.searchInput.setValue(expectedText);
        paymentsPage.searchSuggest.filterBy(Condition.text(expectedText)).first().shouldNot(Condition.visible);
        kommunalkaPage.companyMenu.find(Condition.text(expectedText)).shouldNot(Condition.visible);


    }
}
