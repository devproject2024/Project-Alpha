package com.paytmmall.clpartifact.utils;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Build;
import android.text.TextUtils;
import com.android.volley.VolleyError;
import com.google.gson.o;
import com.paytmmall.clpartifact.common.CLPArtifact;
import com.paytmmall.clpartifact.network.CLPNetworkService;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.Map;

public class CLPCacheUtils {
    private static String childPath = "map";
    private static String fileName = "data";
    private static CLPCacheUtils mInstance;
    /* access modifiers changed from: private */
    public Map<String, String> mCacheMap;

    public static CLPCacheUtils getInstance() {
        if (mInstance == null) {
            mInstance = new CLPCacheUtils();
        }
        return mInstance;
    }

    public void saveCacheMap(Context context, Map<String, String> map) {
        try {
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(new File(context.getDir(fileName, 0), childPath)));
            objectOutputStream.writeObject(map);
            objectOutputStream.flush();
            objectOutputStream.close();
        } catch (IOException e2) {
            e2.printStackTrace();
        }
    }

    public void loadFromCache(String str, CLPNetworkService.IResponseListener iResponseListener) {
        Map<String, String> map;
        String updatedUrl = UrlUtils.getUpdatedUrl(UrlUtils.getUpdatedUrl(UrlUtils.getUpdatedUrl(str, "networkType", ""), "lat", ""), "long", "");
        if (this.mCacheMap == null) {
            init(CLPArtifact.getInstance().getContext());
        }
        if (TextUtils.isEmpty(updatedUrl) || (map = this.mCacheMap) == null || !map.containsKey(updatedUrl)) {
            iResponseListener.onError(new VolleyError("No cache found"));
        } else {
            iResponseListener.onSuccess(this.mCacheMap.get(updatedUrl), (o) null);
        }
    }

    public void saveResponseInCache(final String str, final String str2) {
        new AsyncTask<Void, Void, Void>() {
            /* access modifiers changed from: protected */
            public Void doInBackground(Void... voidArr) {
                String updatedUrl = UrlUtils.getUpdatedUrl(UrlUtils.getUpdatedUrl(UrlUtils.getUpdatedUrl(str, "networkType", ""), "lat", ""), "long", "");
                Context context = CLPArtifact.getInstance().getContext();
                if (CLPCacheUtils.this.mCacheMap == null) {
                    CLPCacheUtils.this.init(context);
                }
                CLPCacheUtils.this.mCacheMap.put(updatedUrl, str2);
                CLPCacheUtils cLPCacheUtils = CLPCacheUtils.this;
                cLPCacheUtils.saveCacheMap(context, cLPCacheUtils.mCacheMap);
                return null;
            }
        }.execute(new Void[0]);
    }

    public void init(Context context) {
        if (Build.VERSION.SDK_INT >= 21) {
            AsyncTask.THREAD_POOL_EXECUTOR.execute(new Runnable(context) {
                private final /* synthetic */ Context f$1;

                {
                    this.f$1 = r2;
                }

                public final void run() {
                    CLPCacheUtils.this.lambda$init$0$CLPCacheUtils(this.f$1);
                }
            });
        } else {
            this.mCacheMap = new HashMap();
        }
    }

    public /* synthetic */ void lambda$init$0$CLPCacheUtils(Context context) {
        this.mCacheMap = SFFileUtils.Companion.readFile(context.getApplicationContext(), fileName, childPath);
    }
}
