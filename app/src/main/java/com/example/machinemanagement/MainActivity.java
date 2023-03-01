package com.example.machinemanagement;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.machinemanagement.Database.MachineDatabase;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private EditText edt_machine_id;
    private EditText edt_machine_name;
    private EditText edt_machine_product_code;
    private EditText edt_machine_require_count;
    private Button btn_add;
    private Button btn_update;
    private Button btn_delete;
    private Button btn_list;


    private MachineAdapter machineAdapter;
    private List<Machine> machineList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edt_machine_id = findViewById(R.id.edittext_machine_id);
        edt_machine_name = findViewById(R.id.edittext_machine_name);
        edt_machine_product_code = findViewById(R.id.edittext_productCode);
        edt_machine_require_count = findViewById(R.id.edittext_requireCount);
        btn_add = findViewById(R.id.btn_add);
        btn_update = findViewById(R.id.btn_update);
        btn_delete = findViewById(R.id.btn_delete);
        btn_list = findViewById(R.id.btn_list);

        machineAdapter = new MachineAdapter();
        machineList = new ArrayList<>();
        machineAdapter.setData(machineList);



        btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addMachine();
            }


        });

    }
    private void addMachine() {
        String id = edt_machine_id.getText().toString();
        String name = edt_machine_name.getText().toString();
        String productCode = edt_machine_product_code.getText().toString();
        String requireCount = edt_machine_require_count.getText().toString();
        if(id.isEmpty() || name.isEmpty() || productCode.isEmpty() || requireCount.isEmpty()) {
            return;
        }else{
            Machine machine = new Machine(Integer.parseInt(id), name, productCode, requireCount);
            machineList.add(machine);
        }


    }

    public void showData(){
        machineList = MachineDatabase.getInstance(this).machineDAO().getAllMachine();
        machineAdapter.setData(machineList);
        Toast.makeText(this, "Add machine successfully ! ", Toast.LENGTH_SHORT).show();
    }
}