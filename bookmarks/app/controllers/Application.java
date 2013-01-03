package controllers;

import models.Bookmark;
import models.Category;
import play.*;
import play.mvc.*;

import views.html.*;

public class Application extends Controller {
  
  public static Result index() {
    return ok(index.render(
            "Vous pouvez commencer à saisir ...",
            Bookmark.find.fetch("category").orderBy("title").findList(),
            Category.find.orderBy("label").findList()
    ));
  }
  
}