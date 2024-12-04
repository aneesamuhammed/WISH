
/**
 * @author Aneesa Muhammed & Mithlesh Sukumar
 * @version 27th Nov 2024
 */
// Task 1.2
// class CardTester
public class CardTester 
{
    public static void main(String[] args) 
    {   
        /*****************************************************************/
        // Task 1.2.1
        // create some suitable Card objects
        Card card1 = new Card(2001, "Alice");
        Card card2 = new Card(2002, "Bob", 20);
        Card card3 = new Card(2003, "choice", 4, 15);
        
        /*****************************************************************/
        // Task 1.2.2
        // Calling its methods
        // calling getcardNo()
        System.out.println("==========================");
        System.out.println("calling getcardNo()");
        System.out.println("Expected:   2001");
        System.out.println("Actual:     "+card1.getcardNo());
        
        // calling getluxuryRating()
        System.out.println("==========================");
        System.out.println("calling getluxuryRating()");
        System.out.println("Expected:   4");
        System.out.println("Actual:     "+card3.getluxuryRating());
        
        // calling getnoOfBitcoins()
        System.out.println("==========================");
        System.out.println("calling getnoOfBitcoins()");
        System.out.println("Expected:   20");
        System.out.println("Actual:     "+card2.getnoOfBitcoins());
        
        // calling addBitCoins()
        System.out.println("==========================");
        System.out.println("calling addBitCoins()");
        System.out.println("Expected:   10");
        card1.addBitCoins(10);
        System.out.println("Actual:     "+card1.getnoOfBitcoins());
        
        // calling deductBitCoins()
        System.out.println("==========================");
        System.out.println("calling deductBitCoins()");
        System.out.println("Expected:   5");
        card3.deductBitCoins(10);
        System.out.println("Actual:     "+card3.getnoOfBitcoins());
        
        // calling UpdateCardAfterShuttle()
        System.out.println("==========================");
        System.out.println("calling UpdateCardAfterShuttle()");
        System.out.println("Expected:   1");
        card3.deductBitCoins(4);
        System.out.println("Actual:     "+card3.getnoOfBitcoins());
        
        // calling checkCardBalance()
        System.out.println("==========================");
        System.out.println("calling checkCardBalance()");
        System.out.println("Expected:   true");
        System.out.println("Actual:     "+card1.checkCardBalance(4));
        System.out.println("Expected:   false");
        System.out.println("Actual:     "+card1.checkCardBalance(12));
        
        
        // calling toString()
        System.out.println("==========================");
        System.out.println("calling toString()");
        System.out.println("Expected:  \n   Card No: 2001  Alice \n   luxury rating:  0\n   Bitcoins : 10\n   points: 0");
        System.out.println("Actual:     "+card1.toString());
        
        
    }
    
}
    