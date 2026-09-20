package abstraction.assigment_problems;

public abstract class GameCharacter {
    private static int counter = 1000;
    private final String characterId;

    public GameCharacter() {
        this.characterId = "CHR-" + (++counter);
    }

    public abstract String getSpecialMove();

    public String getCharacterId() {
        return characterId;
    }

    public static void resolveDefense(Defendable[] combatants) {
        Defendable.resolveDefense(combatants);
    }
}
