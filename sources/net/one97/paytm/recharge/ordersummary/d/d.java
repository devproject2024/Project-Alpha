package net.one97.paytm.recharge.ordersummary.d;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.Group;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.paytm.utility.t;
import com.squareup.picasso.ah;
import com.squareup.picasso.e;
import com.squareup.picasso.w;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import kotlin.g.b.k;
import kotlin.u;
import kotlin.x;
import net.one97.paytm.common.entity.shopping.CJROrderedCart;
import net.one97.paytm.recharge.R;
import net.one97.paytm.recharge.common.a.i;
import net.one97.paytm.recharge.common.e.g;
import net.one97.paytm.recharge.common.widget.CJRAmountView;
import net.one97.paytm.recharge.common.widget.CJRCircleImageViewV8;
import net.one97.paytm.recharge.model.CJROSActionItemV2;
import net.one97.paytm.recharge.model.CJROSActionResponseV2;
import net.one97.paytm.recharge.ordersummary.f.o;
import net.one97.paytm.recharge.ordersummary.h.c;
import net.one97.paytm.recharge.ordersummary.widget.CJRRechargeItemActionsListView;

public class d extends j implements g<net.one97.paytm.recharge.ordersummary.e.d>, o {

    /* renamed from: a  reason: collision with root package name */
    protected CJROrderedCart f64104a;

    /* renamed from: h  reason: collision with root package name */
    private boolean f64105h;

    /* renamed from: i  reason: collision with root package name */
    private ArrayList<kotlin.o<String, String>> f64106i;
    private HashMap j;

    public View a(int i2) {
        if (this.j == null) {
            this.j = new HashMap();
        }
        View view = (View) this.j.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View view2 = getView();
        if (view2 == null) {
            return null;
        }
        View findViewById = view2.findViewById(i2);
        this.j.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    public final long c_(int i2) {
        return (long) i2;
    }

    public void d() {
        HashMap hashMap = this.j;
        if (hashMap != null) {
            hashMap.clear();
        }
    }

    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        d();
    }

