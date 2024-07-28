package com.uninstallationtracking;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.widget.ImageView;
import com.google.firebase.perf.network.FirebasePerfUrlConnection;
import java.io.InputStream;
import java.net.URL;

final class c extends AsyncTask<String, Void, Bitmap> {

    /* renamed from: a  reason: collision with root package name */
    ImageView f45712a;

    /* access modifiers changed from: protected */
    public final /* synthetic */ Object doInBackground(Object... objArr) {
        return a((String[]) objArr);
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ void onPostExecute(Object obj) {
        this.f45712a.setImageBitmap((Bitmap) obj);
    }

    public c(ImageView imageView) {
        this.f45712a = imageView;
    }

    private static Bitmap a(String... strArr) {
        try {
            InputStream openStream = FirebasePerfUrlConnection.openStream(new URL(strArr[0]));
            b.a();
            return BitmapFactory.decodeStream(openStream);
        } catch (Exception unused) {
            return null;
        }
    }
}
