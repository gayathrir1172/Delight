import java.sql.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import tourismPack.PlacedetailsFacadeLocal;
@WebServlet(urlPatterns = {"/viewPlace"})
public class viewPlace extends HttpServlet {
    @EJB
    private PlacedetailsFacadeLocal placedetailsFacade;
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter out = response.getWriter();
            response.setContentType("text/html");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>");
            out.println("Tourism");
            out.println("</title>");
            out.println("</head>");
            out.println("<body>");
            String category = request.getParameter("category");
            out.println("<h2>"+category+"</h2><br /><h4>Following are the list of places : </h4><br />");
            ArrayList<String> result = placedetailsFacade.getPlaces(category);
            out.println("<form method=\"post\" action=\"view\">");
            out.println("<select name=\"place\">");
            for(String i:result){
                out.println("<option value=\""+i+"\">"+i+"</option>");}
            out.println("</select>");
            out.println("<input type=\"submit\" value=\"View this place\"/><br />");
            out.println("</form>");
            out.println("</body>");
            out.println("</html>");}}
