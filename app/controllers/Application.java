package controllers;

import play.*;
import play.mvc.*;
import play.data.Form;

import views.html.*;
import models.UserAccount;

public class Application extends Controller {
	public static class Login {
        public String email;
        public String password;
    }
	
	public static Result login() {
	       return ok(
	          index.render(Form.form(Login.class))
	       );
	    }
	 
	    public static Result authenticate() {
	    	Form<Login> loginForm = Form.form(Login.class).bindFromRequest();
	        String email = loginForm.get().email;
	        String password = loginForm.get().password;
	 
	        session().clear();
	        
	        UserAccount usr = UserAccount.authenticate(email, password);
	        if (usr == null) {
	            flash("error", "Invalid email and/or password");
	            return redirect(routes.Application.index());       
	        }
	        String role = usr.role;
	        session("email", email);
	        session("role", role);
	        
	        if(role.equals("Global_Admin")){
	        	return redirect(routes.Thesises.list(0, "id", "asc", ""));
	        } else if(role.equals("Admin")) {
	        	return redirect(routes.Thesises.list(0, "id", "asc", ""));
	        } else if(role.equals("Learner")){
	        	return redirect(routes.Thesises.list(0, "id", "asc", ""));
	        } else if(role.equals("Instructor")){
	        	return redirect(routes.Thesises.list(0, "id", "asc", ""));
	        } else {
	        	flash("error", "authenticate faile");
	            return redirect(routes.Application.index()); 
	        }
	
	    }
	
    public static Result index() {
        return ok(index.render(Form.form(Login.class)));
    }
    
    public static Result error(){
    	return ok(error.render("error description"));
    }
    
    public static Result userCPanel() {
        return ok(cpanellayout.render(wellcome.render()));
    }
    public static Result studentlist(){
    	return ok(studentlist.render());
    }
    public static Result demo(){
    	return ok(demo.render());
    }
}
