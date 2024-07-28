package net.one97.paytm.transport.iocl.a;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.z;
import net.one97.paytm.transport.iocl.activity.AJRIOCLHomeActivity;
import net.one97.paytm.transport.iocl.data.IOCLCommonResponse;

public abstract class a extends Fragment {
    /* access modifiers changed from: protected */
    public abstract net.one97.paytm.transport.iocl.c.a a();

    public final void b() {
        if (getActivity() instanceof AJRIOCLHomeActivity) {
            a().f14296b.observe(this, new z<IOCLCommonResponse>() {
                public final /* synthetic */ void onChanged(Object obj) {
                    IOCLCommonResponse iOCLCommonResponse = (IOCLCommonResponse) obj;
                    if (iOCLCommonResponse != null && iOCLCommonResponse.getUser() != null && iOCLCommonResponse.getUser().getStatus() != null) {
                        if (iOCLCommonResponse.getUser().getStatus().equalsIgnoreCase("REGISTERED") || iOCLCommonResponse.getUser().getStatus().equalsIgnoreCase("USER_REQUESTED") || iOCLCommonResponse.getUser().getStatus().equalsIgnoreCase("REQUEST_INITIATED")) {
                            ((AJRIOCLHomeActivity) a.this.getActivity()).f14252a.c();
                        }
                    }
                }
            });
            a().f14295a.observe(this, new z<Boolean>() {
                public final /* synthetic */ void onChanged(Object obj) {
                    Boolean bool = (Boolean) obj;
                    if (bool != null) {
                        ((AJRIOCLHomeActivity) a.this.getActivity()).f14252a.a(bool.booleanValue());
                    }
                }
            });
            a().f14298d.observe(this, new z<String>() {
                public final /* synthetic */ void onChanged(Object obj) {
                    ((AJRIOCLHomeActivity) a.this.getActivity()).f14252a.f14298d.setValue((String) obj);
                }
            });
            a().f14299e.observe(this, new z() {
                public final void onChanged(Object obj) {
                    a.this.a((Boolean) obj);
                }
            });
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(Boolean bool) {
        if (bool != null && bool.booleanValue()) {
            ((AJRIOCLHomeActivity) getActivity()).d();
        }
    }
}
