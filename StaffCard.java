/**
 * StaffCard class represents a card for staff members.
 * @author Aneesa Muhammed & Mithlesh sukumar 
 * @version 30th Nov 2024
 */
public class StaffCard extends Card 
{
    
    private int journeyScore = 0; // Tracks the number of shuttle journeys
    private int deductShuttle = 0;
    private int employeeNumber;
    private String jobDescription;
    
    public StaffCard(int cardNo, String name, int employeeNumber, String jobDescription) 
    {
        super(cardNo, name, 10, 0); // Highest luxury rating of 10, 0 bitcoins
        deductShuttle = 0;
        this.employeeNumber = employeeNumber;
        this.jobDescription = jobDescription;
    }

    /**
     * Increments the journey score whenever a shuttle journey is made.
     */
    public void incrementJourneyScore() 
    {
        journeyScore++;
    }

    public int getJourneyScore() 
    {
        return journeyScore;
    }

    @Override
    public String toString() 
    {
        return super.toString() + ", Emp no : "+employeeNumber+", Dept : "+jobDescription+", Deduct per Shuttle: "+deductShuttle+", Journey Score: " + journeyScore+"\n";
    }
}
