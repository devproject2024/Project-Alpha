package net.one97.paytm.recharge.ordersummary.d;

import android.content.Context;
import android.graphics.Typeface;
import android.os.Build;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.paytm.utility.t;
import com.squareup.picasso.ah;
import com.squareup.picasso.w;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import kotlin.g.b.k;
import kotlin.u;
import net.one97.paytm.common.entity.shopping.CJROrderedCart;
import net.one97.paytm.recharge.R;
import net.one97.paytm.recharge.common.a.i;
import net.one97.paytm.recharge.common.e.g;
import net.one97.paytm.recharge.common.widget.CJRCircleImageViewV8;
import net.one97.paytm.recharge.model.CJROSActionItemV2;
import net.one97.paytm.recharge.model.CJROSActionResponseV2;
import net.one97.paytm.recharge.ordersummary.b.a;
import net.one97.paytm.recharge.ordersummary.e.d;
import net.one97.paytm.recharge.ordersummary.f.b;
import net.one97.paytm.recharge.ordersummary.f.o;
import net.one97.paytm.recharge.ordersummary.h.c;
import net.one97.paytm.recharge.ordersummary.widget.CJRRechargeItemActionsListView;

public class e extends k implements g<d>, o {

    /* renamed from: d  reason: collision with root package name */
    private ArrayList<kotlin.o<String, String>> f64109d;

    /* renamed from: e  reason: collision with root package name */
    private HashMap f64110e;

    public void a() {
        HashMap hashMap = this.f64110e;
        if (hashMap != null) {
            hashMap.clear();
        }
    }

    public View b(int i2) {
        if (this.f64110e == null) {
            this.f64110e = new HashMap();
        }
        View view = (View) this.f64110e.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View view2 = getView();
        if (view2 == null) {
            return null;
        }
        View findViewById = view2.findViewById(i2);
        this.f64110e.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    public final long c_(int i2) {
        return (long) i2;
    }

    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        a();
    }

