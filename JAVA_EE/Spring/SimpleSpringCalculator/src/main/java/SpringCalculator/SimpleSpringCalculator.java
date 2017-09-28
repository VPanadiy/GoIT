package SpringCalculator;

import dream.calc.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

/**
 * Created by Splayd on 04.03.2017.
 * Test Library
 */
public class SimpleSpringCalculator {

    public static final Logger LOGGER = LoggerFactory.getLogger(SimpleSpringCalculator.class);

    public static void main(String[] args) throws IOException, InvalidInputException {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("application-context.xml");
        SimpleSpringCalculator simpleSpringCalculator = applicationContext.getBean(SimpleSpringCalculator.class);
        simpleSpringCalculator.start();
    }

    private void start() throws InvalidInputException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Operators.getOperatorsMap().put("/", new DivisionOperator());
        Operators.getOperatorsMap().put("*", new MultiplyOperator());
        ArgumentsType.getMapOfTypes().put("Date", new ParseData());

        System.out.println(Calc.bootCalc(reader.readLine()));
        cleanUp();

        Separate.getArgumentsArray().add("11.05.2017");
        Separate.getArgumentsArray().add("10.05.2017");
        ParseData parseData = new ParseData();
        parseData.parse();
        System.out.println(ArgumentsType.getArgumentsByTypeArray().toString());
    }

    public static void cleanUp() {
        Separate.setArgumentsArray(new ArrayList<>());
        Separate.setOperatorsArray(new ArrayList<>());
        ArgumentsType.setArgumentsByTypeArray(new ArrayList<>());
        ArgumentsType.setResultArray(new ArrayList<>());
    }
}
