package net.one97.paytm.recharge.ordersummary.d;

import android.content.Context;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.transition.Slide;
import androidx.transition.Transition;
import androidx.transition.TransitionSet;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.utility.t;
import com.squareup.picasso.ah;
import com.squareup.picasso.e;
import com.squareup.picasso.w;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import kotlin.g.b.k;
import kotlin.u;
import net.one97.paytm.common.entity.shopping.CJROrderSummary;
import net.one97.paytm.common.entity.shopping.CJROrderSummaryProductDetail;
import net.one97.paytm.common.entity.shopping.CJROrderedCart;
import net.one97.paytm.common.entity.shopping.CJRRefund;
import net.one97.paytm.common.entity.shopping.CJRTransactionDetails;
import net.one97.paytm.recharge.R;
import net.one97.paytm.recharge.common.f.d;
import net.one97.paytm.recharge.common.utils.ba;
import net.one97.paytm.recharge.common.widget.CJRAmountView;
import net.one97.paytm.recharge.di.helper.CJRRechargeUtilities;
import net.one97.paytm.recharge.ordersummary.activity.AJRechargeOrderSummaryActivity;
import net.one97.paytm.recharge.ordersummary.c.i;
import net.one97.paytm.recharge.ordersummary.e.b;
import net.one97.paytm.recharge.ordersummary.f.l;
import net.one97.paytm.recharge.ordersummary.h.c;

public class g extends f {
    private a r = new a(this);
    private HashMap s;

    public final View a(int i2) {
        if (this.s == null) {
            this.s = new HashMap();
        }
        View view = (View) this.s.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View view2 = getView();
        if (view2 == null) {
            return null;
        }
        View findViewById = view2.findViewById(i2);
        this.s.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    public final void b() {
        HashMap hashMap = this.s;
        if (hashMap != null) {
            hashMap.clear();
        }
    }

    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        b();
    }

    public static final class a extends RecyclerView.a<b.a> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ g f64138a;

        a(g gVar) {
            this.f64138a = gVar;
        }

        public final /* synthetic */ void onBindViewHolder(RecyclerView.v vVar, int i2) {
            b.a aVar = (b.a) vVar;
            k.c(aVar, "holder");
            CJRRefund refund = this.f64138a.d().getRefund();
            k.a((Object) refund, "orderedItem.refund");
            CJRTransactionDetails cJRTransactionDetails = refund.getTransactionDetails().get(i2);
            k.a((Object) cJRTransactionDetails, "orderedItem.refund.transactionDetails[position]");
            CJRRefund refund2 = this.f64138a.d().getRefund();
            k.a((Object) refund2, "orderedItem.refund");
            aVar.a(aVar, cJRTransactionDetails, refund2);
        }

        public final /* synthetic */ RecyclerView.v onCreateViewHolder(ViewGroup viewGroup, int i2) {
            k.c(viewGroup, "parent");
            View inflate = LayoutInflater.from(this.f64138a.getContext()).inflate(R.layout.content_os_refund_status_list_item, viewGroup, false);
            k.a((Object) inflate, "LayoutInflater.from(cont…list_item, parent, false)");
            return new b.a(inflate, this.f64138a.r());
        }

        public final int getItemCount() {
            ArrayList<CJRTransactionDetails> transactionDetails;
            c.a aVar = net.one97.paytm.recharge.ordersummary.h.c.f64331a;
            CJRRefund refund = this.f64138a.d().getRefund();
            k.a((Object) refund, "orderedItem.refund");
            c.a.a(refund);
            CJRRefund refund2 = this.f64138a.d().getRefund();
            if (refund2 == null || (transactionDetails = refund2.getTransactionDetails()) == null) {
                return 0;
            }
            return transactionDetails.size();
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (!this.f64111a) {
            TransitionSet transitionSet = new TransitionSet();
            transitionSet.a((Transition) new Slide((byte) 0));
            transitionSet.a(375);
            setReturnTransition(transitionSet);
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        k.c(layoutInflater, "inflater");
        View inflate = layoutInflater.inflate(R.layout.content_base_os_failed_pending_v8, viewGroup, false);
        View findViewById = inflate.findViewById(R.id.status_recharge_item);
        if (findViewById != null) {
            LinearLayout linearLayout = (LinearLayout) findViewById;
            linearLayout.removeAllViews();
            k.a((Object) inflate, "rootView");
            LayoutInflater.from(inflate.getContext()).inflate(R.layout.content_os_insurance_cancelled_v8, linearLayout, true);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
            layoutParams.leftMargin = com.paytm.utility.b.c(8);
            layoutParams.rightMargin = com.paytm.utility.b.c(8);
            layoutParams.bottomMargin = com.paytm.utility.b.c(8);
            View findViewById2 = inflate.findViewById(R.id.status_main);
            if (findViewById2 != null) {
                LinearLayout linearLayout2 = (LinearLayout) findViewById2;
                View inflate2 = LayoutInflater.from(inflate.getContext()).inflate(R.layout.content_os_order_actions_item, linearLayout2, false);
                k.a((Object) inflate2, "needHelpView");
                inflate2.setLayoutParams(layoutParams);
                inflate2.setOnClickListener(new c(this));
                linearLayout2.addView(inflate2);
                return inflate;
            }
            throw new u("null cannot be cast to non-null type android.widget.LinearLayout");
        }
        throw new u("null cannot be cast to non-null type android.widget.LinearLayout");
    }

    public static final class c implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ g f64140a;

        c(g gVar) {
            this.f64140a = gVar;
        }

        public final void onClick(View view) {
            g gVar = this.f64140a;
            gVar.f(gVar.d());
        }
    }

