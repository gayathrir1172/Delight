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
@WebServlet(urlPatterns = {"/view"})
public class view extends HttpServlet {
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
            String place = request.getParameter("place");
            out.println(place);
            ArrayList<String> result = placedetailsFacade.viewPlaceDetails(place);
            for(String i:result){
                out.println("<h4>"+i+"</h4><br />");}
            out.println("</body>");
            out.println("</html>");}}
