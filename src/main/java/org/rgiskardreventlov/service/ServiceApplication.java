/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.rgiskardreventlov.service;

import io.dropwizard.Application;
import io.dropwizard.jdbi.DBIFactory;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import org.rgiskardreventlov.service.db.StudentDao;
import org.rgiskardreventlov.service.resource.StudentResource;
import org.skife.jdbi.v2.DBI;

/**
 *
 * @author justin
 */
public class ServiceApplication extends Application<ServiceConfiguration> {

    public static void main(String[] args) throws Exception {
        new ServiceApplication().run(args);
    }

    @Override
    public String getName() {
        return "student-search-service";
    }

    @Override
    public void initialize(Bootstrap<ServiceConfiguration> btstrp) {}

    @Override
    public void run(ServiceConfiguration configuration, Environment environment) throws Exception {
        final DBIFactory factory = new DBIFactory();
        final DBI jdbi = factory.build(environment, configuration.getDataSourceFactory(), "h2");
        final StudentDao dao = jdbi.onDemand(StudentDao.class);
        final StudentResource studentResource = new StudentResource(dao);
        environment.jersey().register(studentResource);
        initialiseDb(dao);
    }

    /**
     * Hack approach to initialising db with test students. Better solution
     * would be to investigate the use of Dropwizard Migrations.
     * 
     * @param dao 
     */
    private void initialiseDb(StudentDao dao) {
        dao.initialiseTables();
        dao.insertStudent(1, "Justin", "Smith");
        dao.insertStudent(2, "Iain", "Smith");
        dao.insertStudent(3, "Hamish", "McDougal");
        dao.insertStudent(4, "Tim", "Shanky");
    }

}
