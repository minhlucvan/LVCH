package models;
 
import play.data.validation.Constraints;
import play.db.ebean.Model;
import javax.persistence.OneToOne; 

import javax.persistence.Entity;
import javax.persistence.Id;
 
@Entity
public class UserAccount extends Model {
    @Id
    public Long id;
    @Constraints.Required
    public String email;
    @Constraints.Required
    public String password;
    @Constraints.Required
    public String role;
    
    public String name;
    public byte[] picture;
    
    public UserAccount() { }
    public UserAccount(String email, String password,String role) {
        this.email = email;
        this.password = password;
        this.role = role;
    }
    
    
    public static UserAccount authenticate(String email, String password) {
       if(Learner.authenticate(email, password) != null){
        	return Learner.authenticate(email, password);
       } else if(Instructor.authenticate(email, password) != null){
    	   return Instructor.authenticate(email, password);
       } else {
    	   return Admin.authenticate(email, password);
       }

    }
}