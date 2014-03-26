package org.rgiskardreventlov.service.resource;

import com.google.common.base.Optional;
import com.codahale.metrics.annotation.Timed;
import com.google.common.collect.ImmutableList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import org.rgiskardreventlov.service.message.Student;
import org.rgiskardreventlov.service.db.StudentDao;
import org.rgiskardreventlov.service.message.StudentMessage;

/**
 * Search for Students based on supplied criteria
 * 
 * Demonstrates:
 *  1. Picking up YAML configuration using DropWizard Configuration class and 
 *     using this configuration in the application by extending application using
 *     the custom configuration.
 *  2. Using JDBI to query for student (currently in memory database is used)
 * 
 * @author justin
 */
@Path("/student")
@Produces(MediaType.APPLICATION_JSON)
public class StudentResource {
    
    private final StudentDao studentDao;

    public StudentResource(StudentDao studentDao) {
        this.studentDao = studentDao;
    }

    @GET
    @Timed
    @Path("/id")
    public StudentMessage findStudentById(@QueryParam("id") Optional<Integer> id) {
        if(!id.isPresent()) {
            throw new RuntimeException("Must provide a student's id when searching for a student by id");
        }
        Student student = studentDao.findById(id.get());
        return new StudentMessage(ImmutableList.of(student));
    }
    
    @GET
    @Timed
    @Path("/name")
    public StudentMessage findStudentsByName(@QueryParam("surname") Optional<String> surname) {
        if(!surname.isPresent()) {
            throw new RuntimeException("Must provide a student's surname when searching for a student by name");
        }
        List<Student> students = studentDao.findByName(surname.get());
        return new StudentMessage(ImmutableList.copyOf(students));
    }
}
