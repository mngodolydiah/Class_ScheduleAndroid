package mng.r.lydia.class_schedule;

import android.app.Activity;
import android.content.Context;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;


public class GalleryViewAdapter extends ArrayAdapter<Timetable> {

private Context mContext;
private int layoutResourceId;
private ArrayList<Timetable> mGridData = new ArrayList<Timetable>();
        MyDBHandler db;


public GalleryViewAdapter(Context mContext, int layoutResourceId, ArrayList<Timetable> mGridData) {
        super(mContext, layoutResourceId, mGridData);
        this.layoutResourceId = layoutResourceId;
        this.mContext = mContext;
        this.mGridData = mGridData;
        db=new MyDBHandler(mContext);
        }


/**
 * Updates grid data and refresh grid items.
 * @param mGridData
 */
public void setGridData(ArrayList<Timetable> mGridData) {
        this.mGridData = mGridData;
        notifyDataSetChanged();
        }
        static class ViewHolder {
                TextView txt1, txt2, txt3, txt4 , txt5;
                ImageView imageView;
        }
@Override
public View getView(int position, View convertView, ViewGroup parent) {
        View row = convertView;
        ViewHolder holder;

        if (row == null) {
        LayoutInflater inflater = ((Activity) mContext).getLayoutInflater();
        row = inflater.inflate(layoutResourceId, parent, false);
        holder = new ViewHolder();
        holder.txt1 = (TextView) row.findViewById(R.id.code);
                holder.txt5=(TextView)row.findViewById(R.id.day);
                holder.txt2=(TextView) row.findViewById(R.id.venue);
                holder.txt3 = (TextView) row.findViewById(R.id.time);
                holder.txt4 = (TextView) row.findViewById(R.id.lec);
        row.setTag(holder);
        } else
        holder = (ViewHolder) row.getTag();


        Timetable item = mGridData.get(position);

        holder.txt1.setText("ACS101");
        holder.txt5.setText("MONDAY");
                holder.txt3.setText("23/56");
                        holder.txt2.setText("5");
                                holder.txt4.setText("BCC");


       // Picasso.with(mContext).load("http://www.crimplinkenterprises.com/churchapp/profilepics/" + item.getImage().toString()+".jpg").into(holder.imageView);
        return row;
        }


}