package DateOperations;

import java.time.LocalDate;

public class AdditionDate {

    public String getOperator() {
        return "+";
    }

    public void getResult(LocalDate firstDate, LocalDate secondDate) {
        LocalDate result = firstDate.plusYears(secondDate.getYear()).
                plusMonths(secondDate.getMonthValue()).plusDays(secondDate.getDayOfMonth());
        System.out.println(result);
    }
}
