package Pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.by;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class PaymentsPage {
    public ElementsCollection paymentsCategoryItem = $$(by("data-qa-file", "PaymentsCategoryItem"));
    public SelenideElement searchInput = $(by("data-qa-file", "SearchInput"));
    public ElementsCollection searchSuggest = $$(by("data-qa-file", "SuggestEntry"));
}
