package net.one97.paytm.upi.registration.view;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.telephony.SubscriptionInfo;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.squareup.picasso.e;
import com.squareup.picasso.w;
import java.util.List;
import net.one97.paytm.i.h;
import net.one97.paytm.upi.R;
import net.one97.paytm.upi.common.upi.AccountProviderBody;
import net.one97.paytm.upi.e.ac;
import net.one97.paytm.upi.e.ae;
import net.one97.paytm.upi.e.v;
import net.one97.paytm.upi.h.a;
import net.one97.paytm.upi.i;
import net.one97.paytm.upi.registration.a.b;
import net.one97.paytm.upi.registration.view.h;
import net.one97.paytm.upi.util.CJRGTMConstants;
import net.one97.paytm.upi.util.CJRSendGTMTag;
import net.one97.paytm.upi.util.GAConstants;
import net.one97.paytm.upi.util.SimUtils;
import net.one97.paytm.upi.util.UpiConstants;
import net.one97.paytm.upi.util.UpiUtils;

public class g extends h implements b.C1388b {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public b.a f68871a;

    /* renamed from: b  reason: collision with root package name */
    private TextView f68872b;

    /* renamed from: c  reason: collision with root package name */
    private TextView f68873c;

    /* renamed from: d  reason: collision with root package name */
    private TextView f68874d;

    /* renamed from: e  reason: collision with root package name */
    private TextView f68875e;

    /* renamed from: f  reason: collision with root package name */
    private ImageView f68876f;

    /* renamed from: g  reason: collision with root package name */
    private ImageView f68877g;

    /* renamed from: h  reason: collision with root package name */
    private View f68878h;

    /* renamed from: i  reason: collision with root package name */
    private v f68879i;
    /* access modifiers changed from: private */
    public List<SubscriptionInfo> j;
    /* access modifiers changed from: private */
    public int k;

    public final /* bridge */ /* synthetic */ void a(Object obj) {
    }

