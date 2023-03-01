package com.example.machinemanagement.Database;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.machinemanagement.Machine;

import java.util.List;

@Dao
public interface MachineDAO {

    @Insert
    public void insertMachine(Machine machine);

    @Query("SELECT * FROM machine_table")
    public List<Machine> getAllMachine();


}
