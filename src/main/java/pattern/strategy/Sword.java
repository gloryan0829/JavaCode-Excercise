package pattern.strategy;

public class Sword implements Weapon {
    @Override
    public void attack() {
        System.out.println("스워드 공격");
    }
}
