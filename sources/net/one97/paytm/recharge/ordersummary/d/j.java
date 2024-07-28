package net.one97.paytm.recharge.ordersummary.d;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.Group;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.al;
import androidx.lifecycle.am;
import androidx.transition.Transition;
import com.paytm.utility.t;
import com.squareup.picasso.ah;
import com.squareup.picasso.e;
import com.squareup.picasso.w;
import java.util.HashMap;
import java.util.Map;
import kotlin.g.b.k;
import kotlin.u;
import net.one97.paytm.common.entity.shopping.CJROrderSummary;
import net.one97.paytm.common.entity.shopping.CJROrderedCart;
import net.one97.paytm.passbook.beans.BusOtherDetailsModel;
import net.one97.paytm.recharge.R;
import net.one97.paytm.recharge.common.b.d;
import net.one97.paytm.recharge.common.h.f;
import net.one97.paytm.recharge.common.utils.ai;
import net.one97.paytm.recharge.common.utils.ba;
import net.one97.paytm.recharge.common.widget.CJRCircleImageViewV8;
import net.one97.paytm.recharge.di.helper.CJRRechargeUtilities;
import net.one97.paytm.recharge.model.CJROSActionResponseV2;
import net.one97.paytm.recharge.model.rechargeutility.CJRBrowsePlanProductList;
import net.one97.paytm.recharge.ordersummary.activity.AJRechargeOrderSummaryActivity;
import net.one97.paytm.recharge.ordersummary.f.o;
import net.one97.paytm.recharge.ordersummary.widget.CJRRechargeItemActionsListView;

public class j extends Fragment implements o {

    /* renamed from: a  reason: collision with root package name */
    private f f64150a;

    /* renamed from: b  reason: collision with root package name */
    protected net.one97.paytm.recharge.ordersummary.b.a f64151b;

    /* renamed from: c  reason: collision with root package name */
    protected CJROrderSummary f64152c;

    /* renamed from: d  reason: collision with root package name */
    boolean f64153d;

    /* renamed from: e  reason: collision with root package name */
    boolean f64154e;

    /* renamed from: f  reason: collision with root package name */
    boolean f64155f;

    /* renamed from: g  reason: collision with root package name */
    CJRRechargeItemActionsListView f64156g;

    /* renamed from: h  reason: collision with root package name */
    private CJRRechargeItemActionsListView f64157h;

    /* renamed from: i  reason: collision with root package name */
    private HashMap f64158i;

    public View a(int i2) {
        if (this.f64158i == null) {
            this.f64158i = new HashMap();
        }
        View view = (View) this.f64158i.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View view2 = getView();
        if (view2 == null) {
            return null;
        }
        View findViewById = view2.findViewById(i2);
        this.f64158i.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    public void d() {
        HashMap hashMap = this.f64158i;
        if (hashMap != null) {
            hashMap.clear();
        }
    }

    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        d();
    }

