/*
 * class that represents a fight between the player and the enemy
 */

 //importing ArrayList and Random
import java.util.ArrayList;
import java.util.Random;

public class Fight 
{
    //creating private variables
    private double pHealth; //"p" variables are for the player
    private double pStrength;
    private int pLuck;
    private double eHealth; //"e" variables are for the enemy
    private double eStrength;
    private int eLuck;
    private ArrayList<String> pSkills;
    private ArrayList<String> eSkills;
    private DiceRoll pRoll;
    private DiceRoll eRoll;
    private int pEffect;
    private int eEffect;
    private int enemyChoice;
    private int playerChoice;
    private double pDamage;
    private double eDamage;

    /*
     * method that enacts a fight between player and enemy
     * 
     * @param pH double sets player health
     * @param pS int sets player strength
     * @param pL int sets player luck
     * @param pSk ArrayList sets player list of skills
     * @param eH double sets enemy health
     * @param eS int sets enemy strength
     * @param eL int sets enemy luck
     * @param eSk ArrayList sets enemy list of skills
     * @param pC int sets player choice of skill
     */
    public Fight(double pH, int pS, int pL, ArrayList<String> pSk, double eH, int eS, int eL, ArrayList<String> eSk, int pC)
    {
        //sets all paramaters to private variables
        pHealth = pH;
        pStrength =pS;
        pLuck = pL;
        pSkills = pSk;
        eHealth = eH;
        eStrength = eS;
        eLuck = eL;
        eSkills = eSk;
        playerChoice = pC;

        Random ranNum = new Random();
        enemyChoice = ranNum.nextInt(2); //enemy choice randomly chosen from 0-2
        pRoll = new DiceRoll(pLuck); //player rolls the 20 sided die
        eRoll = new DiceRoll(eLuck); //enemy rolls the 20 sided die
        pEffect = pRoll.getEffect();
        eEffect = eRoll.getEffect();
        pDamage = pStrength/10; //setting player's damage using their character's strength
        eDamage = eStrength/10; //setting enemy's damage using character's strength
        
        /*
         * player attacks enemy first
         * the effect of the roll determines the damage done to enemy's health
         * 0 is 0 damage (miss), 1 is normal damage, 2 is double damage (critical hit)
         * enemy health loses value equal to player damage
         */
        if (pEffect == 0)
        {
            eHealth = eHealth - 0;
        }
        else if (pEffect == 1)
        {
            eHealth = eHealth - pDamage;
        }
        else
        {
            eHealth = eHealth - pDamage*2;
        }

        /*
         * enemy attacking the player
         * the effect of the roll determines the damage done to player's health
         * 0 is 0 damage (miss), 1 is normal damage, 2 is double damage (critical hit)
         * player health loses value equal to enemy damage 
         */
        if (eEffect == 0)
        {
            pHealth = pHealth - 0;
        }
        else if (eEffect == 1)
        {
            pHealth = pHealth - eDamage;
        }
        else
        {
            pHealth = pHealth - eDamage*2;
        }

        //sets player and enemy health to 0 if the health goes below 0
        if (pHealth < 0)
        {
            pHealth = 0;
        }
        else if (eHealth < 0)
        {
            eHealth = 0;
        }
    }

    /*
     * method to return player health value
     * 
     * @return pHealth double that represents player's new health
     */
    public double getPlayerHealth()
    {
        return pHealth;
    }

    /*
     * method to return enemy health value
     * 
     * @return ehealth double that represents enemy's new health
     */
    public double getEnemyHealth()
    {
        return eHealth;
    }

    /*
     * method to return string value of fight outcome to print
     * 
     * @return fightString string of what happened in fight depending on die roll
     */
    public String toString()
    {
        String fightString = "";
        fightString += "You used " + pSkills.get(playerChoice) + " and rolled " + pRoll.getRoll() + "\n";
        if (pEffect == 0)
        {
            fightString += "Unfortunely, you missed and dealt 0 damage to the theif. Enemy's health is " + eHealth + "\n";
        }
        else if (pEffect == 1)
        {
            fightString += "You dealt " + pDamage + " damage to the theif. Enemy's health is " + eHealth + "\n";
        }
        else
        {
            fightString += "You got a critical hit and dealt " + pDamage*2 + " damage to the theif. Enemy's health is " + eHealth + "\n";
        }

        fightString += "Enemy used " + eSkills.get(enemyChoice) + " and rolled " + eRoll.getRoll() + "\n";
        if (eEffect == 0)
        {
            fightString += "Enemy missed their attack and dealt 0 damage to you. Your health is " + pHealth + "\n";
        }
        else if (eEffect == 1)
        {
            fightString += "Enemy dealt " + eDamage + " damage to you. Your health is " + pHealth + "\n";
        }
        else
        {
            fightString += "Enemy got a critical hit and dealt " + eDamage*2 + " damage to you. Your health is " + pHealth + "\n";
        }
        return fightString;
    }
}