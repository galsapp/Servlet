package a;
import com.mysql.jdbc.jdbc2.optional.MysqlConnectionPoolDataSource;
import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class Example {
	  public static void main(String[] args) {
        Connection connection=null;
        try {
            	MysqlDataSource ds = new MysqlConnectionPoolDataSource();
	ds.setServerName("localhost");
	ds.setDatabaseName("test");
            	connection=ds.getConnection("root","");
            	Statement statement=connection.createStatement();
            	ResultSet rs=statement.executeQuery("SELECT * FROM customer_table");
            	while(rs.next()){
                		System.out.println(rs.getInt("id")+"- "+rs.getString("First_Name"));
            	}
            	connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
