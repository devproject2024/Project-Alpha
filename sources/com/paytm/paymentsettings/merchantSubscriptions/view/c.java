package com.paytm.paymentsettings.merchantSubscriptions.view;

import android.app.Activity;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.TouchDelegate;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.Button;
import android.widget.ImageView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.business.merchant_payments.businesswallet.util.TransactionType;
import com.paytm.paymentsettings.R;
import com.paytm.paymentsettings.merchantSubscriptions.model.ActiveSubscriptionDetailsItem;
import com.paytm.utility.RoboTextView;
import java.io.Serializable;
import java.util.HashMap;
import kotlin.g.b.k;
import kotlin.u;
import net.one97.paytm.i.f;
import net.one97.paytm.nativesdk.transcation.viewmodel.DirectFormItemType;

public final class c extends f implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public static final a f43488a = new a((byte) 0);

    /* renamed from: b  reason: collision with root package name */
    private ActiveSubscriptionDetailsItem f43489b;

    /* renamed from: c  reason: collision with root package name */
    private RoboTextView f43490c;

    /* renamed from: d  reason: collision with root package name */
    private RoboTextView f43491d;

    /* renamed from: e  reason: collision with root package name */
    private String f43492e;

    /* renamed from: f  reason: collision with root package name */
    private HashMap f43493f;

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setStyle(0, R.style.CustomActiveSubscriptionsBottomSheetTheme);
        if (getArguments() != null) {
            Bundle arguments = getArguments();
            String str = null;
            Serializable serializable = arguments != null ? arguments.getSerializable("item") : null;
            if (serializable != null) {
                this.f43489b = (ActiveSubscriptionDetailsItem) serializable;
                Bundle arguments2 = getArguments();
                if (arguments2 != null) {
                    str = arguments2.getString("tag");
                }
                this.f43492e = str;
                return;
            }
            throw new u("null cannot be cast to non-null type com.paytm.paymentsettings.merchantSubscriptions.model.ActiveSubscriptionDetailsItem");
        }
    }

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        k.c(layoutInflater, "inflater");
        View inflate = layoutInflater.inflate(R.layout.layout_cancel_active_subscription, viewGroup, false);
        k.a((Object) inflate, "inflater.inflate(R.layou…iption, container, false)");
        Button button = (Button) inflate.findViewById(R.id.btn_cancel_subscription_confirmation);
        View findViewById = inflate.findViewById(R.id.tv_cancel_subscription_denial);
        k.a((Object) findViewById, "view.findViewById(R.id.t…ncel_subscription_denial)");
        RoboTextView roboTextView = (RoboTextView) findViewById;
        View findViewById2 = inflate.findViewById(R.id.tv_active_subscription_info_content);
        if (findViewById2 != null) {
            this.f43490c = (RoboTextView) findViewById2;
            View findViewById3 = inflate.findViewById(R.id.tv_cancel_subscription_title);
            if (findViewById3 != null) {
                this.f43491d = (RoboTextView) findViewById3;
                View findViewById4 = inflate.findViewById(R.id.iv_dismiss_active_subscription_bottom_sheet);
                if (findViewById4 != null) {
                    ImageView imageView = (ImageView) findViewById4;
                    ViewParent parent = roboTextView.getParent();
                    if (parent != null) {
                        View view = (View) parent;
                        view.post(new b(this, roboTextView, view));
                        View.OnClickListener onClickListener = this;
                        button.setOnClickListener(onClickListener);
                        roboTextView.setOnClickListener(onClickListener);
                        imageView.setOnClickListener(onClickListener);
                        if (k.a((Object) this.f43492e, (Object) "information")) {
                            View findViewById5 = inflate.findViewById(R.id.cl_cancel_subscription);
                            k.a((Object) findViewById5, "view.findViewById<View>(…d.cl_cancel_subscription)");
                            findViewById5.setVisibility(8);
                            View findViewById6 = inflate.findViewById(R.id.cl_show_subscription_information);
                            k.a((Object) findViewById6, "view.findViewById<View>(…subscription_information)");
                            findViewById6.setVisibility(0);
                        } else if (k.a((Object) this.f43492e, (Object) DirectFormItemType.CANCEL)) {
                            View findViewById7 = inflate.findViewById(R.id.cl_cancel_subscription);
                            k.a((Object) findViewById7, "view.findViewById<View>(…d.cl_cancel_subscription)");
                            findViewById7.setVisibility(0);
                            View findViewById8 = inflate.findViewById(R.id.cl_show_subscription_information);
                            k.a((Object) findViewById8, "view.findViewById<View>(…subscription_information)");
                            findViewById8.setVisibility(8);
                        }
                        return inflate;
                    }
                    throw new u("null cannot be cast to non-null type android.view.View");
                }
                throw new u("null cannot be cast to non-null type android.widget.ImageView");
            }
            throw new u("null cannot be cast to non-null type com.paytm.utility.RoboTextView");
        }
        throw new u("null cannot be cast to non-null type com.paytm.utility.RoboTextView");
    }

    static final class b implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ c f43494a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ RoboTextView f43495b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ View f43496c;

        b(c cVar, RoboTextView roboTextView, View view) {
            this.f43494a = cVar;
            this.f43495b = roboTextView;
            this.f43496c = view;
        }

        public final void run() {
            Rect rect = new Rect();
            this.f43495b.getHitRect(rect);
            Resources resources = this.f43494a.getResources();
            k.a((Object) resources, "resources");
            int applyDimension = (int) TypedValue.applyDimension(1, 20.0f, resources.getDisplayMetrics());
            rect.top -= applyDimension;
            rect.left -= applyDimension;
            rect.bottom += applyDimension;
            rect.right += applyDimension;
            this.f43496c.setTouchDelegate(new TouchDelegate(rect, this.f43495b));
        }
    }

    public final void onActivityCreated(Bundle bundle) {
        Resources resources;
        String str;
        Resources resources2;
        super.onActivityCreated(bundle);
        if (getActivity() != null) {
            Activity activity = getActivity();
            RoboTextView roboTextView = this.f43490c;
            String str2 = null;
            if (roboTextView != null) {
                if (activity == null || (resources2 = activity.getResources()) == null) {
                    str = null;
                } else {
                    int i2 = R.string.active_subscription_information_content;
                    Object[] objArr = new Object[2];
                    ActiveSubscriptionDetailsItem activeSubscriptionDetailsItem = this.f43489b;
                    objArr[0] = activeSubscriptionDetailsItem != null ? activeSubscriptionDetailsItem.getMerchantName() : null;
                    ActiveSubscriptionDetailsItem activeSubscriptionDetailsItem2 = this.f43489b;
                    objArr[1] = activeSubscriptionDetailsItem2 != null ? activeSubscriptionDetailsItem2.getMerchantName() : null;
                    str = resources2.getString(i2, objArr);
                }
                roboTextView.setText(str);
            }
            RoboTextView roboTextView2 = this.f43491d;
            if (roboTextView2 != null) {
                if (!(activity == null || (resources = activity.getResources()) == null)) {
                    int i3 = R.string.subscription_cancel_title;
                    Object[] objArr2 = new Object[1];
                    ActiveSubscriptionDetailsItem activeSubscriptionDetailsItem3 = this.f43489b;
                    if (activeSubscriptionDetailsItem3 != null) {
                        str2 = activeSubscriptionDetailsItem3.getMerchantName();
                    }
                    objArr2[0] = str2;
                    str2 = resources.getString(i3, objArr2);
                }
                roboTextView2.setText(str2);
            }
        }
    }

    public final void onClick(View view) {
        k.c(view, "v");
        int id = view.getId();
        if (id == R.id.btn_cancel_subscription_confirmation) {
            Fragment parentFragment = getParentFragment();
            FragmentActivity activity = parentFragment != null ? parentFragment.getActivity() : null;
            if (activity != null) {
                ((ActiveSubscriptionActivity) activity).callEditSubscriptionAPI(TransactionType.CANCEL);
            } else {
                throw new u("null cannot be cast to non-null type com.paytm.paymentsettings.merchantSubscriptions.view.ActiveSubscriptionActivity");
            }
        } else if (!(id == R.id.tv_cancel_subscription_denial || id == R.id.iv_dismiss_active_subscription_bottom_sheet)) {
            return;
        }
        dismiss();
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }

        public static c a(ActiveSubscriptionDetailsItem activeSubscriptionDetailsItem, String str) {
            k.c(activeSubscriptionDetailsItem, "item");
            c cVar = new c();
            Bundle bundle = new Bundle();
            bundle.putSerializable("item", activeSubscriptionDetailsItem);
            bundle.putString("tag", str);
            cVar.setArguments(bundle);
            return cVar;
        }
    }

    public final /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        HashMap hashMap = this.f43493f;
        if (hashMap != null) {
            hashMap.clear();
        }
    }
}
