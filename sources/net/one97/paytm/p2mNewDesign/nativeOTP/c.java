package net.one97.paytm.p2mNewDesign.nativeOTP;

import android.app.Application;
import android.content.Context;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.y;
import androidx.lifecycle.z;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import java.util.HashMap;
import java.util.Map;
import kotlin.g.b.k;
import kotlin.g.b.x;
import kotlin.u;
import net.one97.paytm.network.b;
import net.one97.paytm.network.f;
import net.one97.paytm.network.g;
import net.one97.paytm.network.h;
import net.one97.paytm.p2mNewDesign.entity.nativeOTP.DirectFormsResponse;
import org.json.JSONObject;

public final class c extends androidx.lifecycle.a {

    static final class a<T> implements z<f> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ x.e f56987a;

        a(x.e eVar) {
            this.f56987a = eVar;
        }

        public final /* synthetic */ void onChanged(Object obj) {
            f fVar = (f) obj;
            h hVar = fVar.f55796a;
            IJRPaytmDataModel iJRPaytmDataModel = fVar.f55797b;
            g gVar = fVar.f55798c;
            if (hVar == h.SUCCESS) {
                y yVar = (y) this.f56987a.element;
                f.a aVar = f.f55795d;
                if (iJRPaytmDataModel != null) {
                    yVar.postValue(f.a.a(iJRPaytmDataModel));
                    return;
                }
                throw new u("null cannot be cast to non-null type com.paytm.network.model.IJRPaytmDataModel");
            } else if (hVar == h.ERROR && gVar != null) {
                y yVar2 = (y) this.f56987a.element;
                f.a aVar2 = f.f55795d;
                int i2 = gVar.f55799a;
                IJRPaytmDataModel iJRPaytmDataModel2 = gVar.f55800b;
                if (iJRPaytmDataModel2 == null) {
                    k.a();
                }
                NetworkCustomError networkCustomError = gVar.f55801c;
                if (networkCustomError == null) {
                    k.a();
                }
                yVar2.postValue(f.a.a(i2, iJRPaytmDataModel2, networkCustomError));
            }
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public c(Application application) {
        super(application);
        k.c(application, "application");
    }

    public static LiveData<f> a(Context context, String str, String str2, HashMap<String, String> hashMap, HashMap<String, String> hashMap2) {
        k.c(context, "mContext");
        k.c(str, "actionUrl");
        k.c(str2, "method");
        k.c(hashMap, "headers");
        k.c(hashMap2, "content");
        String jSONObject = new JSONObject(hashMap2).toString();
        k.a((Object) jSONObject, "JSONObject(content as Ma…ring, String>).toString()");
        b bVar = new b(str, new DirectFormsResponse(), (Map<String, String>) null, hashMap, jSONObject);
        bVar.e();
        bVar.a(net.one97.paytm.wallet.utility.a.a(net.one97.paytm.wallet.communicator.b.a().getIntegerFromGTM(context, "p2mGenericAPITimeOut")));
        x.e eVar = new x.e();
        eVar.element = new y();
        bVar.a().observeForever(new a(eVar));
        return (y) eVar.element;
    }
}
