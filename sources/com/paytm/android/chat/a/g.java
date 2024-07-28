package com.paytm.android.chat.a;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.paytm.android.chat.ChatManager;
import com.paytm.android.chat.R;
import com.paytm.android.chat.activity.NotificationActivity;
import com.paytm.android.chat.d;
import com.paytm.android.chat.network.response.HomeChips;
import com.paytm.android.chat.utils.ChatAnalyticsHelperKt;
import com.paytm.android.chat.utils.ImageUtils;
import com.sendbird.android.constant.StringSet;
import java.util.List;
import kotlin.g.b.k;
import kotlin.u;

public final class g extends RecyclerView.a<a> {

    /* renamed from: a  reason: collision with root package name */
    List<HomeChips> f41378a;

    public g(List<HomeChips> list) {
        k.c(list, "chips");
        this.f41378a = list;
    }

    public final /* synthetic */ void onBindViewHolder(RecyclerView.v vVar, int i2) {
        a aVar = (a) vVar;
        k.c(aVar, "holder");
        HomeChips homeChips = this.f41378a.get(i2);
        k.c(homeChips, "chip");
        View view = aVar.itemView;
        k.a((Object) view, "itemView");
        TextView textView = (TextView) view.findViewById(R.id.ccci_tv);
        k.a((Object) textView, "itemView.ccci_tv");
        textView.setText(homeChips.getName());
        View view2 = aVar.itemView;
        k.a((Object) view2, "itemView");
        Context context = view2.getContext();
        String image_url = homeChips.getImage_url();
        View view3 = aVar.itemView;
        k.a((Object) view3, "itemView");
        ImageUtils.displayImageFromUrl(context, image_url, (ImageView) view3.findViewById(R.id.ccci_icon));
        if (homeChips.getShowDot()) {
            View view4 = aVar.itemView;
            k.a((Object) view4, "itemView");
            ImageView imageView = (ImageView) view4.findViewById(R.id.ccci_nd);
            if (imageView != null) {
                imageView.setVisibility(0);
            }
        } else {
            View view5 = aVar.itemView;
            k.a((Object) view5, "itemView");
            ImageView imageView2 = (ImageView) view5.findViewById(R.id.ccci_nd);
            if (imageView2 != null) {
                imageView2.setVisibility(8);
            }
        }
        View view6 = aVar.itemView;
        k.a((Object) view6, "itemView");
        ConstraintLayout constraintLayout = (ConstraintLayout) view6.findViewById(R.id.cl_chip);
        if (constraintLayout != null) {
            constraintLayout.setOnClickListener(new a.C0691a(aVar, homeChips, i2));
        }
    }

    public final /* synthetic */ RecyclerView.v onCreateViewHolder(ViewGroup viewGroup, int i2) {
        k.c(viewGroup, "parent");
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.chat_channel_chips_item, viewGroup, false);
        k.a((Object) inflate, "itemView");
        return new a(inflate);
    }

    public static final class a extends RecyclerView.v {
        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(View view) {
            super(view);
            k.c(view, "itemView");
        }

        /* renamed from: com.paytm.android.chat.a.g$a$a  reason: collision with other inner class name */
        static final class C0691a implements View.OnClickListener {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ a f41379a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ HomeChips f41380b;

            /* renamed from: c  reason: collision with root package name */
            final /* synthetic */ int f41381c;

            C0691a(a aVar, HomeChips homeChips, int i2) {
                this.f41379a = aVar;
                this.f41380b = homeChips;
                this.f41381c = i2;
            }

            public final void onClick(View view) {
                String action = this.f41380b.getAction();
                if (action != null) {
                    String lowerCase = action.toLowerCase();
                    k.a((Object) lowerCase, "(this as java.lang.String).toLowerCase()");
                    if (lowerCase.equals(StringSet.filter)) {
                        View view2 = this.f41379a.itemView;
                        k.a((Object) view2, "itemView");
                        Intent intent = new Intent(view2.getContext(), NotificationActivity.class);
                        Bundle bundle = new Bundle();
                        bundle.putString("title", this.f41380b.getName());
                        bundle.putStringArrayList("filters", this.f41380b.getFilter());
                        intent.putExtras(bundle);
                        View view3 = this.f41379a.itemView;
                        k.a((Object) view3, "itemView");
                        view3.getContext().startActivity(intent);
                    } else {
                        ChatManager b2 = ChatManager.b();
                        k.a((Object) b2, "ChatManager.getInstance()");
                        d g2 = b2.g();
                        View view4 = this.f41379a.itemView;
                        k.a((Object) view4, "itemView");
                        g2.a(view4.getContext(), this.f41380b.getUrl());
                    }
                    View view5 = this.f41379a.itemView;
                    k.a((Object) view5, "itemView");
                    Context context = view5.getContext();
                    k.a((Object) context, "itemView.context");
                    ChatAnalyticsHelperKt.fireTabClickEvent(context, this.f41380b, this.f41381c + 1);
                    return;
                }
                throw new u("null cannot be cast to non-null type java.lang.String");
            }
        }
    }

    public final int getItemCount() {
        return this.f41378a.size();
    }
}
