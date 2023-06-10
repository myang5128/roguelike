package MODEL.StartingClasses;

public class RangerClass implements Classes {

    String name = "RANGER CLASS";
    int maxHealth = 8;
    int maxMana = 6;
    int defense = 3;
    int damage = 5;
    int dodge = 60;

    /**
     * getter method for class name
     *
     * @return name
     */
    @Override
    public String getName() {
        return name;
    }

    /**
     * getter method for class health
     *
     * @return maxHealth
     */
    @Override
    public int getHealth() {
        return maxHealth;
    }

    /**
     * getter method for class mana
     *
     * @return maxHMana
     */
    @Override
    public int getMana() {
        return maxMana;
    }

    /**
     * getter method for class defense
     *
     * @return defense
     */
    @Override
    public int getDefense() {
        return defense;
    }

    /**
     * getter method for class damage
     *
     * @return damage
     */
    @Override
    public int getDamage() {
        return damage;
    }

    /**
     * getter method for class dodge
     *
     * @return dodge
     */
    @Override
    public int getDodge() {
        return dodge;
    }
}
