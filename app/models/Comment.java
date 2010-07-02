package models;

import java.util.*;
import javax.persistence.*;
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

    public String author;

    public Date postedAt;

    @Lob
    public String content;

    @ManyToOne
    public Post post;

    public Comment(Post post, String author, String content) {
        this.post = post;
        this.author = author;
        this.content = content;
        this.postedAt = new Date();
    }

}