    /* access modifiers changed from: protected */
    public final net.one97.paytm.recharge.ordersummary.b.a e() {
        net.one97.paytm.recharge.ordersummary.b.a aVar = this.f64151b;
        if (aVar == null) {
            k.a("viewModel");
        }
        return aVar;
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        k.c(layoutInflater, "inflater");
        return layoutInflater.inflate(R.layout.content_order_details_mobile, viewGroup, false);
    }

    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        if (getActivity() instanceof AJRechargeOrderSummaryActivity) {
            CJRRechargeUtilities.INSTANCE.debugLog("mobile-detail get viewModel from Activity");
            FragmentActivity activity = getActivity();
            if (activity != null) {
                this.f64151b = ((AJRechargeOrderSummaryActivity) activity).l();
                net.one97.paytm.recharge.ordersummary.b.a aVar = this.f64151b;
                if (aVar == null) {
                    k.a("viewModel");
                }
                CJROrderSummary cJROrderSummary = aVar.f63998b;
                if (cJROrderSummary == null) {
                    k.a();
                }
                this.f64152c = cJROrderSummary;
                FragmentActivity activity2 = getActivity();
                if (activity2 != null) {
                    k.a((Object) activity2, "it");
                    Context applicationContext = activity2.getApplicationContext();
                    k.a((Object) applicationContext, "it.applicationContext");
                    this.f64150a = (f) am.a(activity2, (al.b) new net.one97.paytm.recharge.common.h.a(d.b(applicationContext), d.d(activity2))).a(f.class);
                }
                if (getView() != null) {
                    if (bundle != null) {
                        this.f64153d = bundle.getBoolean("isTransitionEnded", this.f64153d);
                    }
                    View view = getView();
                    if (view == null) {
                        k.a();
                    }
                    k.a((Object) view, "view!!");
                    a(view, bundle);
                    return;
                }
                return;
            }
            throw new u("null cannot be cast to non-null type net.one97.paytm.recharge.ordersummary.activity.AJRechargeOrderSummaryActivity");
        }
        CJRRechargeUtilities.INSTANCE.debugLog("mobile-detail no implementation to get viewModel: Default returning to home");
        FragmentActivity activity3 = getActivity();
        if (activity3 != null) {
            activity3.finish();
        }
    }

    public void onSaveInstanceState(Bundle bundle) {
        k.c(bundle, "outState");
        bundle.putBoolean("isTransitionEnded", this.f64153d);
        super.onSaveInstanceState(bundle);
    }

    /* access modifiers changed from: protected */
    public void a(View view, Bundle bundle) {
        FrameLayout frameLayout;
        View view2 = view;
        k.c(view2, "view");
        net.one97.paytm.recharge.ordersummary.b.a aVar = this.f64151b;
        if (aVar == null) {
            k.a("viewModel");
        }
        if (aVar.s) {
            net.one97.paytm.recharge.ordersummary.b.a aVar2 = this.f64151b;
            if (aVar2 == null) {
                k.a("viewModel");
            }
            if (aVar2.d()) {
                a();
            }
        }
        ImageView imageView = (ImageView) view2.findViewById(R.id.operator_logo);
        TextView textView = (TextView) view2.findViewById(R.id.operator_name);
        TextView textView2 = (TextView) view2.findViewById(R.id.recharge_number);
        TextView textView3 = (TextView) view2.findViewById(R.id.operator_message);
        TextView textView4 = (TextView) view2.findViewById(R.id.recharge_order_id);
        TextView textView5 = (TextView) view2.findViewById(R.id.recharge_order_time);
        k.a((Object) textView, "operatorName");
        net.one97.paytm.recharge.ordersummary.b.a aVar3 = this.f64151b;
        if (aVar3 == null) {
            k.a("viewModel");
        }
        Context context = getContext();
        if (context == null) {
            k.a();
        }
        k.a((Object) context, "context!!");
        textView.setText(aVar3.T(context));
        k.a((Object) textView2, "rechargeNumber");
        net.one97.paytm.recharge.ordersummary.b.a aVar4 = this.f64151b;
        if (aVar4 == null) {
            k.a("viewModel");
        }
        Context context2 = getContext();
        if (context2 == null) {
            k.a();
        }
        k.a((Object) context2, "context!!");
        textView2.setText(aVar4.Q(context2));
        k.a((Object) textView4, "rechargeOrderId");
        net.one97.paytm.recharge.ordersummary.b.a aVar5 = this.f64151b;
        if (aVar5 == null) {
            k.a("viewModel");
        }
        Context context3 = getContext();
        if (context3 == null) {
            k.a();
        }
        k.a((Object) context3, "context!!");
        textView4.setText(aVar5.o(context3));
        k.a((Object) textView5, "rechargeOrderTime");
        net.one97.paytm.recharge.ordersummary.b.a aVar6 = this.f64151b;
        if (aVar6 == null) {
            k.a("viewModel");
        }
        Context context4 = getContext();
        if (context4 == null) {
            k.a();
        }
        k.a((Object) context4, "context!!");
        textView5.setText(aVar6.n(context4));
        net.one97.paytm.recharge.ordersummary.b.a aVar7 = this.f64151b;
        if (aVar7 == null) {
            k.a("viewModel");
        }
        CJROrderedCart u = aVar7.u();
        if (u == null) {
            k.a();
        }
        net.one97.paytm.recharge.ordersummary.b.a aVar8 = this.f64151b;
        if (aVar8 == null) {
            k.a("viewModel");
        }
        CJROSActionResponseV2 cJROSActionResponseV2 = aVar8.m.get(Long.valueOf(u.getId()));
        net.one97.paytm.recharge.ordersummary.b.a aVar9 = this.f64151b;
        if (aVar9 == null) {
            k.a("viewModel");
        }
        Context context5 = getContext();
        if (context5 == null) {
            k.a();
        }
        k.a((Object) context5, "context!!");
        CharSequence b2 = aVar9.b(context5, cJROSActionResponseV2);
        if (!TextUtils.isEmpty(b2)) {
            this.f64154e = true;
            if (textView3 != null) {
                textView3.setText(b2);
            }
        }
        if (getParentFragment() != null && (getParentFragment() instanceof net.one97.paytm.recharge.ordersummary.f.b)) {
            CJRRechargeItemActionsListView.b bVar = CJRRechargeItemActionsListView.f64530e;
            Context context6 = getContext();
            if (context6 == null) {
                k.a();
            }
            k.a((Object) context6, "context!!");
            net.one97.paytm.recharge.ordersummary.b.a aVar10 = this.f64151b;
            if (aVar10 == null) {
                k.a("viewModel");
            }
            Fragment parentFragment = getParentFragment();
            if (parentFragment != null) {
                this.f64156g = CJRRechargeItemActionsListView.b.a(context6, 2, 3, u, aVar10, (net.one97.paytm.recharge.ordersummary.f.b) parentFragment, false, false, 192);
                if (!(this.f64156g == null || (frameLayout = (FrameLayout) a(R.id.lyt_actions)) == null)) {
                    frameLayout.addView(this.f64156g);
                }
                CJRRechargeItemActionsListView.b bVar2 = CJRRechargeItemActionsListView.f64530e;
                Context context7 = getContext();
                if (context7 == null) {
                    k.a();
                }
                k.a((Object) context7, "context!!");
                net.one97.paytm.recharge.ordersummary.b.a aVar11 = this.f64151b;
                if (aVar11 == null) {
                    k.a("viewModel");
                }
                Fragment parentFragment2 = getParentFragment();
                if (parentFragment2 != null) {
                    this.f64157h = CJRRechargeItemActionsListView.b.a(context7, 2, 3, u, aVar11, (net.one97.paytm.recharge.ordersummary.f.b) parentFragment2, false, true, 64);
                    if (this.f64157h != null) {
                        FrameLayout frameLayout2 = (FrameLayout) a(R.id.lyt_vertical_actions);
                        if (frameLayout2 != null) {
                            ai.a(frameLayout2);
                        }
                        FrameLayout frameLayout3 = (FrameLayout) a(R.id.lyt_vertical_actions);
                        if (frameLayout3 != null) {
                            frameLayout3.addView(this.f64157h);
                        }
                    }
                } else {
                    throw new u("null cannot be cast to non-null type net.one97.paytm.recharge.ordersummary.listener.IJRFailedPendingActionListener");
                }
            } else {
                throw new u("null cannot be cast to non-null type net.one97.paytm.recharge.ordersummary.listener.IJRFailedPendingActionListener");
            }
        }
        k.c(u, "orderedItem");
        CJRBrowsePlanProductList cJRBrowsePlanProductList = new CJRBrowsePlanProductList();
        Object metaDataResponse = u.getMetaDataResponse();
        if (!(metaDataResponse instanceof Map)) {
            metaDataResponse = null;
        }
        Map map = (Map) metaDataResponse;
        if (map != null) {
            String str = (String) map.get("couponDescription");
            if (str == null) {
                str = (String) map.get("PlanDescription");
            }
            if (str == null) {
                str = "";
            }
            cJRBrowsePlanProductList.setDescription(str);
            String str2 = (String) map.get("talktime");
            if (str2 == null) {
                str2 = "";
            }
            if (str2 == null) {
                str2 = (String) map.get("Talktime");
            }
            if (str2 == null) {
                str2 = "";
            }
            cJRBrowsePlanProductList.setTalktime(str2);
            String str3 = (String) map.get("validity");
            if (str3 == null) {
                str3 = "";
            }
            if (str3 == null) {
                str3 = (String) map.get(BusOtherDetailsModel.ROW_NAME_VALIDITY);
            }
            if (str3 == null) {
                str3 = "";
            }
            cJRBrowsePlanProductList.setValidity(str3);
            String str4 = (String) map.get("data");
            if (str4 == null) {
                str4 = "";
            }
            cJRBrowsePlanProductList.setData(str4);
            String str5 = (String) map.get("sms");
            if (str5 == null) {
                str5 = "";
            }
            cJRBrowsePlanProductList.setSms(str5);
        }
        SpannableStringBuilder a2 = ba.a(getContext(), cJRBrowsePlanProductList);
        CharSequence charSequence = a2;
        if (!TextUtils.isEmpty(charSequence)) {
            this.f64155f = true;
            Context context8 = getContext();
            if (context8 == null) {
                k.a();
            }
            a2.setSpan(new ForegroundColorSpan(androidx.core.content.b.c(context8, R.color.v8_recharge_selected_plan)), 0, a2.length(), 33);
            TextView textView6 = (TextView) a(R.id.plan_details);
            if (textView6 != null) {
                textView6.setText(charSequence);
            }
        }
        this.f64153d = true;
        b();
        net.one97.paytm.recharge.ordersummary.b.a aVar12 = this.f64151b;
        if (aVar12 == null) {
            k.a("viewModel");
        }
        String c2 = aVar12.c(u);
        if (!TextUtils.isEmpty(c2)) {
            try {
                w.a().a(c2).a((ah) new t.b((int) getResources().getDimension(R.dimen.dimen_34dp), 0, true)).a(R.color.color_ffffff).a(imageView, (e) new b(this));
            } catch (Exception unused) {
                Fragment parentFragment3 = getParentFragment();
                if (parentFragment3 != null) {
                    parentFragment3.startPostponedEnterTransition();
                }
            }
        } else {
            Fragment parentFragment4 = getParentFragment();
            if (parentFragment4 != null) {
                parentFragment4.startPostponedEnterTransition();
            }
        }
    }

    public static final class b implements e {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ j f64160a;

        b(j jVar) {
            this.f64160a = jVar;
        }

        public final void onSuccess() {
            Fragment parentFragment = this.f64160a.getParentFragment();
            if (parentFragment != null) {
                parentFragment.startPostponedEnterTransition();
            }
        }

        public final void onError(Exception exc) {
            k.c(exc, "e");
            Fragment parentFragment = this.f64160a.getParentFragment();
            if (parentFragment != null) {
                parentFragment.startPostponedEnterTransition();
            }
        }
    }

    public static final class a extends androidx.transition.u {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ j f64159a;

        a(j jVar) {
            this.f64159a = jVar;
        }

        public final void b(Transition transition) {
            k.c(transition, "transition");
            CJRRechargeUtilities cJRRechargeUtilities = CJRRechargeUtilities.INSTANCE;
            cJRRechargeUtilities.debugLog("onTransitionStart startPostInflate " + j.class.getName());
        }

        public final void a(Transition transition) {
            k.c(transition, "transition");
            CJRRechargeUtilities cJRRechargeUtilities = CJRRechargeUtilities.INSTANCE;
            cJRRechargeUtilities.debugLog("onTransitionEnd " + j.class.getName());
            j jVar = this.f64159a;
            jVar.f64153d = true;
            if (((TextView) jVar.a(R.id.recharge_order_id)) != null) {
                this.f64159a.c();
            } else {
                this.f64159a.b();
            }
        }
    }

    /* access modifiers changed from: protected */
    public void a() {
        Fragment parentFragment = getParentFragment();
        Object sharedElementEnterTransition = parentFragment != null ? parentFragment.getSharedElementEnterTransition() : null;
        if (!(sharedElementEnterTransition instanceof Transition)) {
            sharedElementEnterTransition = null;
        }
        Transition transition = (Transition) sharedElementEnterTransition;
        if (transition != null) {
            transition.a((Transition.d) new a(this));
        }
    }

    /* access modifiers changed from: protected */
    public void b() {
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
        if (this.f64155f) {
            TextView textView4 = (TextView) a(R.id.plan_details_title);
            if (textView4 != null) {
                textView4.setVisibility(0);
            }
            TextView textView5 = (TextView) a(R.id.plan_details);
            if (textView5 != null) {
                textView5.setVisibility(0);
            }
            Group group2 = (Group) a(R.id.group_plan_details);
            if (group2 != null) {
                group2.setVisibility(0);
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
        ObjectAnimator ofPropertyValuesHolder5 = ObjectAnimator.ofPropertyValuesHolder((Group) a(R.id.group_plan_details), new PropertyValuesHolder[]{PropertyValuesHolder.ofFloat(View.ALPHA, new float[]{0.0f, 1.0f})});
        k.a((Object) ofPropertyValuesHolder5, "ObjectAnimator.ofPropert….toFloat(), 1.toFloat()))");
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.setDuration(375);
        animatorSet.setInterpolator(new AccelerateDecelerateInterpolator());
        animatorSet.addListener(new c(this));
        animatorSet.playTogether(new Animator[]{ofPropertyValuesHolder, ofPropertyValuesHolder3, ofPropertyValuesHolder2, ofPropertyValuesHolder4, ofPropertyValuesHolder5});
        animatorSet.start();
    }

    public static final class c extends AnimatorListenerAdapter {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ j f64161a;

        c(j jVar) {
            this.f64161a = jVar;
        }

        public final void onAnimationStart(Animator animator) {
            TextView textView = (TextView) this.f64161a.a(R.id.recharge_order_id);
            if (textView != null) {
                textView.setVisibility(0);
            }
            TextView textView2 = (TextView) this.f64161a.a(R.id.recharge_order_time);
            if (textView2 != null) {
                textView2.setVisibility(0);
            }
            ImageView imageView = (ImageView) this.f64161a.a(R.id.divider_order_id);
            if (imageView != null) {
                imageView.setVisibility(0);
            }
            if (this.f64161a.f64154e) {
                View a2 = this.f64161a.a(R.id.recharge_divider);
                if (a2 != null) {
                    a2.setVisibility(0);
                }
                TextView textView3 = (TextView) this.f64161a.a(R.id.operator_message);
                if (textView3 != null) {
                    textView3.setVisibility(0);
                }
                Group group = (Group) this.f64161a.a(R.id.group_operator_message);
                if (group != null) {
                    group.setVisibility(0);
                }
            }
            if (this.f64161a.f64155f) {
                TextView textView4 = (TextView) this.f64161a.a(R.id.plan_details_title);
                if (textView4 != null) {
                    textView4.setVisibility(0);
                }
                TextView textView5 = (TextView) this.f64161a.a(R.id.plan_details);
                if (textView5 != null) {
                    textView5.setVisibility(0);
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
        }
        CJRRechargeItemActionsListView cJRRechargeItemActionsListView = this.f64156g;
        if (cJRRechargeItemActionsListView != null) {
            if (cJRRechargeItemActionsListView == null) {
                k.a();
            }
            hashMap.putAll(cJRRechargeItemActionsListView.getSharedElementMap());
        }
        CJRRechargeItemActionsListView cJRRechargeItemActionsListView2 = this.f64157h;
        if (cJRRechargeItemActionsListView2 != null) {
            if (cJRRechargeItemActionsListView2 == null) {
                k.a();
            }
            hashMap.putAll(cJRRechargeItemActionsListView2.getSharedElementMap());
        }
        return hashMap;
    }
}
