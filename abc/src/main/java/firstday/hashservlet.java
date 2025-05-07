package firstday;

import java.io.IOException;
import java.io.PrintWriter;
import java.security.MessageDigest;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/HashServlet")
public class hashservlet extends HttpServlet  {
	
	 protected void doPost(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {
	        String input = request.getParameter("inputText");
	        String hash = generateHash(input);

	        response.setContentType("text/html");
	        PrintWriter out = response.getWriter();

	        out.println("<html><body>");
	        out.println("<h3>Input: " + input + "</h3>");
	        out.println("<h3>SHA-256 Hash: " + hash + "</h3>");
	        out.println("<a href='index.html'>Go Back</a>");
	        
	        
	        out.println("</body></html>");
	    }
	 
	 private String generateHash(String input) {
	        try {
	            MessageDigest md = MessageDigest.getInstance("SHA-256");
	            byte[] digest = md.digest(input.getBytes("UTF-8"));

	            StringBuilder hex = new StringBuilder();
	            for (byte b : digest) {
	                hex.append(String.format("%02x", b));
	            }
	            return hex.toString();

	        } catch (Exception e) {
	            return "Error generating hash";
	        }
	    }
	 
	 

}

