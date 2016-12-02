package cat.tecnocampus.jpaConverter;

/**
 * Created by roure on 16/11/2016.
 */

public class LocalDateTimeConverter { //implements AttributeConverter<java.time.LocalDateTime, java.sql.Timestamp> {

    public java.sql.Timestamp convertToDatabaseColumn(java.time.LocalDateTime attribute) {

        return attribute == null ? null : java.sql.Timestamp.valueOf(attribute);
    }

    public java.time.LocalDateTime convertToEntityAttribute(java.sql.Timestamp dbData) {

        return dbData == null ? null : dbData.toLocalDateTime();
    }
}