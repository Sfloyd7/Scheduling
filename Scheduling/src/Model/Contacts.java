package Model;

public class Contacts {

    private int Contact_ID;
    private String ContactName;
    private String Email;

    public Contacts(int contact_id, String contactName, String email) {
        Contact_ID = contact_id;
        ContactName = contactName;
        Email = email;
    }

    public int getContact_ID() {
        return Contact_ID;
    }

    public void setContact_ID(int contact_ID) {
        Contact_ID = contact_ID;
    }

    public String getContactName() {
        return ContactName;
    }

    public void setContactName(String contactName) {
        ContactName = contactName;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }





}
