package net.one97.paytm.passbook.genericPassbook.d.b;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import com.paytm.utility.v;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import kotlin.g.b.aa;
import kotlin.g.b.k;
import kotlin.g.b.x;
import kotlin.m.l;
import kotlin.m.p;
import kotlin.u;
import net.one97.paytm.i.h;
import net.one97.paytm.passbook.R;
import net.one97.paytm.passbook.beans.GiftVoucherListResponse;
import net.one97.paytm.passbook.beans.GiftVoucherResponseData;
import net.one97.paytm.passbook.beans.SubwalletStatusResponseList;
import net.one97.paytm.passbook.genericPassbook.activity.PassbookL2Activity;
import net.one97.paytm.passbook.genericPassbook.d.a.e;
import net.one97.paytm.passbook.genericPassbook.fragment.PassbookL2Fragment;
import net.one97.paytm.passbook.giftVoucher.GiftVoucherRedeemActivity;
import net.one97.paytm.passbook.mapping.IJRDataModel;
import net.one97.paytm.passbook.mapping.a.g;
import net.one97.paytm.passbook.mapping.a.i;
import net.one97.paytm.passbook.mapping.f;

public final class a extends h {

    /* renamed from: a  reason: collision with root package name */
    private HashMap f57463a;

    static final class b implements g {

        /* renamed from: a  reason: collision with root package name */
        public static final b f57466a = new b();

        b() {
        }

        public final void onErrorResponse(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
        }
    }

