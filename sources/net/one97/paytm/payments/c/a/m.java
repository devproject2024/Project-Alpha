package net.one97.paytm.payments.c.a;

import android.graphics.Bitmap;
import android.util.Base64;
import com.business.merchant_payments.common.utility.AppConstants;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import kotlin.g.b.k;
import net.one97.paytm.paymentsBank.utils.o;
import net.one97.paytm.phoenix.api.H5Event;
import net.one97.paytm.phoenix.api.b;
import net.one97.paytm.phoenix.core.a;
import org.json.JSONObject;

public final class m extends a {
    public m() {
        super("convertQrCodeIDToToQRCode");
    }

    public final boolean a(H5Event h5Event, b bVar) {
        k.c(h5Event, AppConstants.NOTIFICATION_DETAILS.EVENT);
        k.c(bVar, "bridgeContext");
        super.a(h5Event, bVar);
        b(h5Event, bVar);
        JSONObject params = h5Event.getParams();
        Bitmap qRCodeBitmap = o.a().getQRCodeBitmap(params != null ? params.getString("qrCodeId") : null, h5Event.getActivity());
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        qRCodeBitmap.compress(Bitmap.CompressFormat.JPEG, 100, byteArrayOutputStream);
        String encodeToString = Base64.encodeToString(byteArrayOutputStream.toByteArray(), 0);
        k.a((Object) encodeToString, "Base64.encodeToString(byteArray, Base64.DEFAULT)");
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("status", "ok");
        jSONObject.put("imageBase64", encodeToString);
        bVar.a(h5Event, jSONObject);
        try {
            byteArrayOutputStream.close();
            return true;
        } catch (IOException e2) {
            e2.printStackTrace();
            return true;
        }
    }
}
