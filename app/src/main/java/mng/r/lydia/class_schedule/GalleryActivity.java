package mng.r.lydia.class_schedule;

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


public class GalleryActivity extends AppCompatActivity{
    private static final String TAG = GalleryActivity.class.getSimpleName();
    private GridView mGridView;
    String units_r[],daye_r[], datee_r[], timee_r[],venue_r[];
    private GalleryViewAdapter mGridAdapter;
    private ArrayList<Timetable> data;
    MyDBHandler db = new MyDBHandler(this);



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_class);

        ArrayList<String> units = new ArrayList<String>();
        ArrayList<String> daye = new ArrayList<String>();
        ArrayList<String> datee = new ArrayList<String>();
        ArrayList<String> timee = new ArrayList<String>();
        ArrayList<String> venuee = new ArrayList<String>();
        Toast.makeText(getApplicationContext(),"number of records"+db.getCount(),Toast.LENGTH_SHORT).show();
        units.addAll(db.getCourse());
        units_r =units.toArray(new String[db.getCount()]);
        daye.addAll(db.getDay());
        daye_r =units.toArray(new String[db.getCount()]);
        datee.addAll(db.getDate());
        datee_r=datee.toArray(new String[db.getCount()]);
        timee.addAll(db.getTime());
        timee_r=timee.toArray(new String[db.getCount()]);
        venuee.addAll(db.getVenue());
        venue_r=venuee.toArray(new String[db.getCount()]);
        data = new ArrayList<Timetable>();


        for(int i=0;i<db.getCount(); i++) {
            Timetable item = new Timetable(units_r[i],daye_r[i],datee_r[i],timee_r[i], venue_r[i]);// using the array values to add to listView
            data.add(item);
        }

        Cursor a=db.Alldata();
        mGridView = (GridView) findViewById(R.id.grid);
       // mGridAdapter = new GalleryViewAdapter(this, R.layout.gridcube, data);
        String from[]=new String[]{db.UNIT, db.VENUE, db.TIME, db.DAY, db.DATE};
        int[] to =new int[]{R.id.code,R.id.venue,R.id.time,R.id.day, R.id.lec};
        SimpleCursorAdapter data=new SimpleCursorAdapter(this,R.layout.gridcube,a,from,to);
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
                                    db.deleteAllCourses();
                                }
                            });
                    builder.create();
                        builder.show();
                }
                catch (Exception d )
                {}
                break;
            case R.id.action_newclass:
                Intent toclas= new Intent(GalleryActivity.this,AddActivity.class);
                startActivity(toclas);
                break;

            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }





}