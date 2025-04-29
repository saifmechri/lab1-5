package com.example.studentmanagement.repository;

import com.example.studentmanagement.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    List<Student> findByMajor(String major);

    List<Student> findByAgeLessThan(int age);

    List<Student> findByLastNameContaining(String namePattern);

    @Query("SELECT s FROM Student s WHERE s.age BETWEEN :minAge AND :maxAge")
    List<Student> findStudentsInAgeRange(@Param("minAge") int minAge, @Param("maxAge") int maxAge);
}
