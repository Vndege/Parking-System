

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.sql.*;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;


@ManagedBean(name = "ParkingBean")
@SessionScoped
public class ParkingBean {

public List<parkingslot> getParkingList()
{
List<parkingslot> slotlist = new ArrayList<parkingslot>();
PreparedStatement ps = null;
Connection con = null;
ResultSet rs = null;
try
{Class.forName("com.mysql.jdbc.Driver");

con = DriverManager.getConnection(""
+ "jdbc:mysql://localhost/eparking"
    + "?user=root&password=");
String sql = "select * from allocateparking";
ps= con.prepareStatement(sql); 
rs= ps.executeQuery(); 
while (rs.next())
{
parkingslot usr = new parkingslot();
usr.setCarnumberplate(rs.getString("carnumberplate"));
usr.setParkingtype(rs.getString("parkingtype"));
usr.setSlotno(rs.getString("parkingslot"));
usr.setDate(rs.getString("parkingdate"));
usr.setEntrytime(rs.getString("entrytime"));
usr.setExittime(rs.getString("exittime"));


slotlist.add(usr);
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
return slotlist;
}
}