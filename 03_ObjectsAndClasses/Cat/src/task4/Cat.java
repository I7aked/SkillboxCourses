package task4;

public class Cat
{
    private double originWeight;
    private double weight;
    public static final int EYE_CAT=2;

    public static int count;
    private double weightFood;

    public static final double MIN_WEIGHT = 1000.0;
    public static final double  MAX_WEIGHT = 9000.0;

    public void setColorCat(colorCat type)
    {
    }
    public Cat()
    {
        weight = 1500.0 + 3000.0 * Math.random();
        originWeight = weight;


        count = count + 1;
    }

    public void kalorii(Double amount)
    {
        weightFood = getWeight() - amount;
    }

    public void pee()
    {
        weight = weight - 250;
        if (weight < MIN_WEIGHT) {count = count - 1;}

    }
    public void meow()
    {
        weight = weight - 1;
        if (weight < MIN_WEIGHT) {count = count - 1;}

    }
    public Double weightFood()
    {
        return weightFood;
    }

    public void feed(Double amount)
    {
        weight = weight + amount;
        if (weight > MAX_WEIGHT) {count = count - 1;}
    }

    public void drink(Double amount)
    {
        weight = weight + amount;
        if (weight > MAX_WEIGHT) {count = count - 1;}
    }

    public Double getWeight()
    {
        return weight;
    }

    public  String getStatus() {
        if (weight < MIN_WEIGHT)
        {
            return "Dead";
        }
        else if (weight > MAX_WEIGHT)
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


