package active.since93.mvvm.demo;

import org.junit.Before;
import org.junit.Test;

import active.since93.mvvm.demo.data.FakeUserGeneratorAPI;
import active.since93.mvvm.demo.model.User;
import active.since93.mvvm.demo.viewmodel.UserDetailViewModel;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class UserDetailViewModelTest {

    private UserDetailViewModel userDetailViewModel;
    private User user;

    @Before
    public void setupUserDetailViewModelTest() {
        user = FakeUserGeneratorAPI.getUser();
        userDetailViewModel = new UserDetailViewModel(user);
    }

    @Test
    public void shouldGetUserName() {
        assertEquals(user.getFullName(), userDetailViewModel.getFullName());
    }

    @Test
    public void shouldGetEmail() {
        assertEquals(user.email, userDetailViewModel.getEmail());
    }
    @Test
    public void shouldGetPicture() {
        assertEquals(user.picture.medium, userDetailViewModel.getPicture());
    }
    @Test
    public void shouldGetCell() {
        assertEquals(user.cell, userDetailViewModel.getCell());
    }

    @Test
    public void shouldGetAddress() {
        assertEquals(user.getFullLocation(), userDetailViewModel.getLocation());
    }
}