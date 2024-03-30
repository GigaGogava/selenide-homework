import Utils.Runners;
import com.codeborne.selenide.*;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static selenideBasics.Constants.*;


public class SelenideTests extends Runners {


    @Test
    public void validateBundleOffers(){
        open(TELERIC_URL);
        $(byText("Pricing")).click();
        SelenideElement devCraftUI = $(DEVCRAFT_CSS);
        devCraftUI.shouldNotHave(text(MOCKING));
        devCraftUI.shouldNotHave(text(END_TO_END));
        SelenideElement Issue = $(byText(ISSUE_ESSCALATION));
        Issue.scrollTo();
        SelenideElement IssueEscalation =
                $(SUPPORT_SERVISES).$$(byText(ISSUE_ESSCALATION)).last();
        IssueEscalation.shouldHave(text("●"));



    }
@Test
    public void validateIndividualOffers(){
        open();
        open(TELERIC_URL);
        $(byText(PRICING)).click();
        $(byText(INDIVIDUAL_PRODUCTS)).click();
        SelenideElement kendoUi = $(KENDOU_UI_ID);
        kendoUi.hover();
        SelenideElement ninja = $(NINJA);
        ninja.shouldBe(visible);
        $(byText(PRIORITY_SUPPORT)).shouldBe(enabled);
        kendoUi.$(BOX_CONTENT_CLASS).$(BOX_CONTENT_CLASS1).shouldHave(text("1,149"));
        SelenideElement kendoReact = $(KENDOU_REACT);
        kendoReact.hover();
        ninja.shouldBe(visible);
        kendoReact.$(BOX_CONTENT_CLASS1).shouldHave(text("999"));

}

    @Test
    public void checkBoxTest(){
        open("http://the-internet.herokuapp.com/checkboxes");
        SelenideElement checkbox1 = $("input[type=checkbox]",0);
        checkbox1.click();
        checkbox1.shouldBe(checked);
        SelenideElement checkBox2 = $("input[type=checkbox]",1);
        checkBox2.click();
        checkBox2.shouldNotBe(checked);
        checkbox1.shouldHave(Condition.attribute("type", "checkbox"));
        checkBox2.shouldHave(Condition.attribute("type", "checkbox"));
    }
    @Test
    public void dropDownTest() {
        open(HEROKU_URL);
        SelenideElement dropDown = $(DROPDOWN);
        $(byText(SELECT_OPTION)).shouldBe(selected);
        dropDown.selectOption(OPTION_2);
        $(byText(OPTION_2)).shouldBe(selected);

    }

    @Test
    @Parameters(value="firefox")
    public void collectionsTest(){

        open(DEMOQA_URL);
        $(NAME_ID).setValue("Giga Gogava");
        $(EMAIL_ID).setValue("tryhard@gmail.com");
        $x(CURENT_ADD_XP).setValue("gldani");
        $(PERMA_ADD).setValue("gldani");
        SelenideElement submit = $(SUBMIT);
        submit.scrollTo();
        submit.click();
        $(submit).click();
        $(OUTPUT).$(NAME_ID).shouldHave(text("Giga Gogava"));
        $(OUTPUT).$(CURENT_ADD_XP).shouldHave(text("gldani"));
        $(OUTPUT).$(PERMA_ADD).shouldHave(text("gldani"));
    }

}
