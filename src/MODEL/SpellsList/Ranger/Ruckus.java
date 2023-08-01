package MODEL.SpellsList.Ranger;

import MODEL.SpellsList.Spells;

public class Ruckus implements Spells {
    String name = "RUCKUS";
    int manaCost = 1;
    int damage = 3;
    int misfire = 5;
    int level = 0;
    String target = "ENEMY";
    String desc = "CALL FOR YOUR HAWK PARTNER TO SWIPE AT YOUR ENEMIES!";
    String spellType = "ATTACK";
    String statChange = null;

    /**
     * getter method for spell name
     *
     * @return name
     */
    @Override
    public String getName() {
        return this.name;
    }

    /**
     * getter method for mana cost
     *
     * @return mana cost
     */
    @Override
    public int getManaCost() {
        switch (this.level) {
            case 1, 2 -> this.manaCost = 1;
            case 3, 4 -> this.manaCost = 3;
            case 5, 6 -> this.manaCost = 5;
        }
        return this.manaCost;
    }

    /**
     * getter method for spell damage
     *
     * @return spell damage
     */
    @Override
    public int getDamage() {
        return (int) ((Math.random() * getRawDamage() + this.level) * 1.4);
    }

    /**
     * getter method for raw spell damage
     *
     * @return raw spell damage
     */
    @Override
    public int getRawDamage() {
        switch (this.level) {
            case 1 -> this.damage = 3;
            case 2 -> this.damage = 4;
            case 3 -> this.damage = 6;
            case 4 -> this.damage = 9;
            case 5 -> this.damage = 12;
            case 6 -> this.damage = 16;
        }
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
        return this.spellType;
    }

    /**
     * getter method for stat change
     *
     * @return HEALTH for health changing, DEFENSE for defense changing, DODGE for dodge changing, DAMAGE for damage changing
     */
    @Override
    public String getStatChange() {
        return this.statChange;
    }

    /**
     * getter method for stat change value
     *
     * @return stat change value
     */
    @Override
    public int getStatValue() {
        return 0;
    }

    /**
     * getter method for raw stat change value
     *
     * @return raw stat change value
     */
    public int getRawStatValue() {
        return 0;
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
            this.level = 1;
            return true;
        } else if (pLevel == 7) {
            this.level = 2;
            return true;
        } else if (pLevel == 12) {
            this.level = 3;
            return true;
        } else if (pLevel == 19) {
            this.level = 4;
            return true;
        } else if (pLevel == 24) {
            this.level = 5;
            return true;
        } else if (pLevel == 29) {
            this.level = 6;
            return true;
        }
        return false;
    }
}
