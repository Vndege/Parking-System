//DB CONNECT CLASS
/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/

/**
*
* @author Joan Munene
*/
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class DBConnect {

public DBConnect(){
} 

public Connection myConnect(){
Connection connect = null;

try {
Class.forName("com.mysql.jdbc.Driver");

connect = DriverManager.getConnection(""
+ "jdbc:mysql://localhost/eparking"
    + "?user=root&password=");

} catch (ClassNotFoundException | SQLException e) {
System.out.println("Cannot connect to Property DB"+e.getMessage());
}
return connect;

}
public static void main(String args[]){
DBConnect myconn = new DBConnect();
myconn.myConnect();
}


}