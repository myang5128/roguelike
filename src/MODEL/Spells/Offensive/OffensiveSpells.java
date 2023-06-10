package MODEL.Spells.Offensive;

public interface OffensiveSpells {

    String name = null;
    int manaCost = 0;
    int damage = 0;
    String target = null;
    String desc = null;

    /**
     * getter method for spell name
     * @return name
     */
    public String getName();

    /**
     * getter method for mana cost
     * @return mana cost
     */
    public int getManaCost();

    /**
     * getter method for spell damage
     * @return spell damage
     */
    public int getDamage();

    /**
     * getter method for spell target
     * @return target
     */
    public String getTarget();

    /**
     * getter method for spell desc
     * @return desc
     */
    public String getDesc();
}
