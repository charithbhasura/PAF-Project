package projectservice;
import javax.swing.text.Document;
import javax.swing.text.html.parser.Parser;
//For REST Service
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

//For XML
import org.jsoup.*;
import org.jsoup.parser.*;

//For JSON
import com.google.code.gson.*;

import project.project;

@SuppressWarnings("unused")
@Path("/project") 

public class projectservice {

	project proObj = new project(); 
	@GET
	@Path("/") 
	@Produces(MediaType.TEXT_HTML) 
	public String readProject() 
	{ 
		return proObj.readProject();
	}

	@POST
	@Path("/") 
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED) 
	@Produces(MediaType.TEXT_PLAIN) 
	public String addProject(@FormParam("pid") String pid, 
			@FormParam("pname") String pname, 
			@FormParam("pdescription") String pdescription,
			@FormParam("pprice") String pprice)
	{ 
			String output = proObj.addProject(pid, pname, pdescription,pprice);
			return output; 
	}
	
	@PUT
	@Path("/") 
	@Consumes(MediaType.APPLICATION_JSON) 
	@Produces(MediaType.TEXT_PLAIN) 
	public String updateProject(String projectData) 
	{ 
		//Convert the input string to a JSON object 
		JsonObject itemObject = new JsonParser().parse(projectData).getAsJsonObject(); 
		
		//Read the values from the JSON object
		String pid = itemObject.get("pid").getAsString(); 
		String pname = itemObject.get("pname").getAsString(); 
		String pdescription = itemObject.get("pdescription").getAsString(); 
		String pprice = itemObject.get("pprice").getAsString(); 
		
		String output = proObj.updateProject(pid, pname, pdescription, pprice);
		
		return output; 
	}
	
	@DELETE
	@Path("/") 
	@Consumes(MediaType.APPLICATION_XML) 
	@Produces(MediaType.TEXT_PLAIN) 
	public String deleteProject(String projectData) 
	{ 
		//Convert the input string to an XML document
		Document doc = Jsoup.parse(projectData, "", Parser.xmlParser()); 
 
		//Read the value from the element <itemID>
		String pid = doc.select("pid").text(); 
		String output = proObj.deleteProject(pid);
		return output; 
	}
}
