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
public class TasksFragment extends Fragment{

    private static final String TAG= TasksFragment.class.getSimpleName();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.tasks_fragment, container, false);

        return view;

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

    }
}
