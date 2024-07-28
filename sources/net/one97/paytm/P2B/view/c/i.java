package net.one97.paytm.p2b.view.c;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.core.content.b;
import androidx.lifecycle.al;
import androidx.lifecycle.ao;
import com.airbnb.lottie.LottieAnimationView;
import com.business.merchant_payments.common.utility.AppConstants;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.paytm.network.model.NetworkCustomError;
import net.one97.paytm.common.entity.auth.WebLogin;
import net.one97.paytm.common.entity.beneficiaryModels.CJRAddBeneficiary;
import net.one97.paytm.i.f;
import net.one97.paytm.nativesdk.transcation.PayUtility;
import net.one97.paytm.p2b.R;
import net.one97.paytm.p2b.a.c;
import net.one97.paytm.p2b.d.g;
import net.one97.paytm.p2b.d.h;
import net.one97.paytm.p2b.d.k;
import net.one97.paytm.p2b.data.Bean.InvalidOTPException;
import net.one97.paytm.p2b.e.a;
import net.one97.paytm.p2b.view.Activity.SendMoneyToBankActivity;
import net.one97.paytm.p2b.view.CustomView.P2BOTPPasteEditText;
import net.one97.paytm.upi.util.UpiUtils;

public class i extends f implements View.OnClickListener, c.b {
    private View.OnFocusChangeListener A = new View.OnFocusChangeListener() {
        public final void onFocusChange(View view, boolean z) {
            Context context;
            int i2;
            EditText editText = (EditText) view;
            if (z) {
                context = i.this.getContext();
                i2 = R.color.p2b_color_00b9f5;
            } else {
                context = i.this.getContext();
                i2 = R.color.p2b_color_002e6e;
            }
            editText.setTextColor(b.c(context, i2));
        }
    };
    private View.OnKeyListener B = new View.OnKeyListener() {
        public final boolean onKey(View view, int i2, KeyEvent keyEvent) {
            int i3 = 0;
            if (i2 != 67 || keyEvent.getAction() != 0) {
                return false;
            }
            P2BOTPPasteEditText p2BOTPPasteEditText = null;
            P2BOTPPasteEditText[] a2 = i.this.y;
            int length = a2.length;
            while (i3 < length) {
                P2BOTPPasteEditText p2BOTPPasteEditText2 = a2[i3];
                if (view.equals(p2BOTPPasteEditText2)) {
                    i.a((EditText) p2BOTPPasteEditText2, (EditText) p2BOTPPasteEditText);
                }
                i3++;
                p2BOTPPasteEditText = p2BOTPPasteEditText2;
            }
            return true;
        }
    };
    private TextWatcher C = new TextWatcher() {
        public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        }

