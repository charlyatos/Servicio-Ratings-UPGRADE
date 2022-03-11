package com.api.ratingscourse.factorydtos;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

public interface FactoryDTOS{
    Object mapToSimpleEntity(Object entityModel);
}
