package conexao;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Map;

import util.ReadConfig;

public class Conexao {
	
	public Conexao() {
		
		ReadConfig config = new ReadConfig();
		Map<String, String> props;
		LoadDriver loadDriver = null;
		ScriptRunner scriptRunner;
		ClassLoader classLoader = getClass().getClassLoader();
		File file = new File(classLoader.getResource("test.sql").getFile());
		try {
			props = config.getPropValues();
			loadDriver = new LoadDriver(props.get("address"), props.get("port"), props.get("database"), props.get("username"), props.get("password"));
			scriptRunner = new ScriptRunner(loadDriver.getConnection(), false, true);
			scriptRunner.runScript(new BufferedReader(new FileReader(file)));
		} catch (IOException e) {
			System.out.println(e.getMessage());
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
	}
	
}
