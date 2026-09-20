package abstraction.assigment_problems;

public interface Defendable {
    String defend();

    static void resolveDefense(Defendable[] combatants) {
        if (combatants != null) {
            for (Defendable c : combatants) {
                if (c != null) {
                    System.out.println(c.defend());
                }
            }
        }
    }
}
