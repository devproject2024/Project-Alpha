package com.paytm.contactsSdk;

import com.paytm.contactsSdk.api.ContactsProvider;
import net.one97.paytm.ups.provider.UpsJarvisInterface;

public interface ContactsSDKApplicationInterface extends UpsJarvisInterface {
    String consentPrivacyPolicyUrl();

    int downloadBatchSize();

    boolean getConsentStatusFromSmsSdk();

    String getContactsSdkBaseURL();

    String getIp();

    boolean getIsStage();

    String getLanLng();

    String getLocale();

    String getNetworkType();

    int getWorkManagerRetryInterval();

    long healthApiInterval();

    boolean isConsentStatusAvailableInSmsSdk();

    boolean isContactsSDKLocalSyncEnabled();

    boolean isContactsSDKRemoteSyncEnabled();

    void onLogin();

    void removeConsentStatusFromSmsSdk();

    void updateConsent();

    int uploadBatchSize();

    int workManagerRetryCount();

    public static final class DefaultImpls {
        public static boolean getConsentStatusFromSmsSdk(ContactsSDKApplicationInterface contactsSDKApplicationInterface) {
            return false;
        }

        public static boolean isConsentStatusAvailableInSmsSdk(ContactsSDKApplicationInterface contactsSDKApplicationInterface) {
            return false;
        }

        public static void removeConsentStatusFromSmsSdk(ContactsSDKApplicationInterface contactsSDKApplicationInterface) {
        }

        public static void onLogin(ContactsSDKApplicationInterface contactsSDKApplicationInterface) {
            contactsSDKApplicationInterface.updateConsent();
        }

        public static void updateConsent(ContactsSDKApplicationInterface contactsSDKApplicationInterface) {
            ContactsProvider.INSTANCE.updateConsent(true, new ContactsSDKApplicationInterface$updateConsent$1(contactsSDKApplicationInterface));
        }
    }
}
