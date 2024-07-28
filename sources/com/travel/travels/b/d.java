package com.travel.travels.b;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.recyclerview.widget.RecyclerView;
import com.travel.R;
import java.util.ArrayList;
import java.util.HashMap;
import kotlin.g.b.k;

public final class d extends c {

    /* renamed from: a  reason: collision with root package name */
    private RecyclerView f28484a;

    /* renamed from: b  reason: collision with root package name */
    private ArrayList<String> f28485b = new ArrayList<>();

    /* renamed from: c  reason: collision with root package name */
    private ImageView f28486c;

    /* renamed from: d  reason: collision with root package name */
    private HashMap f28487d;

    public final void a() {
        HashMap hashMap = this.f28487d;
        if (hashMap != null) {
            hashMap.clear();
        }
    }

    public final /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        a();
    }

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        k.c(layoutInflater, "inflater");
        return layoutInflater.inflate(R.layout.vh_offer_tc, viewGroup, false);
    }

    static final class a implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ d f28488a;

        a(d dVar) {
            this.f28488a = dVar;
        }

        public final void onClick(View view) {
            this.f28488a.dismiss();
        }
    }

    /* JADX WARNING: type inference failed for: r0v8, types: [android.view.View] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onViewCreated(android.view.View r7, android.os.Bundle r8) {
        /*
            r6 = this;
            java.lang.String r0 = "view"
            kotlin.g.b.k.c(r7, r0)
            android.os.Bundle r0 = r6.getArguments()
            r1 = 0
            if (r0 == 0) goto L_0x0014
            java.lang.String r2 = "offersTnC"
            java.util.ArrayList r0 = r0.getStringArrayList(r2)
            goto L_0x0015
        L_0x0014:
            r0 = r1
        L_0x0015:
            r6.f28485b = r0
            if (r7 == 0) goto L_0x0022
            int r0 = com.travel.R.id.recyclerView
            android.view.View r0 = r7.findViewById(r0)
            androidx.recyclerview.widget.RecyclerView r0 = (androidx.recyclerview.widget.RecyclerView) r0
            goto L_0x0023
        L_0x0022:
            r0 = r1
        L_0x0023:
            r6.f28484a = r0
            com.travel.travels.a.c r0 = new com.travel.travels.a.c
            android.content.Context r2 = r6.getContext()
            java.util.ArrayList<java.lang.String> r3 = r6.f28485b
            if (r3 != 0) goto L_0x0032
            kotlin.g.b.k.a()
        L_0x0032:
            java.util.List r3 = (java.util.List) r3
            r0.<init>(r2, r3)
            androidx.recyclerview.widget.LinearLayoutManager r2 = new androidx.recyclerview.widget.LinearLayoutManager
            android.content.Context r3 = r6.getContext()
            r4 = 0
            r5 = 1
            r2.<init>(r3, r5, r4)
            androidx.recyclerview.widget.RecyclerView r3 = r6.f28484a
            if (r3 == 0) goto L_0x004b
            androidx.recyclerview.widget.RecyclerView$LayoutManager r2 = (androidx.recyclerview.widget.RecyclerView.LayoutManager) r2
            r3.setLayoutManager(r2)
        L_0x004b:
            androidx.recyclerview.widget.RecyclerView r2 = r6.f28484a
            if (r2 == 0) goto L_0x0054
            androidx.recyclerview.widget.RecyclerView$a r0 = (androidx.recyclerview.widget.RecyclerView.a) r0
            r2.setAdapter(r0)
        L_0x0054:
            if (r7 == 0) goto L_0x005f
            int r0 = com.travel.R.id.close_button
            android.view.View r0 = r7.findViewById(r0)
            r1 = r0
            android.widget.ImageView r1 = (android.widget.ImageView) r1
        L_0x005f:
            if (r1 == 0) goto L_0x007e
            r6.f28486c = r1
            android.widget.ImageView r0 = r6.f28486c
            com.travel.utils.n$a r1 = com.travel.utils.n.a.V1
            java.lang.String r2 = "close_circle_filled.png"
            com.travel.cdn.ResourceUtils.loadTCoreImagesFromCDN(r0, r2, r4, r5, r1)
            android.widget.ImageView r0 = r6.f28486c
            if (r0 == 0) goto L_0x007a
            com.travel.travels.b.d$a r1 = new com.travel.travels.b.d$a
            r1.<init>(r6)
            android.view.View$OnClickListener r1 = (android.view.View.OnClickListener) r1
            r0.setOnClickListener(r1)
        L_0x007a:
            super.onViewCreated(r7, r8)
            return
        L_0x007e:
            kotlin.u r7 = new kotlin.u
            java.lang.String r8 = "null cannot be cast to non-null type android.widget.ImageView"
            r7.<init>(r8)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.travel.travels.b.d.onViewCreated(android.view.View, android.os.Bundle):void");
    }
}
