package DateOperations;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class DateParserAndCalculate {

    //Hardcode because only two operators. Not needed interface.
    private String plus = new AdditionDate().getOperator();
    private String minus = new SubtractionDate().getOperator();
    private String OPERATORS = plus + minus;
    private DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("yyyy.MM.dd");
    private ArrayList<LocalDate> dateList = new ArrayList<>();
    private String sign;


    public void parseDate(String expression) {

        StringTokenizer stringTokenizer = new StringTokenizer(expression, OPERATORS, true);
        if (stringTokenizer.countTokens() == 3) {
            while (stringTokenizer.hasMoreTokens()) {
                String token = stringTokenizer.nextToken();
                try {
                    dateList.add(LocalDate.parse(token, dateFormat));

                } catch (DateTimeParseException e) {
                    if (OPERATORS.contains(token)) {  //The priority of operations is equal
                        sign = token;
                    }
                }
            }
        } else {
            System.out.println("Wrong input!");
        }
    }

    public void calculateDate() {
        if (sign.equals(plus)) {
            AdditionDate additionDate = new AdditionDate();
            additionDate.getResult(dateList.get(0), dateList.get(1));
        } else if (sign.equals(minus)) {
            SubtractionDate subtractionDate = new SubtractionDate();
            subtractionDate.getResult(dateList.get(0), dateList.get(1));
        }
    }
}
