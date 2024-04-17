/*
 * This project has a player pick a Dungeons and Dragons class and fight an enemy utilizing their stats
 * This class is the driver class that runs the whole program
 * 
 * @author: Tyler Cloutier
 */

 //importing Scanner and ArrayList
import java.util.Scanner;
import java.util.ArrayList;

public class Driver 
{
    /*
     * main class that runs all other classes
     */
    public static void main(String[] args)
    {
        Scanner keyboard = new Scanner(System.in); //variable that utilizes Scanner and user input
        ArrayList<String> charList = new ArrayList<String>(); //creating the list of classes user can pick
        //adding classes to ArrayList
        charList.add("Barbarian");
        charList.add("Wizard");
        charList.add("Bard");
        charList.add("Rogue");
        charList.add("Paladin");

        //creating empty player variable using CharacterClass class
        CharacterClass player = new CharacterClass("","",0,0,0); 

        System.out.println(charList + "\nPick one of these character classes.");
        String pickChar = keyboard.nextLine(); //player chosen DnD class
        while (charList.contains(pickChar) == false) //loop to make sure player picks an available class
        {
            System.out.println("Not a choice. Choose again.");
            pickChar = keyboard.nextLine();
        }

        System.out.println("and what will be your Character's name?");
        String charName = keyboard.nextLine(); //user sets their charcater's name
        
        //changes player variable depending on the DnD class they pick
        if (pickChar.equals(charList.get(0)))
        {
            player = new CharacterClass(pickChar, charName, 200, 300, 20);
        }
        else if (pickChar.equals(charList.get(1)))
        {
            player = new CharacterClass(pickChar, charName, 150, 150, 50);
        }
        else if (pickChar.equals(charList.get(2)))
        {
            player = new CharacterClass(pickChar, charName, 150, 100, 100);
        }
        else if (pickChar.equals(charList.get(3)))
        {
            player = new CharacterClass(pickChar, charName, 115, 175, 70);
        }
        else if (pickChar.equals(charList.get(4)))
        {
            player = new CharacterClass(pickChar, charName, 250, 200, 35);
        }

        System.out.println("Name three of your skills:");
        for (int i = 0; i < 3; i++) //loop that allows player to input 3 skills into an ArrayList
        {
            String skillName = keyboard.nextLine();
            player.addSkill(skillName);
        }
        System.out.println("\nYour stats are\n"+player); //prints player variable data

        //creating enemy variable using CharacterClass
        CharacterClass enemy = new CharacterClass("Theif", "Enemy", 150, 150, 50);
        //setting 3 skills to enemy variable ArrayList
        enemy.addSkill("Punch");
        enemy.addSkill("Kick");
        enemy.addSkill("Stab");

        double playerHealth = player.getHealth(); //creating player health variavable by getting health from CharacterClass
        double enemyHealth = enemy.getHealth(); //creating enemy health variavable by getting health from CharacterClass

        System.out.println("\nYour jouney begins. But suddenly you are attacked by an Enemy theif. \nTheir stats are\n" + enemy);
        System.out.println("\nIt is time to fight!");

        //loop that makes the player and the enemy fight until one of their health values is 0
        while (playerHealth > 0 && enemyHealth > 0)
        {
            System.out.println("Select a skill (0, 1, 2):"); //player inputs what skill they want to use

            int pChoice = keyboard.nextInt(); //player choice variable created using Scanner
            keyboard.nextLine();
            while (pChoice != 0 && pChoice != 1 && pChoice != 2) //loop that makes sure player only uses available skill
            {
                System.out.println("Not an option");
                pChoice = keyboard.nextInt();
                keyboard.nextLine();
            }
        
            //creating a fight class variable by inputting all of player and enemy stats
            Fight battle = new Fight(playerHealth, player.getStrength(), player.getLuck(), player.getSkills(), enemyHealth, enemy.getStrength(), enemy.getLuck(), enemy.getSkills(), pChoice);
            System.out.println(battle);
            //setting player and enemy health to new value after a turn on fighting
            playerHealth = battle.getPlayerHealth(); 
            enemyHealth = battle.getEnemyHealth();
        }

        //prints player loses if they reach 0 health
        if (playerHealth == 0)
        {
            System.out.println("You lost the fight and died. This is where your jouney ends.");
        }
        //prints player wins if enemy health reaches 0
        else if (enemyHealth == 0)
        {
            System.out.println("You won the fight! Your jouney countinues and glory awaits the amazing " + charName + "!");
        }
        keyboard.close();
    }
}