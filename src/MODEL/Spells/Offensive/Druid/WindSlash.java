package MODEL.Spells.Offensive.Druid;

import MODEL.Spells.Offensive.OffensiveSpells;

public class WindSlash implements OffensiveSpells {

    String name = "WIND SLASH";
    int manaCost = 1;
    int damage = 2;
    int misfire = 8;
    int level = 0;
    String target = "ENEMY";
    String desc = "SUMMON A POWERFUL GUST OF WIND TO LACERATE YOUR TARGETS!";

    /**
     * constructor
     */
    public WindSlash() {
    }

    /**
     * getter method for spell name
     *
     * @return name
     */
    @Override
    public String getName() {
        return name;
    }

    /**
     * getter method for mana cost
     *
     * @return mana cost
     */
    @Override
    public int getManaCost() {
        return manaCost + level;
    }

    /**
     * getter method for spell damage
     *
     * @return spell damage
     */
    @Override
    public int getDamage() {
        return (int) ((Math.random() * 1 + this.damage) + level * 1.5);
    }

    /**
     * getter method for misfire chance
     *
     * @return misfire chance
     */
    @Override
    public int getMisfire() {
        return this.misfire;
    }

    /**
     * getter method for spell level
     *
     * @param pLevel player level
     * @return spell level
     */
    @Override
    public int getLevel(int pLevel) {
        return this.level;
    }

    /**
     * getter method for spell target
     *
     * @return target
     */
    @Override
    public String getTarget() {
        return this.target;
    }

    /**
     * getter method for spell desc
     *
     * @return desc
     */
    @Override
    public String getDesc() {
        return this.desc;
    }

    /**
     * run spell
     *
     * @return 0 if miss, >0 for damage
     */
    @Override
    public int runSpell() {
        int chance = (int) (Math.random() * 100 + this.level);
        if (chance <= this.misfire) {
            return 0;
        } else {
            return getDamage();
        }
    }

    /**
     * updates spell level
     *
     * @param pLevel player level
     * @return t if updated, f if not
     */
    @Override
    public boolean updateLevel(int pLevel) {
        if (pLevel == 1) {
            this.level += 1;
            return true;
        } else if (pLevel == 5) {
            this.level += 1;
            return true;
        } else if (pLevel == 9) {
            this.level += 1;
            return true;
        } else if (pLevel == 14) {
            this.level += 1;
            return true;
        } else if (pLevel == 19) {
            this.level += 1;
            return true;
        } else if (pLevel == 25) {
            this.level += 1;
            return true;
        }
        return false;
    }
}
