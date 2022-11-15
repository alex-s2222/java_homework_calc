package Command;

import org.junit.jupiter.api.Test;
import Command.Define;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import Exception.CalculatorException;

import static org.junit.jupiter.api.Assertions.*;

class DefineTest {
    protected Stack<Double> stack = new Stack<Double>();
    protected Map<String, Double> vars = new HashMap<String, Double>();
    @Test
    void ExecuteOk() throws CalculatorException {

        final String[] args ={"DEF", "fefef", "3.0"};
        double value = Double.parseDouble(args[2]);

        var context = new Define(stack, vars);
        context.addArg(args);
        context.perform();

        assertTrue(context.vars.containsKey(args[1]));
        assertEquals(context.vars.get(args[1]), value);
    }

}