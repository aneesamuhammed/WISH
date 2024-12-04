import java.util.*;

/**This class implements the WISH interface
 *
 * @author A.A.Marczyk 
 * @edited by Aneesa Muhammed & Mithlesh Sukumar
 * @version 01/11/24
 * @updated on 28th Nov 2024
 **/
 /******* Task 3.1 *******/
public class Resort implements WISH
{
    /******* Task 3.2 *******/
    /******* Task 3.2.1 *******/
    private String location; // Location of the resort
    
    /******* Task 3.2.2 *******/
    private ArrayList<World> worlds = new ArrayList<World>(); // List of all worlds, with "Home" at index 0
    private ArrayList<Card> cards = new ArrayList<Card>(); // List of all registered cards
    private ArrayList<Shuttle> shuttles = new ArrayList<Shuttle>(); // List of all shuttles

    /** constructor
     * @param loc - the location of the resort
     */
    /******* Task 3.3 *******/
    public Resort(String loc) 
    {
        /******* Task 3.3.1 *******/
        location = loc;
        
        
        // Invoke private methods to load data
        /******* Task 3.3.2 *******/
        loadWorlds(); // Load all worlds, including the "Home" world
        loadCards();  // Create and add all cards to the "Home" world
        setUpShuttles(); // Create and add all shuttles

        /******************************/
        /******* Task 3.2.3 *******/
        World homeWorld = worlds.get(0); // "Home" world is always at index 0
        /******* Task 3.3.3 *******/
        for (Card card : cards) 
        {
            homeWorld.arrive(card);
        }
        /******************************/
    }
    
    /**
     * Returns all of the details of all worlds including the cards
     * currently on each world, on "No cards"
     * @return all of the details of all worlds including location 
     * and all cards currently on each world, or "No cards" 
     */
    public String toString()
    {
        // Iterate over all worlds
        String result = "";
            for (World world : worlds) 
                {
                    result += "\n World: " + world.getworldName() // Append world name
                    + ", Rating: " + world.getworldRating() // Append world rating
                    + ", Capacity: " + world.getworldCapacity() // Append world capacity
                    + "\n";
                    
                    // Get the list of cards in this world
                    List<Card> worldCards = world.getCards(); 
                    
                    // Check if the world has cards
                    if (worldCards.isEmpty()) 
                    {
                        result += "   No cards\n"; // If no cards, append "No cards"
                    } 
                    else 
                    {
                        // Iterate over cards on the world and append their details
                        for (Card card : worldCards) 
                        {// Check the type of card and append specific details
                            if (card instanceof TouristCard) 
                            {
                                TouristCard touristCard = (TouristCard) card;
                                result += touristCard.toString()+"\n"; // Append citizenship
                            } 
                            else 
                            if (card instanceof BusinessCard) 
                            {
                                BusinessCard businessCard = (BusinessCard) card;
                                result += businessCard.toString()+"\n"; // Append free drinks remaining
                            } 
                            else 
                            if (card instanceof StaffCard) 
                            {
                                StaffCard staffCard = (StaffCard) card;
                                result += staffCard.toString()+"\n"; 
                            }
                            else

                            
                                result += card.toString()+"\n";
                                    
                        }
                    }
                }

        return result; // Return the constructed string

    }

    
    /**Returns the name of the world which contains the specified card or null
     * @param tr - the specified card
     * @return the name of the World which contains the card, or null
     **/
    public String findCard(int tr)
    {
            // Iterate over all worlds
            for (World world : worlds) 
            {
                List<Card> worldCards = world.getCards();
                // Iterate over all cards in the current world
                for (Card card : worldCards) 
                {
                    // Check if the card ID matches the specified one
                    if (card.getcardNo() == tr) 
                    {
                        return "card "+tr+" is in "+world.getworldName(); // Return the name of the world if found
                    }
                }
            }
            return null;
    }
    
    /** Given the name of a world, returns the world id number
     * or -1 if world does not exist
     * @param name of world
     * @return id number of world
     */
    public int getWorldNumber(String ww)
    {
        for (World world : worlds) 
        {
            // Check if the world name matches the specified name
            if (world.getworldName().equals(ww)) 
            {
                return world.getworldNo(); // Return the world number (assuming World has a getNumber() method)
            }
        }
        return -1;
    }
                
