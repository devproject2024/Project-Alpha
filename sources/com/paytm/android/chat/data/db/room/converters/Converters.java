package com.paytm.android.chat.data.db.room.converters;

import com.google.gsonhtcfix.f;
import com.paytm.android.chat.bean.ChannelMetaData;
import com.paytm.android.chat.bean.RegistrationStatus;
import com.paytm.android.chat.bean.UserExtendedMetaData;
import com.paytm.android.chat.bean.UserMetaData;
import com.paytm.android.chat.bean.UserType;
import com.paytm.android.chat.data.db.room.db_entities.UserInfoSource;
import com.paytm.android.chat.data.models.messages.MPCPreviewDrawable;
import com.sendbird.android.Member;
import java.util.List;
import kotlin.g.b.k;

public final class Converters {
    private final f gson = new f();

    public final f getGson() {
        return this.gson;
    }

    public final ChannelMetaData fromJsonToChannelMetadata(String str) {
        return (ChannelMetaData) this.gson.a(str, ChannelMetaData.class);
    }

    public final String fromChannelMetadataToJson(ChannelMetaData channelMetaData) {
        return this.gson.a((Object) channelMetaData);
    }

    public final UserInfoSource toUserInfoSource(String str) {
        return UserInfoSource.Companion.fromString(str);
    }

    public final String fromUserInfoSource(UserInfoSource userInfoSource) {
        if (userInfoSource != null) {
            return userInfoSource.toString();
        }
        return null;
    }

    public final UserMetaData toUserMetaData(String str) {
        try {
            UserMetaData userMetaData = (UserMetaData) this.gson.a(str, UserMetaData.class);
            if (userMetaData == null) {
                return null;
            }
            if (userMetaData.getUserType() == null) {
                userMetaData.setUserType(UserType.CUSTOMER);
            }
            if (userMetaData.getRegistrationStatus() == null) {
                userMetaData.setRegistrationStatus(RegistrationStatus.COMPLETE);
            }
            return userMetaData;
        } catch (Exception unused) {
            return null;
        }
    }

    public final String fromUserMetaData(UserMetaData userMetaData) {
        if (userMetaData != null) {
            return this.gson.a((Object) userMetaData);
        }
        return null;
    }

    public final UserExtendedMetaData toUserExtendedMetaData(String str) {
        try {
            return (UserExtendedMetaData) this.gson.a(str, UserExtendedMetaData.class);
        } catch (Exception unused) {
            return null;
        }
    }

    public final String fromUserExtendedMeta(UserExtendedMetaData userExtendedMetaData) {
        if (userExtendedMetaData != null) {
            return this.gson.a((Object) userExtendedMetaData);
        }
        return null;
    }

    public final String memberListToJson(List<? extends Member> list) {
        return this.gson.a((Object) list);
    }

    public final List<Member> jsonToMemberList(String str) {
        k.c(str, "value");
        Object a2 = this.gson.a(str, Member[].class);
        k.a(a2, "gson.fromJson(value, Array<Member>::class.java)");
        return kotlin.a.f.b((Object[]) a2);
    }

    public final MPCPreviewDrawable fromMessagePreviewDrawable(Integer num) {
        if (num == null) {
            return null;
        }
        num.intValue();
        return MPCPreviewDrawable.values()[num.intValue()];
    }

    public final Integer toMessagePreviewDrawable(MPCPreviewDrawable mPCPreviewDrawable) {
        if (mPCPreviewDrawable != null) {
            return Integer.valueOf(mPCPreviewDrawable.ordinal());
        }
        return null;
    }
}
