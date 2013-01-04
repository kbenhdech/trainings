package controllers;

import play.*;
import play.mvc.*;
import play.data.*;

import models.*;
import views.html.*;

import static play.libs.Json.toJson;

public class AuthenticationJson extends Controller {

    public static class AuthenticatedUser {

        public String email;
        public String password;

        public String validate() {
            if(User.authenticate(email, password) == null) {
                return "oups";
            }

            return null;
        }
    }

    //On récupère les informations de login (quand le user se "signe")
    public static Result authenticate() {
        Form<AuthenticatedUser> loginForm =
                form(AuthenticatedUser.class).bindFromRequest();

        if(loginForm.hasErrors()) {
            return ok(toJson("badRequest"));

        } else {
            session("email", loginForm.get().email);
            User who = User.findByEmail(loginForm.get().email);
            return ok(toJson(who.name));
        }
    }

    //Fermer la session
    public static Result logout() {
        session().clear();
        return ok(toJson("bye"));
    }

}