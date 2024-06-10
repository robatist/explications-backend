package com.robatist.backend.backend.service;

import com.robatist.backend.domain.user.Role;
import com.robatist.backend.domain.user.User;
import com.robatist.backend.service.UserService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceTest {

    @Autowired
    private UserService userService;

    @Test
    public void createUser() {
        List<User> userList = userService.getAllUsers();

        User userCreated = new User("firstNameTest", "lastNameTest", "email@email.pt", "password", 23, "111222333", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcS5hZT8SakB-eGvBzrl-91ED8bthY-hnBL6cUVb7jmuMxO41Gej7xAQXHyNLZQ06ZcIPeM&usqp=CAU", true, Role.USER);

        User result = userService.createUser(userCreated);

        Assert.assertEquals(userCreated, result);
    }

    @Test
    public void getUser() {
        User result = userService.getUserById(7);

        // EXPECTS
        User expectedUser = new User(7, "firstNameTest", "lastNameTest", "email@email.pt", "password", 23, "111222333", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcS5hZT8SakB-eGvBzrl-91ED8bthY-hnBL6cUVb7jmuMxO41Gej7xAQXHyNLZQ06ZcIPeM&usqp=CAU", true, Role.USER);

        // ASSERTS
        Assert.assertEquals(expectedUser, result);
    }

    @Test
    public void updateUser() {
        User userToUpdate = new User("firstNameTest", "lastNameTest", "email@email.pt", "password", 23, "nif updated", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcS5hZT8SakB-eGvBzrl-91ED8bthY-hnBL6cUVb7jmuMxO41Gej7xAQXHyNLZQ06ZcIPeM&usqp=CAU", true, Role.USER);

        User userUpdated = userService.updateUser(7, userToUpdate);

        // EXPECTS
        User expectedUser = new User(7, "firstNameTest", "lastNameTest", "email@email.pt", "password", 23, "nif updated", "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcS5hZT8SakB-eGvBzrl-91ED8bthY-hnBL6cUVb7jmuMxO41Gej7xAQXHyNLZQ06ZcIPeM&usqp=CAU", true, Role.USER);

        // ASSERTS
        Assert.assertEquals(expectedUser, userUpdated);
    }

    @Test
    public void deleteUser() {
        userService.deleteUser(5);

        try {
            userService.getUserById(5);
        } catch (NullPointerException exception) {
            Assert.assertEquals("User to get not exists!", exception.getMessage());
        }

    }

    @Test
    public void getAllUsers() {
        List<User> userList = userService.getAllUsers();

        Assert.assertNotNull(userList);
    }

}
