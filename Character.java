/*
 * class for returning all data of a DnD character
 */
public class Character 
{
    //creating protected variables that can be inherited
    protected String name;
    protected int health;
    protected int strength;
    protected int luck;

    /*
     * setting all character data with only name parameter
     * 
     * @param n string to set character's name variable
     */
    public Character(String n)
    {
        name = n;
        health = 100;
        strength = 100;
        luck = 50;
    }

    /*
     * setting character data with all variables given
     * 
     * @param n string to set character's name variable
     * @param h int to set character's health value
     * @param s int to set character's strength value
     * @param l int to set character's luck value
     */
    public Character(String n, int h, int s, int l)
    {
        name = n;
        health = h;
        luck = l;
        strength = s;
    }

    /*
     * creating string value of character's stats to print
     * 
     * @return returnString string that is all of the character's stats
     */
    public String toString()
    {
        String returnString = "";
        returnString += "Name: " + name + "\n";
        returnString += "Health: " + health + "\n";
        returnString += "Strength: " + strength + "\n";
        returnString += "Luck: " + luck;
        return returnString;
    }
}