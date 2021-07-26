package components;

import static com.codeborne.selenide.Selenide.$;
import static java.lang.String.format;

public class Calendar {
    public void setBirth(String day, String month, String year){
        $("#dateOfBirthInput").click();
        $(".react-datepicker__year-select").selectOptionContainingText(year);
        $(".react-datepicker__month-select").selectOptionContainingText(month);
        String dayLocator = format(".react-datepicker__day--0%s", day);
        $(dayLocator).click();
    }
}
