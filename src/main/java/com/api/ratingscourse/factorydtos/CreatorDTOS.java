package com.api.ratingscourse.factorydtos;

import com.api.ratingscourse.exceptions.exceptionclasses.InternalServerErrorException;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

public final class CreatorDTOS implements FactoryDTOS{

    private Constructor constructorNedeedToCreateInstance(Object entityModel)throws Exception{
        Class<?> classToExtract = Class.forName("com.api.ratingscourse.factorydtos.dtomodelsimpl.Simple" + entityModel.getClass().getSimpleName()+ "DTOImpl");
        return classToExtract.getConstructor();
    }


    public Object mapToSimpleEntity(Object entityModel){
        try{
            Object instance2 = constructorNedeedToCreateInstance(entityModel).newInstance();

            Method[] allMethods = instance2.getClass().getMethods();
            Method methodToInvoke = null;
            for (Method method: allMethods){
                String methodName = method.getName();
                if (methodName.startsWith("mapTo")){
                    methodToInvoke = method;
                }
            }
//               (Una instancia de la clase a la que pertenece el metodo, Parametro que queremos introducir)
            return methodToInvoke.invoke(instance2,entityModel);
        }catch (Exception e){
            e.printStackTrace();
            return new InternalServerErrorException("An error has occurred we are working to solve it");
        }
    }
}
