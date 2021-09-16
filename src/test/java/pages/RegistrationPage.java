package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import components.Calendar;

import java.io.File;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class RegistrationPage {

    private final static String RESULT_TITLE = "Thanks for submitting the form";

    private SelenideElement modal = $("[role = dialog]");

    private Calendar calendar = new Calendar();

    public void openPage(){
        open("/automation-practice-form");
    }

    public RegistrationPage typeFirstName(String firstName){
        $("#firstName").setValue(firstName);

        return this;
    }

    public RegistrationPage typeLastName(String lastName){
        $("#lastName").setValue(lastName);

        return this;
    }

    public RegistrationPage typeEmail(String email){
        $("#userEmail").setValue(email);

        return this;
    }

    public RegistrationPage selectGender(String gender){
        $("#genterWrapper").$(byText(gender)).click();

        return this;
    }

    public RegistrationPage typePhone(String phone){
        $("#userNumber").setValue(phone);

        return this;
    }

    public RegistrationPage setDate(String day, String month, String year){
        calendar.setBirth(day, month, year);
        return this;
    }

    public RegistrationPage setSubject(String subject) {
        $("#subjectsInput").setValue(subject).pressEnter();

        return this;
    }

    public RegistrationPage setHobbi(String hobbi) {
        $("#hobbiesWrapper").$(byText(hobbi)).click();

        return this;
    }


    public RegistrationPage uploadPict(String direct){
        $("#uploadPicture").uploadFile(new File(direct));

        return this;
    }

    public RegistrationPage setAdress(String country, String state, String city){
        $("#currentAddress").setValue(country);
        $("#react-select-3-input").setValue(state).pressEnter();
        $("#react-select-4-input").setValue(city).pressEnter();

        return this;
    }

    public void clickSubmit(){
        $("#submit").scrollTo().click();
    }

    public RegistrationPage checkResultTitle(){
        modal.$(".modal-title").shouldHave(text(RESULT_TITLE));

        return this;
    }

    public RegistrationPage checkResultValue(String value){
        modal.$(".table-responsive").shouldHave(text(value));

        return this;
    }
}
