package com.travel.booking.a;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.j;
import androidx.fragment.app.o;
import com.travel.booking.b.a;
import java.util.List;
import kotlin.g.b.k;
import net.one97.paytm.common.entity.shopping.CJRHomePage;

public final class a extends o {

    /* renamed from: a  reason: collision with root package name */
    public final List<String> f21462a;

    /* renamed from: b  reason: collision with root package name */
    private final int f21463b;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public a(int i2, List<String> list, j jVar) {
        super(jVar);
        k.c(list, CJRHomePage.LAYOUT_HOME_PAGE_TABS);
        k.c(jVar, "fm");
        this.f21463b = i2;
        this.f21462a = list;
    }

    public final Fragment getItem(int i2) {
        a.C0425a aVar = com.travel.booking.b.a.f21468a;
        com.travel.booking.b.a aVar2 = new com.travel.booking.b.a();
        Bundle bundle = new Bundle();
        bundle.putInt("ARG_TRIP_LIST_INDEX", i2);
        aVar2.setArguments(bundle);
        return aVar2;
    }

    public final int getCount() {
        return this.f21463b;
    }
}
