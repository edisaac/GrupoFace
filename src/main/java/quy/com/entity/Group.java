package quy.com.entity;
// Generated 26-jul-2016 9:58:34 by Hibernate Tools 4.3.4.Final

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * Group generated by hbm2java
 */
public class Group implements java.io.Serializable {

	private Integer groupId;
	private User user;
	private String name;
	private Date beginDate;
	private BigDecimal amount;
	private Character period;
	private Character state;
	private Set detailGroups = new HashSet(0);

	public Group() {
	}

	public Group(User user, String name, Date beginDate, BigDecimal amount, Character period, Character state,
			Set detailGroups) {
		this.user = user;
		this.name = name;
		this.beginDate = beginDate;
		this.amount = amount;
		this.period = period;
		this.state = state;
		this.detailGroups = detailGroups;
	}

	public Integer getGroupId() {
		return this.groupId;
	}

	public void setGroupId(Integer groupId) {
		this.groupId = groupId;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getBeginDate() {
		return this.beginDate;
	}

	public void setBeginDate(Date beginDate) {
		this.beginDate = beginDate;
	}

	public BigDecimal getAmount() {
		return this.amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public Character getPeriod() {
		return this.period;
	}

	public void setPeriod(Character period) {
		this.period = period;
	}

	public Character getState() {
		return this.state;
	}

	public void setState(Character state) {
		this.state = state;
	}

	public Set getDetailGroups() {
		return this.detailGroups;
	}

	public void setDetailGroups(Set detailGroups) {
		this.detailGroups = detailGroups;
	}

}