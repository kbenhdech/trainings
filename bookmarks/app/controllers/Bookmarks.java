package controllers;

import models.Bookmark;

import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import play.*;
import play.mvc.*;
import static play.libs.Json.toJson;

@Security.Authenticated(SecuredJson.class)
public class Bookmarks extends Controller {

    public static Result add() {

        final Form<Bookmark> bookmarkForm = form(Bookmark.class).bindFromRequest();
        final Bookmark bookmark = bookmarkForm.get();

        bookmark.save();
        return redirect(routes.Application.index());

    }

    public static Result jsonList() {
        Map<String, List<Bookmark>> data = new HashMap<String, List<Bookmark>>();
        List<Bookmark> list = Bookmark.find.orderBy("title").findList();
        data.put("bookmarks", list);
        return ok(toJson(data));
    }
}