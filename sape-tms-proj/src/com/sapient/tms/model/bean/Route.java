package com.sapient.tms.model.bean;

import com.sapient.tms.helper.DropList;

public class Route {

	private String name;
	private int id;
	DropList dropList = new DropList();

	public String getName() {
		return name;
	}

	public void setRouteName(String routeName) {
		this.name = routeName;
	}

	public int getId() {
		return id;
	}

	public void setRouteId(int id) {
		this.id = id;
	}

	public DropList getDropList() {
		return dropList;
	}

	public void setDropList(DropList dropList) {
		this.dropList = dropList;
	}

	public Route(int id, String name, DropList dropList) {
		super();
		this.name = name;
		this.id = id;
		this.dropList = dropList;
	}

	public void dropLoc(Drop dropparam) {

		dropList.add(dropparam);
	}

	@Override
	public String toString() {
		return "Route [name=" + name + ", id=" + id + ", dropList=" + dropList + "]";
	}

}
