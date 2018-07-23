package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import connection.SingleConnection;

public class DaoLogin {

	private Connection connection;
	
	public DaoLogin() {
		// Atribuir na variavel connection o objeto SingleConnection.getConnection()
		connection = SingleConnection.getConnection();
	}
	
	public boolean validarLogin(String login, String senha) throws Exception{
		String sql = "select * from usuario where login = '" + login + "' and senha = '" + senha + "'";
		PreparedStatement statement = connection.prepareStatement(sql); // Prepared é uma instrução para o banco de dados
		ResultSet resultSet = statement.executeQuery(); // Objeto que vai carregar o resultado do sql
		if(resultSet.next()) { // Se estiver resultado retorna
			return true; // possui usuário
		}else {
			return false; // não validou usuário
		}
	}
}
