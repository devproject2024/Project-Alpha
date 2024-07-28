package net.one97.paytm.recharge.common.d;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.paytm.business.merchantprofile.view.RequestConfirmationDialogFragment;
import java.util.List;
import kotlin.g.b.k;
import kotlin.m.p;
import kotlin.u;
import net.one97.paytm.recharge.R;
import net.one97.paytm.recharge.common.a.w;
import net.one97.paytm.recharge.common.widget.CJRAmountView;
import net.one97.paytm.recharge.model.rechargeutility.CJRBrowsePlanProductList;

public class e extends w.a {

    /* renamed from: a  reason: collision with root package name */
    View f61032a;

    /* renamed from: b  reason: collision with root package name */
    LinearLayout f61033b;

    /* renamed from: c  reason: collision with root package name */
    final LinearLayout f61034c;

    /* renamed from: d  reason: collision with root package name */
    final TextView f61035d;

    /* renamed from: e  reason: collision with root package name */
    final LinearLayout f61036e;

    /* renamed from: f  reason: collision with root package name */
    final List<CJRBrowsePlanProductList> f61037f;

    /* renamed from: g  reason: collision with root package name */
    private CJRAmountView f61038g;

    /* renamed from: h  reason: collision with root package name */
    private TextView f61039h;

    /* renamed from: i  reason: collision with root package name */
    private TextView f61040i;
    private final TextView j;
    private final TextView k;
    private final TextView l;
    private final LinearLayout m;
    private final LinearLayout n;
    private final LinearLayout o;
    private final TextView p;
    private final TextView q;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public e(View view, final w.b bVar, List<? extends CJRBrowsePlanProductList> list) {
        super(view);
        k.c(view, "view");
        k.c(bVar, "mItemClickListner");
        k.c(list, "productList");
        this.f61037f = list;
        this.f61032a = view.findViewById(R.id.divider);
        this.f61033b = (LinearLayout) view.findViewById(R.id.type_2_layout);
        this.f61038g = (CJRAmountView) view.findViewById(R.id.price_Text);
        this.f61039h = (TextView) view.findViewById(R.id.dataValidityText);
        this.f61040i = (TextView) view.findViewById(R.id.smsValidityText);
        this.j = (TextView) view.findViewById(R.id.selectText);
        this.k = (TextView) view.findViewById(R.id.full_talk_time_value2);
        this.f61034c = (LinearLayout) view.findViewById(R.id.layout_only_description);
        this.l = (TextView) view.findViewById(R.id.description);
        this.m = (LinearLayout) view.findViewById(R.id.data_layout);
        this.n = (LinearLayout) view.findViewById(R.id.sms_layout);
        this.o = (LinearLayout) view.findViewById(R.id.talktime_layout);
        this.p = (TextView) view.findViewById(R.id.full_talktime_title);
        this.q = (TextView) view.findViewById(R.id.full_talktime_validity);
        this.f61035d = (TextView) view.findViewById(R.id.talk_timeValidity_without_title);
        this.f61036e = (LinearLayout) view.findViewById(R.id.talktime_with_validity_layout);
        view.setOnClickListener(new View.OnClickListener(this) {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ e f61041a;

            {
                this.f61041a = r1;
            }

            public final void onClick(View view) {
                if (this.f61041a.getAdapterPosition() >= 0) {
                    bVar.b(this.f61041a.f61037f.get(this.f61041a.getAdapterPosition()));
                }
            }
        });
        this.f61034c.setOnClickListener(new View.OnClickListener(this) {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ e f61043a;

            {
                this.f61043a = r1;
            }

            public final void onClick(View view) {
                if (this.f61043a.getAdapterPosition() >= 0) {
                    bVar.a(this.f61043a.f61037f.get(this.f61043a.getAdapterPosition()));
                }
            }
        });
    }

