package Command;
import Exception.StackCalcException;
import java.util.Map;
import java.util.Stack;

public class Sqrt extends Command{
    public Sqrt(Stack<Double> stack, Map<String,Double> var){
        super(stack, var);
    }

    public void perform() throws StackCalcException {
        if (!stack.empty()){
            Double d1 = stack.pop();
            Double result = Math.sqrt(d1);
            stack.push(result);
        }
        else throw new StackCalcException("Not enough argument");
    }
}
