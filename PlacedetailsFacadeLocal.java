package tourismPack;

import java.util.ArrayList;
import java.util.List;
import javax.ejb.Local;
@Local
public interface PlacedetailsFacadeLocal {

    void create(Placedetails placedetails);

    void edit(Placedetails placedetails);

    void remove(Placedetails placedetails);

    Placedetails find(Object id);

    List<Placedetails> findAll();

    List<Placedetails> findRange(int[] range);

    int count();

    boolean addPlace(String preference, String place, String location1, String detail1, String location2, String detail2, String location3, String detail3, String location4, String detail4);

    ArrayList<String> getPlaces(String category);

    ArrayList<String> viewPlaceDetails(String place);
 
}

UserAccounts.java

package tourismPack;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
@Entity
@Table(name = "USERACCOUNTS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Useraccounts.findAll", query = "SELECT u FROM Useraccounts u")
    , @NamedQuery(name = "Useraccounts.findByUsername", query = "SELECT u FROM Useraccounts u WHERE u.username = :username")
    , @NamedQuery(name = "Useraccounts.findByPassword", query = "SELECT u FROM Useraccounts u WHERE u.password = :password")
    , @NamedQuery(name = "Useraccounts.findByEmail", query = "SELECT u FROM Useraccounts u WHERE u.email = :email")
    , @NamedQuery(name = "Useraccounts.findByPreference", query = "SELECT u FROM Useraccounts u WHERE u.preference = :preference")
    , @NamedQuery(name = "Useraccounts.findByType", query = "SELECT u FROM Useraccounts u WHERE u.type = :type")})
public class Useraccounts implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "USERNAME")
    private String username;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "PASSWORD")
    private String password;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "EMAIL")
    private String email;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 40)
    @Column(name = "PREFERENCE")
    private String preference;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "TYPE")
    private String type;

    public Useraccounts() {
    }

    public Useraccounts(String username) {
        this.username = username;
    }

    public Useraccounts(String username, String password, String email, String preference, String type) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.preference = preference;
        this.type = type;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPreference() {
        return preference;
    }

    public void setPreference(String preference) {
        this.preference = preference;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (username != null ? username.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Useraccounts)) {
            return false;
        }
        Useraccounts other = (Useraccounts) object;
        if ((this.username == null && other.username != null) || (this.username != null && !this.username.equals(other.username))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "tourismPack.Useraccounts[ username=" + username + " ]";
    }   
}
