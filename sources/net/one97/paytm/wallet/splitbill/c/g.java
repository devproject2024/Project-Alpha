package net.one97.paytm.wallet.splitbill.c;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.lifecycle.z;
import com.airbnb.lottie.LottieAnimationView;
import com.paytm.network.a;
import com.paytm.utility.b;
import com.paytm.utility.q;
import java.util.ArrayList;
import java.util.HashMap;
import net.one97.paytm.dynamic.module.fastag.helper.ImagePickerUtils;
import net.one97.paytm.i.f;
import net.one97.paytm.nativesdk.transcation.viewmodel.DirectFormItemType;
import net.one97.paytm.network.h;
import net.one97.paytm.upi.util.UpiConstants;
import net.one97.paytm.wallet.R;
import net.one97.paytm.wallet.splitbill.activity.SBLandingPageActivity;
import net.one97.paytm.wallet.splitbill.model.UserSettlementAPIResponse.SBUserSettlementBaseResponse;

public class g extends f {

    /* renamed from: a  reason: collision with root package name */
    public String f72157a;

    /* renamed from: b  reason: collision with root package name */
    public a f72158b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f72159c = false;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public Context f72160d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public Button f72161e;

    /* renamed from: f  reason: collision with root package name */
    private TextView f72162f;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public LottieAnimationView f72163g;

    public interface a {
        void a();

        void a(String str);
    }

    public static g a() {
        return new g();
    }

