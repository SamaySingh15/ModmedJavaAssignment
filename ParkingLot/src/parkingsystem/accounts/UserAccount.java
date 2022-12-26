package parkingsystem.accounts;

import java.util.Scanner;

public class UserAccount {
    public void setId(String id){
        this.id=id;
    }
    public String getId(){
        return this.id;
    }
    private String id;

    public void setUserName(String userName){
        this.userName=userName;
    }
    public String getUserName(){
        return this.userName;
    }
    private String userName;

    public void setEmail(String email){
        this.email= email;
    }
    public String getEmail(){
        return this.email;
    }
    private String email;

    public void setPassword(String password){
        this.password=password;
    }
    public String getPassword(){
        return this.password;
    }
    private String password;

    public void setContactdetails(String phone , String email , String address , String personalInfo){
        this.contact = new Contactdetails(phone , email, address , personalInfo);

    }
    public String getContactdetails(){
        Scanner sc = new Scanner(System.in);
        System.out.println("press 1 for phone \n press 2 for email \n press 3 for address \n press 4 for personalInfo ");
        int x = sc.nextInt();
        if(x==1){
            return contact.getPhone();
        }
        else if(x==2){
            return contact.getEmail();
        }
        else if(x==3){
            return contact.getAddress();
        }
        else if(x==4){
            return contact.getPersonalInfo();
        }
        else return "please select correct option";
    }
    private Contactdetails contact;
    public UserAccount(String id , String userName , String email , String password , String personalInfo ,String address ,String phone){
        this.setId(id);
        this.setEmail(email);
        this.setUserName(userName);
        this.setPassword(password);
        this.setContactdetails(phone ,email , address ,personalInfo);
    }

}
