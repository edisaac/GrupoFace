package quy.com.controller;

 
import java.util.List;
import java.util.ResourceBundle;

 
import javax.faces.event.ActionEvent;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
 
import quy.com.controller.util.JsfUtil;
import quy.com.entity.Group;
import quy.com.entity.User;
import quy.com.service.IGroupService;


 
@Controller
@Scope("session")
public class GroupBean {
	
	@Autowired
	private User user;
		
	@Autowired
	private IGroupService groupService;
	
	
	private List<Group>  items;
	private Group selected;
 
	public List<Group> getItems() {
		if (items == null) {
			items=groupService.getGroupsByUser(user.getUserId());		
		}
		return items;
	}
	public boolean isItemsEmpty(){
		if (items == null) {
			return true;
		}
		if (items.size()<1){
			return true;
		}
		return false;
	}
	public void setItems(List<Group> items ){
		 this.items = items;
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
			this.items = null;
			}
	}
	
	public void saveNew(ActionEvent event) {
		String msg = ResourceBundle.getBundle("/MyBundle").getString("GroupCreated");
		 
		if (groupService.guardar(this.selected)) { 
			this.items.add(this.selected);
			JsfUtil.addSuccessMessage(msg);	
		 }
	}
	
	public String periodToString(Group group){
		String var="";
		switch (group.getPeriod()){
			case 'M':
				var= ResourceBundle.getBundle("/MyBundle").getString("GroupPeriodMonthly");
				break;
			case 'D':
				var= ResourceBundle.getBundle("/MyBundle").getString("GroupPeriodDaily");
				break;
			case 'W':
				var= ResourceBundle.getBundle("/MyBundle").getString("GroupPeriodWeekly");
				break;
		}
		
		return   var;
	}
	public String stateToString(Group group){
		String var="";
		switch (group.getState()){
			case 'P':
				var= ResourceBundle.getBundle("/MyBundle").getString("GroupStatePending");
				break;
			case 'A':
				var= ResourceBundle.getBundle("/MyBundle").getString("GroupStateAccepted");
				break;
			case 'C':
				var= ResourceBundle.getBundle("/MyBundle").getString("GroupStateCompleted");
				break;
		}	
		
		return   var;
	}
}
;