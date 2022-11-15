package Command;

import java.util.Map;
import java.util.Stack;
import Exception.StackCalcException;
import Exception.NoDefinitionExcetpion;

public class Push extends Command{
    String var;

    public Push(Stack<Double> stack, Map<String, Double> var){
        super(stack, var);
    }

    public void setPush(String s){
        this.var = s;
    }

    public void perform() throws NoDefinitionExcetpion {
        Double d = null;

        if (vars.containsKey(var)){
            d = super.vars.get(var);
        } else {
            d = Double.valueOf(var);
        }

        if(d == null){
            throw new NoDefinitionExcetpion("No such variable in DEFINITIONS " + this.var);
        }
        stack.push(d);
    }
}
