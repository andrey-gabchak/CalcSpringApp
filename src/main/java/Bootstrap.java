import Operations.AllOperations;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Scanner;

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

        Scanner scanner = new Scanner(System.in);
        String inputExpression = scanner.next();

        Arithmetic arithmetic = new Arithmetic();

        double result = arithmetic.calculation(inputExpression);
        System.out.println(result);


    }
}
