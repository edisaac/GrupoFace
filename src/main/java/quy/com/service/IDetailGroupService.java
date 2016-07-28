package quy.com.service;

import java.util.List;

import quy.com.entity.DetailGroup;;

public interface IDetailGroupService {
	public boolean guardar(DetailGroup arg0);
	public boolean actualizar(DetailGroup arg0);
	public boolean eliminar(DetailGroup arg0);
	public DetailGroup getDetailGroup(int id);
	public List<DetailGroup> getDetailGroups();
	public List<DetailGroup> getDetailsByGroup(int id);
}
