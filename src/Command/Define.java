package Command;
import Exception.StackCalcException;
import Exception.CalculatorException;
import Exception.WrongCommand;
import Exception.WrongArguments;
import java.util.Map;
import java.util.Stack;



public class Define extends Command {
    String var;
    Double value = null;

    public Define(Stack<Double> stack, Map<String, Double> var){
         super(stack,var);
    }

    public void addArg(String[] args) throws CalculatorException{
        if (args.length < 3) throw new WrongCommand("Wrong command");
        this.var = args[1];
        try{
            this.value = Double.valueOf(args[2]);
        }catch (NumberFormatException n){
            throw new WrongArguments("Wrong Type for variable" + this.var);
        }
    }

    public void perform(){
        vars.put(var, value);
    }
}
