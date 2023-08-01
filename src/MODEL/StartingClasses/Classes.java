package MODEL.StartingClasses;

public interface Classes {
    /**
     * Default starting values
     */
    String name = null;
    int maxHealth = 0;
    int maxMana = 0;
    int defense = 0;
    int damage = 0;
    int dodge = 0;

    /**
     * getter method for class name
     *
     * @return name
     */
    String getName();

    /**
     * getter method for class health
     *
     * @return maxHealth
     */
    int getHealth();

    /**
     * getter method for class mana
     *
     * @return maxHMana
     */
    int getMana();

    /**
     * getter method for class defense
     *
     * @return defense
     */
    int getDefense();

    /**
     * getter method for class damage
     *
     * @return damage
     */
    int getDamage();

    /**
     * getter method for class dodge
     *
     * @return dodge
     */
    int getDodge();

}
