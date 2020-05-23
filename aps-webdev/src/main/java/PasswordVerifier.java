import java.io.IOException;

import java.lang.Character;



import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import java.util.HashMap;

import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@WebServlet("/verify")
public class PasswordVerifier extends HttpServlet {
	private static final long serialVersionUID = 1L;

    @Override
	protected void doGet(final HttpServletRequest request, final HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    protected void doPost(final HttpServletRequest request, final HttpServletResponse response)
            throws ServletException, IOException {

        final String senha = request.getParameter("senha");

        char ch;
        boolean capitalFlag = false;
        boolean lowerCaseFlag = false;
        boolean numberFlag = false;
        boolean specialFlag = false;

        for(int i=0;i < senha.length();i++) {
            ch = senha.charAt(i);
            if(Character.isDigit(ch)) {
                numberFlag = true;
            }
            if (Character.isUpperCase(ch)) {
                capitalFlag = true;
            } 
            if (Character.isLowerCase(ch)) {
                lowerCaseFlag = true;
            } 
        }
        Pattern p = Pattern.compile("[^a-z0-9 ]", Pattern.CASE_INSENSITIVE);
        Matcher m = p.matcher(senha);
        specialFlag = m.find();
        
        Map<String, Boolean> flags = new HashMap<String, Boolean>();
        flags.put("number", numberFlag);
        flags.put("upper", capitalFlag);
        flags.put("lower", lowerCaseFlag);
        flags.put("special", specialFlag);

        request.setAttribute("flags", flags);
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }

}
