package models;

import java.util.*;
import javax.persistence.*;

import play.db.jpa.*;

/**
 * Created by IntelliJ IDEA.
 * User: kbenhdech
 * Date: 1 juil. 2010
 * Time: 13:52:16
 * To change this template use File | Settings | File Templates.
 */
@Entity
public class User extends Model {

    public String email;
    
    public String password;

    public String fullname;

    public boolean isAdmin;

    public User(String email, String password, String fullname) {
        this.email = email;
        this.password = password;
        this.fullname = fullname;
    }

public static User connect(String email, String password) {
    return find("byEmailAndPassword", email, password).first();
}
    

}

