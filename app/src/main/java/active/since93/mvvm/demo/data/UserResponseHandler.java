package active.since93.mvvm.demo.data;

import com.google.gson.annotations.SerializedName;

import java.util.List;

import active.since93.mvvm.demo.model.Info;
import active.since93.mvvm.demo.model.User;

/**
 * Created by myzupp on 25-03-2017.
 *
 * @author Darshan Parikh (parikhdarshan36@gmail.com)
 */

public class UserResponseHandler {

    @SerializedName("results")
    private List<User> results;

    @SerializedName("info")
    private Info info;

    public List<User> getResults() {
        return results;
    }

    public void setResults(List<User> results) {
        this.results = results;
    }

    public Info getInfo() {
        return info;
    }

    public void setInfo(Info info) {
        this.info = info;
    }
}
