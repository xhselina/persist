package com.mx.persist.repository;

import com.mx.persist.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 * Created by 季先生 on 2017/8/2 10:55.
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    @Query("from User u where u.userName=:userName")
    User findUserByUserName(@Param("userName") String userName);
}
