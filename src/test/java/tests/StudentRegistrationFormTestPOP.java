package tests;


import com.codeborne.selenide.Configuration;
import com.github.javafaker.Faker;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import pages.RegistrationPage;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static data.TestData.*;

public class StudentRegistrationFormTestPOP {

    RegistrationPage registrationPage = new RegistrationPage();

    Faker faker = new Faker();
    String firstName = faker.name().firstName();
    String lastName = faker.name().lastName();
    String email = faker.internet().emailAddress();
    @BeforeAll
    static void setup() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.startMaximized = true;
    }

    @Test
    void positiveTest() {
        registrationPage.openPage();

        registrationPage.typeFirstName(firstName)
                .typeLastName(lastName)
                .typeEmail(email)
                .selectGender(gender)
                .typePhone(phoneNumber)
                .setDate("27", "March", "1998")
                .setSubject(subject)
                .setHobbi(hobbi)
                .uploadPict(dirPicture)
                .setAdress("Russia", "NCR", "Noida")
                .clickSubmit();

        //Assertions
        registrationPage.checkResultTitle()
                .checkResultValue(firstName + " " + lastName)
                .checkResultValue(email)
                .checkResultValue(gender)
                .checkResultValue(phoneNumber)
                .checkResultValue("27 March,1998")
                .checkResultValue(subject)
                .checkResultValue(hobbi)
                .checkResultValue("road.jpg")
                .checkResultValue("Russia")
                .checkResultValue("NCR Noida");
    }

}
