package active.since93.mvvm.demo.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by myzupp on 25-03-2017.
 *
 * @author Darshan Parikh (parikhdarshan36@gmail.com)
 */

public class Info {

    @SerializedName("seed") String seed;
    @SerializedName("version") String version;
    @SerializedName("results") int results;
    @SerializedName("page") int page;
}
