import java.util.*;
/**
 * Write a description of class MyTester here.
 * 
 * @author Aneesa Muhammed & Mithlesh Sukumar
 * @version 30th Nov 2024
 */
/*************************Task5*****************************/
public class MyTester 
{   
    WISH myResort = new Resort("space");
    
    private void doTest()
    {
        // Display all worlds and cards
        System.out.println("\n***** All Worlds and Cards *****");
        System.out.println("Expected: Details of all worlds and cards.");
        System.out.println(myResort.toString());
        
        System.out.println("\n\n***** this Test ends here *****");

        // Test findCard() - Positive and Negative
        System.out.println("\n***** Test: Find Card *****");
        int validCardId = 1001;
        int invalidCardId = 999;
        System.out.println("Expected: World name for card " + validCardId+" is Home");
        System.out.println("Result: " + myResort.findCard(validCardId));
        System.out.println("Expected: null for card " + invalidCardId);
        System.out.println("Result: " + myResort.findCard(invalidCardId));
        System.out.println("\n\n***** this Test ends here *****");

        // Test getWorldNumber() - Positive and Negative
        System.out.println("\n***** Test: Get World Number *****");
        String validWorldName = "Fantasia";
        String invalidWorldName = "Atlantis";
        System.out.println("Expected: World number for \"" + validWorldName + " is 3\".");
        System.out.println("Result: " + myResort.getWorldNumber(validWorldName));
        System.out.println("Expected: -1 for \"" + invalidWorldName + "\".");
        System.out.println("Result: " + myResort.getWorldNumber(invalidWorldName));
        System.out.println("\n***** this Test ends here *****");

        
        // Test canTravel() - Positive and Negative
        System.out.println("\n***** Test: Can Travel *****");
        int cardEligible = 1001;
        int cardIneligible = 1002; // Assume this card lacks sufficient bitcoins
        String validShuttle = "ABC1";
        String invalidShuttle = "BCD2";
        
        System.out.println("Expected: true for card " + cardEligible + " on shuttle " + validShuttle + ".");
        System.out.println("Result: " + myResort.canTravel(cardEligible, validShuttle));
        System.out.println("Expected: false for card " + cardIneligible + " on shuttle " + invalidShuttle + ".");
        System.out.println("Result: " + myResort.canTravel(cardIneligible, invalidShuttle));
        System.out.println("\n***** this Test ends here *****");

        // Test travel() - Positive and Negative
        System.out.println("\n***** Test: Shuttle Travel *****");
        int cardToMove = 1001;
        int cardBlocked = 1002; // Assume this card doesn't meet travel criteria
        String travelShuttle = "ABC1";
        String notravelShuttle = "BCD2";
        
        System.out.println("Expected: Successful travel message for card " + cardToMove + ".");
        System.out.println("Result: " + myResort.travel(cardToMove, travelShuttle));
        System.out.println("Expected: Failure message for card " + cardBlocked + ".");
        System.out.println("Result: " + myResort.travel(cardBlocked, notravelShuttle));
        System.out.println("\n***** this Test ends here *****");
        
        // Test getAllCardsOnOneWorld() - Positive and Negative
        System.out.println("\n***** Test: Get All Cards on a Specific World *****");
        String worldWithCards = "Sprite";
        String worldWithoutCards = "Solo"; // Assume Solo has no cards
        System.out.println("Expected: List of cards on \"" + worldWithCards + "\".");
        System.out.println("Result: " + myResort.getAllCardsOnOneWorld(worldWithCards));
        System.out.println("Expected: 'No cards' for \"" + worldWithoutCards + "\".");
        System.out.println("Result: " + myResort.getAllCardsOnOneWorld(worldWithoutCards));
        System.out.println("\n***** this Test ends here *****");


        // Test getCardDetails() - Positive and Negative
        System.out.println("\n***** Test: Get Card Details *****");
        int validCard = 1001;
        int invalidCard = 999;
        System.out.println("Expected: Details for card " + validCard + ".");
        System.out.println("Result: " + myResort.getCardDetails(validCard));
        System.out.println("Expected: 'No such card' for card " + invalidCard + ".");
        System.out.println("Result: " + myResort.getCardDetails(invalidCard));
        System.out.println("\n***** this Test ends here *****");

        // Test topUpBitcoins() - Positive and Negative
        System.out.println("\n***** Test: Top Up Bitcoins *****");
        int cardToTopUp = 1007;
        int invalidCardToTopUp = 999; // Assume this card ID doesn't exist
        System.out.println("Expected: Bitcoins added for card " + cardToTopUp + ".");
        myResort.topUpBitcoins(cardToTopUp, 10);
        System.out.println("Result: " + myResort.getCardDetails(cardToTopUp));
        System.out.println("Expected: No change for invalid card " + invalidCardToTopUp + ".");
        myResort.topUpBitcoins(invalidCardToTopUp, 10);
        System.out.println("Result: " + myResort.getCardDetails(invalidCardToTopUp));
        System.out.println("\n***** this Test ends here *****");

        // Test convertPoints() - Positive and Negative
        
    
        System.out.println("\n***** Test: Convert Points to Bitcoins *****");
        myResort.travel(1001,"CDE3");
        myResort.travel(1001,"JKL8");
        
        int cardToConvert = 1001;
        int invalidCardToConvert = 999; // Assume this card ID doesn't exist
        System.out.println("Expected: Points converted for card " + cardToConvert + ".");
        myResort.convertPoints(cardToConvert);
        System.out.println("Result: " + myResort.getCardDetails(cardToConvert));
        System.out.println("Expected: No change for invalid card " + invalidCardToConvert + ".");
        myResort.convertPoints(invalidCardToConvert);
        System.out.println("Result: " + myResort.getCardDetails(invalidCardToConvert));
        System.out.println("\n***** this Test ends here *****");
        
        // Test findCard() - Positive and Negative
        System.out.println("\n***** Test: Find Card *****");
        System.out.println("Expected: World name for card " + validCardId+" is Tropicana");
        System.out.println("Result: " + myResort.findCard(validCardId));
        System.out.println("Expected: null for card " + invalidCardId);
        System.out.println("Result: " + myResort.findCard(invalidCardId));
        System.out.println("\n***** this Test ends here *****");
   
        
        
        
    }
     
     
    
    public static void main(String[] args)
    {
        MyTester xx = new MyTester();
        xx.doTest();
    }
}
