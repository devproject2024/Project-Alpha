package com.zhihu.matisse.internal.entity;

import android.content.Context;
import android.widget.Toast;
import androidx.fragment.app.FragmentActivity;
import com.zhihu.matisse.internal.ui.widget.c;

public final class b {

    /* renamed from: a  reason: collision with root package name */
    private int f45775a;

    /* renamed from: b  reason: collision with root package name */
    private String f45776b;

    /* renamed from: c  reason: collision with root package name */
    private String f45777c;

    public b(String str) {
        this.f45775a = 0;
        this.f45777c = str;
    }

    public b(String str, byte b2) {
        this.f45775a = 0;
        this.f45775a = 1;
        this.f45777c = str;
    }

    public static void a(Context context, b bVar) {
        if (bVar != null) {
            int i2 = bVar.f45775a;
            if (i2 == 1) {
                c.a(bVar.f45776b, bVar.f45777c).show(((FragmentActivity) context).getSupportFragmentManager(), c.class.getName());
            } else if (i2 != 2) {
                Toast.makeText(context, bVar.f45777c, 0).show();
            }
        }
    }
}
