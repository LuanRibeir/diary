package com.luanr.diary;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.luanr.diary.model.Activity;
import com.luanr.diary.service.ActivityService;

@SpringBootTest
public class ActivityServiceTests {

    @Autowired
    ActivityService activityService;

    @Test
    @DisplayName("Add a activity.")
    public void addActivityTest() {
        int totalBefore = activityService.findAll().size();

        Activity activity = new Activity();
        activity.setAmount(1);

        activityService.add(activity);

        int totalAfter = activityService.findAll().size();

        assertEquals(totalBefore + 1, totalAfter);
    }

}
