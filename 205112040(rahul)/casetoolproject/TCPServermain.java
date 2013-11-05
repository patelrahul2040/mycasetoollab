import java.io.*;
import java.net.*;
import java.sql.*;
class TCPServermain implements Runnable
{

  public void TCPServermain1()
      {
               Thread th=new Thread(this);
               th.start();
      } 
public void run()
  {
  	
          String dept,name,roll,amount;
           String capitalizedSentence;
           while(true)
           {
              try{
                      
                      ServerSocket welcomeSocket = new ServerSocket(4003);
                      Socket connectionSocket;
                      connectionSocket= welcomeSocket.accept();
                      BufferedReader inFromClient=new BufferedReader(new InputStreamReader(connectionSocket.getInputStream()));                              
                      DataOutputStream outToClient=new  DataOutputStream(connectionSocket.getOutputStream()); 
                      System.out.println("\t........Login details for ExtraFoods......... ");
   
                      roll=inFromClient.readLine(); 
                      dept=inFromClient.readLine();
                      name= inFromClient.readLine();
                      amount= inFromClient.readLine();

                      System.out.println(" User roll: " +roll);
                      System.out.println("department Password: " +dept);
                      System.out.println("name: " +name);
                      System.out.println("amount: " +amount);


               Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");  

                  Connection con = DriverManager.getConnection("jdbc:odbc:extrafood","","");

                     PreparedStatement stmt= con.prepareStatement("insert into extrafood(roll,dept,sname,amount,registrationid) values(?,?,?,?,?)");


                     stmt.setInt(1,Integer.parseInt(roll)); 
                     stmt.setString(2,dept); 
                     stmt.setString(3,name); 
                     stmt.setInt(4,Integer.parseInt(amount));
                     stmt.setInt(5,2*Integer.parseInt(roll)); 
                     int rs=stmt.executeUpdate();
                   


                     if(rs!=0)
                      {
                                   
                                   outToClient.writeBytes("ok");
                                   outToClient.flush();
                    
                      }
                   else
                                 outToClient.writeBytes("no"); 
                                 outToClient.flush();
                    con.close();
                 }catch(Exception e){}
         }   
 }
public static void main(String argv[]) throws Exception
        {
               TCPServermain t1=new TCPServermain();
               t1.TCPServermain1();

         
        }
    
}

