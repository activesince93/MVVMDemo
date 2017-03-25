package active.since93.mvvm.demo.view;

import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import java.util.Collections;
import java.util.List;

import active.since93.mvvm.demo.R;
import active.since93.mvvm.demo.databinding.ItemUserBinding;
import active.since93.mvvm.demo.model.User;
import active.since93.mvvm.demo.viewmodel.UserItemViewModel;

/**
 * Created by myzupp on 25-03-2017.
 *
 * @author Darshan Parikh (parikhdarshan36@gmail.com)
 */

public class UserItemAdapter extends RecyclerView.Adapter<UserItemAdapter.ViewHolder> {

    private List<User> userList;

    public UserItemAdapter() {
        this.userList = Collections.emptyList();
    }
    public UserItemAdapter(List<User> userList) {
        this.userList = userList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ItemUserBinding itemUserBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.item_user
                , parent , false);
        return new ViewHolder(itemUserBinding);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.bindPeople(userList.get(position));
    }

    public void setUserList(List<User> userList) {
        this.userList = userList;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return userList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        ItemUserBinding itemUserBinding;

        public ViewHolder(ItemUserBinding itemUserBinding) {
            super(itemUserBinding.itemUser);
            this.itemUserBinding = itemUserBinding;
        }

        void bindPeople(User user) {
            if (itemUserBinding.getItemUserViewModel() == null) {
                itemUserBinding.setItemUserViewModel(
                        new UserItemViewModel(itemView.getContext(), user));
            } else {
                itemUserBinding.getItemUserViewModel().setUser(user);
            }
        }
    }
}
