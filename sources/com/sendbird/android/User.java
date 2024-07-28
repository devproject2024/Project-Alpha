package com.sendbird.android;

import android.util.Base64;
import com.alipay.mobile.nebula.resourcehandler.H5ResourceHandlerUtil;
import com.sendbird.android.constant.StringSet;
import com.sendbird.android.shadow.com.google.gson.JsonArray;
import com.sendbird.android.shadow.com.google.gson.JsonElement;
import com.sendbird.android.shadow.com.google.gson.JsonObject;
import com.sendbird.android.shadow.com.google.gson.JsonParser;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants;
import java.io.UnsupportedEncodingException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class User {
    private ConnectionStatus mConnectionStatus;
    private String mFriendDiscoveryKey;
    private String mFriendName;
    private boolean mIsActive = true;
    private long mLastSeenAt;
    /* access modifiers changed from: private */
    public Map<String, String> mMetaData;
    private String mNickname;
    private List<String> mPreferredLanguages;
    private String mProfileUrl;
    private boolean mRequireAuth = false;
    /* access modifiers changed from: private */
    public String mUserId;

    public enum ConnectionStatus {
        NON_AVAILABLE,
        ONLINE,
        OFFLINE
    }

    public interface DeleteMetaDataHandler {
        void onResult(SendBirdException sendBirdException);
    }

    public interface MetaDataHandler {
        void onResult(Map<String, String> map, SendBirdException sendBirdException);
    }

    protected User(JsonElement jsonElement) {
        boolean z = true;
        if (!jsonElement.isJsonNull()) {
            JsonObject asJsonObject = jsonElement.getAsJsonObject();
            if (asJsonObject.has(StringSet.guest_id)) {
                this.mUserId = asJsonObject.get(StringSet.guest_id).getAsString();
            }
            if (asJsonObject.has("user_id")) {
                this.mUserId = asJsonObject.get("user_id").getAsString();
            }
            if (asJsonObject.has("name")) {
                this.mNickname = asJsonObject.get("name").getAsString();
            }
            if (asJsonObject.has("nickname")) {
                this.mNickname = asJsonObject.get("nickname").getAsString();
            }
            if (asJsonObject.has(H5ResourceHandlerUtil.IMAGE)) {
                this.mProfileUrl = asJsonObject.get(H5ResourceHandlerUtil.IMAGE).getAsString();
            }
            if (asJsonObject.has("profile_url")) {
                this.mProfileUrl = asJsonObject.get("profile_url").getAsString();
            }
            if (asJsonObject.has("friend_discovery_key") && !asJsonObject.get("friend_discovery_key").isJsonNull()) {
                this.mFriendDiscoveryKey = asJsonObject.get("friend_discovery_key").getAsString();
            }
            if (asJsonObject.has("friend_name") && !asJsonObject.get("friend_name").isJsonNull()) {
                this.mFriendName = asJsonObject.get("friend_name").getAsString();
            }
            this.mMetaData = new ConcurrentHashMap();
            if (asJsonObject.has("metadata")) {
                for (Map.Entry next : asJsonObject.get("metadata").getAsJsonObject().entrySet()) {
                    if (((JsonElement) next.getValue()).isJsonPrimitive()) {
                        this.mMetaData.put(next.getKey(), ((JsonElement) next.getValue()).getAsString());
                    }
                }
            }
            this.mConnectionStatus = asJsonObject.has("is_online") ? asJsonObject.get("is_online").getAsBoolean() ? ConnectionStatus.ONLINE : ConnectionStatus.OFFLINE : ConnectionStatus.NON_AVAILABLE;
            this.mLastSeenAt = asJsonObject.has("last_seen_at") ? asJsonObject.get("last_seen_at").getAsLong() : 0;
            this.mIsActive = !asJsonObject.has("is_active") || asJsonObject.get("is_active").getAsBoolean();
            parsePreferredLanguages(asJsonObject);
            this.mRequireAuth = (!asJsonObject.has(StringSet.require_auth_for_profile_image) || !asJsonObject.get(StringSet.require_auth_for_profile_image).getAsBoolean()) ? false : z;
        }
    }

    /* access modifiers changed from: package-private */
    public JsonElement toJson() {
        JsonObject jsonObject = new JsonObject();
        String str = this.mUserId;
        if (str != null) {
            jsonObject.addProperty("user_id", str);
        }
        String str2 = this.mNickname;
        if (str2 != null) {
            jsonObject.addProperty("nickname", str2);
        }
        String str3 = this.mProfileUrl;
        if (str3 != null) {
            jsonObject.addProperty("profile_url", str3);
        }
        String str4 = this.mFriendDiscoveryKey;
        if (str4 != null) {
            jsonObject.addProperty("friend_discovery_key", str4);
        }
        String str5 = this.mFriendName;
        if (str5 != null) {
            jsonObject.addProperty("friend_name", str5);
        }
        Map<String, String> map = this.mMetaData;
        if (map != null && map.size() > 0) {
            JsonObject jsonObject2 = new JsonObject();
            for (Map.Entry next : this.mMetaData.entrySet()) {
                jsonObject2.addProperty((String) next.getKey(), (String) next.getValue());
            }
            jsonObject.add("metadata", jsonObject2);
        }
        if (this.mConnectionStatus == ConnectionStatus.ONLINE) {
            jsonObject.addProperty("is_online", Boolean.TRUE);
        } else if (this.mConnectionStatus == ConnectionStatus.OFFLINE) {
            jsonObject.addProperty("is_online", Boolean.FALSE);
        }
        jsonObject.addProperty("last_seen_at", (Number) Long.valueOf(this.mLastSeenAt));
        jsonObject.addProperty("is_active", Boolean.valueOf(this.mIsActive));
        if (this.mPreferredLanguages != null) {
            JsonArray jsonArray = new JsonArray();
            for (String add : this.mPreferredLanguages) {
                jsonArray.add(add);
            }
            jsonObject.add("preferred_languages", jsonArray);
        }
        jsonObject.addProperty(StringSet.require_auth_for_profile_image, Boolean.valueOf(this.mRequireAuth));
        return jsonObject;
    }

    public static User buildFromSerializedData(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        byte[] bArr2 = new byte[bArr.length];
        for (int i2 = 0; i2 < bArr.length; i2++) {
            bArr2[i2] = (byte) (bArr[i2] ^ (i2 & 255));
        }
        try {
            return new User(new JsonParser().parse(new String(Base64.decode(bArr2, 0), AppConstants.UTF_8)));
        } catch (UnsupportedEncodingException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public byte[] serialize() {
        JsonObject asJsonObject = toJson().getAsJsonObject();
        asJsonObject.addProperty("version", SendBird.getSDKVersion());
        try {
            byte[] encode = Base64.encode(asJsonObject.toString().getBytes(AppConstants.UTF_8), 0);
            for (int i2 = 0; i2 < encode.length; i2++) {
                encode[i2] = (byte) (encode[i2] ^ (i2 & 255));
            }
            return encode;
        } catch (UnsupportedEncodingException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public String getUserId() {
        return this.mUserId;
    }

    public String getNickname() {
        return this.mNickname;
    }

    public String getProfileUrl() {
        if (!this.mRequireAuth) {
            return this.mProfileUrl;
        }
        return String.format("%s?auth=%s", new Object[]{this.mProfileUrl, SendBird.getEkey()});
    }

    public String getPlainProfileImageUrl() {
        return this.mProfileUrl;
    }

    public String getOriginalProfileUrl() {
        try {
            if (this.mProfileUrl == null) {
                return "";
            }
            URL url = new URL(this.mProfileUrl);
            String protocol = url.getProtocol();
            String host = url.getHost();
            String path = url.getPath();
            if (!protocol.toLowerCase().equals("https") && !protocol.toLowerCase().equals("http")) {
                return "";
            }
            if ((host.contains("sendbird.com") || host.contains("intoz.com")) && path.contains("/profile_images/")) {
                return this.mProfileUrl.replace("/profile_images/", "/");
            }
            return "";
        } catch (Exception e2) {
            e2.printStackTrace();
            return "";
        }
    }

    public String getFriendDiscoveryKey() {
        return this.mFriendDiscoveryKey;
    }

    public String getFriendName() {
        return this.mFriendName;
    }

    public ConnectionStatus getConnectionStatus() {
        return this.mConnectionStatus;
    }

    public long getLastSeenAt() {
        return this.mLastSeenAt;
    }

    public boolean isActive() {
        return this.mIsActive;
    }

    /* access modifiers changed from: package-private */
    public void setUserId(String str) {
        this.mUserId = str;
    }

    /* access modifiers changed from: package-private */
    public void setNickname(String str) {
        this.mNickname = str;
    }

    /* access modifiers changed from: package-private */
    public void setProfileUrl(String str) {
        this.mProfileUrl = str;
    }

    /* access modifiers changed from: package-private */
    public void setFriendDiscoveryKey(String str) {
        this.mFriendDiscoveryKey = str;
    }

    /* access modifiers changed from: package-private */
    public void setFriendName(String str) {
        this.mFriendName = str;
    }

    /* access modifiers changed from: package-private */
    public void setPreferredLanguages(List<String> list) {
        this.mPreferredLanguages = list;
    }

    /* access modifiers changed from: package-private */
    public void parsePreferredLanguages(JsonObject jsonObject) {
        ArrayList arrayList;
        if (jsonObject.has("preferred_languages")) {
            JsonArray asJsonArray = jsonObject.getAsJsonArray("preferred_languages");
            arrayList = new ArrayList();
            if (asJsonArray.size() > 0) {
                for (int i2 = 0; i2 < asJsonArray.size(); i2++) {
                    arrayList.add(asJsonArray.get(i2).getAsString());
                }
            }
        } else {
            arrayList = null;
        }
        setPreferredLanguages(arrayList);
    }

    /* access modifiers changed from: package-private */
    public void updatePropertiesByUser(User user) {
        if (!getNickname().equals(user.getNickname())) {
            setNickname(user.getNickname());
        }
        if (!getPlainProfileImageUrl().equals(user.getPlainProfileImageUrl())) {
            setProfileUrl(user.getPlainProfileImageUrl());
        }
        if (!getMetaData().equals(user.getMetaData())) {
            getMetaData().putAll(user.getMetaData());
        }
    }

    public void createMetaData(final Map<String, String> map, final MetaDataHandler metaDataHandler) {
        d.a(new q<Map<String, String>>() {
            public final /* synthetic */ void a(Object obj, SendBirdException sendBirdException) {
                Map map = (Map) obj;
                MetaDataHandler metaDataHandler = metaDataHandler;
                if (metaDataHandler != null) {
                    metaDataHandler.onResult(map, sendBirdException);
                }
            }

            public final /* synthetic */ Object call() throws Exception {
                if (map != null) {
                    APIClient a2 = APIClient.a();
                    String access$000 = User.this.mUserId;
                    Map map = map;
                    String format = String.format(b.USERS_USERID_METADATA.publicUrl(), new Object[]{b.urlEncodeUTF8(access$000)});
                    JsonObject e2 = APIClient.e();
                    JsonObject jsonObject = new JsonObject();
                    for (Map.Entry entry : map.entrySet()) {
                        jsonObject.addProperty((String) entry.getKey(), (String) entry.getValue());
                    }
                    e2.add("metadata", jsonObject);
                    JsonElement a3 = a2.a(format, (JsonElement) e2);
                    HashMap hashMap = new HashMap();
                    for (Map.Entry next : a3.getAsJsonObject().entrySet()) {
                        if (((JsonElement) next.getValue()).isJsonPrimitive()) {
                            hashMap.put(next.getKey(), ((JsonElement) next.getValue()).getAsString());
                            User.this.mMetaData.put(next.getKey(), ((JsonElement) next.getValue()).getAsString());
                        }
                    }
                    return hashMap;
                }
                throw new SendBirdException("Invalid arguments.", SendBirdError.ERR_INVALID_PARAMETER);
            }
        });
    }

    public void updateMetaData(final Map<String, String> map, final MetaDataHandler metaDataHandler) {
        d.a(new q<Map<String, String>>() {
            public final /* synthetic */ void a(Object obj, SendBirdException sendBirdException) {
                Map map = (Map) obj;
                MetaDataHandler metaDataHandler = metaDataHandler;
                if (metaDataHandler != null) {
                    metaDataHandler.onResult(map, sendBirdException);
                }
            }

            public final /* synthetic */ Object call() throws Exception {
                if (map != null) {
                    APIClient a2 = APIClient.a();
                    String access$000 = User.this.mUserId;
                    Map map = map;
                    String format = String.format(b.USERS_USERID_METADATA.publicUrl(), new Object[]{b.urlEncodeUTF8(access$000)});
                    JsonObject e2 = APIClient.e();
                    JsonObject jsonObject = new JsonObject();
                    for (Map.Entry entry : map.entrySet()) {
                        jsonObject.addProperty((String) entry.getKey(), (String) entry.getValue());
                    }
                    e2.add("metadata", jsonObject);
                    e2.addProperty("upsert", Boolean.TRUE);
                    JsonElement b2 = a2.b(format, e2);
                    HashMap hashMap = new HashMap();
                    for (Map.Entry next : b2.getAsJsonObject().entrySet()) {
                        if (((JsonElement) next.getValue()).isJsonPrimitive()) {
                            hashMap.put(next.getKey(), ((JsonElement) next.getValue()).getAsString());
                            User.this.mMetaData.put(next.getKey(), ((JsonElement) next.getValue()).getAsString());
                        }
                    }
                    return hashMap;
                }
                throw new SendBirdException("Invalid arguments.", SendBirdError.ERR_INVALID_PARAMETER);
            }
        });
    }

    public String getMetaData(String str) {
        return this.mMetaData.get(str);
    }

    public Map<String, String> getMetaData() {
        return this.mMetaData;
    }

    public List<String> getPreferredLanguages() {
        return this.mPreferredLanguages;
    }

    /* access modifiers changed from: package-private */
    public void setRequireAuth(boolean z) {
        this.mRequireAuth = z;
    }

    public void deleteMetaData(final String str, final DeleteMetaDataHandler deleteMetaDataHandler) {
        d.a(new q<JsonElement>() {
            public final /* synthetic */ void a(Object obj, SendBirdException sendBirdException) {
                DeleteMetaDataHandler deleteMetaDataHandler = deleteMetaDataHandler;
                if (deleteMetaDataHandler != null) {
                    deleteMetaDataHandler.onResult(sendBirdException);
                }
            }

            public final /* synthetic */ Object call() throws Exception {
                if (str != null) {
                    APIClient a2 = APIClient.a();
                    String access$000 = User.this.mUserId;
                    String str = str;
                    JsonElement a3 = a2.a(String.format(b.USERS_USERID_METADATA_KEY.publicUrl(), new Object[]{b.urlEncodeUTF8(access$000), b.urlEncodeUTF8(str)}), (Map<String, Collection<String>>) null, (JsonElement) APIClient.e());
                    User.this.mMetaData.remove(str);
                    return a3;
                }
                throw new SendBirdException("Invalid arguments.", SendBirdError.ERR_INVALID_PARAMETER);
            }
        });
    }

    public void deleteAllMetaData(final DeleteMetaDataHandler deleteMetaDataHandler) {
        d.a(new q<JsonElement>() {
            public final /* synthetic */ void a(Object obj, SendBirdException sendBirdException) {
                DeleteMetaDataHandler deleteMetaDataHandler = deleteMetaDataHandler;
                if (deleteMetaDataHandler != null) {
                    deleteMetaDataHandler.onResult(sendBirdException);
                }
            }

            public final /* synthetic */ Object call() throws Exception {
                APIClient a2 = APIClient.a();
                String access$000 = User.this.mUserId;
                JsonElement a3 = a2.a(String.format(b.USERS_USERID_METADATA.publicUrl(), new Object[]{b.urlEncodeUTF8(access$000)}), (Map<String, Collection<String>>) null, (JsonElement) APIClient.e());
                User.this.mMetaData.clear();
                return a3;
            }
        });
    }

    public boolean equals(Object obj) {
        if (obj == null || obj.getClass() != getClass()) {
            return false;
        }
        return getUserId().equals(((User) obj).getUserId());
    }

    public int hashCode() {
        return p.a(getUserId());
    }

    public String toString() {
        return "User{mUserId='" + this.mUserId + '\'' + ", mNickname='" + this.mNickname + '\'' + ", mProfileUrl='" + this.mProfileUrl + '\'' + ", mFriendDiscoveryKey='" + this.mFriendDiscoveryKey + '\'' + ", mFriendName='" + this.mFriendName + '\'' + ", mMetaData=" + this.mMetaData + ", mConnectionStatus=" + this.mConnectionStatus + ", mLastSeenAt=" + this.mLastSeenAt + ", mIsActive=" + this.mIsActive + ", mPreferredLanguages=" + this.mPreferredLanguages + '}';
    }
}
