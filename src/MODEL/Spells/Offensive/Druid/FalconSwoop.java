package MODEL.Spells.Offensive.Druid;

import MODEL.Spells.Offensive.OffensiveSpells;

public class FalconSwoop implements OffensiveSpells {

    String name = "FALCON SWOOP";
    int manaCost = 4;
    int damage = 2;
    int misfire = 10;
    int level = 0;
    String target = "ENEMY";
    String desc = "ENLIST THE AID OF A TRUSTWORTHY FALCON TO HARASS YOUR FOE WITH VOLATILE RESULTS!";

    /**
     * constructor
     */
    public FalconSwoop() {
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
        return (int) ((Math.random() * 10) + this.damage + level * 1.5);
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
     * @return spell level
     */
    @Override
    public int getLevel() {
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
        if (pLevel == 2) {
            this.level += 1;
            return true;
        } else if (pLevel == 8) {
            this.level += 1;
            return true;
        } else if (pLevel == 13) {
            this.level += 1;
            return true;
        } else if (pLevel == 15) {
            this.level += 1;
            return true;
        } else if (pLevel == 21) {
            this.level += 1;
            return true;
        } else if (pLevel == 27) {
            this.level += 1;
            return true;
        }
        return false;
    }
}
