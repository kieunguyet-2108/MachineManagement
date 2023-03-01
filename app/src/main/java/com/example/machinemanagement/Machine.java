package com.example.machinemanagement;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "machine_table")
public class Machine {

    @PrimaryKey(autoGenerate = false)
    private int id;
    private String name;
    private String productCode;
    private String requireCount;

    public Machine(int id, String name, String productCode, String requireCount) {
        this.id = id;
        this.name = name;
        this.productCode = productCode;
        this.requireCount = requireCount;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getProductCode() {
        return productCode;
    }

    public String getRequireCount() {
        return requireCount;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setProductCode(String productCode) {
        this.productCode = productCode;
    }

    public void setRequireCount(String requireCount) {
        this.requireCount = requireCount;
    }
}
