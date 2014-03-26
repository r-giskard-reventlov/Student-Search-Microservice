/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.rgiskardreventlov.service.message;

/**
 *
 * @author justin
 */
public class Student {
    private final String surname;
    private final String forename;
    private final Integer id;

    public Student(Integer id, String forename, String surname) {
        this.id = id;
        this.forename = forename;
        this.surname = surname;
    }

    public Integer getId() {
        return id;
    }

    public String getSurname() {
        return surname;
    }

    public String getForename() {
        return forename;
    }
    
}
