import java.sql.*;

public class DatabaseTester
{
    public static void main(String[] args)
    {
        try
        {
            //1. Get a connection to database
            System.out.println("Connecting to database...");
            Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/testdb", "root", "password1");
            System.out.println("Connection successful! \n");

            //2. Create a statement
            Statement myStatement =  myConn.createStatement();
            //3. Execute a SQL query
            ResultSet myRs = myStatement.executeQuery("SELECT * FROM department");
            //4. Process the results set
            System.out.println("Department database table: \n");
            while (myRs.next())
            {
                System.out.println(myRs.getString("name") + " " + myRs.getString("position"));
            }


            //5. Adding new rows to database

            System.out.println("\nAdding new employee...");
            myStatement.execute("INSERT INTO department (id, name, position) " +
                                    "VALUES (5, 'John Ayonque', 'Professional Slacker')");
            System.out.println("Employee added! Displaying updated table:\n");

            myRs = myStatement.executeQuery("SELECT * FROM department");
            System.out.println("Department database table: \n");
            while (myRs.next())
            {
                System.out.println(myRs.getString("name") + " " + myRs.getString("position"));
            }


            //6. Deleting rows from database

            System.out.println("\nDeleting newest employee...");
            myStatement.executeUpdate("DELETE FROM department " +
                    "WHERE name = 'John Ayonque'");
            System.out.println("Deletion successful! Displaying updated table:\n");

            myRs = myStatement.executeQuery("SELECT * FROM department");
            System.out.println("Department database table: \n");
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
