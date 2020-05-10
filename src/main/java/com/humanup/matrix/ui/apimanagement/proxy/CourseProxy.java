package com.humanup.matrix.ui.apimanagement.proxy;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "training-app-v1", decode404 = true)
public interface CourseProxy {
  @Cacheable(cacheNames = "courses-by-email", key = "#email")
  @RequestMapping(value = "/course/all/internemail", method = RequestMethod.GET)
  String findCoursesByEmail(@RequestParam(value = "internEmail") String email);

  @Cacheable(cacheNames = "course-all")
  @GetMapping(value = "/course/all")
  String findAllCourses();
}
