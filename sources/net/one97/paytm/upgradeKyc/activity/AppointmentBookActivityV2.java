package net.one97.paytm.upgradeKyc.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.paytm.business.merchantprofile.viewmodel.AddEditGstinViewModelKt;
import net.one97.paytm.common.entity.upgradeKyc.KycAddDetail;
import net.one97.paytm.upgradeKyc.R;
import net.one97.paytm.upgradeKyc.helper.e;

public class AppointmentBookActivityV2 extends UpgradeKycBaseActivity {

    /* renamed from: a  reason: collision with root package name */
    private TextView f65249a;

    public final int b() {
        return -1;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        e.a aVar = e.f66028b;
        e.a.b().a("/kyc-wallet-upgrade/in-person/doorstep/request-accepted", "kyc", (Context) this);
        TextView textView = (TextView) findViewById(R.id.fragment_appointment_book_card_data_tv);
        this.f65249a = (TextView) findViewById(R.id.address_for_in_person_value_tv);
        findViewById(R.id.appointment_book_parent_sv);
        findViewById(R.id.btn_back).setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                AppointmentBookActivityV2.this.a(view);
            }
        });
        Intent intent = getIntent();
        if (intent != null && intent.hasExtra(AddEditGstinViewModelKt.BODY_PARAM_ADDRESS)) {
            String stringExtra = intent.getStringExtra(AddEditGstinViewModelKt.BODY_PARAM_ADDRESS);
            if (!TextUtils.isEmpty(stringExtra)) {
                findViewById(R.id.address_heading_appointment_booked).setVisibility(0);
                this.f65249a.setText(stringExtra);
            } else {
                findViewById(R.id.address_heading_appointment_booked).setVisibility(8);
            }
        }
        if (intent != null && intent.hasExtra("docType") && intent.hasExtra("number")) {
            String stringExtra2 = intent.getStringExtra("number");
            String stringExtra3 = intent.getStringExtra("docType");
            if (!TextUtils.isEmpty(stringExtra2) && !TextUtils.isEmpty(stringExtra3)) {
                if (!stringExtra3.equalsIgnoreCase("Aadhaar Card") || stringExtra2.length() <= 14) {
                    textView.setText(getString(R.string.poitype_with_poinumber, new Object[]{stringExtra3, stringExtra2}));
                } else {
                    textView.setText(getString(R.string.vid_text_with_number, new Object[]{stringExtra2}));
                }
            }
        }
        if (getIntent() != null && getIntent().hasExtra("appointmentBookedaddress")) {
            KycAddDetail kycAddDetail = (KycAddDetail) getIntent().getSerializableExtra("appointmentBookedaddress");
            StringBuilder sb = new StringBuilder();
            if (kycAddDetail != null) {
                if (!TextUtils.isEmpty(kycAddDetail.getAddressLine1())) {
                    sb.append(kycAddDetail.getAddressLine1());
                    sb.append(", ");
                }
                if (!TextUtils.isEmpty(kycAddDetail.getAddressLine2())) {
                    sb.append(kycAddDetail.getAddressLine2());
                    sb.append(", ");
                }
                if (!TextUtils.isEmpty(kycAddDetail.getAddressLine3())) {
                    sb.append(kycAddDetail.getAddressLine3());
                    sb.append(", ");
                }
                if (!TextUtils.isEmpty(kycAddDetail.getCity())) {
                    sb.append(kycAddDetail.getCity());
                    sb.append(", ");
                }
                if (!TextUtils.isEmpty(kycAddDetail.getState())) {
                    sb.append(kycAddDetail.getState());
                    sb.append(", ");
                }
                if (!TextUtils.isEmpty(kycAddDetail.getPincodeC())) {
                    sb.append(kycAddDetail.getPincodeC());
                }
                this.f65249a.setText(sb.toString());
            }
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(View view) {
        onBackPressed();
    }

    public void onBackPressed() {
        setResult(-1);
        e.a aVar = e.f66028b;
        e.a.b().a((Activity) this);
    }

    public final int a() {
        return R.layout.fragment_appointment_book_v2;
    }
}
