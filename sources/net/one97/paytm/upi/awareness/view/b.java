package net.one97.paytm.upi.awareness.view;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import com.airbnb.lottie.LottieAnimationView;
import net.one97.paytm.i.h;
import net.one97.paytm.upi.R;
import net.one97.paytm.upi.common.UpiBaseDataModel;
import net.one97.paytm.upi.common.UpiCustomVolleyError;
import net.one97.paytm.upi.common.models.UpiAvailabilityModel;
import net.one97.paytm.upi.common.upi.AccountProviderBody;
import net.one97.paytm.upi.common.upi.UpiProfileDefaultBank;
import net.one97.paytm.upi.common.upi.UpiProfileModel;
import net.one97.paytm.upi.g;
import net.one97.paytm.upi.h.a;
import net.one97.paytm.upi.profile.b.a;
import net.one97.paytm.upi.profile.view.BankVpaCreationActivity;
import net.one97.paytm.upi.registration.b.a.a;
import net.one97.paytm.upi.registration.view.AccountProviderActivity;
import net.one97.paytm.upi.registration.view.UpiSelectBankActivity;
import net.one97.paytm.upi.registration.view.k;
import net.one97.paytm.upi.util.UpiConstants;
import net.one97.paytm.upi.util.UpiUtils;

public class b extends h {

    /* renamed from: a  reason: collision with root package name */
    private final String f66580a = "UpiOnboardingCallbackActivity";
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public LottieAnimationView f66581b;

    /* renamed from: c  reason: collision with root package name */
    private TextView f66582c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public String f66583d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public boolean f66584e;

    public static b a() {
        b bVar = new b();
        Bundle bundle = new Bundle();
        bundle.putBoolean(UpiConstants.EXTRA_IS_FROM_REFUND, true);
        bundle.putString(UpiConstants.EXTRA_REGISTRATION_REDIRECT_URL, UpiConstants.REFUND_TO_SOURCE);
        bVar.setArguments(bundle);
        return bVar;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (getArguments() != null) {
            this.f66584e = getArguments().getBoolean(UpiConstants.EXTRA_IS_FROM_REFUND, false);
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.fragment_upi_onboarding_callback, viewGroup, false);
        this.f66581b = (LottieAnimationView) inflate.findViewById(R.id.lav_progress);
        this.f66582c = (TextView) inflate.findViewById(R.id.tv_please_wait);
        UpiUtils.startWalletLoader(this.f66581b);
        if (this.f66584e) {
            this.f66581b.setVisibility(8);
            this.f66582c.setVisibility(8);
        } else {
            this.f66581b.setVisibility(0);
            this.f66582c.setVisibility(0);
        }
        getActivity();
        g.a((a) null).e(new a.C1389a() {
            public final void onSuccess(UpiBaseDataModel upiBaseDataModel) {
                if (b.this.getActivity() != null) {
                    UpiAvailabilityModel upiAvailabilityModel = (UpiAvailabilityModel) upiBaseDataModel;
                    if (upiAvailabilityModel == null || upiAvailabilityModel.getResponse() == null) {
                        b.this.c();
                    } else if (upiAvailabilityModel.getResponse().isUpiUser()) {
                        b.b(b.this);
                    } else {
                        UpiUtils.stopWalletLoader(b.this.f66581b);
                        if (upiAvailabilityModel.getResponse().isUpiProfileExist()) {
                            b bVar = b.this;
                            bVar.startActivityForResult(UpiUtils.getUpiLandingPageActivityIntent(bVar.getContext()), UpiConstants.REQUEST_CODE_UPI_LANDING_PAGE);
                        } else if (b.this.f66584e) {
                            b.this.getActivity().getSupportFragmentManager().a().a(R.id.fragment_container, k.c((String) null), "list_fragment").a("list_fragment").c();
                            b.this.getActivity().getSupportFragmentManager().a().a((Fragment) b.this).c();
                        } else {
                            Intent intent = new Intent(b.this.getActivity(), UpiSelectBankActivity.class);
                            intent.putExtra(UpiConstants.EXTRA_REGISTRATION_REDIRECT_URL, UpiConstants.UPI_ONBOARDING_SELF_DESTROY);
                            b.this.startActivityForResult(intent, 352);
                        }
                    }
                }
            }

            public final void onError(UpiCustomVolleyError upiCustomVolleyError) {
                if (b.this.getActivity() != null) {
                    UpiUtils.stopWalletLoader(b.this.f66581b);
                    if (b.this.f66584e) {
                        b.this.getActivity().getSupportFragmentManager().a().a(R.id.fragment_container, k.c((String) null), "list_fragment").a("list_fragment").c();
                        b.this.getActivity().getSupportFragmentManager().a().a((Fragment) b.this).c();
                        return;
                    }
                    Intent intent = new Intent(b.this.getActivity(), UpiSelectBankActivity.class);
                    intent.putExtra(UpiConstants.EXTRA_REGISTRATION_REDIRECT_URL, UpiConstants.UPI_ONBOARDING_SELF_DESTROY);
                    b.this.startActivityForResult(intent, 352);
                }
            }
        }, "UpiOnboardingCallbackActivity", "");
        return inflate;
    }

