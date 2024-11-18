package com.cseazeem.carmanagement.DataBase;


import com.cseazeem.carmanagement.Entities.Car;
import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;
import org.jdbi.v3.sqlobject.customizer.Bind;

import java.util.List;

public interface CarDao {

    @SqlUpdate("INSERT INTO cars (title, description, tags, user_id) VALUES (:title, :description, :tags, :userId)")
    void insertCar(@Bind("title") String title, @Bind("description") String description, @Bind("tags") String tags, @Bind("userId") Long userId);

    @SqlQuery("SELECT * FROM cars WHERE user_id = :userId")
    List<Car> findByUserId(@Bind("userId") Long userId);

    @SqlQuery("SELECT * FROM cars WHERE title ILIKE '%' || :keyword || '%' OR description ILIKE '%' || :keyword || '%' OR tags ILIKE '%' || :keyword || '%'")
    List<Car> searchCars(@Bind("keyword") String keyword);

    @SqlQuery("SELECT * FROM cars WHERE id = :id")
    Car findById(@Bind("id") Long id);

    @SqlUpdate("DELETE FROM cars WHERE id = :id")
    void deleteById(@Bind("id") Long id);
}

