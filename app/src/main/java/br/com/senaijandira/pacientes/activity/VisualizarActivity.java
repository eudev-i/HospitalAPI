package br.com.senaijandira.pacientes.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

import br.com.senaijandira.pacientes.R;
import br.com.senaijandira.pacientes.model.Paciente;
import br.com.senaijandira.pacientes.presenter.VisualizarPresenter;
import br.com.senaijandira.pacientes.service.ServiceFactory;
import br.com.senaijandira.pacientes.view.VisualizarView;

public class VisualizarActivity extends AppCompatActivity implements VisualizarView{

    TextView txtResultNome, txtResultDtNasc, txtResultSus, txtResultCpf, txtNomeTitulo;
    VisualizarPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_visualizar);

        int idPaciente = getIntent().getIntExtra("idPaciente",0);

        Log.d("VISUALIZAR",idPaciente+"");

        txtResultNome = findViewById(R.id.txtResultNome);
        txtResultDtNasc = findViewById(R.id.txtDtNascimento);
        txtResultSus = findViewById(R.id.txtResultSus);
        txtResultCpf = findViewById(R.id.txtResultCpf);
        txtNomeTitulo = findViewById(R.id.txtNomeTitulo);

        presenter = new VisualizarPresenter(this, ServiceFactory.create());
        presenter.pacienteResult(idPaciente);
    }

    @Override
    public void apresentarPaciente(Paciente paciente){
        txtResultNome.setText(paciente.getNome());
        txtResultDtNasc.setText(String.valueOf(paciente.getDataNascimento()));
        txtResultSus.setText(paciente.getNumeroSus());
        txtResultCpf.setText(paciente.getCpf());
        txtNomeTitulo.setText(paciente.getNome());
    }
}
