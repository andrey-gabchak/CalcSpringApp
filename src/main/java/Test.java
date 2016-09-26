import java.time.LocalDate;
import java.time.Month;

public class Test {

    public static void main(String[] args) {

        Test test = new Test();
        test.exampeSubtractionLocalDate();

    }

    public void exampeSubtractionLocalDate() {
        String expression = "1990-09-26";
        LocalDate inputDate = LocalDate.parse(expression);
        LocalDate moreThen = LocalDate.of(1990, Month.SEPTEMBER, 27);
        moreThen = moreThen.minusYears(inputDate.getYear()).minusMonths(inputDate.getMonthValue()).minusDays(inputDate.getDayOfMonth());
        System.out.println(moreThen);
        // Output must be "0000-00-01", but really it's "-0001-12-01"
        // It isn't correct output, but it's the mistake of LocalDate class
    }

}
