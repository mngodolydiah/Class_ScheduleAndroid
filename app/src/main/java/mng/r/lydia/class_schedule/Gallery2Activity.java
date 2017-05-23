package mng.r.lydia.class_schedule;

/**
 * Created by user on 5/16/2016.
 */

import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.SimpleCursorAdapter;
import android.widget.Toast;


public class Gallery2Activity extends AppCompatActivity{
    private static final String TAG = GalleryActivity.class.getSimpleName();
    private GridView mGridView;
    String units_r[],name_r[], datg_r[], dats_r[];
    private GalleryViewAdapter mGridAdapter;
    private ArrayList<Timetable1> data;
    MyDBHandler db = new MyDBHandler(this);



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_class2);

        ArrayList<String> course = new ArrayList<String>();
        ArrayList<String> namee = new ArrayList<String>();
        ArrayList<String> datgi = new ArrayList<String>();
        ArrayList<String> datsub = new ArrayList<String>();

        Toast.makeText(getApplicationContext(),"number of records"+db.getCount2(),Toast.LENGTH_SHORT).show();
        course.addAll(db.getCourse2());
        units_r =course.toArray(new String[db.getCount2()]);
        namee.addAll(db.getNamee());
        name_r =namee.toArray(new String[db.getCount2()]);
        datgi.addAll(db.getDate2());
        datg_r=datgi.toArray(new String[db.getCount2()]);
        datsub.addAll(db.getDate3());
        dats_r=datsub.toArray(new String[db.getCount2()]);

        data = new ArrayList<Timetable1>();


        for(int i=0;i<db.getCount2(); i++) {
            Timetable1 item1 = new Timetable1(units_r[i],name_r[i],datg_r[i],dats_r[i]);// using the array values to add to listView
            data.add(item1);
        }

        Cursor a=db.Alldata2();
        mGridView = (GridView) findViewById(R.id.grid);
        // mGridAdapter = new GalleryViewAdapter(this, R.layout.gridcube, data);
        String from[]=new String[]{db.UNT, db.NAME, db.DATE_GIVEN, db.DATE_SUB};
        int[] to =new int[]{R.id.code,R.id.name,R.id.dg,R.id.ds};
        SimpleCursorAdapter data=new SimpleCursorAdapter(this,R.layout.gridcube1,a,from,to);
        mGridView.setAdapter(data);

        //Start download

        mGridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v, int position, long id) {}
        });
    }
    @Override public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public  boolean onOptionsItemSelected(MenuItem item){
        int id=item.getItemId();
        switch(id){
            case R.id.action_delete:
                try{

                    AlertDialog.Builder builder = new AlertDialog.Builder(this);

                    builder.setTitle("Do you want to clear the records?");
                    // Set the action buttons
                    builder .setPositiveButton("no", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int id) {
                            // User clicked OK, so save the mSelectedItems results somewhere
                            // or return them to the component that opened the dialog
                            dialog.dismiss();
                        }
                    })

                            .setNegativeButton("yes", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int id) {
                                    db.deleteAllCourses2();
                                }
                            });
                    builder.create();
                    builder.show();
                }
                catch (Exception d )
                {}
                break;
            case R.id.action_newclass:
                Intent toclas= new Intent(Gallery2Activity.this,AddActivity.class);
                startActivity(toclas);
                break;

            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }





}
