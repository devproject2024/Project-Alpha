package net.one97.paytm.transport.iocl_v1.a;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.z;
import net.one97.paytm.transport.iocl_v1.activity.AJRIOCLHomeActivity;
import net.one97.paytm.transport.iocl_v1.c.b;
import net.one97.paytm.transport.iocl_v1.data.IOCLCommonResponse;

public abstract class a extends Fragment {
    /* access modifiers changed from: protected */
    public abstract b a();

    public final void b() {
        if (getActivity() instanceof AJRIOCLHomeActivity) {
            a().f14434b.observe(this, new z<IOCLCommonResponse>() {
                public final /* synthetic */ void onChanged(Object obj) {
                    IOCLCommonResponse iOCLCommonResponse = (IOCLCommonResponse) obj;
                    if (iOCLCommonResponse != null && iOCLCommonResponse.getUser() != null) {
                        if (iOCLCommonResponse.getUser().getStatus().equalsIgnoreCase("REGISTERED") || iOCLCommonResponse.getUser().getStatus().equalsIgnoreCase("USER_REQUESTED") || iOCLCommonResponse.getUser().getStatus().equalsIgnoreCase("REQUEST_INITIATED")) {
                            ((AJRIOCLHomeActivity) a.this.getActivity()).f14393b.b();
                        }
                    }
                }
            });
            a().f14433a.observe(this, new z<Boolean>() {
                public final /* synthetic */ void onChanged(Object obj) {
                    Boolean bool = (Boolean) obj;
                    if (bool != null) {
                        ((AJRIOCLHomeActivity) a.this.getActivity()).f14393b.a(bool.booleanValue());
                    }
                }
            });
            a().f14435c.observe(this, new z<String>() {
                public final /* synthetic */ void onChanged(Object obj) {
                    ((AJRIOCLHomeActivity) a.this.getActivity()).f14393b.f14435c.setValue((String) obj);
                }
            });
            a().f14436d.observe(this, new z() {
                public final void onChanged(Object obj) {
                    a.this.a((Boolean) obj);
                }
            });
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(Boolean bool) {
        if (bool != null && bool.booleanValue()) {
            ((AJRIOCLHomeActivity) getActivity()).f();
        }
    }
}
