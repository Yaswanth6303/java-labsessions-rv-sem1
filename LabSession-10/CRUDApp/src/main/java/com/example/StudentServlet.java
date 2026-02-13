package com.example;

import java.io.IOException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/")
public class StudentServlet extends HttpServlet {
	
	private void sendResponse(HttpServletResponse response, String message) 
			throws IOException {
		response.setContentType("text/plain");
		response.getWriter().println(message);	
	}

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        sendResponse(response, "Hello from GET");
    }

    @Override	
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        sendResponse(response, "Hello from POST");
    }
    
    @Override
    protected void doPut(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        sendResponse(response, "Hello from PUT");
    }
    
    @Override
    protected void doDelete(HttpServletRequest request, HttpServletResponse response)
            throws IOException {
        sendResponse(response, "Hello from DELETE");
    }
}
