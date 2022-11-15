package Command;
import Exception.StackCalcException;
import java.util.Map;
import java.util.Stack;

public class Print extends Command{
    public Print(Stack<Double> stack, Map<String,Double> var){
        super(stack, var);
    }

    public void perform() throws StackCalcException {
        //find out the difference between
        if (!stack.empty()){
            System.out.println(stack.peek());
        }
        else throw new StackCalcException("Not enough argument");
    }
}
