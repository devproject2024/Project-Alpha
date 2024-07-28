package net.one97.paytm.o2o.amusementpark.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.paytmmoney.lite.mod.helper.CJRConstants;
import net.one97.paytm.activity.PaytmActivity;
import net.one97.paytm.common.entity.CJRSelectCityModel;
import net.one97.paytm.common.entity.shopping.CJRHomePageItem;
import net.one97.paytm.o2o.amusementpark.a;
import net.one97.paytm.o2o.amusementpark.c.c;
import net.one97.paytm.o2o.amusementpark.utils.m;

public class AJRAmParkHomePage extends PaytmActivity {

    /* renamed from: a  reason: collision with root package name */
    private c f73323a;

    /* renamed from: b  reason: collision with root package name */
    private final String f73324b = "AmPark_fragment";

    public void onCreate(Bundle bundle) {
    }

    public void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        c cVar = (c) getSupportFragmentManager().c("AmPark_fragment");
        if (cVar != null) {
            cVar.onActivityResult(i2, i3, intent);
        }
    }

    public void onNewIntent(Intent intent) {
        CJRHomePageItem cJRHomePageItem;
        String str;
        super.onNewIntent(intent);
        if (intent != null) {
            try {
                if (intent.getExtras().containsKey("extra_home_data") && (intent.getExtras().getSerializable("extra_home_data") instanceof CJRHomePageItem) && (cJRHomePageItem = (CJRHomePageItem) intent.getExtras().getSerializable("extra_home_data")) != null) {
                    String str2 = null;
                    String str3 = !TextUtils.isEmpty(cJRHomePageItem.getmParkName()) ? cJRHomePageItem.getmParkName() : null;
                    String str4 = !TextUtils.isEmpty(cJRHomePageItem.getmParkId()) ? cJRHomePageItem.getmParkId() : null;
                    String str5 = !TextUtils.isEmpty(cJRHomePageItem.getmParkCategory()) ? cJRHomePageItem.getmParkCategory() : null;
                    if (!TextUtils.isEmpty(cJRHomePageItem.getmParkCityName())) {
                        String str6 = cJRHomePageItem.getmParkCityName();
                        CJRSelectCityModel cJRSelectCityModel = new CJRSelectCityModel();
                        cJRSelectCityModel.setValue(str6);
                        cJRSelectCityModel.setlabel(str6);
                        str = str6;
                    } else {
                        str = null;
                    }
                    if (!TextUtils.isEmpty(cJRHomePageItem.getmParkProviderId())) {
                        str2 = cJRHomePageItem.getmParkProviderId();
                    }
                    String str7 = str2;
                    if (!TextUtils.isEmpty(str3) && !TextUtils.isEmpty(str7) && !TextUtils.isEmpty(str5) && !TextUtils.isEmpty(str)) {
                        this.f73323a.a(str5, str3, str7, str, str4);
                    } else if (!TextUtils.isEmpty(cJRHomePageItem.getParkcityValue()) && !TextUtils.isEmpty(cJRHomePageItem.getParkcityLabel())) {
                        CJRSelectCityModel cJRSelectCityModel2 = new CJRSelectCityModel();
                        cJRSelectCityModel2.setValue(cJRHomePageItem.getParkcityValue());
                        cJRSelectCityModel2.setlabel(cJRHomePageItem.getParkcityLabel());
                        this.f73323a.a(cJRSelectCityModel2);
                    }
                }
            } catch (Exception unused) {
            }
        }
    }

    public void onBackPressed() {
        Intent intent = new Intent(this, a.a().getLoginActivity());
        intent.addFlags(67108864);
        intent.addFlags(268435456);
        intent.setFlags(536870912);
        intent.putExtra(CJRConstants.EXTRA_INTENT_RESULTANT_FRAGMENT_TYPE, "main");
        startActivity(intent);
        super.onBackPressed();
    }

    public void onRequestPermissionsResult(int i2, String[] strArr, int[] iArr) {
        c cVar = this.f73323a;
        if (cVar != null) {
            cVar.onRequestPermissionsResult(i2, strArr, iArr);
        }
    }

    public void attachBaseContext(Context context) {
        if (a.a() == null) {
            new m();
            m.a();
            super.attachBaseContext(context);
        } else {
            super.attachBaseContext(a.a().getBaseContext(context));
        }
        com.google.android.play.core.splitcompat.a.a((Context) this);
    }
}
