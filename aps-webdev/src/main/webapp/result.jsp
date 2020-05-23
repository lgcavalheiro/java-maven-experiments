<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Result</title>
</head>
<body>
    <%@ page import="java.util.*" %>
    <% 
        Object flagsObj = request.getAttribute("flags");
        HashMap flags = (HashMap<String, Boolean>)flagsObj; 
    %>
    <%!
        public String processPassword(HashMap<String, Boolean> flags) {
            int failureCounter = 0;
            String output = "<ul>";
            if(flags != null && flags.get("number") == false) {
                failureCounter++;
                output += "<li>No number detected.</li>";
            }
            if(flags != null && flags.get("upper") == false) {
                failureCounter++;
                output += "<li>No upper case letter detected.</li>";
            }
            if(flags != null && flags.get("lower") == false) {
                failureCounter++;
                output += "<li>No lower case letter detected.</li>";
            }
            if(flags != null && flags.get("special") == false) {
                failureCounter++;
                output += "<li>No special character detected.</li>";
            }
            output+= "</ul>";

            switch(failureCounter) {
                case 0:
                    output += "<h3>All requirements met - Security level: <span id=\"high\">HIGH</span></h3>";
                    break;
                case 1:
                    output += "<h3>One requirement failed - Security level: <span id=\"medium\">MEDIUM</span></h3>";
                    break;
                case 2:
                    output += "<h3>Two requirements failed - Security level: <span id=\"low\">LOW</span></h3>";
                    break;
                case 3:
                    output += "<h3>Three requirements failed - Security level: <span id=\"low\">LOW</span></h3>";
                    break;
                case 4:
                    output += "<h3>All requirements failed - Security level: <span id=\"low\">LOW</span></h3>";
                    break;
                default:
                    break;
            }

            return output;
        }
    %>
    <% 
        if(flags != null){
            out.println("<div class=\"form-display\">");
            out.println("<h3>Password verified, it's security report is:</h3>");
            out.println(processPassword(flags));
            out.println("</div>");
        }
    %>
    
</body>
</html>
