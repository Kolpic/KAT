package eu.deltasource.kat.configuration;

import java.sql.Types;

public class PostgreSQL94Dialect extends org.hibernate.dialect.PostgreSQL94Dialect {

    public PostgreSQL94Dialect() {
        this.registerColumnType(Types.OTHER, "jsonb");
    }
}
