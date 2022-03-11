package com.api.ratingscourse.serviceimpl.servicesimpl;

import com.api.ratingscourse.entyties.entity.ResultCourses;
import com.api.ratingscourse.factorydtos.CreatorDTOS;
import com.api.ratingscourse.repositoy.repositories.ResultCoursesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.concurrent.CompletableFuture;

@Service
// No extiende de genericService porque no hace uso de todos los metodos
public class ResultCourseServiceImpl{
    @Autowired
    private ResultCoursesRepository resultCoursesRepository;


//    Factory Automapper
    CreatorDTOS mapToDTO = new CreatorDTOS();

    @Async("asyncExecutor")
    @Transactional/*Wont work without transactional*/
    public CompletableFuture<Object> calculateCourseRatingAverage(Long courseId){
        ResultCourses resultPerCourse = new ResultCourses();
        resultPerCourse.setCourseId(courseId);
        resultPerCourse.setAverageRating(resultCoursesRepository.getAverageRatingPerCourse(courseId));
        resultPerCourse.setCreationTime(new Date());
        resultPerCourse.setStatus((byte)1);
        resultCoursesRepository.save(resultPerCourse);
      return CompletableFuture.completedFuture(mapToDTO.mapToSimpleEntity(resultPerCourse));
    }
}
