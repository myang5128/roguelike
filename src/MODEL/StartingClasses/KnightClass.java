package MODEL.StartingClasses;

public class KnightClass implements Classes {

    String name = "KNIGHT CLASS";
    int maxHealth = 12;
    int defense = 5;
    int damage = 3;
    int dodge = 45;

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