    /**Returns a String representation of all the cards on specified world
     * @return a String representation of all cards on specified world
     **/
    public String getAllCardsOnOneWorld(String world)
    {
            // Find the world by name
            World targetWorld = getWorld(world); 
        
            // If world is not found, return null or an error message
            if (targetWorld == null) 
            {
                return " World not found";
            }
    
            // Get the list of cards on the target world
            List<Card> cardsOnWorld = targetWorld.getCards();
    
            // If no cards are present, return "No cards"
            if (cardsOnWorld.isEmpty()) 
            {
                return " No cards";
            }
    
            // Build the string representation of the cards using string concatenation (+)
            String result = "";
            
                for (Card card : cardsOnWorld) 
                    {
                         result += "Card ID: " + card.getcardNo() // Append card ID
                         + ", Name: " + card.getcardName() // Append card Name
                         + ", Rating: " + card.getluxuryRating() // Append card Rating
                         + ", Bitcoins: " + card.getnoOfBitcoins() // Append card Bitcoins
                         + "\n"; // New line after each card's details
                    }
    
            return result; // Return the string representation of the cards

    } 

    /******* Task 3.4 *******/
     /**Returns true if a Card is allowed to move using the shuttle, false otherwise
     * A move can be made if:  
     * the rating of the card  >= the rating of the destination world
     * AND the destination world is not full
     * AND the card has sufficient credits
     * AND the card is currently in the source world
     * AND the card id is for a card on the system
     * AND the shuttle code is the code for a shuttle on the system
     * @param trId is the id of the card requesting the move
     * @param shtlCode is the code of the shuttle journey by which the card wants to pCardel
     * @return true if the card is allowed on the shuttle journey, false otherwise 
     **/
     
    /******* Task 3.4.2 *******/
    public boolean canTravel(int trId, String shtlCode)
    {   //other checks optional
        // Find the card by its ID
        Card card = null;
        for (Card c : cards) 
        {
            if (c.getcardNo() == trId) 
            {
                card = c;
                break;
            }
            
            
        }
        
        if (card == null) 
            {
                System.out.println("   Card not found");
                return false; // Return false since the card wasn't found
            }
        
        
        
        // Find the shuttle by its code
        Shuttle shuttle = null;
        for (Shuttle s : shuttles) 
        {
            if (s.getJourneyCode().equals(shtlCode)) 
            {
                shuttle = s;
                break;
            }
            
        }
        if (shuttle==null)
            {
                System.out.println("   shuttle not found");
                return false;
                
            }
    
        
        
        // Get source and destination worlds from the shuttle
        World sourceWorld = shuttle.getSourceWorld();
        World destinationWorld = shuttle.getDestinationWorld();
        if (card instanceof StaffCard)
        {
        if (sourceWorld.isCardOnWorld(card) &&                               // Card is in the source world
            card.getluxuryRating() >= destinationWorld.getworldRating() &&        // Card's luxury rating is sufficient
            !destinationWorld.isworldFull())
            { 
                return true;
            }
        }
        
        if (sourceWorld.isCardOnWorld(card) &&                               // Card is in the source world
            card.getluxuryRating() >= destinationWorld.getworldRating() &&        // Card's luxury rating is sufficient
            !destinationWorld.isworldFull() &&                              // Destination world is not full
            card.getnoOfBitcoins() >= shuttle.getjourneycost())
            {
                return true;
            }
        return false;
        
    }     

    /**Returns the result of a card requesting to move by Shuttle.
     * A move will be successful if:  
     * the luxury rating of the card  >= the luxury rating of the destination world
     * AND the destination world is not full
     * AND the card has sufficient credits
     * AND the card is currently in the source world
     * AND the card id is for a card on the system
     * AND the shuttle code is the code for a shuttle on the system
     * If the shuttle journey can be made, the card information is removed from the source
     * world, added to the destination world and a suitable message returned.
     * 
     * If shuttle journey cannot be made, the state of the system remains unchanged
     * and a message specifying the reason is returned.
     * 
     * @param pCardId is the id of the card requesting the move
     * @param shtlCode is the code of the shuttle journey by which the card wants to pCardel
     * @return a String giving the result of the request 
     **/
     
