package com.marocair.marocair.base;

public class Dao {

    protected String table;
    protected StringBuilder query;

    protected Dao insert(String columns){
        query.append("SELECT ");
        query.append(columns);
        query.append(" FROM ");
        query.append(this.table);
        return this;
    }
    protected Dao update(String columns){
        query.append("UPDATE ");
        query.append(columns);
        query.append(" FROM ");
        query.append(this.table);
        return this;
    }

    protected Dao where (String col, String operator, String val) {
        query.append(" WHERE ");
        query.append(col);
        query.append(operator);
        query.append(val);
        return this;
    }
    protected Dao and (String col, String operator, String val) {
        query.append(" AND ");
        query.append(col);
        query.append(operator);
        query.append(val);
        return this;
    }
    protected Dao ASC (String col, String operator, String val) {
        query.append(" ORDER BY ASC");
        return this;
    }
    protected Dao DESC (String col, String operator, String val) {
        query.append(" ORDER BY DESC");
        return this;
    }
}
