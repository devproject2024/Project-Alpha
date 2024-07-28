package net.one97.paytm.payments.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import com.paytm.network.a;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import com.paytm.utility.b;
import com.paytm.utility.k;
import com.paytm.utility.q;
import com.paytm.utility.v;
import java.util.HashMap;
import net.one97.paytm.bankCommon.g.c;
import net.one97.paytm.bankCommon.g.d;
import net.one97.paytm.bankCommon.g.f;
import net.one97.paytm.bankCommon.g.g;
import net.one97.paytm.bankCommon.model.CustProductList;
import net.one97.paytm.bankCommon.model.PBBlockUnblockCardResponse;
import net.one97.paytm.bankCommon.utils.PinEntryView;
import net.one97.paytm.bankCommon.utils.g;
import net.one97.paytm.common.entity.wallet.CJRIMPSInitiateDataModel;
import net.one97.paytm.paymentsBank.R;
import net.one97.paytm.paymentsBank.forgotpasscode.ForgotPasscodeChallengesActivity;
import net.one97.paytm.paymentsBank.passcode.BankPasscodeActivity;
import net.one97.paytm.paymentsBank.utils.o;

public class AJREnterPasscode extends BankPasscodeActivity {
    private Context s;
    private int t;
    private CustProductList u;
    private String v;
    /* access modifiers changed from: private */
    public String w;
    /* access modifiers changed from: private */
    public boolean x;

