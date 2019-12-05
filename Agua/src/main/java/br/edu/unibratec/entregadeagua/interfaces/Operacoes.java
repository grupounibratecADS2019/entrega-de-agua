package br.edu.unibratec.entregadeagua.interfaces;

import java.util.List;

public interface Operacoes<Object> {
	
	public void insert(Object registro);
	public void delete(int id);
	public void update(Object registro);
	public List<Object> listAll();
	public Object listById(int id);
	
	
}
