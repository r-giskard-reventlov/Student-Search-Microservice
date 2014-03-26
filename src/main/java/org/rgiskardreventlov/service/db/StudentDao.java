/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.rgiskardreventlov.service.db;

import org.rgiskardreventlov.service.message.Student;
import java.util.List;
import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.customizers.Mapper;

/**
 *
 * @author justin
 */
public interface StudentDao {
    
    @Mapper(StudentMapper.class)
    @SqlQuery("select id, forename, surname from student where id = :id")
    Student findById(@Bind("id") Integer id);
    
    @Mapper(StudentMapper.class)
    @SqlQuery("select id, forename, surname from student where surname = :surname")
    List<Student> findByName(@Bind("surname") String surname);
    
    @SqlUpdate("create table student (id int primary key, forename varchar(20), surname varchar(20))")
    void initialiseTables();

    @SqlUpdate("insert into student (id, forename, surname) values (:id, :forename, :surname)")
    void insertStudent(@Bind("id") Integer id, @Bind("forename") String forename, @Bind("surname") String surname);
    
    void close();

}