package com.travel.bus.busticket.e;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.travel.bus.busticket.a.w;

public final class n extends RecyclerView.v {

    /* renamed from: a  reason: collision with root package name */
    public Context f22184a;

    /* renamed from: b  reason: collision with root package name */
    public TextView f22185b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f22186c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f22187d;

    /* renamed from: e  reason: collision with root package name */
    public ImageView f22188e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f22189f;

    /* renamed from: g  reason: collision with root package name */
    public ViewGroup f22190g;

    /* renamed from: h  reason: collision with root package name */
    public ViewGroup f22191h;

    /* renamed from: i  reason: collision with root package name */
    public ImageView f22192i;
    public boolean j;
    private w.c k;

    public n(Context context, View view, w.c cVar) {
        super(view);
        this.f22184a = context;
        this.k = cVar;
    }

    public final void a() {
        this.j = !this.j;
    }

    public static String a(String str, int i2) {
        String a2 = a(str);
        if (TextUtils.isEmpty(a2)) {
            a2 = b(str);
        }
        Object[] objArr = new Object[4];
        objArr[0] = i2 > 1 ? " all " : " ";
        objArr[1] = Integer.valueOf(i2);
        objArr[2] = a2;
        objArr[3] = i2 > 1 ? " buses" : " bus";
        return String.format("Show%s%s %s%s", objArr);
    }

    private static String a(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return "";
            }
            int lastIndexOf = str.lastIndexOf(40);
            int lastIndexOf2 = str.lastIndexOf(41);
            return (lastIndexOf < 0 || lastIndexOf2 < 0 || lastIndexOf >= lastIndexOf2) ? "" : str.substring(lastIndexOf + 1, lastIndexOf2);
        } catch (Exception unused) {
            return "";
        }
    }

    private static String b(String str) {
        StringBuilder sb = new StringBuilder();
        for (String str2 : str.split("(\\s)+")) {
            if (str2.charAt(0) != '(') {
                sb.append(str2.charAt(0));
            }
        }
        return sb.toString();
    }
}
