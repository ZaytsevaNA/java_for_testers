package model;

public record ContactData(String id, String first_name, String last_name, String address, String mobile, String e_mail) {

    public ContactData() {
        this("", "", "", "", "", "");
    }

    public ContactData withId(String id) {
        return new ContactData(id, first_name, this.last_name, this.address, this.mobile, this.e_mail);

    }
    public ContactData withFirstName(String first_name) {
        return new ContactData(this.id, first_name, this.last_name, this.address, this.mobile, this.e_mail);

    }

    public ContactData withLastName(String last_name) {
        return new ContactData(this.id, this.first_name, last_name, this.address, this.mobile, this.e_mail);

    }

    public ContactData withAddress(String address) {
        return new ContactData(this.id, this.first_name, this.last_name, address, this.mobile, this.e_mail);

    }

    public ContactData withMobile(String mobile) {
        return new ContactData(this.id, this.first_name, this.last_name, this.address, mobile, this.e_mail);

    }

    public ContactData withEmail(String e_mail) {
        return new ContactData(this.id, this.first_name, this.last_name, this.address, this.mobile, e_mail);

    }
}