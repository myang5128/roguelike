package MODEL.Spells.Offensive.Druid;

import MODEL.Spells.Offensive.OffensiveSpells;

public class RagingBoar implements OffensiveSpells {

    String name = "RAGING BOAR";
    int manaCost = 3;
    int damage = 5;
    int misfire = 15;
    int level = 0;
    String target = "ENEMY";
    String desc = "CALL UPON A SPECTRAL BOAR TO MAIM YOUR ENEMIES!";

    /**
     * constructor
     */
    public RagingBoar() {
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
        return (int) ((Math.random() * this.damage + 2) + level * 1.7);
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
        if (pLevel == 4) {
            this.level += 1;
            return true;
        } else if (pLevel == 7) {
            this.level += 1;
            return true;
        } else if (pLevel == 10) {
            this.level += 1;
            return true;
        } else if (pLevel == 16) {
            this.level += 1;
            return true;
        } else if (pLevel == 24) {
            this.level += 1;
            return true;
        } else if (pLevel == 28) {
            this.level += 1;
            return true;
        }
        return false;
    }
}
