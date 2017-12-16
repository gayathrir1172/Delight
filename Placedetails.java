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
@Table(name = "PLACEDETAILS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Placedetails.findAll", query = "SELECT p FROM Placedetails p")
    , @NamedQuery(name = "Placedetails.findByPreference", query = "SELECT p FROM Placedetails p WHERE p.preference = :preference")
    , @NamedQuery(name = "Placedetails.findByPlace", query = "SELECT p FROM Placedetails p WHERE p.place = :place")
    , @NamedQuery(name = "Placedetails.findByLocation1", query = "SELECT p FROM Placedetails p WHERE p.location1 = :location1")
    , @NamedQuery(name = "Placedetails.findByDetail1", query = "SELECT p FROM Placedetails p WHERE p.detail1 = :detail1")
    , @NamedQuery(name = "Placedetails.findByLocation2", query = "SELECT p FROM Placedetails p WHERE p.location2 = :location2")
    , @NamedQuery(name = "Placedetails.findByDetail2", query = "SELECT p FROM Placedetails p WHERE p.detail2 = :detail2")
    , @NamedQuery(name = "Placedetails.findByLocation3", query = "SELECT p FROM Placedetails p WHERE p.location3 = :location3")
    , @NamedQuery(name = "Placedetails.findByDetail3", query = "SELECT p FROM Placedetails p WHERE p.detail3 = :detail3")
    , @NamedQuery(name = "Placedetails.findByLocation4", query = "SELECT p FROM Placedetails p WHERE p.location4 = :location4")
    , @NamedQuery(name = "Placedetails.findByDetail4", query = "SELECT p FROM Placedetails p WHERE p.detail4 = :detail4")})
public class Placedetails implements Serializable {
    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "PREFERENCE")
    private String preference;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "PLACE")
    private String place;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "LOCATION1")
    private String location1;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 500)
    @Column(name = "DETAIL1")
    private String detail1;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "LOCATION2")
    private String location2;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 500)
    @Column(name = "DETAIL2")
    private String detail2;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "LOCATION3")
    private String location3;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 500)
    @Column(name = "DETAIL3")
    private String detail3;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "LOCATION4")
    private String location4;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 500)
    @Column(name = "DETAIL4")
    private String detail4;
    public Placedetails() {}
    public Placedetails(String place) {
        this.place = place;}
    public Placedetails(String place, String preference, String location1, String detail1, String location2, String detail2, String location3, String detail3, String location4, String detail4) {
        this.place = place;
        this.preference = preference;
        this.location1 = location1;
        this.detail1 = detail1;
        this.location2 = location2;
        this.detail2 = detail2;
        this.location3 = location3;
        this.detail3 = detail3;
        this.location4 = location4;
        this.detail4 = detail4; }
    public String getPreference() {
        return preference;}
    public void setPreference(String preference) {
        this.preference = preference; }
    public String getPlace() {
        return place;}
    public void setPlace(String place) {
        this.place = place;}
    public String getLocation1() {
        return location1; }
    public void setLocation1(String location1) {
        this.location1 = location1;}
    public String getDetail1() {
        return detail1;}
    public void setDetail1(String detail1) {
        this.detail1 = detail1;    }
public String getLocation2() {
        return location2;}
    public void setLocation2(String location2) {
        this.location2 = location2;}
    public String getDetail2() {
        return detail2; }
    public void setDetail2(String detail2) {
        this.detail2 = detail2;
    }
    public String getLocation3() {
        return location3;}
    public void setLocation3(String location3) {
        this.location3 = location3;
    }
    public String getDetail3() {
        return detail3;
    }

    public void setDetail3(String detail3) {
        this.detail3 = detail3;
    }

    public String getLocation4() {
        return location4;
    }

    public void setLocation4(String location4) {
        this.location4 = location4;
    }

    public String getDetail4() {
        return detail4;
    }

    public void setDetail4(String detail4) {
        this.detail4 = detail4;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (place != null ? place.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Placedetails)) {
            return false;
        }
        Placedetails other = (Placedetails) object;
        if ((this.place == null && other.place != null) || (this.place != null && !this.place.equals(other.place))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "tourismPack.Placedetails[ place=" + place + " ]";
    }   
}
