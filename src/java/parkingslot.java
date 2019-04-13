import java.sql.*;
import javax.faces.bean.ManagedBean;
import java.*;
import java.util.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author HP
 */
@ManagedBean(name = "parkingslot")
public class parkingslot {

   
    public String carnumberplate;
    public String parkingtype;
    public String slotno;
    public String date;
    public String entrytime;
    public String exittime;
    
    DBConnect myDb=new DBConnect();
    Connection myCon=myDb.myConnect();
    
    public parkingslot(){}

    public String getCarnumberplate() {
        return carnumberplate;
    }

    public void setCarnumberplate(String carnumberplate) {
        this.carnumberplate = carnumberplate;
    }

    public String getParkingtype() {
        return parkingtype;
    }

    public void setParkingtype(String parkingtype) {
        this.parkingtype = parkingtype;
    }

    public String getSlotno() {
        return slotno;
    }

    public void setSlotno(String slotno) {
        this.slotno = slotno;
    }
    
    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date=date;
    }

    public String getEntrytime() {
        return entrytime;
    }

    public void setEntrytime(String entrytime) {
        this.entrytime = entrytime;
    }

    public String getExittime() {
        return exittime;
    }

    public void setExittime(String exittime) {
        this.exittime = exittime;
    }
    
    public String saveParkingslot() throws SQLException{
Statement s = null;
//creates an instance of the DBConnect class

if(myCon!=null){
System.out.println(myCon);
s = myCon.createStatement();

String sql = "INSERT INTO allocateparking "
+ "(carnumberplate,parkingslot,parkingtype,parkingdate,entrytime,exittime)"
+ "VALUES ('" + getCarnumberplate() + "','"+ getSlotno() + "','"+ getParkingtype()+ "','"+ getDate() + "','"+ getEntrytime()+"',"
+ "'"+getExittime()+"') ";
s.execute(sql);

}
return "allocateparking";}


}