    private View a(int i2) {
        if (this.f57463a == null) {
            this.f57463a = new HashMap();
        }
        View view = (View) this.f57463a.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View view2 = getView();
        if (view2 == null) {
            return null;
        }
        View findViewById = view2.findViewById(i2);
        this.f57463a.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    /* renamed from: net.one97.paytm.passbook.genericPassbook.d.b.a$a  reason: collision with other inner class name */
    static final class C1080a<T> implements i.a<IJRDataModel> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f57464a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ x.c f57465b;

        C1080a(a aVar, x.c cVar) {
            this.f57464a = aVar;
            this.f57465b = cVar;
        }

        public final /* synthetic */ void onResponse(Object obj) {
            IJRDataModel iJRDataModel = (IJRDataModel) obj;
            FragmentActivity activity = this.f57464a.getActivity();
            if (activity != null) {
                k.a((Object) activity, "it");
                if (!activity.isFinishing()) {
                    if (!(iJRDataModel instanceof GiftVoucherResponseData)) {
                        iJRDataModel = null;
                    }
                    GiftVoucherResponseData giftVoucherResponseData = (GiftVoucherResponseData) iJRDataModel;
                    if (giftVoucherResponseData != null && giftVoucherResponseData.getStatusCode() != null && p.a(giftVoucherResponseData.getStatusCode(), "SUCCESS", true)) {
                        if (giftVoucherResponseData.getResponse() != null) {
                            GiftVoucherListResponse response = giftVoucherResponseData.getResponse();
                            k.a((Object) response, "responseData.response");
                            if (response.getSubwalletStatusResponseList() != null) {
                                GiftVoucherListResponse response2 = giftVoucherResponseData.getResponse();
                                k.a((Object) response2, "responseData.response");
                                ArrayList<SubwalletStatusResponseList> subwalletStatusResponseList = response2.getSubwalletStatusResponseList();
                                this.f57465b.element = subwalletStatusResponseList.size();
                                a.a(this.f57464a, this.f57465b.element);
                                return;
                            }
                        }
                        a.a(this.f57464a, this.f57465b.element);
                    }
                }
            }
        }
    }

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        k.c(layoutInflater, "inflater");
        return layoutInflater.inflate(R.layout.pass_gift_voucher_header, viewGroup, false);
    }

    public final void onViewCreated(View view, Bundle bundle) {
        k.c(view, "view");
        super.onViewCreated(view, bundle);
        ((RelativeLayout) a(R.id.rl_buy_gift_voucher)).setOnClickListener(new c(this));
        getContext();
        String v = net.one97.paytm.passbook.mapping.c.v();
        k.a((Object) v, "CJRWalletUtility.getWalletGrade(context)");
        f b2 = net.one97.paytm.passbook.d.b();
        net.one97.paytm.passbook.utility.k kVar = net.one97.paytm.passbook.utility.k.f59256a;
        String a2 = b2.a(net.one97.paytm.passbook.utility.k.j());
        boolean z = true;
        if (!v.a(a2)) {
            k.a((Object) a2, "gvPurchaseEnable");
            Object[] array = new l(AppConstants.COMMA).split(a2, 0).toArray(new String[0]);
            if (array != null) {
                String[] strArr = (String[]) array;
                int length = strArr.length;
                int i2 = 0;
                while (true) {
                    if (i2 >= length) {
                        break;
                    } else if (p.a(strArr[i2], v, true)) {
                        break;
                    } else {
                        i2++;
                    }
                }
            } else {
                throw new u("null cannot be cast to non-null type kotlin.Array<T>");
            }
        }
        z = false;
        if (z) {
            RelativeLayout relativeLayout = (RelativeLayout) a(R.id.rl_buy_gift_voucher);
            k.a((Object) relativeLayout, "rl_buy_gift_voucher");
            relativeLayout.setVisibility(0);
            View a3 = a(R.id.v_divider);
            k.a((Object) a3, "v_divider");
            a3.setVisibility(0);
        } else {
            RelativeLayout relativeLayout2 = (RelativeLayout) a(R.id.rl_buy_gift_voucher);
            k.a((Object) relativeLayout2, "rl_buy_gift_voucher");
            relativeLayout2.setVisibility(8);
            View a4 = a(R.id.v_divider);
            k.a((Object) a4, "v_divider");
            a4.setVisibility(8);
        }
        ((RelativeLayout) a(R.id.rl_redeem_gv)).setOnClickListener(new d(this));
        a();
    }

    static final class c implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f57467a;

        c(a aVar) {
            this.f57467a = aVar;
        }

        public final void onClick(View view) {
            net.one97.paytm.passbook.d.b().a(this.f57467a.getContext(), "passbook", "buy_gift_voucher", (ArrayList<String>) null, "/passbook/gift-voucher", "passbook");
            Context context = this.f57467a.getContext();
            f b2 = net.one97.paytm.passbook.d.b();
            k.a((Object) b2, "PassbookHelper.getImplListener()");
            Intent intent = new Intent(context, b2.y());
            intent.putExtra("add_money_tab", "giftVoucher");
            intent.addFlags(67108864);
            this.f57467a.startActivityForResult(intent, 129);
        }
    }

    static final class d implements View.OnClickListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ a f57468a;

        d(a aVar) {
            this.f57468a = aVar;
        }

        public final void onClick(View view) {
            net.one97.paytm.passbook.d.b().a(this.f57468a.getContext(), "passbook", "redeem_gift_voucher", (ArrayList<String>) null, "/passbook/gift-voucher", "passbook");
            this.f57468a.startActivityForResult(new Intent(this.f57468a.getContext(), GiftVoucherRedeemActivity.class), 345);
        }
    }

    private final void a() {
        x.c cVar = new x.c();
        cVar.element = 0;
        e eVar = e.f57457a;
        e.c(getContext(), new C1080a(this, cVar), b.f57466a);
    }

    public final void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        if (i2 == 129 || i2 == 345) {
            FragmentActivity activity = getActivity();
            Fragment fragment = null;
            Fragment c2 = activity != null ? activity.getSupportFragmentManager().c(R.id.l2Fragment) : null;
            if (c2 != null) {
                ((PassbookL2Fragment) c2).b();
                FragmentActivity activity2 = getActivity();
                if (activity2 != null) {
                    ((PassbookL2Activity) activity2).a().a();
                    FragmentActivity activity3 = getActivity();
                    if (activity3 != null) {
                        fragment = activity3.getSupportFragmentManager().c(R.id.l2Fragment);
                    }
                    if (fragment != null) {
                        ((PassbookL2Fragment) fragment).a();
                        a();
                        return;
                    }
                    throw new u("null cannot be cast to non-null type net.one97.paytm.passbook.genericPassbook.fragment.PassbookL2Fragment");
                }
                throw new u("null cannot be cast to non-null type net.one97.paytm.passbook.genericPassbook.activity.PassbookL2Activity");
            }
            throw new u("null cannot be cast to non-null type net.one97.paytm.passbook.genericPassbook.fragment.PassbookL2Fragment");
        }
    }

    public static final /* synthetic */ void a(a aVar, int i2) {
        if (i2 > 0) {
            TextView textView = (TextView) aVar.a(R.id.tvGiftVoucherCount);
            k.a((Object) textView, "tvGiftVoucherCount");
            textView.setVisibility(0);
            TextView textView2 = (TextView) aVar.a(R.id.tvGiftVoucherCount);
            k.a((Object) textView2, "tvGiftVoucherCount");
            aa aaVar = aa.f47921a;
            String string = aVar.getString(R.string.gv_count);
            k.a((Object) string, "getString(R.string.gv_count)");
            String format = String.format(string, Arrays.copyOf(new Object[]{String.valueOf(i2)}, 1));
            k.a((Object) format, "java.lang.String.format(format, *args)");
            textView2.setText(format);
            RelativeLayout relativeLayout = (RelativeLayout) aVar.a(R.id.rl_redeem_gv);
            k.a((Object) relativeLayout, "rl_redeem_gv");
            relativeLayout.setVisibility(0);
            RelativeLayout relativeLayout2 = (RelativeLayout) aVar.a(R.id.rl_buy_gift_voucher);
            k.a((Object) relativeLayout2, "rl_buy_gift_voucher");
            if (relativeLayout2.getVisibility() == 0) {
                View a2 = aVar.a(R.id.v_divider);
                k.a((Object) a2, "v_divider");
                a2.setVisibility(0);
                return;
            }
            return;
        }
        TextView textView3 = (TextView) aVar.a(R.id.tvGiftVoucherCount);
        k.a((Object) textView3, "tvGiftVoucherCount");
        textView3.setVisibility(8);
        RelativeLayout relativeLayout3 = (RelativeLayout) aVar.a(R.id.rl_redeem_gv);
        k.a((Object) relativeLayout3, "rl_redeem_gv");
        relativeLayout3.setVisibility(8);
        View a3 = aVar.a(R.id.v_divider);
        k.a((Object) a3, "v_divider");
        a3.setVisibility(8);
    }

    public final /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        HashMap hashMap = this.f57463a;
        if (hashMap != null) {
            hashMap.clear();
        }
    }
}
