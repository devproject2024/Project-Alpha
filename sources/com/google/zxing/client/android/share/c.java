package com.google.zxing.client.android.share;

import android.app.ListActivity;
import android.content.pm.PackageItemInfo;
import android.content.pm.PackageManager;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import com.google.zxing.client.android.R;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

final class c extends AsyncTask<Object, Object, List<a>> {

    /* renamed from: a  reason: collision with root package name */
    private static final String[] f40293a = {"com.google.android.apps."};

    /* renamed from: b  reason: collision with root package name */
    private static final String[] f40294b = {"com.android.", "android", "com.google.android.", "com.htc"};

    /* renamed from: c  reason: collision with root package name */
    private final ListActivity f40295c;

    /* access modifiers changed from: protected */
    public final /* synthetic */ void onPostExecute(Object obj) {
        final List list = (List) obj;
        this.f40295c.setListAdapter(new ArrayAdapter<a>(this.f40295c, R.layout.app_picker_list_item, R.id.app_picker_list_item_label, list) {
            public final View getView(int i2, View view, ViewGroup viewGroup) {
                View view2 = super.getView(i2, view, viewGroup);
                Drawable drawable = ((a) list.get(i2)).f40289b;
                if (drawable != null) {
                    ((ImageView) view2.findViewById(R.id.app_picker_list_item_icon)).setImageDrawable(drawable);
                }
                return view2;
            }
        });
    }

    c(ListActivity listActivity) {
        this.f40295c = listActivity;
    }

    private static boolean a(String str) {
        if (str == null) {
            return true;
        }
        for (String startsWith : f40293a) {
            if (str.startsWith(startsWith)) {
                return false;
            }
        }
        for (String startsWith2 : f40294b) {
            if (str.startsWith(startsWith2)) {
                return true;
            }
        }
        return false;
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ Object doInBackground(Object[] objArr) {
        ArrayList arrayList = new ArrayList();
        PackageManager packageManager = this.f40295c.getPackageManager();
        for (PackageItemInfo packageItemInfo : packageManager.getInstalledApplications(0)) {
            String str = packageItemInfo.packageName;
            if (!a(str)) {
                CharSequence loadLabel = packageItemInfo.loadLabel(packageManager);
                Drawable loadIcon = packageItemInfo.loadIcon(packageManager);
                if (loadLabel != null) {
                    arrayList.add(new a(str, loadLabel.toString(), loadIcon));
                }
            }
        }
        Collections.sort(arrayList);
        return arrayList;
    }
}
