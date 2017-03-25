package active.since93.mvvm.demo.data;

import java.util.ArrayList;
import java.util.List;

import active.since93.mvvm.demo.model.Location;
import active.since93.mvvm.demo.model.Name;
import active.since93.mvvm.demo.model.Picture;
import active.since93.mvvm.demo.model.User;

/**
 * Created by myzupp on 25-03-2017.
 *
 * @author Darshan Parikh (parikhdarshan36@gmail.com)
 */

public class FakeUserGeneratorAPI {
    private static final String USER_CELL_TEST = "0177-6155420";
    private static final String USER_MAIL_TEST = "theodor.kaufmann@example.com";
    private static final String USER_PICTURE_TEST =
            "http://api.randomuser.me/portraits/women/39.jpg";
    private static final String USER_TITLE_TEST = "ms";
    private static final String USER_FIRST_TEST = "constance";
    private static final String USER_LAST_TEST = "fowler";
    private static final String USER_STREET_TEST = "9193 brock rd";
    private static final String USER_CITY_TEST = "flatrock";
    private static final String USER_STATE_TEST = "prince edward island";
    private static final String USER_USER_NAME_TEST = "organicgoose874";

    public static List<User> getUserList() {
        List<User> users = new ArrayList<>();
        for (int i = 0; i < 10; i++)
            users.add(getUser());
        return users;
    }

    public static User getUser() {
        User user = new User();
        user.picture = new Picture();
        user.location = new Location();
        user.name = new Name();
        user.name.first = USER_FIRST_TEST;
        user.name.last= USER_LAST_TEST;
        user.name.title = USER_TITLE_TEST;
        user.cell = USER_CELL_TEST;
        user.email = USER_MAIL_TEST;
        user.picture.medium = USER_PICTURE_TEST;
        user.location.street = USER_STREET_TEST;
        user.location.city = USER_CITY_TEST;
        user.location.state = USER_STATE_TEST;
        return user;
    }
}
