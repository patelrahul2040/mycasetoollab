import java.io.*;
import java.net.*;
import java.sql.*;
class reregistrationServer implements Runnable
{
	 int rs;
	 public void Server()
      {
     
               Thread th=new Thread(this);
               th.start();
      } 
   public void  myfunction(int roll,String dept,int year,int sem,String mess)
     {
     	
     	   try
      	     {
      	   
      	 
      	               Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");  

                       Connection con = DriverManager.getConnection("jdbc:odbc:reregistrationform","","");

                       PreparedStatement stmt= con.prepareStatement("insert into reregistration(roll,dept,syear,sem,mess) values(?,?,?,?,?)");

                       stmt.setInt(1,roll);  

                       stmt.setString(2,dept);

                       stmt.setInt(3,year); 

                       stmt.setInt(4,sem);

                       stmt.setString(5,mess);


System.out.println("beforeupdation");
                       rs=stmt.executeUpdate();
System.out.println("afterupdation");
                       con.close();
                  
             }catch(Exception ee){}
         
      	
      }  
public void run()
{
  	
   	             int i=0;
  	          	 String roll,dept,mess,year,sem;
                 String capitalizedSentence;
          
          while(true) 
          {
                          
                   try
                    { 
                        ServerSocket welcomeSocket = new ServerSocket(4005);
                        Socket connectionSocket;
                        connectionSocket= welcomeSocket.accept();
                        BufferedReader inFromClient=new BufferedReader(new InputStreamReader(connectionSocket.getInputStream()));                              
                        DataOutputStream outToClient=new  DataOutputStream(connectionSocket.getOutputStream()); 
                        
                        System.out.println(".........................Re-regisration details Status:");    
             
                        roll=inFromClient.readLine(); 
                        dept=inFromClient.readLine();
                        year=inFromClient.readLine(); 
                        sem=inFromClient.readLine(); 
                        mess=inFromClient.readLine(); 
                        
                        System.out.println("Roll number : " +roll);

                        System.out.println("Dept " +dept);


                        System.out.println("year   : " +year);
                        System.out.println("semester  " +sem);
                        System.out.println("From mess" +mess);
                      
                        int a=Integer.parseInt(roll);
                        int y=Integer.parseInt(year);
                        int s=Integer.parseInt(sem);  
                        myfunction(a,dept,y,s,mess);
                       
                    if(rs!=0)
                      {
                         
                                   System.out.println("successfully updated");     
                                   outToClient.writeBytes("ok");
                                   outToClient.flush();
                    
                      }
                   else
                     {
                                       System.out.println("Not updated");
                                       outToClient.writeBytes("no"); 
                                       outToClient.flush();
                      }       
                  
                        
                   
                 }catch(Exception e){}
       }
 }
public static void main(String argv[]) throws Exception
      {
                     reregistrationServer t1=new reregistrationServer();
                     t1.Server();
      }
}

