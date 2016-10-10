import DateOperations.DateParserAndCalculate;
import Operations.AllOperations;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Scanner;
import java.util.Stack;

public class Bootstrap {

    public static void main(String[] args) {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("application-context.xml");
        Bootstrap bootstrap = applicationContext.getBean("bootstrap", Bootstrap.class);
        bootstrap.execute();
    }

    private void execute() {
        AllOperations allOperations = AllOperations.getAllOperations();
        allOperations.addBinaryOperation(new Division());
        allOperations.addBinaryOperation(new Multiplication());

        System.out.println("Choose what needs calculate.\nFor Date enter 1\nFor equation enter 2");
        Scanner scanner = new Scanner(System.in);
        String choice = scanner.next();

        String inputExpression;
        if (choice.equals("1")) {
            System.out.println("The date format is 2016.09.15-2016.09.14");
            inputExpression = scanner.next();
            DateParserAndCalculate dateParser = new DateParserAndCalculate();
            dateParser.parseDate(inputExpression);
            dateParser.calculateDate();
        } else if (choice.equals("2")) {
            System.out.println("The equation format is 1+2^4*(3+3^3)/3");
            inputExpression = scanner.next();
            Parser parser = new Parser();
            Stack<String> stackPRN = parser.parsing(inputExpression);

            Arithmetic arithmetic = new Arithmetic();
            double result = arithmetic.calculation(stackPRN);

            System.out.println(result);
        }
    }
}
