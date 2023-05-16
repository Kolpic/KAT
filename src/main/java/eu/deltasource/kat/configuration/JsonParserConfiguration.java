package eu.deltasource.kat.configuration;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.usertype.UserType;

import java.io.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

/**
 * We need to implement a custom mapping if we want to use PostgreSQL’s JSONB type
 * with Hibernate 4 or 5. The best way to do that is to implement Hibernate’s UserType
 * interface and register the mapping in a custom dialect.
 * Hibernate 6 provides a standard JSON mapping. We only need to activate it by annotating
 * our entity attribute with a @JdbcTypeCode annotation and setting the type to SqlTypes.JSON.
 */
public class JsonParserConfiguration implements UserType {

    /**
     * We tell Hibernate the SQL type it shall use for this mapping. In this case,
     * We use the generic Type.JAVA_OBJECT as the SQL type .
     */
    @Override
    public int[] sqlTypes() {
        return new int[]{Types.JAVA_OBJECT};
    }

    /**
     * We tell Hibernate the Java class it shall use for this mapping. In this case,
     * JsonParserConfiguration class as the Java class.
     */
    @Override
    public Class returnedClass() {
        return Class.class;
    }

    @Override
    public boolean equals(Object x, Object y) throws HibernateException {
        if(x == null){
            return y == null;
        }

        return x.equals(y);
    }

    @Override
    public int hashCode(Object x) throws HibernateException {
        return x.hashCode();
    }

    /**
     * The nullSafeGet method gets called to map the value from the database into the Java class.
     * So we have to parse the JSON document into a JsonParserConfiguration class.
     * Methods nullSafeGet and nullSafeSet, are telling Hibernate,
     * which will call when you read or write the attribute.
     */
    @Override
    public Object nullSafeGet(ResultSet rs, String[] names,
                              SharedSessionContractImplementor session, Object owner) throws HibernateException, SQLException {
        if(rs.getString(names[0]) == null){
            return null;
        }
        return rs.getString(names[0]);
    }

    @Override
    public void nullSafeSet(PreparedStatement st, Object value,
                            int index, SharedSessionContractImplementor session) throws HibernateException, SQLException {
        if (value == null) {
            st.setNull(index, Types.OTHER);
            return;
        }

        st.setObject(index, value, Types.OTHER);
    }

    /**
     * Has to create a deep copy of a JsonParserConfiguration object.
     * One of the easiest ways to do that is to serialize and deserialize the JsonParserConfiguration object.
     * This forces the JVM to create a deep copy of the object.
     */
    @Override
    public Object deepCopy(Object value) throws HibernateException {
        return value;
    }

    @Override
    public boolean isMutable() {
        return true;
    }

    @Override
    public Serializable disassemble(Object value) throws HibernateException {
        return (String)this.deepCopy(value);
    }

    @Override
    public Object assemble(Serializable cached, Object owner) throws HibernateException {
        return this.deepCopy(cached);
    }

    @Override
    public Object replace(Object original, Object target, Object owner) throws HibernateException {
        return original;
    }
}
