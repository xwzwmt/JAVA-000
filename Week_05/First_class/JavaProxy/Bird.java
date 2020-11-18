package Week_05.First_class.JavaProxy;

public class Bird implements EggLayable, Flyable{
    @Override
    public void Egg() {
        System.out.println("I can egg");
    }

    @Override
    public void fly() {
        System.out.println("I can fly");
    }
}
