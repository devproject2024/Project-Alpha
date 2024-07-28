package net.one97.paytm.o2o.amusementpark.utils;

import com.sendbird.android.constant.StringSet;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants;
import java.net.URLEncoder;
import java.util.ArrayList;
import net.one97.paytm.common.entity.CJRSelectCityModel;

public final class e {

    /* renamed from: a  reason: collision with root package name */
    public static ArrayList<CJRSelectCityModel> f73650a;

    public static CJRSelectCityModel a(String str) {
        CJRSelectCityModel cJRSelectCityModel = new CJRSelectCityModel();
        if (str == null || str.equals("") || (!str.toUpperCase().contains("NOIDA") && !str.toUpperCase().contains("GURGAON"))) {
            cJRSelectCityModel.setlabel("All Cities");
            cJRSelectCityModel.setValue(StringSet.all);
            return cJRSelectCityModel;
        }
        cJRSelectCityModel.setlabel("Delhi-NCR");
        cJRSelectCityModel.setValue("Delhi-NCR");
        return cJRSelectCityModel;
    }

    public static String b(String str) {
        try {
            return URLEncoder.encode(str, AppConstants.UTF_8);
        } catch (Exception unused) {
            return "+";
        }
    }

    public static void a(ArrayList<CJRSelectCityModel> arrayList) {
        ArrayList<CJRSelectCityModel> arrayList2 = f73650a;
        if (arrayList2 != null) {
            arrayList2.clear();
        } else {
            f73650a = new ArrayList<>();
        }
        f73650a.addAll(arrayList);
    }
}
