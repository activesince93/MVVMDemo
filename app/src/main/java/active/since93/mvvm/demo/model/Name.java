package active.since93.mvvm.demo.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by myzupp on 25-03-2017.
 *
 * @author Darshan Parikh (parikhdarshan36@gmail.com)
 */

public class Name implements Serializable {
    @SerializedName("title") public String title;
    @SerializedName("first") public String first;
    @SerializedName("last") public String last;

}
