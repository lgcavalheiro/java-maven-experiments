import java.io.IOException;
import java.io.PrintWriter;
import java.lang.Character;
import java.lang.CharSequence;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@WebServlet("/hello")
public class Hello extends HttpServlet {
	private static final long serialVersionUID = 1L;

    @Override
	protected void doGet(final HttpServletRequest request, final HttpServletResponse response)
            throws ServletException, IOException {
        
    }

    @Override
    protected void doPost(final HttpServletRequest request, final HttpServletResponse response)
            throws ServletException, IOException {

        final PrintWriter out = response.getWriter();
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
        specialFlag = senha.matches("[^A-Za-z0-9 ]");

        out.println("<html><body>");
        out.println("SENHA FOI ESSA MERDA AQUI Ó: " + senha + "<br/>");
        if(!numberFlag) {
            out.println("SEM NUMERO PORRA <br/>");
        }
        if (!capitalFlag) {
            out.println("SEM MAIUSCULA PORRA <br/>");
        }
        if (!lowerCaseFlag) {
            out.println("SEM MINUSCULA PORRA <br/>");
        }
        if (!specialFlag) {
            out.println("SEM CARACTER PORRA <br/>");
        }
        out.println("</body></html>");
    }

}
