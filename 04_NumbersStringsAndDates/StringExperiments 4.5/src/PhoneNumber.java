import java.util.Scanner;

public class PhoneNumber {


    public static void main(String[] args) {
        String phoneNumber;

        Scanner scanner = new Scanner(System.in);
        phoneNumber = scanner.nextLine();
        phoneNumber = phoneNumber.replaceAll("[^0-9]","");// убрали все символы кроме цифр

        if (phoneNumber.length()>9 && phoneNumber.length()<12) {// проверяем длину получившегося цифрового значения

            switch (phoneNumber.length()) {
                case 10:
                    System.out.println(phoneNumber);
                    break;
                default:
                    System.out.println(phoneNumber.substring(1, 11));
            }

        } else  {
            System.out.println("В номере мало или много цифр");
        }
        System.out.println(phoneNumber.length());
    }
}
