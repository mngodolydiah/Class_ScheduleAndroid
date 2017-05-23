package mng.r.lydia.class_schedule;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class LoginActivity extends AppCompatActivity {
Button out,add,clases,exms,task;
    TextView showing;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        setTitle("Class Schedule Details");
        out= (Button) findViewById(R.id.button);
        out.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent toout = new Intent(LoginActivity.this, MainActivity.class);
                startActivity(toout);
            }
        });
        add=(Button) findViewById(R.id.button3);
        add.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent toadd = new Intent(LoginActivity.this,AddActivity.class);
                startActivity(toadd);
            }
        });

        clases=(Button) findViewById(R.id.button2);
        clases.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent toclas = new Intent(LoginActivity.this,GalleryActivity.class);
                startActivity(toclas);
            }
        });

        exms=(Button) findViewById(R.id.button5);
        exms.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent toexam = new Intent(LoginActivity.this,Gallery1Activity.class);
                startActivity(toexam);
            }
        });

        task=(Button) findViewById(R.id.button4);
        task.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent totas = new Intent(LoginActivity.this,Gallery2Activity.class);
                startActivity(totas);
            }
        });

        showing = (TextView) findViewById(R.id.display);

        Intent intent = getIntent();
        String str = intent.getStringExtra("location");
        showing.setText(str);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


    }

}
