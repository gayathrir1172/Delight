import java.io.IOException;
import java.io.PrintWriter;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import tourismPack.PlacedetailsFacadeLocal;
@WebServlet(urlPatterns = {"/addPlace"})
public class addPlace extends HttpServlet {
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
            out.println("Login");
            out.println("</title>");
            out.println("</head>");
            out.println("<body>");
            String category = request.getParameter("category");
            String place = request.getParameter("place");
            String loc1 = request.getParameter("loc1");
            String det1 = request.getParameter("det1");
            String loc2 = request.getParameter("loc2");
            String det2 = request.getParameter("det2");
            String loc3 = request.getParameter("loc3");
            String det3 = request.getParameter("det3");
            String loc4 = request.getParameter("loc4");
            String det4 = request.getParameter("det4");
            boolean result = placedetailsFacade.addPlace(category, place, loc1, det1, loc2, det2, loc3, det3, loc4, det4);
            if(result){
                out.println("Place added successfully!!!");
                out.println("<a href=\"guideHome.html\">Home</a><br />");
            }
            else{
                out.println("<h4>Place not added because of one of the following reasons...</h4><br />");
                out.println("<h4>1.The place might already exist.</h4><br />");
                out.println("<h4>2.The details about the location must not be beyond 500 characters.</h4><br />");
            }
            out.println("</body>");
            out.println("</html>");}}
