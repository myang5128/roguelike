package MODEL.StartingClasses;

public interface Classes {
    /**
     * interface for starting classes
     * ranger
     * knight
     * mage
     * druid
     * paladin
     * rogue
     */

    /**
     * Default starting values
     */
    String name = null;
    int maxHealth = 0;
    int defense = 0;
    int damage = 0;
    int dodge = 0;

    /**
     * getter method for class name
     * @return name
     */
    public String getName();

    /**
     * getter method for class health
     * @return maxHealth
     */
    public int getHealth();

    /**
     * getter method for class defense
     * @return defense
     */
    public int getDefense();

    /**
     * getter method for class damage
     * @return damage
     */
    public int getDamage();

    /**
     * getter method for class dodge
     * @return dodge
     */
    public int getDodge();

}
