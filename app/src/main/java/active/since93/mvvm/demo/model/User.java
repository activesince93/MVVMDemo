package active.since93.mvvm.demo.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by myzupp on 25-03-2017.
 *
 * @author Darshan Parikh (parikhdarshan36@gmail.com)
 */

public class User implements Serializable {
    @SerializedName("name") public Name name;
    @SerializedName("location") public Location location;
    @SerializedName("email") public String email;
    @SerializedName("cell") public String cell;
    @SerializedName("picture") public Picture picture;

    public String fullName;

    public String getFullName() {
        return name.title + " " + name.first + " " + name.last;
    }

    public String getFullLocation() {
        return location.street + ", " + location.city + ", " + location.state + "-" + location.postcode;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public boolean hasEmail() {
        return email != null && !email.isEmpty();
    }
}
