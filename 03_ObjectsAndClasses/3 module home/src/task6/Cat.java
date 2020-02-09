package task6;

public class Cat
{
    private double originWeight;
    private double weight;
    private String catColor;
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

    public String getCatColor(String catColor)
    {
     return catColor;
    }

    public void setCatColor(String catColor)
    {
        this.catColor = catColor;
    }



    public  Cat(int weight)
    { this();
    this.weight = weight;
    }

    public void meow()
    {
        weight = weight - 1;
        if (weight < minWeight) {count = count - 1;}

    }
    public Double weightFood()
    {
        return weightFood;
    }

    public void feed(Double amount)
    {
        weight = weight + amount;
        if (weight > maxWeight) {count = count - 1;}
    }

    public void drink(Double amount)
    {
        weight = weight + amount;
        if (weight > maxWeight) {count = count - 1;}
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


