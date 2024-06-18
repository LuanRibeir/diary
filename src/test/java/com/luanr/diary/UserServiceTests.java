package com.luanr.diary;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.luanr.diary.model.User;
import com.luanr.diary.service.UserService;

@SpringBootTest
public class UserServiceTests {
    @Autowired
    UserService userService;

    @Test
    @DisplayName("Add a user on DB.")
    public void saveUserTest() {
        int totalBefore = userService.findAll().size();

        User dummy = new User();
        dummy.setName("Test Dummy");
        userService.save(dummy);

        int totalAfter = userService.findAll().size();

        assertEquals(totalBefore + 1, totalAfter);
    }

    @Test
    @DisplayName("Delete a user on DB.")
    public void deleteUserTest() {
        User dummy = new User();
        dummy.setName("Test Dummy");
        userService.save(dummy);

        int totalBefore = userService.findAll().size();

        userService.deleteById(dummy.getId());

        int totalAfter = userService.findAll().size();

        assertEquals(totalBefore - 1, totalAfter);
    }

    @Test
    @DisplayName("Find a user by ID.")
    public void FindUserByIdTest() {
        User dummy = new User();
        dummy.setName("Test Dummy");
        userService.save(dummy);

        assertTrue(userService.findById(dummy.getId()).isPresent());
    }

    @Test
    @DisplayName("Find all users")
    public void FindAllUsersTest() {
        assertTrue(userService.findAll().isEmpty());

        User dummy = new User();
        dummy.setName("Test Dummy");
        userService.save(dummy);

        assertTrue(!userService.findAll().isEmpty());
    }

    @Test
    @DisplayName("Update a user by ID")
    public void updateUserByIdTest() throws Exception {
        User dummy = new User();
        dummy.setName("Test Dummy");
        userService.save(dummy);

        String dummyNameBefore = dummy.getName();

        User newDummy = new User();
        dummy.setName("New Test Dummy");

        userService.updateById(dummy.getId(), newDummy);

        assertNotEquals(dummyNameBefore, dummy.getName());
    }
}
