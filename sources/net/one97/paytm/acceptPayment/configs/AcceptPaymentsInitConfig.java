package net.one97.paytm.acceptPayment.configs;

import android.app.Application;
import com.business.common_module.b.h;
import net.one97.paytm.acceptPayment.b.a;

public class AcceptPaymentsInitConfig {
    /* access modifiers changed from: private */
    public a mAcceptPaymentsListener;
    /* access modifiers changed from: private */
    public h mAppKeys;
    /* access modifiers changed from: private */
    public Application mApplication;

    public Application getApplication() {
        return this.mApplication;
    }

    public h getAppKeys() {
        return this.mAppKeys;
    }

    public a getAcceptPaymentsListener() {
        return this.mAcceptPaymentsListener;
    }

    public static final class Builder {
        private AcceptPaymentsInitConfig configuration;

        public Builder(Application application) {
            AcceptPaymentsInitConfig acceptPaymentsInitConfig = new AcceptPaymentsInitConfig();
            this.configuration = acceptPaymentsInitConfig;
            Application unused = acceptPaymentsInitConfig.mApplication = application;
        }

        public final Builder setApplicationKeys(h hVar) {
            h unused = this.configuration.mAppKeys = hVar;
            return this;
        }

        public final Builder setAcceptPaymentsListener(a aVar) {
            a unused = this.configuration.mAcceptPaymentsListener = aVar;
            return this;
        }

        public final AcceptPaymentsInitConfig build() {
            checkNotNull(this.configuration.mAppKeys, "AppKeys");
            checkNotNull(this.configuration.mAcceptPaymentsListener, "mAcceptPaymentsListener");
            checkNotNull(this.configuration.mApplication, "mApplication");
            return this.configuration;
        }

        private void checkNotNull(Object obj, String str) {
            if (obj == null) {
                throw new IllegalArgumentException(str + " can't be null.");
            }
        }
    }
}
