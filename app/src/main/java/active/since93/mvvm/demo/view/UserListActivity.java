package active.since93.mvvm.demo.view;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;

import java.util.Observable;
import java.util.Observer;

import active.since93.mvvm.demo.R;
import active.since93.mvvm.demo.databinding.ActivityUserListBinding;
import active.since93.mvvm.demo.viewmodel.UserListViewModel;

/**
 * Created by myzupp on 25-03-2017.
 *
 * @author Darshan Parikh (parikhdarshan36@gmail.com)
 */

public class UserListActivity extends AppCompatActivity implements Observer {

    private ActivityUserListBinding activityUserListBinding;
    private UserListViewModel userListViewModel;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        initBinding();
        setupToolbar();
        setupUserListView(activityUserListBinding.listUser);
        setupObserver(userListViewModel);
    }

    private void setupUserListView(RecyclerView listUser) {
        UserItemAdapter userItemAdapter = new UserItemAdapter();
        listUser.setAdapter(userItemAdapter);
        listUser.setLayoutManager(new LinearLayoutManager(this));
    }

    private void setupObserver(Observable observable) {
        observable.addObserver(this);
    }

    private void setupToolbar() {
        if(getSupportActionBar() != null) {
            getSupportActionBar().setTitle(getString(R.string.user_list));
        }
    }

    private void initBinding() {
        activityUserListBinding = DataBindingUtil.setContentView(this, R.layout.activity_user_list);
        userListViewModel = new UserListViewModel(this);
        activityUserListBinding.setUserListViewModel(userListViewModel);
    }

    @Override
    public void update(Observable observable, Object o) {
        if(observable instanceof UserListViewModel) {
            UserListViewModel userListViewModel = (UserListViewModel) observable;
            UserItemAdapter userItemAdapter = (UserItemAdapter) activityUserListBinding.listUser.getAdapter();
            userItemAdapter.setUserList(userListViewModel.getAllUsers());
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_user_list, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.action_github) {
            startActivityActionView();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private void startActivityActionView() {
        startActivity(
                new Intent(Intent.ACTION_VIEW, Uri.parse("https://github.com/activesince93/MVVMDemo")));
    }
}
