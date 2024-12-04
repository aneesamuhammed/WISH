import java.util.*;
/**
 * An world is part of a WISH resort.Each world has a reference number, name, 
 * a luxury rating and a capacity which represents the maximum number of 
 * cards that can be on the world at any one time. Each world must 
 * maintain a list of all cards currently on that world. This list 
 * is updated whenever cards arrive or leave a world,so that it is always 
 * possible to say which cards are on the world and who they are.
 * 
 * @author Aneesa Muhammed & Mithlesh sukumar 
 * @version 27th Nov 2024
 */
// Task 2.1
// class world
public class World 
{
    /*****************************************************************/
    // Task 2.1.1 class world field defining here
    
    private int refNo;
    private String worldName;
    private int wluxuryRating;
    private int capacity;
    
    // Task 2.1.4
    // an ArrayList field to store Card object references
    private ArrayList<Card> cardList;
    
    /*****************************************************************/
    // Task 2.1.2 
    // constructor to create a world using suitable parameters
    public World(int wNo, String wName, int rating,int cap)    
    {
        refNo = wNo;
        worldName = wName;
        wluxuryRating = rating;
        capacity = cap;
        
        // Task 2.1.4
        // an ArrayList field to store Card object references
        cardList = new ArrayList<Card>();
    
    }
    
    //constructors ends here...
    
    /*****************************************************************/
    // Task 2.1.3
    // accessors
    // to return its world number
    public int getworldNo()
    {
        return refNo;
    }
    
    // to return its name
    public String getworldName()
    {
        return worldName;
    }
    
    // to return its luxury Rating
    public int getworldRating()
    {
        return wluxuryRating;
    }
    
    // to return its capacity
    public int getworldCapacity()
    {
        return capacity;
    }
    
    /*****************************************************************/
    // Task 2.1.5
    // mutator arrive()which has a Card as a parameter and adds it from the ArrayList
    public void arrive(Card c)
    {
       cardList.add(c);
    }
    
    /*****************************************************************/
    // Task 2.1.6
    // mutator leave()with a Card as a parameter, finds and removes the card in the ArrayList
    public void leave(Card c)
    {
        Card temp = findCardAtWorld(c.getcardNo());
        if (temp != null)
        {
            cardList.remove(temp);
        }
    }
    // defining findCardAtWorld
    public Card findCardAtWorld(int c)
    {
        for(int indx=0; indx<cardList.size(); indx++)
        {
            Card temp = cardList.get(indx);
            if (temp.getcardNo() == c)
            {
                return temp;
            }
        }
        return null; // not found
    }
    
    /*****************************************************************/
    // Task 2.1.7
    // an accessor which either says whether the world is full (reached capacity)
    public boolean isworldFull()
    {
        if (cardList.size() >= capacity)
        {
            return true;
        }
        else
        {
            return false;
        }
        
    }
    
    /*****************************************************************/
    // Task 2.1.8
    // an accessor to return details of one Card on the world given its ID as a parameter
    public String getCardDetailsById(int cId) 
    {
        for (Card card : cardList) 
        {
            if (card.getcardNo()==(cId)) 
            {
                return card.toString(); // Return the card's details
            }
        }
        return "No such card.";
    }
    
    /*****************************************************************/
    // Task 2.1.9
    // an accessor which returns a boolean saying whether a Card is on the world (in the ArrayList)
    public boolean isCardOnWorld(Card card) 
    {
        return cardList.contains(card);
    }
    /*****************************************************************/
    // Task 2.1.11
    
    /*****************************************************************/
    // Task 2.1.11
    // a toString () method which includes world details and a list of the Cards in the world
    public String toString()
    {
        String s;
        s = "\n World No: " + refNo + "-" + worldName + 
            ", luxury rating: "+wluxuryRating+
            ", capacity: " + capacity+
            "\n*****Cards in this World:*****\n"+
            getcardList();
        
        return s;
        
    }
    public String getcardList()
    {
        String ss = "";
        if (cardList.size() >0)
        {
            for(Card temp: cardList)
            {
                ss = ss + "\n" + temp.toString();
            }
            return ss + "\n*******************************";
        }
        return "\nNo cards" + "\n*******************************" ;
    }
    
    public ArrayList<Card> getCards() 
    {
        return cardList;
    }
}