    public void onActivityCreated(Bundle bundle) {
        o();
        super.onActivityCreated(bundle);
    }

    /* access modifiers changed from: protected */
    public final void g() {
        String str;
        String str2;
        String merchantName;
        View view = getView();
        if (view == null) {
            k.a();
        }
        TextView textView = (TextView) view.findViewById(R.id.txt_status_header);
        View view2 = getView();
        if (view2 == null) {
            k.a();
        }
        ImageView imageView = (ImageView) view2.findViewById(R.id.operator_logo);
        View view3 = getView();
        if (view3 == null) {
            k.a();
        }
        TextView textView2 = (TextView) view3.findViewById(R.id.operator_name);
        View view4 = getView();
        if (view4 == null) {
            k.a();
        }
        TextView textView3 = (TextView) view4.findViewById(R.id.recharge_order_id);
        View view5 = getView();
        if (view5 == null) {
            k.a();
        }
        TextView textView4 = (TextView) view5.findViewById(R.id.recharge_order_time);
        View view6 = getView();
        if (view6 == null) {
            k.a();
        }
        CJRAmountView cJRAmountView = (CJRAmountView) view6.findViewById(R.id.total_amount);
        View view7 = getView();
        if (view7 == null) {
            k.a();
        }
        RecyclerView recyclerView = (RecyclerView) view7.findViewById(R.id.lyt_refund_items);
        View view8 = getView();
        if (view8 == null) {
            k.a();
        }
        TextView textView5 = (TextView) view8.findViewById(R.id.refund_note);
        View view9 = getView();
        if (view9 == null) {
            k.a();
        }
        ImageView imageView2 = (ImageView) view9.findViewById(R.id.icon_order_optn);
        View view10 = getView();
        if (view10 == null) {
            k.a();
        }
        TextView textView6 = (TextView) view10.findViewById(R.id.txt_order_optn);
        View view11 = getView();
        if (view11 == null) {
            k.a();
        }
        ImageView imageView3 = (ImageView) view11.findViewById(R.id.action_next_order_optn);
        View view12 = getView();
        if (view12 == null) {
            k.a();
        }
        View findViewById = view12.findViewById(R.id.divider_order_optn);
        View view13 = getView();
        if (view13 == null) {
            k.a();
        }
        View findViewById2 = view13.findViewById(R.id.divider_order_actions);
        View view14 = getView();
        if (view14 == null) {
            k.a();
        }
        view14.findViewById(R.id.divider);
        Context context = getContext();
        if (!(context instanceof AJRechargeOrderSummaryActivity)) {
            context = null;
        }
        AJRechargeOrderSummaryActivity aJRechargeOrderSummaryActivity = (AJRechargeOrderSummaryActivity) context;
        if (aJRechargeOrderSummaryActivity != null) {
            aJRechargeOrderSummaryActivity.b();
        }
        net.one97.paytm.recharge.di.helper.c cVar = net.one97.paytm.recharge.di.helper.c.f62654a;
        HashMap<String, String> bn = net.one97.paytm.recharge.di.helper.c.bn();
        CJROrderSummaryProductDetail productDetail = d().getProductDetail();
        String str3 = "";
        if (productDetail == null || (str = String.valueOf(productDetail.getVerticalId())) == null) {
            str = str3;
        }
        View view15 = findViewById2;
        TextView textView7 = textView5;
        View view16 = findViewById;
        ImageView imageView4 = imageView3;
        if (TextUtils.isEmpty(str) || bn == null || !bn.containsKey(str)) {
            k.a((Object) textView, "statusHeader");
            String string = getString(R.string.v8_os_status_item_cancelled);
            k.a((Object) string, "getString(R.string.v8_os_status_item_cancelled)");
            if (string != null) {
                String upperCase = string.toUpperCase();
                k.a((Object) upperCase, "(this as java.lang.String).toUpperCase()");
                textView.setText(upperCase);
            } else {
                throw new u("null cannot be cast to non-null type java.lang.String");
            }
        } else {
            k.a((Object) textView, "statusHeader");
            String string2 = getString(R.string.v8_os_header_title_Canceled_1, getString(R.string.v8_os_other_items_insurance_title));
            k.a((Object) string2, "getString(R.string.v8_os…r_items_insurance_title))");
            if (string2 != null) {
                String upperCase2 = string2.toUpperCase();
                k.a((Object) upperCase2, "(this as java.lang.String).toUpperCase()");
                textView.setText(upperCase2);
            } else {
                throw new u("null cannot be cast to non-null type java.lang.String");
            }
        }
        Context context2 = getContext();
        if (context2 == null) {
            k.a();
        }
        textView.setBackgroundColor(androidx.core.content.b.c(context2, R.color.recharge_order_cancelled));
        CJROrderSummaryProductDetail productDetail2 = d().getProductDetail();
        k.a((Object) textView2, "operatorName");
        int i2 = R.string.v8_os_order_details_other_insurance_Cancelled;
        Object[] objArr = new Object[1];
        c.a aVar = net.one97.paytm.recharge.ordersummary.h.c.f64331a;
        if (!(productDetail2 == null || (merchantName = productDetail2.getMerchantName()) == null)) {
            str3 = merchantName;
        }
        objArr[0] = c.a.a(str3);
        textView2.setText(getString(i2, objArr));
        k.a((Object) textView3, "rechargeOrderId");
        net.one97.paytm.recharge.ordersummary.b.a r2 = r();
        Context context3 = getContext();
        if (context3 == null) {
            k.a();
        }
        k.a((Object) context3, "context!!");
        textView3.setText(r2.o(context3));
        k.a((Object) textView4, "rechargeOrderTime");
        net.one97.paytm.recharge.ordersummary.b.a r3 = r();
        Context context4 = getContext();
        if (context4 == null) {
            k.a();
        }
        k.a((Object) context4, "context!!");
        textView4.setText(r3.n(context4));
        textView4.setVisibility(8);
        String c2 = r().c(d());
        if (!TextUtils.isEmpty(c2)) {
            try {
                w.a().a(c2).a((ah) new t.b((int) getResources().getDimension(R.dimen.dimen_34dp), 0, true)).a(R.color.color_ffffff).a(imageView, (e) new b(this));
            } catch (Exception unused) {
                Fragment parentFragment = getParentFragment();
                if (parentFragment != null) {
                    parentFragment.startPostponedEnterTransition();
                }
            }
        } else {
            Fragment parentFragment2 = getParentFragment();
            if (parentFragment2 != null) {
                parentFragment2.startPostponedEnterTransition();
            }
        }
        CJRRefund refund = d().getRefund();
        if (refund == null || (str2 = String.valueOf(refund.getTotalRefund())) == null) {
            str2 = String.valueOf(d().getRefundAmount());
        }
        cJRAmountView.setText(ba.a(str2, true));
        k.a((Object) recyclerView, "lytRefundItems");
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(this.r);
        if (d().getRefund() != null) {
            w();
            CJRRefund refund2 = d().getRefund();
            k.a((Object) refund2, "orderedItem.refund");
            if (refund2.getTransactionDetails() != null) {
                CJRRefund refund3 = d().getRefund();
                k.a((Object) refund3, "orderedItem.refund");
                if (refund3.getTransactionDetails().size() > 0) {
                    recyclerView.setVisibility(0);
                }
            }
            CJRRechargeUtilities.INSTANCE.debugLog("InsuranceDetails : inflateView : has refund description : no trxn detail");
            b((l) this);
            recyclerView.setVisibility(8);
        } else {
            CJRRechargeUtilities.INSTANCE.debugLog("InsuranceDetails : inflateView : has no refund");
            b((l) this);
        }
        imageView2.setImageResource(R.drawable.ic_os_action_24x7_help);
        k.a((Object) textView6, "txtView");
        textView6.setText(getString(R.string.v8_os_order_option_help));
        ImageView imageView5 = imageView4;
        k.a((Object) imageView5, "actionNext");
        imageView5.setVisibility(8);
        View view17 = view16;
        k.a((Object) view17, "dividerView");
        view17.setVisibility(8);
        TextView textView8 = textView7;
        k.a((Object) textView8, "refundNote");
        if (textView8.getVisibility() == 0 || recyclerView.getVisibility() == 0) {
            View view18 = view15;
            k.a((Object) view18, "dividerAction");
            view18.setVisibility(0);
            return;
        }
        View view19 = view15;
        k.a((Object) view19, "dividerAction");
        view19.setVisibility(8);
    }

