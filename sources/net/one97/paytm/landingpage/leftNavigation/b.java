package net.one97.paytm.landingpage.leftNavigation;

import com.paytmmall.clpartifact.listeners.IGAEnableListener;
import com.paytmmall.clpartifact.modal.SanitizedResponseModel;

public final class b {

    /* renamed from: a  reason: collision with root package name */
    public static final b f52831a = new b();

    /* renamed from: b  reason: collision with root package name */
    private static SanitizedResponseModel f52832b;

    private b() {
    }

    public static final class a implements IGAEnableListener {
        public final boolean isGAEnabled() {
            return false;
        }

        a() {
        }
    }

    public static void a(SanitizedResponseModel sanitizedResponseModel) {
        if (sanitizedResponseModel != null) {
            f52832b = new SanitizedResponseModel(sanitizedResponseModel.getRvWidgets(), sanitizedResponseModel.getSfWidgets(), sanitizedResponseModel.getAdRequestId(), sanitizedResponseModel.getVerticalName(), 1005, new a());
        }
    }

    public static SanitizedResponseModel a() {
        return f52832b;
    }
}
