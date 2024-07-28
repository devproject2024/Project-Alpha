package androidx.core.app;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import androidx.core.g.f;
import java.util.ArrayList;

public final class n {

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public final Intent f2800a = new Intent().setAction("android.intent.action.SEND");

        /* renamed from: b  reason: collision with root package name */
        public CharSequence f2801b;

        /* renamed from: c  reason: collision with root package name */
        public ArrayList<String> f2802c;

        /* renamed from: d  reason: collision with root package name */
        public ArrayList<String> f2803d;

        /* renamed from: e  reason: collision with root package name */
        public ArrayList<String> f2804e;

        /* renamed from: f  reason: collision with root package name */
        public ArrayList<Uri> f2805f;

        /* renamed from: g  reason: collision with root package name */
        private final Context f2806g;

        public a(Context context, ComponentName componentName) {
            this.f2806g = (Context) f.a(context);
            this.f2800a.putExtra("androidx.core.app.EXTRA_CALLING_PACKAGE", context.getPackageName());
            this.f2800a.putExtra("android.support.v4.app.EXTRA_CALLING_PACKAGE", context.getPackageName());
            this.f2800a.putExtra("androidx.core.app.EXTRA_CALLING_ACTIVITY", componentName);
            this.f2800a.putExtra("android.support.v4.app.EXTRA_CALLING_ACTIVITY", componentName);
            this.f2800a.addFlags(524288);
        }

        public final void a(String str, ArrayList<String> arrayList) {
            String[] stringArrayExtra = this.f2800a.getStringArrayExtra(str);
            int length = stringArrayExtra != null ? stringArrayExtra.length : 0;
            String[] strArr = new String[(arrayList.size() + length)];
            arrayList.toArray(strArr);
            if (stringArrayExtra != null) {
                System.arraycopy(stringArrayExtra, 0, strArr, arrayList.size(), length);
            }
            this.f2800a.putExtra(str, strArr);
        }
    }
}
