
/**
 * A shuttle provides a one-way connection between two worlds. It
 * has a Shuttle code and information about both the source and
 * the destination world
 * 
 * @author Aneesa Muhammed & Mithlesh Sukumar 
 * @version 28th Nov 2024
 */

// Task 2.2
// class Shuttle
public class Shuttle
{
    /*****************************************************************/
    // Task 2.2.1
    // class Shuttle variables
    private String journeyCode;
    private int journeycost;
    private World sourceWorld;
    private World destinationWorld;
    
    /*****************************************************************/
    // Task 2.2.2
    // a small range of accessors/mutators to process data held by the class
    // constructor
    public Shuttle(String jCode, World sWorld, World dWorld) 
    {
        journeyCode = jCode;
        journeycost = 4;
        sourceWorld = sWorld;
        destinationWorld = dWorld;
    }
    public Shuttle(String jCode, int jcost, World sWorld, World dWorld) 
    {
        journeyCode = jCode;
        journeycost = jcost;
        sourceWorld = sWorld;
        destinationWorld = dWorld;
    }
    
    // accessors
    public String getJourneyCode() 
    {
        return journeyCode;
    }
    
    public int getjourneycost() 
    {
        return journeycost;
    }

    public World getSourceWorld() 
    {
        return sourceWorld;
    }

    public World getDestinationWorld() 
    {
        return destinationWorld;
    }
    
    // mutators
    public void setJourneyCode(String jCode) 
    {
        journeyCode = jCode;
    }

    public void setSourceWorld(World sWorld) 
    {
        sourceWorld = sWorld;
    }

    public void setDestinationWorld(World dWorld) 
    {
        destinationWorld = dWorld;
    }
    
    /*****************************************************************/
    // Task 2.2.3
    // method which returns a boolean saying whether a card 
    //given as a parameter can enter the shuttle
    public boolean processJourneyRequest(Card card)
    {
        
        if ((card == null) || (!sourceWorld.isCardOnWorld(card)) || (card.getluxuryRating() < destinationWorld.getworldRating()) || (destinationWorld.isworldFull()) || (card.getnoOfBitcoins() < journeycost))
            {
            return false;
            }
        else
        
        return true;
    }
    
    /*****************************************************************/
    // Task 2.2.4
    // a method to process a card moving to the destination world
    public String processCardMovement(Card card) 
    {   
        /*****************************************/
        // Task 2.2.4.2
        // if it does not meet one of the conditions
        // Check if the card exists
        if (card == null) 
        {
        return "Error: Card does not exist.";
        }
        
        // Determine the specific reason for failure
        if (!sourceWorld.isCardOnWorld(card)) 
        {
            return "Refused: Card is not in the source world.";
        }
        
        if (card.getluxuryRating() < destinationWorld.getworldRating()) 
        {
            return "Refused: Card's luxury rating is too low for the destination world.";
        }
        
        if (destinationWorld.isworldFull())
        {
            return "Refused: Destination world is at full capacity.";
        }
        
        if (card.getnoOfBitcoins() < journeycost) 
        {
            return "Refused: Card does not have enough bitcoins for the journey.";
        }
        
        /*****************************************/
        // Task 2.2.4.1
        // if the card meets the conditions
        sourceWorld.leave(card); // Remove card from source world
        destinationWorld.arrive(card); // Add card to destination world 
        card.updateCardAfterShuttle(journeycost);// Add 1 point to the card & Deduct journey cost
        return "Journey successful: Card has traveled to the destination world.";

    }
    
    /*****************************************************************/
    // Task 2.2.4
    // tostring method
    public String toString() 
    {
    return "\n Shuttle \n Journey Code: " + journeyCode +
           "\n Source: " + sourceWorld.getworldNo() +  " - "+ sourceWorld.getworldName() +
           "\n Destination: " + destinationWorld.getworldNo() + " - " + destinationWorld.getworldName() + 
           "\n Cost: " + journeycost + " bitcoins.";
    }
    
    
}
