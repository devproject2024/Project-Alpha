package com.paytm.android.chat.network.response;

import android.text.TextUtils;
import android.util.Base64;
import com.appsflyer.internal.referrer.Payload;
import com.google.gsonhtcfix.f;
import com.google.gsonhtcfix.l;
import com.google.gsonhtcfix.o;
import com.paytm.android.chat.bean.jsonbean.UsersInfoJsonBean;
import com.paytm.android.chat.data.models.users.payments.GetUserInfoByIdsResponse;
import com.paytm.android.chat.data.models.users.payments.UserInfoByIdsData;
import com.paytm.android.chat.network.response.ResponseOfRegisterSendBird;
import com.paytm.utility.q;
import com.paytmmall.clpartifact.customViews.PriceRangeSeekBar;
import com.sendbird.android.BaseChannel;
import com.sendbird.android.constant.StringSet;
import java.nio.charset.Charset;
import java.util.Map;
import kotlin.g.b.g;
import kotlin.g.b.k;
import kotlin.m.d;
import kotlin.m.p;
import kotlin.u;
import okhttp3.Response;
import okhttp3.ResponseBody;

public final class CreateChannelResponse {
    public static final Companion Companion = new Companion((g) null);
    private final Failure failureResponse;
    private final boolean isSuccess;
    private final Success successResponse;

