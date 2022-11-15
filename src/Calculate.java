import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;

import Command.*;
import Command.Command;
import Exception.CalculatorException;
import Exception.WrongCommand;

public class Calculate {
    private final String DEFINE = "DEF";
    private final String DIV = "/";
    private final String MINUS = "-";
    private final String SUM = "+";
    private final String MULTIPLY = "*";
    private final String POP = "POP";
    private final String PUSH = "PUSH";
    private final String PRINT  = "PRINT";
    private final String SQRT = "SQRT";

    protected Stack<Double> stack = new Stack<Double>();
    protected Map<String, Double> define = new HashMap<String, Double>();
    protected String[] args;

    public void addCommand(String s) throws CalculatorException{
        args = s.split(" ");
        if(args.length==0) return;
        Command c = null;

        String type = args[0];
        switch(type){
            case DEFINE:{
                c = new Define(this.stack, this.define);
                ((Define) c).addArg(args);
                break;
            }
            case DIV:{
                c = new Div(stack,define);
                break;
            }
            case MINUS:{
                c = new Minus(stack, define);
                break;
            }
            case SUM:{
                c = new Sum(stack, define);
                break;
            }
            case MULTIPLY:{
                c =  new Mul(stack, define);
                break;
            }
            case POP:{
                c = new Pop(stack, define);
                break;
            }
            case PRINT:{
                c = new Print(stack, define);
                break;
            }
            case SQRT:{
                c = new Sqrt(stack, define);
                break;
            }
            case PUSH:{
                c = new Push(stack, define);
                ((Push) c).setPush(args[1]);
                break;
            }
        }
        if (c != null){
            c.perform();
        }else throw new WrongCommand("Wrong command");
    }

    public void addFile(String s) throws CalculatorException{
        InputStream stream = Calculate.class.getClassLoader().getResourceAsStream(s);
        Scanner in = new Scanner(stream);
        while (in.hasNextLine()){
            addCommand(in.nextLine());
        }
    }
    void clear(){
        stack.clear();
        define.clear();
    }


}
