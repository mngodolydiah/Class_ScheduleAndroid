package mng.r.lydia.class_schedule;

import android.app.Activity;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.MultiAutoCompleteTextView;
import android.widget.Toast;

/**
 * Created by user on 3/15/2016.
 */
public class ClassExamFragment extends Fragment {
    EditText edunit;
    EditText edday;
    EditText eddate;
    EditText edtime;
    EditText edvenue;

    EditText edunit1;
    EditText edday1;
    EditText eddate1;
    EditText edtime1;
    EditText edvenue1;


    MyDBHandler db;
    Show s;
    Button clas, exa, tas;
    String unit, day, date, time, venue;

    classExamListener activityCommander;

    public interface classExamListener {
        public void createMeme();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstancesState) {
        View view = inflater.inflate(R.layout.fragment_classexam, container, false);
//db.open();
        edunit = (EditText) view.findViewById(R.id.id);
        edday = (EditText) view.findViewById(R.id.name);
        eddate = (EditText) view.findViewById(R.id.em);
        edtime = (EditText) view.findViewById(R.id.ps);
        edvenue = (EditText) view.findViewById(R.id.db);


        db = new MyDBHandler(getActivity());
        clas = (Button) view.findViewById(R.id.bt2);
        exa = (Button) view.findViewById(R.id.bt3);

        View.OnClickListener listener = new View.OnClickListener() {
            @Override

            public void onClick(View v) {
                //   clasClicked(v);

                // create a new intent
                if (v.equals(clas)) {

                    Intent tolist = new Intent(getActivity(), ListActivity.class);

                    // put the name and phone(to be sent to other activity) in intent
                    tolist.putExtra("FRAGMENT", "class");
                    tolist.putExtra("UNIT", edunit.getText().toString());

                    tolist.putExtra("DAY", edday.getText().toString());
                    tolist.putExtra("DATE", eddate.getText().toString());
                    tolist.putExtra("TIME", edtime.getText().toString());
                    tolist.putExtra("VENUE", edvenue.getText().toString());
                    db.addEntry(edunit.getText().toString(), edday.getText().toString(), eddate.getText().toString(), edtime.getText().toString(), edvenue.getText().toString());
//db.addEntry(new Show(edunit.getText().toString(), edday.getText().toString(), eddate.getText().toString(), edtime.getText().toString(), edvenue.getText().toString()));
                    // start the second activity

                    startActivity(tolist);
                } else {


                    Intent tolist = new Intent(getActivity(), ListActivity.class);

                    // put the name and phone(to be sent to other activity) in intent
                    tolist.putExtra("FRAGMENT", "exam");
                    tolist.putExtra("UNIT", edunit.getText().toString());

                    tolist.putExtra("DAY", edday.getText().toString());
                    tolist.putExtra("DATE", eddate.getText().toString());
                    tolist.putExtra("TIME", edtime.getText().toString());
                    tolist.putExtra("VENUE", edvenue.getText().toString());
                    db.addEntry2(edunit.getText().toString(), edday.getText().toString(), eddate.getText().toString(), edtime.getText().toString(), edvenue.getText().toString());
//db.addEntry(new Show(edunit.getText().toString(), edday.getText().toString(), eddate.getText().toString(), edtime.getText().toString(), edvenue.getText().toString()));
                    // start the second activity

                    startActivity(tolist);
                }


            }


        };
        clas.setOnClickListener(listener);
        exa.setOnClickListener(listener);

        return view;

    }
}

