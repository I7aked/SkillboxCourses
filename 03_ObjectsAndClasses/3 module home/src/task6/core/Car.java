package task6.core;

public class Car
{
    public String number;
    public int height;
    public double weight;
    public boolean hasVehicle;
    public boolean isSpecial;

    public String toString()
    {
        String special = isSpecial ? "СПЕЦТРАНСПОРТ " : ""; // переменная тип string
        return "\n=========================================\n" +
                special + "Автомобиль с номером " + number +
                ":\n\tВысота: " + height + " мм\n\tМасса: " + weight + " кг";
    }
     // Геттэры
    private  String number()
    {
        return number;
    }

    private int height()
    {
         return height;
    }
    private double weight()
    {
        return weight;
    }
    public boolean hasVehicle()
    {
        return hasVehicle;
    }

    public boolean isSpecial()
    {
        return isSpecial;
    }

    //Сеттэры
    private void setNumber(String number)
    {
        this.number = number;
    }

    private void setHeight(int height)
    {
        this.height = height;
    }

    private void setWeight(double weight)
    {
        this.weight = weight;
    }

    private void setHasVehicle(boolean hasVehicle)
    {
        this.hasVehicle = hasVehicle;
    }

    private void setIsSpecial(boolean isSpecial)
    {
        this.isSpecial = isSpecial;
    }
}