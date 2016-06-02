package com.cst.service;

import java.util.List;

import com.cst.model.Subject;

public interface SubjectService {

	public List<Subject> getAll();
	public Subject get(String id);
}
