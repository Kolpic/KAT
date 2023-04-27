/**
 * Registering UserType with @TypeDef, so that we apply an annotation to the entire package
 */

@org.hibernate.annotations.TypeDef(name = "JsonParserConfiguration", typeClass = JsonParserConfiguration.class)

package eu.deltasource.kat;

import eu.deltasource.kat.configuration.JsonParserConfiguration;