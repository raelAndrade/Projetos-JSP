package connection;

import java.sql.Connection;
import java.sql.DriverManager;

/**
  * Responsável em fazer conexão com o banco de dados
  * @author Israel
  *
  */

public class SingleConnection {
	
	private static String banco = "jdbc:postgresql://localhost:5432/banco-jsp?autoReconnect=true";
	private static String password = "admin";
	private static String user = "postgres";
	private static Connection connection = null;
	
	/**
	 * Essa chamada static serve chamar o nosso método conectar e sempre irá executar  
	 */
	static {
		conectar();
	}
	
	/**
	 * Método construtor
	 */
	public SingleConnection() {
		conectar();
	}
	
	private static void conectar() {
		try {
			if (connection == null) {
				Class.forName("org.postgresql.Driver");
				connection = DriverManager.getConnection(banco, user, password);
				connection.setAutoCommit(false);
			}
		}catch(Exception e) {
			throw new RuntimeException("Erro ao conectar no banco de dados");
		}
	}
	
	public static Connection getConnection() {
		return connection;
	}
}
