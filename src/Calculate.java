import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;
import java.util.logging.*;

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

    static Logger LOGGER = Logger.getLogger("Mylog");
    static FileHandler fh;
    static {
        try{
            fh = new FileHandler("C:/Users/Admin/Desktop/study/3.1/java/Lab6/log.config");
            LOGGER.addHandler(fh);
            SimpleFormatter formatter = new SimpleFormatter();
            fh.setFormatter(formatter);
        }catch (Exception ignore){
            ignore.printStackTrace();
        }
    }


    public void addCommand(String s) throws CalculatorException{
        LOGGER.log(Level.INFO,"void func addCommand");
        args = s.split(" ");
        if(args.length==0) return;
        Command c = null;

        String type = args[0];
        LOGGER.log(Level.INFO, "void switch operator");
        switch(type){
            case DEFINE:{
                LOGGER.log(Level.WARNING, "Switch choice DEFINE");
                c = new Define(this.stack, this.define);
                ((Define) c).addArg(args);
                LOGGER.log(Level.WARNING, "DEFINE Good completed");
                break;
            }
            case DIV:{
                LOGGER.log(Level.WARNING, "Switch choice DIV");
                c = new Div(stack,define);
                LOGGER.log(Level.WARNING,"DIV Good completed");
                break;
            }
            case MINUS:{
                LOGGER.log(Level.WARNING, "Switch choice MINUS ");
                c = new Minus(stack, define);
                LOGGER.log(Level.WARNING, "Minus good completed");
                break;
            }
            case SUM:{
                LOGGER.log(Level.WARNING, "Switch choice SUM");
                c = new Sum(stack, define);
                LOGGER.log(Level.WARNING, "Sum good completed");
                break;
            }
            case MULTIPLY:{
                LOGGER.log(Level.WARNING,"Switch choice MUL");
                c =  new Mul(stack, define);
                LOGGER.log(Level.WARNING, "Mul good completed");
                break;
            }
            case POP:{
                LOGGER.log(Level.WARNING, "Switch choice POP");
                c = new Pop(stack, define);
                LOGGER.log(Level.WARNING, "Pop good completed");
                break;
            }
            case PRINT:{
                LOGGER.log(Level.WARNING, "Switch choice PRINT");
                c = new Print(stack, define);
                LOGGER.log(Level.WARNING, "Print good completed");
                break;
            }
            case SQRT:{
                LOGGER.log(Level.WARNING,"Switch choice SQRT");
                c = new Sqrt(stack, define);
                LOGGER.log(Level.WARNING,"Sqrt good completed");
                break;
            }
            case PUSH:{
                LOGGER.log(Level.WARNING, "Swith choice PUSH");
                c = new Push(stack, define);
                ((Push) c).setPush(args[1]);
                LOGGER.log(Level.WARNING,"Push good completed");
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
