import java.util.*;
/**
 * Write a description of class ResortUI here.
 * 
 * @author Aneesa Muhammed & Mithlesh Sukumar 
 * @version 29th Nov 2024
 */

/************* Task 4 *************/
public class ResortUI
{
    
    private Scanner reader = new Scanner(System.in);
    private WISH wayward = new Resort("Wayward Worlds");
    
    private void runUI()
    {   

        int choice = getOption();        
        while (choice != 0)
        {            
            // process choice
            if      (choice == 1){listAllWorlds();}
            else if (choice == 2){listOneWorld();}
            else if (choice == 3){findACard();}
            else if (choice == 4){tryTravel();}
            else if (choice == 5){travelNow();}
            else if (choice == 6){getCard();}
            else if (choice == 7){updateCoins();}
            else if (choice == 8){convertPoints();}
            // output menu & get choice
            choice = getOption();
        }
        System.out.println("\nThank-you");
    }
    
    
    private int getOption()
    {
        
       System.out.println("\n************************* WELCOME TO WISH *************************\n");
       System.out.println("What would you like to do ?");
       System.out.println("0. Quit");
       System.out.println("1. List all world details including cards");
       System.out.println("2. List all cards on one world");
       System.out.println("3. Find a card on a world");
       System.out.println("4. Say if card can travel by shuttle");
       System.out.println("5. Move a card by shuttle");
       System.out.println("6. Get card details");
       System.out.println("7. Top up bitcoins");
       System.out.println("8. Convert points");

       System.out.println("\nEnter your choice");
       // read choice
       int option = reader.nextInt();
       reader.nextLine();
       return option;
    }
    
    // provide the code here
    /*************added*************/
    private void listAllWorlds()
    {
       System.out.println(wayward.toString());
    }
    
   
    // This one has been done for you 
    private void listOneWorld()
    {
        System.out.println("Enter name of world");
        String ww = reader.nextLine();
        System.out.println(wayward.getAllCardsOnOneWorld(ww));
    }
    
    // provide the code here
    /*************added*************/
    private void findACard()
    {
        System.out.println("Enter number of card");
        int cc = reader.nextInt();
        System.out.println(wayward.findCard(cc));
    
    }
    
    // This one has been done for you 
    private void tryTravel()
    {
        System.out.println("Enter card id");
        int trav = reader.nextInt();
        reader.nextLine();
        System.out.println("Enter shuttle code");
        String shuttle = reader.nextLine();
        System.out.println(wayward.canTravel(trav,shuttle));
    }
    
    // Provide the code here
    /*************added*************/
    private void travelNow()
    {
        System.out.println("Enter card id");
        int trav = reader.nextInt();
        reader.nextLine();
        System.out.println("Enter shuttle code");
        String shuttle = reader.nextLine();
        System.out.println(wayward.travel(trav,shuttle));
        
    }
    
    
    // this one has been done for you
    private void getCard()
    {
        System.out.println("Enter card id");
        int trav = reader.nextInt();
        
        System.out.println(wayward.getCardDetails(trav));
    }
    private void getCard(int cb)
    {
        
        
        System.out.println(wayward.getCardDetails(cb));
    }
    
    
    // provide the code here
    /*************added*************/
    private void updateCoins()
    {
        System.out.println("Enter card id");
        int cc = reader.nextInt();
        reader.nextLine();
        System.out.println("Enter number of coins to be added to card "+cc);
        int bc = reader.nextInt();
        // Call topUpBitcoins() to add coins to the card
        wayward.topUpBitcoins(cc, bc);
    
        // Print confirmation message after topping up the bitcoins
        System.out.println("Successfully added " + bc + " bitcoins to card " + cc + ". ");
        
        
    }
    
    // provide the code here
    /*************added*************/
    private void convertPoints()
    {
        System.out.println("Enter card id");
        int trav = reader.nextInt();
        
        
        
            wayward.convertPoints(trav);
            System.out.println("Available Points converted to bitcoins for card "+trav+" successfully!");
            getCard(trav);
        
    
    }
   
    
    public static void main(String[] args)
    {
        ResortUI xx = new ResortUI();
        xx.runUI();
    }
}
