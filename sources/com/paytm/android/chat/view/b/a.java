package com.paytm.android.chat.view.b;

import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.paytm.android.chat.R;
import com.paytm.android.chat.bean.p4b.KybChannel;
import com.paytm.android.chat.e.d;
import com.paytm.android.chat.e.e;
import com.paytm.android.chat.utils.P4BNotificationHelper;
import kotlin.g.b.k;

public final class a extends RecyclerView.v implements e {

    /* renamed from: a  reason: collision with root package name */
    d f42552a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public a(View view, d dVar) {
        super(view);
        k.c(view, "itemView");
        k.c(dVar, "itemClickListener");
        this.f42552a = dVar;
    }

    public final void a(Object obj, int i2) {
        if (obj instanceof KybChannel) {
            View view = this.itemView;
            TextView textView = null;
            TextView textView2 = view != null ? (TextView) view.findViewById(R.id.tv_kyb_channel_name) : null;
            k.a((Object) textView2, "itemView?.tv_kyb_channel_name");
            textView2.setText("");
            KybChannel kybChannel = (KybChannel) obj;
            if (!TextUtils.isEmpty(kybChannel.getName())) {
                View view2 = this.itemView;
                TextView textView3 = view2 != null ? (TextView) view2.findViewById(R.id.tv_kyb_channel_name) : null;
                k.a((Object) textView3, "itemView?.tv_kyb_channel_name");
                textView3.setText(kybChannel.getName());
            }
            P4BNotificationHelper p4BNotificationHelper = new P4BNotificationHelper();
            String id = kybChannel.getId();
            View view3 = this.itemView;
            if (view3 != null) {
                textView = (TextView) view3.findViewById(R.id.tv_branch_unread_chats);
            }
            k.a((Object) textView, "itemView?.tv_branch_unread_chats");
            p4BNotificationHelper.setUnreadCountBadgePerStore(id, textView);
            this.itemView.setOnClickListener(new C0706a(this, obj, i2));
        }
    }

    /* renamed from: com.paytm.android.chat.view.b.a$a  reason: collision with other inner class name */
    static final class C0706a implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f42553a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Object f42554b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ int f42555c;

        C0706a(a aVar, Object obj, int i2) {
            this.f42553a = aVar;
            this.f42554b = obj;
            this.f42555c = i2;
        }

        public final void onClick(View view) {
            this.f42553a.f42552a.a(this.f42554b);
        }
    }
}