    public void onAttach(Context context) {
        super.onAttach(context);
        this.f72160d = context;
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.sb_bottom_sheet_delete_bill_confirmation, viewGroup, false);
        this.f72161e = (Button) inflate.findViewById(R.id.button_confirm_delete);
        this.f72162f = (TextView) inflate.findViewById(R.id.tv_cancel);
        this.f72163g = (LottieAnimationView) inflate.findViewById(R.id.lav_lottie_loader);
        this.f72161e.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                if (b.c(g.this.f72160d)) {
                    g.this.f72161e.setBackgroundColor(g.this.getActivity().getResources().getColor(R.color.grid_offer_blue));
                    g.this.f72161e.setClickable(false);
                    try {
                        net.one97.paytm.common.widgets.a.a(g.this.f72163g);
                    } catch (Exception e2) {
                        q.d(String.valueOf(e2));
                    }
                    g gVar = g.this;
                    g.a(gVar, gVar.f72157a);
                    return;
                }
                g.this.f72158b.a();
                g.this.dismiss();
            }
        });
        this.f72162f.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                ArrayList arrayList = new ArrayList();
                if (g.this.f72159c) {
                    arrayList.add("1");
                } else {
                    arrayList.add("0");
                }
                arrayList.add(DirectFormItemType.CANCEL);
                net.one97.paytm.wallet.splitbill.e.b.a(g.this.f72160d, "split_bill", "splitbill_delete", arrayList, "", "/splitbill/deleteBill", "split_bill");
                g.this.dismiss();
            }
        });
        return inflate;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(net.one97.paytm.network.f fVar) {
        net.one97.paytm.network.f fVar2 = fVar;
        if (fVar2.f55796a == h.SUCCESS) {
            if (!(fVar2.f55797b instanceof SBUserSettlementBaseResponse)) {
                this.f72161e.setBackgroundColor(getActivity().getResources().getColor(R.color.paytm_blue));
                this.f72161e.setClickable(true);
                try {
                    net.one97.paytm.common.widgets.a.b(this.f72163g);
                } catch (Exception unused) {
                }
                this.f72158b.a(((SBUserSettlementBaseResponse) fVar2.f55797b).getMessage());
                dismiss();
                ArrayList arrayList = new ArrayList();
                if (this.f72159c) {
                    arrayList.add("1");
                } else {
                    arrayList.add("0");
                }
                arrayList.add(ImagePickerUtils.IMAGE_PICKER_KEY_STATUS_FAILURE);
                net.one97.paytm.wallet.splitbill.e.b.a(this.f72160d, "split_bill", "splitbill_delete", arrayList, "", "", "split_bill");
            } else if (((SBUserSettlementBaseResponse) fVar2.f55797b).getSuccess() == null || !((SBUserSettlementBaseResponse) fVar2.f55797b).getSuccess().booleanValue()) {
                this.f72161e.setBackgroundColor(getActivity().getResources().getColor(R.color.paytm_blue));
                this.f72161e.setClickable(true);
                try {
                    net.one97.paytm.common.widgets.a.b(this.f72163g);
                } catch (Exception unused2) {
                }
                this.f72158b.a(((SBUserSettlementBaseResponse) fVar2.f55797b).getMessage());
                dismiss();
                ArrayList arrayList2 = new ArrayList();
                if (this.f72159c) {
                    arrayList2.add("1");
                } else {
                    arrayList2.add("0");
                }
                arrayList2.add(ImagePickerUtils.IMAGE_PICKER_KEY_STATUS_FAILURE);
                net.one97.paytm.wallet.splitbill.e.b.a(this.f72160d, "split_bill", "splitbill_delete", arrayList2, "", "/splitbill/deleteBill", "split_bill");
            } else {
                try {
                    net.one97.paytm.common.widgets.a.b(this.f72163g);
                } catch (Exception unused3) {
                }
                dismiss();
                Intent intent = new Intent(this.f72160d, SBLandingPageActivity.class);
                intent.putExtra("from", "bill_delete_success");
                intent.setFlags(67108864);
                this.f72160d.startActivity(intent);
                dismiss();
                ArrayList arrayList3 = new ArrayList();
                if (this.f72159c) {
                    arrayList3.add("1");
                } else {
                    arrayList3.add("0");
                }
                arrayList3.add("success");
                net.one97.paytm.wallet.splitbill.e.b.a(this.f72160d, "split_bill", "splitbill_delete", arrayList3, "", "/splitbill/deleteBill", "split_bill");
            }
        } else if (fVar2.f55796a == h.ERROR) {
            net.one97.paytm.network.g gVar = fVar2.f55798c;
            this.f72161e.setBackgroundColor(getActivity().getResources().getColor(R.color.paytm_blue));
            this.f72161e.setClickable(true);
            try {
                net.one97.paytm.common.widgets.a.b(this.f72163g);
            } catch (Exception unused4) {
            }
            this.f72158b.a("");
            dismiss();
            if (gVar != null && (gVar.f55799a == 401 || gVar.f55799a == 410 || gVar.f55799a == 403)) {
                net.one97.paytm.wallet.communicator.b.a().handleError(getActivity(), gVar.f55801c, g.class.getName(), (Bundle) null, false);
            }
            ArrayList arrayList4 = new ArrayList();
            if (this.f72159c) {
                arrayList4.add("1");
            } else {
                arrayList4.add("0");
            }
            arrayList4.add(ImagePickerUtils.IMAGE_PICKER_KEY_STATUS_FAILURE);
            net.one97.paytm.wallet.splitbill.e.b.a(this.f72160d, "split_bill", "splitbill_delete", arrayList4, "", "/splitbill/deleteBill", "split_bill");
        }
    }

    static /* synthetic */ void a(g gVar, String str) {
        String stringFromGTM = !TextUtils.isEmpty(net.one97.paytm.wallet.communicator.b.a().getStringFromGTM(gVar.f72160d, "getDeleteBillRequestURL")) ? net.one97.paytm.wallet.communicator.b.a().getStringFromGTM(gVar.f72160d, "getDeleteBillRequestURL") : "https://prms.paytmbank.com/prms/ext/request/delete";
        HashMap hashMap = new HashMap();
        hashMap.put("requestId", str);
        HashMap hashMap2 = new HashMap();
        hashMap2.put("user-token", com.paytm.utility.a.q(gVar.f72160d));
        hashMap2.put(UpiConstants.CACHE_CONTROL, "no-cache");
        hashMap2.put("client-id", UpiConstants.B2C_ANDROID);
        new net.one97.paytm.network.b(stringFromGTM, new SBUserSettlementBaseResponse(), hashMap, hashMap2, (String) null, a.C0715a.PUT, a.c.WALLET, a.b.USER_FACING, gVar.getClass().getName()).c().observeForever(new z() {
            public final void onChanged(Object obj) {
                g.this.a((net.one97.paytm.network.f) obj);
            }
        });
    }
}
