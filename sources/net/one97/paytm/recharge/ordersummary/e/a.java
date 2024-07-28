package net.one97.paytm.recharge.ordersummary.e;

import android.content.Context;
import android.content.DialogInterface;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.f;
import androidx.core.h.u;
import androidx.core.widget.i;
import io.reactivex.rxjava3.j.c;
import java.util.List;
import kotlin.g.b.k;
import kotlin.o;
import net.one97.paytm.common.entity.shopping.CJROrderedCart;
import net.one97.paytm.recharge.R;
import net.one97.paytm.recharge.model.CJROSActionResponseV2;
import net.one97.paytm.recharge.ordersummary.c.g;
import net.one97.paytm.recharge.ordersummary.f.b;
import net.one97.paytm.recharge.ordersummary.f.e;
import net.one97.paytm.recharge.ordersummary.f.l;
import net.one97.paytm.recharge.ordersummary.h.c;
import net.one97.paytm.recharge.ordersummary.widget.CJRRechargeItemActionsListView;

public final class a extends c {
    private final String m = "why.processing";

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public a(View view, net.one97.paytm.recharge.ordersummary.b.a aVar, CJROrderedCart cJROrderedCart, CJROSActionResponseV2 cJROSActionResponseV2, boolean z, c<Object[]> cVar, b bVar) {
        super(view, aVar, cJROrderedCart, cJROSActionResponseV2, z, cVar, bVar);
        k.c(view, "itemView");
        k.c(aVar, "viewModel");
        k.c(cJROrderedCart, "orderedItem");
        k.c(cVar, "titleTextObservable");
        k.c(bVar, "actionListener");
    }

    public final void onClick(View view) {
        String str;
        String str2;
        List list;
        Object tag = view != null ? view.getTag() : null;
        if (!(tag instanceof o)) {
            return;
        }
        if (k.a(((o) tag).getFirst(), (Object) this.m)) {
            View view2 = this.itemView;
            k.a((Object) view2, "itemView");
            if (view2.getContext() != null && (this.l instanceof e)) {
                if (c.a.C1269a.MY_PAYMENTS == this.f64280h.b()) {
                    View view3 = this.itemView;
                    k.a((Object) view3, "itemView");
                    str = view3.getContext().getString(R.string.os_help_my_pay_why_processing);
                    View view4 = this.itemView;
                    k.a((Object) view4, "itemView");
                    Context context = view4.getContext();
                    if (context == null) {
                        k.a();
                    }
                    str2 = context.getString(R.string.okay_got_it);
                    String[] strArr = new String[2];
                    View view5 = this.itemView;
                    k.a((Object) view5, "itemView");
                    Context context2 = view5.getContext();
                    if (context2 == null) {
                        k.a();
                    }
                    strArr[0] = context2.getString(R.string.os_help_my_pay_why_processing_message_new_1);
                    View view6 = this.itemView;
                    k.a((Object) view6, "itemView");
                    Context context3 = view6.getContext();
                    if (context3 == null) {
                        k.a();
                    }
                    strArr[1] = context3.getString(R.string.os_help_my_pay_why_processing_message_new_2);
                    list = kotlin.a.k.b((T[]) strArr);
                } else {
                    View view7 = this.itemView;
                    k.a((Object) view7, "itemView");
                    str = view7.getContext().getString(R.string.v8_os_help_cc_why_processing);
                    View view8 = this.itemView;
                    k.a((Object) view8, "itemView");
                    Context context4 = view8.getContext();
                    if (context4 == null) {
                        k.a();
                    }
                    str2 = context4.getString(R.string.okay_got_it);
                    String[] strArr2 = new String[2];
                    View view9 = this.itemView;
                    k.a((Object) view9, "itemView");
                    Context context5 = view9.getContext();
                    if (context5 == null) {
                        k.a();
                    }
                    strArr2[0] = context5.getString(R.string.v8_os_why_processing_message_new_1);
                    View view10 = this.itemView;
                    k.a((Object) view10, "itemView");
                    Context context6 = view10.getContext();
                    if (context6 == null) {
                        k.a();
                    }
                    strArr2[1] = context6.getString(R.string.v8_os_why_processing_message_new_2);
                    list = kotlin.a.k.b((T[]) strArr2);
                }
                g.a aVar = g.f64067a;
                g a2 = g.a.a(str, str2, list);
                a2.f64228c = C1263a.f64257a;
                a2.show(((e) this.l).getSupportFragmentManager(), g.class.getSimpleName());
                return;
            }
            return;
        }
        super.onClick(view);
    }

