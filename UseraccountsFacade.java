package tourismPack;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.sql.*;
@Stateless
public class UseraccountsFacade extends AbstractFacade<Useraccounts> implements UseraccountsFacadeLocal {

    @PersistenceContext(unitName = "TouristGuide-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public UseraccountsFacade() {
        super(Useraccounts.class);
    }

    @Override
    public boolean insertUser(String username, String password, String email, String preference, String type) {
        try{
           Useraccounts u = new Useraccounts();
           u.setUsername(username);
           u.setPassword(password);
           u.setEmail(email);
           u.setPreference(preference);
           u.setType(type);
           em.persist(u);
           return true;
        }
        catch(Exception e){
            return false;
        }
    }

    @Override
    public String loginUser(String uname, String pwd) {
        try{
            Useraccounts u = new Useraccounts();
            String user, pass, mail, preference, type;
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            Connection con = DriverManager.getConnection("jdbc:derby://localhost:1527/Tourism","tour","tour");
            Statement st = con.createStatement();
            String query = "select * from useraccounts";
            ResultSet rst = st.executeQuery(query);
            while(rst.next()){
                user = rst.getString("username");
                pass = rst.getString("password");
                mail = rst.getString("email");
                preference = rst.getString("preference");
                type = rst.getString("type");
                if(user.equals(uname)&&(pass.equals(pwd))){
                    System.out.println(uname);
                    System.out.println(user);
                    System.out.println(pass);
                    System.out.println(pwd);
                    return type;
                }
            }
        }
        catch(Exception e){
            System.out.println(e);
        }
        return "Not a user";}        
        }
