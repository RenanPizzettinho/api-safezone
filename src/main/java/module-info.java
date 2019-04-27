module api.safezone {
    requires java.sql;
    requires spring.boot;
    requires spring.boot.autoconfigure;
    requires java.xml.bind;
    requires net.bytebuddy;
    requires spring.beans;
    requires spring.context;
    requires java.persistence;
    requires spring.web;

    opens com.stage.safezone to spring.core;
    opens com.stage.safezone.model to org.hibernate.orm.core;
    opens com.stage.safezone.service to spring.beans;
    opens com.stage.safezone.api to spring.beans, spring.web;
    exports com.stage.safezone.model to com.fasterxml.jackson.databind;

    exports com.stage.safezone;
}