package net.one97.paytm.oauth.e;

import com.paytm.network.listener.b;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import com.paytm.network.model.NetworkResponse;
import java.nio.charset.Charset;
import kotlin.g.b.k;
import kotlin.m.d;
import kotlin.u;
import net.one97.paytm.oauth.OauthModule;
import net.one97.paytm.oauth.R;
import net.one97.paytm.oauth.utils.q;

public abstract class a implements b {

    /* renamed from: a  reason: collision with root package name */
    private String f52606a;

    /* access modifiers changed from: protected */
    public abstract void a(String str, int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError);

    /* access modifiers changed from: protected */
    public abstract void a(String str, IJRPaytmDataModel iJRPaytmDataModel);

    public a(String str) {
        this.f52606a = str;
    }

    public void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
        a(this.f52606a, iJRPaytmDataModel);
    }

    public void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
        String str;
        byte[] bArr;
        String str2;
        String url;
        NetworkResponse networkResponse;
        a(this.f52606a, i2, iJRPaytmDataModel, networkCustomError);
        if (i2 == -1) {
            net.one97.paytm.oauth.b b2 = OauthModule.b();
            k.a((Object) b2, "OauthModule.getOathDataProvider()");
            str = b2.getApplicationContext().getString(R.string.no_connection);
        } else {
            str = "No response";
        }
        if (networkCustomError == null || (networkResponse = networkCustomError.networkResponse) == null || (bArr = networkResponse.data) == null) {
            k.a((Object) str, "defaultResponse");
            Charset charset = d.f47971a;
            if (str != null) {
                bArr = str.getBytes(charset);
                k.a((Object) bArr, "(this as java.lang.String).getBytes(charset)");
            } else {
                throw new u("null cannot be cast to non-null type java.lang.String");
            }
        }
        String str3 = new String(bArr, d.f47971a);
        q qVar = q.f56798a;
        String k = q.k();
        String str4 = k == null ? "" : k;
        if (networkCustomError == null || (url = networkCustomError.getUrl()) == null) {
            str2 = "";
        } else {
            str2 = url;
        }
        OauthModule.b().logHawEyeEvent(new net.one97.paytm.oauth.models.a("OAuth", "OAuth", str4, str3, str2, i2));
        com.paytm.utility.q.b(str3);
    }
}
