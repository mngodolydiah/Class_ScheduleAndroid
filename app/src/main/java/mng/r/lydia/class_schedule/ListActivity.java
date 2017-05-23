package mng.r.lydia.class_schedule;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

public class ListActivity extends AppCompatActivity {
    String unit, day, date, time, venue, uni, da, dat,tim,  venu,unt,name,dgiven,dsub;
    MyDBHandler db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        // extract the unit,day... and venue from intent
        db=new MyDBHandler(this);
        String fragment = getIntent().getStringExtra("FRAGMENT");
        switch (fragment){
            case "task":
                unt=getIntent().getStringExtra("UNT");

                name=getIntent().getStringExtra("NAME");
                dgiven=getIntent().getStringExtra("DATE_GIVEN");
                dsub=getIntent().getStringExtra("DATE_SUB");

                //db.addEntry(unit,date,time,venue);
                TextView tv=new TextView(this);
                // extract the unit,... and venue from intent
                tv.setTextSize(20);


                String str="UNIT: "+unt+"\nNAME: "+name+"\nDATE GIVEN: "+dgiven+"\nDATE OF SUBBMISSION: "+dsub ;

                tv.setText(str);

                setContentView(tv);


                break;
            case "class":
                unit=getIntent().getStringExtra("UNIT");

                day=getIntent().getStringExtra("DAY");
                date=getIntent().getStringExtra("DATE");
                time=getIntent().getStringExtra("TIME");
                venue=getIntent().getStringExtra("VENUE");

                //db.addEntry(unit,date,time,venue);
                TextView tv1=new TextView(this);
                // extract the unit,... and venue from intent
                tv1.setTextSize(20);


                String str1="UNIT : "+unit+"\nDAY: "+day+"\nDATE : "+date+ "\nTIME: "+ time + "\nVENUE: "+venue ;

                tv1.setText(str1);

                setContentView(tv1);



                break;
            case "exam":
                uni=getIntent().getStringExtra("UNIT");

                da=getIntent().getStringExtra("DAY");
                dat=getIntent().getStringExtra("DATE");
                tim=getIntent().getStringExtra("TIME");
                venu=getIntent().getStringExtra("VENUE");

                //db.addEntry(unit,date,time,venue);
                TextView tv2=new TextView(this);
                // extract the unit,... and venue from intent
                tv2.setTextSize(20);


                String str2="UNIT: "+uni+"\nDAY: "+da+"\nDATE: "+dat+"\nTIME: "+tim+"\nVENUE: "+venu ;

                tv2.setText(str2);

                setContentView(tv2);



                break;
        }







    }

}
