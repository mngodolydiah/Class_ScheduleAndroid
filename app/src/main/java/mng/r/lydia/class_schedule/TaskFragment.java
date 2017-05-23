package mng.r.lydia.class_schedule;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import mng.r.lydia.class_schedule.R;


public class TaskFragment extends Fragment {
    EditText edunt;
    EditText edname;
    EditText edgiv;
    EditText edsub;

    Button tas;
    MyDBHandler db;
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstancesState){
        View view= inflater.inflate(R.layout.fragment_task, container,false);

        edunt=(EditText)view.findViewById(R.id.id);
        edname=(EditText)view.findViewById(R.id.name);
        edgiv=(EditText)view.findViewById(R.id.em);
        edsub=(EditText)view.findViewById(R.id.ps);

        db = new MyDBHandler(getActivity());
        tas = (Button) view.findViewById(R.id.bt4);

                tas.setOnClickListener(new View.OnClickListener() {

                    public void onClick(View v) {
                        //   clasClicked(v);

                        // create a new intent

                        Intent tolist = new Intent(getActivity(), ListActivity.class);

                        // put the name and phone(to be sent to other activity) in intent

                        tolist.putExtra("FRAGMENT", "task");
                        tolist.putExtra("UNT", edunt.getText().toString());

                        tolist.putExtra("NAME", edname.getText().toString());
                        tolist.putExtra("DATE_GIVEN", edgiv.getText().toString());
                        tolist.putExtra("DATE_SUB", edsub.getText().toString());

                        db.addEntry3(edunt.getText().toString(), edname.getText().toString(), edgiv.getText().toString(), edsub.getText().toString());
//db.addEntry(new Show(edunit.getText().toString(), edday.getText().toString(), eddate.getText().toString(), edtime.getText().toString(), edvenue.getText().toString()));
                        // start the second activity

                        startActivity(tolist);
                    }
                });

                return view;
        }
    }



