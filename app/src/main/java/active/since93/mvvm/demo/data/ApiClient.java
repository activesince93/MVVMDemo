package active.since93.mvvm.demo.data;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by myzupp on 25-03-2017.
 *
 * @author Darshan Parikh (parikhdarshan36@gmail.com)
 */

public class ApiClient {

    public static final String BASE_URL = "https://randomuser.me/";
    private static Retrofit retrofit = null;

    public static Retrofit getClient() {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
}
