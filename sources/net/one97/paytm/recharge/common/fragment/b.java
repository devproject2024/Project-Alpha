package net.one97.paytm.recharge.common.fragment;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.paytm.utility.RoboTextView;
import com.squareup.picasso.w;
import java.util.List;
import kotlin.g.b.k;
import kotlin.m.p;
import net.one97.paytm.recharge.R;
import net.one97.paytm.recharge.common.fragment.c;
import net.one97.paytm.recharge.common.utils.ai;
import net.one97.paytm.recharge.common.utils.g;
import net.one97.paytm.recharge.model.v4.CJRRechargeAlertItem;

public final class b extends RecyclerView.a<c.a> {

    /* renamed from: a  reason: collision with root package name */
    v f61134a;

    /* renamed from: b  reason: collision with root package name */
    private final List<CJRRechargeAlertItem> f61135b;

    /* renamed from: c  reason: collision with root package name */
    private final Context f61136c;

    /* renamed from: d  reason: collision with root package name */
    private final boolean f61137d;

    /* renamed from: e  reason: collision with root package name */
    private final String f61138e;

    public static final /* synthetic */ v a(b bVar) {
        v vVar = bVar.f61134a;
        if (vVar == null) {
            k.a("alertBottomSheet");
        }
        return vVar;
    }

    public final /* synthetic */ void onBindViewHolder(RecyclerView.v vVar, int i2) {
        c.a aVar = (c.a) vVar;
        k.c(aVar, "holder");
        RoboTextView roboTextView = aVar.f61150a;
        k.a((Object) roboTextView, "holder.heading");
        roboTextView.setText(this.f61135b.get(i2).getTitle());
        if (g.c(this.f61135b.get(i2).getDescription())) {
            RoboTextView roboTextView2 = aVar.f61151b;
            k.a((Object) roboTextView2, "holder.desc");
            roboTextView2.setText(this.f61135b.get(i2).getDescription());
            RoboTextView roboTextView3 = aVar.f61151b;
            k.a((Object) roboTextView3, "holder.desc");
            roboTextView3.setVisibility(0);
        } else {
            RoboTextView roboTextView4 = aVar.f61151b;
            k.a((Object) roboTextView4, "holder.desc");
            roboTextView4.setVisibility(8);
        }
        if (g.c(this.f61135b.get(i2).getDescription1())) {
            RoboTextView roboTextView5 = aVar.f61152c;
            k.a((Object) roboTextView5, "holder.desc1");
            roboTextView5.setText(this.f61135b.get(i2).getDescription1());
            RelativeLayout relativeLayout = aVar.f61154e;
            k.a((Object) relativeLayout, "holder.descLayoutContainer1");
            relativeLayout.setVisibility(0);
        } else {
            RelativeLayout relativeLayout2 = aVar.f61154e;
            k.a((Object) relativeLayout2, "holder.descLayoutContainer1");
            relativeLayout2.setVisibility(8);
        }
        if (g.c(this.f61135b.get(i2).getDescription2())) {
            RoboTextView roboTextView6 = aVar.f61153d;
            k.a((Object) roboTextView6, "holder.desc2");
            roboTextView6.setText(this.f61135b.get(i2).getDescription2());
            RelativeLayout relativeLayout3 = aVar.f61155f;
            k.a((Object) relativeLayout3, "holder.descLayoutContainer2");
            relativeLayout3.setVisibility(0);
        } else {
            RelativeLayout relativeLayout4 = aVar.f61155f;
            k.a((Object) relativeLayout4, "holder.descLayoutContainer2");
            relativeLayout4.setVisibility(8);
        }
        CJRRechargeAlertItem cJRRechargeAlertItem = this.f61135b.get(i2);
        CharSequence charSequence = this.f61138e;
        boolean z = true;
        if (!(charSequence == null || p.a(charSequence))) {
            Button button = aVar.l;
            k.a((Object) button, "holder.btn_action");
            ai.a(button);
            Button button2 = aVar.l;
            k.a((Object) button2, "holder.btn_action");
            button2.setText(this.f61138e);
            aVar.l.setOnClickListener(new c(this));
        }
        String message = cJRRechargeAlertItem.getMessage();
        if (message != null) {
            RoboTextView roboTextView7 = aVar.j;
            k.a((Object) roboTextView7, "holder.message");
            roboTextView7.setText(message);
        }
        String rightImageUrl = cJRRechargeAlertItem.getRightImageUrl();
        if (rightImageUrl != null) {
            w.a().a(rightImageUrl).a(aVar.f61157h);
            ImageView imageView = aVar.f61157h;
            k.a((Object) imageView, "holder.info_image");
            ai.a(imageView);
        }
        CharSequence buttonLabel = cJRRechargeAlertItem.getButtonLabel();
        if (!(buttonLabel == null || p.a(buttonLabel))) {
            CharSequence buttonUrl = cJRRechargeAlertItem.getButtonUrl();
            if (buttonUrl != null && !p.a(buttonUrl)) {
                z = false;
            }
            if (!z) {
                w.a().a(cJRRechargeAlertItem.getButtonUrl()).a(aVar.k);
                RoboTextView roboTextView8 = aVar.f61156g;
                ai.a(roboTextView8);
                roboTextView8.setText(this.f61135b.get(i2).getButtonLabel());
                roboTextView8.setOnClickListener(new a(roboTextView8, this, i2, aVar));
            }
        }
        if (this.f61137d && i2 == 0) {
            ImageView imageView2 = aVar.f61158i;
            ai.a(imageView2);
            imageView2.setOnClickListener(new C1183b(this));
        }
    }

    public final /* synthetic */ RecyclerView.v onCreateViewHolder(ViewGroup viewGroup, int i2) {
        k.c(viewGroup, "parent");
        View inflate = LayoutInflater.from(this.f61136c).inflate(R.layout.recharge_alert_item, viewGroup, false);
        k.a((Object) inflate, "LayoutInflater.from(cont…lert_item, parent, false)");
        return new c.a(inflate);
    }

    public b(List<CJRRechargeAlertItem> list, Context context, boolean z, String str) {
        k.c(list, "alertItems");
        this.f61135b = list;
        this.f61136c = context;
        this.f61137d = z;
        this.f61138e = str;
    }

    static final class c implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b f61144a;

        c(b bVar) {
            this.f61144a = bVar;
        }

        public final void onClick(View view) {
            b.a(this.f61144a).c();
        }
    }

    static final class a implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ RoboTextView f61139a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ b f61140b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ int f61141c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ c.a f61142d;

        a(RoboTextView roboTextView, b bVar, int i2, c.a aVar) {
            this.f61139a = roboTextView;
            this.f61140b = bVar;
            this.f61141c = i2;
            this.f61142d = aVar;
        }

        public final void onClick(View view) {
            ai.b(this.f61139a);
            ImageView imageView = this.f61142d.k;
            k.a((Object) imageView, "holder.sample_image");
            ai.a(imageView);
        }
    }

    /* renamed from: net.one97.paytm.recharge.common.fragment.b$b  reason: collision with other inner class name */
    static final class C1183b implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ b f61143a;

        C1183b(b bVar) {
            this.f61143a = bVar;
        }

        public final void onClick(View view) {
            b.a(this.f61143a).b();
        }
    }

    public final int getItemCount() {
        return this.f61135b.size();
    }
}
