package net.one97.paytm.transport.iocl.c;

import android.app.Application;
import androidx.databinding.h;
import androidx.databinding.m;
import androidx.lifecycle.y;
import com.paytm.network.listener.b;
import com.paytm.network.model.IJRPaytmDataModel;
import com.paytm.network.model.NetworkCustomError;
import net.one97.paytm.common.entity.CJRAadharPanGet;
import net.one97.paytm.transport.iocl.data.IOCLBaseModel;
import net.one97.paytm.transport.iocl.data.IOCLCommonResponse;

public class a extends androidx.lifecycle.a implements h, b {

    /* renamed from: a  reason: collision with root package name */
    public y<Boolean> f14295a = new y<>();

    /* renamed from: b  reason: collision with root package name */
    public y<IOCLCommonResponse> f14296b = new y<>();

    /* renamed from: c  reason: collision with root package name */
    public y<CJRAadharPanGet> f14297c = new y<>();

    /* renamed from: d  reason: collision with root package name */
    public y<String> f14298d = new y<>();

    /* renamed from: e  reason: collision with root package name */
    public y<Boolean> f14299e = new y<>();

    /* renamed from: f  reason: collision with root package name */
    m f14300f = new m();

    public a(Application application) {
        super(application);
    }

    public final void a(boolean z) {
        this.f14295a.setValue(Boolean.valueOf(z));
        this.f14300f.a(this, net.one97.paytm.iocl.a.f14082f);
    }

    public final IOCLCommonResponse a() {
        return this.f14296b.getValue();
    }

    public final CJRAadharPanGet b() {
        return this.f14297c.getValue();
    }

    public void addOnPropertyChangedCallback(h.a aVar) {
        this.f14300f.a(aVar);
    }

    public void removeOnPropertyChangedCallback(h.a aVar) {
        this.f14300f.b(aVar);
    }

    public void onApiSuccess(IJRPaytmDataModel iJRPaytmDataModel) {
        if (iJRPaytmDataModel instanceof IOCLBaseModel) {
            this.f14295a.setValue(Boolean.FALSE);
            IOCLBaseModel iOCLBaseModel = (IOCLBaseModel) iJRPaytmDataModel;
            if (iOCLBaseModel.getStatus().equalsIgnoreCase("SUCCESS")) {
                this.f14296b.setValue(iOCLBaseModel.getResponse());
            } else if (iOCLBaseModel.getStatus().equalsIgnoreCase("FAILURE")) {
                this.f14298d.setValue(iOCLBaseModel.getStatusMessage());
            }
            this.f14300f.a(this, net.one97.paytm.iocl.a.f14082f);
        } else if (iJRPaytmDataModel instanceof CJRAadharPanGet) {
            this.f14297c.setValue((CJRAadharPanGet) iJRPaytmDataModel);
        }
    }

    public void handleErrorCode(int i2, IJRPaytmDataModel iJRPaytmDataModel, NetworkCustomError networkCustomError) {
        this.f14295a.setValue(Boolean.FALSE);
        if (networkCustomError.getStatusCode() == 401 || networkCustomError.getStatusCode() == 410 || networkCustomError.getStatusCode() == 403) {
            this.f14299e.setValue(Boolean.TRUE);
        } else if (networkCustomError.getStatusCode() == 500) {
            this.f14298d.setValue("Something went wrong. Please try Again");
        } else {
            this.f14298d.setValue(networkCustomError.getMessage());
        }
        this.f14300f.a(this, net.one97.paytm.iocl.a.f14082f);
    }
}
