package com.google.zxing.client.android.share;

import android.app.ListActivity;
import android.content.Intent;
import android.os.AsyncTask;
import android.view.View;
import android.widget.ListAdapter;
import android.widget.ListView;
import java.util.List;

public final class AppPickerActivity extends ListActivity {

    /* renamed from: a  reason: collision with root package name */
    private AsyncTask<Object, Object, List<a>> f40272a;

    /* access modifiers changed from: protected */
    public final void onResume() {
        super.onResume();
        this.f40272a = new c(this);
        this.f40272a.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Object[0]);
    }

    /* access modifiers changed from: protected */
    public final void onPause() {
        AsyncTask<Object, Object, List<a>> asyncTask = this.f40272a;
        if (asyncTask != null) {
            asyncTask.cancel(true);
            this.f40272a = null;
        }
        super.onPause();
    }

    /* access modifiers changed from: protected */
    public final void onListItemClick(ListView listView, View view, int i2, long j) {
        ListAdapter listAdapter = getListAdapter();
        if (i2 < 0 || i2 >= listAdapter.getCount()) {
            setResult(0);
        } else {
            String str = ((a) listAdapter.getItem(i2)).f40288a;
            Intent intent = new Intent();
            intent.addFlags(524288);
            intent.putExtra("url", "market://details?id=".concat(String.valueOf(str)));
            setResult(-1, intent);
        }
        finish();
    }
}
