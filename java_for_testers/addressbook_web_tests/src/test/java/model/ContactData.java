package model;

public record ContactData(String id, String first_name, String last_name, String address, String mobile, String e_mail, String photo) {

    public ContactData() {
        this("", "", "", "", "", "","src/test/resources/images/avatar.png");
    }

    public ContactData withId(String id) {
        return new ContactData(id, this.first_name, this.last_name, this.address, this.mobile, this.e_mail, this.photo);

    }

    public ContactData withFirstName(String first_name) {
        return new ContactData(this.id, first_name, this.last_name, this.address, this.mobile, this.e_mail, this.photo);

    }

    public ContactData withLastName(String last_name) {
        return new ContactData(this.id, this.first_name, last_name, this.address, this.mobile, this.e_mail, this.photo);

    }

    public ContactData withAddress(String address) {
        return new ContactData(this.id, this.first_name, this.last_name, address, this.mobile, this.e_mail, this.photo);

    }

    public ContactData withMobile(String mobile) {
        return new ContactData(this.id, this.first_name, this.last_name, this.address, mobile, this.e_mail, this.photo);

    }

    public ContactData withEmail(String e_mail) {
        return new ContactData(this.id, this.first_name, this.last_name, this.address, this.mobile, e_mail, this.photo);

    }

    public ContactData withPhoto(String photo) {
        return new ContactData(this.id, this.first_name, this.last_name, this.address, this.mobile, this.e_mail, photo);

    }
}