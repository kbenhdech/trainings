import play.*;
import play.libs.*;

import java.util.*;

import com.avaje.ebean.*;

import models.*;

public class Global extends GlobalSettings {

    public void onStart(Application app) {
        InitialData.insert(app);
    }

    static class InitialData {

        public static void insert(Application app) {
            if(Ebean.find(Category.class).findRowCount() == 0) {

                Map<String,List<Object>> all =
                        (Map<String,List<Object>>)Yaml.load("initial-data.yml");

                if(Ebean.find(User.class).findRowCount() == 0) {
                    Ebean.save(all.get("users"));
                }

                if(Ebean.find(Category.class).findRowCount() == 0) {
                    // Insert categories first
                    Ebean.save(all.get("categories"));
                }

                if(Ebean.find(Bookmark.class).findRowCount() == 0) {
                    Ebean.save(all.get("bookmarks"));
                }

            }
        }

    }

}