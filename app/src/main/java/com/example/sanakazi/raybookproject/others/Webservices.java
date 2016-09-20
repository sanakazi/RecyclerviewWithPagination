package com.example.sanakazi.raybookproject.others;

import android.content.Context;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

/**
 * Created by SanaKazi on 9/12/2016.
 */
public class Webservices {

    public static void triggerVolleyGetRequest(Context context, String url, Response.Listener responseListener, Response.ErrorListener errorListener ){
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,responseListener ,errorListener);
        stringRequest.setRetryPolicy(new DefaultRetryPolicy(5000,
                2,
                DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));
        MySingleton.getInstance(context).getRequestQueue().add(stringRequest);
    }

}
