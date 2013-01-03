package controllers;

import models.Category;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;

public class Categories extends Controller {

    public static Result add() {

        final Form<Category> categoryForm = form(Category.class).bindFromRequest();
        final Category category = categoryForm.get();

        category.save();
        return redirect(routes.Application.index());

    }
}