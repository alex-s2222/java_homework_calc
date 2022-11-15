package Command;
import Exception.StackCalcException;
import java.util.Map;
import java.util.Stack;

public class Sum extends Command{
    public Sum(Stack<Double> stack, Map<String,Double> var){
        super(stack, var);
    }

    public void perform() throws StackCalcException{
        if (hasTwoNumber()){
            Double d1 = stack.pop();
            Double d2 = stack.pop();
            Double result = d1 + d2;
            stack.push(result);
        }
        else throw new StackCalcException("Not enough argument");
    }
}
