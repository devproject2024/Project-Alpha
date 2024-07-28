package net.one97.paytm.upgradeKyc.form60.a;

import android.app.Activity;
import com.android.volley.VolleyError;
import com.paytm.network.model.NetworkCustomError;
import java.util.ArrayList;
import net.one97.paytm.common.entity.auth.TncData;

public interface a {

    /* renamed from: net.one97.paytm.upgradeKyc.form60.a.a$a  reason: collision with other inner class name */
    public interface C1316a {
        void fetchForm60TncApiCall();

        void onDestroy();

        void saveForm60DetailsApiCall(String str, String str2, String str3, String str4);

        void saveForm60TncApiCall(ArrayList<TncData> arrayList);
    }

    public interface b {
        Activity a();

        void a(VolleyError volleyError);

        void a(NetworkCustomError networkCustomError);

        void a(String str);

        void a(String str, String str2, String str3, String str4);

        void a(ArrayList<TncData> arrayList);

        void b();

        void b(ArrayList<TncData> arrayList);

        void c();

        void d();

        void e();

        void f();
    }

    public interface c {
        void a(NetworkCustomError networkCustomError);

        void a(String str);

        void a(ArrayList<TncData> arrayList);

        Activity aD_();

        void d();

        void e();

        void f();

        void g();

        void h();
    }
}
