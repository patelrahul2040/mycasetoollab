import java.io.*;
import java.net.*;
import java.sql.*;
class messserver implements Runnable
{

      public void messServer()
       {
               Thread th=new Thread(this);
               th.start();
       } 
public void run()
  {
                String regis,amount1;
               String capitalizedSentence; 
      while(true)
           {
           
                try
              {
                       ServerSocket welcomeSocket = new ServerSocket(4002);
                       Socket connectionSocket;
                       connectionSocket= welcomeSocket.accept();

             
                       BufferedReader inFromClient=new BufferedReader(new InputStreamReader(connectionSocket.getInputStream()));                              
                       DataOutputStream outToClient=new  DataOutputStream(connectionSocket.getOutputStream()); 
                       System.out.println("\t......................Messserver login details.............................");
                       regis=inFromClient.readLine(); 
                       amount1=inFromClient.readLine();
                       System.out.println("Registration Id: " +regis);
                       System.out.println("Mess dish/charge: " +amount1);
                       int a=Integer.parseInt(amount1);                   
                       Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");  
                    

                       Connection con = DriverManager.getConnection("jdbc:odbc:coupons","","");

                       String sql1 = "select amount from extrafood WHERE registrationid= ?";
 
                       PreparedStatement prest = con.prepareStatement(sql1);

                       prest.setInt(1,Integer.parseInt(regis));

                       ResultSet rs=prest.executeQuery();  

       
                       rs.next();

                       int val=rs.getInt("amount");

               
                     if(val-a>0)  
                       {             
                            String sql = "UPDATE extrafood SET amount=amount-? WHERE registrationid= ?";
                            PreparedStatement prest1= con.prepareStatement(sql);
                            prest1.setInt(1,a);
                            prest1.setInt(2,Integer.parseInt(regis));
                            int up=prest1.executeUpdate();
                            System.out.println("Updating Successfully!");
                          if(up!=0)
                              {
                 
                                      outToClient.writeBytes("ok");
                                      outToClient.flush();
                             }
                          else
                             {
                                   outToClient.writeBytes("no"); 
                                   outToClient.flush(); 
                             }
                     }
                    else
                     {
                                 outToClient.writeBytes("in"); 
                                 outToClient.flush();
                    
                     }

          /*if(up!=0)
                    {
                
                                       outToClient.writeBytes("ok");
                                       outToClient.flush(); 
                      
                      }
                   else
                                 outToClient.writeBytes("no"); 
                                 outToClient.flush();*/
                    

                  con.close();
                 }catch(Exception e){}
         }   
 }
public static void main(String argv[]) throws Exception
      {
                messserver t1=new messserver();
                t1.messServer();
     }
}

