package Command;
import Exception.NoDefinitionExcetpion;
import Exception.StackCalcException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public abstract class Command {
    public Stack <Double> stack = new Stack<>();
    public Map<String, Double> vars = new HashMap<>();


    public Command(Stack<Double> stack, Map<String, Double> vars){
        this.stack = stack;
        this.vars = vars;
    }

    public abstract void perform() throws NoDefinitionExcetpion, StackCalcException;

    protected boolean hasTwoNumber(){
        return stack.size() > 1;
    }

}
