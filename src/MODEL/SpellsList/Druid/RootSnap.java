package MODEL.SpellsList.Druid;

import MODEL.SpellsList.Spells;

public class RootSnap implements Spells {

    String name = "ROOT SNAP";
    int manaCost = 3;
    int damage = 4;
    int misfire = 12;
    int level = 0;
    String target = "ENEMY";
    String desc = "UNLEASH AN MIGHTY BRIONET TREE ROOT TO PUMMEL YOUR ENEMY!";
    String spellType = "OFFENSIVE";

    /**
     * constructor
     */
    public RootSnap() {
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
        return (int) ((Math.random() * this.damage + 1) + level * 2);
    }

    /**
     * getter method for raw spell damage
     * @return raw spell damage
     */
    public int getRawDamage() {
        return this.damage;
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
     * getter method for spell type
     *
     * @return ATTACK for offensive spells, SUPPORT for support spells, WEAKEN for enemy debuff spells
     */
    @Override
    public String getSpellType() {
        return spellType;
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
        if (pLevel == 3) {
            this.level =1;
            return true;
        } else if (pLevel == 7) {
            this.level =2;
            return true;
        } else if (pLevel == 12) {
            this.level =3;
            return true;
        } else if (pLevel == 18) {
            this.level =4;
            return true;
        } else if (pLevel == 23) {
            this.level =5;
            return true;
        } else if (pLevel == 29) {
            this.level =6;
            return true;
        }
        return false;
    }
}
