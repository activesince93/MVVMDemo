package active.since93.mvvm.demo.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by myzupp on 25-03-2017.
 *
 * @author Darshan Parikh (parikhdarshan36@gmail.com)
 */

public class Picture implements Serializable {

    @SerializedName("large") public String large;
    @SerializedName("medium") public String medium;
    @SerializedName("thumbnail") public String thumbnail;
}
