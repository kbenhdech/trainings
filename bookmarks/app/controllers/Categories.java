package controllers;

import models.Category;
import play.data.Form;
import play.mvc.Controller;
import play.mvc.Result;

public class Categories extends Controller {

    public static Result add() {

        final Form<Category> categoryForm = form(Category.class).bindFromRequest();

        if (categoryForm.hasErrors()) { // <--- le code modifié, ça commence ici
            flash("error", "Non, non, il faut saisir autre chose !");
        } else { // <--- on n'enregistre que si tout va bien
            final Category category = categoryForm.get();
            category.save();
        }

        return redirect(routes.Application.index());

    }
}