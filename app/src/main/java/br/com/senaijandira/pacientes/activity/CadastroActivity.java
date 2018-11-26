package br.com.senaijandira.pacientes.activity;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;

import java.util.Calendar;

import br.com.senaijandira.pacientes.R;
import br.com.senaijandira.pacientes.model.Paciente;
import br.com.senaijandira.pacientes.presenter.CadastroPresenter;
import br.com.senaijandira.pacientes.service.PacienteService;
import br.com.senaijandira.pacientes.service.ServiceFactory;
import br.com.senaijandira.pacientes.util.DateUtil;
import br.com.senaijandira.pacientes.view.CadastroView;

public class CadastroActivity extends AppCompatActivity implements CadastroView{

    static EditText txtNome, txtDtNascimento, txtNumeroSus, txtCpf;

    //INSTANCIANDO A CLASSE DE SERVIÇO DA API
    PacienteService service = ServiceFactory.create();

    CadastroPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);

        //INSTANCIANDO O CADASTRO PRESENTER
        presenter= new CadastroPresenter(this, service);

        txtNome = findViewById(R.id.txtNome);
        txtDtNascimento = findViewById(R.id.txtDtNascimento);
        txtNumeroSus = findViewById(R.id.txtNumeroSus);
        txtCpf = findViewById(R.id.txtCpf);
    }

    //FUNÇAO PARA QUE NO CLIQUE CADASTRE UM PACIENTE
    public void cadastroPaciente(View view){

        String nome = txtNome.getText().toString();
        String dtNascimento = txtDtNascimento.getText().toString();
        String numeroSus = txtNumeroSus.getText().toString();
        String cpf = txtCpf.getText().toString();

        int dataFormatada = new DateUtil().convertToInt(dtNascimento);

        Paciente paciente = new Paciente();
        paciente.setNome(nome);
        paciente.setDataNascimento(dataFormatada);
        paciente.setNumeroSus(numeroSus);
        paciente.setCpf(cpf);

        presenter.cadastrarPaciente(paciente);
    }

    //NA AÇÃO DO CLICK DO NOME DO CALENDARIO, ABRIR O CALENDARIO
    public void abrirCalendario(View view){

        //Showing the date picker
        DialogFragment newFragment = new DatePickerFragment();
        newFragment.show(getSupportFragmentManager(), "datePicker");
    }

    //IMPLEMENTANDO O METODO DEFINIDO NO CONTRATO

    @Override
    public void showMessage(String titulo, String mensagem) {
        AlertDialog.Builder alert = new AlertDialog.Builder(this);
        alert.setTitle(titulo);
        alert.setMessage(mensagem);
        alert.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish();
            }
        });
        alert.show();
    }


    //Creating a Date Picker
    public static class DatePickerFragment extends android.support.v4.app.DialogFragment
            implements DatePickerDialog.OnDateSetListener {

        @Override
        public Dialog onCreateDialog(Bundle savedInstanceState) {
            // Use the current date as the default date in the picker
            //USE A DATA ATUAL COMO A DATA PADRÃO NO SELECIONADOR
            final Calendar c = Calendar.getInstance();
            int year = c.get(Calendar.YEAR);
            int month = c.get(Calendar.MONTH);
            int day = c.get(Calendar.DAY_OF_MONTH);

            // Create a new instance of DatePickerDialog and return it
            //CRIA UMA NOVA INSTÂNCIA DE DatePickerDialog E RETORNE-A
            return new DatePickerDialog(getActivity(), this, year, month, day);
        }

        public void onDateSet(DatePicker view, int year, int month, int day) {


            String data = String.format("%02d/%02d/%d", day, month, year);
            txtDtNascimento.setText(data);

        }
    }

}
