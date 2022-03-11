package com.api.ratingscourse.grpcservices;

import com.api.ratingscourse.repositoy.repositories.ResultCoursesRepository;
import com.resultcourses.grpc.CourseId;
import com.resultcourses.grpc.ResultCourse;
import com.resultcourses.grpc.ResultCoursesGRPCGrpc;
import io.grpc.Status;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;
import org.springframework.beans.factory.annotation.Autowired;

@GrpcService
public class ResultCoursesServiceGRPC extends ResultCoursesGRPCGrpc.ResultCoursesGRPCImplBase {

    @Autowired
    private ResultCoursesRepository resultCoursesRepository;

    @Override
    public void getAverageRatingPerCourse(CourseId request, StreamObserver<ResultCourse> responseObserver) {
        Float resultCourse = resultCoursesRepository.getAverageRatingPerCourse(request.getCourseId());
        if (resultCourse == null){
            responseObserver.onError(Status.NOT_FOUND
                    .augmentDescription("No ratings for this course")
                    .withDescription("Try to find another course rating")
                    .asException());
        }


        ResultCourse resultCourseToReturn = ResultCourse.newBuilder()
                .setCourseId(request.getCourseId())
                .setAverageRating(resultCourse)
                .build();
        responseObserver.onNext(resultCourseToReturn);
        responseObserver.onCompleted();
    }
}
