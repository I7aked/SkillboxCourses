import java.util.HashMap;
import java.util.Scanner;

public class CustomerStorage
{
    private HashMap<String, Customer> storage;

    public CustomerStorage()
    {
        storage = new HashMap<>();
    }

//    public void addCustomer(String data)
//    {
//        try {
//            String[] components = data.split("\\s+");
//            String name = components[0] + " " + components[1];
//            storage.put(name, new Customer(name, components[3], components[2]));
//
//             }catch (ArrayIndexOutOfBoundsException e) {
//
//            System.out.println("Вы ввели неверные данные для команды. Введите правильные");
//            Scanner scanner = new Scanner(System.in);
//            String command = scanner.nextLine();
//            addCustomer(command);
//        }
//    }

        public void addCustomer(String data)
    {
        String[] components = data.split("\\s+");
        try {
            try {
                if (components.length != 4) {
                    throw new Error();
                }
            } catch (Error e) {
                System.out.print("Вы ввели не все данные для команды");
                throw new Throwable();
            }
            String name = components[0] + " " + components[1];
            try {
                if (!components[2].matches(".+@.+\\..+")) throw new RuntimeException();
            } catch (RuntimeException e) {
                System.out.print("Вы ввели неправильную почту");
                throw new Throwable();
            }

            try {
                if (!components[3].matches("\\+?(\\d){11}")) throw new ArrayIndexOutOfBoundsException();

            } catch (ArrayIndexOutOfBoundsException e) {
                System.out.print("Вы ввели неверный номер телефона.");
                throw new Throwable();
            }
            storage.put(name, new Customer(name, components[3], components[2]));
        }catch (Throwable e){
            System.out.println("Введите по образцу");
        }
    }



    public void listCustomers()
    {
        storage.values().forEach(System.out::println);
    }

    public void removeCustomer(String name)
    {
        storage.remove(name);
    }

    public int getCount()
    {
        return storage.size();
    }
}