package quy.com.controller;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import quy.com.entity.DetailGroup;
import quy.com.entity.Group;
import quy.com.entity.User;
import quy.com.service.IGroupService;
import quy.com.service.IUserService;

 
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
}
;