package DateOperations;

import java.time.LocalDate;
import java.time.Period;

public class SubtractionDate {

    public String getOperator() {
        return "-";
    }

    public void getResult(LocalDate firstDate, LocalDate secondDate) {
        Period period = Period.between(secondDate, firstDate);
        System.out.println(period.getYears() + "." + period.getMonths() + "." + period.getDays());
    }
}
