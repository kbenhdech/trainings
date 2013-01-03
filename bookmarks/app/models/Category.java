package models;

import play.db.ebean.Model;
import javax.persistence.*;

@Entity
public class Category extends Model{

    @Id
    public Long id;
    public String label;

    public static Finder<Long, Category> find =
            new Finder<Long, Category>(Long.class, Category.class);

}