package br.com.senaijandira.pacientes.service;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ServiceFactory {

    public static PacienteService create(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(PacienteService.URL_BASE)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        return retrofit.create(PacienteService.class);
    }
}
