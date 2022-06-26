package controller;

import java.util.List;
import dao.HuespedDAO;
import factory.ConnectionFactory;
import model.Huesped;


public class HuespedController {
	
	private HuespedDAO huespedDao;
	
	public HuespedController() {
		var factory = new ConnectionFactory();
		this.huespedDao = new HuespedDAO(factory.abrirConexion());
	};

	public void agregarHuesped(Huesped huesped) {
		huespedDao.agregarHuesped(huesped);
	}
	
	public Integer borrarHuesped(Integer id) {
		return huespedDao.borrarHuesped(id);
	}
	
	public List<Huesped> listar() {
	    return huespedDao.listar();
	}
	
	public List<Huesped> listaInicial(List<Huesped> lista) {
		lista.forEach(huesped -> {
			agregarHuesped(huesped);
		});
	    return lista;
	}
	public List<Huesped> borrarLista() {
		var lista = huespedDao.listar();
		lista.forEach(huesped -> {
			borrarHuesped(huesped.getIdHuesped());
		});
	    return lista;
	}
	 
	public int editar(String nombre, String apellido,String fechaNacimiento, String nacionalidad, String telefono, Integer idHuesped) {
	        return huespedDao.editar(nombre, apellido, fechaNacimiento, nacionalidad,telefono,idHuesped);
	    }
	
	public void resetAutoIncrement() {
		huespedDao.resetAutoIncrement();
	}
	
	public List<Huesped> listar(String textoABuscar) {
	        return huespedDao.listar(textoABuscar);
	    }
	
	public void cancelarHuesped() {
		huespedDao.cancelarHuesped();
	}
	
	
}
