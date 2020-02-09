package task4;

public class Cat
{
    private double originWeight;
    private double weight;
    public static final int EYECAT=2;

    public static int count;
    private double weightFood;

    public static final double MINWEIGHT = 1000.0;
    public static final double  MAXWEIGHT = 9000.0;

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
        if (weight < MINWEIGHT) {count = count - 1;}

    }
    public void meow()
    {
        weight = weight - 1;
        if (weight < MINWEIGHT) {count = count - 1;}

    }
    public Double weightFood()
    {
        return weightFood;
    }

    public void feed(Double amount)
    {
        weight = weight + amount;
        if (weight > MAXWEIGHT) {count = count - 1;}
    }

    public void drink(Double amount)
    {
        weight = weight + amount;
        if (weight > MAXWEIGHT) {count = count - 1;}
    }

    public Double getWeight()
    {
        return weight;
    }

    public  String getStatus() {
        if (weight < MINWEIGHT)
        {
            return "Dead";
        }
        else if (weight > MAXWEIGHT)
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


