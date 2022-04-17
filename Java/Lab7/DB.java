import java.sql.*;

public class DB {
    public DB() {
    }

    public static void main(String[] args) {
        try{
            DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
        } catch (Exception ex) {
        }
        try {
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/os42", "root",
                    "ShaimaaCS177@");
            Statement stmt = con.createStatement();
            ResultSet rss = stmt.executeQuery("select * from students");
            while (rss.next())
                System.out.println(rss.getInt(1) + " " + rss.getString(2) + " " +
                        rss.getString(3));
			
			/*String insert =new String("insert into students (student_id,first_name,last_name,tel,email,gender,birth_date) values ('10','Ahmed','Khalil',NULL,NULL,'female', '1992-10-01')");
			stmt.executeUpdate(insert);
			String sqli=new String("select * from students");
			ResultSet rsi= stmt.executeQuery(sqli);*/
			
			/*String delete = "DELETE FROM students WHERE student_id = 10";
			stmt.executeUpdate(delete);
			String sqld=new String("select * from students");
			ResultSet rsd= stmt.executeQuery(sqld);*/
		
		PreparedStatement pst2 = con.prepareStatement("Update students set first_name=? where last_name=?");
			pst2.setString(1 ,"Shaimaa");
			pst2.setString(2,"Ibrahem");
			pst2.executeUpdate();
            con.close();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

    }
}