    public static final class b implements e {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ g f64139a;

        b(g gVar) {
            this.f64139a = gVar;
        }

        public final void onSuccess() {
            Fragment parentFragment = this.f64139a.getParentFragment();
            if (parentFragment != null) {
                parentFragment.startPostponedEnterTransition();
            }
        }

        public final void onError(Exception exc) {
            k.c(exc, "e");
            Fragment parentFragment = this.f64139a.getParentFragment();
            if (parentFragment != null) {
                parentFragment.startPostponedEnterTransition();
            }
        }
    }

    private final void w() {
        net.one97.paytm.recharge.ordersummary.b.a r2 = r();
        Context context = getContext();
        if (context == null) {
            k.a();
        }
        k.a((Object) context, "context!!");
        String a2 = r2.a(context, d().getRefund());
        if (!TextUtils.isEmpty(a2)) {
            Context context2 = getContext();
            if (context2 == null) {
                k.a();
            }
            String string = context2.getString(R.string.v8_os_info_note);
            k.a((Object) string, "context!!.getString(R.string.v8_os_info_note)");
            SpannableString spannableString = new SpannableString(string + ' ' + a2);
            Context context3 = getContext();
            if (context3 == null) {
                k.a();
            }
            spannableString.setSpan(new ForegroundColorSpan(androidx.core.content.b.c(context3, R.color.recharge_506d85)), 0, string.length(), 33);
            spannableString.setSpan(new StyleSpan(1), 0, string.length(), 33);
            TextView textView = (TextView) a(R.id.refund_note);
            k.a((Object) textView, "refund_note");
            textView.setText(spannableString);
            TextView textView2 = (TextView) a(R.id.refund_note);
            k.a((Object) textView2, "refund_note");
            textView2.setVisibility(0);
        }
    }

