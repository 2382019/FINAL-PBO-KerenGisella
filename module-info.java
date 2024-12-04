module mahasiswislipapp {
    requires spring.context;
    requires spring.beans;
    requires java.sql;

    opens mahasiswislipapp;
    opens mahasiswislipapp.entities;
    opens mahasiswislipapp.repositories;
    opens mahasiswislipapp.services;
    opens mahasiswislipapp.views;
    opens mahasiswislipapp.config;

}