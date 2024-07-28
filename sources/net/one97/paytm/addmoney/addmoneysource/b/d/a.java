package net.one97.paytm.addmoney.addmoneysource.b.d;

import android.app.Activity;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.fragment.app.FragmentActivity;
import com.business.merchant_payments.utility.StringUtility;
import com.paytm.network.model.NetworkCustomError;
import com.paytm.utility.s;
import net.one97.paytm.addmoney.R;
import net.one97.paytm.addmoney.addmoneysource.b.a.a;
import net.one97.paytm.addmoney.addmoneysource.b.c.b;
import net.one97.paytm.addmoney.common.model.IsaDetailsModel;
import net.one97.paytm.addmoney.utils.e;
import net.one97.paytm.i.h;

public class a extends h implements View.OnLongClickListener, a.b {

    /* renamed from: a  reason: collision with root package name */
    public e f48196a;

    /* renamed from: b  reason: collision with root package name */
    private TextView f48197b;

    /* renamed from: c  reason: collision with root package name */
    private TextView f48198c;

    /* renamed from: d  reason: collision with root package name */
    private TextView f48199d;

    /* renamed from: e  reason: collision with root package name */
    private RelativeLayout f48200e;

    /* renamed from: f  reason: collision with root package name */
    private int f48201f;

    /* renamed from: g  reason: collision with root package name */
    private a.C0840a f48202g;

    /* renamed from: h  reason: collision with root package name */
    private String f48203h;

    /* renamed from: i  reason: collision with root package name */
    private String f48204i;

    public final void a(boolean z) {
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.uam_fragment_ppb_bank_detail_card, viewGroup, false);
        this.f48201f = getArguments().getInt("destinationAddMoney");
        this.f48203h = getArguments().getString("ppb_account_number");
        this.f48204i = getArguments().getString("ppb_account_ifsc");
        this.f48200e = (RelativeLayout) inflate.findViewById(R.id.lyt_bank_detail);
        this.f48200e.setDrawingCacheEnabled(true);
        this.f48197b = (TextView) inflate.findViewById(R.id.name);
        this.f48198c = (TextView) inflate.findViewById(R.id.acc_number);
        this.f48199d = (TextView) inflate.findViewById(R.id.ifsc_code);
        this.f48197b.setOnLongClickListener(this);
        this.f48198c.setOnLongClickListener(this);
        this.f48199d.setOnLongClickListener(this);
        FragmentActivity activity = getActivity();
        getParentFragment();
        this.f48202g = new net.one97.paytm.addmoney.addmoneysource.b.b.a(this, b.a((net.one97.paytm.addmoney.addmoneysource.b.c.a) net.one97.paytm.addmoney.addmoneysource.b.c.a.a.a((Context) activity), (net.one97.paytm.addmoney.addmoneysource.b.c.a) net.one97.paytm.addmoney.addmoneysource.b.c.b.a.a((Context) getActivity(), getParentFragment())), this.f48201f, this.f48203h);
        this.f48202g.a();
        if (!TextUtils.isEmpty(this.f48203h)) {
            this.f48198c.setText(this.f48203h);
        }
        if (!TextUtils.isEmpty(this.f48204i)) {
            this.f48199d.setText(this.f48204i);
        }
        return inflate;
    }

    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
    }

    public void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
        if (i2 == 103 && s.a(iArr)) {
            try {
                IsaDetailsModel isaDetailsModel = (IsaDetailsModel) getArguments().getSerializable("ISA_DETAILS");
                StringBuilder sb = new StringBuilder("");
                if (isaDetailsModel != null) {
                    if (!TextUtils.isEmpty(isaDetailsModel.getAccountName())) {
                        sb.append(isaDetailsModel.getAccountName() + StringUtility.NEW_LINE);
                    }
                    if (!TextUtils.isEmpty(isaDetailsModel.getAccountNumber())) {
                        sb.append(getString(R.string.acc_no));
                        sb.append(" ");
                        sb.append(isaDetailsModel.getAccountNumber());
                    }
                    if (!TextUtils.isEmpty(isaDetailsModel.getIfscCode())) {
                        sb.append(StringUtility.NEW_LINE);
                        sb.append(getString(R.string.uam_bank_ifsc_code));
                        sb.append(" ");
                        sb.append(isaDetailsModel.getIfscCode());
                    }
                }
                String sb2 = sb.toString();
                if (!TextUtils.isEmpty(sb2)) {
                    Intent intent = new Intent("android.intent.action.SEND");
                    intent.setType("text/plain");
                    intent.putExtra("android.intent.extra.TEXT", sb2);
                    Intent createChooser = Intent.createChooser(intent, getString(R.string.uam_share_payments_bank_acc_details));
                    if (createChooser.resolveActivity(getActivity().getPackageManager()) != null) {
                        startActivity(createChooser);
                    } else {
                        Toast.makeText(getActivity(), getString(R.string.no_app_found), 1).show();
                    }
                }
            } catch (Exception e2) {
                if (com.paytm.utility.b.v) {
                    e2.printStackTrace();
                }
            }
        }
    }

    public boolean onLongClick(View view) {
        if (view.equals(this.f48197b)) {
            ((ClipboardManager) getActivity().getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText("account", this.f48197b.getText().toString()));
            Toast.makeText(getActivity(), getString(R.string.uam_name_copied_clipboard), 0).show();
        } else if (view.equals(this.f48198c)) {
            ((ClipboardManager) getActivity().getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText("account", this.f48198c.getText().toString()));
            Toast.makeText(getActivity(), getString(R.string.uam_acc_num_copied_clipboard), 0).show();
        } else if (view.equals(this.f48199d)) {
            ((ClipboardManager) getActivity().getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText("account", this.f48199d.getText().toString()));
            Toast.makeText(getActivity(), getString(R.string.uam_ifsc_copied_clipboard), 0).show();
        }
        return false;
    }

    public final void a(String str, String str2) {
        if (str != null) {
            this.f48198c.setText(str);
        }
        if (str2 != null) {
            this.f48199d.setText(str2);
        }
    }

    public final void a(String str) {
        if (str != null) {
            this.f48197b.setText(str);
        }
    }

    public void onDestroyView() {
        this.f48202g.b();
        super.onDestroyView();
    }

    public final void a(NetworkCustomError networkCustomError) {
        if (isAdded()) {
            net.one97.paytm.helper.a.b().a((Activity) getActivity(), a.class.getCanonicalName(), (Bundle) null);
        }
    }
}
