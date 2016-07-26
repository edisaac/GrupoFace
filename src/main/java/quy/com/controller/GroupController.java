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
	
	public void setGroups(List<Group> groups ){
		 this.groups = groups;
	}
	
	public Group getSelected() {
		return selected;
	}

	public void setSelected(Group selected) {
		this.selected = selected;
	}

	public Group prepareCreate (ActionEvent event) {
		 Group group=new Group();
		 DetailGroup dg= new DetailGroup(group,user,1,'A','A');
		 group.getDetailGroups().add(dg);
		 this.selected=group;
		return group;
	}
	public String prepareCreate(String uri){
		Group group=new Group();
		DetailGroup dg= new DetailGroup(group,user,1,'A','A');
		group.getDetailGroups().add(dg);
		this.selected=group;
		return uri;
	}
	
	private void save(ActionEvent event) {
		 String msg = ResourceBundle.getBundle("/MyBundle").getString("GroupUpdated");
		 
		if (groupService.actualizar(this.selected))  
			 JsfUtil.addSuccessMessage(msg);
		 else
			 JsfUtil.addErrorMessage("Error:"+ msg) ;
	}
	
	private void saveNew(ActionEvent event) {
		String msg = ResourceBundle.getBundle("/MyBundle").getString("GroupCreated");
		 
		if (groupService.guardar(this.selected))  
			 JsfUtil.addSuccessMessage(msg);
		 else
			 JsfUtil.addErrorMessage("Error:"+ msg) ;
	}
    
	  public String navigateTo(String actionName) {	       
	        return actionName;
	    }
    
}
;