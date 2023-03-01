package com.example.machinemanagement.Database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;

import com.example.machinemanagement.Machine;

@Database(entities = Machine.class, version = 1, exportSchema = false)
public abstract class MachineDatabase extends androidx.room.RoomDatabase{

    private static final String DATABASE_NAME = "machine.database";
    private static MachineDatabase instance;

    public static synchronized MachineDatabase getInstance(Context context){
       if(instance == null){
           instance = Room.databaseBuilder(context.getApplicationContext(), MachineDatabase.class, DATABASE_NAME)
                   .allowMainThreadQueries()
                   .build();
       }
         return instance;
    }

    public abstract MachineDAO machineDAO();
}