    public void onActivityResult(int i2, int i3, Intent intent) {
        if (i3 != -1) {
            c();
        } else if (i2 == 288) {
            if (TextUtils.isEmpty(this.f66583d)) {
                c();
            } else {
                BankVpaCreationActivity.a((Fragment) this, (AccountProviderBody.AccountProvider) intent.getSerializableExtra(UpiConstants.EXTRA_ACCOUNT_PROVIDER), this.f66583d, 304);
            }
        } else if (i2 == 304) {
            b();
        } else if (i2 == 1212) {
            b();
        } else if (i2 == 352) {
            b();
        }
    }

    private void b() {
        if (this.f66584e) {
            getActivity().getSupportFragmentManager().a((String) null, 0);
            return;
        }
        getActivity().setResult(-1, getActivity().getIntent());
        getActivity().finish();
    }

    /* access modifiers changed from: private */
    public void c() {
        if (this.f66584e) {
            getActivity().getSupportFragmentManager().a((String) null, 0);
            return;
        }
        getActivity().setResult(0, getActivity().getIntent());
        getActivity().finish();
    }

    static /* synthetic */ void b(b bVar) {
        bVar.getActivity();
        g.a().a((a.C1382a) new a.C1382a() {
            public final void onSuccess(UpiBaseDataModel upiBaseDataModel) {
                if (b.this.getActivity() != null) {
                    UpiUtils.stopWalletLoader(b.this.f66581b);
                    if (upiBaseDataModel instanceof UpiProfileModel) {
                        UpiProfileModel upiProfileModel = (UpiProfileModel) upiBaseDataModel;
                        if (!upiProfileModel.getStatus().equalsIgnoreCase("SUCCESS") || !"0".equalsIgnoreCase(upiProfileModel.getRespCode())) {
                            b.this.c();
                        } else if (upiProfileModel.getResponse() == null || upiProfileModel.getResponse().getProfileDetail().getProfileVpaList() == null) {
                            b.this.c();
                        } else {
                            for (UpiProfileDefaultBank next : upiProfileModel.getResponse().getProfileDetail().getProfileVpaList()) {
                                if (next.isPrimary()) {
                                    String unused = b.this.f66583d = next.getVirtualAddress();
                                    if (b.this.f66584e) {
                                        b.this.getActivity().getSupportFragmentManager().a().a(R.id.fragment_container, k.c(b.this.f66583d), "list_fragment").a("list_fragment").c();
                                        b.this.getActivity().getSupportFragmentManager().a().a((Fragment) b.this).c();
                                        return;
                                    }
                                    AccountProviderActivity.a((Fragment) b.this, 288);
                                    return;
                                }
                            }
                        }
                    } else {
                        b.this.c();
                    }
                }
            }

            public final void onError(UpiCustomVolleyError upiCustomVolleyError) {
                UpiUtils.stopWalletLoader(b.this.f66581b);
                b.this.c();
            }
        }, "UpiOnboardingCallbackActivity", "");
    }
}
