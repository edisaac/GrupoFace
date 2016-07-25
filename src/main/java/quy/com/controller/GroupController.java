package quy.com.controller;

import java.util.ArrayList;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
	
	public List<Group> getGroups() {
		List<Group>  groups;
		groups=groupService.getGroupsByUser(user.getUserId());
		
		return groups;
	}
	
	
	private Group group;

    public Group getGroup() {
		return group;
	}

    public void setOrden(Group group) {
		this.group = group;
	}
    
    public void newGruop() {
        this.group=new Group();
        DetailGroup dg= new DetailGroup(this.group,user,1,'A','A'  );
        this.group.getDetailGroups().add(dg);
  	 // return "redirect:grupo.xhtml";
      }
    public String editGruop(Group group) {
      this.group=group;        
  	  return "redirect:grupo";
      }
    
}
;