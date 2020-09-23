import java.sql.*;

public class DatabaseTester
{
    public static void main(String[] args)
    {
        try
        {
            //1. Get a connection to database
            Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/testdb", "root", "password1");
            //2. Create a statement
            Statement myStatement =  myConn.createStatement();
            //3. Execute a SQL query
            ResultSet myRs = myStatement.executeQuery("SELECT * FROM department");
            //4. Process the results set
            while (myRs.next())
            {
                System.out.println(myRs.getString("name") + " " + myRs.getString("position"));
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
