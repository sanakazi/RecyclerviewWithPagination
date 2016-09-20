package com.example.sanakazi.raybookproject.adapters;


import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.toolbox.ImageLoader;


import com.android.volley.toolbox.NetworkImageView;
import com.example.sanakazi.raybookproject.R;
import com.example.sanakazi.raybookproject.others.MySingleton;
import com.example.sanakazi.raybookproject.pojos.ActivityStreamJson;

import java.util.ArrayList;

/**
 * Created by SanaKazi on 9/9/2016.
 */
public class ActivityStreamAdapter extends RecyclerView.Adapter<ActivityStreamAdapter.ViewHolder> {
    private static final int TYPE_HEADER = 0;  // Declaring Variable to Understand which View is being worked on
    private static final int TYPE_ITEM_1 = 1;
    private static final int TYPE_ITEM_2 = 2;
    public Context context;
    public ArrayList<ActivityStreamJson.DataJson.SortedFeedJson> sortedList;
    public static final String TAG = ActivityStreamAdapter.class.getSimpleName();
    private ImageLoader imageLoader;

    public  ActivityStreamAdapter(Context context, ArrayList<ActivityStreamJson.DataJson.SortedFeedJson> sortedList) {
        this.context=context;
        this.sortedList = sortedList;
    }


    @Override
    public ActivityStreamAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        if (viewType == TYPE_HEADER) {
            View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_stream_fragment_item_header,parent,false);

           ViewHolder vhHeader = new ViewHolder(v,viewType);

           return vhHeader;


        } else if (viewType == TYPE_ITEM_1) {

            View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_stream_fragment_item_1,parent,false);

            ViewHolder vhItem1 = new ViewHolder(v,viewType);
            return vhItem1;


        }
        else if (viewType == TYPE_ITEM_2) {

            View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_stream_fragment_item_2,parent,false);

            ViewHolder vhItem2 = new ViewHolder(v,viewType);
            return vhItem2;


        }
        return null;

    }

    @Override
    public void onBindViewHolder(ActivityStreamAdapter.ViewHolder holder,final int position) {
        imageLoader = MySingleton.getInstance(context).getImageLoader();

        if(holder.Holderid==1)
        {
          //  Log.w(TAG , "POSITION IS " + position + "username is " + sortedList.get(position-1).getUserName().toString());
           holder.txt_3.setText(sortedList.get(position-1).getUserName().toString());

        }
        else if (holder.Holderid==2)
        {
           // Log.w(TAG , "POSITION IS " + position + "username is " + sortedList.get(position-1).getTitle().toString());
            holder.txt_user.setText(sortedList.get(position-1).getTitle().toString());
            holder.imgUser.setImageUrl(sortedList.get(position-1).getFeaturedImageURL(),imageLoader);
         //   holder.imgUser.setImageUrl(sortedList.get(position).getProfileImageURL(), imageLoader);
        }

    }


    @Override
    public int getItemCount() {
        return sortedList.size()+1;
    }

    @Override
    public int getItemViewType(int position) {
        if(position==0)
        {
            return 0;
        }

      //  Log.w(TAG," Test " + sortedList.get(position-1).getType().toString());

        if(sortedList.get(position-1).getType().toString().equals("tweet"))
      {
         return TYPE_ITEM_1;
      }
        else if (sortedList.get(position-1).getType().toString().equals("post"))
        {
            return  TYPE_ITEM_2;
        }

        else return 0;

    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        int Holderid;
        TextView txt_3,txt_user;
        NetworkImageView imgUser;

        public ViewHolder(View itemView, int viewtype)
        {
            super(itemView);
            if(viewtype == TYPE_ITEM_1) {
                txt_3=(TextView)itemView.findViewById(R.id.txt_3);
                Holderid =1;
            }
            else if(viewtype==TYPE_ITEM_2)
            {
                imgUser=(NetworkImageView)itemView.findViewById(R.id.imgUser);
                txt_user=(TextView)itemView.findViewById(R.id.txt_user);
                Holderid=2;
            }
        }

    }

}
