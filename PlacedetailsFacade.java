package tourismPack;
import java.sql.*;
import java.sql.DriverManager;
import java.util.ArrayList;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
@Stateless
public class PlacedetailsFacade extends AbstractFacade<Placedetails> implements PlacedetailsFacadeLocal {

    @PersistenceContext(unitName = "TouristGuide-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PlacedetailsFacade() {
        super(Placedetails.class);
    }

    @Override
    public boolean addPlace(String preference, String place, String location1, String detail1, String location2, String detail2, String location3, String detail3, String location4, String detail4) {
        try{
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/Tourism","tour","tour");
            PreparedStatement ps = con.prepareStatement("insert into placedetails values(?,?,?,?,?,?,?,?,?,?)");
            ps.setString(1, preference);
            ps.setString(2, place);
            ps.setString(3,location1);
            ps.setString(4,detail1);
            ps.setString(5,location2);
            ps.setString(6,detail2);
            ps.setString(7,location3);
            ps.setString(8,detail3);
            ps.setString(9,location4);
            ps.setString(10,detail4);
            int i = ps.executeUpdate();
            if(i>0){
                return true;}}
        catch(Exception e){
            System.out.println(e);
        }
        return false;
    }
    @Override
    public ArrayList<String> getPlaces(String category) {
        ArrayList<String> places = new ArrayList<String>();
        try{
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/Tourism","tour","tour");
            Statement st = con.createStatement();
            ResultSet rst = st.executeQuery("select * from PLACEDETAILS");
            while(rst.next()){
                String preference = rst.getString("preference");
                String place = rst.getString("place");
                String loc1 = rst.getString("location1");
                String det1 = rst.getString("detail1");
                String loc2 = rst.getString("location2");
                String det2 = rst.getString("detail2");
                String loc3 = rst.getString("location3");
                String det3 = rst.getString("detail3");
                String loc4 = rst.getString("location4");
                String det4 = rst.getString("detail4");
                if(category.equals(preference)){
                    System.out.println(place);
                    places.add(place);
                }
            }
        }
        catch(Exception e){
            System.out.println(e);
        }
        return places;
    }

    @Override
    public ArrayList<String> viewPlaceDetails(String place) {
        ArrayList<String> details = new ArrayList<String>();
        try{
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/Tourism","tour","tour");
            Statement st = con.createStatement();
            ResultSet rst = st.executeQuery("select * from PLACEDETAILS");
            while(rst.next()){
                String preference = rst.getString("preference");
                String placeToBeViewed = rst.getString("place");
                String loc1 = rst.getString("location1");
                String det1 = rst.getString("detail1");
                String loc2 = rst.getString("location2");
                String det2 = rst.getString("detail2");
                String loc3 = rst.getString("location3");
                String det3 = rst.getString("detail3");
                String loc4 = rst.getString("location4");
                String det4 = rst.getString("detail4");
                if(placeToBeViewed.equals(place)){
                    System.out.println(place);
                    details.add(loc1);
                    details.add(det1);
                    details.add(loc2);
                    details.add(det2);
                    details.add(loc3);
                    details.add(det3);
                    details.add(loc4);
                    details.add(det4);
                }
            }
        }
        catch(Exception e){
            System.out.println(e);
        }
        return details;
    }  
}
