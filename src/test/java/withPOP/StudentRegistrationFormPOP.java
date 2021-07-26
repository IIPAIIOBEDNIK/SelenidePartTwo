package withPOP;


import com.codeborne.selenide.Configuration;
import components.Calendar;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import pages.RegistrationPage;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class StudentRegistrationFormPOP {

    RegistrationPage registrationPage = new RegistrationPage();

    @BeforeAll
    static void setup() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.startMaximized = true;
    }

    @Test
    void PositiveTest() {
        registrationPage.openPage();

        registrationPage.typeFirstName("Alex")
                .typeLastName("Pereponov")
                .typeEmail("pereponov_alexander@mail.ru")
                .SelectGender("Male")
                .typePhone("9169163660")
                .setDate("27", "March", "1998")
                .setSubject("Maths")
                .setHobbi("Music")
                .uploadPict("src/test/resources/road.jpg")
                .setAdress("Russia", "NCR", "Noida")
                .clickSubmit();

        //Assertions
        registrationPage.checkResultTitle()
                .checkResultValue("Alex Pereponov")
                .checkResultValue("pereponov_alexander@mail.ru")
                .checkResultValue("Male")
                .checkResultValue("9169163660")
                .checkResultValue("27 March,1998")
                .checkResultValue("Maths")
                .checkResultValue("Music")
                .checkResultValue("road.jpg")
                .checkResultValue("Russia")
                .checkResultValue("NCR Noida");
    }

}
