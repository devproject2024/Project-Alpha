package net.one97.paytm.wallet.newdesign.utils;

import android.content.Context;
import android.os.AsyncTask;
import android.text.TextUtils;
import com.google.firebase.perf.network.FirebasePerfUrlConnection;
import com.paytm.utility.q;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import net.one97.paytm.wallet.newdesign.postcard.d;

public class IndependentImageDownloadManager {
    /* access modifiers changed from: private */
    public Context mContext;
    /* access modifiers changed from: private */
    public ImageDownloadListener mlistener;

    public interface ImageDownloadListener {
        void onDownloadFinished();
    }

    public IndependentImageDownloadManager(Context context) {
        this.mContext = context;
    }

    public void download(String str, ImageDownloadListener imageDownloadListener) {
        this.mlistener = imageDownloadListener;
        new DownloadTask().executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new String[]{str});
    }

    class DownloadTask extends AsyncTask<String, Void, Void> {
        DownloadTask() {
        }

        /* access modifiers changed from: protected */
        public Void doInBackground(String... strArr) {
            String str;
            try {
                String str2 = strArr[0];
                if (TextUtils.isEmpty(str2)) {
                    return null;
                }
                File externalCacheDir = IndependentImageDownloadManager.this.mContext.getExternalCacheDir();
                try {
                    str = str2.substring(str2.lastIndexOf("/"));
                } catch (Exception unused) {
                    str = str2;
                }
                File file = new File(externalCacheDir.toString(), str);
                try {
                    if (!file.exists()) {
                        file.createNewFile();
                        HttpURLConnection httpURLConnection = (HttpURLConnection) ((URLConnection) FirebasePerfUrlConnection.instrument(new URL(str2).openConnection()));
                        httpURLConnection.setConnectTimeout(30000);
                        httpURLConnection.setReadTimeout(30000);
                        httpURLConnection.setInstanceFollowRedirects(true);
                        InputStream inputStream = httpURLConnection.getInputStream();
                        FileOutputStream fileOutputStream = new FileOutputStream(file);
                        d.a(inputStream, (OutputStream) fileOutputStream);
                        fileOutputStream.close();
                        fileOutputStream.flush();
                    }
                } catch (IOException e2) {
                    q.d(String.valueOf(e2));
                }
                return null;
            } catch (Exception e3) {
                q.d(String.valueOf(e3));
            }
        }

        /* access modifiers changed from: protected */
        public void onPostExecute(Void voidR) {
            super.onPostExecute(voidR);
            if (IndependentImageDownloadManager.this.mlistener != null) {
                IndependentImageDownloadManager.this.mlistener.onDownloadFinished();
            }
        }
    }
}
