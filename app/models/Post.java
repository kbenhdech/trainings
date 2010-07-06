package models;


import play.data.validation.*;
import play.db.jpa.Model;

import javax.persistence.*;
import java.util.*;

/**
 * Created by IntelliJ IDEA.
 * User: kbenhdech
 * Date: 2 juil. 2010
 * Time: 09:29:49
 * To change this template use File | Settings | File Templates.
 */
@Entity
public class Post extends Model {

    @Required
    public String title;

    @Required
    public Date postedAt;

    @Lob
    @Required
    @MaxSize(10000)
    public String content;

    @Required
    @ManyToOne
    public User author;


    @OneToMany(mappedBy="post", cascade=CascadeType.ALL)
    public List<Comment> comments;

    @ManyToMany(cascade=CascadeType.PERSIST)
    public Set<Tag> tags;


    public Post(User author, String title, String content) {
        this.comments = new ArrayList<Comment>();
        this.tags = new TreeSet<Tag>();
        this.author = author;
        this.title = title;
        this.content = content;
        this.postedAt = new Date();
    }

    public Post tagItWith(String name) {
        tags.add(Tag.findOrCreateByName(name));
        return this;
    }

    public static List<Post> findTaggedWith(String tag) {
        return Post.find(
                "select distinct p from Post p join p.tags as t where t.name = ?", tag
        ).fetch();
    }

    public static List<Post> findTaggedWith(String... tags) {
        return Post.find(
                "select distinct p.id from Post p join p.tags as t where t.name in (:tags) group by p.id having count(t.id) = :size"
        ).bind("tags", tags).bind("size", tags.length).fetch();
    }

    public Post addComment(String author, String content) {
        Comment newComment = new Comment(this, author, content).save();
        this.comments.add(newComment);
        return this;
    }

    public static List<Map> getCloud() {
        List<Map> result = Tag.find(
                "select new map(t.name as tag, count(p.id) as pound) from Post p join p.tags as t group by t.name"
        ).fetch();
        return result;
    }

    public Post previous() {
        return Post.find("postedAt < ? order by postedAt desc", postedAt).first();
    }

    public Post next() {
        return Post.find("postedAt > ? order by postedAt asc", postedAt).first();
    }

    public String toString() {
        return this.title;
    }
}
