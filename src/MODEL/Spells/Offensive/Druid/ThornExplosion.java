package MODEL.Spells.Offensive.Druid;

import MODEL.Spells.Offensive.OffensiveSpells;

public class ThornExplosion implements OffensiveSpells {

    String name = "THORN EXPLOSION";
    int manaCost = 5;
    int damage = 7;
    int misfire = 20;
    int level = 0;
    String target = "ENEMY";
    String desc = "CREATE A HAPHAZARD ASSORTMENT OF EXPLODER FLOWERS FOR YOUR UNGRATEFUL VISITORS!";

    /**
     * constructor
     */
    public ThornExplosion() {
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
        return manaCost * this.level - 1;
    }

    /**
     * getter method for spell damage
     *
     * @return spell damage
     */
    @Override
    public int getDamage() {
        return (int) ((Math.random() * this.damage) + level * 2.3);
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
        if (pLevel == 5) {
            this.level += 1;
            return true;
        } else if (pLevel == 11) {
            this.level += 1;
            return true;
        } else if (pLevel == 17) {
            this.level += 1;
            return true;
        } else if (pLevel == 22) {
            this.level += 1;
            return true;
        } else if (pLevel == 26) {
            this.level += 1;
            return true;
        } else if (pLevel == 30) {
            this.level += 1;
            return true;
        }
        return false;
    }
}
