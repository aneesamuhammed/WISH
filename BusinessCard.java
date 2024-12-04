/**
 * BusinessCard class represents a card for business travelers.
 * @author Aneesa Muhammed & Mithlesh sukumar 
 * @version 30th Nov 2024
 */
public class BusinessCard extends Card 
{
    private int freeDrinks = 10; // Start with 10 free drinks
    private int deductShuttle = 3;
    
    

    public BusinessCard(int cardNo, String name, int luxuryRating) 
    {
        super(cardNo, name, luxuryRating, 30); // 30 bitcoins by default
        
    }

    /**
     * Deducts one free drink whenever a shuttle journey is made.
     */
    public void deductFreeDrink() 
    {
        if (freeDrinks > 0) 
        {
            freeDrinks--;
        }
    }

    public int getFreeDrinks() 
    {
        return freeDrinks;
    }

    @Override
    public String toString() 
    {
        return super.toString() + ", Deduct per Shuttle: "+deductShuttle+", Free Drinks Remaining: " + freeDrinks;
    }
}
