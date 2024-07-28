package net.one97.paytm.o2o.movies.viewmodel;

import android.app.Application;
import android.net.Uri;
import android.text.TextUtils;
import androidx.lifecycle.a;
import androidx.lifecycle.y;
import com.paytm.network.a;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import java.util.HashMap;
import java.util.Map;
import net.one97.paytm.o2o.movies.actor.CJRActorModel;
import net.one97.paytm.o2o.movies.common.b.c;
import net.one97.paytm.o2o.movies.utils.n;

public class b extends a implements com.paytm.network.listener.b {

    /* renamed from: a  reason: collision with root package name */
    public y<Boolean> f76057a = new y<>();

    /* renamed from: b  reason: collision with root package name */
    public y<CJRDisclaimerModel> f76058b = new y<>();

    /* renamed from: c  reason: collision with root package name */
    private y<CJRActorModel> f76059c = new y<>();

    /* renamed from: d  reason: collision with root package name */
    private String f76060d = "ActorPageViewModel";

    public b(Application application) {
        super(application);
    }

    public final y<CJRActorModel> a(int i2) {
        if (this.f76059c == null) {
            this.f76059c = new y<>();
        }
        b(i2);
        return this.f76059c;
    }

    private void b(int i2) {
        c.a();
        String a2 = c.a("MovieActorContentURL", (String) null);
        if (!TextUtils.isEmpty(a2)) {
            Uri.Builder buildUpon = Uri.parse(a2).buildUpon();
            buildUpon.appendPath(String.valueOf(i2));
            a(buildUpon.build().toString(), new CJRActorModel());
        }
    }

    public final void a(String str, IJRPaytmDataModel iJRPaytmDataModel) {
        net.one97.paytm.o2o.movies.utils.c cVar = new net.one97.paytm.o2o.movies.utils.c();
        cVar.f42877a = getApplication().getApplicationContext();
        cVar.f42878b = a.c.MOVIES;
        cVar.f42879c = a.C0715a.GET;
        cVar.f42880d = str;
        cVar.f42881e = null;
        cVar.f42882f = a();
        cVar.f42883g = null;
        cVar.f42884h = null;
        cVar.f42885i = iJRPaytmDataModel;
        cVar.j = this;
        cVar.n = a.b.USER_FACING;
        cVar.o = "movies";
        cVar.t = n.h(this.f76060d);
        com.paytm.network.a l = cVar.l();
        l.f42859c = false;
        l.a();
    }

    private static Map<String, String> a() {
        HashMap hashMap = new HashMap();
        hashMap.put("ClientId", "paytm");
        return hashMap;
    }

    public void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
        if (iJRPaytmDataModel instanceof CJRActorModel) {
            this.f76059c.setValue((CJRActorModel) iJRPaytmDataModel);
        } else if (iJRPaytmDataModel instanceof CJRDisclaimerModel) {
            this.f76058b.setValue((CJRDisclaimerModel) iJRPaytmDataModel);
        }
    }

    public void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
        if (iJRPaytmDataModel instanceof CJRActorModel) {
            this.f76059c.setValue(null);
            this.f76057a.setValue(Boolean.TRUE);
        } else if (iJRPaytmDataModel instanceof CJRDisclaimerModel) {
            this.f76058b.setValue(null);
        }
    }
}
