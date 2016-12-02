package cat.tecnocampus.jpaConverter;

/**
 * Created by roure on 16/11/2016.
 */

public class LocalTimeConverter { //implements AttributeConverter<LocalTime, Time> {

    public java.sql.Time convertToDatabaseColumn(java.time.LocalTime attribute) {

        return attribute == null ? null : java.sql.Time.valueOf(attribute);
    }

    public java.time.LocalTime convertToEntityAttribute(java.sql.Time dbData) {

        return dbData == null ? null : dbData.toLocalTime();
    }
}
