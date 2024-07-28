package net.one97.paytm.upgradeKyc.activity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import com.paytm.utility.RoboTextView;
import java.util.HashMap;
import kotlin.g.b.k;
import net.one97.paytm.common.entity.upgradeKyc.KycAadharEkycDetails;
import net.one97.paytm.upgradeKyc.R;

public final class KnowMoreMinorKyc extends UpgradeKycBaseActivity implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    private KycAadharEkycDetails.KycResponse f65311a;

    /* renamed from: b  reason: collision with root package name */
    private HashMap f65312b;

    public final View a(int i2) {
        if (this.f65312b == null) {
            this.f65312b = new HashMap();
        }
        View view = (View) this.f65312b.get(Integer.valueOf(i2));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i2);
        this.f65312b.put(Integer.valueOf(i2), findViewById);
        return findViewById;
    }

    public final void onClick(View view) {
    }

    public final int b() {
        return R.layout.base_toolbar;
    }

    public final int a() {
        return R.layout.activity_know_more_minor_kyc;
    }

    public final void onCreate(Bundle bundle) {
        KycAadharEkycDetails.KycResponse kycResponse;
        String uid;
        super.onCreate(bundle);
        if (getIntent() != null && getIntent().hasExtra("aadhaarData")) {
            this.f65311a = (KycAadharEkycDetails.KycResponse) getIntent().getSerializableExtra("aadhaarData");
        }
        KycAadharEkycDetails.KycResponse kycResponse2 = this.f65311a;
        String str = null;
        if (!TextUtils.isEmpty(kycResponse2 != null ? kycResponse2.getName() : null)) {
            RoboTextView roboTextView = (RoboTextView) a(R.id.tv_name);
            k.a((Object) roboTextView, "tv_name");
            KycAadharEkycDetails.KycResponse kycResponse3 = this.f65311a;
            roboTextView.setText(kycResponse3 != null ? kycResponse3.getName() : null);
        }
        StringBuilder sb = new StringBuilder("");
        KycAadharEkycDetails.KycResponse kycResponse4 = this.f65311a;
        if (!TextUtils.isEmpty(kycResponse4 != null ? kycResponse4.getCo() : null)) {
            RoboTextView roboTextView2 = (RoboTextView) a(R.id.tv_co);
            k.a((Object) roboTextView2, "tv_co");
            roboTextView2.setVisibility(0);
            RoboTextView roboTextView3 = (RoboTextView) a(R.id.tv_co);
            k.a((Object) roboTextView3, "tv_co");
            KycAadharEkycDetails.KycResponse kycResponse5 = this.f65311a;
            roboTextView3.setText(kycResponse5 != null ? kycResponse5.getCo() : null);
        }
        KycAadharEkycDetails.KycResponse kycResponse6 = this.f65311a;
        if (!TextUtils.isEmpty(kycResponse6 != null ? kycResponse6.getHouse() : null)) {
            KycAadharEkycDetails.KycResponse kycResponse7 = this.f65311a;
            sb.append(kycResponse7 != null ? kycResponse7.getHouse() : null);
            sb.append(" ");
        }
        KycAadharEkycDetails.KycResponse kycResponse8 = this.f65311a;
        if (!TextUtils.isEmpty(kycResponse8 != null ? kycResponse8.getLocation() : null)) {
            KycAadharEkycDetails.KycResponse kycResponse9 = this.f65311a;
            sb.append(kycResponse9 != null ? kycResponse9.getLocation() : null);
            sb.append(" ");
        }
        KycAadharEkycDetails.KycResponse kycResponse10 = this.f65311a;
        if (!TextUtils.isEmpty(kycResponse10 != null ? kycResponse10.getStreet() : null)) {
            KycAadharEkycDetails.KycResponse kycResponse11 = this.f65311a;
            sb.append(kycResponse11 != null ? kycResponse11.getStreet() : null);
            sb.append(" ");
        }
        KycAadharEkycDetails.KycResponse kycResponse12 = this.f65311a;
        if (!TextUtils.isEmpty(kycResponse12 != null ? kycResponse12.getLandMark() : null)) {
            KycAadharEkycDetails.KycResponse kycResponse13 = this.f65311a;
            sb.append(kycResponse13 != null ? kycResponse13.getLandMark() : null);
            sb.append(" ");
        }
        KycAadharEkycDetails.KycResponse kycResponse14 = this.f65311a;
        if (!TextUtils.isEmpty(kycResponse14 != null ? kycResponse14.getDistrict() : null)) {
            KycAadharEkycDetails.KycResponse kycResponse15 = this.f65311a;
            sb.append(kycResponse15 != null ? kycResponse15.getDistrict() : null);
            sb.append(" ");
        }
        KycAadharEkycDetails.KycResponse kycResponse16 = this.f65311a;
        if (!TextUtils.isEmpty(kycResponse16 != null ? kycResponse16.getPostOffice() : null)) {
            KycAadharEkycDetails.KycResponse kycResponse17 = this.f65311a;
            sb.append(kycResponse17 != null ? kycResponse17.getPostOffice() : null);
            sb.append(" ");
        }
        KycAadharEkycDetails.KycResponse kycResponse18 = this.f65311a;
        if (!TextUtils.isEmpty(kycResponse18 != null ? kycResponse18.getState() : null)) {
            KycAadharEkycDetails.KycResponse kycResponse19 = this.f65311a;
            sb.append(kycResponse19 != null ? kycResponse19.getState() : null);
            sb.append(" ");
        }
        KycAadharEkycDetails.KycResponse kycResponse20 = this.f65311a;
        if (!TextUtils.isEmpty(kycResponse20 != null ? kycResponse20.getPostalCode() : null)) {
            KycAadharEkycDetails.KycResponse kycResponse21 = this.f65311a;
            sb.append(kycResponse21 != null ? kycResponse21.getPostOffice() : null);
        }
        if (!TextUtils.isEmpty(sb.toString())) {
            RoboTextView roboTextView4 = (RoboTextView) a(R.id.tv_address);
            k.a((Object) roboTextView4, "tv_address");
            roboTextView4.setVisibility(0);
            RoboTextView roboTextView5 = (RoboTextView) a(R.id.tv_address);
            k.a((Object) roboTextView5, "tv_address");
            roboTextView5.setText(sb);
        }
        KycAadharEkycDetails.KycResponse kycResponse22 = this.f65311a;
        if (!TextUtils.isEmpty(kycResponse22 != null ? kycResponse22.getUid() : null) && (kycResponse = this.f65311a) != null && (uid = kycResponse.getUid()) != null && uid.length() == 12) {
            KycAadharEkycDetails.KycResponse kycResponse23 = this.f65311a;
            if (kycResponse23 != null) {
                str = kycResponse23.getUid();
            }
            StringBuilder insert = new StringBuilder(str).insert(4, ' ');
            k.a((Object) insert, "sb.insert(4, ' ')");
            StringBuilder insert2 = insert.insert(9, ' ');
            k.a((Object) insert2, "sb.insert(9, ' ')");
            RoboTextView roboTextView6 = (RoboTextView) a(R.id.tv_aadhaar_num);
            k.a((Object) roboTextView6, "tv_aadhaar_num");
            roboTextView6.setText(insert2);
        }
    }
}
