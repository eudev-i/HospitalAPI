package br.com.senaijandira.pacientes.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.List;

import br.com.senaijandira.pacientes.R;
import br.com.senaijandira.pacientes.adapter.PacienteAdapter;
import br.com.senaijandira.pacientes.model.Paciente;
import br.com.senaijandira.pacientes.presenter.MainPresenter;
import br.com.senaijandira.pacientes.service.ServiceFactory;
import br.com.senaijandira.pacientes.view.MainView;

public class MainActivity extends AppCompatActivity implements MainView, AdapterView.OnItemClickListener {

    ListView listView;


    PacienteAdapter adapter;

    //ProgressBar progressBar;

    MainPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.listView);
        adapter = new PacienteAdapter(this);/*INSTANCIAR O ADAPTER*/
        listView.setAdapter(adapter);/*PLUGAR O ADAPTER NA LISTA*/
        listView.setOnItemClickListener(this);

        /*CONFIG PRESENTER*/
        presenter = new MainPresenter(this, ServiceFactory.create());
    }

    @Override
    protected void onResume() {
        super.onResume();

        presenter.carregarPacientes();/*PARA QUANDO CADASTRAR JÁ APARECER O CADASTRO*/

    }

    /*@Override
    public void exibirBarraProgresso(){

        progressBar.setVisibility(View.VISIBLE);
        listView.setVisibility(View.GONE);
    }

    @Override
    public void esconderBarraProgresso(){

        progressBar.setVisibility(View.GONE);
        listView.setVisibility(View.VISIBLE);
    }*/

    @Override
    public void preencherLista(List<Paciente> lstPacientes){

        adapter.clear();
        adapter.addAll(lstPacientes);
    }

    /*ONCLIK PARA QUANDO APERTAR NO BOTÃO ABRIR OUTRA PAGINA*/
    public void abrirCadastro(View view) {
        startActivity(new Intent(this, CadastroActivity.class));
    }

    /*IDENTIFICAR O CLIQUE DA LISTA*/
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

        /*PEGANDO O CLIQUE*/
        Paciente pacienteSelecionado = adapter.getItem(position);

        Intent intent  = new Intent(this, VisualizarActivity.class);
        intent.putExtra("idPaciente", pacienteSelecionado.getId());

        startActivity(intent);
    }
}
