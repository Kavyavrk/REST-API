package practiceserialization;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.core.exc.StreamWriteException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;

class Project1
{
	String projectName;
	String projectstatus;
	int teamSize;
	List<String> teammember;
	ProjectManager projectManager;
	
	
	
	public Project1(String projectName, String projectstatus, int teamSize, List<String> teammember,
			ProjectManager projectManager) {
		super();
		this.projectName = projectName;
		this.projectstatus = projectstatus;
		this.teamSize = teamSize;
		this.teammember = teammember;
		this.projectManager = projectManager;
	}
	public String getProjectName() {
		return projectName;
	}
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	public String getProjectstatus() {
		return projectstatus;
	}
	public void setProjectstatus(String projectstatus) {
		this.projectstatus = projectstatus;
	}
	public int getTeamSize() {
		return teamSize;
	}
	public void setTeamSize(int teamSize) {
		this.teamSize = teamSize;
	}
	public List<String> getTeammember() {
		return teammember;
	}
	public void setTeammember(List<String> teammember) {
		this.teammember = teammember;
	}
	public ProjectManager getProjectManager() {
		return projectManager;
	}
	public void setProjectManager(ProjectManager projectManager) {
		this.projectManager = projectManager;
	}
	
	
}
class ProjectManager
{
	String name;
	String id;
	
	public ProjectManager(String name, String id) {
		super();
		this.name = name;
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
}
public class Run_POJO
{
	public static void main(String[] args) throws StreamWriteException, DatabindException, IOException
	{
		List<String> lst= new ArrayList<String>();
		lst.add("john");
		lst.add("devid");
		lst.add("stev");
		ProjectManager pm= new ProjectManager("sagar", "tp01");
		Project1 p=new Project1("deepak", "created", 10, lst, pm);
		System.out.println(p.projectName);//access the data available
		
		//to convert object back to json file
		ObjectMapper om=new ObjectMapper();
		om.writeValue(new File("./project1.json"), p);//serialization converting pojoobject(p) back to json file
	}
}
