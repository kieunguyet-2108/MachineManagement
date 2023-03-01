package com.example.machinemanagement;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MachineAdapter extends RecyclerView.Adapter<MachineAdapter.MachineViewHolder> {


    private List<Machine> listMachine;

    public void setData(List<Machine> listMachine){
        this.listMachine = listMachine;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public MachineViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_machine, parent, false);
        return new MachineViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MachineViewHolder holder, int position) {
        Machine machine = listMachine.get(position);
        if(machine == null){
            return;
        }else{
            holder.edt_machine_id.setText(machine.getId());
            holder.edt_machine_name.setText(machine.getName());
            holder.edt_machine_product_code.setText(machine.getProductCode());
            holder.edt_machine_require_count.setText(machine.getRequireCount());
        }

    }

    @Override
    public int getItemCount() {
        if(listMachine != null)
            return listMachine.size();
        return 0;
    }

    public class MachineViewHolder extends RecyclerView.ViewHolder {
        private EditText edt_machine_id;
        private EditText edt_machine_name;
        private EditText edt_machine_product_code;
        private EditText edt_machine_require_count;


        public MachineViewHolder(@NonNull View itemView) {
            super(itemView);
            edt_machine_id = itemView.findViewById(R.id.edittext_machine_id);
            edt_machine_name = itemView.findViewById(R.id.edittext_machine_name);
            edt_machine_product_code = itemView.findViewById(R.id.edittext_productCode);
            edt_machine_require_count = itemView.findViewById(R.id.edittext_requireCount);

        }

    }
}
