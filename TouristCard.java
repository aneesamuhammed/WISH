/**
 * TouristCard class represents a card for tourists.
 * @author Aneesa Muhammed & Mithlesh sukumar 
 * @version 30th Nov 2024
 */
public class TouristCard extends Card 
{
    private String citizenship; // Planet they come from
    private int deductShuttle = 4;

    public TouristCard(int cardNo, String name, int luxuryRating, int bitcoins, String citizenship) 
    {
        super(cardNo, name, luxuryRating, bitcoins);
        this.citizenship = citizenship;
        
        
    }
    public String getcit()
    {
        return citizenship;
    }

    @Override
    public String toString() 
    {
        return super.toString()+" Citizenship: "+getcit();
    }
}
