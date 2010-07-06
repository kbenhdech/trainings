package models;

import java.util.*;
import javax.persistence.*;

import net.sf.oval.constraint.MaxSize;
import play.data.validation.Required;
import play.db.jpa.*;


/**
 * Created by IntelliJ IDEA.
 * User: kbenhdech
 * Date: 2 juil. 2010
 * Time: 09:35:40
 * To change this template use File | Settings | File Templates.
 */
@Entity
public class Comment extends Model {

    @Required
    public String author;

    @Required
    public Date postedAt;

    @Lob
    @Required
    @MaxSize(10000)
    public String content;

    @ManyToOne
    @Required
    public Post post;


    public Comment(Post post, String author, String content) {
        this.post = post;
        this.author = author;
        this.content = content;
        this.postedAt = new Date();
    }

    public String toString() {
        return this.post.title + " - " + this.postedAt;
    }

}

