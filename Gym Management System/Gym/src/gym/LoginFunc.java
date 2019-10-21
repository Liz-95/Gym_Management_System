
package gym;

import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author game
 */
public class LoginFunc {
    private static String logName;
    public void setLogName(String lg){
        logName = lg;
    }
    public String getLogName(){
        return logName;
    }
    public boolean checkLogin(String name, String password){
        Connection conn = new DBConnection().connect();
        String sql = "select * from login where name = ? and pword =? ";
        try{
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1,name);
            
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
           
            
            
                if(rs.next()){
                    
                    System.out.println("correct uname pword");
                    
                    new Home().setVisible(true);
                   
                     
                    setLogName(name);
                    return true;
                     
                    
                    
                    
                }
                else{
                    JOptionPane.showMessageDialog(null,"Username or Password is incorrect");
                    System.out.println("incorrect uname pword"+name+" "+password);
                    return false;
                                        
                }
                
            
            
        } catch (SQLException ex) {
            System.out.println("sql exception in submit btn :"+ex);
           
        }
        catch(HeadlessException ez){
        System.out.println("Error :"+ez);
    }
        
        
    return false;
    }
    }
