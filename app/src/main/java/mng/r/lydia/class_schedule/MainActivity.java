package mng.r.lydia.class_schedule;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

public class MainActivity extends AppCompatActivity {
    Button sign, log;
    EditText input, pass;
    ProgressDialog   mProgressDialog;
    String query, resulta;
    HttpURLConnection con;
    JSONObject json_data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("WELCOME");

        input = (EditText) findViewById(R.id.emd);
        pass = (EditText) findViewById(R.id.pased);

        sign = (Button) findViewById(R.id.sign);
        sign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent tosign = new Intent(MainActivity.this, SigninActivity.class);
                startActivity(tosign);
            }

        });
        log = (Button) findViewById(R.id.login);
        log.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                        {
                            if (input.getText().toString().compareTo("")==0) {
                                final AlertDialog.Builder alert = new AlertDialog.Builder(MainActivity.this);
                                LinearLayout lila1 = new LinearLayout(MainActivity.this);
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
                            }
                            else if (pass.getText().toString().compareTo("")==0) {
                                final AlertDialog.Builder alert = new AlertDialog.Builder(MainActivity.this);
                                LinearLayout lila1 = new LinearLayout(MainActivity.this);
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
                            } else{

                                final class Des extends AsyncTask<Void, Void, Void> {

                                    @Override
                                    protected void onPreExecute() {


                                        super.onPreExecute();

                                        mProgressDialog = new ProgressDialog(MainActivity.this);
                                        mProgressDialog.setMessage("Authenticating user..A moment please");
                                        mProgressDialog.setIndeterminate(false);
                                        mProgressDialog.setCancelable(true);
                                        mProgressDialog.show();
                                        Uri.Builder builder = new Uri.Builder()
                                                .appendQueryParameter("username", input.getText().toString().trim())
                                                .appendQueryParameter("password", pass.getText().toString().trim());
                                        query = builder.build().getEncodedQuery();

                                    }

                                    @Override
                                    protected Void doInBackground(Void... params) {


                                        InputStream is = null;
                                        try {

                                            String url = "http://mngodo.6te.net/login/log.php";
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
                                                Intent tomain = new Intent(MainActivity.this, LoginActivity.class);
                                                startActivity(tomain);
                                                finish();
                                            } else {
                                                final AlertDialog.Builder alert = new AlertDialog.Builder(MainActivity.this);
                                                LinearLayout lila1 = new LinearLayout(MainActivity.this);
                                                lila1.setOrientation(LinearLayout.VERTICAL);
                                                alert.setView(lila1);
                                                alert.setTitle("Login failed!");
                                                alert.setMessage("Check your username and password then retry.\nIf you forgot your password click on forgot password to recover");
                                                alert.setIcon(R.drawable.erro);
                                                Log.e("Fail 3", "Value"+code);
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
    }

}


