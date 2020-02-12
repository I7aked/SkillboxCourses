package task2;

public class Cat
{
    private double originWeight;
    private double weight;
    private double weightPee;

   // private double startWeight;
    private double weightFood;

    private double minWeight;
    private double maxWeight;

    public Cat()
    {
        weight = 1500.0 + 3000.0 * Math.random();
        originWeight = weight;
        minWeight = 1000.0;
        maxWeight = 9000.0;

    }

    public void pee()
    {
        weight = weight - 25;
       weightPee = weightPee + 25;
    }
    public Double getPee(){return weightPee;}

    public void meow()
    {
        weight = weight - 1;

    }

    public Double weightFood()
    {
        return weightFood;
    }

    public void feed(Double amount)
    {
        weight = weight + amount;
        weightFood = weightFood + amount;
    }

    public void drink(Double amount)
    {
        weight = weight + amount;
    }

    public Double getWeight()
    {
        return weight;
    }

    public String getStatus()
    {
        if(weight < minWeight) {
            return "Dead";
        }
        else if(weight > maxWeight) {
            return "Exploded";
        }
        else if(weight > originWeight) {
            return "Sleeping";
        }
        else {
            return "Playing";
        }
    }

}