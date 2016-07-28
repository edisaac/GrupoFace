package quy.com.dao;

import java.util.List;

import quy.com.entity.DetailGroup;

public interface IDetailGroupDao {
	public void guardar(DetailGroup arg0);
	public void actualizar(DetailGroup   arg0);
	public void eliminar(DetailGroup arg0);
	public DetailGroup getDetailGroup(int id);	
	public List<DetailGroup> getDetailGroups();
	public List<DetailGroup> getDetailsByGroup(int id);
	
}
