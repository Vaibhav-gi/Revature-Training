import java.sql.*;

public class JdbcConnection {
    public static void main(String[] args) {
        String url= "jdbc:mysql://localhost:3306/bankapp";
        String user="root";
        String password="manager";
        try{
            Connection connection= DriverManager.getConnection(url,user,password);
            Statement statement=connection.createStatement();
            ResultSet resultSet=statement.executeQuery("SELECT * FROM CUSTOMER");

            while(resultSet.next())
            {
                int id=resultSet.getInt("id");
                String name=resultSet.getString("name");
                String email=resultSet.getString("email");
                String acocountName = resultSet.getString("accountname");
                System.out.println(id + name + email + acocountName);
                //connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();

        }

    }
}
