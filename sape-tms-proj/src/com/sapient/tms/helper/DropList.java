package com.sapient.tms.helper;

import java.util.ArrayList;
import java.util.List;

import com.sapient.tms.model.bean.Drop;

public class DropList {
	List<Drop> drops;

	public DropList() {
		drops = new ArrayList<>();
	}

	public void add(Drop drop) {
		drops.add(drop);
	}

	public List<Drop> getDrops() {
		return drops;
	}

	@Override
	public String toString() {
		return "DropList [drops=" + drops + "]";
	}

}
