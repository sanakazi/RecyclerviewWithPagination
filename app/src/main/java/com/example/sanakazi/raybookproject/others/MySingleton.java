package com.example.sanakazi.raybookproject.others;

import android.content.Context;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.Volley;
import com.example.sanakazi.raybookproject.utils.LruBitmapCache;

/**
 * Created by SanaKazi on 9/8/2016.
 */
public class MySingleton {
    private static MySingleton mInstance;
    private static Context mContext;
    private RequestQueue mRequestQueue;
    private ImageLoader mImageLoader;

    private MySingleton(Context mContext) {
        this.mContext = mContext;
        mRequestQueue = getRequestQueue();
        mImageLoader = new ImageLoader(mRequestQueue,new LruBitmapCache(LruBitmapCache.getCacheSize(mContext)));
    }

    public static synchronized MySingleton getInstance(Context context) {
        if (mInstance == null) {
            mInstance = new MySingleton(context);
        }
        return mInstance;
    }

    public RequestQueue getRequestQueue() {
        if (mRequestQueue == null) {
            // getApplicationContext() is key, it keeps you from leaking the
            // Activity or BroadcastReceiver if someone passes one in.
            mRequestQueue = Volley.newRequestQueue(mContext.getApplicationContext());

        }
        return mRequestQueue;
    }

    public ImageLoader getImageLoader() {
        return mImageLoader;
    }
}
