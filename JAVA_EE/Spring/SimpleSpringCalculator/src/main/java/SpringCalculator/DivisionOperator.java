package SpringCalculator;

import dream.calc.ArgumentsType;
import dream.calc.InvalidInputException;
import dream.calc.Separate;
import dream.calc.model.interfaces.Task;
import org.apache.commons.math3.util.Precision;

/**
 * Division Operator
 * Created by Splayd on 22.04.2017.
 */
public class DivisionOperator implements Task {
    @Override
    public void calc() throws InvalidInputException {
        try {
            if(ArgumentsType.getArgumentsByTypeArray().size() == 0) {
                ArgumentsType.getResultArray().add(Double.valueOf(Precision.round(Double.parseDouble((String) Separate.getArgumentsArray().get(0)) / Double.parseDouble((String)Separate.getArgumentsArray().get(1)), 7)));
            } else if(ArgumentsType.getArgumentsByTypeArray().get(0) instanceof Double && ArgumentsType.getArgumentsByTypeArray().get(1) instanceof Double) {
                ArgumentsType.getResultArray().add(Double.valueOf(Precision.round(Double.parseDouble((String)Separate.getArgumentsArray().get(0)) / Double.parseDouble((String)Separate.getArgumentsArray().get(1)), 7)));
            } else if(ArgumentsType.getArgumentsByTypeArray().get(0) instanceof Float && ArgumentsType.getArgumentsByTypeArray().get(1) instanceof Float) {
                ArgumentsType.getResultArray().add(Float.valueOf(Precision.round(Float.parseFloat((String)Separate.getArgumentsArray().get(0)) / Float.parseFloat((String)Separate.getArgumentsArray().get(1)), 7)));
            } else if(ArgumentsType.getArgumentsByTypeArray().get(0) instanceof Integer && ArgumentsType.getArgumentsByTypeArray().get(1) instanceof Integer) {
                ArgumentsType.getResultArray().add(Integer.valueOf(Integer.parseInt((String)Separate.getArgumentsArray().get(0)) / Integer.parseInt((String)Separate.getArgumentsArray().get(1))));
            } else {
                if(!(ArgumentsType.getArgumentsByTypeArray().get(0) instanceof Long) || !(ArgumentsType.getArgumentsByTypeArray().get(1) instanceof Long)) {
                    throw new InvalidInputException();
                }

                ArgumentsType.getResultArray().add(Long.valueOf(Long.parseLong((String)Separate.getArgumentsArray().get(0)) / Long.parseLong((String)Separate.getArgumentsArray().get(1))));
            }

        } catch (Exception var2) {
            throw new InvalidInputException();
        }
    }
}
