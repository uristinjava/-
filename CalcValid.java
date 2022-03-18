package HomeWork;
        //проверка ввода допустимого выражения
public class CalcValid extends Exception {
    public CalcValid() {
        System.out.println("Не знаю такого действия");
    }
    
    public CalcValid(String message){
        this();
        System.out.println(message);
    }
}