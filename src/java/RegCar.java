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


    public int regNo;
    public String CarName;
    public String NumberPLate;
    public String model;
    public String LogBookNo;
    public String OwnerTel;
    
            
    DBConnect myDB= new DBConnect();
    Connection myCon = myDB.myConnect();
    
    public RegCar(){}

    public int getRegNo() {
        return regNo;
    }

    public void setRegNo(int regNo) {
        this.regNo = regNo;
    }
    
    
    
        public String getCarName() {
        return CarName;
    }

    public void setCarName(String CarName) {
        this.CarName = CarName;
    }

    public String getNumberPLate() {
        return NumberPLate;
    }

    public void setNumberPLate(String NumberPLate) {
        this.NumberPLate = NumberPLate;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
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
+ "(regNo,CarName,NumberPlate,Model,LogBookNo,OwnerTel) "
+ "VALUES ('" + getRegNo()+ "','"+ getCarName()+ "',+ '"+getNumberPLate()+"','"+getModel()+"','"+getLogBookNo()+"','"+getOwnerTel()+"') ";
s.execute(sql);


    }
    return "allocateparking";
    }

    }
