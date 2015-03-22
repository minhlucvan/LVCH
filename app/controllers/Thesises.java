package controllers;

import java.util.ArrayList;
import java.util.List;

import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;
import play.mvc.Security;
import com.avaje.ebean.Page;
import play.mvc.Security;

import models.*;
import views.html.*;

@Security.Authenticated(Secured.class)
public class Thesises extends Controller {
	
    private static final Form<Thesis> ThesisForm = Form.form(Thesis.class);

    public static Result newThesis() {
        return ok(newthesis.render(ThesisForm));
    }

    public static Result details(Thesis thesis) {

        return ok();
    }

    public static Result detailsReadOnly(Thesis Thesis) {
        return TODO;
    }

    public static Result save() {
    	Form<Thesis> thesisF = ThesisForm.bindFromRequest();
        if (thesisF.hasErrors()) {
            flash("error", "Please correct the form below.");
            return badRequest();
        }
        Thesis thesis = thesisF.get();
    	thesis.save();
    	
        return listnoarg();
       
    }

    public static Result delete(String ean) {
    	return TODO;
    }

    /*
    public static Result list(Integer page) {
        Page<Thesis> Thesiss = Thesis.find(page);
        return ok(views.html.listThesis.render(Thesiss));
    }
    */
    
    public static Result listnoarg() {
    	return list(0, "id", "asc", "");
    }
    
    public static Result list(Integer page, String sortBy, String order, String filter) {
    	Page<Thesis> crrentpage = Thesis.find(page);
    	return ok(thesislist.render(crrentpage, sortBy, order, filter));
    }
	
}