     /******* Task 3.4.1 *******/
    public String travel(int pCardId, String shtlCode )
    {   //other checks optional
        // Find the card by its ID
        Card card = null;
        for (Card c : cards) 
        {
            if (c.getcardNo() == pCardId) 
            {
                card = c;
                break;
            }
            
            
        }
        
        if (card == null) 
            {
                System.out.println("   Card not found");
                 // Return false since the card wasn't found
            }
        
        
        
        // Find the shuttle by its code
        Shuttle shuttle = null;
        for (Shuttle s : shuttles) 
        {
            if (s.getJourneyCode().equals(shtlCode)) 
            {
                shuttle = s;
                break;
            }
            
        }
        if (shuttle==null)
            {
                System.out.println(" shuttle not found");

                
            }
        // Get source and destination worlds from the shuttle
        World sourceWorld = shuttle.getSourceWorld();
        World destinationWorld = shuttle.getDestinationWorld();
        
        if (card instanceof StaffCard)
        {
        if (sourceWorld.isCardOnWorld(card) &&                               // Card is in the source world
            card.getluxuryRating() >= destinationWorld.getworldRating() &&        // Card's luxury rating is sufficient
            !destinationWorld.isworldFull())                              // Destination world is not full

        
                            {
                                sourceWorld.leave(card);
                                destinationWorld.arrive(card);
                                card.updateCardAfterShuttle(0);
                                return "Card " + card.getcardName() + " successfully traveled from " + 
                                sourceWorld.getworldName() + " to " + destinationWorld.getworldName() + 
                                " via shuttle " + shtlCode + ".";
                            }
                        }
        if (sourceWorld.isCardOnWorld(card) &&                               // Card is in the source world
            card.getluxuryRating() >= destinationWorld.getworldRating() &&        // Card's luxury rating is sufficient
            !destinationWorld.isworldFull() &&                              // Destination world is not full
            card.getnoOfBitcoins() >= shuttle.getjourneycost()) 
            // Card has enough credits
        {   
                
                // Perform the move
                sourceWorld.leave(card);
                destinationWorld.arrive(card);
                if (card instanceof StaffCard) 
                            {
                                card.updateCardAfterShuttle(0);
                            } 
                            else 
                            if (card instanceof BusinessCard) 
                            {
                                card.updateCardAfterShuttle(3);
                                BusinessCard businessCard = (BusinessCard) card;
                                businessCard.deductFreeDrink();
                                
                            } 
                            else
                            card.updateCardAfterShuttle(4);
                 // Deduct journey cost from the card
        
                return "Card " + card.getcardName() + " successfully traveled from " + 
                       sourceWorld.getworldName() + " to " + destinationWorld.getworldName() + 
                       " via shuttle " + shtlCode + ".";
        }
        // Return specific failure reasons if conditions are not met
        if (!sourceWorld.isCardOnWorld(card)) 
        {
            return " Card is not currently in the source world.";
        }
        if (card.getluxuryRating() < destinationWorld.getworldRating()) 
        {
            return " Card luxury rating is insufficient for the destination world.";
        }
        if (destinationWorld.isworldFull()) 
        {
            return " Destination world is full.";
        }
        if (card.getnoOfBitcoins() < shuttle.getjourneycost()) 
        {
            return " Card does not have sufficient credits for the journey.";
        }

        return " Travel failed due to unknown reasons.";

    } 
         
    /** 
     * returns details of a card, or "No such card" 
     */
    public String getCardDetails(int id)
    {
        String cardDetails = null;
        // Loop through all worlds in the resort
        for (World world : worlds) 
        { 
            List<Card> worldCards = world.getCards();
            for(Card card : worldCards)
            {
                if(card.getcardNo()==id)
                {
                    cardDetails = card.toString();
                    return cardDetails+", World : "+world.getworldName();
                }
            }
            
        }
        
        // If the card is not found in any world, return "No such card"
        return "   No such card";
    }
    

    /** Allows a card to top up their bitcoins.This method is not concerned with 
     *  the cost of a bitcoin as currency and prices may vary between resorts.
     *  @param id the id of the card toping up their bitcoins
     *  @param coins the number of bitcoins to be added to card 
     */
    public void topUpBitcoins(int id, int coins)
    {
        // Loop through all worlds in the resort
        for (World world : worlds) 
        {
            // For each world, try to find the card with the given ID
            Card card = world.findCardAtWorld(id);
            
            if (card != null) 
            {
                // If the card is found, top up its bitcoins by the specified amount
                card.addBitCoins(coins);
                return ;
            }
            return ;
        }
    
    
    }
   
