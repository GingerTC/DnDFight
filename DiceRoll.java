/*
 * class that represents rolling a 20 sided die
 */

 //importing Random
import java.util.Random;

public class DiceRoll 
{
    //creating private variables
    private int chance;
    private int damEffect;
    private int dice;

    /*
     * method that rolls the die
     * 
     * @param c int represents a character's luck
     */
    public DiceRoll(int c)
    {
        chance = c;
        Random ranNum = new Random();
        dice = ranNum.nextInt(19) + 1; //creating variable to represent die roll
    }

    /*
     * method that gets the effect of the dice roll
     * 
     * @return damEffect int represents effect of die roll on damage of character
     */
    public int getEffect()
    {
        /*
         * the effect of the roll depends on the luck of a character
         * low luck means high chance to deal 0 damage and low chance to deal double damage
         * this means more numbers on the die will equal 0 damage and less numbers on the die will equal double damage
         * high luck means low chance to deal 0 damage and high chance to deal double damage
         * this means more numbers on the die will equal double damage and less numbers on the die will equal 0 damage
         */
        if (chance < 25)
        {
            if (dice <= 9)
            {
                damEffect = 0;
            }
            else if (dice > 8 && dice <=19)
            {
                damEffect = 1;
            }
            else if (dice > 19)
            {
                damEffect = 2;
            }
        }
        else if (chance > 25 && chance < 50)
        {
            if (dice <= 7)
            {
                damEffect = 0;
            }
            else if (dice > 7 && dice <=18)
            {
                damEffect = 1;
            }
            else if (dice > 18)
            {
                damEffect = 2;
            }
        }
        else if (chance == 50)
        {
            if (dice <= 5)
            {
                damEffect = 0;
            }
            else if (dice > 5 && dice <=17)
            {
                damEffect = 1;
            }
            else if (dice > 17)
            {
                damEffect = 2;                
            }
        }
        else if (chance > 50 && chance < 75)
        {
            if (dice <= 4)
            {
                damEffect = 0;
            }
            else if (dice > 4 && dice <=16)
            {
                damEffect = 1;
            }
            else if (dice > 16)
            {
                damEffect = 2;                
            }
        }
        else if (chance > 75)
        {
            if (dice <= 2)
            {
                damEffect = 0;
            }
            else if (dice > 2 && dice <=13)
            {
                damEffect = 1;
            }
            else if (dice > 13)
            {
                 damEffect = 2;               
            }
        }
        return damEffect;
    }

    /*
     * method that returns die role value
     * 
     * @return dice int the randomly generated number between 1-20
     */
    public int getRoll()
    {
        return dice;
    }
}