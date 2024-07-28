package com.paytmmall.clpartifact.utils;

import android.content.Context;
import android.os.Handler;
import com.android.volley.VolleyError;
import com.google.gson.o;
import com.google.gson.q;
import com.paytmmall.clpartifact.network.CLPNetworkService;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Reader;

public class FileUtils {
    public static void readFileFromAsset(final Context context, final String str, final CLPNetworkService.IResponseListener iResponseListener) {
        new Handler().post(new Runnable() {
            public final void run() {
                try {
                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(context.getAssets().open(str)));
                    StringBuffer stringBuffer = new StringBuffer();
                    while (true) {
                        String readLine = bufferedReader.readLine();
                        if (readLine != null) {
                            stringBuffer.append(readLine);
                        } else {
                            iResponseListener.onSuccess(stringBuffer.toString(), new o());
                            return;
                        }
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                    iResponseListener.onError(new VolleyError(e2.getMessage()));
                }
            }
        });
    }

    public static boolean isCacheExists(Context context, String str) {
        return new File(context.getFilesDir(), str).exists();
    }

    public static void readCacheFile(final Context context, final String str, final CLPNetworkService.IResponseListener iResponseListener) {
        new Thread(new Runnable() {
            public final void run() {
                try {
                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(new File(context.getFilesDir(), str))));
                    new q();
                    q.a((Reader) bufferedReader);
                    StringBuffer stringBuffer = new StringBuffer();
                    while (true) {
                        String readLine = bufferedReader.readLine();
                        if (readLine != null) {
                            stringBuffer.append(readLine);
                        } else {
                            iResponseListener.onSuccess(stringBuffer.toString(), new o());
                            return;
                        }
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                    iResponseListener.onError(new VolleyError(e2.getMessage()));
                }
            }
        }).start();
    }

    public static synchronized void writeCacheFile(Context context, String str, String str2) {
        synchronized (FileUtils.class) {
            try {
                new OutputStreamWriter(new FileOutputStream(new File(context.getFilesDir(), str))).write(str2);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }
}
