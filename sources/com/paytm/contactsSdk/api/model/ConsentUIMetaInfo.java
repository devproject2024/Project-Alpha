package com.paytm.contactsSdk.api.model;

import com.paytm.contactsSdk.ContactsSdk;
import com.paytm.contactsSdk.R;
import kotlin.g.b.g;
import kotlin.g.b.k;

public final class ConsentUIMetaInfo {
    private final int confirmationButtonText;
    private final int deniedButtonText;
    private final int descriptionText;
    private final int headerText;
    private final String tnCLink;
    private final int tnCText;

    private ConsentUIMetaInfo(int i2, int i3, String str, int i4, int i5, int i6) {
        this.headerText = i2;
        this.descriptionText = i3;
        this.tnCLink = str;
        this.tnCText = i4;
        this.confirmationButtonText = i5;
        this.deniedButtonText = i6;
    }

    public /* synthetic */ ConsentUIMetaInfo(int i2, int i3, String str, int i4, int i5, int i6, g gVar) {
        this(i2, i3, str, i4, i5, i6);
    }

    public final int getHeaderText() {
        return this.headerText;
    }

    public final int getDescriptionText() {
        return this.descriptionText;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    /* synthetic */ ConsentUIMetaInfo(int i2, int i3, String str, int i4, int i5, int i6, int i7, g gVar) {
        this(i2, i3, (i7 & 4) != 0 ? "" : str, i4, i5, i6);
    }

    public final String getTnCLink() {
        return this.tnCLink;
    }

    public final int getTnCText() {
        return this.tnCText;
    }

    public final int getConfirmationButtonText() {
        return this.confirmationButtonText;
    }

    public final int getDeniedButtonText() {
        return this.deniedButtonText;
    }

    public static final class Builder {
        private int confirmationButtonText = R.string.allow_contacts_sdk;
        private int deniedButtonText = R.string.skip_contact_sdk;
        private int descriptionText = R.string.description_contacts_sdk;
        private int headerText = R.string.header_contacts_sdk;
        private String tnCLink = ContactsSdk.INSTANCE.getContactsSDKApplicationInterface$contacts_sdk_release().consentPrivacyPolicyUrl();
        private int tnCText = R.string.privacy_contacts_sdk;

        public final Builder setHeaderText(int i2) {
            Builder builder = this;
            builder.headerText = i2;
            return builder;
        }

        public final Builder setDescriptionText(int i2) {
            Builder builder = this;
            builder.descriptionText = builder.descriptionText;
            return builder;
        }

        public final Builder setTnCLink(String str) {
            k.c(str, "tnCLink");
            Builder builder = this;
            builder.tnCLink = str;
            return builder;
        }

        public final Builder setTnCText(int i2) {
            Builder builder = this;
            builder.tnCText = i2;
            return builder;
        }

        public final Builder setConfirmationButtonText(int i2) {
            Builder builder = this;
            builder.confirmationButtonText = i2;
            return builder;
        }

        public final Builder setDeniedButtonText(int i2) {
            Builder builder = this;
            builder.deniedButtonText = i2;
            return builder;
        }

        public final ConsentUIMetaInfo build() {
            return new ConsentUIMetaInfo(this.headerText, this.descriptionText, this.tnCLink, this.tnCText, this.confirmationButtonText, this.deniedButtonText, (g) null);
        }
    }
}