    /* renamed from: net.one97.paytm.recharge.ordersummary.e.a$a  reason: collision with other inner class name */
    static final class C1263a implements DialogInterface.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        public static final C1263a f64257a = new C1263a();

        C1263a() {
        }

        public final void onClick(DialogInterface dialogInterface, int i2) {
            dialogInterface.dismiss();
        }
    }

    public final void a(int i2) {
        Object[] objArr;
        String str;
        int i3 = i2;
        LinearLayout linearLayout = this.f64278f;
        if (linearLayout != null) {
            linearLayout.removeAllViews();
        }
        if (i3 == 0) {
            if (!k.a((Object) this.f64281i.getItemStatus(), (Object) "6")) {
                this.f64273a.setImageResource(R.drawable.ic_os_status_success_type2);
            } else {
                ImageView imageView = this.f64273a;
                k.a((Object) imageView, "statusLogo");
                imageView.setVisibility(8);
                ImageView imageView2 = this.f64274b;
                k.a((Object) imageView2, "statusPrevious");
                imageView2.setVisibility(0);
                this.f64274b.setImageResource(R.drawable.ic_os_status_previous_type2);
            }
            TextView textView = this.f64275c;
            k.a((Object) textView, "title");
            net.one97.paytm.recharge.ordersummary.b.a aVar = this.f64280h;
            View view = this.itemView;
            k.a((Object) view, "itemView");
            Context context = view.getContext();
            k.a((Object) context, "itemView.context");
            textView.setText(aVar.z(context));
            i.a(this.f64275c, R.style.OSPreviousStatusTitle);
            net.one97.paytm.recharge.ordersummary.b.a aVar2 = this.f64280h;
            View view2 = this.itemView;
            k.a((Object) view2, "itemView");
            Context context2 = view2.getContext();
            k.a((Object) context2, "itemView.context");
            CharSequence B = aVar2.B(context2);
            if (!TextUtils.isEmpty(B)) {
                TextView textView2 = this.f64277e;
                k.a((Object) textView2, "statusTime");
                textView2.setText(B);
                TextView textView3 = this.f64277e;
                k.a((Object) textView3, "statusTime");
                textView3.setVisibility(0);
            }
            if (!(!k.a((Object) this.f64281i.getItemStatus(), (Object) "6")) || !(!k.a((Object) this.f64281i.getItemStatus(), (Object) "7"))) {
                View view3 = this.f64279g;
                f b2 = f.b();
                View view4 = this.itemView;
                k.a((Object) view4, "itemView");
                u.a(view3, b2.a(view4.getContext(), R.drawable.shape_os_success_line));
            } else {
                View view5 = this.f64279g;
                f b3 = f.b();
                View view6 = this.itemView;
                k.a((Object) view6, "itemView");
                u.a(view5, b3.a(view6.getContext(), R.drawable.shape_os_pending_line));
            }
            View view7 = this.f64279g;
            k.a((Object) view7, "separator");
            view7.setVisibility(0);
        } else if (i3 != 4) {
            super.a(i2);
        } else {
            if (c.a.C1269a.MY_PAYMENTS == this.f64280h.b()) {
                net.one97.paytm.recharge.ordersummary.b.a aVar3 = this.f64280h;
                View view8 = this.itemView;
                k.a((Object) view8, "itemView");
                Context context3 = view8.getContext();
                k.a((Object) context3, "itemView.context");
                objArr = new Object[]{aVar3.r(context3), Integer.valueOf(R.color.recharge_order_success)};
            } else {
                net.one97.paytm.recharge.ordersummary.b.a aVar4 = this.f64280h;
                View view9 = this.itemView;
                k.a((Object) view9, "itemView");
                Context context4 = view9.getContext();
                k.a((Object) context4, "itemView.context");
                objArr = new Object[]{aVar4.r(context4), Integer.valueOf(R.color.recharge_order_cancelled)};
            }
            this.k.onNext(objArr);
            this.f64273a.setImageResource(R.drawable.ic_os_status_pending_type3);
            TextView textView4 = this.f64275c;
            k.a((Object) textView4, "title");
            net.one97.paytm.recharge.ordersummary.b.a aVar5 = this.f64280h;
            View view10 = this.itemView;
            k.a((Object) view10, "itemView");
            Context context5 = view10.getContext();
            k.a((Object) context5, "itemView.context");
            textView4.setText(aVar5.u(context5));
            net.one97.paytm.recharge.ordersummary.b.a aVar6 = this.f64280h;
            View view11 = this.itemView;
            k.a((Object) view11, "itemView");
            Context context6 = view11.getContext();
            k.a((Object) context6, "itemView.context");
            CharSequence b4 = aVar6.b(context6, this.f64281i, this.j);
            if (!TextUtils.isEmpty(b4)) {
                TextView textView5 = this.f64276d;
                k.a((Object) textView5, "subtitle");
                textView5.setText(b4);
                TextView textView6 = this.f64276d;
                k.a((Object) textView6, "subtitle");
                textView6.setVisibility(0);
            }
            net.one97.paytm.recharge.ordersummary.b.a aVar7 = this.f64280h;
            View view12 = this.itemView;
            k.a((Object) view12, "itemView");
            Context context7 = view12.getContext();
            k.a((Object) context7, "itemView.context");
            CharSequence i4 = aVar7.i(context7, this.f64281i);
            if (!TextUtils.isEmpty(i4)) {
                TextView textView7 = this.f64277e;
                k.a((Object) textView7, "statusTime");
                textView7.setText(i4);
                TextView textView8 = this.f64277e;
                k.a((Object) textView8, "statusTime");
                textView8.setVisibility(0);
            }
            CJRRechargeItemActionsListView.b bVar = CJRRechargeItemActionsListView.f64530e;
            View view13 = this.itemView;
            k.a((Object) view13, "itemView");
            Context context8 = view13.getContext();
            k.a((Object) context8, "itemView.context");
            CJRRechargeItemActionsListView a2 = CJRRechargeItemActionsListView.b.a(context8, 1, 2, this.f64281i, this.f64280h, this.l, false, false, 192);
            if (a2 != null) {
                LinearLayout linearLayout2 = this.f64278f;
                k.a((Object) linearLayout2, "lytActions");
                linearLayout2.setVisibility(0);
                this.f64278f.addView(a2);
            }
            if (c.a.C1269a.MY_PAYMENTS == this.f64280h.b()) {
                View view14 = this.itemView;
                k.a((Object) view14, "itemView");
                str = view14.getContext().getString(R.string.os_help_my_pay_why_processing);
            } else {
                View view15 = this.itemView;
                k.a((Object) view15, "itemView");
                str = view15.getContext().getString(R.string.v8_os_help_cc_why_processing);
            }
            CJRRechargeItemActionsListView.b bVar2 = CJRRechargeItemActionsListView.f64530e;
            View view16 = this.itemView;
            k.a((Object) view16, "itemView");
            Context context9 = view16.getContext();
            k.a((Object) context9, "itemView.context");
            TextView a3 = CJRRechargeItemActionsListView.b.a(context9, R.style.OSStatusActionTextWhyProcessing, str);
            a3.setTag(new o(this.m, null));
            a3.setOnClickListener(this);
            ViewGroup.LayoutParams layoutParams = a3.getLayoutParams();
            if (layoutParams != null) {
                FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) layoutParams;
                layoutParams2.topMargin = com.paytm.utility.b.c(16);
                a3.setLayoutParams(layoutParams2);
                this.f64278f.addView(a3);
                LinearLayout linearLayout3 = this.f64278f;
                k.a((Object) linearLayout3, "lytActions");
                linearLayout3.setVisibility(0);
                if (this.f64280h.s) {
                    this.l.b((l) null);
                    return;
                }
                return;
            }
            throw new kotlin.u("null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
        }
    }
}
