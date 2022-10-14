package com.marocair.marocair.base;


import com.marocair.marocair.util.DB.DBConnection;
import com.marocair.marocair.util.DB.DBHandler;
//import org.jetbrains.annotations.NotNull;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.stream.IntStream;

public class DaoBuilder{

    public String table = null;

    protected ArrayList<Object> values;
    protected StringBuilder query;
    private DBHandler DBHandler;


    public DaoBuilder(){
        DBConnection.establishConnection();
        this.values = new ArrayList<>();
        this.query = new StringBuilder();
        this.DBHandler = new DBHandler();
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
    public <T>DaoBuilder insert(String[] cols, T ...values){
        query.append("INSERT INTO ");
        query.append(this.table);
        query.append(" " + cols);
        query.append(" VALUES ");
        IntStream.range(0, values.length).forEachOrdered(i -> {
            query.append("?,");
            this.addValue(values[i]);
        });

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
    public DaoBuilder delete(String columns){
        query.append("DELETE FROM ");
        query.append(this.table);
        return this;
    }

    public DaoBuilder build(){
        System.out.println(this.query);
        return prepare();
    }

    public DaoBuilder buildReturn(){
        this.query.append(" RETURNING * ");
        System.out.println(this.query);
        return prepare();
    }

//    @NotNull
    private DaoBuilder prepare() {
        this.DBHandler.prepare(this.query.toString());
        int size = this.values.size();
        if (size == 0) return this;
        for (int i = 0; i < size; i++) {
            this.DBHandler.setParam(i+1,this.values.get(i));
        }
        return this;
    }

    public int executeUpdate(){
        int affectedRows = this.DBHandler.executeUpdate();
        this.reset();
        return affectedRows;
    }

    public ResultSet execute(){
        ResultSet resultSet = this.DBHandler.execute();
        this.reset();
        return resultSet;
    }
    public boolean isEmpty(){
        ResultSet resultSet = this.DBHandler.execute();
        this.reset();
        return this.DBHandler.isEmpty();
    }

    @Override
    public String toString() {
        return query.toString();
    }

    public <V> DaoBuilder and(String col, String operator, V value) {
        query.append(" AND ");
        query.append(col);
        query.append(operator);
        query.append("?");
        this.addValue(value);
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
