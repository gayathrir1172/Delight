import java.io.IOException;
import java.io.PrintWriter;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import tourismPack.UseraccountsFacadeLocal;
@WebServlet(urlPatterns = {"/loginServlet"})
public class loginServlet extends HttpServlet {
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
            out.println("Login");
            out.println("</title>");
            out.println("</head>");
            out.println("<body>");
            String username, password;
            String result;
            username = request.getParameter("username");
            password = request.getParameter("password");
            result = useraccountsFacade.loginUser(username, password);
            if(result.equals("Not a user")){
                out.println("<center><h2>");
                out.println("Incorrect username or password. Please try again!!!");
                out.println("<a href=\"login.html\">Login</a><br />");
                out.println("</h2></center>");}
            else{
                if(result.equals("Tourist")){
                    out.println("<center><h2>");
                    out.println("<a href=\"home.html\">Home</a><br />");
                    out.println(username+", You have logged in successfully!!!Click on the link to move to home page...");
                    out.println("</h2></center>");
                }
                else{
                    out.println("<center><h2>");
                    out.println("<a href=\"guideHome.html\">Home</a><br />");
                    out.println(username+", You have logged in successfully!!!Click on the link to move to home page...");
                    out.println("</h2></center>");}}
            out.println("</body>");
            out.println("</html>");}}