    public static /* synthetic */ CreateChannelResponse copy$default(CreateChannelResponse createChannelResponse, boolean z, Success success, Failure failure, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            z = createChannelResponse.isSuccess;
        }
        if ((i2 & 2) != 0) {
            success = createChannelResponse.successResponse;
        }
        if ((i2 & 4) != 0) {
            failure = createChannelResponse.failureResponse;
        }
        return createChannelResponse.copy(z, success, failure);
    }

    public final boolean component1() {
        return this.isSuccess;
    }

    public final Success component2() {
        return this.successResponse;
    }

    public final Failure component3() {
        return this.failureResponse;
    }

    public final CreateChannelResponse copy(boolean z, Success success, Failure failure) {
        return new CreateChannelResponse(z, success, failure);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CreateChannelResponse)) {
            return false;
        }
        CreateChannelResponse createChannelResponse = (CreateChannelResponse) obj;
        return this.isSuccess == createChannelResponse.isSuccess && k.a((Object) this.successResponse, (Object) createChannelResponse.successResponse) && k.a((Object) this.failureResponse, (Object) createChannelResponse.failureResponse);
    }

    public final int hashCode() {
        boolean z = this.isSuccess;
        if (z) {
            z = true;
        }
        int i2 = (z ? 1 : 0) * true;
        Success success = this.successResponse;
        int i3 = 0;
        int hashCode = (i2 + (success != null ? success.hashCode() : 0)) * 31;
        Failure failure = this.failureResponse;
        if (failure != null) {
            i3 = failure.hashCode();
        }
        return hashCode + i3;
    }

    public final String toString() {
        return "CreateChannelResponse(isSuccess=" + this.isSuccess + ", successResponse=" + this.successResponse + ", failureResponse=" + this.failureResponse + ")";
    }

    public CreateChannelResponse(boolean z, Success success, Failure failure) {
        this.isSuccess = z;
        this.successResponse = success;
        this.failureResponse = failure;
    }

    public final boolean isSuccess() {
        return this.isSuccess;
    }

    public final Success getSuccessResponse() {
        return this.successResponse;
    }

    public final Failure getFailureResponse() {
        return this.failureResponse;
    }

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(g gVar) {
            this();
        }

        public final CreateChannelResponse createFromResponse(Response response) {
            BaseChannel baseChannel;
            UserInfoByIdsData userInfoByUserIdResponse;
            String str;
            k.c(response, Payload.RESPONSE);
            if (!response.isSuccessful()) {
                return new CreateChannelResponse(false, (Success) null, new Failure(response.code(), response.message()));
            }
            f fVar = new f();
            ResponseBody body = response.body();
            String string = body != null ? body.string() : null;
            q.d("response\n".concat(String.valueOf(string)));
            ResponseOfRegisterSendBird responseOfRegisterSendBird = (ResponseOfRegisterSendBird) fVar.a(string, ResponseOfRegisterSendBird.class);
            k.a((Object) responseOfRegisterSendBird, "responseObject");
            if (!responseOfRegisterSendBird.isSuccess()) {
                return new CreateChannelResponse(false, (Success) null, new Failure(response.code(), responseOfRegisterSendBird.getResultMessage()));
            }
            ResponseOfRegisterSendBird.DataOfRegisterSendBird data = responseOfRegisterSendBird.getData();
            String channelUrl = data != null ? data.getChannelUrl() : null;
            if (!TextUtils.isEmpty(data != null ? data.getChannelData() : null)) {
                k.a((Object) data, "data");
                o oVar = (o) new f().a(data.getChannelData(), o.class);
                if (!oVar.a(StringSet.channel_type)) {
                    l b2 = oVar.b("name");
                    if (b2 == null || (str = b2.b()) == null) {
                        str = "";
                    }
                    CharSequence charSequence = str;
                    if (p.a(charSequence, (CharSequence) "Group Channel", true) || !p.a(charSequence, (CharSequence) "Open Channel", true)) {
                        oVar.a(StringSet.channel_type, BaseChannel.ChannelType.GROUP.value());
                    } else {
                        oVar.a(StringSet.channel_type, BaseChannel.ChannelType.OPEN.value());
                    }
                }
                String oVar2 = oVar.toString();
                k.a((Object) oVar2, "channelJson.toString()");
                Charset charset = d.f47971a;
                if (oVar2 != null) {
                    byte[] bytes = oVar2.getBytes(charset);
                    k.a((Object) bytes, "(this as java.lang.String).getBytes(charset)");
                    byte[] encode = Base64.encode(bytes, 0);
                    k.a((Object) encode, "byteArray");
                    int length = encode.length;
                    for (int i2 = 0; i2 < length; i2++) {
                        encode[i2] = (byte) (encode[i2] ^ ((byte) (i2 & PriceRangeSeekBar.INVALID_POINTER_ID)));
                    }
                    baseChannel = BaseChannel.buildFromSerializedData(encode);
                } else {
                    throw new u("null cannot be cast to non-null type java.lang.String");
                }
            } else {
                baseChannel = null;
            }
            Map<String, UsersInfoJsonBean> map = (data == null || (userInfoByUserIdResponse = data.getUserInfoByUserIdResponse()) == null) ? null : userInfoByUserIdResponse.getMap();
            GetUserInfoByIdsResponse getUserInfoByIdsResponse = new GetUserInfoByIdsResponse(new UserInfoByIdsData(map));
            if (data == null || channelUrl == null || baseChannel == null || map == null) {
                return null;
            }
            ResponseOfRegisterSendBird.DataOfRegisterSendBird data2 = responseOfRegisterSendBird.getData();
            k.a((Object) data2, "responseObject.data");
            return new CreateChannelResponse(true, new Success(data2, channelUrl, baseChannel, map, getUserInfoByIdsResponse), (Failure) null);
        }
    }

    public static final class Success {
        private final BaseChannel channel;
        private final Map<String, UsersInfoJsonBean> channelChatPayeeUsers;
        private final String channelurl;
        private final ResponseOfRegisterSendBird.DataOfRegisterSendBird data;
        private final GetUserInfoByIdsResponse userInfo;

        public static /* synthetic */ Success copy$default(Success success, ResponseOfRegisterSendBird.DataOfRegisterSendBird dataOfRegisterSendBird, String str, BaseChannel baseChannel, Map<String, UsersInfoJsonBean> map, GetUserInfoByIdsResponse getUserInfoByIdsResponse, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                dataOfRegisterSendBird = success.data;
            }
            if ((i2 & 2) != 0) {
                str = success.channelurl;
            }
            String str2 = str;
            if ((i2 & 4) != 0) {
                baseChannel = success.channel;
            }
            BaseChannel baseChannel2 = baseChannel;
            if ((i2 & 8) != 0) {
                map = success.channelChatPayeeUsers;
            }
            Map<String, UsersInfoJsonBean> map2 = map;
            if ((i2 & 16) != 0) {
                getUserInfoByIdsResponse = success.userInfo;
            }
            return success.copy(dataOfRegisterSendBird, str2, baseChannel2, map2, getUserInfoByIdsResponse);
        }

        public final ResponseOfRegisterSendBird.DataOfRegisterSendBird component1() {
            return this.data;
        }

        public final String component2() {
            return this.channelurl;
        }

        public final BaseChannel component3() {
            return this.channel;
        }

        public final Map<String, UsersInfoJsonBean> component4() {
            return this.channelChatPayeeUsers;
        }

        public final GetUserInfoByIdsResponse component5() {
            return this.userInfo;
        }

        public final Success copy(ResponseOfRegisterSendBird.DataOfRegisterSendBird dataOfRegisterSendBird, String str, BaseChannel baseChannel, Map<String, ? extends UsersInfoJsonBean> map, GetUserInfoByIdsResponse getUserInfoByIdsResponse) {
            k.c(dataOfRegisterSendBird, "data");
            k.c(str, "channelurl");
            k.c(baseChannel, "channel");
            k.c(map, "channelChatPayeeUsers");
            k.c(getUserInfoByIdsResponse, "userInfo");
            return new Success(dataOfRegisterSendBird, str, baseChannel, map, getUserInfoByIdsResponse);
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Success)) {
                return false;
            }
            Success success = (Success) obj;
            return k.a((Object) this.data, (Object) success.data) && k.a((Object) this.channelurl, (Object) success.channelurl) && k.a((Object) this.channel, (Object) success.channel) && k.a((Object) this.channelChatPayeeUsers, (Object) success.channelChatPayeeUsers) && k.a((Object) this.userInfo, (Object) success.userInfo);
        }

        public final int hashCode() {
            ResponseOfRegisterSendBird.DataOfRegisterSendBird dataOfRegisterSendBird = this.data;
            int i2 = 0;
            int hashCode = (dataOfRegisterSendBird != null ? dataOfRegisterSendBird.hashCode() : 0) * 31;
            String str = this.channelurl;
            int hashCode2 = (hashCode + (str != null ? str.hashCode() : 0)) * 31;
            BaseChannel baseChannel = this.channel;
            int hashCode3 = (hashCode2 + (baseChannel != null ? baseChannel.hashCode() : 0)) * 31;
            Map<String, UsersInfoJsonBean> map = this.channelChatPayeeUsers;
            int hashCode4 = (hashCode3 + (map != null ? map.hashCode() : 0)) * 31;
            GetUserInfoByIdsResponse getUserInfoByIdsResponse = this.userInfo;
            if (getUserInfoByIdsResponse != null) {
                i2 = getUserInfoByIdsResponse.hashCode();
            }
            return hashCode4 + i2;
        }

        public final String toString() {
            return "Success(data=" + this.data + ", channelurl=" + this.channelurl + ", channel=" + this.channel + ", channelChatPayeeUsers=" + this.channelChatPayeeUsers + ", userInfo=" + this.userInfo + ")";
        }

        public Success(ResponseOfRegisterSendBird.DataOfRegisterSendBird dataOfRegisterSendBird, String str, BaseChannel baseChannel, Map<String, ? extends UsersInfoJsonBean> map, GetUserInfoByIdsResponse getUserInfoByIdsResponse) {
            k.c(dataOfRegisterSendBird, "data");
            k.c(str, "channelurl");
            k.c(baseChannel, "channel");
            k.c(map, "channelChatPayeeUsers");
            k.c(getUserInfoByIdsResponse, "userInfo");
            this.data = dataOfRegisterSendBird;
            this.channelurl = str;
            this.channel = baseChannel;
            this.channelChatPayeeUsers = map;
            this.userInfo = getUserInfoByIdsResponse;
        }

        public final ResponseOfRegisterSendBird.DataOfRegisterSendBird getData() {
            return this.data;
        }

        public final String getChannelurl() {
            return this.channelurl;
        }

        public final BaseChannel getChannel() {
            return this.channel;
        }

        public final Map<String, UsersInfoJsonBean> getChannelChatPayeeUsers() {
            return this.channelChatPayeeUsers;
        }

        public final GetUserInfoByIdsResponse getUserInfo() {
            return this.userInfo;
        }
    }

    public static final class Failure {
        private final String error;
        private final int errorCode;

        public static /* synthetic */ Failure copy$default(Failure failure, int i2, String str, int i3, Object obj) {
            if ((i3 & 1) != 0) {
                i2 = failure.errorCode;
            }
            if ((i3 & 2) != 0) {
                str = failure.error;
            }
            return failure.copy(i2, str);
        }

        public final int component1() {
            return this.errorCode;
        }

        public final String component2() {
            return this.error;
        }

        public final Failure copy(int i2, String str) {
            return new Failure(i2, str);
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Failure)) {
                return false;
            }
            Failure failure = (Failure) obj;
            return this.errorCode == failure.errorCode && k.a((Object) this.error, (Object) failure.error);
        }

        public final int hashCode() {
            int i2 = this.errorCode * 31;
            String str = this.error;
            return i2 + (str != null ? str.hashCode() : 0);
        }

        public final String toString() {
            return "Failure(errorCode=" + this.errorCode + ", error=" + this.error + ")";
        }

        public Failure(int i2, String str) {
            this.errorCode = i2;
            this.error = str;
        }

        public final String getError() {
            return this.error;
        }

        public final int getErrorCode() {
            return this.errorCode;
        }
    }
}
