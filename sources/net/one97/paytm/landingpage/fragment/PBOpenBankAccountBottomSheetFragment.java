package net.one97.paytm.landingpage.fragment;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.j;
import com.airbnb.lottie.LottieAnimationView;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.a;
import com.paytm.network.a;
import com.paytm.network.listener.b;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import com.paytm.utility.q;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants;
import java.util.HashMap;
import net.one97.paytm.common.entity.paymentsbank.CustProductList;
import net.one97.paytm.common.entity.paymentsbank.CustProductStatus;
import net.one97.paytm.i.f;
import net.one97.paytm.j.c;
import net.one97.paytm.paytm_finance.R;
import net.one97.paytm.upi.util.UpiConstants;
import net.one97.paytm.upi.util.UpiUtils;
import net.one97.paytm.utils.ag;
import net.one97.paytm.utils.r;
import org.json.JSONException;
import org.json.JSONObject;

public class PBOpenBankAccountBottomSheetFragment extends f implements b {
    /* access modifiers changed from: private */
    public BottomSheetBehavior behavior;
    private ViewGroup buttonLayout;
    private LottieAnimationView loader;
    private Button mBtnOpenAccount;
    private ImageView mIvCross;
    private TextView mTvKnowMore;

    public Dialog onCreateDialog(Bundle bundle) {
        a aVar = (a) super.onCreateDialog(bundle);
        aVar.setOnShowListener(new DialogInterface.OnShowListener() {
            public final void onShow(DialogInterface dialogInterface) {
                FrameLayout frameLayout = (FrameLayout) ((a) dialogInterface).findViewById(R.id.design_bottom_sheet);
                frameLayout.setBackgroundDrawable(new ColorDrawable(0));
                if (frameLayout != null) {
                    BottomSheetBehavior unused = PBOpenBankAccountBottomSheetFragment.this.behavior = BottomSheetBehavior.from(frameLayout);
                }
                PBOpenBankAccountBottomSheetFragment.this.setUpBehaviorCallBack();
            }
        });
        aVar.getWindow().setBackgroundDrawable(new ColorDrawable(0));
        return aVar;
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.ppb_fragment_open_account_bottom_sheet, viewGroup, false);
        initViews(inflate);
        return inflate;
    }

    /* access modifiers changed from: private */
    public void setUpBehaviorCallBack() {
        this.behavior.setBottomSheetCallback(new BottomSheetBehavior.a() {
            public final void onSlide(View view, float f2) {
            }

            public final void onStateChanged(View view, int i2) {
                if (i2 == 1) {
                    c.a();
                    if (c.a("full_kyc_pop_up_mandate", false)) {
                        PBOpenBankAccountBottomSheetFragment.this.behavior.setState(3);
                    }
                }
            }
        });
    }

    private void initViews(View view) {
        String str;
        this.mBtnOpenAccount = (Button) view.findViewById(R.id.open_acc_btn);
        this.mIvCross = (ImageView) view.findViewById(R.id.full_kyc_cross_iv);
        this.mTvKnowMore = (TextView) view.findViewById(R.id.full_kyc_know_more_tv);
        this.loader = (LottieAnimationView) view.findViewById(R.id.wallet_loader);
        this.buttonLayout = (ViewGroup) view.findViewById(R.id.buttonLayout);
        c.a();
        if (!TextUtils.isEmpty(c.J())) {
            c.a();
            String[] split = c.J().split("##");
            if (split.length > 1) {
                str = split[1];
                ((TextView) view.findViewById(R.id.full_kyc_yellow_strip_complete_kyc_tv)).setText(getString(R.string.pb_earn_interest_upto, str));
                getDialog().setCanceledOnTouchOutside(true);
                this.mBtnOpenAccount.setOnClickListener(new View.OnClickListener() {
                    public final void onClick(View view) {
                        PBOpenBankAccountBottomSheetFragment.this.getCustomerProductList();
                    }
                });
                this.mIvCross.setOnClickListener(new View.OnClickListener() {
                    public final void onClick(View view) {
                        PBOpenBankAccountBottomSheetFragment.this.dismissAllowingStateLoss();
                    }
                });
                this.mTvKnowMore.setOnClickListener(new View.OnClickListener() {
                    public final void onClick(View view) {
                        net.one97.paytm.payments.d.a.a((Activity) PBOpenBankAccountBottomSheetFragment.this.getActivity(), "paytmmp://payment_bank?featuretype=open_acc_base&extraDefaultFrame=5");
                        PBOpenBankAccountBottomSheetFragment.this.dismissAllowingStateLoss();
                    }
                });
            }
        }
        str = "6.85%";
        ((TextView) view.findViewById(R.id.full_kyc_yellow_strip_complete_kyc_tv)).setText(getString(R.string.pb_earn_interest_upto, str));
        getDialog().setCanceledOnTouchOutside(true);
        this.mBtnOpenAccount.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                PBOpenBankAccountBottomSheetFragment.this.getCustomerProductList();
            }
        });
        this.mIvCross.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                PBOpenBankAccountBottomSheetFragment.this.dismissAllowingStateLoss();
            }
        });
        this.mTvKnowMore.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                net.one97.paytm.payments.d.a.a((Activity) PBOpenBankAccountBottomSheetFragment.this.getActivity(), "paytmmp://payment_bank?featuretype=open_acc_base&extraDefaultFrame=5");
                PBOpenBankAccountBottomSheetFragment.this.dismissAllowingStateLoss();
            }
        });
    }

    /* access modifiers changed from: private */
    public void getCustomerProductList() {
        HashMap hashMap = new HashMap();
        hashMap.put("screen_name", getClass().getSimpleName());
        com.paytm.network.a a2 = net.one97.paytm.payments.b.a.a.a(getActivity(), this, a.c.PAYMENTSBANK, a.b.USER_FACING, hashMap);
        if (com.paytm.utility.a.m(getActivity())) {
            setAnimation(this.loader);
            a2.a();
        }
    }

    private void getCustomerProductStatus(String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("screen_name", getClass().getSimpleName());
        HashMap hashMap2 = new HashMap();
        hashMap2.put("User-Token", com.paytm.utility.a.q(getActivity()));
        hashMap2.put("Content-Type", "application/json");
        hashMap2.put("channel", UpiConstants.B2C_ANDROID);
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("channel", UpiConstants.B2C_ANDROID);
            jSONObject.put("productRequested", str);
        } catch (JSONException unused) {
        }
        String jSONObject2 = jSONObject.toString();
        c.a();
        String e2 = com.paytm.utility.b.e((Context) getActivity(), c.a("ppb_custprod_prereq", (String) null));
        com.paytm.network.b bVar = new com.paytm.network.b();
        bVar.f42877a = getContext();
        bVar.f42879c = a.C0715a.POST;
        bVar.f42884h = jSONObject2;
        bVar.f42880d = e2;
        bVar.f42882f = hashMap2;
        bVar.f42885i = new CustProductStatus();
        bVar.k = false;
        bVar.f42878b = a.c.PAYMENTSBANK;
        bVar.o = (String) hashMap.get("screen_name");
        bVar.n = a.b.USER_FACING;
        bVar.j = this;
        com.paytm.network.a l = bVar.l();
        if (com.paytm.utility.a.m(getActivity())) {
            setAnimation(this.loader);
            l.a();
        }
    }

    private void setAnimation(LottieAnimationView lottieAnimationView) {
        this.buttonLayout.setVisibility(8);
        lottieAnimationView.setVisibility(0);
        lottieAnimationView.setAnimation("Payments-Loader.json");
        lottieAnimationView.loop(true);
        lottieAnimationView.playAnimation();
    }

    private void stopAnimation(LottieAnimationView lottieAnimationView) {
        this.buttonLayout.setVisibility(0);
        lottieAnimationView.cancelAnimation();
        lottieAnimationView.setVisibility(8);
    }

    public void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
        stopAnimation(this.loader);
        if (networkCustomError != null && !TextUtils.isEmpty(networkCustomError.getMessage()) && (networkCustomError.getMessage().equalsIgnoreCase("410") || networkCustomError.getMessage().equalsIgnoreCase(UpiUtils.AUTHENTICATION_FAILURE_401))) {
            r.a((Activity) getActivity(), (Exception) networkCustomError, (String) null, (Bundle) null);
        }
        dismissAllowingStateLoss();
    }

    public void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
        stopAnimation(this.loader);
        if (iJRPaytmDataModel instanceof CustProductList) {
            CustProductList custProductList = (CustProductList) iJRPaytmDataModel;
            if (!TextUtils.isEmpty(custProductList.getErrorMessage())) {
                com.paytm.utility.b.b((Context) getActivity(), getString(R.string.error), custProductList.getErrorMessage());
            } else if (TextUtils.isEmpty(custProductList.getIsaStatus())) {
            } else {
                if (custProductList.getIsaStatus().equals("NOT_ELIGIBLE")) {
                    com.paytm.utility.b.b((Context) getActivity(), getString(R.string.alert), getString(R.string.pb_not_eligible_apply));
                } else if (custProductList.getIsaStatus().equals("NOT_APPLIED") || custProductList.getIsaStatus().equals("LEAD")) {
                    getCustomerProductStatus("ISA");
                } else if (custProductList.getIsaStatus().equals("FAILED") || custProductList.getIsaStatus().equals("IN_PROGRESS") || custProductList.getIsaStatus().equals("INITIATED") || custProductList.getIsaStatus().equals("PENDING")) {
                    net.one97.paytm.utils.a.b.b((Context) getActivity(), 2);
                    dismiss();
                } else if (custProductList.getIsaStatus().equals("ISSUED")) {
                    net.one97.paytm.utils.a.b.b((Context) getActivity(), 3);
                    dismiss();
                }
            }
        } else if (iJRPaytmDataModel instanceof CustProductStatus) {
            CustProductStatus custProductStatus = (CustProductStatus) iJRPaytmDataModel;
            if (!TextUtils.isEmpty(custProductStatus.getProduct()) && custProductStatus.getProduct().equalsIgnoreCase("ISA")) {
                if (!TextUtils.isEmpty(custProductStatus.getPasscode())) {
                    if (custProductStatus.getPasscode().equalsIgnoreCase("Y")) {
                        net.one97.paytm.utils.a.b.b((Context) getActivity(), true);
                    } else {
                        net.one97.paytm.utils.a.b.b((Context) getActivity(), false);
                    }
                }
                if (!TextUtils.isEmpty(custProductStatus.getKYC())) {
                    FragmentActivity activity = getActivity();
                    ag.a(activity.getApplicationContext()).a("is_bank_kyc", custProductStatus.getKYC(), true);
                }
                if (!TextUtils.isEmpty(custProductStatus.getNominee())) {
                    FragmentActivity activity2 = getActivity();
                    ag.a(activity2.getApplicationContext()).a("nominee_status", custProductStatus.getNominee(), true);
                }
                if (!TextUtils.isEmpty(custProductStatus.getAadhaarRec())) {
                    FragmentActivity activity3 = getActivity();
                    ag.a(activity3.getApplicationContext()).a("is_aadhaar", custProductStatus.getAadhaarRec(), true);
                }
                if (!TextUtils.isEmpty(custProductStatus.getPanRec())) {
                    FragmentActivity activity4 = getActivity();
                    ag.a(activity4.getApplicationContext()).a("is_pan", custProductStatus.getPanRec(), true);
                }
                if (!TextUtils.isEmpty(custProductStatus.getForm60Rec())) {
                    FragmentActivity activity5 = getActivity();
                    ag.a(activity5.getApplicationContext()).a("is_form60", custProductStatus.getForm60Rec(), true);
                }
                if (getActivity() != null) {
                    decidePageandOpen(getActivity());
                    dismiss();
                }
            }
        }
    }

    public void decidePageandOpen(Activity activity) {
        if (activity != null) {
            boolean a2 = net.one97.paytm.utils.a.b.a(activity);
            String b2 = ag.a(activity.getApplicationContext()).b("nominee_status", UpiConstants.DEFAULT_ACCOUNT_NA_CONSTANT, true);
            String b3 = ag.a(activity.getApplicationContext()).b("is_bank_kyc", UpiConstants.DEFAULT_ACCOUNT_NA_CONSTANT, true);
            String b4 = ag.a(activity.getApplicationContext()).b("is_aadhaar", UpiConstants.DEFAULT_ACCOUNT_NA_CONSTANT, true);
            String b5 = ag.a(activity.getApplicationContext()).b("is_pan", UpiConstants.DEFAULT_ACCOUNT_NA_CONSTANT, true);
            ag.a(activity.getApplicationContext()).b("is_form60", UpiConstants.DEFAULT_ACCOUNT_NA_CONSTANT, true);
            if (!a2) {
                net.one97.paytm.payments.d.a.a(activity, "paytmmp://payment_bank?featuretype=open_acc_base&extraDefaultFrame=0");
            } else if (b2.equalsIgnoreCase(UpiConstants.DEFAULT_ACCOUNT_NA_CONSTANT)) {
                net.one97.paytm.payments.d.a.a(activity, "paytmmp://payment_bank?featuretype=open_acc_base&extraDefaultFrame=1");
            } else if (b3.equalsIgnoreCase("Y")) {
                if (b4.equalsIgnoreCase("Y")) {
                    if (b5.equalsIgnoreCase("Y")) {
                        net.one97.paytm.payments.d.a.a(activity, "paytmmp://payment_bank?featuretype=bank_acc_opened");
                    } else if (b5.equalsIgnoreCase(AppConstants.FEED_COMMUNITY_POST)) {
                        net.one97.paytm.payments.d.a.a(activity, "paytmmp://payment_bank?featuretype=bank_acc_requeseted&middle_text=" + activity.getString(R.string.bank_acc_open_after_verified));
                    } else if (b5.equalsIgnoreCase(UpiConstants.DEFAULT_ACCOUNT_NA_CONSTANT)) {
                        try {
                            net.one97.paytm.payments.d.a.a(activity, "paytmmp://payment_bank?featuretype=add_pan_card");
                        } catch (Exception e2) {
                            q.b(e2.getMessage());
                        }
                    }
                } else if (b4.equalsIgnoreCase(AppConstants.FEED_COMMUNITY_POST)) {
                    if (b5.equalsIgnoreCase(AppConstants.FEED_COMMUNITY_POST)) {
                        net.one97.paytm.payments.d.a.a(activity, "paytmmp://payment_bank?featuretype=bank_acc_requeseted&middle_text=" + activity.getString(R.string.verification_pending_for_bank));
                    } else if (b5.equalsIgnoreCase("Y")) {
                        net.one97.paytm.payments.d.a.a(activity, "paytmmp://payment_bank?featuretype=bank_acc_requeseted&middle_text=" + activity.getString(R.string.verification_aadhaar_for_bank));
                    } else if (b5.equalsIgnoreCase(UpiConstants.DEFAULT_ACCOUNT_NA_CONSTANT)) {
                        try {
                            net.one97.paytm.payments.d.a.a(activity, "paytmmp://payment_bank?featuretype=add_pan_card");
                        } catch (Exception e3) {
                            q.b(e3.getMessage());
                        }
                    }
                } else if (!b4.equalsIgnoreCase(UpiConstants.DEFAULT_ACCOUNT_NA_CONSTANT)) {
                } else {
                    if (b5.equalsIgnoreCase("Y") || b5.equalsIgnoreCase(AppConstants.FEED_COMMUNITY_POST)) {
                        try {
                            net.one97.paytm.payments.d.a.a(activity, "paytmmp://payment_bank?featuretype=add_aadhar_card");
                        } catch (Exception e4) {
                            q.b(e4.getMessage());
                        }
                    } else if (b5.equalsIgnoreCase(UpiConstants.DEFAULT_ACCOUNT_NA_CONSTANT)) {
                        try {
                            net.one97.paytm.payments.d.a.a(activity, "paytmmp://payment_bank?featuretype=add_aadhar_card");
                        } catch (Exception e5) {
                            q.b(e5.getMessage());
                        }
                    }
                }
            } else if (b3.equalsIgnoreCase(UpiConstants.DEFAULT_ACCOUNT_NA_CONSTANT)) {
                try {
                    net.one97.paytm.payments.d.a.a(activity, "paytmmp://payment_bank?featuretype=upgrade_kyc");
                } catch (Exception e6) {
                    q.b(e6.getMessage());
                }
            } else if (b3.equalsIgnoreCase(AppConstants.USER_SUB_TYPE)) {
                net.one97.paytm.payments.d.a.a(activity, "paytmmp://payment_bank?featuretype=bank_acc_requeseted&middle_text=");
            }
        }
    }

    public void show(j jVar, String str) {
        try {
            super.show(jVar, str);
        } catch (IllegalStateException unused) {
        }
    }
}