        public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        }

        public final void afterTextChanged(Editable editable) {
            i.b(i.this);
        }
    };

    /* renamed from: a  reason: collision with root package name */
    LottieAnimationView f13030a;

    /* renamed from: b  reason: collision with root package name */
    private TextView f13031b;

    /* renamed from: c  reason: collision with root package name */
    private TextView f13032c;

    /* renamed from: d  reason: collision with root package name */
    private TextView f13033d;

    /* renamed from: e  reason: collision with root package name */
    private String f13034e;

    /* renamed from: f  reason: collision with root package name */
    private String f13035f;

    /* renamed from: g  reason: collision with root package name */
    private String f13036g;

    /* renamed from: h  reason: collision with root package name */
    private String f13037h;

    /* renamed from: i  reason: collision with root package name */
    private String f13038i;
    private String j;
    private String k;
    private double l;
    private double m;
    private double n;
    private boolean o;
    private boolean p;
    private boolean q;
    private c.a r;
    private Dialog s;
    private g t;
    private ImageView u;
    private TextView v;
    private a w;
    private RelativeLayout x;
    /* access modifiers changed from: private */
    public P2BOTPPasteEditText[] y;
    private P2BOTPPasteEditText.a z = new P2BOTPPasteEditText.a() {
        public final void a(String str) {
            P2BOTPPasteEditText[] a2 = i.this.y;
            int length = a2.length;
            int i2 = 0;
            int i3 = 0;
            while (i2 < length) {
                a2[i2].setText(String.valueOf(str.charAt(i3)));
                i2++;
                i3++;
            }
        }
    };

    public static i a(String str, String str2, String str3, boolean z2, String str4, String str5, double d2, String str6, double d3, String str7, boolean z3) {
        i iVar = new i();
        Bundle bundle = new Bundle();
        bundle.putString(net.one97.paytm.p2b.d.c.f12675e, str);
        bundle.putString(net.one97.paytm.p2b.d.c.f12676f, str2);
        bundle.putString(net.one97.paytm.p2b.d.c.f12677g, str3);
        bundle.putBoolean(net.one97.paytm.p2b.d.c.f12678h, z2);
        bundle.putString(PayUtility.BANK_NAME, str4);
        bundle.putString("branch_name", str5);
        bundle.putString(net.one97.paytm.p2b.d.c.f12671a, str6);
        bundle.putDouble(net.one97.paytm.p2b.d.c.f12672b, d2);
        bundle.putDouble(net.one97.paytm.p2b.d.c.f12674d, d3);
        bundle.putDouble("fixed_commision", 0.0d);
        bundle.putBoolean(net.one97.paytm.p2b.d.c.f12679i, false);
        bundle.putString(net.one97.paytm.p2b.d.c.j, str7);
        bundle.putBoolean("is_self", z3);
        iVar.setArguments(bundle);
        return iVar;
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        getDialog().setOnShowListener(new DialogInterface.OnShowListener() {
            public final void onShow(DialogInterface dialogInterface) {
                BottomSheetBehavior.from(((com.google.android.material.bottomsheet.a) dialogInterface).getWindow().findViewById(com.google.android.material.R.id.design_bottom_sheet)).setState(3);
            }
        });
        View inflate = layoutInflater.inflate(R.layout.p2b_fragment_enter_otp, viewGroup, false);
        this.y = new P2BOTPPasteEditText[6];
        this.y[0] = (P2BOTPPasteEditText) inflate.findViewById(R.id.p2b_editext1);
        this.y[1] = (P2BOTPPasteEditText) inflate.findViewById(R.id.p2b_editext2);
        this.y[2] = (P2BOTPPasteEditText) inflate.findViewById(R.id.p2b_editext3);
        this.y[3] = (P2BOTPPasteEditText) inflate.findViewById(R.id.p2b_editext4);
        this.y[4] = (P2BOTPPasteEditText) inflate.findViewById(R.id.p2b_editext5);
        this.y[5] = (P2BOTPPasteEditText) inflate.findViewById(R.id.p2b_editext6);
        b();
        this.f13031b = (TextView) inflate.findViewById(R.id.resend_otp);
        this.f13033d = (TextView) inflate.findViewById(R.id.btn_proceed);
        this.f13031b.setOnClickListener(this);
        this.f13033d.setOnClickListener(this);
        this.f13032c = (TextView) inflate.findViewById(R.id.error_text_otp);
        this.x = (RelativeLayout) inflate.findViewById(R.id.rl_loader);
        this.f13030a = (LottieAnimationView) inflate.findViewById(R.id.lav_progress);
        this.f13034e = getArguments().getString(net.one97.paytm.p2b.d.c.f12675e);
        this.f13035f = getArguments().getString(net.one97.paytm.p2b.d.c.f12676f);
        this.f13036g = getArguments().getString(net.one97.paytm.p2b.d.c.f12677g);
        this.o = getArguments().getBoolean(net.one97.paytm.p2b.d.c.f12678h);
        this.f13037h = getArguments().getString(PayUtility.BANK_NAME);
        this.f13038i = getArguments().getString("branch_name");
        this.j = getArguments().getString(net.one97.paytm.p2b.d.c.f12671a);
        this.n = getArguments().getDouble(net.one97.paytm.p2b.d.c.f12672b);
        this.m = getArguments().getDouble(net.one97.paytm.p2b.d.c.f12674d);
        this.l = getArguments().getDouble("fixed_commision");
        this.q = getArguments().getBoolean(net.one97.paytm.p2b.d.c.f12679i);
        this.k = getArguments().getString(net.one97.paytm.p2b.d.c.j);
        this.p = getArguments().getBoolean("is_self");
        net.one97.paytm.p2b.d.b bVar = new net.one97.paytm.p2b.d.b();
        P2BOTPPasteEditText[] p2BOTPPasteEditTextArr = this.y;
        for (P2BOTPPasteEditText p2BOTPPasteEditText : p2BOTPPasteEditTextArr) {
            p2BOTPPasteEditText.setTransformationMethod(bVar);
            p2BOTPPasteEditText.addTextChangedListener(this.C);
            p2BOTPPasteEditText.setOnKeyListener(this.B);
            p2BOTPPasteEditText.setOnFocusChangeListener(this.A);
            p2BOTPPasteEditText.setOTPListner(this.z);
        }
        this.u = (ImageView) inflate.findViewById(R.id.cross_iv);
        this.u.setOnClickListener(this);
        this.s = a(getContext());
        p2BOTPPasteEditTextArr[0].requestFocus();
        k.a((EditText) p2BOTPPasteEditTextArr[0], (Activity) getActivity());
        this.v = (TextView) inflate.findViewById(R.id.tv_otp_sent_to);
        this.v.setText(getString(R.string.p2b_enter_otp_sent_to, k.a(com.paytm.utility.b.l(getContext()), 2)));
        return inflate;
    }

    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.resend_otp) {
            h.b().a(getContext(), "P2B", "P2B_txn_details_screen", "OTP_triggered", SendMoneyToBankActivity.f12799a, "", "p2b", "P2B");
            this.w.f12772f = Boolean.TRUE;
            if (!k.a(getContext())) {
                com.paytm.utility.b.b((Context) getActivity(), getResources().getString(R.string.p2b_no_connection), getResources().getString(R.string.p2b_no_internet));
            } else if (this.o) {
                this.r.a(this.w.n, this.p);
            } else {
                this.r.a(this.f13034e, this.f13036g, this.f13035f, this.f13037h, this.p);
            }
        } else if (id == R.id.btn_proceed) {
            if (this.q) {
                net.one97.paytm.p2b.d.i.a(getContext(), net.one97.paytm.p2b.d.c.u, net.one97.paytm.p2b.d.c.v, net.one97.paytm.p2b.d.c.B, (String) null);
            }
            try {
                StringBuilder sb = new StringBuilder();
                P2BOTPPasteEditText[] p2BOTPPasteEditTextArr = this.y;
                int length = p2BOTPPasteEditTextArr.length;
                int i2 = 0;
                while (i2 < length) {
                    P2BOTPPasteEditText p2BOTPPasteEditText = p2BOTPPasteEditTextArr[i2];
                    if (!TextUtils.isEmpty(p2BOTPPasteEditText.getText().toString())) {
                        sb.append(p2BOTPPasteEditText.getText().toString());
                        i2++;
                    } else {
                        throw new InvalidOTPException("Invalid Exception");
                    }
                }
                String sb2 = sb.toString();
                if (k.a(getContext())) {
                    this.r.a(sb2, this.k);
                } else {
                    com.paytm.utility.b.b((Context) getActivity(), getResources().getString(R.string.p2b_no_connection), getResources().getString(R.string.p2b_no_internet));
                }
            } catch (InvalidOTPException unused) {
                a(true);
                b(getString(R.string.p2b_invalid_otp_error));
            }
        } else if (id == R.id.cross_iv) {
            dismissAllowingStateLoss();
        }
    }

    private void a() {
        h.b().a(getContext(), "P2B", "P2B_txn_details_screen", "OTP_verified", SendMoneyToBankActivity.f12799a, "", "p2b", "P2B");
        this.w.a(Boolean.TRUE);
        dismissAllowingStateLoss();
    }

    private void b() {
        for (P2BOTPPasteEditText text : this.y) {
            text.setText("");
        }
    }

    public final void d() {
        this.x.setVisibility(0);
        k.a(this.f13030a);
        a(false);
    }

    public final void e() {
        this.x.setVisibility(8);
        k.b(this.f13030a);
        a(true);
    }

    private void a(boolean z2) {
        TextView textView = this.f13033d;
        if (textView != null) {
            textView.setEnabled(z2);
        }
    }

    public final void a(NetworkCustomError networkCustomError) {
        a(true);
        if (networkCustomError instanceof NetworkCustomError) {
            String valueOf = String.valueOf(networkCustomError.getStatusCode());
            if (UpiUtils.AUTHENTICATION_FAILURE_401.equalsIgnoreCase(valueOf) || "403".equalsIgnoreCase(valueOf) || "410".equalsIgnoreCase(valueOf)) {
                this.t.e();
            } else {
                b(networkCustomError.getAlertMessage());
            }
        } else {
            b((String) null);
        }
    }

    public final void a(String str) {
        this.k = str;
        b();
        Toast.makeText(getContext(), getString(R.string.p2b_resend_otp_success), 0).show();
    }

    public final void b(NetworkCustomError networkCustomError) {
        if (getActivity() != null && !getActivity().isFinishing() && isResumed()) {
            if (networkCustomError instanceof NetworkCustomError) {
                String valueOf = String.valueOf(networkCustomError.getStatusCode());
                if (UpiUtils.AUTHENTICATION_FAILURE_401.equalsIgnoreCase(valueOf) || "403".equalsIgnoreCase(valueOf) || "410".equalsIgnoreCase(valueOf)) {
                    this.t.e();
                } else {
                    b(networkCustomError.getAlertMessage());
                }
            } else {
                b((String) null);
            }
            a(true);
        }
    }

    public final void a(CJRAddBeneficiary cJRAddBeneficiary) {
        if (cJRAddBeneficiary == null) {
            b((String) null);
        } else if (cJRAddBeneficiary.getError() != null) {
            if (TextUtils.isEmpty(cJRAddBeneficiary.getError().getErrorCode()) || !cJRAddBeneficiary.getError().getErrorCode().equalsIgnoreCase("B-1008")) {
                b(cJRAddBeneficiary.getError().getErrorMsg());
            } else {
                a();
            }
        } else if (cJRAddBeneficiary.getStatusCode().equalsIgnoreCase(WebLogin.RESPONSE_CODE_SUCCESS)) {
            a();
        }
    }

    public final void a(CJRAddBeneficiary.CJRAddBeneficiarySubError cJRAddBeneficiarySubError, String str) {
        a aVar = this.w;
        aVar.o = str;
        aVar.m.setValue(cJRAddBeneficiarySubError);
        dismissAllowingStateLoss();
    }

    private void b(String str) {
        String string = getString(R.string.p2b_error_title);
        String string2 = getString(R.string.p2b_default_error);
        if (TextUtils.isEmpty(str)) {
            str = string2;
        }
        final com.paytm.utility.h hVar = new com.paytm.utility.h(getContext());
        hVar.setTitle(string);
        hVar.a(str);
        hVar.a(-1, getString(R.string.p2b_ok), new View.OnClickListener() {
            public final void onClick(View view) {
                hVar.dismiss();
            }
        });
        hVar.show();
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.w = (a) new al((ao) getActivity(), (al.b) al.a.a(getActivity().getApplication())).a(a.class);
        setStyle(0, R.style.p2bAppBottomSheetDialogTheme);
        setCancelable(true);
        this.r = new net.one97.paytm.p2b.c.b(this, net.one97.paytm.p2b.data.a.b.a(getContext()), this.q, getClass().getName());
    }

    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof g) {
            this.t = (g) context;
        }
    }

    public void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        if (i2 == net.one97.paytm.p2b.d.c.l && intent != null) {
            intent.getStringExtra("order_id");
            intent.getBooleanExtra(AppConstants.IS_CANCEL, false);
        }
    }

    private static Dialog a(Context context) {
        try {
            Dialog dialog = new Dialog(context);
            dialog.requestWindowFeature(1);
            dialog.setCancelable(false);
            dialog.setContentView(R.layout.p2b_lyt_progress_bar);
            dialog.getWindow().setBackgroundDrawableResource(17170445);
            return dialog;
        } catch (Exception unused) {
            return null;
        }
    }

    public void onDestroy() {
        super.onDestroy();
        if (getActivity() != null) {
            k.a((Activity) getActivity());
        }
        a aVar = this.w;
        if (aVar != null) {
            aVar.f12772f = Boolean.FALSE;
        }
        c.a aVar2 = this.r;
        if (aVar2 != null) {
            aVar2.a();
        }
    }

    public void onCancel(DialogInterface dialogInterface) {
        super.onCancel(dialogInterface);
        k.a((Activity) getActivity());
    }

    public void onDismiss(DialogInterface dialogInterface) {
        super.onDismiss(dialogInterface);
        k.a((Activity) getActivity());
    }

    static /* synthetic */ void a(EditText editText, EditText editText2) {
        if (!editText.getText().toString().equals("")) {
            editText.setText("");
        } else if (editText2 != null) {
            editText2.setText("");
            editText2.setEnabled(true);
            editText2.requestFocus();
        }
    }

    static /* synthetic */ void b(i iVar) {
        for (P2BOTPPasteEditText p2BOTPPasteEditText : iVar.y) {
            if (TextUtils.isEmpty(p2BOTPPasteEditText.getText().toString())) {
                p2BOTPPasteEditText.requestFocus();
                return;
            }
        }
    }
}
