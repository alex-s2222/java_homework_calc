import Command.*;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;
import Exception.*;


public class Lab_6_Main {
    public static void main(String[] arg){
        Calculate calculate = new Calculate();
        Scanner in = new Scanner(System.in);

        while(true){
            String s = in.nextLine();
            if (s.equalsIgnoreCase("EXIT")) break;
            try{
                if (getFile(s)){
                    calculate.addFile(s);
                }else {
                    calculate.addCommand(s);
                    if (s.startsWith("PRINT")){
                        calculate.clear();
                    }
                }
            }catch (NoDefinitionExcetpion | StackCalcException | WrongArguments noDefinitionExcetpions){
                System.out.println(noDefinitionExcetpions.getMessage());
            }catch (CalculatorException c){
                c.printStackTrace();
            }
        }
    }
    static boolean getFile(String name){
        try {
            Path path = Paths.get("D:\\Idea Projects\\calc\\src\\main\\resources\\" + name);
            return Files.exists(path);

        } catch (Exception e) {
            return false;
        }

    }

}
