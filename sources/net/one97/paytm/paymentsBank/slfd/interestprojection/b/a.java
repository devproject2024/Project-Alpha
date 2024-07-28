package net.one97.paytm.paymentsBank.slfd.interestprojection.b;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.paytm.network.a;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import java.util.HashMap;
import java.util.Map;
import net.one97.paytm.bankCommon.g.g;
import net.one97.paytm.bankCommon.h.c;
import net.one97.paytm.bankCommon.utils.d;
import net.one97.paytm.i.f;
import net.one97.paytm.paymentsBank.R;
import net.one97.paytm.paymentsBank.slfd.interestprojection.model.ViewHistoryModel;
import net.one97.paytm.paymentsBank.utils.j;
import net.one97.paytm.upi.util.UpiConstants;
import org.json.JSONException;
import org.json.JSONObject;

public class a extends f implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    private RecyclerView f19195a;

    /* renamed from: b  reason: collision with root package name */
    private RelativeLayout f19196b;

    /* renamed from: c  reason: collision with root package name */
    private String f19197c;

    /* renamed from: d  reason: collision with root package name */
    private double f19198d;

    /* renamed from: e  reason: collision with root package name */
    private TextView f19199e;

    /* renamed from: f  reason: collision with root package name */
    private TextView f19200f;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (getArguments() != null) {
            this.f19197c = getArguments().getString("fd_id");
            this.f19198d = getArguments().getDouble("slfd_amount");
        }
    }

    public void setupDialog(Dialog dialog, int i2) {
        super.setupDialog(dialog, i2);
        View inflate = View.inflate(getContext(), R.layout.bs_fd_history, (ViewGroup) null);
        this.f19195a = (RecyclerView) inflate.findViewById(R.id.rv_fd_detail);
        this.f19195a.setLayoutManager(new LinearLayoutManager(getActivity(), 1, false));
        ((ImageView) inflate.findViewById(R.id.iv_close)).setOnClickListener(this);
        this.f19196b = (RelativeLayout) inflate.findViewById(R.id.rl_progress_bar_wrapper);
        this.f19199e = (TextView) inflate.findViewById(R.id.tv_fd_no);
        this.f19200f = (TextView) inflate.findViewById(R.id.tv_amount);
        net.one97.paytm.paymentsBank.slfd.interestprojection.d.a a2 = net.one97.paytm.paymentsBank.slfd.interestprojection.d.a.a(getActivity());
        a2.f19202a = getActivity();
        this.f19196b.setVisibility(0);
        String str = this.f19197c;
        $$Lambda$a$AZeobrPm_rFJvY9gXN7V3ZhuwnM r4 = new g.b() {
            public final void onResponse(Object obj) {
                a.this.a(obj);
            }
        };
        $$Lambda$a$avJsIg7L2_syCK0MxspHvO6Z0sM r5 = new g.a() {
            public final void onErrorResponse(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
                a.this.a(i2, iJRPaytmDataModel, networkCustomError);
            }
        };
        HashMap hashMap = new HashMap();
        HashMap hashMap2 = new HashMap();
        hashMap2.put("screen_name", a2.getClass().getSimpleName());
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("userToken", com.paytm.utility.a.q(a2.f19202a));
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        hashMap.put("authorization", jSONObject.toString());
        hashMap.put("Content-Type", "application/json");
        hashMap.put("Accept", "application/json");
        hashMap.put("client", "iosapp");
        d.b();
        Uri.Builder buildUpon = Uri.parse(d.a("fdTransactionHistory")).buildUpon();
        if (j.a().equals("ICA")) {
            buildUpon.appendQueryParameter("entity_id", c.d(a2.f19202a));
            buildUpon.appendQueryParameter(UpiConstants.EXTRA_ACCOUNT_TYPE, "ica");
        } else {
            buildUpon.appendQueryParameter(UpiConstants.EXTRA_ACCOUNT_TYPE, "isa");
        }
        buildUpon.appendQueryParameter("fdId", str);
        net.one97.paytm.bankCommon.g.a aVar = new net.one97.paytm.bankCommon.g.a(buildUpon.toString(), (g.b) r4, (g.a) r5, (IJRPaytmDataModel) new ViewHistoryModel(), (Map<String, String>) null, (Map<String, String>) hashMap, a.c.PAYMENTSBANK, a.b.USER_FACING, (HashMap<String, String>) hashMap2);
        a2.f19202a.getApplicationContext();
        new net.one97.paytm.bankCommon.g.c();
        net.one97.paytm.bankCommon.g.c.a(aVar);
        dialog.setContentView(inflate);
    }

    public void onClick(View view) {
        if (view.getId() == R.id.iv_close) {
            dismiss();
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(Object obj) {
        try {
            this.f19196b.setVisibility(8);
            ViewHistoryModel viewHistoryModel = (ViewHistoryModel) obj;
            if (viewHistoryModel == null || !viewHistoryModel.getStatus().equalsIgnoreCase("success")) {
                net.one97.paytm.bankCommon.mapping.a.b((Context) getActivity(), getActivity().getString(R.string.error), viewHistoryModel.getMessage());
                return;
            }
            this.f19200f.setText(getString(R.string.rs_str, net.one97.paytm.bankCommon.mapping.a.c(Double.valueOf(this.f19198d))));
            this.f19199e.setText(getString(R.string.pb_fixed_deposit_number, this.f19197c));
            this.f19195a.setAdapter(new net.one97.paytm.paymentsBank.slfd.interestprojection.a.a(getActivity(), viewHistoryModel.getFdList()));
        } catch (Exception unused) {
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
        try {
            this.f19196b.setVisibility(8);
            net.one97.paytm.bankCommon.utils.f.a((Activity) getActivity(), (Exception) networkCustomError, (String) null);
        } catch (Exception unused) {
        }
    }

    public void onAttach(Context context) {
        super.onAttach(context);
    }

    public int getTheme() {
        return R.style.BottomSheetDialogTheme;
    }
}
