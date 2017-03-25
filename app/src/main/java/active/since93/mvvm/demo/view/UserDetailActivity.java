package active.since93.mvvm.demo.view;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

import active.since93.mvvm.demo.R;
import active.since93.mvvm.demo.databinding.ActivityUserDetailBinding;
import active.since93.mvvm.demo.model.User;
import active.since93.mvvm.demo.viewmodel.UserDetailViewModel;

public class UserDetailActivity extends AppCompatActivity {

    /**
     * This name depends upon XML file name
     *
     * EX.
     * If xml file name is 'activity_main' then binding class will be 'ActivityMainBinding'
     */
    private ActivityUserDetailBinding activityUserDetailBinding;

    public static final String TAG = "EXTRA_OBJECT";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        activityUserDetailBinding = DataBindingUtil.setContentView(this, R.layout.activity_user_detail);

        setupToolbar();
        getDataAndDisplay();
    }

    private void setupToolbar() {
        if(getSupportActionBar() != null) {
            getSupportActionBar().setTitle("User Details");
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
    }

    private void getDataAndDisplay() {
        User user = (User) getIntent().getSerializableExtra(TAG);
        UserDetailViewModel userDetailViewModel = new UserDetailViewModel(user);
        activityUserDetailBinding.setUserDetailViewModel(userDetailViewModel);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            case android.R.id.home:
                onBackPressed();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}