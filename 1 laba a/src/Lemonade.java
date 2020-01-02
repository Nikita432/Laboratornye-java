//package bsu.rfe.java.lab1;

public class Lemonade extends Food{
    private String taste;
    public Lemonade(String taste)
    {
        super("Лимонад");
        this.taste = taste;
    }

    public boolean equals(Object arg0)
    {
        if (super.equals(arg0))
        { // Шаг 1
            if (!(arg0 instanceof Lemonade )) return false; // Шаг 2
            return taste.equals(((Lemonade) arg0).taste); // Шаг 3
        } else
            return false;
    }

    public String  getFat()
    {
        return taste;
    }
    public void consume()
    {
        System.out.println(this + " выпито");
    }

    public String toString()
    {
        return super.toString() + " вкус " + taste.toUpperCase();
    }
}
