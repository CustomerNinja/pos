/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pos;

/**
 *
 * @author mellon
 */
public class Session {
    private boolean isAdmin = false;
    protected User currentUser;
    
    NinjaConn connection;
    
    public boolean connectionValid;
    
    
    public Session(String aUsername, String aPassword){
       
        try{
       
            connection = new NinjaConn();

            if(connection.checkAccess(aPassword, aUsername)){
                System.out.println("USER LOGIN ACCEPTED");
                if(connection != null){
                    connectionValid = true;
                }

                //create the employee/manager object
                currentUser = new User(aUsername,connection);
                // if the database returns admin flag then set the admin boolean
                if(currentUser.getPermissions() == 1){
                    isAdmin = true;
                } else {
                    isAdmin = false;
                }
                
             //show the inventory page here 
            }
        }catch(Exception e){System.out.println("you fail"); }
 
    }

    protected Boolean getAdminStatus() {
        return isAdmin;
    }
    
}

