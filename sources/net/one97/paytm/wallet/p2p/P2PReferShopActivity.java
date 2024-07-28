package net.one97.paytm.wallet.p2p;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;
import androidx.appcompat.widget.AppCompatEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.paytm.android.chat.utils.KeyList;
import com.paytm.network.model.NetworkCustomError;
import com.paytm.utility.h;
import com.paytm.utility.q;
import net.one97.paytm.common.entity.wallet.universalp2p.P2PreferShopResponse;
import net.one97.paytm.wallet.R;
import net.one97.paytm.wallet.communicator.b;
import net.one97.paytm.wallet.newdesign.universalp2p.c.b;
import net.one97.paytm.wallet.utility.a;
import org.json.JSONObject;

public class P2PReferShopActivity extends P2PAppCompatActivity implements View.OnClickListener {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public TextInputLayout f71506a;

    /* renamed from: b  reason: collision with root package name */
    private TextInputLayout f71507b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public AppCompatEditText f71508c;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public AppCompatEditText f71509e;

    /* renamed from: f  reason: collision with root package name */
    private ImageView f71510f;

    /* renamed from: g  reason: collision with root package name */
    private Button f71511g;

    /* renamed from: h  reason: collision with root package name */
    private final int f71512h = 101;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_p2_refer_shop);
        if (getSupportActionBar() != null) {
            getSupportActionBar().f();
        }
        this.f71510f = (ImageView) findViewById(R.id.p2p_back_arrow_iv);
        this.f71510f.setOnClickListener(this);
        this.f71506a = (TextInputLayout) findViewById(R.id.shopkeeper_number_til);
        this.f71507b = (TextInputLayout) findViewById(R.id.shop_name_til);
        this.f71508c = (AppCompatEditText) findViewById(R.id.shopkeeper_number_et);
        this.f71509e = (AppCompatEditText) findViewById(R.id.shop_name_et);
        findViewById(R.id.add_address_tv).setOnClickListener(this);
        this.f71508c.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            public final void onFocusChange(View view, boolean z) {
                if (z) {
                    b.a().sendNewCustomGTMEvents(P2PReferShopActivity.this, "refer_shopkeeper_detail", "shopkeeper_mobile_clicked", "", "", "", "/refer-shopkeeper", "refer_shopkeeper");
                }
            }
        });
        this.f71509e.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            public final void onFocusChange(View view, boolean z) {
                if (z) {
                    b.a().sendNewCustomGTMEvents(P2PReferShopActivity.this, "refer_shopkeeper_detail", "shop_name_clicked", "", "", "", "/refer-shopkeeper", "refer_shopkeeper");
                }
            }
        });
        this.f71511g = (Button) findViewById(R.id.proceed_btn);
        this.f71511g.setOnClickListener(this);
        this.f71508c.addTextChangedListener(new TextWatcher() {
            public final void afterTextChanged(Editable editable) {
            }

            public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
                P2PReferShopActivity.this.f71506a.setError((CharSequence) null);
            }
        });
        this.f71508c.setOnTouchListener(new View.OnTouchListener() {
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() != 1 || motionEvent.getRawX() < ((float) (P2PReferShopActivity.this.f71508c.getRight() - P2PReferShopActivity.this.f71508c.getCompoundDrawables()[2].getBounds().width()))) {
                    return false;
                }
                b.a().sendNewCustomGTMEvents(P2PReferShopActivity.this, "refer_shopkeeper_detail", "contacts_icon_clicked", "", "", "", "/refer-shopkeeper", "refer_shopkeeper");
                P2PReferShopActivity.this.startActivityForResult(new Intent("android.intent.action.PICK", ContactsContract.CommonDataKinds.Phone.CONTENT_URI), 101);
                return true;
            }
        });
        if (!com.paytm.utility.b.r((Context) this)) {
            Intent intent = new Intent(this, b.a().getAuthActivityClass());
            intent.putExtra("launchSignUp", false);
            intent.putExtra("set_result_required", true);
            intent.putExtra("VERTICAL_NAME", "Wallet");
            startActivityForResult(intent, KeyList.IntentRequestKey.INTENT_REQUEST_CHOOSE_MEDIA);
        }
        this.f71511g.requestFocus();
        b.a().sendGTMOpenScreenWithDeviceInfo(this, "/refer-shopkeeper", "refer_shopkeeper");
    }

    public void attachBaseContext(Context context) {
        super.attachBaseContext(b.a().wrapContextByRestring(context));
    }

    public void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        if (i3 != -1) {
            finish();
        } else if ((i2 != 301 || !com.paytm.utility.b.r((Context) this)) && i2 == 101) {
            try {
                Cursor query = getContentResolver().query(intent.getData(), (String[]) null, (String) null, (String[]) null, (String) null);
                query.moveToFirst();
                String string = query.getString(query.getColumnIndex("data1"));
                String string2 = query.getString(query.getColumnIndex("display_name"));
                String a2 = a.a(string);
                if (a2.length() > 10) {
                    a2 = a.a((Activity) this, a2);
                }
                if (!TextUtils.isEmpty(string)) {
                    this.f71508c.setText(a2);
                    this.f71508c.setSelection(this.f71508c.getText().length());
                }
                if (!TextUtils.isEmpty(string2)) {
                    this.f71509e.setText(string2);
                }
            } catch (Exception e2) {
                q.d(String.valueOf(e2));
            }
        }
    }

    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.proceed_btn) {
            if (a()) {
                try {
                    b.a().sendCustomGTMEvents("offline_payments", "scan_screen_refershop_submit", net.one97.paytm.p2mNewDesign.PaymentOptions.businessLogic.b.f().f13092h ? "flow_through_scan_icon" : "flow_through_pay_icon", (String) null, (Context) this, "home/scan/refer-shop/success", "offline_payments");
                } catch (Exception e2) {
                    if (com.paytm.utility.b.v) {
                        q.d(String.valueOf(e2));
                    }
                }
                if (!com.paytm.utility.b.c((Context) this)) {
                    try {
                        if (!isFinishing()) {
                            final h hVar = new h(this);
                            hVar.setTitle(getResources().getString(R.string.no_connection));
                            hVar.a(getResources().getString(R.string.no_internet));
                            hVar.a(-3, getResources().getString(R.string.ok), new View.OnClickListener() {
                                public final void onClick(View view) {
                                    hVar.cancel();
                                }
                            });
                            hVar.setCancelable(true);
                            hVar.show();
                        }
                    } catch (Exception e3) {
                        if (com.paytm.utility.b.v) {
                            q.d(String.valueOf(e3));
                        }
                    }
                } else {
                    a(true);
                    net.one97.paytm.wallet.newdesign.universalp2p.c.b.a((Activity) this).a(new b.e() {
                        public final void a(Object obj) {
                            P2PReferShopActivity.this.a(false);
                            if (obj instanceof P2PreferShopResponse) {
                                net.one97.paytm.wallet.communicator.b.a().sendNewCustomGTMEvents(P2PReferShopActivity.this, "refer_shopkeeper_detail", "refer_shopkeeper_detail_success", "", "", "", "/refer-shopkeeper", "refer_shopkeeper");
                                Intent intent = new Intent(P2PReferShopActivity.this, P2PReferShopSuccessActivity.class);
                                intent.putExtra("merchantName", P2PReferShopActivity.this.f71509e.getText().toString().trim());
                                intent.putExtra("merchantMobileNumber", P2PReferShopActivity.this.f71508c.getText().toString().trim());
                                P2PReferShopActivity.this.startActivity(intent);
                                P2PReferShopActivity.this.finish();
                            }
                        }

                        public final void a(NetworkCustomError networkCustomError) {
                            net.one97.paytm.wallet.communicator.b.a().sendNewCustomGTMEvents(P2PReferShopActivity.this, "refer_shopkeeper_detail", "refer_shopkeeper_detail_fail", "", "", "", "/refer-shopkeeper", "refer_shopkeeper");
                            P2PReferShopActivity.this.a(false);
                            P2PReferShopActivity p2PReferShopActivity = P2PReferShopActivity.this;
                            Toast.makeText(p2PReferShopActivity, p2PReferShopActivity.getResources().getString(R.string.some_went_wrong), 0).show();
                        }
                    }, this.f71508c.getText().toString().trim(), this.f71509e.getText().toString().trim(), (JSONObject) null);
                }
            }
        } else if (id == R.id.p2p_back_arrow_iv) {
            finish();
        } else if (id == R.id.add_address_tv) {
            net.one97.paytm.wallet.communicator.b.a().sendNewCustomGTMEvents(this, "refer_shopkeeper_detail", "add_shop_address_clicked", "", "", "", "/refer-shopkeeper", "refer_shopkeeper");
            if (a()) {
                Intent intent = new Intent(this, P2PReferShopAddressActivity.class);
                intent.putExtra("NUMBER", this.f71508c.getText().toString().trim());
                intent.putExtra("NAME", this.f71509e.getText().toString().trim());
                startActivity(intent);
                finish();
            }
        }
    }

    private boolean a() {
        if (!com.paytm.utility.b.b(this.f71508c.getText().toString().trim())) {
            this.f71506a.setError(getResources().getString(R.string.enter_valid_mobile_number));
            return false;
        } else if (com.paytm.utility.b.l((Context) this) == null || !com.paytm.utility.b.l((Context) this).equalsIgnoreCase(this.f71508c.getText().toString().trim())) {
            return true;
        } else {
            this.f71506a.setError(getResources().getString(R.string.accept_payment_own_mobile_error));
            return false;
        }
    }
}
