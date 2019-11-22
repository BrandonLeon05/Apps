package mx.edu.utng.firebaseapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {
    //Declarar objetos de la vista
    EditText etxTema;
    Spinner spiCarrera, spiMateria;
    Button btnReg;

    private DatabaseReference refDiario; //Referencia a la BD


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        refDiario = FirebaseDatabase.getInstance().getReference("Clase");
        //Relacionar componentes visuales //Casteando
        etxTema = (EditText) findViewById(R.id.etxTema);
        spiCarrera= (Spinner) findViewById(R.id.spiCarrera);
        spiMateria= (Spinner) findViewById(R.id.spiMaterias);
        btnReg = (Button) findViewById(R.id.btnRegistrar);

        //Asociar clase escucha para el evente
        btnReg.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                registrarClase();
            }
        });
    } //Fin de On Create

    public void registrarClase(){
        //Guardar los datos de la vista
        String carrera= spiCarrera.getSelectedItem().toString();
        String materia= spiMateria.getSelectedItem().toString();
        String tema= etxTema.getText().toString();

        //Comprobar que el tema no este vacio
        if(!TextUtils.isEmpty(tema)){
            String id = refDiario.push().getKey();
            Clase leccion = new Clase(id,carrera,materia,tema);
            refDiario.child("Lecciones").child(id).setValue(leccion);
            Toast.makeText(this,"Clase registrada",Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(this,"Falta ingresar tema",Toast.LENGTH_LONG).show();
        }
    }
}
