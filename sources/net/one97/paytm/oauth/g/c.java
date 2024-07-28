package net.one97.paytm.oauth.g;

import android.content.Context;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ai;
import androidx.lifecycle.y;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import net.one97.paytm.oauth.b.b;
import net.one97.paytm.oauth.e;
import net.one97.paytm.oauth.e.a;
import net.one97.paytm.oauth.models.ErrorModel;

public class c extends ai {
    public final LiveData<e<IJRPaytmDataModel>> a(Context context, String str) {
        final y yVar = new y();
        b.a(context, (com.paytm.network.listener.b) new com.paytm.network.listener.b() {
            public final void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
                yVar.setValue(e.a(iJRPaytmDataModel));
            }

            public final void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
                yVar.setValue(e.a(new ErrorModel(i2, iJRPaytmDataModel, networkCustomError), (Throwable) networkCustomError));
            }
        }, str);
        return yVar;
    }

    public final LiveData<e<IJRPaytmDataModel>> a(String str, String str2) {
        final y yVar = new y();
        b.i(new a("oauthdevicebindingclaimSv1") {
            public final void a(String str, IJRPaytmDataModel iJRPaytmDataModel) {
                yVar.setValue(e.a(iJRPaytmDataModel, str));
            }

            public final void a(String str, int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
                yVar.setValue(e.a(new ErrorModel(i2, iJRPaytmDataModel, networkCustomError), networkCustomError, str));
            }
        }, str, str2);
        return yVar;
    }
}
