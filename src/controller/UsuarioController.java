package controller;

import dao.UsuarioDAO;
import factory.ConnectionFactory;
import model.Usuario;

public class UsuarioController {
	
	private UsuarioDAO usuarioDao;
	
	public UsuarioController() {
	        var factory = new ConnectionFactory();
	        this.usuarioDao = new UsuarioDAO(factory.abrirConexion());
	    }
	
	public boolean login(Usuario usuario) {
		
		return usuarioDao.login(usuario);
		
	}

}
