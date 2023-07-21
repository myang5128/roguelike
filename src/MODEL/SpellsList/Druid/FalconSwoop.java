package MODEL.SpellsList.Druid;

import MODEL.SpellsList.Spells;

public class FalconSwoop implements Spells {

    String name = "FALCON SWOOP";
    int manaCost = 4;
    int damage = 2;
    int misfire = 10;
    int level = 0;
    String target = "ENEMY";
    String desc = "ENLIST THE AID OF A TRUSTWORTHY FALCON TO HARASS YOUR FOE WITH VOLATILE RESULTS!";
    String spellType = "OFFENSIVE";
    String statChange = null;

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
        return (int) ((Math.random() * 5) + this.damage + level * 1.5);
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
            this.level = 1;
            return true;
        } else if (pLevel == 8) {
            this.level = 2;
            return true;
        } else if (pLevel == 13) {
            this.level += 3;
            return true;
        } else if (pLevel == 15) {
            this.level =4;
            return true;
        } else if (pLevel == 21) {
            this.level =5;
            return true;
        } else if (pLevel == 27) {
            this.level =6;
            return true;
        }
        return false;
    }
}