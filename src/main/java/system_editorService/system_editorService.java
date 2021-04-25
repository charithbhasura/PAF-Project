package system_editorService;

import javax.swing.text.Document;
import javax.swing.text.html.parser.Parser;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import project.project;
import projectService.JsonObject;
import projectService.JsonParser;
import system_editor.system_editor;

public class system_editorService {

	system_editor sysObj = new system_editor(); 
	@GET
	@Path("/") 
	@Produces(MediaType.TEXT_HTML) 
	public String readsystem_editor() 
	{ 
		return sysObj.readsystem_editor();
	}

	@POST
	@Path("/") 
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED) 
	@Produces(MediaType.TEXT_PLAIN) 
	public String addsystem_editor(@FormParam("sid") String sid, 
			@FormParam("username") String username, 
			@FormParam("email") String email,
			@FormParam("password") String password)
	{ 
			String output = sysObj.addsystem_editor(sid, username, email,password);
			return output; 
	}
	
	@PUT
	@Path("/") 
	@Consumes(MediaType.APPLICATION_JSON) 
	@Produces(MediaType.TEXT_PLAIN) 
	public String updatesystem_editor(String systData) 
	{ 
		//Convert the input string to a JSON object 
		JsonObject itemObject = new JsonParser().parse(systData).getAsJsonObject(); 
		
		//Read the values from the JSON object
		String sid = itemObject.get("sid").getAsString(); 
		String username = itemObject.get("username").getAsString(); 
		String email = itemObject.get("email").getAsString(); 
		String password = itemObject.get("password").getAsString(); 
		
		String output = sysObj.updatesystem_editor(sid, username, email,password);
		
		return output; 
	}
	
	@DELETE
	@Path("/") 
	@Consumes(MediaType.APPLICATION_XML) 
	@Produces(MediaType.TEXT_PLAIN) 
	public String deletesystem_editor(String sysData) 
	{ 
		//Convert the input string to an XML document
		Document doc = Jsoup.parse(sysData, "", Parser.xmlParser()); 
 
		//Read the value from the element <itemID>
		String sid = doc.select("sid").text(); 
		String output = sysObj.deletesystem_editor(sid);
		return output; 
	}
	
}
