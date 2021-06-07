package lesson5;

public class Exponentiation {
    public static void main(String[] args) {

        System.out.println(exponentiation(5, 3));

    }


    public static int exponentiation(int number, int degree) {

        if (degree <= 0) {
            return 1;
        } else if (degree == 1) {
            return number;
        }

        return number * exponentiation(number, --degree);
    }


}
