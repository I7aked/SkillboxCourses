package task6;

import task6.core.*;
import task6.core.Camera;

import java.util.Scanner;

public class RoadController1
{
    private static double passengerCarMaxWeight = 3500.0; // kg Вещественная прееменная, double
    private static int passengerCarMaxHeight = 2000; // mm  целая переменная, int
    private static int controllerMaxHeight = 4000; // mm  целая переменная, int

    private static int passengerCarPrice = 200; // RUB  целая переменная, int
    private static int cargoCarPrice = 250; // RUB  целая переменная, int
    private static int vehicleAdditionalPrice = 200; // RUB  целая переменная, int

    public static void main(String[] args)
    {
        System.out.println("Сколько автомобилей сгенерировать?");

        Scanner scanner = new Scanner(System.in); //тип Scanner
        int carsCount = scanner.nextInt();    // целая переменная, int

        for(int i = 0; i < carsCount; i++) // целая пременная, int
        {
            Car car = Camera.getNextCar(); // тип Car
            System.out.println(car);

            //Пропускаем автомобили спецтранспорта бесплатно
            if (car.isSpecial) {
                openWay();
                continue;
            }

            //Проверяем высоту и массу автомобиля, вычисляем стоимость проезда
            int price = calculatePrice(car); //целая переменная, int
            if(price == -1) {
                continue;
            }

            System.out.println("Общая сумма к оплате: " + price + " руб.");
        }
    }

    /**
     * Расчёт стоимости проезда исходя из массы и высоты
     */
    private static int calculatePrice(Car car)
    {
        int carHeight = car.height;//целая переменная, int
        int price = 0;  //целая переменная, int
        if (carHeight > controllerMaxHeight)
        {
            blockWay("высота вашего ТС превышает высоту пропускного пункта!");
            return -1;
        }
        else if (carHeight > passengerCarMaxHeight)
        {
            double weight = car.weight; //вещественная переменная, double
            //Грузовой автомобиль
            if (weight > passengerCarMaxWeight)
            {
                price = passengerCarPrice;
                if (car.hasVehicle) {
                    price = price + vehicleAdditionalPrice;
                }
            }
            //Легковой автомобиль
            else {
                price = cargoCarPrice;
            }
        }
        else {
            price = passengerCarPrice;
        }
        return price;
    }

    /**
     * Открытие шлагбаума
     */
    private static void openWay()
    {
        System.out.println("Шлагбаум открывается... Счастливого пути!");
    }

    /**
     * Сообщение о невозможности проезда
     */
    private static void blockWay(String reason)
    {
        System.out.println("Проезд невозможен: " + reason);
    }
}