    public final /* synthetic */ RecyclerView.v a(ViewGroup viewGroup) {
        b bVar;
        k.c(viewGroup, "parent");
        if (getParentFragment() instanceof b) {
            Fragment parentFragment = getParentFragment();
            if (parentFragment != null) {
                bVar = (b) parentFragment;
            } else {
                throw new u("null cannot be cast to non-null type net.one97.paytm.recharge.ordersummary.listener.IJRFailedPendingActionListener");
            }
        } else {
            bVar = null;
        }
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.voucher_code_recycler_item, viewGroup, false);
        k.a((Object) inflate, "LayoutInflater.from(cont…cler_item, parent, false)");
        return new d(inflate, bVar);
    }

    public final /* synthetic */ void a(RecyclerView.v vVar, int i2) {
        d dVar = (d) vVar;
        k.c(dVar, "holder");
        boolean z = true;
        if (i2 != getItemCount() - 1) {
            z = false;
        }
        ArrayList<kotlin.o<String, String>> arrayList = this.f64109d;
        if (arrayList == null) {
            k.a();
        }
        String str = (String) arrayList.get(i2).getSecond();
        ArrayList<kotlin.o<String, String>> arrayList2 = this.f64109d;
        if (arrayList2 == null) {
            k.a();
        }
        dVar.a(str, (String) arrayList2.get(i2).getFirst(), z);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        k.c(layoutInflater, "inflater");
        return layoutInflater.inflate(R.layout.content_storefront_electricity, viewGroup, false);
    }

    /* access modifiers changed from: protected */
    public void a(View view) {
        SpannableString spannableString;
        boolean z;
        int i2;
        String str;
        FrameLayout frameLayout;
        View view2 = view;
        k.c(view2, "view");
        ImageView imageView = (ImageView) view2.findViewById(R.id.operator_logo);
        TextView textView = (TextView) view2.findViewById(R.id.operator_name);
        TextView textView2 = (TextView) view2.findViewById(R.id.recharge_number);
        TextView textView3 = (TextView) view2.findViewById(R.id.operator_message);
        RecyclerView recyclerView = (RecyclerView) view2.findViewById(R.id.voucher_code_recycler_view);
        k.a((Object) textView, "operatorName");
        a b2 = b();
        Context context = getContext();
        if (context == null) {
            k.a();
        }
        k.a((Object) context, "context!!");
        textView.setText(b2.R(context));
        a b3 = b();
        Context context2 = getContext();
        if (context2 == null) {
            k.a();
        }
        k.a((Object) context2, "context!!");
        CharSequence Q = b3.Q(context2);
        if (!TextUtils.isEmpty(Q)) {
            k.a((Object) textView2, "rechargeNumber");
            textView2.setText(Q);
        } else {
            k.a((Object) textView2, "rechargeNumber");
            textView2.setVisibility(8);
        }
        CJROrderedCart u = b().u();
        if (u == null) {
            k.a();
        }
        CJROSActionResponseV2 cJROSActionResponseV2 = b().m.get(Long.valueOf(u.getId()));
        if (b().k.size() > 1) {
            a b4 = b();
            Context context3 = getContext();
            if (context3 == null) {
                k.a();
            }
            k.a((Object) context3, "context!!");
            spannableString = b4.a(context3, cJROSActionResponseV2);
        } else {
            a b5 = b();
            Context context4 = getContext();
            if (context4 == null) {
                k.a();
            }
            k.a((Object) context4, "context!!");
            spannableString = b5.b(context4, cJROSActionResponseV2);
        }
        CharSequence charSequence = spannableString;
        if (!TextUtils.isEmpty(charSequence)) {
            k.a((Object) textView3, "operatorMessage");
            textView3.setText(charSequence);
            textView3.setVisibility(0);
        }
        a b6 = b();
        Context context5 = getContext();
        if (context5 == null) {
            k.a();
        }
        k.a((Object) context5, "context!!");
        this.f64109d = b6.j(context5);
        ArrayList<kotlin.o<String, String>> arrayList = this.f64109d;
        if (arrayList != null && (!arrayList.isEmpty())) {
            k.a((Object) recyclerView, "meterCodeRecyclerView");
            recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
            recyclerView.setAdapter(new i(this));
            recyclerView.setVisibility(0);
            if (b().k.size() > 1) {
                k.a((Object) textView3, "operatorMessage");
                textView3.setVisibility(8);
            }
        }
        if (getParentFragment() == null || !(getParentFragment() instanceof b)) {
            str = "operatorMessage";
            i2 = 0;
            z = true;
        } else {
            CJRRechargeItemActionsListView.b bVar = CJRRechargeItemActionsListView.f64530e;
            Context context6 = getContext();
            if (context6 == null) {
                k.a();
            }
            k.a((Object) context6, "context!!");
            a b7 = b();
            Fragment parentFragment = getParentFragment();
            if (parentFragment != null) {
                b bVar2 = (b) parentFragment;
                i2 = 0;
                str = "operatorMessage";
                z = true;
                this.f64164c = CJRRechargeItemActionsListView.b.a(context6, 1, 1, u, b7, bVar2, b().k.size() > 1, false, 128);
                if (!(this.f64164c == null || (frameLayout = (FrameLayout) b(R.id.lyt_actions)) == null)) {
                    frameLayout.addView(this.f64164c);
                }
            } else {
                throw new u("null cannot be cast to non-null type net.one97.paytm.recharge.ordersummary.listener.IJRFailedPendingActionListener");
            }
        }
        String c2 = b().c(u);
        if (c.a.C1269a.MY_PAYMENTS == b().u.b()) {
            CharSequence text = textView.getText();
            if (text == null) {
                text = "";
            }
            SpannableString spannableString2 = new SpannableString(text);
            Context context7 = getContext();
            if (context7 == null) {
                k.a();
            }
            spannableString2.setSpan(new ForegroundColorSpan(androidx.core.content.b.c(context7, R.color.color_000000)), i2, spannableString2.length(), 33);
            textView.setTextSize(2, 16.0f);
            textView.setText(spannableString2);
            CharSequence text2 = textView2.getText();
            if (text2 == null) {
                text2 = "";
            }
            SpannableString spannableString3 = new SpannableString(text2);
            Context context8 = getContext();
            if (context8 == null) {
                k.a();
            }
            spannableString3.setSpan(new ForegroundColorSpan(androidx.core.content.b.c(context8, R.color.color_506d85)), i2, spannableString3.length(), 33);
            textView2.setTypeface(Typeface.create("sans-serif", i2));
            textView2.setTextSize(2, 12.0f);
            textView2.setText(spannableString3);
            k.a((Object) textView3, str);
            CharSequence text3 = textView3.getText();
            if (text3 == null) {
                text3 = "";
            }
            SpannableString spannableString4 = new SpannableString(text3);
            Context context9 = getContext();
            if (context9 == null) {
                k.a();
            }
            spannableString4.setSpan(new ForegroundColorSpan(androidx.core.content.b.c(context9, R.color.color_1d2f54)), i2, spannableString4.length(), 33);
            textView3.setTypeface(Typeface.create("sans-serif", i2));
            textView3.setTextSize(2, 12.0f);
            textView3.setText(spannableString4);
            TextView textView4 = (TextView) view2.findViewById(R.id.txt_name_initials);
            View findViewById = view2.findViewById(R.id.layer_bg_name_initials);
            if (!TextUtils.isEmpty(c2)) {
                textView4.setBackgroundColor(androidx.core.content.b.c(view.getContext(), R.color.rc_os_my_payment_name_initial));
                k.a((Object) textView4, "txtNameInitials");
                net.one97.paytm.recharge.widgets.c.d dVar = net.one97.paytm.recharge.widgets.c.d.f64967a;
                textView4.setText(net.one97.paytm.recharge.widgets.c.d.i(c2));
                k.a((Object) imageView, "operatorLogoView");
                imageView.setVisibility(4);
                textView4.setVisibility(i2);
                k.a((Object) findViewById, "txtBg");
                findViewById.setVisibility(i2);
                return;
            }
            textView4.setBackgroundResource(R.drawable.v3_default_logo_contact);
            k.a((Object) imageView, "operatorLogoView");
            imageView.setVisibility(4);
            k.a((Object) textView4, "txtNameInitials");
            textView4.setVisibility(i2);
        } else if (!TextUtils.isEmpty(c2)) {
            try {
                w.a().a(c2).a((ah) new t.b((int) getResources().getDimension(R.dimen.dimen_34dp), i2, z)).a(R.color.color_ffffff).a(imageView);
            } catch (Exception unused) {
            }
        }
    }

    public int getItemCount() {
        ArrayList<kotlin.o<String, String>> arrayList = this.f64109d;
        if (arrayList != null) {
            return arrayList.size();
        }
        return 0;
    }

    public Map<String, View> getSharedElementMap() {
        HashMap hashMap = new HashMap(1);
        if (((CJRCircleImageViewV8) b(R.id.operator_logo)) == null) {
            return hashMap;
        }
        if (Build.VERSION.SDK_INT >= 21) {
            String x = androidx.core.h.u.x((CJRCircleImageViewV8) b(R.id.operator_logo));
            if (x != null) {
                k.a((Object) x, "it");
                CJRCircleImageViewV8 cJRCircleImageViewV8 = (CJRCircleImageViewV8) b(R.id.operator_logo);
                k.a((Object) cJRCircleImageViewV8, "operator_logo");
                hashMap.put(x, cJRCircleImageViewV8);
            }
            String x2 = androidx.core.h.u.x((TextView) b(R.id.operator_name));
            if (x2 != null) {
                k.a((Object) x2, "it");
                TextView textView = (TextView) b(R.id.operator_name);
                k.a((Object) textView, "operator_name");
                hashMap.put(x2, textView);
            }
            String x3 = androidx.core.h.u.x((TextView) b(R.id.recharge_number));
            if (x3 != null) {
                k.a((Object) x3, "it");
                TextView textView2 = (TextView) b(R.id.recharge_number);
                k.a((Object) textView2, "recharge_number");
                hashMap.put(x3, textView2);
            }
            String x4 = androidx.core.h.u.x((TextView) b(R.id.operator_message));
            if (x4 != null) {
                k.a((Object) x4, "it");
                TextView textView3 = (TextView) b(R.id.operator_message);
                k.a((Object) textView3, "operator_message");
                hashMap.put(x4, textView3);
            }
            String x5 = androidx.core.h.u.x(b(R.id.bg_operator_logo));
            if (x5 != null) {
                k.a((Object) x5, "it");
                View b2 = b(R.id.bg_operator_logo);
                k.a((Object) b2, "bg_operator_logo");
                hashMap.put(x5, b2);
            }
            String x6 = androidx.core.h.u.x((RecyclerView) b(R.id.voucher_code_recycler_view));
            if (x6 != null) {
                k.a((Object) x6, "it");
                RecyclerView recyclerView = (RecyclerView) b(R.id.voucher_code_recycler_view);
                k.a((Object) recyclerView, "voucher_code_recycler_view");
                hashMap.put(x6, recyclerView);
            }
        }
        if (this.f64164c != null) {
            CJRRechargeItemActionsListView cJRRechargeItemActionsListView = this.f64164c;
            if (cJRRechargeItemActionsListView == null) {
                k.a();
            }
            hashMap.putAll(cJRRechargeItemActionsListView.getSharedElementMap());
        }
        return hashMap;
    }

    public void onStart() {
        CJRRechargeItemActionsListView cJRRechargeItemActionsListView;
        io.reactivex.rxjava3.j.c<String> disableActionObservable;
        super.onStart();
        ArrayList<kotlin.o<String, String>> arrayList = this.f64109d;
        if ((arrayList == null || (arrayList != null && arrayList.isEmpty())) && (cJRRechargeItemActionsListView = this.f64164c) != null && (disableActionObservable = cJRRechargeItemActionsListView.getDisableActionObservable()) != null) {
            disableActionObservable.onNext(CJROSActionItemV2.Companion.getACTION_TYPE_SHARE_VOUCHER_CODE());
        }
    }
}
