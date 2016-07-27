package quy.com.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import quy.com.controller.util.JsfUtil;
import quy.com.entity.DetailGroup;
import quy.com.entity.Group;
import quy.com.entity.User;
import quy.com.service.IGroupService;


 
@Controller

@Scope("session")
public class GroupController {
	@Autowired
	private User user;
		
	@Autowired
	private IGroupService groupService;
	
	
	private List<Group>  groups;
	private Group selected;

	
	public List<Group> getGroups() {
		if (groups == null) {
			groups=groupService.getGroupsByUser(user.getUserId());		
		}
		return groups;
	}
	public boolean isGroupsEmpty(){
		if (groups == null) {
			return true;
		}
		if (groups.size()<1){
			return true;
		}
		return false;
	}
	public void setGroups(List<Group> groups ){
		 this.groups = groups;
	}
	
	public Group getSelected() {
		return selected;
	}

	public void setSelected(Group selected) {	
		this.selected = selected;
	}

	public void prepareCreate (ActionEvent event) {
		 Group group=new Group();
		 group.setState('P');
		 group.setUser(user);
		 this.selected=group;
		return ;
	}
	 
	
	public void save(ActionEvent event) {
		 String msg = ResourceBundle.getBundle("/MyBundle").getString("GroupUpdated");
		 
		if (groupService.actualizar(this.selected))  
			JsfUtil.addSuccessMessage(msg);
		else
			{
			this.selected= groupService.getGroup(this.selected.getGroupId());
			this.groups = null;
			}
	}
	
	public void saveNew(ActionEvent event) {
		String msg = ResourceBundle.getBundle("/MyBundle").getString("GroupCreated");
		 
		if (groupService.guardar(this.selected)) { 
			this.groups.add(this.selected);
			JsfUtil.addSuccessMessage(msg);	
		 }
	}
    
	  
}
;