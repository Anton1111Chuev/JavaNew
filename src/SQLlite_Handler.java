import java.sql.*;
import java.util.HashMap;

public class SQLlite_Handler {
    private Connection conn;
    private final static String url = "jdbc:sqlite:db/laptops.db3";

    private static SQLlite_Handler instance = null;

    public static synchronized SQLlite_Handler getInstance() throws SQLException {
        if (instance == null)
            instance = new SQLlite_Handler();
        return instance;
    }

    private Connection connection;

    private SQLlite_Handler() throws SQLException {

        this.connection = DriverManager.getConnection(url);
    }



    public String getLaptopsByParam(String RAM, String HD){

        try (Statement statement = this.connection.createStatement()) {

            ResultSet resultSet = statement.executeQuery("select name, RAM, HD from laptops where " +
                    " RAM > " + RAM +
                    " and HD > " + HD);

            String result = "";

            while (resultSet.next()) {
                result = result + resultSet.getString("name") + "\n" ;
            }
            return result;

        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }


    public void addLaptopDB(Laptop laptop) {
        // Создадим подготовленное выражение, чтобы избежать SQL-инъекций
        try (PreparedStatement statement = this.connection.prepareStatement(
                "INSERT INTO laptops('name', 'RAM', 'HD') " +
                        "VALUES(?, ?, ?)")) {
            statement.setObject(1, laptop.getName());
            statement.setObject(2, laptop.getRAM());
            statement.setObject(3, laptop.getHD());
            // Выполняем запрос
            statement.execute();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