    public final void a(CJROrderSummary cJROrderSummary) {
        boolean z;
        ArrayList<CJRTransactionDetails> arrayList;
        Object obj;
        boolean z2;
        k.c(cJROrderSummary, "orderSummary");
        if (getActivity() != null && getContext() != null && isAdded()) {
            ArrayList<CJROrderedCart> orderedCartList = cJROrderSummary.getOrderedCartList();
            k.a((Object) orderedCartList, "orderSummary.orderedCartList");
            Iterator it2 = orderedCartList.iterator();
            while (true) {
                z = true;
                arrayList = null;
                if (!it2.hasNext()) {
                    obj = null;
                    break;
                }
                obj = it2.next();
                CJROrderedCart cJROrderedCart = (CJROrderedCart) obj;
                k.a((Object) cJROrderedCart, "it");
                if (cJROrderedCart.getId() == d().getId()) {
                    z2 = true;
                    continue;
                } else {
                    z2 = false;
                    continue;
                }
                if (z2) {
                    break;
                }
            }
            CJROrderedCart cJROrderedCart2 = (CJROrderedCart) obj;
            if (cJROrderedCart2 == null) {
                super.a(cJROrderSummary);
            } else if (r().a((IJRPaytmDataModel) k(), cJROrderedCart2)) {
                a(cJROrderedCart2);
                w();
                CJRRefund refund = cJROrderedCart2.getRefund();
                if (refund != null) {
                    arrayList = refund.getTransactionDetails();
                }
                Collection collection = arrayList;
                if (collection != null && !collection.isEmpty()) {
                    z = false;
                }
                if (z) {
                    CJRRechargeUtilities.INSTANCE.debugLog("onOrderSummaryLoaded : has refund description & no trxn detail");
                    b((l) this);
                } else {
                    CJRRechargeUtilities.INSTANCE.debugLog("onOrderSummaryLoaded : has refund description & trxn detail");
                    RecyclerView recyclerView = (RecyclerView) a(R.id.lyt_refund_items);
                    k.a((Object) recyclerView, "lyt_refund_items");
                    recyclerView.setVisibility(0);
                }
                this.r.notifyDataSetChanged();
            } else {
                CJRRechargeUtilities.INSTANCE.debugLog("onOrderSummaryLoaded : has no refund description");
                b((l) this);
            }
        }
    }

    public final boolean ax_() {
        if (getContext() == null) {
            k.a();
        }
        if (d.a() == null) {
            return false;
        }
        if (getContext() == null) {
            k.a();
        }
        d.a();
        Context context = getContext();
        if (context == null) {
            k.a();
        }
        d.a(context, "order_detail_request");
        return false;
    }

    /* access modifiers changed from: protected */
    public final void h() {
        i iVar = this.m;
        if (iVar != null) {
            iVar.f64077c = false;
        }
    }
}
