package com.api.ratingscourse.grpcservices;

import com.api.ratingscourse.entyties.entity.RatingHistories;
import com.api.ratingscourse.exceptions.exceptionclasses.ResourceNotFoundException;
import com.api.ratingscourse.factorydtos.CreatorDTOS;
import com.api.ratingscourse.repositoy.repositories.RatingHistoryRepository;
import com.errors.grpc.BadRequest;
import com.errors.grpc.ErrorInfo;
import com.google.protobuf.Field;
import com.ratinghistories.grpc.*;
import io.grpc.Status;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;
import org.graalvm.compiler.lir.amd64.AMD64Binary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.HttpClientErrorException;

import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

@GrpcService
public class RantingHistoriesServiceGRPC extends RatingHistoriesGRPCGrpc.RatingHistoriesGRPCImplBase {

    @Autowired
    private RatingHistoryRepository ratingHistoryRepository;

    @Override
    public void getOneRatingById(Id request, StreamObserver<RatingHistoryObject> responseObserver) {
        Optional<RatingHistories> checkIfExists = ratingHistoryRepository.findById(request.getId());
        RatingHistoryObject ratingHistoryObject = null;

        if (checkIfExists.isPresent()){
            ratingHistoryObject = RatingHistoryObject.newBuilder()
                    .setId(checkIfExists.get().getId())
                    .setUserId(checkIfExists.get().getUserId())
                    .setCourseId(checkIfExists.get().getCourseId())
                    .setRating(checkIfExists.get().getRating())
                    .setNote(checkIfExists.get().getNote())
                    .build();
        }else {
            responseObserver.onError(Status.NOT_FOUND
                    .augmentDescription("INFORMATION ABOUT THE ERROR")
                    .withDescription("TRY WITH ANOTHER ID")
                    .asException());
        }
        responseObserver.onNext(ratingHistoryObject);
        responseObserver.onCompleted();
    }

    @Override
    public void getAllRatings(Empty request, StreamObserver<ListOfAllRatings> responseObserver) {
        Optional<List<RatingHistories>> listFromDataBase = Optional.of(ratingHistoryRepository.findAll());
        RatingHistoryObject ratingHistoryObject;

        ListOfAllRatings listToReturn = null;

        for(RatingHistories oneRating : listFromDataBase.get()){
            ratingHistoryObject = RatingHistoryObject.newBuilder()
                    .setId(oneRating.getId())
                    .setUserId(oneRating.getUserId())
                    .setCourseId(oneRating.getCourseId())
                    .setRating(oneRating.getRating())
                    .setNote(oneRating.getNote())
                    .build();


            listToReturn = ListOfAllRatings.newBuilder()
                    .addListOfAllRatings(ratingHistoryObject)
                    .build();
        }
        responseObserver.onNext(listToReturn);
        responseObserver.onCompleted();
    }
}
