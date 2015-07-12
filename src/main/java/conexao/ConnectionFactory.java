package conexao;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Map;

import util.ReadConfig;

public class ConnectionFactory {

    private static Connection connection;
    private ClassLoader classLoader;
    private static DriverConnection driver = null;
    
    public ConnectionFactory() {
        ReadConfig config = new ReadConfig();
        Map<String, String> props;
        try {
            props = config.getPropValues();
            driver = new DriverConnection(props.get("address"), props.get("port"), props.get("database"), props.get("username"), props.get("password"));
            connection = driver.getConnection();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }

    public static Connection getConnection() {
        if (connection == null)
            new ConnectionFactory();
        return connection;
    }

    public void populate() {
        classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource("test.sql").getFile());
        ScriptRunner scriptRunner;
        try {
            scriptRunner = new ScriptRunner(driver.getConnection(), false, true);
            scriptRunner.runScript(new BufferedReader(new FileReader(file)));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
