
import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean
@SessionScoped
public class carBean implements Serializable {

	private static final long serialVersionUID = 6081417964063918994L;

	public List<RegCar> getCars() throws ClassNotFoundException, SQLException {

		//public Connection myConnect(){
                Connection connect = null;

                try {
                Class.forName("com.mysql.jdbc.Driver");

                connect = DriverManager.getConnection(""
                + "jdbc:mysql://localhost/eparking"
                    + "?user=root&password=");

                } catch (ClassNotFoundException | SQLException e) {
                System.out.println("Cannot connect to Property DB"+e.getMessage());
                }

		List<RegCar> cars = new ArrayList<RegCar>();
		PreparedStatement pstmt = connect
				.prepareStatement("select car_id, cname, color, speed, Manufactured_Country from Car");
		ResultSet rs = pstmt.executeQuery();

		while (rs.next()) {

			RegCar car = new RegCar();
			car.setRegNo(rs.getInt("car_id"));
			car.setCarName(rs.getString("cname"));
                        car.setNumberPLate(rs.getString("no.Plate"));
                        car.setModel(rs.getString("model"));
			car.setLogBookNo(rs.getString("log.no"));
			car.setOwnerTel(rs.getString("phone"));

			cars.add(car);

		}

		// close resources
		rs.close();
		pstmt.close();
		connect.close();

		return cars;

	}

}
