package com.example.rebcesp.proyectointegradorv2;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.rebcesp.proyectointegradorv2.Model.User;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class SignUp extends AppCompatActivity {

    EditText edtPhone,edtName,edtPassword;
    Button btnSignUp,btnResetPassword;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        edtPhone=(EditText)findViewById(R.id.edtPhone);
        edtName=(EditText)findViewById(R.id.edtName);
        edtPassword=(EditText)findViewById(R.id.edtPassword);
        btnSignUp=(Button)findViewById(R.id.btnSignUp);

//        //Recuperar contraseña
//        btnResetPassword=(Button)findViewById(R.id.btn_reset_password);


        //Iniciamos el firebase Database

         final FirebaseDatabase database= FirebaseDatabase.getInstance();
         final DatabaseReference table_user = database.getReference("User");

//         btnResetPassword.setOnClickListener(new View.OnClickListener() {
//             @Override
//             public void onClick(View v) {
//                 Intent i = new Intent(SignUp.this,RecuperarPassword.class);
//                 startActivity(i);
//                 finish();
//             }
//         });



         btnSignUp.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {

                 final ProgressDialog mDialog = new ProgressDialog(SignUp.this);
                 mDialog.setMessage("Porfavor Espere");
                 mDialog.show();

                 table_user.addValueEventListener(new ValueEventListener() {
                     @Override
                     public void onDataChange(DataSnapshot dataSnapshot) {
                         //Verificamos si tiene telefono
                         if (dataSnapshot.child(edtPhone.getText().toString()).exists()) {


                             mDialog.dismiss();
                             Toast.makeText(SignUp.this, "Numero de telefono Verificado", Toast.LENGTH_SHORT).show();

                         } else

                         {
                             mDialog.dismiss();
                             User user = new User(edtName.getText().toString(), edtPassword.getText().toString());
                             table_user.child(edtPhone.getText().toString()).setValue(user);
                             if (edtPassword.getText().toString().equals("")) {
                                 Toast.makeText(SignUp.this,"Introduce una contraseña",Toast.LENGTH_SHORT).show();

                             } else {

                                 Toast.makeText(SignUp.this, "Registro Correctamente", Toast.LENGTH_SHORT).show();
                                 Intent i = new Intent(SignUp.this, SignIn.class);
                                 i.putExtra("telefono", edtPhone.getText().toString());
                                 i.putExtra("password", edtPassword.getText().toString());
                                 startActivity(i);
                                 finish();

                             }
                         }
                     }

                     @Override
                     public void onCancelled(DatabaseError databaseError) {

                     }
                 });

             }
         });
    }
}
