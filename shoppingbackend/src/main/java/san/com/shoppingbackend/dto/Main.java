package san.com.shoppingbackend.dto;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Scanner;

class Main 
{ 
    public static void main(String a[]) 
    { 
        //Creating the connection 
        String url = "jdbc:postgresql://127.0.0.1:5432/myProjects";
        
        String user = "postgres"; 
        String pass = "root"; 
  
        //Entering the data 
        //Inserting data using SQL query 
        Connection con=null; 
        try
        { 
            DriverManager.registerDriver(new org.postgresql.Driver()); 
            //Inserting data using SQL query 
            String sql = "insert into public.category values(1,'sandeep','ss','ss',true)"; 
            //Reference to connection interface 
            con = DriverManager.getConnection(url,user,pass); 
            Statement st = con.createStatement(); 
            int m = st.executeUpdate(sql); 
            if (m == 1) 
                System.out.println("inserted successfully : "+sql); 
            else
                System.out.println("insertion failed"); 
  System.out.println(con);
            con.close(); 
        } 
        catch(Exception ex) 
        { 
            System.err.println(ex); 
        } 
    }
    }