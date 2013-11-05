import java.io.*;
import java.net.*;
import java.sql.*;
class loginserver implements Runnable
{
   public void loginserverfun()
     {
                Thread th=new Thread(this);
                th.start();
    } 
   public void run()
   { 
    
                String clientSentence,clientpassword,name;
                String capitalizedSentence;
                Socket connectionSocket;
     while(true)
        {
        
        try{
              
                   ServerSocket welcomeSocket = new ServerSocket(4004);
           
                   connectionSocket= welcomeSocket.accept();
                   BufferedReader inFromClient=new BufferedReader(new InputStreamReader(connectionSocket.getInputStream()));             
                   BufferedReader inFromClient1=new BufferedReader(new InputStreamReader(connectionSocket.getInputStream()));             
                   DataOutputStream outToClient=new DataOutputStream(connectionSocket.getOutputStream()); 
                   System.out.println("........................Login details...................\n\n"); 
                   clientSentence = inFromClient.readLine();
                   clientpassword = inFromClient.readLine();
                   System.out.println("Received User Name: " + clientSentence);
                   System.out.println("Received Password: " + clientpassword);
                   
                   Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");  
         
                   Connection con = DriverManager.getConnection("jdbc:odbc:database","","");
                   PreparedStatement stmt= con.prepareStatement("select *from login WHERE uname= ?");
                   stmt.setString(1,clientSentence);
                   
      
                  ResultSet rs = stmt.executeQuery(); 
                 

              
 while (rs.next()) 
                {
       
                    String u=rs.getString("uname");
                    String p=rs.getString("pass");
                 
      
                if(clientSentence.equals(u) && clientpassword.equals(p))
                   {
                         
                        capitalizedSentence = "Welcome "+clientSentence+" \n";
                        outToClient.writeBytes(capitalizedSentence); 
                   }
                else
                   {  
                      capitalizedSentence = "Sorry, not authorized \n";
                      outToClient.writeBytes(capitalizedSentence); 
                  }     
            }
          con.close();
     
        }catch(Exception e){}
      
     }   
 }

     public static void main(String argv[]) throws Exception
      {
                loginserver lf=new loginserver();
                lf.loginserverfun();
      }
  


}  


