package br.com.senaijandira.pacientes.service;

import java.util.List;

import br.com.senaijandira.pacientes.model.ApiResult;
import br.com.senaijandira.pacientes.model.Paciente;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface PacienteService {

    String URL_BASE = "http://10.0.2.2:5001/";

    @GET("/pacientes")
    Call<List<Paciente>> obterPacientes();

    @POST("/paciente/novo")
        //void cadastrarAluno(Aluno aluno);
    Call<ApiResult> cadastrarPaciente(@Body Paciente paciente);

    @GET("paciente/{id}")
    Call<Paciente> pacientePorId(@Path("id")int id);

    @GET("/paciente/deletar/{id}")
    Call<Paciente> deltarPacientePorId(@Path("id")int id);

}
