package net.one97.paytm.wallet.newdesign.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import com.paytm.utility.RoboTextView;
import com.paytm.utility.q;
import java.util.HashMap;
import net.one97.paytm.AppCompatLockActivity;
import net.one97.paytm.common.entity.IJRDataModel;
import net.one97.paytm.common.entity.shopping.CJRHomePageItem;
import net.one97.paytm.common.entity.wallet.CJRQRScanResultModel;
import net.one97.paytm.nativesdk.Constants.SDKConstants;
import net.one97.paytm.upi.util.UpiConstants;
import net.one97.paytm.wallet.R;
import net.one97.paytm.wallet.activity.AJRQRActivity;
import net.one97.paytm.wallet.entity.CJRSendMoney;
import net.one97.paytm.wallet.newdesign.b.c;
import net.one97.paytm.wallet.newdesign.universalp2p.c.b;
import net.one97.paytm.wallet.p2p.P2PLandingPageActivity;
import net.one97.paytm.wallet.utility.a;

public class P2PActivity extends AppCompatLockActivity implements View.OnClickListener {

    /* renamed from: i  reason: collision with root package name */
    private static final String f70515i = P2PActivity.class.getSimpleName();

    /* renamed from: e  reason: collision with root package name */
    RoboTextView f70516e;

    /* renamed from: f  reason: collision with root package name */
    public String f70517f;

    /* renamed from: g  reason: collision with root package name */
    public String f70518g;

