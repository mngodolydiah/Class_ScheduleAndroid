package mng.r.lydia.class_schedule;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by user on 5/16/2016.
 */
public class GalleryViewAdapter1 extends ArrayAdapter<Timetable1> {

    private Context mContext;
    private int layoutResourceId;
    private ArrayList<Timetable1> mGridData = new ArrayList<Timetable1>();
    MyDBHandler db;


    public GalleryViewAdapter1(Context mContext, int layoutResourceId, ArrayList<Timetable1> mGridData) {
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
    public void setGridData(ArrayList<Timetable1> mGridData) {
        this.mGridData = mGridData;
        notifyDataSetChanged();
    }
    static class ViewHolder {
        TextView txt1, txt2, txt3, txt4 ;
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
            holder.txt4=(TextView)row.findViewById(R.id.name);
            holder.txt2=(TextView) row.findViewById(R.id.dg);
            holder.txt3 = (TextView) row.findViewById(R.id.ds);

            row.setTag(holder);
        } else
            holder = (ViewHolder) row.getTag();


        Timetable1 item1 = mGridData.get(position);

        holder.txt1.setText("ACS101");
        holder.txt4.setText("ACCOUNTING");
        holder.txt3.setText("23/56");
        holder.txt2.setText("5/4");



        // Picasso.with(mContext).load("http://www.crimplinkenterprises.com/churchapp/profilepics/" + item.getImage().toString()+".jpg").into(holder.imageView);
        return row;
    }


}
