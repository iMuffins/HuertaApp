package com.huertaUrbana.finalfinalfinalhuerta;

import android.Manifest;
import android.app.DatePickerDialog;
import android.content.ContentValues;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.app.Activity;
import android.database.Cursor;
import android.view.Menu;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.room.Database;
import androidx.constraintlayout.widget.ConstraintLayout;

import java.io.FileNotFoundException;
import java.util.Calendar;
import java.util.StringTokenizer;

import com.huertaUrbana.finalfinalfinalhuerta.R;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    /*------------------------------------ºº------------------------------------*/
    //                     INTERFAZ AGREGAR

    //QR
    private Button scanBtn, guardar, eliminar, ver;
    private EditText codigoQR, nombreQR, fechaPlantacion;
    //TEXTO
    private EditText Nombre_inicio;

    //FECHA
    private static final String TAG = "MainActivity";
    private TextView mDisplayDate;
    private DatePickerDialog.OnDateSetListener mDateSetListener;

    //IMAGEN
    Button capImg;
    ImageView fotoimgView;
    Uri img_Uri;
    int i = 0;
    String i1;

    Database database = new Database(this);



    private AppBarConfiguration mAppBarConfiguration;
    private static final int PERMISSION_CODE = 1000;
    private static final int IMAGE_CAPTURE_CODE = 1001;
    /*------------------------------------ºº------------------------------------*/




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BottomNavigationView navView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_agregar, R.id.navigation_lista, R.id.navigation_notifications)
                .build();

        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(navView, navController);



        //---------------------INTERFAZ AGREGAR---------------------------------------
        //QR
        setContentView(R.layout.activity_main);
        scanBtn=(Button) findViewById((R.id.scan_button));
        nombreQR= (EditText) findViewById(R.id.scan_nombre);
        fechaPlantacion=()findViewById(R.id.scan_fechaPlantacion);
        codigoQR=(EditText)findViewById(R.id.scan_codigo);
        scanBtn.setOnClickListener(this);
        guardar=(Button) findViewById(R.id.guardar);
        ver=(Button)findViewById(R.id.ver);
        ver.setOnClickListener(this);
        eliminar=(Button)findViewById(R.id.eliminar);
        eliminar.setOnClickListener();
        // FECHA
        mDateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int i, int i1, int i2) {
                Log.d(TAG, "onDateSet: date:  " + i + "/" + i1 + "/" + i2);
            }
        };

        //Imagen

        fotoimgView = (ImageView) findViewById(R.id.imgvFoto);
        capImg = (Button) findViewById(R.id.btMasFoto);
        //-----------------------------------------------------------------
    }
    public boolean onCreateOptionMenu (Menu menu){
    getMenuInflater().inflate(R.menu.MainActivity,menu);//nombre del main//
    return true}
}
    public void insertar(View v){
    AdminSQLiteOpenHelper admin= new AdminSQLiteOpenHelper(this, "administracion", null, 1);
    SQLiteDatabase bd= admin.getWritableDatabase();
    //aqui ponemos lo que vamos a traer y de donde ejemplo String cedula=et1.getText().toString();//
    ContentValues registro= new ContentValues();
    /*registro.put("nombre",cedula);
    bd.insert("vegetales", null, registro);
    bd.close;
    et1.setText("") se limpia el campo
    Toast.makeText(this, "Se cargaron los datos del vegetal", Toast.LENGTH_SHORT).show();
     */
    }
    public void consulta(View v){
        AdminSQLiteOpenHelper admin= new AdminSQLiteOpenHelper(this, "administracion", null, 1);
        SQLiteDatabase bd= admin.getWritableDatabase();
        /*String codigo= donde este el codigo
        Cursor fila=bd.rawQuery("select nombre, fecha, foto from vegetales where codigo=" + codigo, null);*/
        if (fila.moveToFirst()){

        }else
            Toast.makeText(this, "No existe ese vegetal", Toast.LENGTH_SHORT).show();
        bd.close();

    }
    public void eliminar (View v){
        AdminSQLiteOpenHelper admin= new AdminSQLiteOpenHelper(this, "administracion", null, 1);
        SQLiteDatabase bd= admin.getWritableDatabase();
        /*String codigo= de donde se saca;
        int cant= bd.delete("vegetales", "codigo="+ codigo, null);
        bd.close();
        editText.setText(""); seteamos campos*/
        if (cant==1)
            Toast.makeText(this, "Se borro el vegetal de dicho código"), Toast.LENGTH_SHORT).show();
        else
            Toast.makeText(this, "No existe el vegetal con dicho documento", Toast.LENGTH_SHORT).show();
    }
    public void modificar (View v) {
        AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(this, "administracion", null, 1);
        SQLiteDatabase bd = admin.getWritableDatabase();
        //capturamos datos ingresados nombre, fecha y foto//
        ContentValues registro = new ContentValues();
        registro.put("nombre", nombre);//inicializamos los registros a modificar//
        registro.put("fecha", fecha);
        registro.put("foto", foto);
        int cant = bd.update("vegetales", registro, "codigo=" + codigo, null);
        bd.close();
        if (cant == 1)
            Toast.makeText(this, "Se modificaron los datos", Toast.LENGTH_SHORT).show();
        else
            Toast.makeText(this, "No existe el vegetal con dicho código", Toast.LENGTH_SHORT).show();

}


    public void btGuardar_Inicio(View view) {


        //Datos de entrada
        setContentView(R.layout.activity_main);

        Nombre_inicio = (EditText) findViewById(R.id.txNombre);

        mDisplayDate = (TextView) findViewById(R.id.tvSeleccionarFecha);
        mDisplayDate.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view){
                Calendar cal = Calendar.getInstance();
                int año = cal.get(Calendar.YEAR);
                int mes = cal.get(Calendar.MONTH);
                int dia = cal.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog dialog = new DatePickerDialog(MainActivity.this, android.R.style.Theme_Holo_Light_Dialog_MinWidth, mDateSetListener, año, mes, dia);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.show();
            }
        });




        capImg.setOnClickListener(new Button.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    if (checkSelfPermission(Manifest.permission.CAMERA) == PackageManager.PERMISSION_DENIED ||
                            checkSelfPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_DENIED) {

                        String[] permisos = {Manifest.permission.CAMERA, Manifest.permission.WRITE_EXTERNAL_STORAGE};

                        requestPermissions(permisos, PERMISSION_CODE);
                    } else {
                        openCamera();
                    }
                } else {
                    openCamera();
                }

            }

        });

    }

    //-------------------------------------------------------------------------------------------------
    // CAMARA
    private void openCamera(){

        ContentValues values = new ContentValues();
        values.put(MediaStore.Images.Media.TITLE, "Nueva Foto");
        values.put(MediaStore.Images.Media.DESCRIPTION, "De la camara");
        img_Uri = getContentResolver().insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, values);
        //Intetnto de la camara
        Intent camaraInt = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        camaraInt.putExtra(MediaStore.EXTRA_OUTPUT, img_Uri);
        startActivityForResult(camaraInt, IMAGE_CAPTURE_CODE);

    }
    @Override
    public void  onRequestPermissionsResult(int requestCode, @NonNull String[] permisos, @NonNull int[] grantResults) {
        switch (requestCode){
            case  PERMISSION_CODE:{
                if(grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED){
                    openCamera();
                }
                else {
                    Toast.makeText(this, "Permisos denegados", Toast.LENGTH_SHORT).show();
                }
            }
        }
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data){

        /*if(resultCode == RESULT_OK){
            fotoimgView.setImageURI(img_Uri);
        }*/
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {

            case 0:
                if (resultCode == RESULT_OK) {
                    Uri targetUri = data.getData();
                    //             textTargetUri.setText(targetUri.toString());
                    Bitmap bitmap;
                    try {
                        bitmap = BitmapFactory.decodeStream(getContentResolver().openInputStream(targetUri));
                        fotoimgView.setImageBitmap(bitmap);

                        i1 = bitmap.toString();
                        Log.i("firstimage........", "" + i1);
                        fotoimgView.setVisibility(View.VISIBLE);

                        AdminSQLiteOpenHelper db = database.getWritableDatabase();
                        db.execSQL("INSERT INTO UPLOAD VALUES('" + i1 + "')");

                    } catch (FileNotFoundException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                }
                break;

        }
        //FIN CAMARA
        //QR
        IntentResult scanningResult=IntentIntegrator.parseActivityResult(requestCode,resultCode,intent);
        if(scanningResult !=null) {
            //si entra se obtuvo resultado por lo tanto desplegamos en pantalla el contenido del código de barra scaneado//
            String scanContent = scanningResult.getContents();
            StringTokenizer t = new StringTokenizer(scanContent, "*");
            final String nombre = t.nextToken();
            final String fecha = t.nextToken();
            final String codigo = t.nextToken();
            nombreQR.setText("" + nombre);
            fechaPlantacion.setText("" + fecha);
            codigoQR.setText("" + codigo);
        }else{
            //quiere decir que no se obtuvo resultado//
            Toast toast =Toast.makeText(getApplicationContext(),"No se ha recibido datos del scaneo!", Toast.LENGTH_SHORT);
            toast.show();;
        }
        //------------------------------------------------------------------------------------------------------------------------
    }

    @Override
    public void onClick(View view) {
    if(view.getId()==R.id.scan_button){
    IntentIntegrator scanIntegrator= new IntentIntegrator(this);
    scanIntegrator.initiateScan();
    }
    if(view.getId()==R.id.guardar){
        AdminSQLiteOpenHelper admin= new AdminSQLiteOpenHelper(MainActivity.this,"huerta2",null,1);
        SQLiteDatabase bd= admin.getWritableDatabase();
        ContentValues registro= new ContentValues();
        registro.put("nombre",nombreQR.getText().toString());
        registro.put("fecha",fechaPlantacion.getText().toString());
        registro.put("codigo",codigoQR.getText().toString());
        bd.insert("vegetal",null, registro);
        bd.close();
        Toast.makeText(MainActivity.this,"Se guardaron los datos del vegetal satisfactoriamente", Toast.LENGTH_SHORT).show();
    }
        if(view.getId()==R.id.ver) {
            AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(MainActivity.this, "huerta2", null, 1);
            SQLiteDatabase bd = admin.getWritableDatabase();
            String cdg=codigoQR.getText().toString();
            Cursor registro=bd.rawQuery("select nombreQR,fechaPlantacion,codigoQR from vegetales where codigo="+cdg,null);
            if (registro.moveToFirst()){
                nombreQR.setText(registro.getString(1));
                fechaPlantacion.setText(registro.getString(2));
                codigoQR.setText(registro.getString(0));
        }else
            Toast.makeText(MainActivity.this, "No existe una obra con ese código", Toast.LENGTH_SHORT).show();
            bd.close();
    }
        if(view.getId()==R.id.eliminar){
            AdminSQLiteOpenHelper admin= new AdminSQLiteOpenHelper(MainActivity.this,"huerta2",null,1);
            SQLiteDatabase bd= admin.getWritableDatabase();
            String cdg=codigoQR.getText().toString();
            int cant= bd.delete("vegetales","codigo="+cdg,null);
            bd.close();
            nombreQR.setText("");
            fechaPlantacion.setText("");
            codigoQR.setText("");
            if(cant==1)
                Toast.makeText(MainActivity.this, "Los datos se borraron satisfactoriamente",Toast.LENGTH_SHORT).show();
            else
                Toast.makeText(MainActivity, "No existe un vegetal con ese código", Toast.LENGTH_SHORT).show();
}}}