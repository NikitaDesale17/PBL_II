import java.sql.*;
class ConnTest
{
public static void main(String args[])
{
   try
   {
      Class.forName("oracle.jdbc.driver.OracleDriver");
      System.out.println("Driver Loaded");

       try (Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","system")) {
           System.out.println("connection to database created");
       }
   }
   catch(ClassNotFoundException e)
   {
      System.out.println("Driver not loaded");
   }
   catch(SQLException e)
   {
      System.out.println("Connection not established");
   }
}
}
