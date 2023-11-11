package manader.hbm;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.Date;

@Entity
@Table(name = "addressbook")
public class ContactRecord {

    @Id
    public int id;
    public String firstname;
    public String lastname;
    public String address;
    public String mobile;
    public String email;

    public String nickname = "";
    public String company = "";
    public String title = "";

    public String middlename = "";
    public String home = "";
    public String work = "";
    public String fax = "";
    public String email2 = "";
    public String email3 = "";
    public String im = "";
    public String im2 = "";
    public String im3 = "";
    public String homepage = "";
    public String bmonth = "";
    public int bday = 0;
    public String byear = "";
    public int aday = 0;
    public String amonth = "";
    public String ayear = "";
    public String address2 = "";
    public String phone2 = "";
    public String notes = "";
    public String photo = "";

    public Date deprecated = null;

    public ContactRecord() {
    }

    public ContactRecord(int id, String firstname, String lastname, String address, String mobile, String email, String photo) {

        this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.address = address;
        this.mobile = mobile;
        this.email = email;
        this.photo = photo;

    }
}