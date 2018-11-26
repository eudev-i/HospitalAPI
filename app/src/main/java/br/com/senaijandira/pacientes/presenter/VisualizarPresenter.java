package br.com.senaijandira.pacientes.presenter;

import br.com.senaijandira.pacientes.model.Paciente;
import br.com.senaijandira.pacientes.service.PacienteService;
import br.com.senaijandira.pacientes.view.VisualizarView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class VisualizarPresenter {

    VisualizarView view;
    PacienteService service;

    public VisualizarPresenter(VisualizarView view, PacienteService service){
        this.view = view;
        this.service = service;

    }

    public void pacienteResult(int id){
        service.pacientePorId(id).enqueue((new Callback<Paciente>() {
            @Override
            public void onResponse(Call<Paciente> call, Response<Paciente> response) {
                view.apresentarPaciente(response.body());
            }

            @Override
            public void onFailure(Call<Paciente> call, Throwable t) {

            }
        }));
    }
}
