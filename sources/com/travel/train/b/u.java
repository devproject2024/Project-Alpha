package com.travel.train.b;

import android.content.Context;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.j;
import androidx.fragment.app.o;
import com.travel.train.R;
import com.travel.train.fragment.g;
import kotlin.g.b.k;

public final class u extends o {

    /* renamed from: a  reason: collision with root package name */
    private final String[] f26565a = {this.f26566b.getResources().getString(R.string.train_by_station_title), this.f26566b.getResources().getString(R.string.search_by_train_title)};

    /* renamed from: b  reason: collision with root package name */
    private Context f26566b;

    /* renamed from: c  reason: collision with root package name */
    private Bundle f26567c;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public u(Context context, Bundle bundle, j jVar) {
        super(jVar);
        k.c(context, "mContext");
        k.c(jVar, "fm");
        this.f26566b = context;
        this.f26567c = bundle;
    }

    public final CharSequence getPageTitle(int i2) {
        return this.f26565a[i2];
    }

    public final int getCount() {
        return this.f26565a.length;
    }

    public final Fragment getItem(int i2) {
        if (i2 != 0) {
            g.a aVar = g.f26961a;
            Bundle bundle = this.f26567c;
            g gVar = new g();
            gVar.setArguments(bundle);
            return gVar;
        }
        com.travel.train.fragment.o a2 = com.travel.train.fragment.o.a(this.f26567c);
        k.a((Object) a2, "FJRTrainBookingFragment.newInstance(args)");
        return a2;
    }
}