    public static g a(AccountProviderBody.AccountProvider accountProvider, int i2) {
        g gVar = new g();
        Bundle bundle = new Bundle();
        bundle.putSerializable(UpiConstants.EXTRA_SELECTED_BANK, accountProvider);
        bundle.putInt(UpiConstants.EXTRA_REG_ERROR_CAUSE, i2);
        gVar.setArguments(bundle);
        return gVar;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.k = -1;
        if (getArguments() != null) {
            int i2 = getArguments().getInt(UpiConstants.EXTRA_REG_ERROR_CAUSE);
            getActivity();
            getActivity();
            this.f68871a = new net.one97.paytm.upi.registration.presenter.b(net.one97.paytm.upi.g.a(a.a(net.one97.paytm.upi.g.d(), (a.C1347a) null)), this, (AccountProviderBody.AccountProvider) getArguments().getSerializable(UpiConstants.EXTRA_SELECTED_BANK), i2);
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        String str;
        View inflate = layoutInflater.inflate(R.layout.fragment_upi_registration_multi_sim, viewGroup, false);
        View findViewById = inflate.findViewById(R.id.accountSwitch);
        if (findViewById != null) {
            ac a2 = ac.a(findViewById);
            TextView textView = (TextView) inflate.findViewById(R.id.selectedMobile);
            if (textView != null) {
                View findViewById2 = inflate.findViewById(R.id.simSelection);
                if (findViewById2 != null) {
                    ae a3 = ae.a(findViewById2);
                    TextView textView2 = (TextView) inflate.findViewById(R.id.tv_cancel);
                    if (textView2 != null) {
                        TextView textView3 = (TextView) inflate.findViewById(R.id.tv_error_desc);
                        if (textView3 != null) {
                            TextView textView4 = (TextView) inflate.findViewById(R.id.tv_error_title);
                            if (textView4 != null) {
                                TextView textView5 = (TextView) inflate.findViewById(R.id.tv_proceed_send_sms);
                                if (textView5 != null) {
                                    this.f68879i = new v((ConstraintLayout) inflate, a2, textView, a3, textView2, textView3, textView4, textView5);
                                    this.f68876f = (ImageView) inflate.findViewById(R.id.iv_icon);
                                    this.f68878h = inflate.findViewById(R.id.fl_icon);
                                    this.f68877g = (ImageView) inflate.findViewById(R.id.redErrorIcon);
                                    this.f68872b = (TextView) inflate.findViewById(R.id.tv_error_title);
                                    this.f68873c = (TextView) inflate.findViewById(R.id.tv_error_desc);
                                    String b2 = com.paytm.utility.a.b(getContext());
                                    if (!TextUtils.isEmpty(b2)) {
                                        this.f68879i.f66912b.setText(getString(R.string.upi_device_binding_selected_mobile_text, b2));
                                        this.f68879i.f66916f.setText(getString(R.string.upi_verify_mobile_number_dynamic, b2));
                                    }
                                    this.f68879i.f66913c.f66748e.setOnClickListener(new View.OnClickListener() {
                                        public final void onClick(View view) {
                                            g.this.c(view);
                                        }
                                    });
                                    this.f68879i.f66913c.f66749f.setOnClickListener(new View.OnClickListener() {
                                        public final void onClick(View view) {
                                            g.this.b(view);
                                        }
                                    });
                                    this.f68879i.f66911a.f66737a.setVisibility(0);
                                    this.f68879i.f66911a.f66738b.setText(getString(R.string.upi_account_change_bottom_bar_text, com.paytm.utility.a.b(getContext())));
                                    this.f68879i.f66911a.f66737a.setOnClickListener(new View.OnClickListener() {
                                        public final void onClick(View view) {
                                            g.this.a(view);
                                        }
                                    });
                                    this.f68874d = (TextView) inflate.findViewById(R.id.tv_proceed_send_sms);
                                    this.f68874d.setOnClickListener(new View.OnClickListener() {
                                        /* JADX WARNING: Removed duplicated region for block: B:13:0x0049 A[RETURN] */
                                        /* JADX WARNING: Removed duplicated region for block: B:14:0x004a  */
                                        /* Code decompiled incorrectly, please refer to instructions dump. */
                                        public final void onClick(android.view.View r10) {
                                            /*
                                                r9 = this;
                                                net.one97.paytm.upi.registration.view.g r10 = net.one97.paytm.upi.registration.view.g.this
                                                int r10 = r10.k
                                                r0 = 0
                                                java.lang.String r1 = "Please select a SIM card to send SMS"
                                                r2 = -1
                                                if (r10 != r2) goto L_0x0019
                                                net.one97.paytm.upi.registration.view.g r10 = net.one97.paytm.upi.registration.view.g.this
                                                android.content.Context r10 = r10.getContext()
                                                android.widget.Toast r10 = android.widget.Toast.makeText(r10, r1, r0)
                                                r10.show()
                                            L_0x0019:
                                                int r10 = android.os.Build.VERSION.SDK_INT
                                                r3 = 22
                                                if (r10 < r3) goto L_0x0046
                                                net.one97.paytm.upi.registration.view.g r10 = net.one97.paytm.upi.registration.view.g.this
                                                java.util.List r10 = r10.j
                                                java.util.Iterator r10 = r10.iterator()
                                            L_0x0029:
                                                boolean r4 = r10.hasNext()
                                                if (r4 == 0) goto L_0x0046
                                                java.lang.Object r4 = r10.next()
                                                android.telephony.SubscriptionInfo r4 = (android.telephony.SubscriptionInfo) r4
                                                int r5 = r4.getSimSlotIndex()
                                                net.one97.paytm.upi.registration.view.g r6 = net.one97.paytm.upi.registration.view.g.this
                                                int r6 = r6.k
                                                if (r5 != r6) goto L_0x0029
                                                int r10 = r4.getSubscriptionId()
                                                goto L_0x0047
                                            L_0x0046:
                                                r10 = -1
                                            L_0x0047:
                                                if (r10 != r2) goto L_0x004a
                                                return
                                            L_0x004a:
                                                net.one97.paytm.upi.registration.view.g r2 = net.one97.paytm.upi.registration.view.g.this
                                                int r2 = r2.k
                                                if (r2 != 0) goto L_0x0077
                                                int r0 = android.os.Build.VERSION.SDK_INT
                                                if (r0 < r3) goto L_0x00b2
                                                net.one97.paytm.upi.registration.view.g r0 = net.one97.paytm.upi.registration.view.g.this
                                                android.content.Context r1 = r0.getContext()
                                                java.lang.String r2 = "bhim_upi"
                                                java.lang.String r3 = "sim_selection"
                                                java.lang.String r4 = "sim1"
                                                java.lang.String r5 = ""
                                                java.lang.String r6 = ""
                                                java.lang.String r7 = ""
                                                java.lang.String r8 = "wallet"
                                                net.one97.paytm.upi.util.CJRSendGTMTag.sendNewCustomGTMEvents(r1, r2, r3, r4, r5, r6, r7, r8)
                                                net.one97.paytm.upi.registration.view.g r0 = net.one97.paytm.upi.registration.view.g.this
                                                net.one97.paytm.upi.registration.a.b$a r0 = r0.f68871a
                                                r0.a(r10)
                                                return
                                            L_0x0077:
                                                net.one97.paytm.upi.registration.view.g r2 = net.one97.paytm.upi.registration.view.g.this
                                                int r2 = r2.k
                                                r4 = 1
                                                if (r2 != r4) goto L_0x00a5
                                                int r0 = android.os.Build.VERSION.SDK_INT
                                                if (r0 < r3) goto L_0x00b2
                                                net.one97.paytm.upi.registration.view.g r0 = net.one97.paytm.upi.registration.view.g.this
                                                android.content.Context r1 = r0.getContext()
                                                java.lang.String r2 = "bhim_upi"
                                                java.lang.String r3 = "sim_selection"
                                                java.lang.String r4 = "sim2"
                                                java.lang.String r5 = ""
                                                java.lang.String r6 = ""
                                                java.lang.String r7 = ""
                                                java.lang.String r8 = "wallet"
                                                net.one97.paytm.upi.util.CJRSendGTMTag.sendNewCustomGTMEvents(r1, r2, r3, r4, r5, r6, r7, r8)
                                                net.one97.paytm.upi.registration.view.g r0 = net.one97.paytm.upi.registration.view.g.this
                                                net.one97.paytm.upi.registration.a.b$a r0 = r0.f68871a
                                                r0.b(r10)
                                                return
                                            L_0x00a5:
                                                net.one97.paytm.upi.registration.view.g r10 = net.one97.paytm.upi.registration.view.g.this
                                                android.content.Context r10 = r10.getContext()
                                                android.widget.Toast r10 = android.widget.Toast.makeText(r10, r1, r0)
                                                r10.show()
                                            L_0x00b2:
                                                return
                                            */
                                            throw new UnsupportedOperationException("Method not decompiled: net.one97.paytm.upi.registration.view.g.AnonymousClass1.onClick(android.view.View):void");
                                        }
                                    });
                                    this.f68875e = (TextView) inflate.findViewById(R.id.tv_cancel);
                                    this.f68875e.setOnClickListener(new View.OnClickListener() {
                                        public final void onClick(View view) {
                                            if (g.this.isAdded()) {
                                                g.this.getActivity().finish();
                                            }
                                        }
                                    });
                                    CJRSendGTMTag.sendNewCustomGTMEvents(getContext(), CJRGTMConstants.GTM_EVENT_CATEGORY_BHIM_UPI, "sim_selection", "dialog_opens", "", "", "", "wallet");
                                    CJRSendGTMTag.sendNewCustomGTMEvents(getContext(), GAConstants.CATEGORY.UPI_ONB_V1, "screen_open", "dialog_opens", "", "", GAConstants.SCREEN_NAME.UPI_ONB_SIM_SELECTION_INTERNAL, "wallet");
                                    this.f68871a.e();
                                    return inflate;
                                }
                                str = "tvProceedSendSms";
                            } else {
                                str = "tvErrorTitle";
                            }
                        } else {
                            str = "tvErrorDesc";
                        }
                    } else {
                        str = "tvCancel";
                    }
                } else {
                    str = "simSelection";
                }
            } else {
                str = "selectedMobile";
            }
        } else {
            str = "accountSwitch";
        }
        throw new NullPointerException("Missing required view with ID: ".concat(str));
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void c(View view) {
        this.k = 0;
        this.f68879i.f66913c.f66748e.setBackground(androidx.core.content.b.a(getContext(), R.drawable.upi_sim_box_selected));
        this.f68879i.f66913c.f66749f.setBackground(androidx.core.content.b.a(getContext(), R.drawable.upi_sim_box_unselected));
        CJRSendGTMTag.sendNewCustomGTMEvents(getContext(), GAConstants.CATEGORY.MT_ONB_DEVICE_BINDING, GAConstants.ACTION.SIM_SELECTED_SLOT, "slot 1", "", "", GAConstants.SCREEN_NAME.UPI_ONB_SIM_SELECTION_INTERNAL, "wallet");
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void b(View view) {
        this.k = 1;
        this.f68879i.f66913c.f66748e.setBackground(androidx.core.content.b.a(getContext(), R.drawable.upi_sim_box_unselected));
        this.f68879i.f66913c.f66749f.setBackground(androidx.core.content.b.a(getContext(), R.drawable.upi_sim_box_selected));
        CJRSendGTMTag.sendNewCustomGTMEvents(getContext(), GAConstants.CATEGORY.MT_ONB_DEVICE_BINDING, GAConstants.ACTION.SIM_SELECTED_SLOT, "slot 2", "", "", GAConstants.SCREEN_NAME.UPI_ONB_SIM_SELECTION_INTERNAL, "wallet");
    }

    public final void a(int i2, String str) {
        if (TextUtils.isEmpty(str)) {
            getString(R.string.upi_bank);
        }
        if (i2 == UpiConstants.RegistrationErrorOrigin.MOBIlE_NOT_REGISTERED.ordinal()) {
            this.f68872b.setText(getString(R.string.upi_error_other_error_title));
            this.f68872b.setTextColor(androidx.core.content.b.c(getActivity(), R.color.color_fd5c5c));
            this.f68873c.setText(getString(R.string.upi_new_error_multi_sim_mobile_not_registered_desc, i.a().f66981b));
            this.f68878h.setBackground(androidx.core.content.b.a((Context) getActivity(), R.drawable.upi_bg_circle_red));
            this.f68876f.setImageResource(R.drawable.ic_upi_multi_sim);
            this.f68878h.setVisibility(0);
            this.f68877g.setVisibility(0);
        } else if (i2 == UpiConstants.RegistrationErrorOrigin.VERIFY_MOBILE_NUMBER.ordinal()) {
            this.f68872b.setText(getString(R.string.upi_verify_mobile_number_dynamic, com.paytm.utility.a.b(getContext())));
            this.f68873c.setText(getString(R.string.upi_new_device_binding_message));
        } else if (i2 == UpiConstants.RegistrationErrorOrigin.SMS_NOT_RECEIVED.ordinal()) {
            this.f68872b.setText(getString(R.string.upi_error_other_error_title));
            this.f68872b.setTextColor(androidx.core.content.b.c(getActivity(), R.color.color_fd5c5c));
            this.f68873c.setText(getString(R.string.upi_error_sms_not_received_desc_new));
            this.f68878h.setBackground(androidx.core.content.b.a((Context) getActivity(), R.drawable.upi_bg_circle_red));
            this.f68876f.setImageResource(R.drawable.ic_upi_multi_sim);
            this.f68878h.setVisibility(0);
            this.f68877g.setVisibility(0);
        } else if (i2 == UpiConstants.RegistrationErrorOrigin.SMS_TOKEN_EXPIRED.ordinal()) {
            this.f68872b.setText(getString(R.string.upi_error_other_error_title));
            this.f68872b.setTextColor(androidx.core.content.b.c(getActivity(), R.color.color_fd5c5c));
            this.f68873c.setText(getString(R.string.upi_error_sms_not_received_desc_new));
            this.f68878h.setBackground(androidx.core.content.b.a((Context) getActivity(), R.drawable.upi_bg_circle_red));
            this.f68876f.setImageResource(R.drawable.ic_upi_multi_sim);
            this.f68878h.setVisibility(0);
            this.f68877g.setVisibility(0);
        } else if (i2 == UpiConstants.RegistrationErrorOrigin.NETWORK_CONNECTION_ERROR.ordinal()) {
            this.f68872b.setText(getString(R.string.upi_error_other_error_title));
            this.f68872b.setTextColor(androidx.core.content.b.c(getActivity(), R.color.color_fd5c5c));
            this.f68873c.setText(getString(R.string.no_internet_new_message));
            this.f68878h.setBackground(androidx.core.content.b.a((Context) getActivity(), R.drawable.upi_bg_circle_red));
            this.f68876f.setImageResource(R.drawable.ic_upi_multi_sim);
            this.f68878h.setVisibility(0);
            this.f68877g.setVisibility(0);
        } else if (i2 == UpiConstants.RegistrationErrorOrigin.SETUP_PROFILE_ERROR.ordinal()) {
            this.f68872b.setText(getString(R.string.upi_verify_mobile_number_title_new));
            this.f68873c.setText(getString(R.string.upi_multi_sim_verify_mobile_number_desc_new));
        } else {
            this.f68872b.setText(getString(R.string.upi_error_other_error_title));
            this.f68872b.setTextColor(androidx.core.content.b.c(getActivity(), R.color.color_fd5c5c));
            this.f68873c.setText(getString(R.string.upi_error_other_error_desc_new));
            this.f68878h.setBackground(androidx.core.content.b.a((Context) getActivity(), R.drawable.upi_bg_circle_red));
            this.f68876f.setImageResource(R.drawable.ic_upi_multi_sim);
            this.f68878h.setVisibility(0);
            this.f68877g.setVisibility(0);
        }
    }

    public final void a(int i2, AccountProviderBody.AccountProvider accountProvider) {
        if (getActivity() != null && (getActivity() instanceof UpiRegistrationActivity)) {
            ((UpiRegistrationActivity) getActivity()).b(accountProvider, i2);
        }
    }

    public final void a() {
        this.j = UpiUtils.getAllCarrier(getActivity());
        if (this.j != null && Build.VERSION.SDK_INT >= 22) {
            SimUtils.TelcoOperatorModel gTMOperatorMapping = SimUtils.Companion.getGTMOperatorMapping();
            boolean z = false;
            boolean z2 = false;
            for (SubscriptionInfo next : this.j) {
                if (next.getSimSlotIndex() == 0) {
                    if (next.getCarrierName() != null) {
                        this.f68879i.f66913c.f66744a.setText(next.getCarrierName().toString());
                    }
                    this.f68879i.f66913c.f66750g.setText(getString(R.string.upi_sim_1));
                    if (next.getCarrierName() != null) {
                        a(next.getCarrierName().toString(), this.f68879i.f66913c.f66746c, gTMOperatorMapping);
                    }
                    z = true;
                } else if (next.getSimSlotIndex() == 1) {
                    if (next.getCarrierName() != null) {
                        this.f68879i.f66913c.f66745b.setText(next.getCarrierName().toString());
                    }
                    this.f68879i.f66913c.f66751h.setText(getString(R.string.upi_sim_2));
                    if (next.getCarrierName() != null) {
                        a(next.getCarrierName().toString(), this.f68879i.f66913c.f66747d, gTMOperatorMapping);
                    }
                    z2 = true;
                }
            }
            if (z) {
                this.f68879i.f66913c.f66748e.setVisibility(0);
            } else {
                this.f68879i.f66913c.f66748e.setVisibility(8);
            }
            if (z2) {
                this.f68879i.f66913c.f66749f.setVisibility(0);
            } else {
                this.f68879i.f66913c.f66749f.setVisibility(8);
            }
        }
    }

    public void onDetach() {
        super.onDetach();
        this.f68871a.f();
        this.f68879i = null;
    }

    private static void a(String str, ImageView imageView, SimUtils.TelcoOperatorModel telcoOperatorModel) {
        if (telcoOperatorModel != null && telcoOperatorModel.getTelcoIconsMap() != null) {
            String uRLFromMap = SimUtils.Companion.getURLFromMap(str, telcoOperatorModel.getTelcoIconsMap());
            if (!TextUtils.isEmpty(uRLFromMap)) {
                w.a().a(uRLFromMap).a(imageView, (e) null);
            }
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(View view) {
        if (isAdded()) {
            h.a aVar = h.f68882a;
            new h().showNow(getChildFragmentManager(), h.class.getName());
        }
    }
}
