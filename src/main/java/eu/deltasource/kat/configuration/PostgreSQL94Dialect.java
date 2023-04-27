package eu.deltasource.kat.configuration;

import java.sql.Types;

/**
 * Hibernate’s PostgreSQL dialect does not support the JSONB datatype.
 * That's why we need to register it by extending an existing dialect and calling the
 * registerColumnType method in its constructor. We use a PostgreSQL database
 * and we are extending Hibernate’s PostgreSQL94Dialect
 */
public class PostgreSQL94Dialect extends org.hibernate.dialect.PostgreSQL94Dialect {

    public PostgreSQL94Dialect() {
        this.registerColumnType(Types.OTHER, "jsonb");
    }
}
