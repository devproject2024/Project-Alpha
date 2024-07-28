package com.google.zxing.client.android.book;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import com.google.zxing.client.android.R;
import java.util.List;

final class b extends ArrayAdapter<c> {
    b(Context context, List<c> list) {
        super(context, R.layout.search_book_contents_list_item, 0, list);
    }

    public final View getView(int i2, View view, ViewGroup viewGroup) {
        SearchBookContentsListItem searchBookContentsListItem;
        SearchBookContentsListItem searchBookContentsListItem2;
        if (view == null) {
            searchBookContentsListItem2 = (SearchBookContentsListItem) LayoutInflater.from(getContext()).inflate(R.layout.search_book_contents_list_item, viewGroup, false);
        } else {
            boolean z = view instanceof SearchBookContentsListItem;
            searchBookContentsListItem = view;
            if (z) {
                searchBookContentsListItem2 = (SearchBookContentsListItem) view;
            }
            return searchBookContentsListItem;
        }
        searchBookContentsListItem2.set((c) getItem(i2));
        searchBookContentsListItem = searchBookContentsListItem2;
        return searchBookContentsListItem;
    }
}