    /* renamed from: h  reason: collision with root package name */
    public String f70519h;
    private final int j = 9;
    private Bundle k = null;
    private boolean l;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        b.a();
        try {
            net.one97.paytm.wallet.communicator.b.a().sendGTMOpenScreenWithDeviceInfo(this, "/wallet/pay-send/mobile", "Wallet");
            HashMap hashMap = new HashMap();
            hashMap.put("wallet_send_money_method_name", "mobile");
            net.one97.paytm.wallet.communicator.b.a().sendCustomGTMEvent(this, "wallet_send_money_method_selected", hashMap);
        } catch (Exception unused) {
        }
        setContentView(R.layout.w_activity_p2p);
        setSupportActionBar((Toolbar) findViewById(R.id.paysend_toolbar));
        ((ImageView) findViewById(R.id.toolbar_btn_back)).setOnClickListener(this);
        this.f70516e = (RoboTextView) findViewById(R.id.pay_send_title);
        CJRHomePageItem cJRHomePageItem = (CJRHomePageItem) getIntent().getSerializableExtra("deep_linking_data");
        if (cJRHomePageItem == null) {
            cJRHomePageItem = (CJRHomePageItem) getIntent().getSerializableExtra("extra_home_data");
        }
        if (cJRHomePageItem == null || !cJRHomePageItem.getPushFeatureType().equalsIgnoreCase("sendmoneymobile")) {
            this.l = getIntent().getBooleanExtra("is_p2m", false);
            if (!this.l) {
                String string = getString(R.string.enter_mobile_no_to_pay);
                RoboTextView roboTextView = this.f70516e;
                if (roboTextView != null) {
                    roboTextView.setText(string);
                }
                c cVar = new c();
                Bundle bundle2 = new Bundle();
                if (getIntent().hasExtra("FLAG_CONTACT_PICKER")) {
                    bundle2.putBoolean("contact_picker", getIntent().getBooleanExtra("contact_picker", false));
                    bundle2.putString("mobile", getIntent().getStringExtra("mobile"));
                    bundle2.putString("amount", getIntent().getStringExtra("amount"));
                } else if (getIntent().hasExtra("UNI_P2P_BUNDLE")) {
                    bundle2 = getIntent().getBundleExtra("UNI_P2P_BUNDLE");
                }
                if (getIntent().hasExtra("paymentmode")) {
                    bundle2.putInt("paymentmode", getIntent().getIntExtra("paymentmode", 1));
                }
                if (getIntent().hasExtra("ssid")) {
                    bundle2.putString("ssid", getIntent().getStringExtra("ssid"));
                }
                bundle2.putBoolean("isFromScan", getIntent().getBooleanExtra("isFromScan", false));
                bundle2.putBoolean("isFromDeeplink", getIntent().getBooleanExtra("isFromDeeplink", false));
                if (getIntent().hasExtra(UpiConstants.IS_GALLERY_SCAN)) {
                    bundle2.putBoolean(UpiConstants.IS_GALLERY_SCAN, getIntent().getBooleanExtra(UpiConstants.IS_GALLERY_SCAN, false));
                }
                if (getIntent().hasExtra(UpiConstants.IS_MID_SCAN)) {
                    bundle2.putBoolean(UpiConstants.IS_MID_SCAN, getIntent().getBooleanExtra(UpiConstants.IS_MID_SCAN, false));
                }
                cVar.setArguments(bundle2);
                a(cVar, "p2p");
            }
        } else if (!TextUtils.isEmpty(cJRHomePageItem.getP2pmobilenumber())) {
            Bundle bundle3 = new Bundle();
            bundle3.putString("PHONE_NUMBER", cJRHomePageItem.getP2pmobilenumber());
            bundle3.putString("AMOUNT", cJRHomePageItem.getBankAmount());
            bundle3.putBoolean("isFromScan", getIntent().getBooleanExtra("isFromScan", false));
            bundle3.putBoolean("isFromDeeplink", getIntent().getBooleanExtra("isFromDeeplink", false));
            c cVar2 = new c();
            cVar2.setArguments(bundle3);
            a(cVar2, "p2p");
        } else {
            startActivity(new Intent(this, PaySendActivityV2.class));
        }
    }

    public final void a() {
        this.f51786a = 102;
    }

    public void attachBaseContext(Context context) {
        super.attachBaseContext(net.one97.paytm.wallet.communicator.b.a().wrapContextByRestring(context));
    }

    public void onActivityResult(int i2, int i3, Intent intent) {
        Fragment c2;
        super.onActivityResult(i2, i3, intent);
        if (i3 == -1 && i2 == 2001 && intent != null && intent.hasExtra("resultdata") && intent.hasExtra("response title")) {
            a(intent, this.f70519h, this.f70517f, this.f70518g);
        }
        if (i3 == 0 && i2 == 2001) {
            finish();
        }
        if (i2 == 104 && i3 == -1) {
            if (!isFinishing() && (c2 = getSupportFragmentManager().c("p2p")) != null && (c2 instanceof c)) {
                c cVar = (c) c2;
                if (c2.isMenuVisible()) {
                    try {
                        cVar.a(Boolean.TRUE);
                        cVar.a((Boolean) null);
                        cVar.a(Boolean.FALSE);
                    } catch (Exception unused) {
                    }
                    if (cVar.f70739b) {
                        if (intent != null) {
                            String stringExtra = intent.getStringExtra("intent_extra_wallet_order_id");
                            boolean booleanExtra = intent.getBooleanExtra("intent_extra_wallet_is_payment_cancelled", false);
                            if (cVar.f70741d != null && !booleanExtra) {
                                cVar.f70741d.b(stringExtra);
                            }
                        }
                    } else if (intent != null) {
                        String stringExtra2 = intent.getStringExtra("intent_extra_wallet_order_id");
                        String stringExtra3 = intent.getStringExtra("intent_extra_wallet_email");
                        String stringExtra4 = intent.getStringExtra("intent_extra_wallet_phone_number");
                        String stringExtra5 = intent.getStringExtra("intent_extra_wallet_payee_sso_id");
                        String stringExtra6 = intent.getStringExtra("intent_extra_wallet_send_money_amount");
                        String stringExtra7 = intent.getStringExtra("intent_extra_wallet_comment");
                        intent.getStringExtra("intent_extra_wallet_request_code");
                        String stringExtra8 = intent.getStringExtra("intent_extra_wallet_is_to_verify");
                        String stringExtra9 = intent.getStringExtra("intent_extra_wallet_is_limit_applicable");
                        boolean booleanExtra2 = intent.getBooleanExtra("intent_extra_wallet_is_payment_cancelled", false);
                        if ((!TextUtils.isEmpty(stringExtra3) || !TextUtils.isEmpty(stringExtra4) || !TextUtils.isEmpty(stringExtra5)) && cVar.f70740c != null) {
                            cVar.f70740c.a(stringExtra2, stringExtra3, stringExtra4, stringExtra5, stringExtra6, stringExtra7, stringExtra8, stringExtra9, booleanExtra2);
                        }
                    }
                }
            }
        } else if (i2 == 3112 && i3 == -1) {
            if (intent == null) {
                q.b("No data found in while gallery selection");
                return;
            }
            Uri data = intent.getData();
            Intent intent2 = new Intent(this, AJRQRActivity.class);
            intent2.setDataAndType(data, "image/*");
            startActivity(intent2);
            finish();
        } else if (i2 == 1) {
            a(this.k);
        } else if (i3 == -1 && i2 == 9) {
            a.a(intent, (Activity) this);
        } else if (i2 == 1800) {
            finish();
        }
    }

    private void a(Fragment fragment, String str) {
        getSupportFragmentManager().a().a(R.id.rly_selectbank_container, fragment, str).b();
    }

    public void onClick(View view) {
        if (view.getId() == R.id.toolbar_btn_back) {
            finish();
        }
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.pay_send_menu, menu);
        menu.removeItem(R.id.action_pay_via_merchant_id);
        return super.onCreateOptionsMenu(menu);
    }

    public void onStart() {
        super.onStart();
        d.a.a.c.a().a((Object) this, true);
    }

    public void onStop() {
        super.onStop();
        d.a.a.c.a().b(this);
    }

    public void onEvent(Bundle bundle) {
        this.k = bundle;
        IJRDataModel iJRDataModel = this.k.getSerializable("postpaymentscreendata") == null ? null : (IJRDataModel) this.k.get("postpaymentscreendata");
        Bundle bundle2 = this.k;
        Bundle bundleExtra = getIntent().getBundleExtra("bill");
        String string = bundleExtra.getString("transaction_mobile_email");
        String string2 = bundleExtra.getString(SDKConstants.AI_TRANSACTION_AMOUNT);
        String string3 = bundleExtra.getString("transaction_message");
        if (bundle2 != null) {
            bundle2.putString("number", string);
            bundle2.putString("amount", string2);
            bundle2.putString(CJRQRScanResultModel.KEY_COMMENT_SMALL, string3);
        }
        if (iJRDataModel != null) {
            Bundle bundleExtra2 = getIntent().getBundleExtra("bill");
            String string4 = bundleExtra2.getString("transaction_mobile_email");
            String string5 = bundleExtra2.getString(SDKConstants.AI_TRANSACTION_AMOUNT);
            String string6 = bundleExtra2.getString("transaction_message");
            Intent intent = new Intent(this, P2PLandingPageActivity.class);
            CJRSendMoney cJRSendMoney = (CJRSendMoney) iJRDataModel;
            intent.putExtra("uni_p2p_landing_intent_extra_success", cJRSendMoney.getStatus());
            intent.putExtra("uni_p2p_landing_intent_extra_mobile_no", string4);
            intent.putExtra("uni_p2p_landing_intent_extra_name", cJRSendMoney.getResponse().getName());
            intent.putExtra("uni_p2p_landing_intent_extra_amount", string5);
            intent.putExtra("uni_p2p_landing_intent_extra_comment", string6);
            intent.putExtra("uni_p2p_landing_intent_extra_transaction_id", cJRSendMoney.getResponse().getwalletSysTransactionID());
            intent.putExtra("bill", getIntent().getBundleExtra("bill"));
            startActivityForResult(intent, 1);
        } else {
            a(this.k);
        }
        d.a.a.c.a().e(bundle);
    }

    private void a(Bundle bundle) {
        Intent intent = new Intent();
        if (bundle != null) {
            this.k.remove("postpaymentscreendata");
        }
        intent.putExtra("data", bundle);
        setResult(-1, intent);
        finish();
    }

    public final void a(Intent intent, String str, String str2, String str3) {
        Intent intent2 = new Intent();
        Bundle bundle = new Bundle();
        bundle.putString("resultdata", intent.getStringExtra("resultdata"));
        bundle.putString("response title", intent.getStringExtra("response title"));
        bundle.putString("response Message", intent.getStringExtra("response Message"));
        bundle.putString("number", str3);
        bundle.putString("amount", str2);
        bundle.putString(CJRQRScanResultModel.KEY_COMMENT_SMALL, str);
        intent2.putExtra("data", bundle);
        setResult(-1, intent2);
        finish();
    }

    public void onDestroy() {
        super.onDestroy();
        b.a();
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        try {
            HashMap hashMap = new HashMap();
            hashMap.put("new_wallet_screen_type", "send_money");
            if (menuItem.getItemId() == R.id.action_add_money) {
                hashMap.put("new_wallet_options_tab_name", "add_money");
            } else if (menuItem.getItemId() == R.id.action_show_code) {
                hashMap.put("new_wallet_options_tab_name", "show_code");
            } else if (menuItem.getItemId() == R.id.action_open_gallery) {
                hashMap.put("new_wallet_options_tab_name", "gallery");
            }
            net.one97.paytm.wallet.communicator.b.a().sendCustomGTMEvent(this, "new_wallet_options_tab_clicked", hashMap);
        } catch (Exception e2) {
            if (com.paytm.utility.b.v) {
                q.d(String.valueOf(e2));
            }
        }
        if (menuItem.getItemId() == R.id.action_add_money) {
            net.one97.paytm.wallet.communicator.b.a().onAddMoneyIntent(this, (CJRHomePageItem) null);
            setResult(-1);
            finish();
        } else if (menuItem.getItemId() == R.id.action_show_code) {
            startActivity(new Intent(this, ShowCodeActivity.class));
        } else if (menuItem.getItemId() == R.id.action_open_gallery) {
            Intent intent = new Intent();
            intent.setType("image/*");
            intent.setAction("android.intent.action.GET_CONTENT");
            try {
                startActivityForResult(Intent.createChooser(intent, "Select Paytm QR Code"), 3112);
            } catch (Exception e3) {
                q.d(String.valueOf(e3));
            }
        }
        return super.onOptionsItemSelected(menuItem);
    }
}
