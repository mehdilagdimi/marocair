package com.marocair.marocair.base;


import com.marocair.marocair.util.DB.Handler;
import org.jetbrains.annotations.NotNull;

import java.sql.ResultSet;
import java.util.ArrayList;

public class DaoBuilder {

    public String table = null;

    protected ArrayList<Object> values;
    protected StringBuilder query;
    private Handler handler;
    public DaoBuilder(){
        this.values = new ArrayList<>();
        this.query = new StringBuilder();
        this.handler = new Handler();
        this.handler.establishConnection();
    }

    private <V>void addValue(V value){
        this.values.add(value);
    }

    private void reset(){
        this.query.setLength(0);
        this.values.clear();
    }

    private DaoBuilder table(String table){
        if (this.table == null) {
            this.table = table;
        }
        return this;
    }

    public <T>DaoBuilder update(String[] cols, T ...values){
        query.append("UPDATE ");
        query.append(this.table);
        query.append(" SET ");

        for(int i = 0; i < values.length; i++){
            query.append(cols[i] + " = ");
            query.append("?,");
            this.addValue(values[i]);
        }

        this.query.deleteCharAt(this.query.length()-1);
        return this;
    }

    public  <T>DaoBuilder where(String col, String operator, T value) {
        query.append(" WHERE ");
        query.append(col);
        query.append(operator);
        query.append("?");
        this.addValue(value);
        return this;
    }


    public DaoBuilder select(String columns){
        query.append("SELECT ");
        query.append(columns);
        query.append(" FROM ");
        query.append(this.table);
        return this;
    }

    public DaoBuilder build(){
        return prepare();
    }

    public DaoBuilder buildReturn(){
        this.query.append(" RETURNING * ");
        return prepare();
    }

    @NotNull
    private DaoBuilder prepare() {
        this.handler.prepare(this.query.toString());
        int size = this.values.size();
        if (size == 0) return this;
        for (int i = 0; i < size; i++) {
            this.handler.setParam(i+1,this.values.get(i));
        }
        return this;
    }

    public int executeUpdate(){
        int affectedRows = this.handler.executeUpdate();
        this.reset();
        return affectedRows;
    }

    public ResultSet execute(){
        ResultSet resultSet = this.handler.execute();
        this.reset();
        return resultSet;
    }

    @Override
    public String toString() {
        return query.toString();
    }

    protected DaoBuilder and(String col, String operator, String val) {
        query.append(" AND ");
        query.append(col);
        query.append(operator);
        query.append(val);
        return this;
    }

    protected DaoBuilder or(String col, String operator, String val) {
        query.append(" OR ");
        query.append(col);
        query.append(operator);
        query.append(val);
        return this;
    }

    protected DaoBuilder ASC (String col, String operator, String val) {
        query.append(" ORDER BY ASC");
        return this;
    }
    protected DaoBuilder DESC (String col, String operator, String val) {
        query.append(" ORDER BY DESC");
        return this;
    }

}
