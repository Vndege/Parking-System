import java.sql.*;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;




/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author webteam
 *
 *
 *git
 */
@ManagedBean(name="RegCarObj")
@RequestScoped
public class RegCar {


    public int regno;
    public String CarName;
    public String NumberPlate;
    public String Model;
    public String LogBookNo;
    public String OwnerTel;
    
            
    DBConnect myDB= new DBConnect();
    Connection myCon = myDB.myConnect();

    public int getRegno() {
        return regno;
    }

    public void setRegno(int regno) {
        this.regno = regno;
    }

    public String getCarName() {
        return CarName;
    }

    public void setCarName(String CarName) {
        this.CarName = CarName;
    }

    public String getNumberPlate() {
        return NumberPlate;
    }

    public void setNumberPlate(String NumberPlate) {
        this.NumberPlate = NumberPlate;
    }

    public String getModel() {
        return Model;
    }

    public void setModel(String Model) {
        this.Model = Model;
    }

    public String getLogBookNo() {
        return LogBookNo;
    }

    public void setLogBookNo(String LogBookNo) {
        this.LogBookNo = LogBookNo;
    }

    public String getOwnerTel() {
        return OwnerTel;
    }

    public void setOwnerTel(String OwnerTel) {
        this.OwnerTel = OwnerTel;
    }
    
    
    
    //Java Comment

    public String saveCar() throws SQLException{
    Statement s = null;
    //creates an instance of the DBConnect class

    if(myCon!=null){
    System.out.println(myCon);
    s = myCon.createStatement();

   String sql = "INSERT INTO registercar "
+ "(regno,CarName,NumberPlate,Model,LogBookNo,OwnerTel) "
+ "VALUES ('" + getRegno()+ "','"+ getCarName()+ "',+ '"+getNumberPlate()+"','"+getModel()+"','"+getLogBookNo()+"','"+getOwnerTel()+"') ";
s.execute(sql);


    }
    return "Car";
    }

    }
