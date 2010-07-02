package models;

import java.util.*;
import javax.persistence.*;

import play.db.jpa.*;

/**
 * Created by IntelliJ IDEA.
 * User: kbenhdech
 * Date: 2 juil. 2010
 * Time: 09:29:49
 * To change this template use File | Settings | File Templates.
 */
@Entity
public class Post extends Model {

    public String title;

    public Date postedAt;

    @Lob
    public String content;

    @ManyToOne
    public User author;

    @OneToMany(mappedBy="post", cascade=CascadeType.ALL)
    public List<Comment> comments;

    public Post(User author, String title, String content) {
        this.comments = new ArrayList<Comment>();
        this.author = author;
        this.title = title;
        this.content = content;
        this.postedAt = new Date();
    }

    public Post addComment(String author, String content) {
        Comment newComment = new Comment(this, author, content).save();
        this.comments.add(newComment);
        return this;
    }


}