    public final /* synthetic */ RecyclerView.v a(ViewGroup viewGroup) {
        k.c(viewGroup, "parent");
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.voucher_code_recycler_item, viewGroup, false);
        k.a((Object) inflate, "LayoutInflater.from(cont…cler_item, parent, false)");
        return new net.one97.paytm.recharge.ordersummary.e.d(inflate, (net.one97.paytm.recharge.ordersummary.f.b) null);
    }

    public final /* synthetic */ void a(RecyclerView.v vVar, int i2) {
        net.one97.paytm.recharge.ordersummary.e.d dVar = (net.one97.paytm.recharge.ordersummary.e.d) vVar;
        k.c(dVar, "holder");
        boolean z = true;
        if (i2 != getItemCount() - 1) {
            z = false;
        }
        ArrayList<kotlin.o<String, String>> arrayList = this.f64106i;
        if (arrayList == null) {
            k.a();
        }
        String str = (String) arrayList.get(i2).getSecond();
        ArrayList<kotlin.o<String, String>> arrayList2 = this.f64106i;
        if (arrayList2 == null) {
            k.a();
        }
        dVar.a(str, (String) arrayList2.get(i2).getFirst(), z);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        k.c(layoutInflater, "inflater");
        return layoutInflater.inflate(R.layout.content_order_details_electricity, viewGroup, false);
    }

    /* access modifiers changed from: protected */
    public void a(View view, Bundle bundle) {
        CJROrderedCart cJROrderedCart;
        SpannableString spannableString;
        FrameLayout frameLayout;
        View view2 = view;
        k.c(view2, "view");
        Bundle arguments = getArguments();
        this.f64105h = arguments != null ? arguments.getBoolean("recharge.show.item.details") : false;
        Bundle arguments2 = getArguments();
        if (arguments2 == null || !arguments2.containsKey("recharge_item")) {
            cJROrderedCart = e().u();
            if (cJROrderedCart == null) {
                k.a();
            }
        } else {
            Bundle arguments3 = getArguments();
            Serializable serializable = arguments3 != null ? arguments3.getSerializable("recharge_item") : null;
            if (serializable != null) {
                cJROrderedCart = (CJROrderedCart) serializable;
            } else {
                throw new u("null cannot be cast to non-null type net.one97.paytm.common.entity.shopping.CJROrderedCart");
            }
        }
        this.f64104a = cJROrderedCart;
        if (!this.f64105h && e().s && e().d()) {
            a();
        }
        ImageView imageView = (ImageView) view2.findViewById(R.id.operator_logo);
        TextView textView = (TextView) view2.findViewById(R.id.operator_name);
        TextView textView2 = (TextView) view2.findViewById(R.id.recharge_number);
        TextView textView3 = (TextView) view2.findViewById(R.id.operator_message);
        TextView textView4 = (TextView) view2.findViewById(R.id.recharge_order_id);
        TextView textView5 = (TextView) view2.findViewById(R.id.recharge_order_time);
        RecyclerView recyclerView = (RecyclerView) view2.findViewById(R.id.voucher_code_recycler_view);
        if (!this.f64105h) {
            k.a((Object) textView, "operatorName");
            net.one97.paytm.recharge.ordersummary.b.a e2 = e();
            Context context = getContext();
            if (context == null) {
                k.a();
            }
            k.a((Object) context, "context!!");
            textView.setText(e2.T(context));
            net.one97.paytm.recharge.ordersummary.b.a e3 = e();
            Context context2 = getContext();
            if (context2 == null) {
                k.a();
            }
            k.a((Object) context2, "context!!");
            CharSequence Q = e3.Q(context2);
            if (!TextUtils.isEmpty(Q)) {
                k.a((Object) textView2, "rechargeNumber");
                textView2.setText(Q);
            } else {
                k.a((Object) textView2, "rechargeNumber");
                textView2.setVisibility(8);
            }
        } else {
            k.a((Object) textView, "operatorName");
            net.one97.paytm.recharge.ordersummary.b.a e4 = e();
            Context context3 = getContext();
            if (context3 == null) {
                k.a();
            }
            k.a((Object) context3, "context!!");
            CJROrderedCart cJROrderedCart2 = this.f64104a;
            if (cJROrderedCart2 == null) {
                k.a("orderedItem");
            }
            textView.setText(e4.c(context3, cJROrderedCart2));
            k.a((Object) textView2, "rechargeNumber");
            textView2.setVisibility(8);
            View a2 = a(R.id.bg_operator_logo);
            if (a2 != null) {
                a2.setVisibility(8);
            }
            if (imageView != null) {
                imageView.setVisibility(8);
            }
            CJRAmountView cJRAmountView = (CJRAmountView) a(R.id.amount_paid);
            if (cJRAmountView != null) {
                net.one97.paytm.recharge.ordersummary.b.a e5 = e();
                Context context4 = getContext();
                if (context4 == null) {
                    k.a();
                }
                k.a((Object) context4, "context!!");
                CJROrderedCart cJROrderedCart3 = this.f64104a;
                if (cJROrderedCart3 == null) {
                    k.a("orderedItem");
                }
                cJRAmountView.setText(e5.g(context4, cJROrderedCart3));
            }
            CJRAmountView cJRAmountView2 = (CJRAmountView) a(R.id.amount_paid);
            if (cJRAmountView2 != null) {
                cJRAmountView2.setVisibility(0);
            }
        }
        k.a((Object) textView4, "rechargeOrderId");
        net.one97.paytm.recharge.ordersummary.b.a e6 = e();
        Context context5 = getContext();
        if (context5 == null) {
            k.a();
        }
        k.a((Object) context5, "context!!");
        textView4.setText(e6.o(context5));
        k.a((Object) textView5, "rechargeOrderTime");
        net.one97.paytm.recharge.ordersummary.b.a e7 = e();
        Context context6 = getContext();
        if (context6 == null) {
            k.a();
        }
        k.a((Object) context6, "context!!");
        textView5.setText(e7.n(context6));
        HashMap<Long, CJROSActionResponseV2> hashMap = e().m;
        CJROrderedCart cJROrderedCart4 = this.f64104a;
        if (cJROrderedCart4 == null) {
            k.a("orderedItem");
        }
        CJROSActionResponseV2 cJROSActionResponseV2 = hashMap.get(Long.valueOf(cJROrderedCart4.getId()));
        if (this.f64105h || e().k.size() <= 1) {
            net.one97.paytm.recharge.ordersummary.b.a e8 = e();
            Context context7 = getContext();
            if (context7 == null) {
                k.a();
            }
            k.a((Object) context7, "context!!");
            spannableString = e8.b(context7, cJROSActionResponseV2);
        } else {
            net.one97.paytm.recharge.ordersummary.b.a e9 = e();
            Context context8 = getContext();
            if (context8 == null) {
                k.a();
            }
            k.a((Object) context8, "context!!");
            spannableString = e9.a(context8, cJROSActionResponseV2);
        }
        CharSequence charSequence = spannableString;
        if (!TextUtils.isEmpty(charSequence)) {
            this.f64154e = true;
            k.a((Object) textView3, "operatorMessage");
            textView3.setText(charSequence);
            textView3.setVisibility(0);
        }
        if (!this.f64105h) {
            net.one97.paytm.recharge.ordersummary.b.a e10 = e();
            Context context9 = getContext();
            if (context9 == null) {
                k.a();
            }
            k.a((Object) context9, "context!!");
            this.f64106i = e10.j(context9);
        } else {
            net.one97.paytm.recharge.ordersummary.b.a e11 = e();
            Context context10 = getContext();
            if (context10 == null) {
                k.a();
            }
            k.a((Object) context10, "context!!");
            CJROrderedCart cJROrderedCart5 = this.f64104a;
            if (cJROrderedCart5 == null) {
                k.a("orderedItem");
            }
            kotlin.o<String, String> e12 = e11.e(context10, cJROrderedCart5);
            if (!TextUtils.isEmpty(e12.getFirst())) {
                this.f64106i = new ArrayList<>();
                ArrayList<kotlin.o<String, String>> arrayList = this.f64106i;
                if (arrayList == null) {
                    k.a();
                }
                arrayList.add(e12);
            }
        }
        ArrayList<kotlin.o<String, String>> arrayList2 = this.f64106i;
        if (arrayList2 != null && (!arrayList2.isEmpty())) {
            k.a((Object) recyclerView, "meterCodeRecyclerView");
            recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
            recyclerView.setAdapter(new i(this));
            recyclerView.setVisibility(0);
            if (!this.f64105h && e().k.size() > 1) {
                k.a((Object) textView3, "operatorMessage");
                textView3.setVisibility(8);
                this.f64154e = false;
            }
        }
        if (getParentFragment() != null && (getParentFragment() instanceof net.one97.paytm.recharge.ordersummary.f.b)) {
            CJRRechargeItemActionsListView.b bVar = CJRRechargeItemActionsListView.f64530e;
            Context context11 = getContext();
            if (context11 == null) {
                k.a();
            }
            k.a((Object) context11, "context!!");
            int i2 = !this.f64105h ? 2 : 1;
            CJROrderedCart cJROrderedCart6 = this.f64104a;
            if (cJROrderedCart6 == null) {
                k.a("orderedItem");
            }
            net.one97.paytm.recharge.ordersummary.b.a e13 = e();
            Fragment parentFragment = getParentFragment();
            if (parentFragment != null) {
                this.f64156g = CJRRechargeItemActionsListView.b.a(context11, i2, 3, cJROrderedCart6, e13, (net.one97.paytm.recharge.ordersummary.f.b) parentFragment, !this.f64105h && e().k.size() > 1, false, 128);
                if (!(this.f64156g == null || (frameLayout = (FrameLayout) a(R.id.lyt_actions)) == null)) {
                    frameLayout.addView(this.f64156g);
                    x xVar = x.f47997a;
                }
            } else {
                throw new u("null cannot be cast to non-null type net.one97.paytm.recharge.ordersummary.listener.IJRFailedPendingActionListener");
            }
        }
        this.f64153d = true;
        b();
        net.one97.paytm.recharge.ordersummary.b.a e14 = e();
        CJROrderedCart cJROrderedCart7 = this.f64104a;
        if (cJROrderedCart7 == null) {
            k.a("orderedItem");
        }
        String c2 = e14.c(cJROrderedCart7);
        if (c.a.C1269a.MY_PAYMENTS == e().u.b()) {
            k.a((Object) imageView, "operatorLogoView");
            imageView.setVisibility(4);
            View findViewById = view2.findViewById(R.id.bg_operator_logo);
            k.a((Object) findViewById, "view.findViewById<View>(R.id.bg_operator_logo)");
            findViewById.setVisibility(4);
            Fragment parentFragment2 = getParentFragment();
            if (parentFragment2 != null) {
                parentFragment2.startPostponedEnterTransition();
                x xVar2 = x.f47997a;
            }
        } else if (!TextUtils.isEmpty(c2)) {
            try {
                w.a().a(c2).a((ah) new t.b((int) getResources().getDimension(R.dimen.dimen_34dp), 0, true)).a(R.color.color_909090).a(imageView, (e) new a(this));
            } catch (Exception unused) {
                Fragment parentFragment3 = getParentFragment();
                if (parentFragment3 != null) {
                    parentFragment3.startPostponedEnterTransition();
                    x xVar3 = x.f47997a;
                }
            }
        } else {
            Fragment parentFragment4 = getParentFragment();
            if (parentFragment4 != null) {
                parentFragment4.startPostponedEnterTransition();
                x xVar4 = x.f47997a;
            }
        }
    }

    public static final class a implements e {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ d f64107a;

        a(d dVar) {
            this.f64107a = dVar;
        }

        public final void onSuccess() {
            Fragment parentFragment = this.f64107a.getParentFragment();
            if (parentFragment != null) {
                parentFragment.startPostponedEnterTransition();
            }
        }

        public final void onError(Exception exc) {
            k.c(exc, "e");
            Fragment parentFragment = this.f64107a.getParentFragment();
            if (parentFragment != null) {
                parentFragment.startPostponedEnterTransition();
            }
        }
    }

    public int getItemCount() {
        ArrayList<kotlin.o<String, String>> arrayList = this.f64106i;
        if (arrayList != null) {
            return arrayList.size();
        }
        return 0;
    }

    /* access modifiers changed from: protected */
    public final void b() {
        TextView textView = (TextView) a(R.id.recharge_order_id);
        if (textView != null) {
            textView.setVisibility(0);
        }
        TextView textView2 = (TextView) a(R.id.recharge_order_time);
        if (textView2 != null) {
            textView2.setVisibility(0);
        }
        ImageView imageView = (ImageView) a(R.id.divider_order_id);
        if (imageView != null) {
            imageView.setVisibility(0);
        }
        if (this.f64154e) {
            View a2 = a(R.id.recharge_divider);
            if (a2 != null) {
                a2.setVisibility(0);
            }
            TextView textView3 = (TextView) a(R.id.operator_message);
            if (textView3 != null) {
                textView3.setVisibility(0);
            }
            Group group = (Group) a(R.id.group_operator_message);
            if (group != null) {
                group.setVisibility(0);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void c() {
        ObjectAnimator ofPropertyValuesHolder = ObjectAnimator.ofPropertyValuesHolder((TextView) a(R.id.recharge_order_id), new PropertyValuesHolder[]{PropertyValuesHolder.ofFloat(View.ALPHA, new float[]{0.0f, 1.0f})});
        k.a((Object) ofPropertyValuesHolder, "ObjectAnimator.ofPropert….toFloat(), 1.toFloat()))");
        ObjectAnimator ofPropertyValuesHolder2 = ObjectAnimator.ofPropertyValuesHolder((ImageView) a(R.id.divider_order_id), new PropertyValuesHolder[]{PropertyValuesHolder.ofFloat(View.ALPHA, new float[]{0.0f, 1.0f})});
        k.a((Object) ofPropertyValuesHolder2, "ObjectAnimator.ofPropert….toFloat(), 1.toFloat()))");
        ObjectAnimator ofPropertyValuesHolder3 = ObjectAnimator.ofPropertyValuesHolder((TextView) a(R.id.recharge_order_time), new PropertyValuesHolder[]{PropertyValuesHolder.ofFloat(View.ALPHA, new float[]{0.0f, 1.0f})});
        k.a((Object) ofPropertyValuesHolder3, "ObjectAnimator.ofPropert….toFloat(), 1.toFloat()))");
        ObjectAnimator ofPropertyValuesHolder4 = ObjectAnimator.ofPropertyValuesHolder(a(R.id.recharge_divider), new PropertyValuesHolder[]{PropertyValuesHolder.ofFloat(View.ALPHA, new float[]{0.0f, 1.0f})});
        k.a((Object) ofPropertyValuesHolder4, "ObjectAnimator.ofPropert….toFloat(), 1.toFloat()))");
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.setDuration(375);
        animatorSet.setInterpolator(new AccelerateDecelerateInterpolator());
        animatorSet.addListener(new b(this));
        animatorSet.playTogether(new Animator[]{ofPropertyValuesHolder, ofPropertyValuesHolder3, ofPropertyValuesHolder2, ofPropertyValuesHolder4});
        animatorSet.start();
    }

    public static final class b extends AnimatorListenerAdapter {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ d f64108a;

        b(d dVar) {
            this.f64108a = dVar;
        }

        public final void onAnimationStart(Animator animator) {
            TextView textView = (TextView) this.f64108a.a(R.id.recharge_order_id);
            if (textView != null) {
                textView.setVisibility(0);
            }
            TextView textView2 = (TextView) this.f64108a.a(R.id.recharge_order_time);
            if (textView2 != null) {
                textView2.setVisibility(0);
            }
            ImageView imageView = (ImageView) this.f64108a.a(R.id.divider_order_id);
            if (imageView != null) {
                imageView.setVisibility(0);
            }
            if (this.f64108a.f64154e) {
                View a2 = this.f64108a.a(R.id.recharge_divider);
                if (a2 != null) {
                    a2.setVisibility(0);
                }
                TextView textView3 = (TextView) this.f64108a.a(R.id.operator_message);
                if (textView3 != null) {
                    textView3.setVisibility(0);
                }
                Group group = (Group) this.f64108a.a(R.id.group_operator_message);
                if (group != null) {
                    group.setVisibility(0);
                }
            }
        }
    }

    public Map<String, View> getSharedElementMap() {
        HashMap hashMap = new HashMap(1);
        if (Build.VERSION.SDK_INT >= 21) {
            String x = androidx.core.h.u.x((CJRCircleImageViewV8) a(R.id.operator_logo));
            if (x != null) {
                k.a((Object) x, "it");
                CJRCircleImageViewV8 cJRCircleImageViewV8 = (CJRCircleImageViewV8) a(R.id.operator_logo);
                k.a((Object) cJRCircleImageViewV8, "operator_logo");
                hashMap.put(x, cJRCircleImageViewV8);
            }
            String x2 = androidx.core.h.u.x((TextView) a(R.id.operator_name));
            if (x2 != null) {
                k.a((Object) x2, "it");
                TextView textView = (TextView) a(R.id.operator_name);
                k.a((Object) textView, "operator_name");
                hashMap.put(x2, textView);
            }
            String x3 = androidx.core.h.u.x((TextView) a(R.id.recharge_number));
            if (x3 != null) {
                k.a((Object) x3, "it");
                TextView textView2 = (TextView) a(R.id.recharge_number);
                k.a((Object) textView2, "recharge_number");
                hashMap.put(x3, textView2);
            }
            String x4 = androidx.core.h.u.x((TextView) a(R.id.recharge_order_id));
            if (x4 != null) {
                k.a((Object) x4, "it");
                TextView textView3 = (TextView) a(R.id.recharge_order_id);
                k.a((Object) textView3, "recharge_order_id");
                hashMap.put(x4, textView3);
            }
            String x5 = androidx.core.h.u.x((TextView) a(R.id.recharge_order_time));
            if (x5 != null) {
                k.a((Object) x5, "it");
                TextView textView4 = (TextView) a(R.id.recharge_order_time);
                k.a((Object) textView4, "recharge_order_time");
                hashMap.put(x5, textView4);
            }
            String x6 = androidx.core.h.u.x((TextView) a(R.id.operator_message));
            if (x6 != null) {
                k.a((Object) x6, "it");
                TextView textView5 = (TextView) a(R.id.operator_message);
                k.a((Object) textView5, "operator_message");
                hashMap.put(x6, textView5);
            }
            String x7 = androidx.core.h.u.x(a(R.id.bg_operator_logo));
            if (x7 != null) {
                k.a((Object) x7, "it");
                View a2 = a(R.id.bg_operator_logo);
                k.a((Object) a2, "bg_operator_logo");
                hashMap.put(x7, a2);
            }
            String x8 = androidx.core.h.u.x((RecyclerView) a(R.id.voucher_code_recycler_view));
            if (x8 != null) {
                k.a((Object) x8, "it");
                RecyclerView recyclerView = (RecyclerView) a(R.id.voucher_code_recycler_view);
                k.a((Object) recyclerView, "voucher_code_recycler_view");
                hashMap.put(x8, recyclerView);
            }
        }
        if (this.f64156g != null) {
            CJRRechargeItemActionsListView cJRRechargeItemActionsListView = this.f64156g;
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
        ArrayList<kotlin.o<String, String>> arrayList = this.f64106i;
        if ((arrayList == null || (arrayList != null && arrayList.isEmpty())) && (cJRRechargeItemActionsListView = this.f64156g) != null && (disableActionObservable = cJRRechargeItemActionsListView.getDisableActionObservable()) != null) {
            disableActionObservable.onNext(CJROSActionItemV2.Companion.getACTION_TYPE_SHARE_VOUCHER_CODE());
        }
    }
}
