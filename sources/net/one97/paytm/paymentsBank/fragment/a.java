package net.one97.paytm.paymentsBank.fragment;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.business.merchant_payments.utility.StringUtility;
import com.google.android.material.textfield.TextInputEditText;
import com.paytm.utility.b;
import com.paytm.utility.s;
import net.one97.paytm.bankCommon.f.d;
import net.one97.paytm.bankCommon.model.IsaDetailsModel;
import net.one97.paytm.i.h;
import net.one97.paytm.paymentsBank.R;
import net.one97.paytm.paymentsBank.utils.o;

public class a extends h implements View.OnClickListener, View.OnLongClickListener {

    /* renamed from: a  reason: collision with root package name */
    private TextInputEditText f18463a;

    /* renamed from: b  reason: collision with root package name */
    private TextInputEditText f18464b;

    /* renamed from: c  reason: collision with root package name */
    private TextInputEditText f18465c;

    /* renamed from: d  reason: collision with root package name */
    private TextView f18466d;

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.item_savings_acc_details, viewGroup, false);
    }

    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        this.f18466d = (TextView) getView().findViewById(R.id.item_savings_acc_details_tv_share);
        ((RelativeLayout) getView().findViewById(R.id.lyt_bank_detail)).setDrawingCacheEnabled(true);
        this.f18463a = (TextInputEditText) getView().findViewById(R.id.name);
        this.f18464b = (TextInputEditText) getView().findViewById(R.id.acc_number);
        this.f18465c = (TextInputEditText) getView().findViewById(R.id.ifsc_code);
        this.f18463a.setOnLongClickListener(this);
        this.f18464b.setOnLongClickListener(this);
        this.f18465c.setOnLongClickListener(this);
        this.f18466d.setOnClickListener(this);
        if (getArguments() != null) {
            if (getArguments().getBoolean("SHOW_MOTIF")) {
                getView().findViewById(R.id.iv_motif).setVisibility(0);
                getView().findViewById(R.id.heading).setVisibility(0);
            } else {
                getView().findViewById(R.id.iv_motif).setVisibility(8);
                getView().findViewById(R.id.heading).setVisibility(8);
            }
            o.a().getNameFromKyc(getContext(), new d() {
                public final void onFragmentAction(int i2, Object obj) {
                    a.this.a(i2, obj);
                }
            });
            IsaDetailsModel isaDetailsModel = (IsaDetailsModel) getArguments().getSerializable("ISA_DETAILS");
            if (isaDetailsModel != null) {
                this.f18464b.setText(isaDetailsModel.getAccountNumber());
                this.f18465c.setText(isaDetailsModel.getIfscCode());
            }
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(int i2, Object obj) {
        this.f18463a.setText((String) obj);
    }

    private String a() {
        IsaDetailsModel isaDetailsModel = (IsaDetailsModel) getArguments().getSerializable("ISA_DETAILS");
        StringBuilder sb = new StringBuilder();
        if (isaDetailsModel != null) {
            if (!TextUtils.isEmpty(isaDetailsModel.getAccountName())) {
                sb.append(isaDetailsModel.getAccountName());
                sb.append(StringUtility.NEW_LINE);
            }
            if (!TextUtils.isEmpty(isaDetailsModel.getAccountNumber())) {
                sb.append(getString(R.string.pb_acc_no));
                sb.append(" ");
                sb.append(isaDetailsModel.getAccountNumber());
            }
            if (!TextUtils.isEmpty(isaDetailsModel.getIfscCode())) {
                sb.append(StringUtility.NEW_LINE);
                sb.append(getString(R.string.pb_bank_ifsc_code));
                sb.append(" ");
                sb.append(isaDetailsModel.getIfscCode());
            }
        }
        return sb.toString();
    }

    public void onClick(View view) {
        if (view.getId() == R.id.item_savings_acc_details_tv_share) {
            b();
        }
    }

    private void b() {
        try {
            String a2 = a();
            if (!TextUtils.isEmpty(a2)) {
                this.f18466d.setVisibility(8);
                Intent intent = new Intent("android.intent.action.SEND");
                intent.setType("text/plain");
                intent.putExtra("android.intent.extra.TEXT", a2);
                Intent createChooser = Intent.createChooser(intent, getString(R.string.share_payments_bank_acc_details));
                if (createChooser.resolveActivity(getActivity().getPackageManager()) != null) {
                    startActivity(createChooser);
                } else {
                    Toast.makeText(getActivity(), getString(R.string.pb_no_app_found), 1).show();
                }
            }
        } catch (Exception e2) {
            if (b.v) {
                e2.printStackTrace();
            }
        } catch (Throwable th) {
            this.f18466d.setVisibility(0);
            throw th;
        }
        this.f18466d.setVisibility(0);
    }

    public void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
        if (i2 == 103 && s.a(iArr)) {
            b();
        }
    }

    public boolean onLongClick(View view) {
        if (view.equals(this.f18463a)) {
            ((ClipboardManager) getActivity().getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText("account", this.f18463a.getText().toString()));
            Toast.makeText(getActivity(), getString(R.string.name_copied_clipboard), 0).show();
        } else if (view.equals(this.f18464b)) {
            ((ClipboardManager) getActivity().getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText("account", this.f18464b.getText().toString()));
            Toast.makeText(getActivity(), getString(R.string.acc_num_copied_clipboard), 0).show();
        } else if (view.equals(this.f18465c)) {
            ((ClipboardManager) getActivity().getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText("account", this.f18465c.getText().toString()));
            Toast.makeText(getActivity(), getString(R.string.ifsc_copied_clipboard), 0).show();
        }
        return false;
    }
}
