package com.example.quickstart;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.googleapis.extensions.android.gms.auth.GoogleAccountCredential;
import com.google.api.client.googleapis.extensions.android.gms.auth.GooglePlayServicesAvailabilityIOException;
import com.google.api.client.googleapis.extensions.android.gms.auth.UserRecoverableAuthIOException;

import com.google.api.client.http.HttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.client.util.ExponentialBackOff;


import com.google.api.services.sheets.v4.SheetsScopes;

import com.google.api.services.sheets.v4.model.*;


import android.Manifest;
import android.accounts.AccountManager;
import android.app.ActionBar;
import android.app.Activity;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Looper;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.text.TextUtils;
import android.text.method.ScrollingMovementMethod;

import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;


import java.io.IOException;
import java.sql.Time;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.Formatter;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;


import pub.devrel.easypermissions.AfterPermissionGranted;
import pub.devrel.easypermissions.EasyPermissions;

public class MainActivity extends AppCompatActivity
        implements EasyPermissions.PermissionCallbacks {
    public static  int id = 1;
    int ide;
    PrincipalActivity timee;
    GuardarDatos datos;
    Animation uptodown,downtoup;
    GoogleAccountCredential mCredential;
    private TextView mOutputText;
    private Button mCallApiButton;
    RadioGroup radio;
    Button BOTON_RESPUESTAS, boton;
    ProgressDialog mProgress;
    TextView texto, imagen1,imagen2,imagen3,imagen4,imagen5,imagen6,imagen7,txt;
    String seleccionado;
    RadioButton radio1,radio2,radio3,radio4,radio5,radio6,radio7;

    static final int REQUEST_ACCOUNT_PICKER = 1000;
    static final int REQUEST_AUTHORIZATION = 1001;
    static final int REQUEST_GOOGLE_PLAY_SERVICES = 1002;
    static final int REQUEST_PERMISSION_GET_ACCOUNTS = 1003;

    private static final String BUTTON_TEXT = "Call Google Sheets API";
    private static final String PREF_ACCOUNT_NAME = "accountName";
    private static final String[] SCOPES = {SheetsScopes.SPREADSHEETS};
    //private static final String[] SCOPES = { SheetsScopes.SPREADSHEETS_READONLY };

    /**
     * Create the main activity.
     * @param savedInstanceState previously saved instance data.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        datos = GuardarDatos.instancia;
        txt = (TextView) findViewById(R.id.textView4);
        BOTON_RESPUESTAS = (Button) findViewById(R.id.BTNsiguiente5);
        texto = (TextView) findViewById(R.id.textotime4);
         boton = (Button)findViewById(R.id.volver);
        uptodown = AnimationUtils.loadAnimation(this,R.anim.uptodown);
        downtoup = AnimationUtils.loadAnimation(this,R.anim.downtoup);
        radio = (RadioGroup) findViewById(R.id.radioGroup4);
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(Color.parseColor("#006064")));
        txt.setText(Html.fromHtml(getResources().getString(R.string.pregunta4)));
        timee = PrincipalActivity.intancia;
        CountDownTimer countDownTimer = PrincipalActivity.mCountDownTimer;
        radio1 = (RadioButton)findViewById(R.id.radioButton16);
        radio2 = (RadioButton)findViewById(R.id.radioButton17);
        radio3 = (RadioButton)findViewById(R.id.radioButton18);
        radio4 = (RadioButton)findViewById(R.id.radioButton19);
        radio5 = (RadioButton)findViewById(R.id.radioButton20);
        radio6 = (RadioButton)findViewById(R.id.radioButton21);
        radio7 = (RadioButton)findViewById(R.id.radioButton22);
        int nose = 0;

        imagen1 = (TextView) findViewById(R.id.cara20);
        imagen2 = (TextView) findViewById(R.id.cara21);
        imagen3 = (TextView) findViewById(R.id.cara22);
        imagen4 = (TextView) findViewById(R.id.cara23);
        imagen5 = (TextView) findViewById(R.id.cara24);
        imagen6 = (TextView) findViewById(R.id.cara25);
        imagen7 = (TextView) findViewById(R.id.cara26);

        radio.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if(radio1.isChecked())
                {
                    seleccionado = radio1.getText().toString();
                }
                else if(radio2.isChecked())
                {
                    seleccionado = radio2.getText().toString();
                }
                else if(radio3.isChecked())
                {
                    datos.getOpciones4().clear();
                    seleccionado = radio3.getText().toString();
                }
                else if(radio4.isChecked())
                {
                    seleccionado = radio4.getText().toString();
                }
                else if(radio5.isChecked())
                {
                    seleccionado = radio5.getText().toString();
                }
                else if(radio6.isChecked())
                {
                    seleccionado = radio6.getText().toString();
                }
                else if(radio7.isChecked())
                {
                    seleccionado = radio7.getText().toString();
                }
            }
        });


        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                datos.getOpciones3().clear();
                datos.getOpciones4().clear();
                Intent Myintent = new Intent(getApplicationContext(),Pregunta3.class);
                startActivity(Myintent);
            }
        });


        BOTON_RESPUESTAS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getResultsFromApi();

                BOTON_RESPUESTAS.setEnabled(true);

            }
        });

        imagen1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                radio1.setChecked(true);
                    seleccionado = imagen1.getText().toString();
            }
        });

        imagen2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                radio2.setChecked(true);
                    seleccionado = imagen2.getText().toString();
                }
        });

        imagen3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                radio3.setChecked(true);
                    seleccionado = imagen3.getText().toString();
            }
        });

        imagen4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    radio4.setChecked(true);
                    seleccionado = imagen4.getText().toString();
            }
        });

        imagen5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    radio5.setChecked(true);
                    seleccionado = imagen5.getText().toString();
            }
        });

        imagen6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                seleccionado = imagen6.getText().toString();
                radio6.setChecked(true);
            }
        });

        imagen7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                seleccionado = imagen7.getText().toString();
                radio7.setChecked(true);
            }
        });



        texto.setVerticalScrollBarEnabled(true);
        texto.setMovementMethod(new ScrollingMovementMethod());
        texto.setText("");


        mProgress = new ProgressDialog(this);
        mProgress.setMessage("Enviando su Información");



        // Initialize credentials and service object.
        mCredential = GoogleAccountCredential.usingOAuth2(
                getApplicationContext(), Arrays.asList(SCOPES))
                .setBackOff(new ExponentialBackOff());
    }



    /**
     * Attempt to call the API, after verifying that all the preconditions are
     * satisfied. The preconditions are: Google Play Services installed, an
     * account was selected and the device currently has online access. If any
     * of the preconditions are not satisfied, the app will prompt the user as
     * appropriate.
     */

    private void getResultsFromApi() {
        if (! isGooglePlayServicesAvailable()) {
            acquireGooglePlayServices();
        } else if (mCredential.getSelectedAccountName() == null) {
            chooseAccount();
        } else if (! isDeviceOnline()) {
            texto.setText("El dispositivo no está conectado.");
        } else {
            new MakeRequestTask(mCredential).execute();
        }
    }
    /**
     * Attempts to set the account used with the API credentials. If an account
     * name was previously saved it will use that one; otherwise an account
     * picker dialog will be shown to the user. Note that the setting the
     * account to use with the credentials object requires the app to have the
     * GET_ACCOUNTS permission, which is requested here if it is not already
     * present. The AfterPermissionGranted annotation indicates that this
     * function will be rerun automatically whenever the GET_ACCOUNTS permission
     * is granted.
     */
    @AfterPermissionGranted(REQUEST_PERMISSION_GET_ACCOUNTS)
    private void chooseAccount() {
        if (EasyPermissions.hasPermissions(
                this, Manifest.permission.GET_ACCOUNTS)) {
            String accountName = getPreferences(Context.MODE_PRIVATE)
                    .getString(PREF_ACCOUNT_NAME, null);
            if (accountName != null) {
                mCredential.setSelectedAccountName(accountName);
                getResultsFromApi();
            } else {
                // Start a dialog from which the user can choose an account
                startActivityForResult(
                        mCredential.newChooseAccountIntent(),
                        REQUEST_ACCOUNT_PICKER);
            }
        } else {
            // Request the GET_ACCOUNTS permission via a user dialog
            EasyPermissions.requestPermissions(
                    this,
                    "This app needs to access your Google account (via Contacts).",
                    REQUEST_PERMISSION_GET_ACCOUNTS,
                    Manifest.permission.GET_ACCOUNTS);
        }
    }

    /**
     * Called when an activity launched here (specifically, AccountPicker
     * and authorization) exits, giving you the requestCode you started it with,
     * the resultCode it returned, and any additional data from it.
     * @param requestCode code indicating which activity result is incoming.
     * @param resultCode code indicating the result of the incoming
     *     activity result.
     * @param data Intent (containing result data) returned by incoming
     *     activity result.
     */
    @Override
    protected void onActivityResult(
            int requestCode, int resultCode, Intent data) {
                super.onActivityResult(requestCode, resultCode, data);
                switch(requestCode) {
                    case REQUEST_GOOGLE_PLAY_SERVICES:
                        if (resultCode != RESULT_OK) {
                            texto.setText(
                                    "This app requires Google Play Services. Please install " +
                                            "Google Play Services on your device and relaunch this app.");
                        } else {
                            getResultsFromApi();
                        }
                        break;
            case REQUEST_ACCOUNT_PICKER:
                if (resultCode == RESULT_OK && data != null &&
                        data.getExtras() != null) {
                    String accountName =
                            data.getStringExtra(AccountManager.KEY_ACCOUNT_NAME);
                    if (accountName != null) {
                        SharedPreferences settings =
                                getPreferences(Context.MODE_PRIVATE);
                        SharedPreferences.Editor editor = settings.edit();
                        editor.putString(PREF_ACCOUNT_NAME, accountName);
                        editor.apply();
                        mCredential.setSelectedAccountName(accountName);
                        getResultsFromApi();
                    }
                }
                break;
            case REQUEST_AUTHORIZATION:
                if (resultCode == RESULT_OK) {
                    getResultsFromApi();
                }
                break;
        }
    }

    /**
     * Respond to requests for permissions at runtime for API 23 and above.
     * @param requestCode The request code passed in
     *     requestPermissions(android.app.Activity, String, int, String[])
     * @param permissions The requested permissions. Never null.
     * @param grantResults The grant results for the corresponding permissions
     *     which is either PERMISSION_GRANTED or PERMISSION_DENIED. Never null.
     */
    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           @NonNull String[] permissions,
                                           @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        EasyPermissions.onRequestPermissionsResult(
                requestCode, permissions, grantResults, this);
    }

    /**
     * Callback for when a permission is granted using the EasyPermissions
     * library.
     * @param requestCode The request code associated with the requested
     *         permission
     * @param list The requested permission list. Never null.
     */
    @Override
    public void onPermissionsGranted(int requestCode, List<String> list) {
        // Do nothing.
    }

    /**
     * Callback for when a permission is denied using the EasyPermissions
     * library.
     * @param requestCode The request code associated with the requested
     *         permission
     * @param list The requested permission list. Never null.
     */
    @Override
    public void onPermissionsDenied(int requestCode, List<String> list) {
        // Do nothing.
    }

    /**
     * Checks whether the device currently has a network connection.
     * @return true if the device has a network connection, false otherwise.
     */
    private boolean isDeviceOnline() {
        ConnectivityManager connMgr =
                (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();
        return (networkInfo != null && networkInfo.isConnected());
    }

    /**
     * Check that Google Play services APK is installed and up to date.
     * @return true if Google Play Services is available and up to
     *     date on this device; false otherwise.
     */
    private boolean isGooglePlayServicesAvailable() {
        GoogleApiAvailability apiAvailability =
                GoogleApiAvailability.getInstance();
        final int connectionStatusCode =
                apiAvailability.isGooglePlayServicesAvailable(this);
        return connectionStatusCode == ConnectionResult.SUCCESS;
    }

    /**
     * Attempt to resolve a missing, out-of-date, invalid or disabled Google
     * Play Services installation via a user dialog, if possible.
     */
    private void acquireGooglePlayServices() {
        GoogleApiAvailability apiAvailability =
                GoogleApiAvailability.getInstance();
        final int connectionStatusCode =
                apiAvailability.isGooglePlayServicesAvailable(this);
        if (apiAvailability.isUserResolvableError(connectionStatusCode)) {
            showGooglePlayServicesAvailabilityErrorDialog(connectionStatusCode);
        }
    }


    /**
     * Display an error dialog showing that Google Play Services is missing
     * or out of date.
     * @param connectionStatusCode code describing the presence (or lack of)
     *     Google Play Services on this device.
     */
    void showGooglePlayServicesAvailabilityErrorDialog(
            final int connectionStatusCode) {
        GoogleApiAvailability apiAvailability = GoogleApiAvailability.getInstance();
        Dialog dialog = apiAvailability.getErrorDialog(
                MainActivity.this,
                connectionStatusCode,
                REQUEST_GOOGLE_PLAY_SERVICES);
        dialog.show();
    }

    /**
     * An asynchronous task that handles the Google Sheets API call.
     * Placing the API calls in their own task ensures the UI stays responsive.
     */
    private class MakeRequestTask extends AsyncTask<Void, Void, List<String>> {
        public com.google.api.services.sheets.v4.Sheets mService = null;
        private Exception mLastError = null;

        MakeRequestTask(GoogleAccountCredential credential) {
            HttpTransport transport = AndroidHttp.newCompatibleTransport();
            JsonFactory jsonFactory = JacksonFactory.getDefaultInstance();
            mService = new com.google.api.services.sheets.v4.Sheets.Builder(
                    transport, jsonFactory, credential)
                    .setApplicationName("encuestaTuOpinionDF")
                    .build();
        }



        /**
         * Background task to call Google Sheets API.
         * @param params no parameters needed for this task.
         */
        @Override
        protected List<String> doInBackground(Void... params) {
            try {
                return WriteExample();
                //return WriteExample2();
                //return getDataFromApi();
            } catch (Exception e) {
                mLastError = e;
                cancel(true);
                return null;
            }
        }



        /**
         * Fetch a list of names and majors of students in a sample spreadsheet:
         * https://docs.google.com/spreadsheets/d/1BxiMVs0XRA5nFMdKvBdBZjgmUUqptlbs74OgvE2upms/edit
         * @return List of names and majors
         * @throws IOException
         */
        private List<String> getDataFromApi() throws IOException {
            int index = 0;
            String spreadsheetId = "";
            String range = "respuestas_encuesta!A2:D2";
            List<String> results = new ArrayList<String>();
            ValueRange response = this.mService.spreadsheets().values().get(spreadsheetId, range).execute();
            List<List<Object>> values = response.getValues();
            if (values != null) {
                results.add("Nombre, Apellido");
                for (List row : values) {
                    results.add(row.get(index) + " , " + row.get(index+1)+ " , " + row.get(index+2)+ " , " + row.get(index+3));
                    index++;
                }
            }
            return results;
        }



        @Nullable
        private List<String> WriteExample() throws IOException {
            if (seleccionado != null) {
                int foo;
                PrincipalActivity.mCountDownTimer.cancel();
                foo = Integer.parseInt(seleccionado);
                //double ekizde;
                datos.getOpciones4().add(seleccionado);
                //Calendar c1 = Calendar.getInstance(TimeZone.getTimeZone("CHL"));
                //int dia2 = c1.get(Calendar.DAY_OF_YEAR);
                //int mes2 = c1.get(Calendar.MONTH);
                //int annio = c1.get(Calendar.YEAR);

                //double fecha1 = dia2&mes2&annio;




                Date date = new Date();
                DateFormat formatofecha2 = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");
                int hora = date.getHours();
                //int minuto = date.getMinutes();
                //int segundos = date.getSeconds();
                //int dia = date.getDay();
                //int mes = date.getMonth();
                //int ano = date.getYear();

                //double fecha = dia&mes&ano&hora&minuto&segundos;

                Date date1 = new Date();
                DateFormat formatofecha = new SimpleDateFormat("yyyy-M");
                String formula2 = "=AHORA()";

               // ekizde = Double.parseDouble(date.toString());
                //hoja encuesta 1w0ThLBg0vi48uQgpSPxVCko5nLEO9pUOG9bedoKyZEs
              //hoja mia  1KU5B-KcP4wRa8GzShcw7DDpmW_xMo7QWJc_cF08geWo
                String spreadsheetId = "1w0ThLBg0vi48uQgpSPxVCko5nLEO9pUOG9bedoKyZEs";
                List<Request> requests = new ArrayList<>();
                List<CellData> values2 = new ArrayList<>();

                values2.add(new CellData()
                        .setUserEnteredValue(new ExtendedValue()
                                .setStringValue(""))
                );
                values2.add(new CellData()
                        .setUserEnteredValue(new ExtendedValue()
                                .setStringValue(formatofecha2.format(date)))
                );

                values2.add(new CellData()
                        .setUserEnteredValue(new ExtendedValue()
                                .setStringValue((datos.getOpciones().toString().replace("[", "").replace("]", ""))))
                );
                values2.add(new CellData()
                        .setUserEnteredValue(new ExtendedValue()
                                .setStringValue(datos.getOpciones2().toString().replace("[", "").replace("]", "")))

                );
                values2.add(new CellData()
                        .setUserEnteredValue(new ExtendedValue()
                                .setStringValue(datos.getOpciones3().toString().replace("[", "").replace("]", "")))
                );

                values2.add(new CellData()
                        .setUserEnteredValue(new ExtendedValue()
                                .setNumberValue(Double.parseDouble(datos.getOpciones4().toString().replace("[","").replace("]",""))))
                );
                values2.add(new CellData()
                        .setUserEnteredValue(new ExtendedValue()
                                .setFormulaValue(formula2))
                );
                requests.add(new Request()
                        .setAppendCells(new AppendCellsRequest()

                                .setRows(Arrays.asList(
                                        new RowData().setValues(values2)))
                                .setFields("userEnteredValue")
                        )
                );

                // requests.add(new Request()
                //       .setUpdateCells(new UpdateCellsRequest()
                //             .setStart(new GridCoordinate()
                //                 .setSheetId(0)
                //                .setRowIndex(1)
                //              .setColumnIndex(0)
                //    )
                //    .setRows(Arrays.asList(
                //  new RowData().setValues(values2)))
                //.setFields("userEnteredValue,userEnteredFormat.backgroundColor")));
                BatchUpdateSpreadsheetRequest batchUpdateRequest = new BatchUpdateSpreadsheetRequest()
                        .setRequests(requests);
                this.mService.spreadsheets().batchUpdate(spreadsheetId, batchUpdateRequest)
                        .execute();
                Intent myintent = new Intent(getApplicationContext(), FinalActivity.class);
                startActivity(myintent);
            } else
            {
              // Intent myintent = new Intent(getApplicationContext(),MainActivity.class);
              // startActivity(myintent);
            }
            return null;

        }

        private List<String> WriteExample2() throws IOException {
            datos.getOpciones().add(seleccionado);
            datos.getOpciones2().add(seleccionado);
            datos.getOpciones3().add(seleccionado);
            datos.getOpciones4().add(seleccionado);

            String spreadsheetId = "1KU5B-KcP4wRa8GzShcw7DDpmW_xMo7QWJc_cF08geWo";


            List<ValueRange> data = new ArrayList<>();


            data.add(new ValueRange()
                    .setRange("A2")
                    .setValues(Arrays.asList(
                            Arrays.<Object>asList(String.valueOf(datos.getOpciones()))))
            );
            data.add(new ValueRange()
                    .setRange("B2")
                    .setValues(Arrays.asList(
                            Arrays.<Object>asList(String.valueOf(datos.getOpciones2()))))
            );
            data.add(new ValueRange()
                    .setRange("C2")
                    .setValues(Arrays.asList(
                            Arrays.<Object>asList(String.valueOf(datos.getOpciones3()))))
            );
            data.add(new ValueRange()
                    .setRange("D2")
                    .setValues(Arrays.asList(
                            Arrays.<Object>asList(String.valueOf(datos.getOpciones4()))))
            );

            final BatchUpdateValuesRequest batchBody = new BatchUpdateValuesRequest()
                    .setValueInputOption("USER_ENTERED")
                    .setData(data);
            BatchUpdateValuesResponse batchResult = this.mService.spreadsheets().values()
                    .batchUpdate(spreadsheetId, batchBody)
                    .execute();
            datos.getOpciones().clear();
            datos.getOpciones2().clear();
            datos.getOpciones3().clear();
            datos.getOpciones4().clear();


            return null;
        }








        @Override
        protected void onPreExecute() {
            texto.setText("");
            mProgress.show();
        }

        @Override
        protected void onPostExecute(List<String> output) {
            mProgress.hide();
            if (output == null || output.size() == 0) {
                texto.setText("Porfavor, seleccione una respuesta!.");
            } else {
                output.add(0, "");
                texto.setText(TextUtils.join("\n", output));
            }
        }

        @Override
        protected void onCancelled() {
            mProgress.hide();
            if (mLastError != null) {
                if (mLastError instanceof GooglePlayServicesAvailabilityIOException) {
                    showGooglePlayServicesAvailabilityErrorDialog(
                            ((GooglePlayServicesAvailabilityIOException) mLastError)
                                    .getConnectionStatusCode());
                } else if (mLastError instanceof UserRecoverableAuthIOException) {
                    startActivityForResult(
                            ((UserRecoverableAuthIOException) mLastError).getIntent(),
                            MainActivity.REQUEST_AUTHORIZATION);
                } else {
                    texto.setText("Ha ocurrido el siguiente error:\n"
                            + mLastError.getMessage());
                }
            } else {
                texto.setText("Request cancelled.");
            }
        }
    }
}