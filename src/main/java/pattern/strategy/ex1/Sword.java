package pattern.strategy.ex1;

public class Sword implements Weapon {
    @Override
    public void attack() {
        System.out.println("스워드 공격");
    }
}
