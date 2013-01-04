package models;

import play.db.ebean.Model;
import javax.persistence.*;
import play.data.validation.Constraints;

@Entity
public class Category extends Model{

    @Id
    public Long id;
    @Constraints.Required
    @Constraints.MaxLength(30)
    public String label;

    public static Finder<Long, Category> find =
            new Finder<Long, Category>(Long.class, Category.class);

}