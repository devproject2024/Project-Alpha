package net.one97.paytm.oauth.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.lifecycle.k;
import com.google.android.material.textfield.TextInputLayout;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import net.one97.paytm.dynamic.module.fastag.helper.ImagePickerUtils;
import net.one97.paytm.nativesdk.Constants.SDKConstants;
import net.one97.paytm.oauth.OauthModule;
import net.one97.paytm.oauth.R;
import net.one97.paytm.oauth.b.b;
import net.one97.paytm.oauth.d.a;
import net.one97.paytm.oauth.models.MergeChallenge;
import net.one97.paytm.oauth.utils.OAuthUtils;
import net.one97.paytm.oauth.utils.t;

public class MergeAccountActivity extends OAuthBaseActivity implements View.OnClickListener, t {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public String f52508a;

    /* renamed from: b  reason: collision with root package name */
    private Button f52509b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public AppCompatEditText f52510c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public AppCompatEditText f52511d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public TextInputLayout f52512e;

    /* renamed from: f  reason: collision with root package name */
    private TextInputLayout f52513f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f52514g;

    /* renamed from: h  reason: collision with root package name */
    private TextView f52515h;

    /* renamed from: i  reason: collision with root package name */
    private TextWatcher f52516i = new TextWatcher() {
        public final void afterTextChanged(Editable editable) {
        }

        public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        }

