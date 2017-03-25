package active.since93.mvvm.demo.viewmodel;

import android.content.Context;
import android.content.Intent;
import android.databinding.BaseObservable;
import android.databinding.BindingAdapter;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import active.since93.mvvm.demo.model.User;
import active.since93.mvvm.demo.view.UserDetailActivity;

/**
 * Created by myzupp on 25-03-2017.
 *
 * @author Darshan Parikh (parikhdarshan36@gmail.com)
 */

public class UserItemViewModel extends BaseObservable {

    private Context context;
    private User user;

    public UserItemViewModel(Context context, User user) {
        this.context = context;
        this.user = user;
    }

    public String getFullName() {
        return user.getFullName();
    }

    public String getEmail() {
        return user.email;
    }

    public String getCell() {
        return user.cell;
    }

    public String getPicture() {
        return user.picture.thumbnail;
    }

    public void onItemClick(View view) {
        Intent intent = new Intent(view.getContext(), UserDetailActivity.class);
        intent.putExtra(UserDetailActivity.TAG, user);
        context.startActivity(intent);
    }

    @BindingAdapter("imageUrl")
    public static void setImageUrl(ImageView imageView, String url) {
        Glide.with(imageView.getContext()).load(url).into(imageView);
    }

    public void setUser(User user) {
        this.user = user;
        notifyChange();
    }
}
