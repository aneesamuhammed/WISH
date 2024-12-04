
/**
 * interface WISH specifies requirements for 7COM1015 (Sem A) 2024
 * 
 * @author A.Marczyk 
 * @version 01/11/24
 */
public interface WISH
{
    /**
     * Returns the location and all  details of all worlds including the cards
     * currently on each world, or "No cards"
     * @return location and details of all worlds including location 
     * and all cards currently on each world, or "No cards" 
     */
    public String toString();
    
    
    /**Returns the name of the world which contains the specified card or null
     * @param tr - the specified card
     * @return the name of the World which contains the card, or null
     **/
    public String findCard(int tr);
    
    
    /** Given the name of a world, returns the world id number
     * or -1 if world does not exist
     * @param name of world
     * @return id number of world
     */
    public int getWorldNumber(String ww);
    
                
    /**Returns a String representation of all the cards on specified world
     * @return a String representation of all cards on specified world
     **/
    public String getAllCardsOnOneWorld(String world);
  
    
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
    public boolean canTravel(int trId, String shtlCode);
    

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
    public String travel(int cardId, String shtlCode );
    
    /** 
     * returns details of a card or "No such card" 
     */
    public String getCardDetails(int id);
  
      
    /** Allows a card to top up their bitcoins.This method is not concerned with 
     *  the cost of a bitcoin as currency and prices may vary between resorts.
     *  @param id the id of the card toping up their bitcoins
     *  @param coins the number of bitcoins to be added to card information
     */
    public void topUpBitcoins(int id, int coins);
    
    /** Allows the points on a card to be converted to bitCoins (3 points = 1 bitcoin)
     *  @param id the id of the card converting its points
     */
    public void convertPoints(int id);
    
   
}
