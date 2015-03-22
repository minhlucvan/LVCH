package models;

import play.data.validation.Constraints;
import play.db.ebean.Model;

import com.avaje.ebean.Page;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import java.util.Date;
import java.util.List;

import models.Learner;
import models.Instructor;

@Entity
public class Thesis extends Model {
	@Id
	public Long id;
	
	@Constraints.Required
	public String code;
	
	@Constraints.Required
	public String name;
	
	public String description;
	
	@OneToOne(mappedBy = "thesis")
	public  Learner learner;
	
	@OneToOne(mappedBy = "thesis")
	public  Instructor instructor;
	

	public  String date;
	
	
	public static Finder<Long, Thesis> finder = new Finder<Long, Thesis>(Long.class, Thesis.class);
	
	public Thesis(){
		
	}
	
	public Thesis(String thesisCode, String name){
		this.code = thesisCode;
		this.name = name;
	}
	
	public Thesis(String thesisCode, String name, Learner learner, Instructor instructor){
		this.code = thesisCode;
		this.name = name;
		this.learner = learner;
		this.instructor = instructor;
	}
	
	@Override
	public void save(){
		super.save();
	}
	
	public static Thesis findByCode(String code) {
        return finder.where().eq("ThesisCode", code).findUnique();

    }
	
	public String toString() {
        return String.format("%s - %s/n", code, name);
    }
	
	public static List<Thesis> findAll() {
        return finder.all();
    }
	
    public void delete() {
        super.delete();
    }

    public static Page<Thesis> page(int page, int pageSize, String sortBy, String order, String filter) {
        if (filter.matches("[\\d]*")) {
            return finder.where()
                    .ilike("code", "%" + filter + "%")
                    .orderBy(sortBy + " " + order)
                    .findPagingList(pageSize)
                    .setFetchAhead(false)
                    .getPage(page);
        } else {
            if (filter.matches("[\\D]*")) {
                return finder.where()
                        .ilike("name", "%" + filter + "%")
                        .orderBy(sortBy + " " + order)
                        .findPagingList(pageSize)
                        .setFetchAhead(false)
                        .getPage(page);
            } else {
                return finder.where()
                        .orderBy(sortBy + " " + order)
                        .findPagingList(pageSize)
                        .setFetchAhead(false)
                        .getPage(page);
            }
        }
    }

    public static Page<Thesis> find(int page) {
        return finder.where()
                .orderBy("id asc")
                .findPagingList(10)
                .setFetchAhead(false)
                .getPage(page);
    }


    public static List<Thesis> findByName(String term) {
        return finder.where().eq("name", term).findList();
    }
}
