package com.luanr.diary.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.luanr.diary.model.Activity;

public interface ActivityRepository extends JpaRepository<Activity, Long> {

}
