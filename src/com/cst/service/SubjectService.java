package com.cst.service;

import java.util.List;

import com.cst.model.Subject;
import com.cst.model.User;

public interface SubjectService {

	public List<User> getAll();
	public Subject get(String id);
}
