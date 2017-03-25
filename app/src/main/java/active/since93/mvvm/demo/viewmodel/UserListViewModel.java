package active.since93.mvvm.demo.viewmodel;

import android.content.Context;
import android.databinding.ObservableField;
import android.databinding.ObservableInt;
import android.view.View;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;

import active.since93.mvvm.demo.R;
import active.since93.mvvm.demo.data.ApiClient;
import active.since93.mvvm.demo.data.ApiInterface;
import active.since93.mvvm.demo.data.UserResponseHandler;
import active.since93.mvvm.demo.model.User;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by myzupp on 25-03-2017.
 *
 * @author Darshan Parikh (parikhdarshan36@gmail.com)
 */

public class UserListViewModel extends Observable {
    public ObservableInt emptyViewVisibility;
    public ObservableInt recyclerViewVisibility;
    public ObservableField<String> emptyViewText;
    public static final int TOTAL_RESULTS = 100;

    private Context context;
    private List<User> userList;

    public UserListViewModel(Context context) {
        this.context = context;
        this.userList = new ArrayList<>();
        emptyViewVisibility = new ObservableInt(View.VISIBLE);
        recyclerViewVisibility = new ObservableInt(View.GONE);
        emptyViewText = new ObservableField<>(context.getString(R.string.press_fab_to_load_users));
    }

    public void onClickFAB(View view) {
        fetchUsersList();
    }

    public void initDefaultValues() {
        emptyViewVisibility.set(View.VISIBLE);
        recyclerViewVisibility.set(View.GONE);
    }

    public void fetchUsersList() {
        ApiInterface apiInterface = ApiClient.getClient().create(ApiInterface.class);
        Call<UserResponseHandler> userCall = apiInterface.getUsersList(TOTAL_RESULTS);
        userCall.enqueue(new Callback<UserResponseHandler>() {
            @Override
            public void onResponse(Call<UserResponseHandler> call, Response<UserResponseHandler> response) {
                emptyViewVisibility.set(View.GONE);
                recyclerViewVisibility.set(View.VISIBLE);
                changeUserDataSet(response.body().getResults());
            }

            @Override
            public void onFailure(Call<UserResponseHandler> call, Throwable t) {
                emptyViewVisibility.set(View.VISIBLE);
                recyclerViewVisibility.set(View.GONE);
                emptyViewText.set(context.getString(R.string.some_error_occurred));
            }
        });
    }

    public void changeUserDataSet(List<User> users) {
        userList.addAll(users);
        setChanged();
        notifyObservers();
    }

    public List<User> getAllUsers() {
        return userList;
    }
}
