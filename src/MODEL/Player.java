package MODEL;

import MODEL.SpellsList.Spells;
import MODEL.StartingClasses.Classes;

public class Player {
    String name;
    Classes playerClass;
    int curHealth;
    int maxHealth;
    int curMana;
    int maxMana;
    int defense;
    int tempDefense;
    int dodge;
    int tempDodge;
    int damage;
    int tempDamage;
    int curExp;
    int expReq;
    int gold;
    int level;
    Spells[] spellArray;

    /**
     * Constructor
     */
    public Player(String name, Classes playerClass, int maxHealth, int maxMana, int defense, int dodge, int damage, Spells[] spellArray) {
        this.name = name;
        this.playerClass = playerClass;
        this.curHealth = maxHealth;
        this.maxHealth = maxHealth;
        this.curMana = maxMana;
        this.maxMana = maxMana;
        this.defense = defense;
        this.tempDefense = defense;
        this.dodge = dodge;
        this.tempDodge = dodge;
        this.damage = damage;
        this.tempDamage = damage;
        this.curExp = 0;
        this.gold = 0;
        this.level = 1;
        this.spellArray = spellArray;
    }

    /**
     * checks to see how much exp is needed for next level up
     *
     * @return exp needed
     */
    public int setExpReq() {
        if (this.level < 5) {
            this.expReq = (this.level * 15);
            return this.expReq;
        } else if (this.level < 10) {
            this.expReq = (this.level * 50);
            return this.expReq;
        } else if (this.level < 20) {
            this.expReq = (this.level * 125);
            return this.expReq;
        } else {
            this.expReq = (this.level * 200);
            return this.expReq;
        }
    }

    /**
     * levels up player
     */
    public void PlayerLevelUp() {
        String className = playerClass.getName();
        int healthGain;
        int manaGain;
        int damageGain;
        int defenseGain;
        int dodgeGain;
        switch (className) {
            // health - mana - damage - defense - dodge
            // druid - focus mana and health
            case "DRUID CLASS" -> {
                healthGain = (int) ((Math.random() * 4) + 2);
                manaGain = (int) ((Math.random() * 3) + 1);
                damageGain = (int) (Math.random() * 1);
                defenseGain = (int) ((Math.random() * 2) - 1);
                if (defenseGain < 0) {
                    defenseGain = 0;
                }
                dodgeGain = (int) ((Math.random() * 3) - 2);
                if (dodgeGain < 0) {
                    dodgeGain = 0;
                }
            }

            // knight - focus on defense and health
            case "KNIGHT CLASS" -> {
                healthGain = (int) ((Math.random() * 5) + 3);
                manaGain = (int) (Math.random() * 2);
                damageGain = (int) ((Math.random() * 3) + 2);
                defenseGain = (int) ((Math.random() * 2) + 1);
                dodgeGain = (int) ((Math.random() * 3) - 2);
                if (dodgeGain < 0) {
                    dodgeGain = 0;
                }
            }

            // mage - focus on mana
            case "MAGE CLASS" -> {
                healthGain = (int) ((Math.random() * 3) + 1);
                manaGain = (int) ((Math.random() * 6) + 4);
                damageGain = (int) ((Math.random() * 3) - 1);
                if (damageGain < 0) {
                    damageGain = 0;
                }
                defenseGain = (int) ((Math.random() * 3) - 2);
                if (defenseGain < 0) {
                    defenseGain = 0;
                }
                dodgeGain = (int) ((Math.random() * 3) - 2);
                if (dodgeGain < 0) {
                    dodgeGain = 0;
                }
            }

            // paladin - focus on defense, mana, and health
            case "PALADIN CLASS" -> {
                healthGain = (int) ((Math.random() * 7) + 2);
                manaGain = (int) ((Math.random() * 4) + 1);
                damageGain = (int) ((Math.random() * 4) + 1);
                defenseGain = (int) ((Math.random() * 2));
                dodgeGain = (int) ((Math.random() * 3) - 2);
                if (dodgeGain < 0) {
                    dodgeGain = 0;
                }
            }

            // ranger - focus on dodge and damage
            case "RANGER CLASS" -> {
                healthGain = (int) ((Math.random() * 3) + 2);
                manaGain = (int) (Math.random() * 2);
                damageGain = (int) ((Math.random() * 4) + 2);
                defenseGain = (int) ((Math.random() * 2) - 1);
                if (defenseGain < 0) {
                    defenseGain = 0;
                }
                dodgeGain = (int) (Math.random() * 2);
            }

            // default/rogue - focus on dodge and damage
            default -> {
                healthGain = (int) ((Math.random() * 2) + 2);
                manaGain = (int) (Math.random() * 2);
                damageGain = (int) ((Math.random() * 6) + 1);
                defenseGain = (int) ((Math.random() * 3) - 2);
                if (defenseGain < 0) {
                    defenseGain = 0;
                }
                dodgeGain = (int) (Math.random() * 3);
            }
        }
        this.level += 1;
        this.curHealth += healthGain;
        this.maxHealth += healthGain;
        this.curMana += manaGain;
        this.maxMana += manaGain;
        this.damage += damageGain;
        this.defense += defenseGain;
        this.dodge += dodgeGain;
        this.expReq = setExpReq();
    }

    /**
     * checks if player has enough exp
     *
     * @return true if level up, false if not
     */
    public boolean ExpLevelEnough() {
        if (this.curExp >= this.expReq) {
            this.curExp -= this.expReq;
            PlayerLevelUp();
            return true;
        }
        return false;
    }

