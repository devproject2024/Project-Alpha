package com.google.zxing.client.android.book;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.widget.AdapterView;
import com.google.zxing.client.android.m;
import java.util.List;

final class a implements AdapterView.OnItemClickListener {

    /* renamed from: a  reason: collision with root package name */
    private final SearchBookContentsActivity f40156a;

    /* renamed from: b  reason: collision with root package name */
    private final List<c> f40157b;

    a(SearchBookContentsActivity searchBookContentsActivity, List<c> list) {
        this.f40156a = searchBookContentsActivity;
        this.f40157b = list;
    }

    public final void onItemClick(AdapterView<?> adapterView, View view, int i2, long j) {
        int i3;
        if (i2 > 0 && i2 - 1 < this.f40157b.size()) {
            String str = this.f40157b.get(i3).f40159a;
            String a2 = c.a();
            if (m.a(this.f40156a.f40148a) && !str.isEmpty()) {
                String str2 = this.f40156a.f40148a;
                String substring = str2.substring(str2.indexOf(61) + 1);
                Intent intent = new Intent("android.intent.action.VIEW", Uri.parse("http://books.google." + m.a((Context) this.f40156a) + "/books?id=" + substring + "&pg=" + str + "&vq=" + a2));
                intent.addFlags(524288);
                this.f40156a.startActivity(intent);
            }
        }
    }
}
