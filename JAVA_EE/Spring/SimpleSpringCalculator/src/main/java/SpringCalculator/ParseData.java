package SpringCalculator;

import dream.calc.ArgumentsType;
import dream.calc.InvalidInputException;
import dream.calc.Separate;
import dream.calc.model.interfaces.ParseType;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

/**
 * Parse Date
 * Created by Splayd on 19.04.2017.
 */
public class ParseData implements ParseType{
    @Override
    public void parse() throws InvalidInputException {
        try {
            DateFormat df = new SimpleDateFormat("dd.MM.yyyy");
            ArgumentsType.getArgumentsByTypeArray().add(df.parse(Separate.getArgumentsArray().get(0)));
            ArgumentsType.getArgumentsByTypeArray().add(df.parse(Separate.getArgumentsArray().get(1)));
        } catch (Exception var2) {
            throw new InvalidInputException();
        }
    }
}
