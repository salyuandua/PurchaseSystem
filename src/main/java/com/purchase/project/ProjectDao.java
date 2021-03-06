package com.purchase.project;

import java.util.List;

import com.purchase.bean.Project;

public interface ProjectDao {

	
	public List<Project> getAllProjects();
	
	public Project getPorjectById(int id);
	
	public void transferState();
	
	public boolean submit(Project project);
}
