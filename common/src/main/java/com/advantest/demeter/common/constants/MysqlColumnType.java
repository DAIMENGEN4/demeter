package com.advantest.demeter.common.constants;

/**
 * Create on 2025/01/01
 * Author: mengen.dai@outlook.com
 */
public enum MysqlColumnType {
    INT("int"),
    BIGINT("bigint"),
    FLOAT("float"),
    DOUBLE("double"),
    VARCHAR("varchar"),
    TEXT("text"),
    MEDIUMTEXT("mediumtext"),
    LONGTEXT("longtext"),
    TINYINT("tinyint"),
    JSON("json"),
    DATE("date"),
    DATETIME("datetime");

    private final String value;

    MysqlColumnType(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }

    public static MysqlColumnType fromColumnType(String value) {
        return switch (value) {
            case "int" -> INT;
            case "bigint" -> BIGINT;
            case "float" -> FLOAT;
            case "double" -> DOUBLE;
            case "varchar" -> VARCHAR;
            case "text" -> TEXT;
            case "mediumtext" -> MEDIUMTEXT;
            case "longtext" -> LONGTEXT;
            case "tinyint" -> TINYINT;
            case "json" -> JSON;
            case "date" -> DATE;
            case "datetime" -> DATETIME;
            default ->
                    throw new IllegalArgumentException(String.format("Invalid column type: %s. Valid values are: int, bigint, float, double, varchar, text), mediumtext, longtext, tinyint, json, date, datetime.", value));
        };
    }
}
