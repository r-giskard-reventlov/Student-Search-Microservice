/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.rgiskardreventlov.service.db;

import org.rgiskardreventlov.service.message.Student;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

/**
 *
 * @author justin
 */
public class StudentMapper implements ResultSetMapper<Student> {

    public Student map(int i, ResultSet rs, StatementContext sc) throws SQLException {
        Integer id = rs.getInt("id");
        String forename = rs.getString("forename");
        String surname = rs.getString("surname");
        return new Student(id, forename, surname);
    }
    
}
