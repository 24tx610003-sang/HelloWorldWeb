package hello.com.configs;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnect {
    private static final String serverName = "localhost";
    private static final String dbName = "LTWEBTUXA";
    private static final String portNumber = "1433";
    private static final String instance = "";
    private static final String userID = "sa";
    private static final String password = "123456";

    public static Connection getConnection() throws Exception {
        String url = "jdbc:sqlserver://" + serverName + ":" + portNumber;
        if (instance != null && !instance.trim().isEmpty()) {
            url += "\\" + instance;
        }
        url += ";databaseName=" + dbName + ";encrypt=true;trustServerCertificate=true";
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        return DriverManager.getConnection(url, userID, password);
    }

    public static void main(String[] args) {
        try (Connection conn = DBConnect.getConnection()) {
            System.out.println("Kết nối thành công tới SQL Server!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
