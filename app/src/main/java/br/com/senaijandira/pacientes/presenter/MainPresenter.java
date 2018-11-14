package br.com.senaijandira.pacientes.presenter;

import android.util.Log;

import java.util.List;

import br.com.senaijandira.pacientes.model.Paciente;
import br.com.senaijandira.pacientes.service.PacienteService;
import br.com.senaijandira.pacientes.service.ServiceFactory;
import br.com.senaijandira.pacientes.view.MainView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainPresenter {

    MainView mainView;
    PacienteService service;

    public MainPresenter (MainView mainView, PacienteService service){

        this.mainView = mainView;
        this.service = service;
    }

    public void carregarPacientes(){

        //Criar o serviço que chama a API
        PacienteService service = ServiceFactory.create();

        //Objeto de chamada a API de pacientes
        Call<List<Paciente>> call = service.obterPacientes();

        //mainView.exibirBarraProgresso();

        //Efetuar a chamada a API
        call.enqueue(new Callback<List<Paciente>>() {
            @Override
            public void onResponse(Call<List<Paciente>> call, Response<List<Paciente>> response) {

                //Lista de pacientes retornada pelo servidor
                List<Paciente> pacientes = response.body();


                mainView.preencherLista(pacientes); /*EXIBE OS PACIENTES NA TELA*/

                //mainView.esconderBarraProgresso(); /*ESCONDER A BARRA DE PROGRESSO DEPOIS QUE CARREGOU OS ALUNOS E A LISTA FOI PREENCHIDA*/
            }

            @Override
            public void onFailure(Call<List<Paciente>> call, Throwable t) {
                Log.e("ERRO_API", t.getMessage());
            }
        });
    }
}
