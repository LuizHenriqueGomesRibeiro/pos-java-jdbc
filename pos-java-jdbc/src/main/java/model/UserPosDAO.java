package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserPosDAO{
	
	private Connection connection;
	
	public UserPosDAO(){
		connection=SingleConnection.getConnection();
	}
	
	public void salvar(Userposjava userposjava){
		try {
			String sql="INSERT INTO userposjava (nome, email) VALUES (?, ?)";
			PreparedStatement insert = connection.prepareStatement(sql);
			insert.setString(1, userposjava.getNome());
			insert.setString(2, userposjava.getEmail());
			insert.execute();
			connection.commit();
		} catch (SQLException e) {
			// TODO: handle exception
			try {
				connection.rollback();
			} catch (SQLException e2) {
				// TODO: handle exception
				System.out.println(e2);
			}
			System.out.println(e);
		}
	}
	
	public void salvarTelefone(Telefone telefone) {
		try {
			String sql="INSERT INTO telefoneuser(numero, tipo, usuariopessoa) VALUES (?,?,?)";
			
			PreparedStatement statement=connection.prepareStatement(sql);
			
			statement.setString(1, telefone.getNumero());
			statement.setString(2, telefone.getTipo());
			statement.setLong(3, telefone.getUsuario());
			
			statement.execute();
			connection.commit();
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			try {
				connection.rollback();
			} catch (Exception e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
		}
	}
	
	public List<Userposjava> listar() throws Exception{
		List<Userposjava> lista=new ArrayList<Userposjava>();
		String sql="SELECT*FROM userposjava";
		PreparedStatement insert = connection.prepareStatement(sql);
		ResultSet resultado=insert.executeQuery();
		
		while(resultado.next()) {
			Userposjava userposjava=new Userposjava();
			userposjava.setId(resultado.getLong("id"));
			userposjava.setNome(resultado.getString("nome"));
			userposjava.setEmail(resultado.getString("email"));
			
			lista.add(userposjava);
		}
		return lista;
	}

	public Userposjava buscar(Long id) throws Exception{
		Userposjava userposjava = new Userposjava();
		
		String sql="SELECT*FROM userposjava WHERE id = "+id;
		
		PreparedStatement insert = connection.prepareStatement(sql);
		ResultSet resultado=insert.executeQuery();
		
		while(resultado.next()) {
			userposjava.setId(resultado.getLong("id"));
			userposjava.setNome(resultado.getString("nome"));
			userposjava.setEmail(resultado.getString("email"));
		}
		
		return userposjava;
	}
	
	public void atualizar(Userposjava userposjava) {
		try {
			String sql="UPDATE userposjava SET nome = ? WHERE id = "+userposjava.getId();
		
			PreparedStatement insert = connection.prepareStatement(sql);
			insert.setString(1, userposjava.getNome());
			
			insert.execute();
			connection.commit();
			
		} catch (Exception e) {
			// TODO: handle exception
				e.printStackTrace();
			try {
				connection.rollback();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}
	
	public void deletar(Long id) {
		try {
			String sql="DELETE FROM userposjava WHERE id = "+id;
			
			PreparedStatement statement=connection.prepareStatement(sql);
			statement.execute();
			
			connection.commit();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			
			try {
				connection.rollback();
			} catch (Exception e2) {
				// TODO: handle exception
				e2.printStackTrace();
			}
		}
	}
}
