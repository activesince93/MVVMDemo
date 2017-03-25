package active.since93.mvvm.demo.viewmodel;

import android.databinding.BindingAdapter;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import active.since93.mvvm.demo.model.User;

/**
 * Created by myzupp on 25-03-2017.
 *
 * @author Darshan Parikh (parikhdarshan36@gmail.com)
 */

public class UserDetailViewModel {

    private User user;

    public UserDetailViewModel(User user) {
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
        return user.picture.medium;
    }

    @BindingAdapter("imageUrl")
    public static void setImageUrl(ImageView imageView, String url) {
        Glide.with(imageView.getContext()).load(url).into(imageView);
    }

    public String getLocation() {
        return user.getFullLocation();
    }

    public int getEmailVisibility() {
        return user.hasEmail() ? View.VISIBLE : View.GONE;
    }
}
