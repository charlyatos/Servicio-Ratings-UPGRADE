package com.api.ratingscourse.repositoy;

import com.api.ratingscourse.entyties.SuperClass;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.io.Serializable;
@NoRepositoryBean
public interface GenericRepository<E extends SuperClass,I extends Serializable>
        extends JpaRepository<E,I> {

    /*Specific Queries*/

}