    /** Allows the points on a card to be converted to bitCoins (3 points = 1 bitcoin)
     *  @param id the id of the card converting their points
     */
    public void convertPoints(int id)
    {
        // Loop through all worlds in the resort to find the card
        for (World world : worlds) 
        {
            // Try to find the card in the world
            Card card = world.findCardAtWorld(id);
            
            if (card != null) 
            {
                // Calculate how many bitcoins the card gets by converting points
                int points = card.getpoints();  // Get the current points on the card
                int bitcoinsToAdd = points / 3;  // Convert points to bitcoins (3 points = 1 bitcoin)
                  // Remaining points (less than 3)
    
                // Add bitcoins to the card
                card.addBitCoins(bitcoinsToAdd);
                int remainingPoints = points % 3;
                card.setPoints(remainingPoints);  // Update the card's points (keep the remainder)
                
                return;
            }
        }
    }
    /***************private methods**************/
    /*******Task 3.3.2 Contd...*****/
    private void loadWorlds()
    {   
        worlds.add(new World(0,"Home", 0, 1000));       // World 0
        worlds.add(new World(1,"Sprite", 1, 100));      // World 1
        worlds.add(new World(2,"Tropicana", 3, 10));    // World 2
        worlds.add(new World(3,"Fantasia", 5, 2));      // World 3
        worlds.add(new World(4,"Solo", 1, 1));          // World 4

       
    }
    
    private void setUpShuttles()
    {   
        // Add shuttles with their respective journey codes and source/destination worlds
        shuttles.add(new Shuttle("ABC1", worlds.get(0), worlds.get(1))); // Home -> Sprite
        shuttles.add(new Shuttle("BCD2", worlds.get(1), worlds.get(0))); // Sprite -> Home
        shuttles.add(new Shuttle("CDE3", worlds.get(1), worlds.get(2))); // Sprite -> Tropicana
        shuttles.add(new Shuttle("DEF4", worlds.get(2), worlds.get(1))); // Tropicana -> Sprite
        shuttles.add(new Shuttle("EFG5", worlds.get(3), worlds.get(1))); // Fantasia -> Sprite
        shuttles.add(new Shuttle("GHJ6", worlds.get(1), worlds.get(4))); // Sprite -> Solo
        shuttles.add(new Shuttle("HJK7", worlds.get(4), worlds.get(1))); // Solo -> Sprite
        shuttles.add(new Shuttle("JKL8", worlds.get(2), worlds.get(3))); // Tropicana -> Fantasia
    }
    
    private void loadCards()
    {
        // Add cards with their respective details
        cards.add(new Card(1000, "Lynn", 5, 10));
        cards.add(new Card(1001, "May", 3, 20));
        cards.add(new Card(1002, "Nils", 10, 20));
        cards.add(new Card(1003, "Olek", 2, 12));
        cards.add(new Card(1004, "Pan", 3, 3));
        cards.add(new Card(1005, "Quin", 1, 5));
        cards.add(new Card(1006, "Raj", 10, 6));
        cards.add(new Card(1007, "Sol", 7, 20));
        cards.add(new Card(1008, "Tel", 6, 24));
        cards.add(new Card(1009, "Zan", 9, 50));
        
        //adding subclass cards
        cards.add(new TouristCard(1010, "Una", 5, 10, "Earth"));
        cards.add(new BusinessCard(1011, "Val", 3));
        cards.add(new StaffCard(1012, "Wei", 12345, "Pilot"));
        

       
    }
 
    /******* Task 3.5 *******/
    /** Returns the card with the card id specified by the parameter
     * @return the card with the specified id
     **/
     /******* Task 3.5.1 *******/
    private Card getCard(int id)
    {
        for (int i = 0; i < cards.size(); i++)
        {
            Card temp = cards.get(i);
            if (temp.getcardNo() == id) 
            {
                return temp; // Return the card if the id matches
            }
        }
        return null;
        
    }
    
    
    /** Returns the world with the name specified by the parameter
     * @return the world with the specified name
     **/
     /******* Task 3.5.2 *******/
    private World getWorld(String worldName)
    {
       
        for (World world : worlds) 
        {
            if (world.getworldName().equals(worldName)) 
            {
                return world; // Return the world if the name matches (case-insensitive)
            }
        }
        return null;
    }
    
    /** Returns the world with the name specified by the parameter
     * @return the world with the specified name
     **/
     /******* Task 3.5.3 *******/
    private Shuttle getShuttle(String shut)
    {
        for (Shuttle shuttle : shuttles) 
        {
            if (shuttle.getJourneyCode().equals(shut)) 
            {
                return shuttle; // Return the shuttle if the journey code matches
            }
        }
        return null;
    }
    
    
    
    public ArrayList<World> getWorlds() 
    {
        return worlds; // Return the list of worlds
    }
}