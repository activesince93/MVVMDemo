package active.since93.mvvm.demo.data;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by myzupp on 25-03-2017.
 *
 * @author Darshan Parikh (parikhdarshan36@gmail.com)
 */

public interface ApiInterface {

    @GET("/api")
    Call<UserResponseHandler> getUsersList(@Query("results") int results);
}
