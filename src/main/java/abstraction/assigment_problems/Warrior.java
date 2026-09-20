package abstraction.assigment_problems;

public class Warrior extends GameCharacter implements Attackable, Defendable {
    private String name;

    public Warrior(String name) {
        super();
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String attack() {
        return name + " strikes with a blade";
    }

    @Override
    public String attack(String weaponName) {
        if (weaponName == null || weaponName.isEmpty()) {
            return attack();
        }
        char first = Character.toLowerCase(weaponName.charAt(0));
        String article = (first == 'a' || first == 'e' || first == 'i' || first == 'o' || first == 'u') ? "an " : "a ";
        return name + " strikes with " + article + weaponName;
    }

    @Override
    public String defend() {
        return name + " raises a shield";
    }

    @Override
    public String getSpecialMove() {
        return name + " unleashes Whirlwind Slash";
    }
}