        public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            if (MergeAccountActivity.this.f52511d.getText().length() > 0) {
                MergeAccountActivity.this.f52511d.setText("");
            }
            MergeAccountActivity.this.f52512e.setError((CharSequence) null);
            MergeAccountActivity.this.a((String) null);
        }
    };
    private TextWatcher j = new TextWatcher() {
        public final void afterTextChanged(Editable editable) {
        }

        public final void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        }

        public final void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            if (MergeAccountActivity.this.f52510c.getText().length() > 0) {
                MergeAccountActivity.this.f52510c.setText("");
            }
            MergeAccountActivity.this.f52512e.setError((CharSequence) null);
            MergeAccountActivity.this.a((String) null);
        }
    };

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_merge_account);
        setTitle(getString(R.string.merge_accounts));
        ActionBar supportActionBar = getSupportActionBar();
        supportActionBar.b(true);
        supportActionBar.a(1.0f);
        if (getIntent() != null) {
            this.f52508a = getIntent().getStringExtra("state");
            this.f52514g = getIntent().getBooleanExtra("openConsentDialog", false);
        }
        this.f52509b = (Button) findViewById(R.id.activity_merge_account_btn_merge);
        this.f52510c = (AppCompatEditText) findViewById(R.id.activity_merge_et_card_num);
        this.f52511d = (AppCompatEditText) findViewById(R.id.activity_merge_et_balance);
        this.f52512e = (TextInputLayout) findViewById(R.id.activity_merge_et_layout_card_num);
        this.f52513f = (TextInputLayout) findViewById(R.id.activity_merge_et_layout_balance);
        this.f52515h = (TextView) findViewById(R.id.activity_merge_account_tv_error);
        this.f52509b.setOnClickListener(this);
        if (this.f52514g) {
            final a aVar = new a(this);
            aVar.setTitle((CharSequence) null);
            aVar.setCancelable(false);
            aVar.a(getString(R.string.merge_account_mobile_add));
            aVar.a(-1, (CharSequence) getString(R.string.dialog_continue), (View.OnClickListener) new View.OnClickListener() {
                public final void onClick(View view) {
                    aVar.cancel();
                    MergeAccountActivity mergeAccountActivity = MergeAccountActivity.this;
                    b.a((Context) mergeAccountActivity, mergeAccountActivity.f52508a, false, (String) null, (String) null, (t) MergeAccountActivity.this);
                }
            });
            aVar.a(-2, (CharSequence) getString(R.string.cancel), (View.OnClickListener) new View.OnClickListener() {

                /* renamed from: b  reason: collision with root package name */
                final /* synthetic */ boolean f52522b = false;

                public final void onClick(View view) {
                    aVar.cancel();
                    if (!this.f52522b) {
                        MergeAccountActivity.this.finish();
                    }
                }
            });
            aVar.show();
        }
        this.f52510c.addTextChangedListener(this.f52516i);
        this.f52511d.addTextChangedListener(this.j);
    }

    /* access modifiers changed from: private */
    public void a(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.f52515h.setVisibility(0);
            this.f52515h.setText(str);
            return;
        }
        this.f52515h.setVisibility(8);
    }

    public void onClick(View view) {
        if (view.getId() == R.id.activity_merge_account_btn_merge) {
            ((InputMethodManager) getSystemService("input_method")).hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 2);
            String obj = this.f52510c.getText().toString();
            String obj2 = this.f52511d.getText().toString();
            if (TextUtils.isEmpty(obj) && TextUtils.isEmpty(obj2)) {
                a(getString(R.string.merge_account_empty_error));
            } else if (!TextUtils.isEmpty(obj)) {
                if (obj.length() < 4) {
                    this.f52512e.setError(getString(R.string.merge_last_card_error));
                    return;
                }
                a((String) null);
                b.a((Context) this, this.f52508a, true, obj, "saved_card", (t) this);
            } else if (!TextUtils.isEmpty(obj2)) {
                a((String) null);
                b.a((Context) this, this.f52508a, true, obj2, SDKConstants.GA_CHECK_BALANCE_ACTION, (t) this);
            }
        }
    }

    public void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        if (i2 == 1 && i3 == -1 && intent != null && !TextUtils.isEmpty(intent.getStringExtra("code"))) {
            Intent intent2 = getIntent();
            intent2.putExtra("code", intent.getStringExtra("code"));
            setResult(-1, intent2);
            finish();
        }
    }

    public void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
        com.paytm.utility.b.Z((Context) this);
        if (iJRPaytmDataModel instanceof MergeChallenge) {
            final MergeChallenge mergeChallenge = (MergeChallenge) iJRPaytmDataModel;
            if (mergeChallenge.getStatus() == null) {
                return;
            }
            if (mergeChallenge.getStatus().equalsIgnoreCase("success")) {
                if (mergeChallenge.getResponseCode() == null) {
                    return;
                }
                if (mergeChallenge.getResponseCode().equalsIgnoreCase("16")) {
                    if (!TextUtils.isEmpty(mergeChallenge.getCode())) {
                        final a aVar = new a(this);
                        aVar.setTitle((CharSequence) null);
                        aVar.setCancelable(false);
                        aVar.a(mergeChallenge.getMessage());
                        aVar.a(-3, (CharSequence) getString(R.string.ok), (View.OnClickListener) new View.OnClickListener() {
                            public final void onClick(View view) {
                                aVar.dismiss();
                                Intent intent = MergeAccountActivity.this.getIntent();
                                intent.putExtra("code", mergeChallenge.getCode());
                                MergeAccountActivity.this.setResult(-1, intent);
                                MergeAccountActivity.this.finish();
                            }
                        });
                        aVar.show();
                    } else if (!TextUtils.isEmpty(mergeChallenge.getMessage())) {
                        final a aVar2 = new a(this);
                        aVar2.setTitle((CharSequence) null);
                        aVar2.setCancelable(false);
                        aVar2.a(mergeChallenge.getMessage());
                        aVar2.a(-3, (CharSequence) getString(R.string.ok), (View.OnClickListener) new View.OnClickListener() {
                            public final void onClick(View view) {
                                aVar2.dismiss();
                                OauthModule.b().openProfileActivity(MergeAccountActivity.this);
                            }
                        });
                        aVar2.show();
                    }
                } else if (!mergeChallenge.getResponseCode().equalsIgnoreCase("15")) {
                } else {
                    if (!TextUtils.isEmpty(mergeChallenge.getCode())) {
                        final a aVar3 = new a(this);
                        aVar3.setTitle((CharSequence) null);
                        aVar3.setCancelable(false);
                        aVar3.a(mergeChallenge.getMessage());
                        aVar3.a(-3, (CharSequence) getString(R.string.ok), (View.OnClickListener) new View.OnClickListener() {
                            public final void onClick(View view) {
                                aVar3.dismiss();
                                Intent intent = MergeAccountActivity.this.getIntent();
                                intent.putExtra("code", mergeChallenge.getCode());
                                MergeAccountActivity.this.setResult(-1, intent);
                                MergeAccountActivity.this.finish();
                            }
                        });
                        aVar3.show();
                    } else if (!TextUtils.isEmpty(mergeChallenge.getMessage())) {
                        final a aVar4 = new a(this);
                        aVar4.setTitle((CharSequence) null);
                        aVar4.setCancelable(false);
                        aVar4.a(mergeChallenge.getMessage());
                        aVar4.a(-3, (CharSequence) getString(R.string.ok), (View.OnClickListener) new View.OnClickListener() {
                            public final void onClick(View view) {
                                aVar4.dismiss();
                                OauthModule.b().openProfileActivity(MergeAccountActivity.this);
                            }
                        });
                        aVar4.show();
                    }
                }
            } else if (mergeChallenge.getStatus().equalsIgnoreCase(ImagePickerUtils.IMAGE_PICKER_KEY_STATUS_FAILURE)) {
                if (!TextUtils.isEmpty(mergeChallenge.getState())) {
                    this.f52508a = mergeChallenge.getState();
                }
                if (!TextUtils.isEmpty(mergeChallenge.getMessage())) {
                    a(mergeChallenge.getMessage());
                }
            }
        }
    }

    public void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
        com.paytm.utility.b.Z((Context) this);
        if (networkCustomError != null && getLifecycle().a().isAtLeast(k.b.RESUMED)) {
            OAuthUtils.a(networkCustomError, (AppCompatActivity) this, AJRChangePassword.class.getName());
        }
    }

    public final void a() {
        com.paytm.utility.b.k(this, getString(R.string.please_wait));
    }
}
