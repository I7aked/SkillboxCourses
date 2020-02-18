package task6;

public class Cat
{
    private double originWeight;
    private double weight;
    private CatColor color;
    private double weightFood;

    private double minWeight;
    private double maxWeight;

    public Cat()
    {
        weight =  1500.0 + 3000.0 * Math.random();
        originWeight = weight;
        minWeight = 1000.0;
        maxWeight = 9000.0;
    }

    public CatColor getCatColor(CatColor color)
    {
     return color;
    }

    public void setCatColor(CatColor color )
    {
        this.color = color;
    }

    public  Cat(int weight)
    { this();
    this.weight = weight;
    }

    public void meow()
    {   weight = weight - 1 ;
      }

    public Double weightFood()
    {
        return weightFood;
    }

    public void feed(Double amount)
    {
        weight = weight + amount;
       }

    public void drink(Double amount)
    {
        weight = weight + amount;
      }

      public boolean isAlive()
{
    if (getStatus() != "Dead" && getStatus() != "Exploded") {
        return true;
    }
    else{
        return false;
    }
}

    public boolean hasTail()
    {
        if (getStatus() != "Dead" || getStatus() != "Exploded") {
            return true;
        }
        else{
            return false;
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
}


