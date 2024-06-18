package com.luanr.diary.service;

import java.util.List;
import java.util.Optional;

import com.luanr.diary.model.Activity;

public interface ActivityService {
    Activity add(Activity activity);

    List<Activity> findAll();

    Optional<Activity> updateById(Long id, Activity activity) throws Exception;

    Optional<Activity> deleteById(Long id);
}
