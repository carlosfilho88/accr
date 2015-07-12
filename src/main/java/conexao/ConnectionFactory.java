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

    public ConnectionFactory() {

        ReadConfig config = new ReadConfig();
        Map<String, String> props;
        DriverConnection driver = null;
        ScriptRunner scriptRunner;
        ClassLoader classLoader = getClass().getClassLoader();

        try {
            File file = new File(classLoader.getResource("test.sql").getFile());
            props = config.getPropValues();
            driver = new DriverConnection(props.get("address"), props.get("port"), props.get("database"), props.get("username"), props.get("password"));
            scriptRunner = new ScriptRunner(driver.getConnection(), false, true);
            scriptRunner.runScript(new BufferedReader(new FileReader(file)));
            connection = driver.getConnection();

        } catch (IOException e) {
            System.out.println(e.getMessage());
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    public static Connection getConnection() {
        return connection;
    }
}
