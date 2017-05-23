package mng.r.lydia.class_schedule;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.MultiAutoCompleteTextView;
import android.widget.TextView;
import android.widget.Toast;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.TextWatcher;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.MultiAutoCompleteTextView;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Calendar;

public class  SigninActivity extends AppCompatActivity {
    AutoCompleteTextView t;
    MultiAutoCompleteTextView t1;
    String[] country = {"America", "Burundi", "Congo", "Dubai", "Egypt", "France", "Ghana", "Holland", "Jamaica", "Kenya", "Libya", "Malawi", "Nigeria", "Rwanda", "Tanzania", "Uganda", "Zimbabwe", "Other"};
    Button sign;
    ProgressDialog mProgressDialog;
    String query, resulta;
    HttpURLConnection con;
    JSONObject json_data;
    EditText num, name, email, pass, dob, cont;
    private DatePicker datePicker;
    private Calendar calendar;
    private TextView dateView;
    private int year, month, day;

    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);
        setTitle("REGISTRATION");
        num = (EditText) findViewById(R.id.id);
        name = (EditText) findViewById(R.id.name);
        email = (EditText) findViewById(R.id.em);
        pass = (EditText) findViewById(R.id.ps);
        dob = (EditText) findViewById(R.id.db);
        cont = (EditText) findViewById(R.id.ct);
        sign = (Button) findViewById(R.id.bt1);

        dateView = (TextView) findViewById(R.id.txtd);
        calendar = Calendar.getInstance();
        year = calendar.get(Calendar.YEAR);

        month = calendar.get(Calendar.MONTH);
        day = calendar.get(Calendar.DAY_OF_MONTH);
        showDate(year, month+1, day);

        sign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                {
                    if (num.getText().toString().compareTo("") == 0) {
                        final AlertDialog.Builder alert = new AlertDialog.Builder(SigninActivity.this);
                        LinearLayout lila1 = new LinearLayout(SigninActivity.this);
                        lila1.setOrientation(LinearLayout.VERTICAL);
                        alert.setView(lila1);
                        alert.setTitle("Error");
                        alert.setMessage("Username must be supplied ");
                        alert.setIcon(R.drawable.erro);
                        alert.setNegativeButton("Back To Login", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int whichButton) {
                                dialog.cancel();
                            }


                        });
                        alert.show();
                        return;
                    } else if (name.getText().toString().compareTo("") == 0) {
                        final AlertDialog.Builder alert = new AlertDialog.Builder(SigninActivity.this);
                        LinearLayout lila1 = new LinearLayout(SigninActivity.this);
                        lila1.setOrientation(LinearLayout.VERTICAL);
                        alert.setView(lila1);
                        alert.setTitle("Error");
                        alert.setMessage("Password must be supplied ");
                        alert.setIcon(R.drawable.erro);
                        alert.setNegativeButton("Back To Login", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int whichButton) {
                                dialog.cancel();
                            }


                        });
                        alert.show();
                        return;
                    } else {

                        final class Des extends AsyncTask<Void, Void, Void> {

                            @Override
                            protected void onPreExecute() {


                                super.onPreExecute();

                                mProgressDialog = new ProgressDialog(SigninActivity.this);
                                mProgressDialog.setMessage("Signing up");
                                mProgressDialog.setIndeterminate(false);
                                mProgressDialog.setCancelable(true);
                                mProgressDialog.show();
                                Uri.Builder builder = new Uri.Builder()
                                        .appendQueryParameter("number", num.getText().toString().trim())
                                        .appendQueryParameter("username", name.getText().toString().trim())
                                        .appendQueryParameter("email", email.getText().toString().trim())
                                        .appendQueryParameter("password", pass.getText().toString().trim())
                                        .appendQueryParameter("dob", dob.getText().toString().trim())
                                        .appendQueryParameter("country", cont.getText().toString().trim());
                                query = builder.build().getEncodedQuery();

                            }

                            @Override
                            protected Void doInBackground(Void... params) {


                                InputStream is = null;
                                try {

                                    String url = "http://mngodo.6te.net/login/sign.php";
                                    URL obj = new URL(url);
                                    con = (HttpURLConnection) obj.openConnection();
                                    con.setRequestMethod("POST");
                                    con.setRequestProperty("User-Agent", "Mozilla/4.0 (compatible; MSIE 7.0; Windows NT 5.1)");
                                    con.setRequestProperty("Accept-Language", "UTF-8");
                                    con.setDoOutput(true);
                                    OutputStreamWriter outputStreamWriter = new OutputStreamWriter(con.getOutputStream());
                                    outputStreamWriter.write(query);
                                    outputStreamWriter.flush();
                                    Log.e("pass 1", "connection success ");
                                } catch (Exception e) {
                                    Log.e("Fail 1", e.toString());

                                }


                                try {
                                    BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
                                    String line;
                                    StringBuffer sb = new StringBuffer();

                                    while ((line = in.readLine()) != null) {
                                        sb.append(line + "\n");
                                    }
                                    //   is.close();
                                    resulta = sb.toString();
                                    Log.e("pass 2", "connection success ");
                                } catch (Exception e) {
                                    Log.e("Fail 2", e.toString());
                                }
                                return null;
                            }


                            @Override
                            protected void onPostExecute(Void result) {


                                try {
                                    json_data = new JSONObject(resulta);
                                    int code = (json_data.getInt("code"));
                                    if (code == 1) {

                                        final AlertDialog.Builder alert = new AlertDialog.Builder(SigninActivity.this);
                                        LinearLayout lila1 = new LinearLayout(SigninActivity.this);
                                        lila1.setOrientation(LinearLayout.VERTICAL);
                                        alert.setView(lila1);
                                        alert.setTitle("Success");
                                        alert.setMessage("You are now registered");
                                        alert.setIcon(R.drawable.tick);
                                        Log.e("Fail 3", "Value" + code);
                                        alert.setNegativeButton("proceed To Login", new DialogInterface.OnClickListener() {
                                            public void onClick(DialogInterface dialog, int whichButton) {
                                                Intent tomain = new Intent(SigninActivity.this, LoginActivity.class);
                                                startActivity(tomain);
                                                finish();
                                            }


                                        });
                                        alert.show();


                                        ///

                                    } else {
                                        final AlertDialog.Builder alert = new AlertDialog.Builder(SigninActivity.this);
                                        LinearLayout lila1 = new LinearLayout(SigninActivity.this);
                                        lila1.setOrientation(LinearLayout.VERTICAL);
                                        alert.setView(lila1);
                                        alert.setTitle("Login failed!");
                                        alert.setMessage("Check your username and password then retry.\nIf you forgot your password click on forgot password to recover");
                                        alert.setIcon(R.drawable.erro);
                                        Log.e("Fail 3", "Value" + code);
                                        alert.setNegativeButton("Back To Login", new DialogInterface.OnClickListener() {
                                            public void onClick(DialogInterface dialog, int whichButton) {
                                                dialog.cancel();
                                            }


                                        });
                                        alert.show();

                                    }
                                } catch (Exception e) {
                                    Log.e("Fail 3", e.toString());

                                }

                                mProgressDialog.dismiss();


                            }
                        }
                        new Des().execute();


                    }//end of else
                }

            }
        });


        t = (AutoCompleteTextView) findViewById(R.id.ct);
        t1 = (MultiAutoCompleteTextView) findViewById(R.id.ct1);
        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, country);

        t.setAdapter(adapter);
        t1.setThreshold(1);

        t.setAdapter(adapter);
        t1.setTokenizer(new MultiAutoCompleteTextView.CommaTokenizer());

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        // ATTENTION: This was auto-generated to implement the App Indexing API.
        // See https://g.co/AppIndexing/AndroidStudio for more information.

    }

    @SuppressWarnings("deprecation")
    public void setDate(View view) {
        showDialog(999);
        Toast.makeText(getApplicationContext(), "ca", Toast.LENGTH_SHORT)
                .show();
    }

    @Override
    protected Dialog onCreateDialog(int id) {
        // TODO Auto-generated method stub
        if (id == 999) {
            return new DatePickerDialog(this, myDateListener, year, month, day);
        }
        return null;
    }

    private DatePickerDialog.OnDateSetListener myDateListener = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker arg0, int arg1, int arg2, int arg3) {
            // TODO Auto-generated method stub
            // arg1 = year
            // arg2 = month
            // arg3 = day
            showDate(arg1, arg2+1, arg3);
        }
    };

    private void showDate(int year, int month, int day) {
        dateView.setText(new StringBuilder().append(day).append("/")
                .append(month).append("/").append(year));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }
}

