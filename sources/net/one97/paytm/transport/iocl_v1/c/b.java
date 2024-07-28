package net.one97.paytm.transport.iocl_v1.c;

import android.app.Application;
import androidx.databinding.h;
import androidx.databinding.m;
import androidx.lifecycle.a;
import androidx.lifecycle.y;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import net.one97.paytm.transport.iocl_v1.data.IOCLBaseModel;
import net.one97.paytm.transport.iocl_v1.data.IOCLCommonResponse;

public class b extends a implements h, com.paytm.network.listener.b {

    /* renamed from: a  reason: collision with root package name */
    public y<Boolean> f14433a = new y<>();

    /* renamed from: b  reason: collision with root package name */
    public y<IOCLCommonResponse> f14434b = new y<>();

    /* renamed from: c  reason: collision with root package name */
    public y<String> f14435c = new y<>();

    /* renamed from: d  reason: collision with root package name */
    public y<Boolean> f14436d = new y<>();

    /* renamed from: e  reason: collision with root package name */
    m f14437e = new m();

    public b(Application application) {
        super(application);
    }

    public final void a(boolean z) {
        this.f14433a.setValue(Boolean.valueOf(z));
        this.f14437e.a(this, net.one97.paytm.iocl.a.f14082f);
    }

    public final IOCLCommonResponse a() {
        return this.f14434b.getValue();
    }

    public void addOnPropertyChangedCallback(h.a aVar) {
        this.f14437e.a(aVar);
    }

    public void removeOnPropertyChangedCallback(h.a aVar) {
        this.f14437e.b(aVar);
    }

    public void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
        if (iJRPaytmDataModel instanceof IOCLBaseModel) {
            this.f14433a.setValue(Boolean.FALSE);
            IOCLBaseModel iOCLBaseModel = (IOCLBaseModel) iJRPaytmDataModel;
            if (iOCLBaseModel.getStatus().equalsIgnoreCase("SUCCESS")) {
                this.f14434b.setValue(iOCLBaseModel.getResponse());
            } else if (iOCLBaseModel.getStatus().equalsIgnoreCase("FAILURE")) {
                this.f14435c.setValue(iOCLBaseModel.getStatusMessage());
            }
            this.f14437e.a(this, net.one97.paytm.iocl.a.f14082f);
        }
    }

    public void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
        this.f14433a.setValue(Boolean.FALSE);
        if (networkCustomError.getStatusCode() == 401 || networkCustomError.getStatusCode() == 410) {
            this.f14436d.setValue(Boolean.TRUE);
        } else if (networkCustomError.getMessage().equalsIgnoreCase("500")) {
            this.f14435c.setValue("Something went wrong. Please try Again");
        } else {
            this.f14435c.setValue(networkCustomError.getMessage());
        }
        this.f14437e.a(this, net.one97.paytm.iocl.a.f14082f);
    }
}
