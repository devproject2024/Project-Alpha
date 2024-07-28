package net.one97.paytm.paymentsBank.form15g.a;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.business.merchant_payments.common.utility.AppConstants;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import net.one97.paytm.bankCommon.g.g;
import net.one97.paytm.bankCommon.mapping.a;
import net.one97.paytm.bankCommon.utils.d;
import net.one97.paytm.i.f;
import net.one97.paytm.paymentsBank.R;
import net.one97.paytm.paymentsBank.form15g.activity.PBFGInformationActivity;
import net.one97.paytm.paymentsBank.form15g.activity.PBFGTackingActivity;
import net.one97.paytm.paymentsBank.form15g.model.FGHStatusModel;
import net.one97.paytm.paymentsBank.form15g.model.Form15ghModel;
import net.one97.paytm.paymentsBank.slfd.tds.view.TDSCertificateActivity;
import net.one97.paytm.paymentsBank.utils.o;

public class b extends f implements g.a, g.b<IJRPaytmDataModel> {

    /* renamed from: a  reason: collision with root package name */
    private String f18395a = b.class.getSimpleName();

    /* renamed from: b  reason: collision with root package name */
    private FGHStatusModel f18396b;

    /* renamed from: c  reason: collision with root package name */
    private TextView f18397c;

    /* renamed from: d  reason: collision with root package name */
    private TextView f18398d;

    /* renamed from: e  reason: collision with root package name */
    private ViewGroup f18399e;

    /* renamed from: f  reason: collision with root package name */
    private ViewGroup f18400f;