    public void a(int i2, CJRBrowsePlanProductList cJRBrowsePlanProductList) {
        k.c(cJRBrowsePlanProductList, "product");
        LinearLayout linearLayout = this.f61036e;
        k.a((Object) linearLayout, "talkTimeWithValidityLayout");
        linearLayout.setVisibility(8);
        TextView textView = this.q;
        k.a((Object) textView, "fulltalkTimeValueWithHeader");
        textView.setVisibility(8);
        LinearLayout linearLayout2 = this.f61034c;
        k.a((Object) linearLayout2, "layout_only_description");
        linearLayout2.setVisibility(8);
        TextView textView2 = this.l;
        k.a((Object) textView2, RequestConfirmationDialogFragment.KEY_DESCRIPTION);
        textView2.setVisibility(8);
        TextView textView3 = this.p;
        k.a((Object) textView3, "fullTalktimeTitle");
        textView3.setVisibility(8);
        TextView textView4 = this.f61035d;
        k.a((Object) textView4, "talkTimeValidityWithoutTitle");
        textView4.setVisibility(8);
        LinearLayout linearLayout3 = this.f61033b;
        k.a((Object) linearLayout3, "parentContainerOfDataSmsTalkTime");
        linearLayout3.setVisibility(8);
        LinearLayout linearLayout4 = this.m;
        k.a((Object) linearLayout4, "data_layout");
        linearLayout4.setVisibility(8);
        LinearLayout linearLayout5 = this.n;
        k.a((Object) linearLayout5, "sms_layout");
        linearLayout5.setVisibility(8);
        LinearLayout linearLayout6 = this.o;
        k.a((Object) linearLayout6, "talktime_layout");
        linearLayout6.setVisibility(8);
        this.f61038g.setText(String.valueOf(cJRBrowsePlanProductList.getPrice().doubleValue()));
        if (!TextUtils.isEmpty(cJRBrowsePlanProductList.getData()) || !TextUtils.isEmpty(cJRBrowsePlanProductList.getSms()) || !TextUtils.isEmpty(cJRBrowsePlanProductList.getTalktime()) || !TextUtils.isEmpty(cJRBrowsePlanProductList.getDescription())) {
            if (!TextUtils.isEmpty(cJRBrowsePlanProductList.getData()) || !TextUtils.isEmpty(cJRBrowsePlanProductList.getSms()) || !TextUtils.isEmpty(cJRBrowsePlanProductList.getTalktime())) {
                if (!TextUtils.isEmpty(cJRBrowsePlanProductList.getDescription())) {
                    LinearLayout linearLayout7 = this.f61034c;
                    k.a((Object) linearLayout7, "layout_only_description");
                    linearLayout7.setVisibility(0);
                    TextView textView5 = this.l;
                    k.a((Object) textView5, RequestConfirmationDialogFragment.KEY_DESCRIPTION);
                    textView5.setVisibility(0);
                    TextView textView6 = this.l;
                    k.a((Object) textView6, RequestConfirmationDialogFragment.KEY_DESCRIPTION);
                    textView6.setText(cJRBrowsePlanProductList.getDescription());
                    TextView textView7 = this.p;
                    k.a((Object) textView7, "fullTalktimeTitle");
                    textView7.setVisibility(0);
                    TextView textView8 = this.p;
                    k.a((Object) textView8, "fullTalktimeTitle");
                    textView8.setText(cJRBrowsePlanProductList.getDescription());
                } else {
                    TextView textView9 = this.l;
                    k.a((Object) textView9, RequestConfirmationDialogFragment.KEY_DESCRIPTION);
                    textView9.setVisibility(8);
                    TextView textView10 = this.p;
                    k.a((Object) textView10, "fullTalktimeTitle");
                    textView10.setVisibility(8);
                    LinearLayout linearLayout8 = this.f61034c;
                    k.a((Object) linearLayout8, "layout_only_description");
                    linearLayout8.setVisibility(8);
                }
                if (!TextUtils.isEmpty(cJRBrowsePlanProductList.getData())) {
                    String data = cJRBrowsePlanProductList.getData();
                    k.a((Object) data, "product.data");
                    if (data != null) {
                        String upperCase = data.toUpperCase();
                        k.a((Object) upperCase, "(this as java.lang.String).toUpperCase()");
                        if (!upperCase.equals("NA")) {
                            LinearLayout linearLayout9 = this.f61033b;
                            k.a((Object) linearLayout9, "parentContainerOfDataSmsTalkTime");
                            linearLayout9.setVisibility(0);
                            LinearLayout linearLayout10 = this.m;
                            k.a((Object) linearLayout10, "data_layout");
                            linearLayout10.setVisibility(0);
                            TextView textView11 = this.f61039h;
                            k.a((Object) textView11, "dataValidityText");
                            textView11.setText(cJRBrowsePlanProductList.getData());
                        }
                    } else {
                        throw new u("null cannot be cast to non-null type java.lang.String");
                    }
                }
                if (!TextUtils.isEmpty(cJRBrowsePlanProductList.getSms())) {
                    String sms = cJRBrowsePlanProductList.getSms();
                    k.a((Object) sms, "product.sms");
                    if (sms != null) {
                        String upperCase2 = sms.toUpperCase();
                        k.a((Object) upperCase2, "(this as java.lang.String).toUpperCase()");
                        if (!upperCase2.equals("NA")) {
                            LinearLayout linearLayout11 = this.f61033b;
                            k.a((Object) linearLayout11, "parentContainerOfDataSmsTalkTime");
                            linearLayout11.setVisibility(0);
                            LinearLayout linearLayout12 = this.n;
                            k.a((Object) linearLayout12, "sms_layout");
                            linearLayout12.setVisibility(0);
                            TextView textView12 = this.f61040i;
                            k.a((Object) textView12, "smsValidityText");
                            textView12.setText(cJRBrowsePlanProductList.getSms());
                        }
                    } else {
                        throw new u("null cannot be cast to non-null type java.lang.String");
                    }
                }
                if (!TextUtils.isEmpty(cJRBrowsePlanProductList.getTalktime())) {
                    String talktime = cJRBrowsePlanProductList.getTalktime();
                    k.a((Object) talktime, "product.talktime");
                    if (talktime != null) {
                        String upperCase3 = talktime.toUpperCase();
                        k.a((Object) upperCase3, "(this as java.lang.String).toUpperCase()");
                        if (!upperCase3.equals("NA") && !p.a("0", cJRBrowsePlanProductList.getTalktime(), false)) {
                            LinearLayout linearLayout13 = this.f61033b;
                            k.a((Object) linearLayout13, "parentContainerOfDataSmsTalkTime");
                            linearLayout13.setVisibility(0);
                            LinearLayout linearLayout14 = this.o;
                            k.a((Object) linearLayout14, "talktime_layout");
                            linearLayout14.setVisibility(0);
                            TextView textView13 = this.k;
                            k.a((Object) textView13, "fullTalkTimeValue");
                            textView13.setText(cJRBrowsePlanProductList.getTalktime());
                        }
                    } else {
                        throw new u("null cannot be cast to non-null type java.lang.String");
                    }
                }
                if (!TextUtils.isEmpty(cJRBrowsePlanProductList.getValidity())) {
                    String validity = cJRBrowsePlanProductList.getValidity();
                    k.a((Object) validity, "product.validity");
                    if (validity != null) {
                        String upperCase4 = validity.toUpperCase();
                        k.a((Object) upperCase4, "(this as java.lang.String).toUpperCase()");
                        if (!upperCase4.equals("NA")) {
                            TextView textView14 = this.f61035d;
                            k.a((Object) textView14, "talkTimeValidityWithoutTitle");
                            textView14.setVisibility(0);
                            TextView textView15 = this.q;
                            k.a((Object) textView15, "fulltalkTimeValueWithHeader");
                            textView15.setVisibility(0);
                            TextView textView16 = this.q;
                            k.a((Object) textView16, "fulltalkTimeValueWithHeader");
                            View view = this.itemView;
                            k.a((Object) view, "itemView");
                            Context context = view.getContext();
                            k.a((Object) context, "itemView.context");
                            textView16.setText(context.getResources().getString(R.string.txt_with_validity, new Object[]{cJRBrowsePlanProductList.getValidity()}));
                            TextView textView17 = this.f61035d;
                            k.a((Object) textView17, "talkTimeValidityWithoutTitle");
                            View view2 = this.itemView;
                            k.a((Object) view2, "itemView");
                            Context context2 = view2.getContext();
                            k.a((Object) context2, "itemView.context");
                            textView17.setText(context2.getResources().getString(R.string.txt_with_validity, new Object[]{cJRBrowsePlanProductList.getValidity()}));
                            return;
                        }
                        return;
                    }
                    throw new u("null cannot be cast to non-null type java.lang.String");
                }
                return;
            }
            LinearLayout linearLayout15 = this.f61033b;
            k.a((Object) linearLayout15, "parentContainerOfDataSmsTalkTime");
            linearLayout15.setVisibility(8);
            if (!TextUtils.isEmpty(cJRBrowsePlanProductList.getDescription())) {
                LinearLayout linearLayout16 = this.f61034c;
                k.a((Object) linearLayout16, "layout_only_description");
                linearLayout16.setVisibility(0);
                TextView textView18 = this.l;
                k.a((Object) textView18, RequestConfirmationDialogFragment.KEY_DESCRIPTION);
                textView18.setVisibility(0);
                TextView textView19 = this.l;
                k.a((Object) textView19, RequestConfirmationDialogFragment.KEY_DESCRIPTION);
                textView19.setText(cJRBrowsePlanProductList.getDescription());
                TextView textView20 = this.p;
                k.a((Object) textView20, "fullTalktimeTitle");
                textView20.setVisibility(0);
                TextView textView21 = this.p;
                k.a((Object) textView21, "fullTalktimeTitle");
                textView21.setText(cJRBrowsePlanProductList.getDescription());
            } else {
                TextView textView22 = this.l;
                k.a((Object) textView22, RequestConfirmationDialogFragment.KEY_DESCRIPTION);
                textView22.setVisibility(8);
                TextView textView23 = this.p;
                k.a((Object) textView23, "fullTalktimeTitle");
                textView23.setVisibility(8);
                LinearLayout linearLayout17 = this.f61034c;
                k.a((Object) linearLayout17, "layout_only_description");
                linearLayout17.setVisibility(8);
            }
            if (!TextUtils.isEmpty(cJRBrowsePlanProductList.getValidity())) {
                TextView textView24 = this.f61035d;
                k.a((Object) textView24, "talkTimeValidityWithoutTitle");
                textView24.setVisibility(0);
                LinearLayout linearLayout18 = this.f61036e;
                k.a((Object) linearLayout18, "talkTimeWithValidityLayout");
                linearLayout18.setVisibility(8);
                TextView textView25 = this.q;
                k.a((Object) textView25, "fulltalkTimeValueWithHeader");
                textView25.setVisibility(0);
                TextView textView26 = this.q;
                k.a((Object) textView26, "fulltalkTimeValueWithHeader");
                View view3 = this.itemView;
                k.a((Object) view3, "itemView");
                Context context3 = view3.getContext();
                k.a((Object) context3, "itemView.context");
                textView26.setText(context3.getResources().getString(R.string.txt_with_validity, new Object[]{cJRBrowsePlanProductList.getValidity()}));
                TextView textView27 = this.f61035d;
                k.a((Object) textView27, "talkTimeValidityWithoutTitle");
                View view4 = this.itemView;
                k.a((Object) view4, "itemView");
                Context context4 = view4.getContext();
                k.a((Object) context4, "itemView.context");
                textView27.setText(context4.getResources().getString(R.string.txt_with_validity, new Object[]{cJRBrowsePlanProductList.getValidity()}));
            }
        } else if (!TextUtils.isEmpty(cJRBrowsePlanProductList.getValidity())) {
            TextView textView28 = this.f61035d;
            k.a((Object) textView28, "talkTimeValidityWithoutTitle");
            textView28.setVisibility(8);
            LinearLayout linearLayout19 = this.f61036e;
            k.a((Object) linearLayout19, "talkTimeWithValidityLayout");
            linearLayout19.setVisibility(0);
            TextView textView29 = this.q;
            k.a((Object) textView29, "fulltalkTimeValueWithHeader");
            textView29.setVisibility(0);
            TextView textView30 = this.q;
            k.a((Object) textView30, "fulltalkTimeValueWithHeader");
            View view5 = this.itemView;
            k.a((Object) view5, "itemView");
            Context context5 = view5.getContext();
            k.a((Object) context5, "itemView.context");
            textView30.setText(context5.getResources().getString(R.string.txt_with_validity, new Object[]{cJRBrowsePlanProductList.getValidity()}));
        }
    }
}
