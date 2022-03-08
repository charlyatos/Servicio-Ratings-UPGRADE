package com.api.ratingscourse.repositoy.repositories;

import com.api.ratingscourse.entyties.entity.ResultCourses;
import com.api.ratingscourse.repositoy.GenericRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ResultCoursesRepository
        extends GenericRepository<ResultCourses,Long> {

    @Query(value = "SELECT AVG(e.rating) FROM rating_history e WHERE e.idcourse= :idCourseRequest",nativeQuery = true)
    Float getAverageRatingPerCourse(Long idCourseRequest);

}
