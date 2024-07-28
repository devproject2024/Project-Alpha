package net.one97.travelpass.ui.fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.HashMap;
import kotlin.g.b.k;
import net.one97.travelpass.R;

public final class c extends f {

    /* renamed from: a  reason: collision with root package name */
    private RecyclerView f30689a;

    /* renamed from: b  reason: collision with root package name */
    private ArrayList<String> f30690b = new ArrayList<>();

    /* renamed from: c  reason: collision with root package name */
    private ImageView f30691c;

    /* renamed from: d  reason: collision with root package name */
    private TextView f30692d;

    /* renamed from: e  reason: collision with root package name */
    private String f30693e;

    /* renamed from: f  reason: collision with root package name */
    private net.one97.travelpass.ordersummary.e.a f30694f;

    /* renamed from: g  reason: collision with root package name */
    private HashMap f30695g;

    public final void a() {
        HashMap hashMap = this.f30695g;
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
        return layoutInflater.inflate(R.layout.vh_offer_tc_tp, viewGroup, false);
    }

    public final void onAttach(Context context) {
        k.c(context, "context");
        super.onAttach(context);
        com.google.android.play.core.splitcompat.a.b((Context) getActivity());
    }

    static final class a implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ c f30696a;

        a(c cVar) {
            this.f30696a = cVar;
        }

        public final void onClick(View view) {
            this.f30696a.dismiss();
        }
    }

    /* JADX WARNING: type inference failed for: r0v14, types: [android.view.View] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onViewCreated(android.view.View r14, android.os.Bundle r15) {
        /*
            r13 = this;
            java.lang.String r0 = "view"
            kotlin.g.b.k.c(r14, r0)
            android.os.Bundle r0 = r13.getArguments()
            r1 = 0
            if (r0 == 0) goto L_0x0013
            java.lang.String r2 = "dataList"
            java.util.ArrayList r0 = r0.getStringArrayList(r2)
            goto L_0x0014
        L_0x0013:
            r0 = r1
        L_0x0014:
            r13.f30690b = r0
            android.os.Bundle r0 = r13.getArguments()
            if (r0 == 0) goto L_0x0023
            java.lang.String r2 = "headerLabel"
            java.lang.String r0 = r0.getString(r2)
            goto L_0x0024
        L_0x0023:
            r0 = r1
        L_0x0024:
            r13.f30693e = r0
            if (r14 == 0) goto L_0x0031
            int r0 = net.one97.travelpass.R.id.recyclerView
            android.view.View r0 = r14.findViewById(r0)
            androidx.recyclerview.widget.RecyclerView r0 = (androidx.recyclerview.widget.RecyclerView) r0
            goto L_0x0032
        L_0x0031:
            r0 = r1
        L_0x0032:
            r13.f30689a = r0
            if (r14 == 0) goto L_0x003f
            int r0 = net.one97.travelpass.R.id.tv_title_hint
            android.view.View r0 = r14.findViewById(r0)
            android.widget.TextView r0 = (android.widget.TextView) r0
            goto L_0x0040
        L_0x003f:
            r0 = r1
        L_0x0040:
            r13.f30692d = r0
            net.one97.travelpass.a.b r0 = new net.one97.travelpass.a.b
            android.content.Context r2 = r13.getContext()
            java.util.ArrayList<java.lang.String> r3 = r13.f30690b
            if (r3 != 0) goto L_0x004f
            kotlin.g.b.k.a()
        L_0x004f:
            java.util.List r3 = (java.util.List) r3
            net.one97.travelpass.ordersummary.e.a r4 = r13.f30694f
            r0.<init>(r2, r3, r4)
            androidx.recyclerview.widget.LinearLayoutManager r2 = new androidx.recyclerview.widget.LinearLayoutManager
            android.content.Context r3 = r13.getContext()
            r4 = 0
            r5 = 1
            r2.<init>(r3, r5, r4)
            androidx.recyclerview.widget.RecyclerView r3 = r13.f30689a
            if (r3 == 0) goto L_0x006a
            androidx.recyclerview.widget.RecyclerView$LayoutManager r2 = (androidx.recyclerview.widget.RecyclerView.LayoutManager) r2
            r3.setLayoutManager(r2)
        L_0x006a:
            androidx.recyclerview.widget.RecyclerView r2 = r13.f30689a
            if (r2 == 0) goto L_0x0073
            androidx.recyclerview.widget.RecyclerView$a r0 = (androidx.recyclerview.widget.RecyclerView.a) r0
            r2.setAdapter(r0)
        L_0x0073:
            if (r14 == 0) goto L_0x007e
            int r0 = net.one97.travelpass.R.id.close_button
            android.view.View r0 = r14.findViewById(r0)
            r1 = r0
            android.widget.ImageView r1 = (android.widget.ImageView) r1
        L_0x007e:
            if (r1 == 0) goto L_0x00bb
            r13.f30691c = r1
            android.widget.ImageView r6 = r13.f30691c
            r8 = 0
            r9 = 1
            r10 = 0
            r11 = 16
            r12 = 0
            java.lang.String r7 = "close_circle_filled.png"
            com.travel.cdn.ResourceUtils.loadTPassImagesFromCDN$default(r6, r7, r8, r9, r10, r11, r12)
            android.widget.ImageView r0 = r13.f30691c
            if (r0 == 0) goto L_0x009d
            net.one97.travelpass.ui.fragment.c$a r1 = new net.one97.travelpass.ui.fragment.c$a
            r1.<init>(r13)
            android.view.View$OnClickListener r1 = (android.view.View.OnClickListener) r1
            r0.setOnClickListener(r1)
        L_0x009d:
            java.lang.String r0 = r13.f30693e
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            if (r0 == 0) goto L_0x00a9
            int r0 = r0.length()
            if (r0 != 0) goto L_0x00aa
        L_0x00a9:
            r4 = 1
        L_0x00aa:
            if (r4 != 0) goto L_0x00b7
            android.widget.TextView r0 = r13.f30692d
            if (r0 == 0) goto L_0x00b7
            java.lang.String r1 = r13.f30693e
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            r0.setText(r1)
        L_0x00b7:
            super.onViewCreated(r14, r15)
            return
        L_0x00bb:
            kotlin.u r14 = new kotlin.u
            java.lang.String r15 = "null cannot be cast to non-null type android.widget.ImageView"
            r14.<init>(r15)
            throw r14
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.travelpass.ui.fragment.c.onViewCreated(android.view.View, android.os.Bundle):void");
    }
}
