package task3;

public class Cat
{
    private double originWeight;
    private double weight;

    public static int count;
    private double weightFood;

    private double minWeight;
    private double maxWeight;

    public Cat()
    {
        weight = 1500.0 + 3000.0 * Math.random();
        originWeight = weight;
        minWeight = 1000.0;
        maxWeight = 9000.0;
        count = count + 1;
    }

    public void pee()
    { if (getStatus() != "Dead"){
        weight = weight - 250;
        if (weight < minWeight) {count = count - 1; }}
        else { System.out.printf("Кошка померла, операцион не возможен"); }
    }

    public void meow()
    {if (getStatus() != "Dead") {
        weight = weight - 1;
        if (weight < minWeight) {
            count = count - 1;
        }
    }
    else { System.out.printf("Кошка померла, операцион не возможен");}

    }
    public Double weightFood()
    {
        return weightFood;
    }

    public void feed(Double amount)
    { if (getStatus() != "Exploded"){
        weight = weight + amount;
        if (weight > maxWeight) {count = count - 1;}
    }
    else {
        System.out.printf("Кошка взорвалась, операцион не возможен" );}
    }

    public void drink(Double amount) {
        if (getStatus() != "Exploded") {
            weight = weight + amount;
            if (weight > maxWeight) {
                count = count - 1;
            }

        } else {
            System.out.printf("Кошка взорвалась, операцион не возможен");
        }
    }

    public Double getWeight()
    {
        return weight;
    }

    public  String getStatus() {
        if (weight < minWeight)
        {
            return "Dead";
        }
        else if (weight > maxWeight)
        {
            return "Exploded";
                }
        else if (weight > originWeight) {
            return "Sleeping";
        } else {
            return "Playing";
        }
    }

        public static int getCount()
        {
            return count;
        }



}


