package controllers;

import models.Bookmark;

import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;

public class Bookmarks extends Controller {

    public static Result add() {

        final Form<Bookmark> bookmarkForm = form(Bookmark.class).bindFromRequest();
        final Bookmark bookmark = bookmarkForm.get();

        bookmark.save();
        return redirect(routes.Application.index());

    }
}