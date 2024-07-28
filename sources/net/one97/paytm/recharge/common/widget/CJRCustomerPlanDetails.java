package net.one97.paytm.recharge.common.widget;

import android.content.Context;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.LinearLayout;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import kotlin.g.b.k;
import kotlin.m.p;
import kotlin.u;
import net.one97.paytm.common.entity.recharge.CJRDisplayValues;
import net.one97.paytm.recharge.R;
import net.one97.paytm.recharge.common.utils.ai;
import net.one97.paytm.recharge.common.utils.ba;

public final class CJRCustomerPlanDetails extends LinearLayout {

    /* renamed from: a  reason: collision with root package name */
    private ArrayList<CJRDisplayValues> f61878a;

    /* renamed from: b  reason: collision with root package name */
    private HashMap f61879b;

    public final View a(int i2) {
        if (this.f61879b == null) {
            this.f61879b = new HashMap();
        }
        View view = (View) this.f61879b.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i2);
        this.f61879b.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CJRCustomerPlanDetails(Context context, ArrayList<CJRDisplayValues> arrayList) {
        super(context);
        k.c(context, "context");
        k.c(arrayList, "displayValues");
        this.f61878a = arrayList;
        setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (layoutParams != null) {
            ((LinearLayout.LayoutParams) layoutParams).setMargins(com.paytm.utility.b.c(20), com.paytm.utility.b.c(10), com.paytm.utility.b.c(20), 0);
            LayoutInflater.from(context).inflate(R.layout.layout_customer_details, this, true);
            a();
            return;
        }
        throw new u("null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
    }

    public final ArrayList<CJRDisplayValues> getDisplayValues() {
        return this.f61878a;
    }

    public final void setDisplayValues(ArrayList<CJRDisplayValues> arrayList) {
        k.c(arrayList, "<set-?>");
        this.f61878a = arrayList;
    }

    private final void a() {
        ViewTreeObserver viewTreeObserver;
        if (this.f61878a.isEmpty()) {
            TextView textView = (TextView) a(R.id.customer_plan_details);
            if (textView != null) {
                ai.b(textView);
                return;
            }
            return;
        }
        Collection arrayList = new ArrayList();
        for (Object next : this.f61878a) {
            if (TextUtils.isEmpty(((CJRDisplayValues) next).getValue())) {
                arrayList.add(next);
            }
        }
        Collection collection = (List) arrayList;
        if (!collection.isEmpty()) {
            this.f61878a.removeAll(collection);
        }
        SpannableStringBuilder a2 = ba.a(getContext(), this.f61878a);
        if (a2 == null || TextUtils.isEmpty(a2.toString())) {
            TextView textView2 = (TextView) a(R.id.customer_plan_details);
            if (textView2 != null) {
                ai.b(textView2);
                return;
            }
            return;
        }
        TextView textView3 = (TextView) a(R.id.customer_plan_details);
        if (textView3 != null) {
            textView3.setText(a2);
        }
        TextView textView4 = (TextView) a(R.id.customer_plan_details);
        if (!(textView4 == null || (viewTreeObserver = textView4.getViewTreeObserver()) == null)) {
            viewTreeObserver.addOnPreDrawListener(new b(this));
        }
        TextView textView5 = (TextView) a(R.id.moreOrLessTxtVw);
        if (textView5 != null) {
            textView5.setOnClickListener(new a(this));
        }
    }

    static final class a implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ CJRCustomerPlanDetails f61880a;

        a(CJRCustomerPlanDetails cJRCustomerPlanDetails) {
            this.f61880a = cJRCustomerPlanDetails;
        }

        public final void onClick(View view) {
            if (view instanceof TextView) {
                TextView textView = (TextView) view;
                if (p.a(this.f61880a.getContext().getString(R.string.view_more), textView.getText().toString(), true)) {
                    textView.setText(this.f61880a.getContext().getString(R.string.view_less));
                    TextView textView2 = (TextView) this.f61880a.a(R.id.customer_plan_details);
                    if (textView2 != null) {
                        textView2.setMaxLines(Integer.MAX_VALUE);
                        return;
                    }
                    return;
                }
                TextView textView3 = (TextView) this.f61880a.a(R.id.customer_plan_details);
                if (textView3 != null) {
                    textView3.setMaxLines(1);
                }
                textView.setText(this.f61880a.getContext().getString(R.string.view_more));
            }
        }
    }

    public static final class b implements ViewTreeObserver.OnPreDrawListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ CJRCustomerPlanDetails f61881a;

        b(CJRCustomerPlanDetails cJRCustomerPlanDetails) {
            this.f61881a = cJRCustomerPlanDetails;
        }

        public final boolean onPreDraw() {
            TextView textView = (TextView) this.f61881a.a(R.id.customer_plan_details);
            k.a((Object) textView, "customer_plan_details");
            textView.getViewTreeObserver().removeOnPreDrawListener(this);
            TextView textView2 = (TextView) this.f61881a.a(R.id.customer_plan_details);
            k.a((Object) textView2, "customer_plan_details");
            if (textView2.getLineCount() > 1) {
                TextView textView3 = (TextView) this.f61881a.a(R.id.moreOrLessTxtVw);
                if (textView3 != null) {
                    ai.a(textView3);
                }
            } else {
                TextView textView4 = (TextView) this.f61881a.a(R.id.moreOrLessTxtVw);
                if (textView4 != null) {
                    ai.b(textView4);
                }
            }
            return true;
        }
    }
}
