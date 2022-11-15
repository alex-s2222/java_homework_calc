package Command;
import Exception.StackCalcException;
import java.util.Map;
import java.util.Stack;

public class Pop extends Command{
    public Pop(Stack<Double> stack, Map<String,Double> var){
        super(stack, var);
    }

    public void perform() throws StackCalcException {
        if (!stack.empty()){
            System.out.println(super.stack.pop());
        }
        else throw new StackCalcException("Not enough argument");
    }
}