    public enum a {
        SAVING_ACCOUNT_DETAILS,
        BLOCK_UNBLOCK_CARD,
        RETURN_TO_CALLER_ACTIVITY,
        ADD_NOMINEE
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.s = this;
        this.w = getIntent().getStringExtra("ENTER_HEADER");
        this.x = getIntent().getBooleanExtra("imps_passcode_flow", false);
        if (!TextUtils.isEmpty(this.w)) {
            if (this.w.equalsIgnoreCase("paytm-wallet-card_unblock")) {
                this.s.getResources().getString(R.string.wallet_card);
                this.v = this.s.getResources().getString(R.string.passcode_activate_card);
            } else if (this.w.equalsIgnoreCase("paytm-wallet-card_block")) {
                this.s.getResources().getString(R.string.wallet_card);
                this.v = this.s.getResources().getString(R.string.passcode_deactivate_card);
            } else if (this.w.equalsIgnoreCase("paytm_wallet_card_confirm")) {
                this.s.getResources().getString(R.string.wallet_card);
                this.v = this.s.getResources().getString(R.string.enter_passcode_to_link_wallet_card);
            } else if (this.w.equalsIgnoreCase("BLOCK_CARD")) {
                this.s.getResources().getString(R.string.block_card);
                this.v = this.s.getResources().getString(R.string.passcode_block_card);
            } else if (this.w.equalsIgnoreCase("UNBLOCK_CARD")) {
                this.s.getResources().getString(R.string.unblock_card);
                this.v = this.s.getResources().getString(R.string.passcode_unblock_card);
            } else if (this.w.equalsIgnoreCase("ADD_NOMINEE")) {
                this.s.getResources().getString(R.string.pb_add_nominee);
                this.v = this.s.getResources().getString(R.string.passcode_msg_add_nominee);
            } else if (this.w.equalsIgnoreCase("paytm_redeem_fd_passcode")) {
                this.s.getResources().getString(R.string.redeem_slfd);
                this.v = this.s.getResources().getString(R.string.passcode_title_redeem_slfd);
            } else if (this.w.equalsIgnoreCase("paytm_create_fd_passcode")) {
                this.s.getResources().getString(R.string.create_slfd);
                this.v = this.s.getResources().getString(R.string.passcode_title_create_slfd);
            } else if (this.x) {
                this.s.getResources().getString(R.string.passcode_required);
                this.v = this.s.getResources().getString(R.string.passcode_to_complete_txn);
            } else if (this.w.equalsIgnoreCase("paytm_saving_account_confirm")) {
                this.s.getResources().getString(R.string.passcode_required);
                this.v = getString(R.string.pb_please_enter_the_passcode);
            }
        }
        this.u = (CustProductList) getIntent().getSerializableExtra("CUST_PRODUCT");
        if (k.b()) {
            this.f18586f.setVisibility(8);
        } else {
            this.f18586f.setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    AJREnterPasscode.this.b(view);
                }
            });
        }
        this.f18587g.setText(this.v);
        this.f18584d.setOnPinEnteredListener(new PinEntryView.b() {
            public final void af_() {
            }

            public final void a(String str) {
                AJREnterPasscode.this.c();
                AJREnterPasscode.a(AJREnterPasscode.this, str);
            }
        });
        this.f18588h.setVisibility(8);
        this.o.setVisibility(0);
        this.p.setVisibility(8);
        this.f18583c.setVisibility(0);
        this.f18583c.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                AJREnterPasscode.this.a(view);
            }
        });
        this.t = getIntent().getIntExtra("REDIRECT_TO", -1);
    }

    public void onResume() {
        super.onResume();
    }

    public void onPause() {
        super.onPause();
    }

    public void onDestroy() {
        super.onDestroy();
    }

    /* access modifiers changed from: private */
    public void b(String str) {
        int i2 = this.t;
        if (i2 == -1) {
            return;
        }
        if (i2 == a.RETURN_TO_CALLER_ACTIVITY.ordinal() || this.t == a.ADD_NOMINEE.ordinal()) {
            Intent intent = new Intent();
            intent.putExtra("passcode", str);
            setResult(-1, intent);
            finish();
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void b(View view) {
        if (net.one97.paytm.bankCommon.mapping.a.c((Context) this)) {
            ForgotPasscodeChallengesActivity.a((Context) this);
        } else {
            d();
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(View view) {
        onBackPressed();
    }

    /* access modifiers changed from: private */
    public void a(boolean z) {
        if (z) {
            this.f18585e.setVisibility(0);
        } else {
            this.f18585e.setVisibility(8);
        }
        if (z) {
            int i2 = net.one97.paytm.bankOpen.R.drawable.pin_view_red_bg;
        } else {
            int i3 = R.drawable.pin_view_gray_bg;
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void d(IJRPaytmDataModel iJRPaytmDataModel) {
        ah_();
        if (iJRPaytmDataModel instanceof PBBlockUnblockCardResponse) {
            PBBlockUnblockCardResponse pBBlockUnblockCardResponse = (PBBlockUnblockCardResponse) iJRPaytmDataModel;
            if (TextUtils.isEmpty(pBBlockUnblockCardResponse.getErrorMessage())) {
                try {
                    HashMap hashMap = new HashMap();
                    hashMap.put("user_id", b.n(this.s));
                    hashMap.put("new_wallet_screen_type", "net/one97/paytm/passbook");
                    hashMap.put("block_card_success_failed", "success");
                    o.a().sendCustomEventWithMap("new_wallet_passbook_rupay_card_block_status", hashMap, this.s);
                } catch (Exception e2) {
                    q.b(e2.getMessage());
                }
                b("");
                return;
            }
            try {
                HashMap hashMap2 = new HashMap();
                hashMap2.put("user_id", b.n(this.s));
                hashMap2.put("new_wallet_screen_type", "net/one97/paytm/passbook");
                hashMap2.put("block_card_success_failed", "failed");
                o.a().sendCustomEventWithMap("new_wallet_passbook_rupay_card_block_status", hashMap2, this.s);
            } catch (Exception e3) {
                q.b(e3.getMessage());
            }
            b.b(this.s, getString(R.string.error), pBBlockUnblockCardResponse.getErrorMessage());
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void c(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
        ah_();
        this.f18585e.setText(networkCustomError.getAlertMessage());
        a(true);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void c(IJRPaytmDataModel iJRPaytmDataModel) {
        ah_();
        if (iJRPaytmDataModel instanceof PBBlockUnblockCardResponse) {
            PBBlockUnblockCardResponse pBBlockUnblockCardResponse = (PBBlockUnblockCardResponse) iJRPaytmDataModel;
            if (TextUtils.isEmpty(pBBlockUnblockCardResponse.getErrorMessage())) {
                try {
                    HashMap hashMap = new HashMap();
                    hashMap.put("user_id", b.n(this.s));
                    hashMap.put("new_wallet_screen_type", "net/one97/paytm/passbook");
                    hashMap.put("block_card_success_failed", "success");
                    o.a().sendCustomEventWithMap("new_wallet_passbook_rupay_card_block_status", hashMap, this.s);
                } catch (Exception e2) {
                    q.b(e2.getMessage());
                }
                b("");
                return;
            }
            try {
                HashMap hashMap2 = new HashMap();
                hashMap2.put("user_id", b.n(this.s));
                hashMap2.put("new_wallet_screen_type", "net/one97/paytm/passbook");
                hashMap2.put("block_card_success_failed", "failed");
                o.a().sendCustomEventWithMap("new_wallet_passbook_rupay_card_block_status", hashMap2, this.s);
            } catch (Exception e3) {
                q.b(e3.getMessage());
            }
            b.b(this.s, getString(R.string.error), pBBlockUnblockCardResponse.getErrorMessage());
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void b(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
        ah_();
        this.f18585e.setText(((d) networkCustomError).getAlertMessage());
        a(true);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void b(IJRPaytmDataModel iJRPaytmDataModel) {
        ah_();
        if (iJRPaytmDataModel instanceof CJRIMPSInitiateDataModel) {
            Intent intent = new Intent();
            intent.putExtra("imps_data", (CJRIMPSInitiateDataModel) iJRPaytmDataModel);
            setResult(-1, intent);
            finish();
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
        ah_();
        this.f18585e.setText(((d) networkCustomError).getAlertMessage());
        a(true);
    }

    static /* synthetic */ void a(AJREnterPasscode aJREnterPasscode, String str) {
        try {
            if (b.c(aJREnterPasscode.s)) {
                g gVar = g.f16329a;
                f a2 = g.a(aJREnterPasscode, str, new net.one97.paytm.bankCommon.f.b<String>() {
                    public final void a(String str, String str2) {
                        AJREnterPasscode.this.ah_();
                        if (!TextUtils.isEmpty(str)) {
                            AJREnterPasscode.this.a(false);
                            if (TextUtils.isEmpty(AJREnterPasscode.this.w)) {
                                return;
                            }
                            if (AJREnterPasscode.this.w.equalsIgnoreCase("BLOCK_CARD")) {
                                AJREnterPasscode.b(AJREnterPasscode.this, str);
                            } else if (AJREnterPasscode.this.w.equalsIgnoreCase("UNBLOCK_CARD")) {
                                AJREnterPasscode.c(AJREnterPasscode.this, str);
                            } else if (AJREnterPasscode.this.x) {
                                AJREnterPasscode.d(AJREnterPasscode.this, str);
                            } else if (AJREnterPasscode.this.w.equalsIgnoreCase("paytm_saving_account_confirm")) {
                                AJREnterPasscode.this.setResult(-1, new Intent());
                                AJREnterPasscode.this.finish();
                            } else {
                                AJREnterPasscode.this.b(str);
                            }
                        } else {
                            AJREnterPasscode.this.f18585e.setText(str2);
                            AJREnterPasscode.this.a(true);
                        }
                    }

                    public final void a(int i2, NetworkCustomError networkCustomError) {
                        AJREnterPasscode.this.ah_();
                        if (!v.a(networkCustomError.getAlertMessage())) {
                            AJREnterPasscode.this.f18585e.setText(networkCustomError.getAlertMessage());
                            AJREnterPasscode.this.a(true);
                        }
                        net.one97.paytm.bankCommon.utils.f.a((Context) AJREnterPasscode.this, networkCustomError, i2);
                    }
                });
                if (a2 != null) {
                    aJREnterPasscode.a(aJREnterPasscode, aJREnterPasscode.getString(R.string.pb_please_wait));
                    aJREnterPasscode.a(false);
                    aJREnterPasscode.getApplicationContext();
                    new c();
                    c.a(a2);
                    return;
                }
                return;
            }
            aJREnterPasscode.a(true);
            aJREnterPasscode.f18585e.setText(aJREnterPasscode.getString(R.string.pb_check_your_network));
        } catch (Exception e2) {
            q.b(e2.getMessage());
        }
    }

    static /* synthetic */ void b(AJREnterPasscode aJREnterPasscode, String str) {
        if (b.c(aJREnterPasscode.s)) {
            aJREnterPasscode.a(aJREnterPasscode, aJREnterPasscode.getString(R.string.please_wait));
            aJREnterPasscode.a(false);
            HashMap hashMap = new HashMap();
            hashMap.put("screen_name", aJREnterPasscode.getClass().getSimpleName());
            f b2 = net.one97.paytm.paymentsBank.b.a.b(aJREnterPasscode.s, str, aJREnterPasscode.u.getVdcCardAlias(), new g.b() {
                public final void onResponse(Object obj) {
                    AJREnterPasscode.this.d((IJRPaytmDataModel) obj);
                }
            }, new g.a() {
                public final void onErrorResponse(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
                    AJREnterPasscode.this.c(i2, iJRPaytmDataModel, networkCustomError);
                }
            }, a.c.PAYMENTSBANK, a.b.USER_FACING, hashMap);
            aJREnterPasscode.s.getApplicationContext();
            new c();
            c.a(b2);
        }
    }

    static /* synthetic */ void c(AJREnterPasscode aJREnterPasscode, String str) {
        if (b.c(aJREnterPasscode.s)) {
            aJREnterPasscode.a(aJREnterPasscode, aJREnterPasscode.getString(R.string.please_wait));
            aJREnterPasscode.a(false);
            HashMap hashMap = new HashMap();
            hashMap.put("screen_name", aJREnterPasscode.getClass().getSimpleName());
            f c2 = net.one97.paytm.paymentsBank.b.a.c(aJREnterPasscode.s, str, aJREnterPasscode.u.getVdcCardAlias(), new g.b() {
                public final void onResponse(Object obj) {
                    AJREnterPasscode.this.c((IJRPaytmDataModel) obj);
                }
            }, new g.a() {
                public final void onErrorResponse(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
                    AJREnterPasscode.this.b(i2, iJRPaytmDataModel, networkCustomError);
                }
            }, a.c.PAYMENTSBANK, a.b.USER_FACING, hashMap);
            aJREnterPasscode.s.getApplicationContext();
            new c();
            c.a(c2);
        }
    }

    static /* synthetic */ void d(AJREnterPasscode aJREnterPasscode, String str) {
        CJRIMPSInitiateDataModel cJRIMPSInitiateDataModel = (CJRIMPSInitiateDataModel) aJREnterPasscode.getIntent().getSerializableExtra("imps_data");
        if (b.c(aJREnterPasscode.s)) {
            HashMap hashMap = new HashMap();
            hashMap.put("screen_name", aJREnterPasscode.getClass().getSimpleName());
            f a2 = net.one97.paytm.paymentsBank.b.a.a(aJREnterPasscode.s, str, cJRIMPSInitiateDataModel.getResume_id(), cJRIMPSInitiateDataModel.getTxn_id(), (g.b<IJRPaytmDataModel>) new g.b() {
                public final void onResponse(Object obj) {
                    AJREnterPasscode.this.b((IJRPaytmDataModel) obj);
                }
            }, (g.a) new g.a() {
                public final void onErrorResponse(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
                    AJREnterPasscode.this.a(i2, iJRPaytmDataModel, networkCustomError);
                }
            }, a.c.PAYMENTSBANK, a.b.SILENT, (HashMap<String, String>) hashMap);
            aJREnterPasscode.a(aJREnterPasscode, aJREnterPasscode.getString(R.string.please_wait));
            aJREnterPasscode.a(false);
            View currentFocus = aJREnterPasscode.getCurrentFocus();
            if (currentFocus != null) {
                ((InputMethodManager) aJREnterPasscode.getSystemService("input_method")).hideSoftInputFromWindow(currentFocus.getWindowToken(), 0);
            }
            aJREnterPasscode.s.getApplicationContext();
            new c();
            c.a(a2);
        }
    }
}
