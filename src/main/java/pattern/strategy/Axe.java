package pattern.strategy;

public class Axe implements Weapon {


    @Override
    public void attack() {
        System.out.println("Axe 공격");
    }
}
