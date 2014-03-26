/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.rgiskardreventlov.service.message;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import org.hibernate.validator.constraints.Length;

/**
 *
 * @author justin
 */
public class StudentMessage {
    
    List<Student> students;

    public StudentMessage(List<Student> students) {
        this.students = students;
    }

    @JsonProperty
    public List<Student> getStudents() {
        return students;
    }
    
    /*
    
    private Integer id;
    @Length(max = 20)
    private String forename;
    @Length(max = 20)
    private String surname;

    public StudentMessage() {
        // Jackson deserialization
    }

    public StudentMessage(String forename, String surname) {
        this.forename = forename;
        this.surname = surname;
    }
    
    public StudentMessage(Integer id, String forename, String surname) {
        this.id = id;
        this.forename = forename;
        this.surname = surname;
    }

    @JsonProperty
    public Integer getId() {
        return id;
    }
    
    @JsonProperty   
    public String getForename() {
        return forename;
    }
    
    @JsonProperty
    public String getSurname() {
        return surname;
    }
    */
    
}