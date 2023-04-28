/**
 * Registering UserType with @TypeDef, so that we apply an annotation to the entire package
 * This links the UserType JsonParserConfiguration to the name “JsonParserConfiguration”
 * which we can then use with a @Type annotation in the entity mapping.
 */
@TypeDefs( {@TypeDef( name= "JsonParserConfigurationObject", typeClass = JsonParserConfiguration.class)})
//@org.hibernate.annotations.TypeDef(name = "JsonParserConfigurationObject", typeClass = JsonParserConfiguration.class)

package eu.deltasource.kat;

import eu.deltasource.kat.configuration.JsonParserConfiguration;
import org.hibernate.annotations.TypeDef;
import org.hibernate.annotations.TypeDefs;