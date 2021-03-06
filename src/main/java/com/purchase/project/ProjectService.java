package com.purchase.project;

import java.util.List;

import com.purchase.bean.Project;

public interface ProjectService {

	public List<Project> getAllProjects();
	
	public Project getPorjectById(int id);
	
	public boolean submit(Project project);
}
