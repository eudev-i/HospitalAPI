package br.com.senaijandira.pacientes.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

import br.com.senaijandira.pacientes.R;
import br.com.senaijandira.pacientes.model.Paciente;

public class PacienteAdapter extends ArrayAdapter<Paciente>{
    public PacienteAdapter(Context ctx){
        super(ctx, 0, new ArrayList<Paciente>()); /*CONSTRUTOR PADRÃO, CRIANDO UMA LISTA VAZIA*/

    }

    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent){

        View v = convertView;

        if(v == null){

            v = LayoutInflater.from(getContext()).inflate(R.layout.list_view_item, parent, false);
        }

        Paciente paciente = getItem(position);

        TextView txtNome = v.findViewById(R.id.txtNomePaciente);
        TextView txtCpf = v.findViewById(R.id.txtCpfPaciente);

        txtNome.setText(paciente.getNome());
        txtCpf.setText(paciente.getCpf());

        return v;
    }




}