    public /* synthetic */ void onResponse(Object obj) {
        String str;
        String str2;
        IJRPaytmDataModel iJRPaytmDataModel = (IJRPaytmDataModel) obj;
        com.paytm.utility.b.p();
        if (iJRPaytmDataModel instanceof Form15ghModel) {
            if (this.f18396b.getResponse().getFormType().equals("Form15G")) {
                str2 = getString(R.string.pb_fg_not_submited);
                str = getString(R.string.pb_fg_name);
            } else {
                str2 = getString(R.string.pb_fh_not_submited);
                str = getString(R.string.pb_fh_name);
            }
            Form15ghModel form15ghModel = (Form15ghModel) iJRPaytmDataModel;
            if (form15ghModel.getStatus().equalsIgnoreCase("FAILURE")) {
                if (form15ghModel.getResponse() != null && form15ghModel.getResponse().getErrorCode() == 4400) {
                    try {
                        o.a().openPanCardDeeplink(getActivity(), true);
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                } else if (form15ghModel.getResponse() != null && form15ghModel.getResponse().getErrorCode() == 500) {
                    a.b((Context) getActivity(), getString(R.string.error), form15ghModel.getResponse().getErrorMessage());
                } else if (form15ghModel.getResponse() == null || form15ghModel.getResponse().getErrorCode() != 4402) {
                    Intent intent = new Intent(getActivity(), PBFGTackingActivity.class);
                    intent.putExtra(AppConstants.EXTRA_FIRST_TITLE, str2);
                    intent.putExtra("SUBTITLE", form15ghModel.getResponse().getErrorMessage());
                    startActivity(intent);
                } else {
                    Intent intent2 = new Intent(getActivity(), PBFGTackingActivity.class);
                    intent2.putExtra(AppConstants.EXTRA_FIRST_TITLE, str2);
                    intent2.putExtra("SUBTITLE", form15ghModel.getResponse().getErrorMessage());
                    startActivity(intent2);
                }
            } else if (!form15ghModel.getStatus().equalsIgnoreCase("SUCCESS")) {
            } else {
                if (form15ghModel.getResponse().getInterestProjection() == 0.0d) {
                    Intent intent3 = new Intent(getActivity(), PBFGTackingActivity.class);
                    intent3.putExtra(AppConstants.EXTRA_FIRST_TITLE, str2);
                    intent3.putExtra("SUBTITLE", getString(R.string.pb_fg_reason_for_not_submited_int_zero, str));
                    startActivity(intent3);
                } else if (this.f18396b.getStatus().equalsIgnoreCase(net.one97.paytm.paymentsBank.form15g.b.NOT_APPLIED.toString()) || this.f18396b.getStatus().equalsIgnoreCase(net.one97.paytm.paymentsBank.form15g.b.REJECTED.toString())) {
                    if (getActivity() != null) {
                        Intent intent4 = new Intent(getActivity(), PBFGInformationActivity.class);
                        intent4.putExtra("FORM15GH_STATUS", this.f18396b);
                        intent4.putExtra("FORM15GH_MODEL", form15ghModel);
                        startActivity(intent4);
                        dismiss();
                    }
                } else if ((this.f18396b.getStatus().equalsIgnoreCase(net.one97.paytm.paymentsBank.form15g.b.APPROVAL_PENDING.toString()) || this.f18396b.getStatus().equalsIgnoreCase(net.one97.paytm.paymentsBank.form15g.b.SUBMISSION_PENDING.toString()) || this.f18396b.getStatus().equalsIgnoreCase(net.one97.paytm.paymentsBank.form15g.b.APPROVED.toString())) && getActivity() != null) {
                    Intent intent5 = new Intent(getActivity(), PBFGTackingActivity.class);
                    intent5.putExtra("FORM15GH_STATUS", this.f18396b);
                    startActivity(intent5);
                    dismiss();
                }
            }
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.pb_fg_bottom_sheet_fragment, viewGroup, false);
        TextView textView = (TextView) inflate.findViewById(R.id.tv_submit_form15g);
        TextView textView2 = (TextView) inflate.findViewById(R.id.tv_form_status);
        ImageView imageView = (ImageView) inflate.findViewById(R.id.iv_close);
        boolean z = getArguments().getBoolean("show_tds");
        boolean z2 = getArguments().getBoolean("show_ic");
        this.f18397c = (TextView) inflate.findViewById(R.id.interest_certificate);
        this.f18398d = (TextView) inflate.findViewById(R.id.tv_tds_certificate);
        this.f18399e = (ViewGroup) inflate.findViewById(R.id.tds_lyt);
        this.f18400f = (ViewGroup) inflate.findViewById(R.id.interest_lyt);
        if (getArguments().containsKey("FORM15GH_STATUS")) {
            this.f18396b = (FGHStatusModel) getArguments().getSerializable("FORM15GH_STATUS");
            if (this.f18396b.getStatus().equalsIgnoreCase(net.one97.paytm.paymentsBank.form15g.b.APPROVAL_PENDING.toString())) {
                textView2.setVisibility(0);
                textView2.setText(getActivity().getResources().getString(R.string.pb_fg_approval_pending));
            } else if (this.f18396b.getStatus().equalsIgnoreCase(net.one97.paytm.paymentsBank.form15g.b.SUBMISSION_PENDING.toString())) {
                textView2.setVisibility(0);
                textView2.setText(getActivity().getResources().getString(R.string.pb_fg_submit_pending));
            } else if (this.f18396b.getStatus().equalsIgnoreCase(net.one97.paytm.paymentsBank.form15g.b.REJECTED.toString())) {
                textView2.setVisibility(0);
                textView2.setText(getActivity().getResources().getString(R.string.pb_fg_rejected));
            } else if (this.f18396b.getStatus().equalsIgnoreCase(net.one97.paytm.paymentsBank.form15g.b.APPROVED.toString())) {
                textView2.setVisibility(0);
                textView2.setText(getActivity().getResources().getString(R.string.pb_fg_approved));
            }
            if ("Form15G".equalsIgnoreCase(this.f18396b.getResponse().getFormtype())) {
                textView.setText(getActivity().getResources().getString(R.string.pb_fg_submit_form_15G));
            } else if ("Form15H".equalsIgnoreCase(this.f18396b.getResponse().getFormtype())) {
                textView.setText(getActivity().getResources().getString(R.string.pb_fg_submit_form_15H));
            }
            inflate.findViewById(R.id.submit_fg_lyt).setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    b.this.e(view);
                }
            });
            textView.setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    b.this.d(view);
                }
            });
        } else {
            inflate.findViewById(R.id.submit_fg_lyt).setVisibility(8);
        }
        imageView.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                b.this.c(view);
            }
        });
        d.b();
        if (z) {
            this.f18399e.setVisibility(0);
            this.f18398d.setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    b.this.b(view);
                }
            });
        } else {
            this.f18399e.setVisibility(8);
        }
        d.b();
        if (z2) {
            this.f18400f.setVisibility(0);
            this.f18397c.setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    b.this.a(view);
                }
            });
        } else {
            this.f18400f.setVisibility(8);
        }
        if (getArguments().containsKey("deeplink")) {
            Uri parse = Uri.parse(getArguments().getString("deeplink"));
            String queryParameter = (parse == null || parse.getQueryParameter("featuretype") == null) ? "" : parse.getQueryParameter("featuretype");
            if ("fd_tds_certificate".equals(queryParameter)) {
                if (this.f18399e.getVisibility() == 0) {
                    this.f18398d.performClick();
                }
            } else if ("fd_interest_certificate".equals(queryParameter)) {
                if (this.f18400f.getVisibility() == 0) {
                    this.f18397c.performClick();
                }
            } else if ("fd_form_15".equalsIgnoreCase(queryParameter)) {
                a();
            }
        }
        return inflate;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void e(View view) {
        a();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void d(View view) {
        if (!this.f18396b.getStatus().equalsIgnoreCase(net.one97.paytm.paymentsBank.form15g.b.APPROVAL_PENDING.toString()) && !this.f18396b.getStatus().equalsIgnoreCase(net.one97.paytm.paymentsBank.form15g.b.SUBMISSION_PENDING.toString()) && !this.f18396b.getStatus().equalsIgnoreCase(net.one97.paytm.paymentsBank.form15g.b.APPROVED.toString())) {
            a();
        } else if (getActivity() != null) {
            Intent intent = new Intent(getActivity(), PBFGTackingActivity.class);
            intent.putExtra("FORM15GH_STATUS", this.f18396b);
            startActivity(intent);
            dismiss();
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void c(View view) {
        dismiss();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void b(View view) {
        Intent intent = new Intent(getActivity(), TDSCertificateActivity.class);
        intent.putExtra("extra_certificate_ui_config", net.one97.paytm.paymentsBank.slfd.tds.a.a.a.TDS_CERTIFICATE);
        startActivity(intent);
        dismiss();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(View view) {
        Intent intent = new Intent(getActivity(), TDSCertificateActivity.class);
        intent.putExtra("extra_certificate_ui_config", net.one97.paytm.paymentsBank.slfd.tds.a.a.a.INTEREST_CERTIFICATE);
        startActivity(intent);
        dismiss();
    }

    private void a() {
        com.paytm.utility.b.k(getActivity(), getString(R.string.pb_please_wait));
        net.one97.paytm.paymentsBank.form15g.a.a(getContext()).a(this, this);
    }

    public void onErrorResponse(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
        com.paytm.utility.b.p();
        com.paytm.utility.b.b((Context) getActivity(), getString(R.string.error), getString(R.string.some_went_wrong));
    }

    public int getTheme() {
        return R.style.BottomSheetDialogTheme;
    }
}
