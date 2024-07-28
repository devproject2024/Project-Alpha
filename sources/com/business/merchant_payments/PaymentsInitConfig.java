package com.business.merchant_payments;

import android.app.Application;
import android.content.Context;
import com.business.a.a;
import com.business.common_module.b.a;
import com.business.common_module.b.b;
import com.business.common_module.b.c;
import com.business.common_module.b.d;
import com.business.common_module.b.e;
import com.business.common_module.b.f;
import com.business.common_module.b.g;
import com.business.common_module.b.h;
import com.business.common_module.b.i;
import com.business.common_module.b.j;

public class PaymentsInitConfig {
    public a appBuildConfiguration;
    public Context appContext;
    public h appKeys;
    public j appSharedPreference;
    public Application application;
    public String clientName;
    public a.C0102a commonHeaderInterface;
    public b commonUtils;
    public String deepLinkTargetScreenIntentString;
    public c deepLinkUtils;
    public d errorHandler;
    public e gaEventPublisher;
    public f gtmDataProvider;
    public a.b hawkEyeNetworkInterface;
    public i merchantDataProvider;
    public g nativeAppKeyManager;

    public b getCommonUtils() {
        return this.commonUtils;
    }

    public PaymentsInitConfig() {
    }

    public Application getApplication() {
        return this.application;
    }

    public h getAppKeys() {
        return this.appKeys;
    }

    public e getGaEventPublisher() {
        return this.gaEventPublisher;
    }

    public String getClientName() {
        return this.clientName;
    }

    public f getGtmDataProvider() {
        return this.gtmDataProvider;
    }

    public com.business.common_module.b.a getAppBuildConfiguration() {
        return this.appBuildConfiguration;
    }

    public j getAppSharedPreference() {
        return this.appSharedPreference;
    }

    public d getErrorHandler() {
        return this.errorHandler;
    }

    public Context getAppContext() {
        return this.appContext;
    }

    public c getDeepLinkUtils() {
        return this.deepLinkUtils;
    }

    public String getDeepLinkTargetScreenIntentString() {
        return this.deepLinkTargetScreenIntentString;
    }

    public a.b getHawkEyeNetworkInterface() {
        return this.hawkEyeNetworkInterface;
    }

    public a.C0102a getCommonHeaderInterface() {
        return this.commonHeaderInterface;
    }

    public g getNativeAppKeyManager() {
        return this.nativeAppKeyManager;
    }

    public i getMerchantDataProvider() {
        return this.merchantDataProvider;
    }

    public static final class Builder {
        public PaymentsInitConfig configuration;

        public Builder(Application application) {
            PaymentsInitConfig paymentsInitConfig = new PaymentsInitConfig();
            this.configuration = paymentsInitConfig;
            Application unused = paymentsInitConfig.application = application;
        }

        public final Builder setApplicationContext(Context context) {
            Context unused = this.configuration.appContext = context;
            return this;
        }

        public final Builder setClientName(String str) {
            String unused = this.configuration.clientName = str;
            return this;
        }

        public final Builder setApplicationKeys(h hVar) {
            h unused = this.configuration.appKeys = hVar;
            return this;
        }

        public final Builder setGAEventPublisher(e eVar) {
            e unused = this.configuration.gaEventPublisher = eVar;
            return this;
        }

        public final Builder setGtmDataProvider(f fVar) {
            f unused = this.configuration.gtmDataProvider = fVar;
            return this;
        }

        public final Builder setMerchantDataProvider(i iVar) {
            i unused = this.configuration.merchantDataProvider = iVar;
            return this;
        }

        public final Builder setAppBuildConfiguration(com.business.common_module.b.a aVar) {
            com.business.common_module.b.a unused = this.configuration.appBuildConfiguration = aVar;
            return this;
        }

        public final Builder setAppSharedPreference(j jVar) {
            j unused = this.configuration.appSharedPreference = jVar;
            return this;
        }

        public final Builder setErrorHandlerListener(d dVar) {
            d unused = this.configuration.errorHandler = dVar;
            return this;
        }

        public final Builder setHawkEyeNetworkInterface(a.b bVar) {
            a.b unused = this.configuration.hawkEyeNetworkInterface = bVar;
            return this;
        }

        public final Builder setCommonHeaderInterface(a.C0102a aVar) {
            a.C0102a unused = this.configuration.commonHeaderInterface = aVar;
            return this;
        }

        public final Builder setNativeAppKeyManager(g gVar) {
            g unused = this.configuration.nativeAppKeyManager = gVar;
            return this;
        }

        public final Builder setCommonUtils(b bVar) {
            b unused = this.configuration.commonUtils = bVar;
            return this;
        }

        public final Builder setDeepLinkUtils(c cVar) {
            c unused = this.configuration.deepLinkUtils = cVar;
            return this;
        }

        public final Builder setDeepLinkTargetScreenIntentString(String str) {
            String unused = this.configuration.deepLinkTargetScreenIntentString = str;
            return this;
        }

        public final PaymentsInitConfig build() {
            checkNotNull(this.configuration.appKeys, "AppKeys");
            checkNotNull(this.configuration.application, "application instance");
            checkNotNull(this.configuration.clientName, "Client name");
            checkNotNull(this.configuration.appContext, "application context instance");
            checkNotNull(this.configuration.gaEventPublisher, "EventPublisher");
            checkNotNull(this.configuration.merchantDataProvider, "MerchantDataProvider");
            checkNotNull(this.configuration.gtmDataProvider, "GtmDataProvider");
            checkNotNull(this.configuration.appBuildConfiguration, "appBuildConfiguration ");
            checkNotNull(this.configuration.appSharedPreference, " appSharedPreference");
            checkNotNull(this.configuration.errorHandler, " errorHandlerListener");
            checkNotNull(this.configuration.deepLinkTargetScreenIntentString, " deepLinkTargetScreenIntentString");
            checkNotNull(this.configuration.deepLinkUtils, " deepLinkUtils");
            checkNotNull(this.configuration.hawkEyeNetworkInterface, "hawkEyeNetworkInterface");
            checkNotNull(this.configuration.commonHeaderInterface, "commonHeaderInterface");
            checkNotNull(this.configuration.nativeAppKeyManager, "nativeAppKeyManager");
            return this.configuration;
        }

        private void checkNotNull(Object obj, String str) {
            if (obj == null) {
                throw new IllegalArgumentException(str + " can't be null.");
            }
        }
    }
}
