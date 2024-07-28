package com.alipay.mobile.nebulacore.dev.bugme;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class H5BugMeListView extends ListView {
    private H5BugMeListViewAdapter mAdapter = new H5BugMeListViewAdapter();
    /* access modifiers changed from: private */
    public H5BugmeConsole mConsole;
    /* access modifiers changed from: private */
    public Context mContext;
    /* access modifiers changed from: private */
    public int mIndex;

    public H5BugMeListView(Context context, H5BugmeConsole h5BugmeConsole, int i2) {
        super(context);
        this.mContext = context;
        this.mConsole = h5BugmeConsole;
        this.mIndex = i2;
        setAdapter(this.mAdapter);
    }

    public void refresh() {
        this.mAdapter.notifyDataSetChanged();
    }

    class H5BugMeListViewAdapter extends BaseAdapter {
        public long getItemId(int i2) {
            return 0;
        }

        H5BugMeListViewAdapter() {
        }

        public int getCount() {
            return H5BugMeListView.this.mConsole.getLogDataList(H5BugMeListView.this.mIndex).size();
        }

        public Object getItem(int i2) {
            return H5BugMeListView.this.mConsole.getLogDataList(H5BugMeListView.this.mIndex).get(i2);
        }

        public View getView(int i2, View view, ViewGroup viewGroup) {
            TextView textView;
            if (view == null) {
                textView = new TextView(H5BugMeListView.this.mContext);
            } else {
                textView = (TextView) view;
            }
            textView.setTextIsSelectable(true);
            textView.setText(H5BugMeListView.this.mConsole.getLogDataList(H5BugMeListView.this.mIndex).get(i2).getContent());
            textView.setLayoutParams(new AbsListView.LayoutParams(-1, -2));
            textView.setPadding(50, 50, 50, 50);
            return textView;
        }
    }
}
