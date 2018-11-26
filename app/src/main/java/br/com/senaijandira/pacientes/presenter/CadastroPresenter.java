package br.com.senaijandira.pacientes.presenter;

import br.com.senaijandira.pacientes.model.ApiResult;
import br.com.senaijandira.pacientes.model.Paciente;
import br.com.senaijandira.pacientes.service.PacienteService;
import br.com.senaijandira.pacientes.view.CadastroView;
import retrofit2.Call;
import retrofit2.Response;

public class CadastroPresenter {

    CadastroView view;
    PacienteService service;

    public  CadastroPresenter(CadastroView view, PacienteService service){
        this.view = view;
        this.service = service;
    }

    public void cadastrarPaciente(Paciente paciente){

        service.cadastrarPaciente(paciente).enqueue(new retrofit2.Callback<ApiResult>() {
            @Override
            public void onResponse(Call<ApiResult> call, Response<ApiResult> response) {

                view.showMessage("Sucesso", "Cadastrado com sucesso");
            }

            @Override
            public void onFailure(Call<ApiResult> call, Throwable t) {
                view.showMessage("Erro", "Erro ao cadastrar");
            }
        });
    }
}
