

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.sql.*;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;


@ManagedBean(name = "carBean")
@SessionScoped
public class carBean {

public List<RegCar> getCarList()
{
List<RegCar> list = new ArrayList<RegCar>();
PreparedStatement ps = null;
Connection con = null;
ResultSet rs = null;
try
{Class.forName("com.mysql.jdbc.Driver");

con = DriverManager.getConnection(""
+ "jdbc:mysql://localhost/eparking"
    + "?user=root&password=");
String sql = "select * from registercar";
ps= con.prepareStatement(sql); 
rs= ps.executeQuery(); 
while (rs.next())
{
RegCar usr = new RegCar();
usr.setRegno(rs.getInt("regno"));
usr.setCarName(rs.getString("CarName"));
usr.setNumberPlate(rs.getString("NumberPlate"));
usr.setModel(rs.getString("Model"));
usr.setLogBookNo(rs.getString("LogBookNo"));
usr.setOwnerTel(rs.getString("OwnerTel"));


list.add(usr);
} 
}

catch(Exception e)
{
e.printStackTrace();
}
finally
{
try
{
con.close();
ps.close();
}
catch(Exception e)
{
e.printStackTrace();
}
}
return list;
}
}