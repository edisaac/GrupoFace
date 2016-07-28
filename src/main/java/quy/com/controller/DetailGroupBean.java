package quy.com.controller;

import java.util.List;
import java.util.ResourceBundle;

import javax.faces.event.ActionEvent;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import quy.com.controller.util.JsfUtil;
import quy.com.entity.DetailGroup;
import quy.com.entity.Group;
import quy.com.entity.User;
import quy.com.service.IDetailGroupService;
import quy.com.service.IUserService;
 
@Controller
@Scope("view")
public class DetailGroupBean {
	
	
	@Autowired
	private IDetailGroupService detailGroupService;
	
	@Autowired
	private IUserService userService;
	
	@Autowired
	private GroupBean groupBean;
	
	private List<DetailGroup>  items;
	private DetailGroup selected;
	
	private List<User> users;
	
	private String name="";
	
	public List<DetailGroup> getItems() {
		if (groupBean.getSelected()==null || groupBean.getSelected().getGroupId()==null ){
			items=null;
		}else{
		items=detailGroupService.getDetailsByGroup(groupBean.getSelected().getGroupId());
		}
		return items;
	}
	public  void setItems( List<DetailGroup> items) {	 
		this.items=items; 		
	}	 
	 
	public void search(){
		users=userService.getNotGroupUsersByName(groupBean.getSelected().getGroupId(), name);
		return;
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}
	
	public void add( User user) {
		String msg = ResourceBundle.getBundle("/MyBundle").getString("DetailGroupCreated");
		DetailGroup detailGroup=new DetailGroup();
		detailGroup.setRol('N');
		detailGroup.setState('P');
		detailGroup.setGroup(groupBean.getSelected());
		detailGroup.setUser(user);
		name="";
		if (detailGroupService.guardar( detailGroup))  
			{JsfUtil.addSuccessMessage(msg);
			items.add(detailGroup);
			users=null;
			name=""; 
			}
		 
	}
	public DetailGroup getSelected() {
		return selected;
	}
	public void setSelected(DetailGroup selected) {
		this.selected = selected;
	}
	public void delete(ActionEvent event) {
		String msg = ResourceBundle.getBundle("/MyBundle").getString("DetailGroupDeleted");
		 
		if (detailGroupService.eliminar(this.selected)) { 
			this.items.remove(this.selected);
			JsfUtil.addSuccessMessage(msg);	
		 }
	}
}