    /**
     * getter method for player name
     *
     * @return name
     */
    public String getName() {
        return this.name;
    }

    /**
     * getter method for current health
     *
     * @return current health
     */
    public int getCurHealth() {
        return this.curHealth;
    }

    /**
     * getter method for max health
     *
     * @return max health
     */
    public int getMaxHealth() {
        return this.maxHealth;
    }

    /**
     * getter method for current mana
     *
     * @return current health
     */
    public int getCurMana() {
        return this.curMana;
    }

    /**
     * getter method for max mana
     *
     * @return max health
     */
    public int getMaxMana() {
        return this.maxMana;
    }

    /**
     * getter method for defense
     *
     * @return defense
     */
    public int getDefense() {
        return this.defense;
    }

    /**
     * getter method for temp defense
     *
     * @return temp defense
     */
    public int getTempDefense() {
        return this.tempDefense;
    }

    /**
     * getter method for dodge
     *
     * @return dodge
     */
    public int getDodge() {
        return this.dodge;
    }

    /**
     * getter method for temp dodge
     *
     * @return temp dodge
     */
    public int getTempDodge() {
        return this.tempDodge;
    }

    /**
     * getter method for damage
     *
     * @return damage
     */
    public int getDamage() {
        return this.damage;
    }

    /**
     * getter method for temp damage
     *
     * @return temp damage
     */
    public int getTempDamage() {
        return this.tempDamage;
    }

    /**
     * getter method for current exp
     *
     * @return current exp
     */
    public int getCurExp() {
        return this.curExp;
    }

    /**
     * getter method for exp required
     *
     * @return exp required
     */
    public int getExpReq() {
        return this.expReq;
    }

    /**
     * getter method for gold
     *
     * @return gold
     */
    public int getGold() {
        return this.gold;
    }

    /**
     * getter method for level
     *
     * @return level
     */
    public int getLevel() {
        return this.level;
    }

    /**
     * gets a scale factor according to the level
     *
     * @return scale factor
     */
    public int getScale() {
        if (this.level < 5) {
            return 1;
        } else if (this.level < 10) {
            return 2;
        } else {
            return this.level / 5;
        }
    }

    /**
     * light attack function
     *
     * @param eDodge enemy dodge chance
     * @return 0 if doesn't hit, > 0 for raw damage
     */
    public int lightAttack(int eDodge) {
        int hitChance = ((int) (Math.random() * 100)) + 30 + this.level;
        if (hitChance >= eDodge) {
            return this.tempDamage;
        } else {
            return 0;
        }
    }

    /**
     * heavy attack function
     *
     * @param eDodge enemy dodge chance
     * @return 0 if doesn't hit, > 0 for raw damage
     */
    public int heavyAttack(int eDodge) {
        int hitChance = ((int) (Math.random() * 100)) + 15 + this.level;
        if (hitChance >= eDodge) {
            return (int) (this.tempDamage * 1.7);
        } else {
            return 0;
        }
    }

    /**
     * calculate flee chance
     *
     * @return 1 if successful, 0 if not
     */
    public int flee() {
        int flee = ((int) (Math.random() * 100)) + 1;
        if (flee >= 70) {
            flee = 1;
        } else {
            flee = 0;
        }
        return flee;
    }

    /**
     * return spells
     *
     * @return spell list
     */
    public Spells[] spells() {
        int count = 0;
        for (int i = 0; i < 5; i++) {
            spellArray[i].updateLevel(this.level);
        }
        for (int i = 0; i < 5; i++) {
            if (spellArray[i].getLevel() > 0) {
                count++;
            }
        }
        Spells[] ret = new Spells[count];
        int j = 0;
        for (int i = 0; i < 5; i++) {
            if (spellArray[i].getLevel() > 0) {
                ret[j] = spellArray[i];
                j++;
            }
        }
        return ret;
    }

    /**
     * calculates dmg done to player and changes player health accordingly
     *
     * @param dmg enemy raw dmg value
     */
    public int takeDamage(int dmg) {
        int dmgValue = dmg - this.tempDefense;
        if (dmgValue <= 0) {
            dmgValue = 1;
            this.curHealth--;
        } else {
            this.curHealth -= dmgValue;
        }
        return dmgValue;
    }

    /**
     * adds exp and gold to player
     *
     * @param exp  exp
     * @param gold gold
     * @return true if level up, false if not
     */
    public boolean addExpGold(int exp, int gold) {
        this.gold += gold;
        this.curExp += exp;
        return ExpLevelEnough();
    }

    /**
     * modifies mana
     *
     * @param value mana to be added/subtracted
     */
    public void setMana(int value) {
        this.curMana -= value;
    }

    /**
     * resets all temp stats to base stats
     */
    public void resetStat() {
        this.tempDefense = this.defense;
        this.tempDamage = this.damage;
        this.tempDodge = this.dodge;
    }

    /**
     * change player stats
     *
     * @param stat  stat to be changed
     * @param value stat change modifier
     */
    public void changeStat(String stat, int value) {
        switch (stat) {
            case "ATTACK" -> this.tempDamage += value;
            case "DEFENSE" -> this.tempDefense += value;
            case "DODGE" -> this.tempDodge += value;
            case "HEALTH" -> {
                this.curHealth += value;
                if (this.curHealth >= this.maxHealth) {
                    this.curHealth = this.maxHealth;
                }
            }
        }
    }
}
