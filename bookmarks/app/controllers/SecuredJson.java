package controllers;

import play.*;
import play.mvc.*;
import play.mvc.Http.*;

import models.*;

import static play.libs.Json.toJson;

public class SecuredJson extends Security.Authenticator {

    @Override
    public String getUsername(Context ctx) {
        return ctx.session().get("email");
    }

    @Override
    public Result onUnauthorized(Context ctx) {
        return ok(toJson("failed"));
    }
}