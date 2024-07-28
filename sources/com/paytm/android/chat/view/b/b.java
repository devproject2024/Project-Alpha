package com.paytm.android.chat.view.b;

import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.paytm.android.chat.R;
import com.paytm.android.chat.bean.p4b.KybData;
import com.paytm.android.chat.e.d;
import com.paytm.android.chat.e.e;
import com.paytm.android.chat.utils.P4BNotificationHelper;
import kotlin.g.b.k;

public final class b extends RecyclerView.v implements e {

    /* renamed from: a  reason: collision with root package name */
    d f42556a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public b(View view, d dVar) {
        super(view);
        k.c(view, "itemView");
        k.c(dVar, "itemClickListener");
        this.f42556a = dVar;
        TextView textView = (TextView) view.findViewById(R.id.tv_total_store_count);
        k.a((Object) textView, "itemView.tv_total_store_count");
        textView.setText("No Stores");
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.channel_list);
        k.a((Object) recyclerView, "itemView.channel_list");
        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext(), 1, false));
    }

    public final void a(Object obj, int i2) {
        if (obj instanceof KybData) {
            View view = this.itemView;
            TextView textView = null;
            TextView textView2 = view != null ? (TextView) view.findViewById(R.id.tv_kyb_name) : null;
            k.a((Object) textView2, "itemView?.tv_kyb_name");
            textView2.setText("");
            KybData kybData = (KybData) obj;
            if (!TextUtils.isEmpty(kybData.getName())) {
                View view2 = this.itemView;
                TextView textView3 = view2 != null ? (TextView) view2.findViewById(R.id.tv_kyb_name) : null;
                k.a((Object) textView3, "itemView?.tv_kyb_name");
                textView3.setText(kybData.getName());
            }
            P4BNotificationHelper p4BNotificationHelper = new P4BNotificationHelper();
            View view3 = this.itemView;
            TextView textView4 = view3 != null ? (TextView) view3.findViewById(R.id.tv_unread_chats) : null;
            k.a((Object) textView4, "itemView?.tv_unread_chats");
            p4BNotificationHelper.setTotalUnreadCount(textView4, kybData);
            if (kybData.getChannels().size() > 1) {
                View view4 = this.itemView;
                if (view4 != null) {
                    textView = (TextView) view4.findViewById(R.id.tv_total_store_count);
                }
                k.a((Object) textView, "itemView?.tv_total_store_count");
                textView.setText(kybData.getChannels().size() + " stores");
            } else {
                View view5 = this.itemView;
                if (view5 != null) {
                    textView = (TextView) view5.findViewById(R.id.tv_total_store_count);
                }
                k.a((Object) textView, "itemView?.tv_total_store_count");
                textView.setText(kybData.getChannels().size() + " store");
            }
            View view6 = this.itemView;
            if (view6 != null) {
                view6.setOnClickListener(new a(this, obj));
            }
        }
    }

    static final class a implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b f42557a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Object f42558b;

        a(b bVar, Object obj) {
            this.f42557a = bVar;
            this.f42558b = obj;
        }

        /* JADX WARNING: type inference failed for: r6v12, types: [android.view.View] */
        /* JADX WARNING: Multi-variable type inference failed */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void onClick(android.view.View r6) {
            /*
                r5 = this;
                com.paytm.android.chat.view.b.b r6 = r5.f42557a
                android.view.View r6 = r6.itemView
                r0 = 0
                if (r6 == 0) goto L_0x0010
                int r1 = com.paytm.android.chat.R.id.channel_list
                android.view.View r6 = r6.findViewById(r1)
                androidx.recyclerview.widget.RecyclerView r6 = (androidx.recyclerview.widget.RecyclerView) r6
                goto L_0x0011
            L_0x0010:
                r6 = r0
            L_0x0011:
                java.lang.String r1 = "itemView?.channel_list"
                kotlin.g.b.k.a((java.lang.Object) r6, (java.lang.String) r1)
                android.view.View r6 = (android.view.View) r6
                java.lang.String r2 = "$this$isVisible"
                kotlin.g.b.k.c(r6, r2)
                int r6 = r6.getVisibility()
                r2 = 0
                if (r6 != 0) goto L_0x0026
                r6 = 1
                goto L_0x0027
            L_0x0026:
                r6 = 0
            L_0x0027:
                java.lang.String r3 = "itemView?.iv_forward_arrow"
                if (r6 == 0) goto L_0x005c
                com.paytm.android.chat.view.b.b r6 = r5.f42557a
                android.view.View r6 = r6.itemView
                if (r6 == 0) goto L_0x003a
                int r2 = com.paytm.android.chat.R.id.channel_list
                android.view.View r6 = r6.findViewById(r2)
                androidx.recyclerview.widget.RecyclerView r6 = (androidx.recyclerview.widget.RecyclerView) r6
                goto L_0x003b
            L_0x003a:
                r6 = r0
            L_0x003b:
                kotlin.g.b.k.a((java.lang.Object) r6, (java.lang.String) r1)
                r2 = 8
                r6.setVisibility(r2)
                com.paytm.android.chat.view.b.b r6 = r5.f42557a
                android.view.View r6 = r6.itemView
                if (r6 == 0) goto L_0x0052
                int r2 = com.paytm.android.chat.R.id.iv_forward_arrow
                android.view.View r6 = r6.findViewById(r2)
                android.widget.ImageView r6 = (android.widget.ImageView) r6
                goto L_0x0053
            L_0x0052:
                r6 = r0
            L_0x0053:
                kotlin.g.b.k.a((java.lang.Object) r6, (java.lang.String) r3)
                r2 = 1127481344(0x43340000, float:180.0)
                r6.setRotation(r2)
                goto L_0x0089
            L_0x005c:
                com.paytm.android.chat.view.b.b r6 = r5.f42557a
                android.view.View r6 = r6.itemView
                if (r6 == 0) goto L_0x006b
                int r4 = com.paytm.android.chat.R.id.channel_list
                android.view.View r6 = r6.findViewById(r4)
                androidx.recyclerview.widget.RecyclerView r6 = (androidx.recyclerview.widget.RecyclerView) r6
                goto L_0x006c
            L_0x006b:
                r6 = r0
            L_0x006c:
                kotlin.g.b.k.a((java.lang.Object) r6, (java.lang.String) r1)
                r6.setVisibility(r2)
                com.paytm.android.chat.view.b.b r6 = r5.f42557a
                android.view.View r6 = r6.itemView
                if (r6 == 0) goto L_0x0081
                int r2 = com.paytm.android.chat.R.id.iv_forward_arrow
                android.view.View r6 = r6.findViewById(r2)
                android.widget.ImageView r6 = (android.widget.ImageView) r6
                goto L_0x0082
            L_0x0081:
                r6 = r0
            L_0x0082:
                kotlin.g.b.k.a((java.lang.Object) r6, (java.lang.String) r3)
                r2 = 0
                r6.setRotation(r2)
            L_0x0089:
                com.paytm.android.chat.view.b.b r6 = r5.f42557a
                android.view.View r6 = r6.itemView
                if (r6 == 0) goto L_0x0098
                int r0 = com.paytm.android.chat.R.id.channel_list
                android.view.View r6 = r6.findViewById(r0)
                r0 = r6
                androidx.recyclerview.widget.RecyclerView r0 = (androidx.recyclerview.widget.RecyclerView) r0
            L_0x0098:
                kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r1)
                com.paytm.android.chat.a.h r6 = new com.paytm.android.chat.a.h
                com.paytm.android.chat.view.b.b r1 = r5.f42557a
                android.view.View r1 = r1.itemView
                java.lang.String r2 = "itemView"
                kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r2)
                android.content.Context r1 = r1.getContext()
                java.lang.String r2 = "itemView.context"
                kotlin.g.b.k.a((java.lang.Object) r1, (java.lang.String) r2)
                java.lang.Object r2 = r5.f42558b
                com.paytm.android.chat.bean.p4b.KybData r2 = (com.paytm.android.chat.bean.p4b.KybData) r2
                java.util.List r2 = r2.getChannels()
                if (r2 == 0) goto L_0x00c8
                java.util.ArrayList r2 = (java.util.ArrayList) r2
                com.paytm.android.chat.view.b.b r3 = r5.f42557a
                com.paytm.android.chat.e.d r3 = r3.f42556a
                r6.<init>(r1, r2, r3)
                androidx.recyclerview.widget.RecyclerView$a r6 = (androidx.recyclerview.widget.RecyclerView.a) r6
                r0.setAdapter(r6)
                return
            L_0x00c8:
                kotlin.u r6 = new kotlin.u
                java.lang.String r0 = "null cannot be cast to non-null type kotlin.collections.ArrayList<kotlin.Any> /* = java.util.ArrayList<kotlin.Any> */"
                r6.<init>(r0)
                throw r6
            */
            throw new UnsupportedOperationException("Method not decompiled: com.paytm.android.chat.view.b.b.a.onClick(android.view.View):void");
        }
    }
}
