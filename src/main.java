import java.util.Scanner;

public class main {

    public static void main(String[] args) {

        String[] arrayToPrint = checkString(scanner());
        print(new String[]{arrayToPrint[0], check(arrayToPrint[1])});

    }

    public static String scanner (){
        String str;
        Scanner scanner = new Scanner(System.in);
        str = scanner.nextLine();
        scanner.close();
        return str;
    }

    public static String[] checkString (String str) {
        String[] strings;
        if (str.isEmpty()) return new String[]{"Строка пустая", ""};
        str = str.trim();
        strings = str.split(" ");
        if (strings.length != 2) return new String[]{"Не верные данные", ""};
        return strings;
    }

    public static String check (String str) {
        return  str.matches("^[0-9]*$") && str.length() > 1 && str.length() < 6 ? Integer.toString(sum(Integer.parseInt(str)))
                : str.matches("^[0-9]*$") && str.length() < 2 ? "Слишком короткое число"
                : str.matches("^[0-9]*$") && str.length() > 5 ? "Слишком длинное число"
                : "Вы ввели не число";
    }

    public static int sum (int num) {
        if (num == 0){
            return num;
        }else        {
            return num % 10 + sum(num / 10) ;
        }
    }

    public static void print (String[] strings) {
        if (strings[0].equals("Строка пустая") || strings[0].equals("Не верные данные")) System.out.println(strings[0]);

        else System.out.println("Здравствуй " + strings[0] + "! " + "Сумма цифр в числе = " + numberPerLine(strings[1]));
    }

    public static String numberPerLine (String str) {
        String[] words = {"Ноль", "Один","Два", "Три", "Четыре", "Пять", "Шесть", "Семь", "Восемь", "Девять", "Десять"};
        if (str.equals("Слишком короткое число") || str.equals("Слишком длинное число")
                || str.equals("Вы ввели не число")) return str;
        int i = Integer.parseInt(str);
        return i > 10 ? "Слишком большая сумма"
                : i < 0 ? "Отрицательная сумма"
                : words[i];

    }

}