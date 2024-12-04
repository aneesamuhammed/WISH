/**
 * A Card has an id number, name, a luxury rating , number of bitcoins, points.
 * 
 * @author Aneesa Muhammed & Mithilesh Sukumar 
 * @version 27th Nov 2024
 */
// Task 1.1
// class Card
public class Card 
{   
    /*****************************************************************/
    // Task 1.1.1 class card field defining here
    private int cardNo;
    private String cardName;
    private int luxuryRating;
    private int noOfBitcoins;
    private int points;
    
    /*****************************************************************/
    // Task 1.1.2 class card constructors
    // by param and default values
    public Card(int cNo, String cName)    
    {
        cardNo = cNo;
        cardName = cName;
        luxuryRating = 0;
        noOfBitcoins = 0;
        points =0;
    
    }
    
 
    public Card(int cNo, String cName, int Bcoins)    
    {
        cardNo = cNo;
        cardName = cName;
        luxuryRating = 0;
        noOfBitcoins = Bcoins;
        points =0;
        
    }
    
    // by params only
    public Card(int cNo, String cName, int lRating,int Bcoins)    
    {
        cardNo = cNo;
        cardName = cName;
        luxuryRating = lRating;
        noOfBitcoins = Bcoins;
        points =0;
        
    }
    
    //constructors ends here...
    
    /*****************************************************************/
    // Task 1.1.3 
    // accessors to return the Card id
    
    /** Returns the card number
     * @return card number
     */
    public int getcardNo()
    {
        return cardNo;
    }
    public String getcardName()
    {
        return cardName;
    }
    
    
    
    // accessors to return the luxury Rating
    
    /** Returns the luxury Rating
     * @return luxury Rating
     */
    public int getluxuryRating()
    {
        return luxuryRating;
    }
    
    // accessors to return the number of bitcoins
    
    /** Returns the number of bitcoins
     * @return number of bitcoins
     */
    public int getnoOfBitcoins()
    {
        return noOfBitcoins;
    }
    
    public int getpoints()
    {
        return points;
    }
    // accessors ends here
    
    /*****************************************************************/
    // Task 1.1.4
    // methods to add bitcoins
    /** add bitcoins by a value
     */
    public void addBitCoins(int addBitcoins)
    {
        noOfBitcoins = noOfBitcoins + addBitcoins;
    }
    
    // methods to deduct bitcoins
    /** deduct bitcoins by a value
     */
    public void deductBitCoins(int deductBitcoins)
    {
        noOfBitcoins = noOfBitcoins - deductBitcoins;
    }
    
    /*****************************************************************/
    // Task 1.1.5
    // method to update the card after taking a shuttle
    public void updateCardAfterShuttle(int shuttlecharge)
    {
        noOfBitcoins = noOfBitcoins - shuttlecharge;
        points += 1;
        
    }
    
    /*****************************************************************/
    // Task 1.1.6
    // a method returning boolean True,if the card has enough coins for a shuttle journey
    public boolean checkCardBalance(int shuttlecharge)
    {
        if(shuttlecharge <= noOfBitcoins)
        {
            return true;
        }
        else
            return false;
    }
    
    /*****************************************************************/
    // Task 1.1.7
    // a method to convert points to bitcoins
    public void convertPointstoBitcoins()
    {
        noOfBitcoins += points/3;
        points = points % 3;
        
    }
    
    /*****************************************************************/
    // Task 1.1.8
    // a toString() method returning a String with all relevant information about the Card
    public String toString()
    {
        String s;
        s = "    Card No: " + cardNo + "-" + cardName + ", Rating:  "+luxuryRating+", Bitcoins : " 
                               + noOfBitcoins +", points: " + points ;
        return s;
    }
    
    /*****************************************************************/
    // Setter for points
    public void setPoints(int pnts) 
    {
        points = pnts;  // Set the points to the provided value
    }
    
}

