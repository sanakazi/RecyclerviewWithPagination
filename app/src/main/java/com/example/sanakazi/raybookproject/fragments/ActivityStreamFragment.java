package com.example.sanakazi.raybookproject.fragments;


import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.ProgressBar;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.example.sanakazi.raybookproject.R;
import com.example.sanakazi.raybookproject.adapters.ActivityStreamAdapter;
import com.example.sanakazi.raybookproject.others.Constants;
import com.example.sanakazi.raybookproject.others.Webservices;
import com.example.sanakazi.raybookproject.pojos.ActivityStreamJson;
import com.example.sanakazi.raybookproject.utils.EndlessRecyclerViewScrollListener;
import com.google.gson.Gson;
import com.paginate.Paginate;

import java.util.ArrayList;

/**
 * Created by SanaKazi on 9/8/2016.
 */
public class ActivityStreamFragment extends Fragment implements Paginate.Callbacks{
    RecyclerView recycler_view;
    ActivityStreamAdapter adapter;
    ProgressBar progressbar;
    LinearLayoutManager  mLayoutManager;
    ArrayList<ActivityStreamJson.DataJson.SortedFeedJson> sortedList;
    int tweetCount=0;
    int blogCount=0;
    int systemCount=0;
    private Handler handler;
    private Paginate paginate;
    //paginate options
    protected int threshold = 4;
    protected boolean addLoadingRow = true;
    private boolean loading = false;
    private boolean loadingFinished = false;
    protected long networkDelay = 2000;
    private static final String TAG= ActivityStreamFragment.class.getSimpleName();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.activity_stream_fragment, container, false);
        recycler_view=(RecyclerView) view.findViewById(R.id.recycler_view);
        progressbar=(ProgressBar) view.findViewById(R.id.progressbar);
        return view;

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        handler = new Handler();
        sortedList = new ArrayList<>();
        mLayoutManager = new LinearLayoutManager(getActivity());                 // Creating a layout Manager
        recycler_view.setLayoutManager(mLayoutManager);
        setupPagination();

    }
    private void triggerFeedVolleyRequest(String feedUrl){
        Log.w(TAG,feedUrl.toString() ) ;
        Webservices.triggerVolleyGetRequest(getActivity(), feedUrl,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Gson gson = new Gson();
                        ActivityStreamJson streamJson =gson.fromJson (response, ActivityStreamJson.class);
                        blogCount=streamJson.getData().getBlogCount();
                        systemCount=streamJson.getData().getSystemCount();
                        tweetCount=streamJson.getData().getTweetCount();
                        if(streamJson.getData().getSortedFeed()!=null)
                        {
                            sortedList.addAll(streamJson.getData().getSortedFeed());
                            //   Log.w(TAG,sortedList.get(1).getType().toString() ) ;
                        }
                        else
                        { loadingFinished = true;}

                        //  adapter.notifyItemRangeInserted(tweetCount, sortedList.size() - 1);
                        adapter.notifyDataSetChanged();

                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        hideProgressBar();
                    }
                });

    }

    private void hideProgressBar() {
        if(progressbar.getVisibility()==View.VISIBLE){
            progressbar.setVisibility(View.GONE);
        }
    }

    protected void setupPagination()
    {
        // If RecyclerView was recently bound, unbind
        if (paginate != null) {
            paginate.unbind();
        }

      /*  triggerFeedVolleyRequest(Constants.FEED_URL+  "?tweetCount=" + tweetCount + "&blogCount=" + blogCount
                + "&systemCount=" + systemCount);
*/
        adapter= new ActivityStreamAdapter(getActivity(),sortedList);
        recycler_view.setAdapter(adapter);

        paginate = Paginate.with(recycler_view, this)
                .setLoadingTriggerThreshold(threshold)
                .addLoadingListItem(addLoadingRow)
                .build();
    }

    //paginate callbacks

    @Override
    public void onLoadMore() {
        Log.w(TAG,"onLoadMore" ) ;
        loading = true;
        handler.postDelayed(callback, networkDelay);
    }

    @Override
    public boolean isLoading() {
        Log.w(TAG,"isLoading" ) ;
        return loading;
    }

    @Override
    public boolean hasLoadedAllItems() {
        Log.w(TAG,"hasLoadedAllItems" ) ;
        return loadingFinished;
    }

    private Runnable callback = new Runnable() {
        @Override
        public void run() {
            triggerFeedVolleyRequest(Constants.FEED_URL+  "?tweetCount=" + tweetCount + "&blogCount=" + blogCount
                    + "&systemCount=" + systemCount);
            loading = false;
        }
    };
}
