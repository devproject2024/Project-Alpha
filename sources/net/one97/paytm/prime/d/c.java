package net.one97.paytm.prime.d;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.databinding.f;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.utility.q;
import net.one97.paytm.common.entity.shopping.CJROrderSummary;
import net.one97.paytm.common.entity.shopping.CJROrderedCart;
import net.one97.paytm.dynamic.module.fastag.helper.ImagePickerUtils;
import net.one97.paytm.nativesdk.Constants.SDKConstants;
import net.one97.paytm.prime.R;
import net.one97.paytm.prime.activity.PrimeLoaderActivity;
import net.one97.paytm.prime.b.a;
import net.one97.paytm.prime.c.e;
import net.one97.paytm.prime.e.b;
import net.one97.paytm.prime.e.d;
import net.one97.paytm.prime.f.b;
import net.one97.paytm.upi.util.UpiConstants;

public class c extends a implements b, d {

    /* renamed from: a  reason: collision with root package name */
    private e f59780a;

    /* renamed from: b  reason: collision with root package name */
    private net.one97.paytm.prime.g.c f59781b;

    /* renamed from: c  reason: collision with root package name */
    private PrimeLoaderActivity f59782c;

    /* renamed from: d  reason: collision with root package name */
    private int f59783d = 5;

    /* renamed from: e  reason: collision with root package name */
    private int f59784e = 1;

    /* renamed from: f  reason: collision with root package name */
    private int[] f59785f = {3, 7, 9, 11, 13, 15, 19, 21};

    /* renamed from: g  reason: collision with root package name */
    private CJROrderSummary f59786g;

    public final void a() {
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.f59780a = (e) f.a(layoutInflater, R.layout.fragment_pending_transcation, viewGroup, false);
        if (getArguments() != null) {
            this.f59786g = (CJROrderSummary) getArguments().getSerializable(net.one97.paytm.prime.f.b.f59790b);
            CJROrderSummary cJROrderSummary = this.f59786g;
            if (cJROrderSummary != null) {
                this.f59781b = new net.one97.paytm.prime.g.c(cJROrderSummary, this);
                this.f59780a.a(this.f59781b);
                if (!TextUtils.isEmpty(this.f59786g.getId())) {
                    final String id = this.f59786g.getId();
                    if (this.f59784e <= this.f59783d) {
                        try {
                            new Handler().postDelayed(new Runnable() {
                                public final void run() {
                                    c.a(c.this, id);
                                }
                            }, (long) (this.f59785f[this.f59784e - 1] * 1000));
                        } catch (NumberFormatException unused) {
                        }
                    }
                }
            }
        }
        return this.f59780a.getRoot();
    }

    public void onAttach(Context context) {
        super.onAttach(context);
        this.f59782c = (PrimeLoaderActivity) context;
    }

    public final void b() {
        CJROrderSummary cJROrderSummary = this.f59786g;
        if (cJROrderSummary == null || cJROrderSummary.getOrderedCartList() == null || this.f59786g.getOrderedCartList().size() <= 0) {
            a.a().b(this.f59782c);
            return;
        }
        Bundle bundle = new Bundle();
        CJROrderedCart cJROrderedCart = this.f59786g.getOrderedCartList().get(0);
        cJROrderedCart.setOrderId(this.f59786g.getId());
        cJROrderedCart.setCreatedAt(this.f59786g.getCreatedAt());
        bundle.putSerializable(UpiConstants.INTENT_EXTRA_CST_ORDER_ITEM, cJROrderedCart);
        bundle.putLong("intent_flag", 67108864);
        a.a().a((Activity) this.f59782c, bundle);
    }

    public final void c() {
        a.a().a((Context) this.f59782c, a.a().a(net.one97.paytm.prime.f.b.f59795g));
    }

    public final void a(IJRPaytmDataModel iJRPaytmDataModel) {
        if (iJRPaytmDataModel instanceof CJROrderSummary) {
            CJROrderSummary cJROrderSummary = (CJROrderSummary) iJRPaytmDataModel;
            if ("success".equalsIgnoreCase(cJROrderSummary.getPaymentStatus())) {
                if (cJROrderSummary.getOrderedCartList() != null && cJROrderSummary.getOrderedCartList().size() > 0 && (cJROrderSummary.getOrderedCartList().get(0).getItemStatus().equalsIgnoreCase("7") || cJROrderSummary.getOrderedCartList().get(0).getItemStatus().equalsIgnoreCase("20"))) {
                    String str = "";
                    String orderId = cJROrderSummary.getPaymentInfo().get(0).getOrderId() != null ? cJROrderSummary.getPaymentInfo().get(0).getOrderId() : str;
                    if (cJROrderSummary.getPaymentInfo().get(0).getBankTransactionId() != null) {
                        str = cJROrderSummary.getPaymentInfo().get(0).getBankTransactionId();
                    }
                    String str2 = str;
                    try {
                        a.a().a(this.f59782c, net.one97.paytm.prime.f.b.f59792d, "first_successful_membership", "Paytm First", "plan_750", orderId, str2, "/prime/offers", net.one97.paytm.prime.f.b.f59791c);
                    } catch (Exception e2) {
                        if (com.paytm.utility.b.v) {
                            q.b(e2.getMessage());
                        }
                    }
                    this.f59782c.a(b.a.SUCCESS, cJROrderSummary);
                } else if (cJROrderSummary.getOrderedCartList() != null && cJROrderSummary.getOrderedCartList().size() > 0) {
                    if (cJROrderSummary.getOrderedCartList().get(0).getStatus().equalsIgnoreCase(ImagePickerUtils.IMAGE_PICKER_KEY_STATUS_FAILURE) || cJROrderSummary.getOrderedCartList().get(0).getStatus().equalsIgnoreCase("failed")) {
                        this.f59782c.a(b.a.FAILURE, cJROrderSummary);
                    }
                }
            } else if (SDKConstants.GA_NATIVE_FAILED.equalsIgnoreCase(cJROrderSummary.getPaymentStatus()) || ImagePickerUtils.IMAGE_PICKER_KEY_STATUS_FAILURE.equalsIgnoreCase(cJROrderSummary.getPaymentStatus())) {
                this.f59782c.a(b.a.FAILURE, cJROrderSummary);
            }
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        a.a().a("/prime/pending", net.one97.paytm.prime.f.b.f59792d, (Activity) this.f59782c);
    }

    static /* synthetic */ void a(c cVar, String str) {
        cVar.f59784e++;
        net.one97.paytm.prime.a.a.a(cVar.f59782c, str, cVar).a();
    }
}
