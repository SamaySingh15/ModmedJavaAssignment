package parkingsystem.accounts;

public class Contactdetails {
    public void setPhone(String phone){
        this.phone=phone;
    }
    public String getPhone(){
        return phone;
    }
    private String phone;

    public void setEmail(String email){
        this.email=email;
    }
    public String getEmail(){
        return email;
    }
    private String email;

    public void setAddress(String address){
        this.address=address;
    }
    public String getAddress(){
        return this.address;
    }
    private String address;

    public void setPersonalInfo(String personalInfo){
        this.personalInfo= personalInfo;
    }
    public String getPersonalInfo(){
        return personalInfo;
    }
    private String personalInfo;

    public Contactdetails(String phone , String email , String address , String personalInfo){
        this.setPhone(phone);
        this.setEmail(email);
        this.setAddress(address);
        this.setPersonalInfo(personalInfo);
    }
}
