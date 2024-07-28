package com.sendbird.android;

import com.google.android.gms.safetynet.SafetyNetStatusCodes;
import com.paytm.business.merchantprofile.common.utility.AppConstants;
import net.one97.paytm.games.model.pfg.BaseResult;

enum j {
    CATEGORY_NONE(0, false),
    CHANNEL_ENTER(10102, false),
    CHANNEL_EXIT(10103, false),
    USER_CHANNEL_MUTE(10201, false),
    USER_CHANNEL_UNMUTE(10200, false),
    USER_CHANNEL_BAN(10601, false),
    USER_CHANNEL_UNBAN(10600, false),
    CHANNEL_FREEZE(10701, false),
    CHANNEL_UNFREEZE(10700, false),
    PROFANITY_MESSAGE_BLOCK(10800, false),
    TYPING_START(10900, false),
    TYPING_END(10901, false),
    CHANNEL_JOIN(AppConstants.START_OTP_FLOW, false),
    CHANNEL_LEAVE(BaseResult.RESP_SYS_EXCEPTION, false),
    CHANNEL_OPERATOR_CHANGED(BaseResult.RESP_SYS_UPGRADING, false),
    CHANNEL_INVITE(10020, false),
    CHANNEL_DECLINE_INVITE(10022, false),
    CHANNEL_PROP_CHANGED(11000, true),
    CHANNEL_DELETED(SafetyNetStatusCodes.SAFE_BROWSING_UNSUPPORTED_THREAT_TYPES, false),
    CHANNEL_META_DATA_CHANGED(11100, false),
    CHANNEL_META_COUNTERS_CHANGED(11200, false),
    CHANNEL_HIDDEN(13000, false),
    CHANNEL_UNHIDDEN(13001, false);
    
    private final int category;
    private final boolean withoutCache;

    private j(int i2, boolean z) {
        this.category = i2;
        this.withoutCache = z;
    }

    /* access modifiers changed from: package-private */
    public final boolean useWithoutCache() {
        return this.withoutCache;
    }

    static j from(int i2) {
        for (j jVar : values()) {
            if (jVar.category == i2) {
                return jVar;
            }
        }
        return CATEGORY_NONE;
    }

    public final int getCategory() {
        return this.category;
    }
}
