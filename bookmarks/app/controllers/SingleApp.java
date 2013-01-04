package controllers;

import play.*;
import play.mvc.*;
import play.data.*;

import models.*;
import views.html.*;

public class SingleApp extends Controller {

    public static Result mainPage() {

        return ok(mainPage.render(
                "Single Page Application"
        ));
    }

}