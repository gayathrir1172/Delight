package tourismPack;
import java.util.List;
import javax.ejb.Local;
@Local
public interface UseraccountsFacadeLocal {
    void create(Useraccounts useraccounts);
    void edit(Useraccounts useraccounts);
    void remove(Useraccounts useraccounts);
    Useraccounts find(Object id);
    List<Useraccounts> findAll();
    List<Useraccounts> findRange(int[] range);
    int count();
    boolean insertUser(String username, String password, String email, String preference, String type);
    String loginUser(String uname, String pwd);}
