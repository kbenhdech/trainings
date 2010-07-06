package models;

import java.util.*;
import javax.persistence.*;

import play.data.validation.Required;
import play.db.jpa.*;

/**
 * Created by IntelliJ IDEA.
 * User: Karim
 * Date: 6 juil. 2010
 * Time: 19:05:28
 * To change this template use File | Settings | File Templates.
 */
@Entity
public class Tag extends Model implements Comparable<Tag> {

    @Required
    public String name;

    private Tag(String name) {
        this.name = name;
    }

    public String toString() {
        return name;
    }

    public int compareTo(Tag otherTag) {
        return name.compareTo(otherTag.name);
    }

    public static Tag findOrCreateByName(String name) {
        Tag tag = Tag.find("byName", name).first();
        if(tag == null) {
            tag = new Tag(name);
        }
        return tag;
    }

}

