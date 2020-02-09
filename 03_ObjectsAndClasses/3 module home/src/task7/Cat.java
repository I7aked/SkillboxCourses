package task7;

public class Cat
{   private double weight;
    private String catColor;

    public  Cat(Cat other)
    {
        this(other.getWeight(),other.getCatColor());
    }

    public String getCatColor()
    {
     return catColor;
    }

    public void setCatColor(String catColor)
    {
        this.catColor = catColor;
    }

    public  Cat(double weight, String catColor)
    {
    this.weight = weight;
    this.catColor = catColor;
    }

    public Double getWeight()
    {
        return weight;
    }

    public void setWeight(double weight)
    {
        this.weight = weight;
    }
}


