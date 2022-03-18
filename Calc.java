
package HomeWork;

import java.util.Arrays;
import java.util.List;

public class Calc {
    private int num1, num2;     //числа
    private String operator;    //операции в действиями над числами, допускается: +-*/

    //---подсчет(только целые числа в ответе)
    private int calcExp(int n1, String op, int n2){
        int res;
        switch (op) {
            case "+":
                res = n1+n2;
                break;
            case "-":
                res = n1-n2;
                break;
            case "*":
                res = n1*n2;
                break;
            case "/":
                res = n1/n2;
                break;
            default:
                throw new AssertionError();
        }
        return res;
    }
    
    //---проверка и вывод результатов
    public String result(String exp) throws CalcValid{
        boolean isRomanExp;     // ---Признак, что числа римские
        CalcConvertor parse = new CalcConvertor();
        
        //---прописываем пробел в воде чисел и выражении в консоли
        List<String> expItems = Arrays.asList(exp.split(" "));
        
        //---число1, оператор, число2, иначе исключение
        if (expItems.size()!=3){
            throw new CalcValid("ОШИБКА. Выражение должно иметь вид: \"Число1 Операция Число2\", разделенные пробелом...");
        }
        
        //--- проверка operator (выражение), могут быть только: ("+"; "-"; "*"; "/")
        if (parse.checkOperator(expItems.get(1))){
            operator = expItems.get(1);
        } else {
            throw new CalcValid("Неверный знак вычесления'" + expItems.get(1) + "' допускается только: + - * / ");
        }
        
        //---ввод чисел, оба арабские, оба римские
        if (parse.isNumeric(expItems.get(0)) && parse.isNumeric(expItems.get(2))){      //"num1" & "num2" арабские числа
            num1 = Integer.parseInt(expItems.get(0));
            num2 = Integer.parseInt(expItems.get(2));
            isRomanExp = false;
        } else if (parse.isRoman(expItems.get(0)) && parse.isRoman(expItems.get(2))){   //"num1" & "num2" римские числа
            num1 = parse.romeToArabConvert(expItems.get(0));
            num2 = parse.romeToArabConvert(expItems.get(2));
            isRomanExp = true;
        } else {    //исключение 
            throw new CalcValid("Числа должны быть либо арабские либо римские");
        }
        
        //ограничение на ввод чисел <=10
        if (!(num1>=1 && num1<=10)){
            throw new CalcValid("Вы ввели недопустимое число, число может быть не более 10 или от I до X включительно");
        }

        if (!(num2>=1 && num2<=10)){
            throw new CalcValid("Вы ввели недопустимое число, число может быть не более 10 или от I до X включительно");
        }
        
        //--- вычисляем результат
        int res = calcExp(num1, operator, num2);
        
        //конвертируем римские числа в арабские и возвращаем результат
        if (isRomanExp){
            String sign = res < 0 ? "-" : "";
            return sign + parse.arabToRomeConvert(Math.abs(res));
        }
        
        //ответ елси числа арабские
        return String.valueOf(res);
    }
    
}