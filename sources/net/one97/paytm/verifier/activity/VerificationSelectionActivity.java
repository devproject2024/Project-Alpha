package net.one97.paytm.verifier.activity;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import androidx.core.content.b.f;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import java.util.ArrayList;
import net.one97.paytm.activity.PaytmActivity;
import net.one97.paytm.common.entity.IJRDataModel;
import net.one97.paytm.common.entity.verifier.CJRVerifierDoView;
import net.one97.paytm.common.entity.verifier.CJRVerifierRenderData;
import net.one97.paytm.paytm_finance.R;
import net.one97.paytm.phoenix.provider.download.FileDownloadDefaultParamsKt;
import net.one97.paytm.utils.z;
import net.one97.paytm.verifier.a.c;

public class VerificationSelectionActivity extends PaytmActivity implements View.OnClickListener, Response.ErrorListener, Response.Listener<IJRDataModel> {

    /* renamed from: a  reason: collision with root package name */
    private ImageView f69825a;

    /* renamed from: b  reason: collision with root package name */
    private TextView f69826b;

    /* renamed from: c  reason: collision with root package name */
    private TextView f69827c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public RadioGroup f69828d;

    /* renamed from: e  reason: collision with root package name */
    private String f69829e;

    /* renamed from: f  reason: collision with root package name */
    private String f69830f;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public int f69831g = 5;

    /* renamed from: h  reason: collision with root package name */
    private ArrayList<CJRVerifierRenderData.CJRVerifierMethods> f69832h;

    /* renamed from: i  reason: collision with root package name */
    private CJRVerifierDoView f69833i;
    private String j = "";
    private z k;

    public /* synthetic */ void onResponse(Object obj) {
        String str;
        IJRDataModel iJRDataModel = (IJRDataModel) obj;
        a();
        if (iJRDataModel != null && (iJRDataModel instanceof CJRVerifierDoView)) {
            CJRVerifierDoView.CJRVerifierDoViewResponse response = ((CJRVerifierDoView) iJRDataModel).getResponse();
            this.f69829e = response.getBody().getVerifyId();
            this.f69830f = response.getBody().getMethod();
            response.getBody().getRenderData();
            if (response.getBody().getIsFinish() != null) {
                str = response.getBody().getIsFinish();
            } else {
                str = "";
            }
            String resultCode = response.getBody().getResultInfo().getResultCode();
            if (!TextUtils.isEmpty(resultCode) && resultCode.equalsIgnoreCase("SYSTEM_ERROR")) {
                a("");
            }
            if ((!TextUtils.isEmpty(str) && str.equalsIgnoreCase("true")) || (!TextUtils.isEmpty(this.f69830f) && this.f69830f.equalsIgnoreCase("EXIT"))) {
                a(response.getBody().getRenderData().getCallbackUrl());
            }
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.activity_verification_basic);
        getWindow().setFlags(FileDownloadDefaultParamsKt.DOWNLOAD_BUFFER_SIZE, FileDownloadDefaultParamsKt.DOWNLOAD_BUFFER_SIZE);
        this.f69825a = (ImageView) findViewById(R.id.iv_back_button);
        this.f69828d = (RadioGroup) findViewById(R.id.radio_group_verifier);
        this.f69826b = (TextView) findViewById(R.id.selection_title);
        this.f69827c = (TextView) findViewById(R.id.proceed);
        this.f69825a.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                VerificationSelectionActivity.this.onClick(view);
            }
        });
        this.f69827c.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                VerificationSelectionActivity.this.onClick(view);
            }
        });
        Intent intent = getIntent();
        if (intent != null) {
            if (intent.hasExtra("verifier_last_method")) {
                this.j = intent.getStringExtra("verifier_last_method");
            }
            if (intent.hasExtra("menu_response")) {
                this.f69833i = (CJRVerifierDoView) intent.getSerializableExtra("menu_response");
                CJRVerifierDoView cJRVerifierDoView = this.f69833i;
                if (cJRVerifierDoView != null) {
                    this.f69829e = cJRVerifierDoView.getResponse().getBody().getVerifyId();
                    this.f69830f = this.f69833i.getResponse().getBody().getMethod();
                    CJRVerifierRenderData renderData = this.f69833i.getResponse().getBody().getRenderData();
                    if (renderData.getHeadTip() != null) {
                        this.f69826b.setText(renderData.getHeadTip());
                    }
                    if (renderData.getForm_button() != null) {
                        this.f69827c.setText(renderData.getForm_button());
                    }
                    this.f69832h = renderData.getMethods();
                    this.f69831g = this.f69832h.size();
                    ArrayList<CJRVerifierRenderData.CJRVerifierMethods> arrayList = this.f69832h;
                    if (arrayList != null && arrayList.size() != 0) {
                        int a2 = c.a(5, this);
                        int a3 = c.a(5, this);
                        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2, 1.0f);
                        layoutParams.setMargins(a3, a2, a3, a2);
                        for (int i2 = 0; i2 < this.f69831g; i2++) {
                            RadioButton radioButton = new RadioButton(this);
                            radioButton.setText(this.f69832h.get(i2).getName());
                            radioButton.setTag(this.f69832h.get(i2).getCode());
                            radioButton.setId(i2);
                            radioButton.setTextSize(15.0f);
                            radioButton.setPadding(a2, a2, a2, a2);
                            radioButton.setButtonDrawable(f.a(getResources(), (int) R.drawable.btn_radio_holo_light, (Resources.Theme) null));
                            if (i2 == 0) {
                                radioButton.setChecked(true);
                                radioButton.setTypeface(Typeface.DEFAULT_BOLD);
                            } else {
                                radioButton.setTypeface(Typeface.DEFAULT);
                                radioButton.setChecked(false);
                            }
                            this.f69828d.addView(radioButton, layoutParams);
                        }
                        this.f69828d.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                            public final void onCheckedChanged(RadioGroup radioGroup, int i2) {
                                for (int i3 = 0; i3 < VerificationSelectionActivity.this.f69831g; i3++) {
                                    RadioButton radioButton = (RadioButton) VerificationSelectionActivity.this.f69828d.getChildAt(i3);
                                    if (radioButton != null) {
                                        if (radioGroup.getCheckedRadioButtonId() == radioButton.getId()) {
                                            radioButton.setTypeface(Typeface.DEFAULT_BOLD);
                                        } else {
                                            radioButton.setTypeface(Typeface.DEFAULT);
                                        }
                                    }
                                }
                            }
                        });
                    }
                }
            }
        }
    }

    public void onBackPressed() {
        Intent intent = new Intent();
        intent.putExtra("verifier_method", this.j);
        intent.putExtra("verifier_verifyID", this.f69829e);
        setResult(-1, intent);
        finish();
    }

    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.iv_back_button) {
            onBackPressed();
        } else if (id == R.id.proceed) {
            RadioGroup radioGroup = this.f69828d;
            Intent intent = new Intent();
            intent.putExtra("verifier_method", ((RadioButton) radioGroup.findViewById(radioGroup.getCheckedRadioButtonId())).getTag().toString());
            intent.putExtra("verifier_verifyID", this.f69829e);
            setResult(-1, intent);
            finish();
        }
    }

    public void onErrorResponse(VolleyError volleyError) {
        a();
    }

    private void a(String str) {
        Intent intent = new Intent();
        intent.putExtra("verifier_callback_url", str);
        setResult(-1, intent);
        finish();
    }

    private void a() {
        z zVar = this.k;
        if (zVar != null && zVar.isShowing()) {
            this.k.dismiss();
        }
    }
}
