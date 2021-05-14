package system_editor;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/system_editorAPI")
public class system_editorAPI extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	 system_editor system_editorObj = new system_editor();
	 
    public system_editorAPI() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String output = system_editorObj.addsystem_editor(request.getParameter("sid"), 
				request.getParameter("username"),
				request.getParameter("email"),
				request.getParameter("password")); 
				response.getWriter().write(output);
		
		doGet(request, response);
	}
	
	
	// Convert request parameters to a Map
		private static Map getParasMap(HttpServletRequest request) 
		{ 
			Map<String, String> map = new HashMap<String, String>(); 
			try
			{ 
				 Scanner scanner = new Scanner(request.getInputStream(), "UTF-8"); 
				 String queryString = scanner.hasNext() ? 
				 scanner.useDelimiter("\\A").next() : ""; 
				 scanner.close(); 
				 String[] params = queryString.split("&"); 
				 for (String param : params) 
				 { 
					 String[] p = param.split("=");
					 map.put(p[0], p[1]); 
				 } 
			} 
			catch (Exception e) 
			{ 
				
			} 
				return map; 
			}

	
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Map paras = getParasMap(request); 
		String output = system_editorObj.updatesystem_editor(paras.get("sid").toString(), 
		paras.get("username").toString(),
		paras.get("email").toString(),
		paras.get("password").toString()); 
		response.getWriter().write(output);
		
	}


	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		Map paras = getParasMap(request); 
		String output = system_editorObj.deletesystem_editor(paras.get("sid").toString()); 
		response.getWriter().write(output); 
	}

}
