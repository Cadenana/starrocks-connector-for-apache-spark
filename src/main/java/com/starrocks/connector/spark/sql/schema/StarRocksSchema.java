package com.starrocks.connector.spark.sql.schema;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static com.starrocks.connector.spark.sql.schema.StarRocksField.__OP;

public class StarRocksSchema {
    private final List<StarRocksField> columns;
    private final List<StarRocksField> pks;
    private final Map<String, StarRocksField> columnMap;

    public StarRocksSchema(List<StarRocksField> columns, List<StarRocksField> pks) {
        this.columns = columns;
        this.pks = pks;
        this.columnMap = new HashMap<>();
        for (StarRocksField field : columns) {
            columnMap.put(field.getName(), field);
        }
    }

    public List<StarRocksField> getColumns() {
        return columns;
    }

    public List<StarRocksField> getPks() {
        return pks;
    }

    public StarRocksField getField(String columnName) {
        if (__OP.getName().equalsIgnoreCase(columnName)) {
            return __OP;
        }

        return columnMap.get(columnName);
    }
}