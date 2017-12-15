import java.io.IOException;
import java.io.PrintWriter;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import tourismPack.UseraccountsFacadeLocal;
@WebServlet(urlPatterns = {"/registerServlet"})
public class registerServlet extends HttpServlet {
    @EJB
    private UseraccountsFacadeLocal useraccountsFacade;
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            PrintWriter out = response.getWriter();
            response.setContentType("text/html");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>");
            out.println("Registration");
            out.println("</title>");
            out.println("</head>");
            out.println("<body>");
            String username, password, email, type, preference;
            boolean result;
            username = request.getParameter("username");
            password = request.getParameter("password");
            email = request.getParameter("email");
            type = request.getParameter("type");
            preference = request.getParameter("preference");
            result = useraccountsFacade.insertUser(username, password, email, preference, type);
            if(result){
                out.println("<center>");
                out.println("<a href=\"login.html\">Login</a><br />");
                out.println("User registered successfully!!!");
                out.println("</center>");
            }
            else{
                out.println("User registration failed!!!");}
            out.println("</body>");
            out.println("</html>");}}
