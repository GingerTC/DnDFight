/*
 * class that inherits data from Character class
 */

 //importing ArrayList
import java.util.ArrayList;

public class CharacterClass extends Character
{
    //creating private variables 
    private String className;
    private ArrayList<String> skills;

    /*
     * sets character's data with all data given
     * 
     * @param c string to set character's DnD class
     * @param n string to set character's name variable
     * @param h int to set character's health value
     * @param s int to set character's strength value
     * @param l int to set character's luck value
     */
    public CharacterClass(String c, String n, int h, int s, int l)
    {  
        super(n, h, s, l); //inherits Character data
        className = c;
        skills = new ArrayList<String>();
    }
    
    /*
     * emthod to add skills to ArrayList
     * 
     * @param s String to add skill to skill list
     * @return skills ArrayList new list of skills
     */
    public ArrayList<String> addSkill(String s)
    {
        skills.add(s);
        return skills;
    }

    /*
     * method to return skill list
     * 
     * @return skills ArrayList of skills
     */
    public ArrayList<String> getSkills()
    {
        return skills;
    }

    /*
     * method to return health value
     * 
     * @return health int that represents character's health
     */
    public int getHealth()
    {
        return health;
    }

    /*
     * method to return strength value
     * 
     * @return strength int that represents character's strength
     */
    public int getStrength()
    {
        return strength;
    }

    /*
     * method to return luck value
     * 
     * @return luck int that represents character's luck
     */
    public int getLuck()
    {
        return luck;
    }

    /*
     * creating string value of character's stats to print
     * 
     * @return returnString string that is all of the character's stats with class and skills
     */
    public String toString()
    {
        String returnString = "";
        returnString += "Name: " + name + "\n";
        returnString += "Class: " + className + "\n";
        returnString += "Health: " + health + "\n";
        returnString += "Strength: " + strength + "\n";
        returnString += "Luck: " + luck + "\n";
        returnString += "Skills: " + skills;
        return returnString;
    }
}