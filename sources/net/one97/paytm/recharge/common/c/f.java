package net.one97.paytm.recharge.common.c;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.j;
import androidx.fragment.app.q;
import java.util.HashMap;
import kotlin.g.b.k;
import kotlin.m.p;
import kotlin.u;
import net.one97.paytm.recharge.R;
import net.one97.paytm.recharge.common.a.w;
import net.one97.paytm.recharge.common.widget.CJRAmountView;
import net.one97.paytm.recharge.model.rechargeutility.CJRBrowsePlanProductList;
import net.one97.paytm.recharge.widgets.widget.CJRProceedWidgetV8;

public final class f extends net.one97.paytm.i.f implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public static final a f60991a = new a((byte) 0);
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public static final String f60992d;

    /* renamed from: b  reason: collision with root package name */
    private final CJRBrowsePlanProductList f60993b;

    /* renamed from: c  reason: collision with root package name */
    private final w.b f60994c;

    /* renamed from: e  reason: collision with root package name */
    private HashMap f60995e;

    private View a(int i2) {
        if (this.f60995e == null) {
            this.f60995e = new HashMap();
        }
        View view = (View) this.f60995e.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View view2 = getView();
        if (view2 == null) {
            return null;
        }
        View findViewById = view2.findViewById(i2);
        this.f60995e.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    public f(CJRBrowsePlanProductList cJRBrowsePlanProductList, w.b bVar) {
        k.c(cJRBrowsePlanProductList, "mSelectedPlanItem");
        k.c(bVar, "mSelectedPlanClickListner");
        this.f60993b = cJRBrowsePlanProductList;
        this.f60994c = bVar;
    }

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b2) {
            this();
        }
    }

    static {
        String simpleName = f.class.getSimpleName();
        k.a((Object) simpleName, "FJRBBBrowsePlanBottomSheet::class.java.simpleName");
        f60992d = simpleName;
    }

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setStyle(0, R.style.CustomOredrSummaryBottomSheetDialogTheme);
    }

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        k.c(layoutInflater, "inflater");
        return layoutInflater.inflate(R.layout.v8_browseplan_detail_sheet, viewGroup, false);
    }

    public final void onViewCreated(View view, Bundle bundle) {
        k.c(view, "view");
        CJRAmountView cJRAmountView = (CJRAmountView) view.findViewById(R.id.price_Text);
        if (!TextUtils.isEmpty(this.f60993b.getValidity())) {
            String validity = this.f60993b.getValidity();
            k.a((Object) validity, "mSelectedPlanItem.validity");
            if (validity != null) {
                String upperCase = validity.toUpperCase();
                k.a((Object) upperCase, "(this as java.lang.String).toUpperCase()");
                if (!upperCase.equals("NA")) {
                    TextView textView = (TextView) a(R.id.validity_days_txt);
                    k.a((Object) textView, "validity_days_txt");
                    textView.setVisibility(8);
                    TextView textView2 = (TextView) a(R.id.validity_days_txt);
                    k.a((Object) textView2, "validity_days_txt");
                    textView2.setText(getString(R.string.txt_with_validity, this.f60993b.getValidity()));
                }
            } else {
                throw new u("null cannot be cast to non-null type java.lang.String");
            }
        }
        cJRAmountView.setText(String.valueOf(this.f60993b.getPrice().doubleValue()));
        if (!TextUtils.isEmpty(this.f60993b.getData()) || !TextUtils.isEmpty(this.f60993b.getTalktime()) || !TextUtils.isEmpty(this.f60993b.getSms())) {
            LinearLayout linearLayout = (LinearLayout) a(R.id.type_2_layout);
            k.a((Object) linearLayout, "type_2_layout");
            linearLayout.setVisibility(0);
            if (!TextUtils.isEmpty(this.f60993b.getData())) {
                String data = this.f60993b.getData();
                k.a((Object) data, "mSelectedPlanItem.data");
                if (data != null) {
                    String upperCase2 = data.toUpperCase();
                    k.a((Object) upperCase2, "(this as java.lang.String).toUpperCase()");
                    if (!upperCase2.equals("NA")) {
                        LinearLayout linearLayout2 = (LinearLayout) a(R.id.data_layout);
                        k.a((Object) linearLayout2, "data_layout");
                        linearLayout2.setVisibility(0);
                        TextView textView3 = (TextView) a(R.id.dataValidityText);
                        k.a((Object) textView3, "dataValidityText");
                        textView3.setText(this.f60993b.getData());
                    }
                } else {
                    throw new u("null cannot be cast to non-null type java.lang.String");
                }
            }
            if (!TextUtils.isEmpty(this.f60993b.getTalktime())) {
                String talktime = this.f60993b.getTalktime();
                k.a((Object) talktime, "mSelectedPlanItem.talktime");
                if (talktime != null) {
                    String upperCase3 = talktime.toUpperCase();
                    k.a((Object) upperCase3, "(this as java.lang.String).toUpperCase()");
                    if (!upperCase3.equals("NA") && !p.a("0", this.f60993b.getTalktime(), false)) {
                        LinearLayout linearLayout3 = (LinearLayout) a(R.id.talktime_layout);
                        k.a((Object) linearLayout3, "talktime_layout");
                        linearLayout3.setVisibility(0);
                        TextView textView4 = (TextView) a(R.id.talkTimeValidityText);
                        k.a((Object) textView4, "talkTimeValidityText");
                        textView4.setText(this.f60993b.getTalktime());
                    }
                } else {
                    throw new u("null cannot be cast to non-null type java.lang.String");
                }
            }
            if (!TextUtils.isEmpty(this.f60993b.getSms())) {
                String sms = this.f60993b.getSms();
                k.a((Object) sms, "mSelectedPlanItem.sms");
                if (sms != null) {
                    String upperCase4 = sms.toUpperCase();
                    k.a((Object) upperCase4, "(this as java.lang.String).toUpperCase()");
                    if (!upperCase4.equals("NA")) {
                        LinearLayout linearLayout4 = (LinearLayout) a(R.id.sms_layout);
                        k.a((Object) linearLayout4, "sms_layout");
                        linearLayout4.setVisibility(0);
                        TextView textView5 = (TextView) a(R.id.smsValidityText);
                        k.a((Object) textView5, "smsValidityText");
                        textView5.setText(this.f60993b.getSms());
                    }
                } else {
                    throw new u("null cannot be cast to non-null type java.lang.String");
                }
            }
        } else {
            LinearLayout linearLayout5 = (LinearLayout) a(R.id.type_2_layout);
            k.a((Object) linearLayout5, "type_2_layout");
            linearLayout5.setVisibility(8);
        }
        if (!TextUtils.isEmpty(this.f60993b.getDescription())) {
            TextView textView6 = (TextView) a(R.id.browseplan_description_title);
            k.a((Object) textView6, "browseplan_description_title");
            textView6.setVisibility(0);
            TextView textView7 = (TextView) a(R.id.browseplan_description);
            k.a((Object) textView7, "browseplan_description");
            textView7.setVisibility(0);
            TextView textView8 = (TextView) a(R.id.browseplan_description);
            k.a((Object) textView8, "browseplan_description");
            textView8.setText(this.f60993b.getDescription());
        }
        View.OnClickListener onClickListener = this;
        ((ImageView) a(R.id.close_button)).setOnClickListener(onClickListener);
        ((CJRProceedWidgetV8) a(R.id.select_plan_button)).setProceedBtnText(getString(R.string.btn_select_plan));
        ((CJRProceedWidgetV8) a(R.id.select_plan_button)).setOnClickListener(onClickListener);
    }

    public final void onClick(View view) {
        Integer valueOf = view != null ? Integer.valueOf(view.getId()) : null;
        ImageView imageView = (ImageView) a(R.id.close_button);
        k.a((Object) imageView, "close_button");
        int id = imageView.getId();
        if (valueOf != null && valueOf.intValue() == id) {
            dismiss();
            return;
        }
        CJRProceedWidgetV8 cJRProceedWidgetV8 = (CJRProceedWidgetV8) a(R.id.select_plan_button);
        k.a((Object) cJRProceedWidgetV8, "select_plan_button");
        int id2 = cJRProceedWidgetV8.getId();
        if (valueOf != null && valueOf.intValue() == id2) {
            dismiss();
            this.f60994c.b(this.f60993b);
        }
    }

    public final void show(j jVar, String str) {
        k.c(jVar, "manager");
        q a2 = jVar.a();
        k.a((Object) a2, "manager.beginTransaction()");
        a2.a((Fragment) this, str);
        a2.c();
    }

    public final /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        HashMap hashMap = this.f60995e;
        if (hashMap != null) {
            hashMap.clear();
        }
    }
}
