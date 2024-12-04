  


/**
 * Details of your team
 * 
 * @author Aneesa Muhammed & Mithlesh Sukumar 
 * @version 01 Dec 2024
 */
public class Teamwork
{
    private String[] details = new String[6];
    
    public Teamwork()
    {   // In each line replace the contents of the String 
        // with the details of your team
        // It will help us if the surname of programmer1 comes
        // alphabetically before the surname of programmer2
        // If there is only 1 team member, please complete details 
        // for programmer1
        
        details[0] = "Chittethukudy Muhammed";
        details[1] = "Aneesa";
        details[2] = "23035252";
        details[3] = "Sukumar";
        details[4] = "Mithlesh";
        details[5] = "23033650";
    }
    
    public String[] getTeamDetails()
    {
        return details;
    }
    
    public void displayDetails()
    {
        for(String temp:details)
        {
            System.out.println(temp.toString());
        }
    }
}
        
