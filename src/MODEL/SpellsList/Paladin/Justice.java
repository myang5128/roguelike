package MODEL.SpellsList.Paladin;

import MODEL.SpellsList.Spells;

public class Justice implements Spells {
    String name = "JUSTICE";
    int manaCost = 7;
    int damage = 12;
    int misfire = 20;
    int level = 0;
    String target = "ENEMY";
    String desc = "A RISKY SPELL THAT DEMANDS A LOT FROM ITS USER TO DEAL POTENTIALLY MASSIVE DAMAGE!";
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
        return this.manaCost + this.level;
    }

    /**
     * getter method for spell damage
     *
     * @return spell damage
     */
    @Override
    public int getDamage() {
        return (int) ((Math.random() * getRawDamage()) * 2.3 + this.level);
    }

    /**
     * getter method for raw spell damage
     *
     * @return raw spell damage
     */
    @Override
    public int getRawDamage() {
        return this.damage + this.level;
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
        return null;
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
        if (pLevel == 5) {
            this.level = 1;
            return true;
        } else if (pLevel == 9) {
            this.level = 2;
            return true;
        } else if (pLevel == 15) {
            this.level = 3;
            return true;
        } else if (pLevel == 20) {
            this.level = 4;
            return true;
        } else if (pLevel == 25) {
            this.level = 5;
            return true;
        } else if (pLevel == 30) {
            this.level = 6;
            return true;
        }
        return false;
    }
}
