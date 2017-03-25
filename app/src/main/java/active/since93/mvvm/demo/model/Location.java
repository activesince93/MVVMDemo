package active.since93.mvvm.demo.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by myzupp on 25-03-2017.
 *
 * @author Darshan Parikh (parikhdarshan36@gmail.com)
 */

public class Location implements Serializable {
    @SerializedName("street") public String street;
    @SerializedName("city") public String city;
    @SerializedName("state") public String state;
    @SerializedName("postcode") public String postcode;
}
