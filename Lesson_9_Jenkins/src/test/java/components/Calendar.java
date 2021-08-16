package components;


import static com.codeborne.selenide.Selenide.$;
import static java.lang.String.format;

    public class Calendar {
        public void setDate(String day, String month, String year){
            $(".react-datepicker-wrapper").click();
            $(".react-datepicker__year-select").selectOption(year);
            $(".react-datepicker__month-select").selectOption(month);
            String dayLocator = format(".react-datepicker__day--0%s", day);
            $(".react-datepicker__day--019").click();
        }
    }

