
package HomeWork;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Process {

    public static void main(String[] args) {
        try{
            System.out.println("Калькулятор подсчета: Допускаются числа от 1 до 10 или от I до X включительно. Операции: + - * /");
            System.out.print("Введите первое чило, действие, введите второе число (не забываете пробел):  ");
            BufferedReader bReader = new BufferedReader(new InputStreamReader(System.in));
            String calcString = bReader.readLine();
            
            Calc calc = new Calc();
            String result = calc.result(calcString);
            System.out.println("Результат:" + result);
        } 
        catch(CalcValid | IOException e){
            
        }

    }
    
}
