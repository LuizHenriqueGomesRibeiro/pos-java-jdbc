package pos_java_jdbc.pos_java_jdbc;

import java.util.List;

import org.junit.Test;

import model.BeanUserFone;
import model.Telefone;
import model.UserPosDAO;
import model.Userposjava;

public class TesteBancoJdbc{
	
	@Test
	public void initBanco(){
		UserPosDAO userPosDAO=new UserPosDAO();
		Userposjava userposjava=new Userposjava();
		
		userposjava.setNome("Rosimar Gomes Ribeiro");
		userposjava.setEmail("Artes@gmail.com.br");
		
		userPosDAO.salvar(userposjava);
	}

	@Test
	public void initListar() {
		UserPosDAO dao=new UserPosDAO();
		try {
			List<Userposjava> lista=dao.listar();
			
			for (Userposjava userposjava : lista) {
				System.out.println(userposjava);
				System.out.println("-----------------------------------------------------"
			    + "----------------------------------------------------------------------------------------------------------");
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	@Test
	public void initBuscar() {
		try {
			UserPosDAO dao=new UserPosDAO();
			Userposjava userposjava=dao.buscar(30L);
			
			System.out.println("-----------------------------------------------------"
					+ "-----------------------------------------------------"
					+ "-----------------------------------------------------");
			System.out.println(userposjava);
			System.out.println("-----------------------------------------------------"
					+ "-----------------------------------------------------"
					+ "-----------------------------------------------------");
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
	}
	
	@Test
	public void initAtualizar() {

		try {
			UserPosDAO dao = new UserPosDAO();
			Userposjava objetoBanco=dao.buscar(4L);
			
			objetoBanco.setNome("Piribinho Filho");
			
			dao.atualizar(objetoBanco);
			
			System.out.println("-----------------------------------------------------"
					+ "-----------------------------------------------------"
					+ "-----------------------------------------------------");
			System.out.println(objetoBanco);
			System.out.println("-----------------------------------------------------"
					+ "-----------------------------------------------------"
					+ "-----------------------------------------------------");
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Test
	public void initDeletar(){
		try {
			UserPosDAO dao=new UserPosDAO();
			dao.deletar(13L);
		}catch (Exception e){
			// TODO: handle exception
		}
	}
	
	@Test
	public void testeCarregaFoneUser() {
		try {
			UserPosDAO dao=new UserPosDAO();
			List<BeanUserFone> beanUserFones=dao.listaUserFone(3L);
			
			for (BeanUserFone beanUserFone : beanUserFones) {
				System.out.println("-----------------------------------------------------"
						+ "-----------------------------------------------------"
						+ "-----------------------------------------------------");
				System.out.println(beanUserFone);
				System.out.println("-----------------------------------------------------"
						+ "-----------------------------------------------------"
						+ "-----------------------------------------------------");
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	@Test
	public void insertTelefone() {
		Telefone telefone = new Telefone();
		
		telefone.setNumero("(27) 8821-4321");
		telefone.setTipo("Telefone");
		telefone.setUsuario(10L);
		
		UserPosDAO dao = new UserPosDAO();
		
		dao.salvarTelefone(telefone);
	}
	
	@Test
	public void deleteUserFone() {
		UserPosDAO dao = new UserPosDAO();
		dao.deleteFonesPorUser(3L);
	}
}
