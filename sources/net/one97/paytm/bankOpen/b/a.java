package net.one97.paytm.bankOpen.b;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import net.one97.paytm.bankCommon.d.b;
import net.one97.paytm.bankCommon.mapping.c;
import net.one97.paytm.bankCommon.mapping.g;
import net.one97.paytm.bankCommon.utils.d;
import net.one97.paytm.bankOpen.R;
import net.one97.paytm.bankOpen.f;
import net.one97.paytm.common.entity.offline_pg.pgTransactionRequest.CJRPGTransactionRequestUtils;
import net.one97.paytm.upi.util.CJRGTMConstants;
import net.one97.paytm.upi.util.UpiConstants;

public class a extends b implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    private final int f16354b = 3;

    /* renamed from: c  reason: collision with root package name */
    private final int f16355c = 5;

    /* renamed from: d  reason: collision with root package name */
    private final int f16356d = 6;

    /* renamed from: e  reason: collision with root package name */
    private final int f16357e = 4;

    /* renamed from: f  reason: collision with root package name */
    private ViewGroup f16358f;

    /* renamed from: g  reason: collision with root package name */
    private int f16359g;

    /* renamed from: h  reason: collision with root package name */
    private TextView f16360h;

    /* renamed from: i  reason: collision with root package name */
    private int f16361i;
    private int j;
    private LinearLayout k;

    /* renamed from: net.one97.paytm.bankOpen.b.a$a  reason: collision with other inner class name */
    enum C0229a {
        VERIFIED,
        VERIFICATION_IN_PROCESS,
        VERIFICATION_IN_PROCESS_DOC,
        PROOF_NOT_SUBMITTED,
        INVALID,
        HIDE
    }

    public void onClick(View view) {
        if (view.getId() == R.id.account_status_tv_bank_open) {
            try {
                g.b();
                String a2 = d.a("cstGetBankHelpineCallingNumber");
                if (!TextUtils.isEmpty(a2)) {
                    Uri parse = Uri.parse("tel:".concat(String.valueOf(a2)));
                    Intent intent = new Intent("android.intent.action.DIAL");
                    intent.setData(parse);
                    startActivity(intent);
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        c.a("/bank/savings-account/status", CJRGTMConstants.GTM_VERTICAL_BANK_SAVINGS_ACCOUNT, (Context) getActivity());
        return layoutInflater.inflate(R.layout.pb_f_account_status, viewGroup, false);
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        this.f16361i = getResources().getDimensionPixelOffset(R.dimen.dimen_25dp);
        this.j = getResources().getDimensionPixelOffset(R.dimen.dimen_48dp);
        this.k = (LinearLayout) view.findViewById(R.id.account_status_tv_bank_open_lyt);
        this.f16360h = (TextView) view.findViewById(R.id.account_status_tv_bank_open);
        this.f16360h.setOnClickListener((View.OnClickListener) null);
        this.k.setVisibility(8);
        this.f16358f = (ViewGroup) view.findViewById(R.id.e_status_layout);
        this.f16358f.setVisibility(8);
        this.f16359g = androidx.core.content.b.c(getActivity(), net.one97.paytm.common.assets.R.color.color_21c17a);
    }

    public void onActivityCreated(Bundle bundle) {
        int i2;
        super.onActivityCreated(bundle);
        net.one97.paytm.bankCommon.h.b.c(getActivity()).equalsIgnoreCase(UpiConstants.DEFAULT_ACCOUNT_NA_CONSTANT);
        getView().findViewById(R.id.f_account_status_lyt_nearby).setVisibility(8);
        getView().findViewById(R.id.f_account_status_lyt_nearby).setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                a.this.e(view);
            }
        });
        this.f16358f.setVisibility(0);
        if (f.a().showPasscodeScreen(getActivity())) {
            a(1, C0229a.VERIFIED, 1);
        } else {
            a(1, C0229a.INVALID, 1);
        }
        a(2, C0229a.VERIFIED, 2);
        String c2 = net.one97.paytm.bankCommon.h.b.c(getActivity());
        net.one97.paytm.bankCommon.h.b.n(getActivity());
        String o = net.one97.paytm.bankCommon.h.b.o(getActivity());
        String q = net.one97.paytm.bankCommon.h.b.q(getActivity());
        if (!TextUtils.isEmpty(c2)) {
            i2 = 5;
            if (c2.equalsIgnoreCase("Y")) {
                a(3, C0229a.VERIFIED, 3);
                C0229a aVar = C0229a.VERIFIED;
                String string = getString(R.string.bank_open_once_done);
                if (TextUtils.isEmpty(o) || !o.equalsIgnoreCase(UpiConstants.DEFAULT_ACCOUNT_NA_CONSTANT)) {
                    if (!TextUtils.isEmpty(o) && o.equalsIgnoreCase("Y")) {
                        a(4, C0229a.VERIFIED, 5);
                        this.k.setVisibility(0);
                        this.f16360h.setText(string);
                    } else if (!TextUtils.isEmpty(o) && o.equalsIgnoreCase(AppConstants.FEED_COMMUNITY_POST)) {
                        a(4, C0229a.VERIFICATION_IN_PROCESS, 5);
                        this.k.setVisibility(0);
                        this.f16360h.setText(string);
                    }
                } else if (!TextUtils.isEmpty(q) && q.equalsIgnoreCase(UpiConstants.DEFAULT_ACCOUNT_NA_CONSTANT)) {
                    a(4, C0229a.PROOF_NOT_SUBMITTED, 5);
                    this.k.setVisibility(0);
                    g.b();
                    String a2 = d.a("cstGetBankHelpineCallingNumber");
                    if (!TextUtils.isEmpty(a2)) {
                        this.f16360h.setText(getString(R.string.bank_acc_open_dial_new, a2));
                        this.f16360h.setOnClickListener(this);
                    }
                } else if (!TextUtils.isEmpty(q) && q.equalsIgnoreCase("Y")) {
                    a(4, C0229a.VERIFIED, 6);
                    this.k.setVisibility(0);
                    this.f16360h.setText(string);
                } else if (!TextUtils.isEmpty(q) && q.equalsIgnoreCase(AppConstants.FEED_COMMUNITY_POST)) {
                    a(4, C0229a.VERIFICATION_IN_PROCESS, 6);
                    this.k.setVisibility(0);
                    this.f16360h.setText(string);
                }
                i2 = 4;
            } else if (c2.equalsIgnoreCase(AppConstants.USER_SUB_TYPE)) {
                a(3, C0229a.VERIFICATION_IN_PROCESS_DOC, 3);
                a(4, C0229a.INVALID, 5);
                return;
            } else {
                a(3, C0229a.PROOF_NOT_SUBMITTED, 3);
                a(4, C0229a.INVALID, 5);
                return;
            }
        } else {
            i2 = 3;
        }
        while (i2 <= 4) {
            a(i2, C0229a.INVALID, 3);
            i2++;
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void e(View view) {
        c.a(getActivity(), "bank_saving_account", "bank_status_nearby_centres_clicked", "", "", "/bank/savings-account/status", CJRGTMConstants.GTM_VERTICAL_BANK_SAVINGS_ACCOUNT);
        net.one97.paytm.bankOpen.d b2 = f.b();
        FragmentActivity activity = getActivity();
        b2.checkDeepLinking(activity, net.one97.paytm.bankCommon.utils.a.a() + "nearby?tab=2");
    }

    private void a(int i2, C0229a aVar, int i3) {
        int i4 = i2 - 1;
        ViewGroup viewGroup = (ViewGroup) this.f16358f.getChildAt(i4);
        viewGroup.setOnClickListener((View.OnClickListener) null);
        if (aVar == C0229a.VERIFIED) {
            ((ImageView) viewGroup.findViewById(R.id.e_status_image)).setImageResource(R.drawable.pb_ic_timeline_done);
            if (i4 != 0) {
                this.f16358f.getChildAt(i4 - 1).findViewById(R.id.e_state).setBackgroundColor(this.f16359g);
            }
        } else if (aVar == C0229a.INVALID) {
            viewGroup.setVisibility(8);
            if (i4 != 0) {
                this.f16358f.getChildAt(i4 - 1).findViewById(R.id.e_state).setVisibility(8);
                return;
            }
            return;
        } else if (aVar == C0229a.HIDE) {
            viewGroup.setVisibility(8);
            return;
        } else {
            ((ImageView) viewGroup.findViewById(R.id.e_status_image)).setImageResource(R.drawable.pb_orange_circle);
            if (i4 != 0) {
                this.f16358f.getChildAt(i4 - 1).findViewById(R.id.e_state).setBackgroundResource(R.drawable.pb_ac_opening_dot_rectangle);
            }
        }
        if (i3 == 3) {
            a(aVar, viewGroup);
        } else if (i3 == 4) {
            b(aVar, viewGroup);
        } else if (i3 == 5) {
            c(aVar, viewGroup);
        } else if (i3 == 6) {
            d(aVar, viewGroup);
        }
    }

    private void a(C0229a aVar, ViewGroup viewGroup) {
        View findViewById = viewGroup.findViewById(R.id.e_state);
        int i2 = this.f16361i;
        int i3 = AnonymousClass1.f16362a[aVar.ordinal()];
        if (i3 == 1) {
            ((TextView) viewGroup.findViewById(R.id.e_title)).setText(getResources().getString(R.string.document_verification_complete));
            viewGroup.findViewById(R.id.e_sub_title).setVisibility(8);
            viewGroup.findViewById(R.id.e_next).setVisibility(8);
        } else if (i3 == 2) {
            ((TextView) viewGroup.findViewById(R.id.e_title)).setText(getResources().getString(R.string.in_person_verification_pending));
            viewGroup.findViewById(R.id.e_sub_title).setVisibility(8);
            ((TextView) viewGroup.findViewById(R.id.e_sub_title)).setText(getResources().getString(R.string.book_appointment_doc_verfiy));
            i2 = this.j;
            viewGroup.setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    a.this.d(view);
                }
            });
        } else if (i3 == 3) {
            ((TextView) viewGroup.findViewById(R.id.e_title)).setText(getResources().getString(R.string.in_person_verification_pending));
            viewGroup.findViewById(R.id.e_sub_title).setVisibility(8);
            viewGroup.findViewById(R.id.e_next).setVisibility(8);
        } else if (i3 == 4) {
            ((TextView) viewGroup.findViewById(R.id.e_title)).setText(getResources().getString(R.string.document_verification_pending));
            viewGroup.findViewById(R.id.e_sub_title).setVisibility(8);
            viewGroup.findViewById(R.id.e_next).setVisibility(8);
        }
        if (findViewById != null) {
            ViewGroup.LayoutParams layoutParams = findViewById.getLayoutParams();
            layoutParams.height = i2;
            findViewById.setLayoutParams(layoutParams);
        }
    }

    /* renamed from: net.one97.paytm.bankOpen.b.a$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f16362a = new int[C0229a.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(10:0|1|2|3|4|5|6|7|8|10) */
        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|(3:7|8|10)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0014 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001f */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x002a */
        static {
            /*
                net.one97.paytm.bankOpen.b.a$a[] r0 = net.one97.paytm.bankOpen.b.a.C0229a.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f16362a = r0
                int[] r0 = f16362a     // Catch:{ NoSuchFieldError -> 0x0014 }
                net.one97.paytm.bankOpen.b.a$a r1 = net.one97.paytm.bankOpen.b.a.C0229a.VERIFIED     // Catch:{ NoSuchFieldError -> 0x0014 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0014 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0014 }
            L_0x0014:
                int[] r0 = f16362a     // Catch:{ NoSuchFieldError -> 0x001f }
                net.one97.paytm.bankOpen.b.a$a r1 = net.one97.paytm.bankOpen.b.a.C0229a.PROOF_NOT_SUBMITTED     // Catch:{ NoSuchFieldError -> 0x001f }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001f }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001f }
            L_0x001f:
                int[] r0 = f16362a     // Catch:{ NoSuchFieldError -> 0x002a }
                net.one97.paytm.bankOpen.b.a$a r1 = net.one97.paytm.bankOpen.b.a.C0229a.VERIFICATION_IN_PROCESS     // Catch:{ NoSuchFieldError -> 0x002a }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x002a }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x002a }
            L_0x002a:
                int[] r0 = f16362a     // Catch:{ NoSuchFieldError -> 0x0035 }
                net.one97.paytm.bankOpen.b.a$a r1 = net.one97.paytm.bankOpen.b.a.C0229a.VERIFICATION_IN_PROCESS_DOC     // Catch:{ NoSuchFieldError -> 0x0035 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0035 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0035 }
            L_0x0035:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.bankOpen.b.a.AnonymousClass1.<clinit>():void");
        }
    }

    private void b(C0229a aVar, ViewGroup viewGroup) {
        View findViewById = viewGroup.findViewById(R.id.e_state);
        int i2 = this.f16361i;
        int i3 = AnonymousClass1.f16362a[aVar.ordinal()];
        if (i3 == 1) {
            ((TextView) viewGroup.findViewById(R.id.e_title)).setText(getResources().getString(R.string.aadhaar_no_verified));
            viewGroup.findViewById(R.id.e_sub_title).setVisibility(8);
            viewGroup.findViewById(R.id.e_next).setVisibility(8);
        } else if (i3 == 2) {
            ((TextView) viewGroup.findViewById(R.id.e_title)).setText(getResources().getString(R.string.update_aadhaar));
            viewGroup.findViewById(R.id.e_sub_title).setVisibility(0);
            ((TextView) viewGroup.findViewById(R.id.e_sub_title)).setText(getResources().getString(R.string.submit_aadhaar));
            viewGroup.setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    a.this.c(view);
                }
            });
            i2 = this.j;
        } else if (i3 == 3) {
            ((TextView) viewGroup.findViewById(R.id.e_title)).setText(R.string.aadhaar_no_verifing);
            viewGroup.findViewById(R.id.e_sub_title).setVisibility(8);
            viewGroup.findViewById(R.id.e_next).setVisibility(8);
        }
        if (findViewById != null) {
            ViewGroup.LayoutParams layoutParams = findViewById.getLayoutParams();
            layoutParams.height = i2;
            findViewById.setLayoutParams(layoutParams);
        }
    }

    private void c(C0229a aVar, ViewGroup viewGroup) {
        View findViewById = viewGroup.findViewById(R.id.e_state);
        int i2 = this.f16361i;
        int i3 = AnonymousClass1.f16362a[aVar.ordinal()];
        if (i3 == 1) {
            ((TextView) viewGroup.findViewById(R.id.e_title)).setText(getResources().getString(R.string.pan_no_verified));
            viewGroup.findViewById(R.id.e_sub_title).setVisibility(8);
            viewGroup.findViewById(R.id.e_next).setVisibility(8);
        } else if (i3 == 2) {
            ((TextView) viewGroup.findViewById(R.id.e_title)).setText(getResources().getString(R.string.update_pan_no));
            viewGroup.findViewById(R.id.e_sub_title).setVisibility(0);
            ((TextView) viewGroup.findViewById(R.id.e_sub_title)).setText(getResources().getString(R.string.submit_pan_no));
            viewGroup.setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    a.this.b(view);
                }
            });
            i2 = this.j;
        } else if (i3 == 3) {
            ((TextView) viewGroup.findViewById(R.id.e_title)).setText(getResources().getString(R.string.pan_no_verifing));
            viewGroup.findViewById(R.id.e_sub_title).setVisibility(8);
            viewGroup.findViewById(R.id.e_next).setVisibility(8);
        }
        if (findViewById != null) {
            ViewGroup.LayoutParams layoutParams = findViewById.getLayoutParams();
            layoutParams.height = i2;
            findViewById.setLayoutParams(layoutParams);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void b(View view) {
        d();
    }

    private void d(C0229a aVar, ViewGroup viewGroup) {
        View findViewById = viewGroup.findViewById(R.id.e_state);
        int i2 = this.f16361i;
        int i3 = AnonymousClass1.f16362a[aVar.ordinal()];
        if (i3 == 1) {
            ((TextView) viewGroup.findViewById(R.id.e_title)).setText(getResources().getString(R.string.pb_form60_verified));
            viewGroup.findViewById(R.id.e_sub_title).setVisibility(8);
            viewGroup.findViewById(R.id.e_next).setVisibility(8);
        } else if (i3 == 2) {
            ((TextView) viewGroup.findViewById(R.id.e_title)).setText(getResources().getString(R.string.pb_update_form60));
            viewGroup.findViewById(R.id.e_sub_title).setVisibility(0);
            ((TextView) viewGroup.findViewById(R.id.e_sub_title)).setText(getResources().getString(R.string.submit_pan_no));
            viewGroup.setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    a.this.a(view);
                }
            });
            i2 = this.j;
        } else if (i3 == 3) {
            ((TextView) viewGroup.findViewById(R.id.e_title)).setText(getResources().getString(R.string.pb_form60_verifing));
            viewGroup.findViewById(R.id.e_sub_title).setVisibility(8);
            viewGroup.findViewById(R.id.e_next).setVisibility(8);
        }
        if (findViewById != null) {
            ViewGroup.LayoutParams layoutParams = findViewById.getLayoutParams();
            layoutParams.height = i2;
            findViewById.setLayoutParams(layoutParams);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(View view) {
        d();
    }

    public void onErrorResponse(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
        W_();
    }

    private void d() {
        try {
            f.b().checkDeepLinking(getActivity(), net.one97.paytm.bankCommon.utils.a.a(net.one97.paytm.bankCommon.utils.a.b(), CJRPGTransactionRequestUtils.PAYER_BANK_NAME, true));
        } catch (UnsupportedEncodingException e2) {
            e2.printStackTrace();
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void c(View view) {
        try {
            net.one97.paytm.bankOpen.d b2 = f.b();
            FragmentActivity activity = getActivity();
            String b3 = net.one97.paytm.bankCommon.utils.a.b();
            b2.checkDeepLinking(activity, net.one97.paytm.bankCommon.utils.a.a() + "add_aadhaar?call_back_url=" + URLEncoder.encode(b3, AppConstants.UTF_8) + "&vertical=" + CJRPGTransactionRequestUtils.PAYER_BANK_NAME + "&dbt_consent=false");
        } catch (UnsupportedEncodingException e2) {
            e2.printStackTrace();
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void d(View view) {
        try {
            net.one97.paytm.bankOpen.d b2 = f.b();
            FragmentActivity activity = getActivity();
            b2.checkDeepLinking(activity, net.one97.paytm.bankCommon.utils.a.a(net.one97.paytm.bankCommon.utils.a.a() + "payment_bank?open_screen=bank_kyc_status_screen", CJRPGTransactionRequestUtils.PAYER_BANK_NAME));
        } catch (UnsupportedEncodingException e2) {
            e2.printStackTrace();
        }
    }
}
