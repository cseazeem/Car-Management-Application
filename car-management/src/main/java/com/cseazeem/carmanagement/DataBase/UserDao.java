package com.cseazeem.carmanagement.DataBase;

import com.cseazeem.carmanagement.Entities.User;
import org.jdbi.v3.sqlobject.config.RegisterRowMapper;
import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;
import org.jdbi.v3.sqlobject.customizer.Bind;

import java.util.Optional;

@RegisterRowMapper(UserMapper.class)
public interface UserDao {

    @SqlUpdate("INSERT INTO users (username, password) VALUES (:username, :password)")
    void insertUser(@Bind("username") String username, @Bind("password") String password);

    @SqlQuery("SELECT * FROM users WHERE username = :username")
    Optional<User> findByUsername(@Bind("username") String username);

}

