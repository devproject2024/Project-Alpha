package com.sendbird.android;

import android.content.Context;
import android.text.TextUtils;
import com.google.firebase.perf.network.FirebasePerfUrlConnection;
import com.paytm.business.merchantprofile.view.RequestConfirmationDialogFragment;
import com.sendbird.android.BaseChannel;
import com.sendbird.android.BaseMessageParams;
import com.sendbird.android.FileMessage;
import com.sendbird.android.GroupChannel;
import com.sendbird.android.SendBird;
import com.sendbird.android.constant.StringSet;
import com.sendbird.android.log.Logger;
import com.sendbird.android.shadow.com.google.gson.Gson;
import com.sendbird.android.shadow.com.google.gson.JsonArray;
import com.sendbird.android.shadow.com.google.gson.JsonElement;
import com.sendbird.android.shadow.com.google.gson.JsonObject;
import com.sendbird.android.shadow.com.google.gson.JsonParser;
import com.sendbird.android.shadow.okhttp3.Call;
import com.sendbird.android.shadow.okhttp3.Headers;
import com.sendbird.android.shadow.okhttp3.MediaType;
import com.sendbird.android.shadow.okhttp3.OkHttpClient;
import com.sendbird.android.shadow.okhttp3.RequestBody;
import com.sendbird.android.shadow.okhttp3.internal.Util;
import com.sendbird.android.shadow.okio.Buffer;
import com.sendbird.android.shadow.okio.BufferedSink;
import com.sendbird.android.shadow.okio.ByteString;
import com.sendbird.android.shadow.okio.ForwardingSink;
import com.sendbird.android.shadow.okio.Okio;
import com.sendbird.android.shadow.okio.Sink;
import com.sheroes.final_sdk.appliedlife.pvtltd.SHEROES.utils.AppConstants;
import java.io.File;
import java.io.IOException;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;

final class APIClient {

    /* renamed from: a  reason: collision with root package name */
    private static final Gson f43879a = new Gson();

    /* renamed from: b  reason: collision with root package name */
    private static final MediaType f43880b = MediaType.parse("application/json; charset=utf-8");

    /* renamed from: c  reason: collision with root package name */
    private static APIClient f43881c;

    /* renamed from: d  reason: collision with root package name */
    private static final Map<String, c> f43882d = new ConcurrentHashMap();

    /* renamed from: e  reason: collision with root package name */
    private String f43883e = "";
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public OkHttpClient f43884f = new OkHttpClient();
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public OkHttpClient f43885g = new OkHttpClient.Builder().writeTimeout(60000, TimeUnit.MILLISECONDS).build();

    public interface APIClientProgressHandler {
        void onProgress(String str, long j, long j2, long j3);
    }

    /* access modifiers changed from: private */
    public OkHttpClient a(boolean z) {
        return z ? this.f43885g : this.f43884f;
    }

    static synchronized APIClient a() {
        APIClient aPIClient;
        synchronized (APIClient.class) {
            if (f43881c != null) {
                aPIClient = f43881c;
            } else {
                Logger.e("SendBird instance hasn't been initialized. Try SendBird.init().");
                throw new RuntimeException("SendBird instance hasn't been initialized.");
            }
        }
        return aPIClient;
    }

    static synchronized void a(Context context) {
        synchronized (APIClient.class) {
            if (f43881c == null) {
                f43881c = new APIClient();
                t.f45283a = context.getApplicationContext().getSharedPreferences("com.sendbird.sdk.messaging.keystore", 0);
            }
        }
    }

    static void b() {
        a().b("");
        t.a();
    }

    protected APIClient() {
    }

    /* access modifiers changed from: package-private */
    public final void c() {
        Logger.d("Evict all connections.");
        try {
            new Thread() {
                public final void run() {
                    APIClient.this.f43884f.connectionPool().evictAll();
                    APIClient.this.f43885g.connectionPool().evictAll();
                }
            }.start();
        } catch (Throwable unused) {
        }
    }

    /* access modifiers changed from: package-private */
    public final void d() {
        Logger.d("Cancel all API calls.");
        this.f43884f.dispatcher().cancelAll();
        this.f43885g.dispatcher().cancelAll();
    }

    /* access modifiers changed from: package-private */
    public final JsonElement a(String str, List<String> list) throws SendBirdException {
        String format = String.format(b.GROUPCHANNELS_CHANNELURL_INVITE.publicUrl(), new Object[]{b.urlEncodeUTF8(str)});
        JsonObject jsonObject = new JsonObject();
        JsonArray jsonArray = new JsonArray();
        for (String add : list) {
            jsonArray.add(add);
        }
        jsonObject.add("user_ids", jsonArray);
        return a(format, (JsonElement) jsonObject);
    }

    /* access modifiers changed from: package-private */
    public final JsonElement a(boolean z, long j, String str, String str2, String str3, int i2, String str4, String str5, String str6, String str7, boolean z2, BaseMessageParams.MentionType mentionType, List<String> list, BaseMessageParams.PushNotificationDeliveryOption pushNotificationDeliveryOption, List<MessageMetaArray> list2) throws SendBirdException {
        String str8;
        String str9 = str3;
        String str10 = str4;
        String str11 = str5;
        String str12 = str6;
        String str13 = str7;
        BaseMessageParams.MentionType mentionType2 = mentionType;
        BaseMessageParams.PushNotificationDeliveryOption pushNotificationDeliveryOption2 = pushNotificationDeliveryOption;
        if (SendBird.getCurrentUser() != null) {
            if (z) {
                str8 = String.format(b.OPENCHANNELS_CHANNELURL_MESSAGES.publicUrl(), new Object[]{b.urlEncodeUTF8(str)});
            } else {
                str8 = String.format(b.GROUPCHANNELS_CHANNELURL_MESSAGES.publicUrl(), new Object[]{b.urlEncodeUTF8(str)});
            }
            JsonObject jsonObject = new JsonObject();
            jsonObject.addProperty(StringSet.message_type, BaseChannel.MessageTypeFilter.FILE.value());
            if (j > 0) {
                jsonObject.addProperty(StringSet.root_message_id, (Number) Long.valueOf(j));
                jsonObject.addProperty(StringSet.parent_message_id, (Number) Long.valueOf(j));
            }
            jsonObject.addProperty("user_id", SendBird.getCurrentUser().getUserId());
            jsonObject.addProperty("url", str2);
            if (str9 != null) {
                jsonObject.addProperty("file_name", str9);
            }
            if (i2 > 0) {
                jsonObject.addProperty("file_size", (Number) Integer.valueOf(i2));
            }
            if (str10 != null) {
                jsonObject.addProperty("file_type", str10);
            }
            if (str11 != null) {
                jsonObject.addProperty(StringSet.custom_type, str11);
            }
            if (str12 != null) {
                jsonObject.addProperty("custom_field", str12);
            }
            if (str13 != null) {
                jsonObject.add("thumbnails", new JsonParser().parse(str13));
            }
            if (z2) {
                jsonObject.addProperty("require_auth", Boolean.TRUE);
            }
            if (mentionType2 == BaseMessageParams.MentionType.USERS) {
                jsonObject.addProperty(StringSet.mention_type, StringSet.users);
                if (list != null && list.size() > 0) {
                    JsonArray jsonArray = new JsonArray();
                    for (String add : list) {
                        jsonArray.add(add);
                    }
                    jsonObject.add(StringSet.mentioned_user_ids, jsonArray);
                }
            } else if (mentionType2 == BaseMessageParams.MentionType.CHANNEL) {
                jsonObject.addProperty(StringSet.mention_type, "channel");
            }
            if (list != null && list.size() > 0) {
                JsonArray jsonArray2 = new JsonArray();
                for (String add2 : list) {
                    jsonArray2.add(add2);
                }
                jsonObject.add(StringSet.mentioned_user_ids, jsonArray2);
            }
            if (pushNotificationDeliveryOption2 != null && pushNotificationDeliveryOption2 == BaseMessageParams.PushNotificationDeliveryOption.SUPPRESS) {
                jsonObject.addProperty("push_option", "suppress");
            }
            if (list2 != null && list2.size() > 0) {
                JsonObject jsonObject2 = new JsonObject();
                JsonArray jsonArray3 = new JsonArray();
                for (MessageMetaArray next : list2) {
                    String key = next.getKey();
                    List<String> value = next.getValue();
                    if (key != null) {
                        JsonArray jsonArray4 = new JsonArray();
                        for (String add3 : value) {
                            jsonArray4.add(add3);
                        }
                        jsonObject2.add(key, jsonArray4);
                        jsonArray3.add(key);
                    }
                }
                jsonObject.add("metaarray", jsonObject2);
                jsonObject.add("metaarray_key_order", jsonArray3);
            }
            return a(str8, (JsonElement) jsonObject);
        }
        throw u.b();
    }

    /* access modifiers changed from: package-private */
    public final JsonElement a(boolean z, String str, long j, long j2, int i2, int i3, boolean z2, boolean z3, String str2, String str3, Collection<String> collection, boolean z4, boolean z5, boolean z6, boolean z7, boolean z8, boolean z9) throws SendBirdException {
        String str4;
        String str5 = str2;
        String str6 = str3;
        Collection<String> collection2 = collection;
        boolean z10 = false;
        if (z) {
            str4 = String.format(b.OPENCHANNELS_CHANNELURL_MESSAGES.publicUrl(), new Object[]{b.urlEncodeUTF8(str)});
        } else {
            str4 = String.format(b.GROUPCHANNELS_CHANNELURL_MESSAGES.publicUrl(), new Object[]{b.urlEncodeUTF8(str)});
        }
        HashMap hashMap = new HashMap();
        hashMap.put(StringSet.is_sdk, "true");
        if (j > 0) {
            hashMap.put(StringSet.parent_message_id, String.valueOf(j));
        }
        hashMap.put(StringSet.message_ts, String.valueOf(j2));
        hashMap.put(StringSet.prev_limit, String.valueOf(i2));
        hashMap.put(StringSet.next_limit, String.valueOf(i3));
        hashMap.put(StringSet.reverse, String.valueOf(z3));
        if ((i2 > 0 && i3 > 0) || z2) {
            z10 = true;
        }
        hashMap.put(StringSet.include, String.valueOf(z10));
        if (str5 != null) {
            hashMap.put(StringSet.message_type, str5);
        }
        if (str6 != null) {
            hashMap.put(StringSet.custom_type, str6);
        }
        if (z4) {
            hashMap.put(StringSet.with_sorted_meta_array, "true");
        }
        if (z5) {
            hashMap.put(StringSet.include_reactions, "true");
        }
        if (z6) {
            hashMap.put(StringSet.include_thread_info, "true");
        }
        if (z7) {
            hashMap.put(StringSet.include_replies, "true");
        }
        if (z8) {
            hashMap.put(StringSet.include_parent_message_text, "true");
        }
        if (z9 && z) {
            hashMap.put(StringSet.show_subchannel_messages_only, "true");
        }
        HashMap hashMap2 = new HashMap();
        if (collection2 != null && collection.size() > 0) {
            hashMap2.put(StringSet.sender_ids, collection2);
        }
        return a(str4, (Map<String, String>) hashMap, (Map<String, Collection<String>>) hashMap2);
    }

    /* access modifiers changed from: package-private */
    public final JsonElement a(List<String> list, List<String> list2, Boolean bool, Boolean bool2, Boolean bool3, Boolean bool4, Boolean bool5, String str, String str2, String str3, String str4, String str5, String str6, Boolean bool6, Boolean bool7, Integer num) throws SendBirdException {
        Boolean bool8 = bool;
        Boolean bool9 = bool2;
        Boolean bool10 = bool3;
        Boolean bool11 = bool4;
        Boolean bool12 = bool5;
        String str7 = str;
        String str8 = str2;
        String str9 = str3;
        String str10 = str4;
        String str11 = str5;
        String str12 = str6;
        Boolean bool13 = bool6;
        Boolean bool14 = bool7;
        Integer num2 = num;
        if (SendBird.getCurrentUser() != null) {
            String publicUrl = b.GROUPCHANNELS.publicUrl();
            JsonObject jsonObject = new JsonObject();
            String str13 = publicUrl;
            JsonArray jsonArray = new JsonArray();
            LinkedHashSet<String> linkedHashSet = new LinkedHashSet<>(list);
            linkedHashSet.add(SendBird.getCurrentUser().getUserId());
            for (String add : linkedHashSet) {
                jsonArray.add(add);
            }
            jsonObject.add("user_ids", jsonArray);
            if (list2 != null) {
                JsonArray jsonArray2 = new JsonArray();
                for (String add2 : list2) {
                    jsonArray2.add(add2);
                }
                jsonObject.add(StringSet.operator_ids, jsonArray2);
            }
            if (bool8 != null) {
                jsonObject.addProperty("is_super", bool8);
            }
            if (bool9 != null) {
                jsonObject.addProperty("is_public", bool9);
            }
            if (bool10 != null) {
                jsonObject.addProperty("is_ephemeral", bool10);
            }
            if (bool11 != null) {
                jsonObject.addProperty("is_distinct", bool11);
            }
            if (bool12 != null) {
                jsonObject.addProperty("is_discoverable", bool12);
            }
            if (str7 != null) {
                jsonObject.addProperty(StringSet.channel_url, str7);
            }
            if (str8 != null) {
                jsonObject.addProperty("name", str8);
            }
            if (str9 != null) {
                jsonObject.addProperty("cover_url", str9);
            }
            if (str10 != null) {
                jsonObject.addProperty("data", str10);
            }
            if (str11 != null) {
                jsonObject.addProperty(StringSet.custom_type, str11);
            }
            if (str12 != null) {
                jsonObject.addProperty("access_code", str12);
            }
            if (bool13 != null) {
                jsonObject.addProperty("strict", bool13);
            }
            Boolean bool15 = bool7;
            if (bool15 != null) {
                jsonObject.addProperty("is_broadcast", bool15);
            }
            Integer num3 = num;
            if (num3 != null) {
                jsonObject.addProperty(StringSet.message_survival_seconds, (Number) num3);
            }
            return a(str13, (JsonElement) jsonObject);
        }
        throw u.b();
    }

    /* access modifiers changed from: package-private */
    public final JsonElement a(String str, String str2, String str3, String str4, String str5, List<String> list) throws SendBirdException {
        String publicUrl = b.OPENCHANNELS.publicUrl();
        JsonObject jsonObject = new JsonObject();
        if (str != null) {
            jsonObject.addProperty("name", str);
        }
        if (str2 != null) {
            jsonObject.addProperty(StringSet.channel_url, str2);
        }
        if (str3 != null) {
            jsonObject.addProperty("cover_url", str3);
        }
        if (str4 != null) {
            jsonObject.addProperty("data", str4);
        }
        if (str5 != null) {
            jsonObject.addProperty(StringSet.custom_type, str5);
        }
        if (list != null) {
            JsonArray jsonArray = new JsonArray();
            for (String add : list) {
                jsonArray.add(add);
            }
            jsonObject.add(StringSet.operator_ids, jsonArray);
        }
        return a(publicUrl, (JsonElement) jsonObject);
    }

    /* access modifiers changed from: package-private */
    public final JsonElement a(String str, String str2, File file, String str3, String str4, List<String> list) throws SendBirdException {
        String publicUrl = b.OPENCHANNELS.publicUrl();
        HashMap hashMap = new HashMap();
        if (str != null) {
            hashMap.put("name", str);
        }
        if (str2 != null) {
            hashMap.put(StringSet.channel_url, str2);
        }
        String str5 = file != null ? "cover_file" : null;
        if (str3 != null) {
            hashMap.put("data", str3);
        }
        if (str4 != null) {
            hashMap.put(StringSet.custom_type, str4);
        }
        if (list != null) {
            hashMap.put(StringSet.operator_ids, b.urlEncodeUTF8((Collection<String>) list));
        }
        return a(publicUrl, (Map<String, String>) hashMap, str5, file);
    }

    /* access modifiers changed from: package-private */
    public final JsonElement a(boolean z, String str, Map<String, Integer> map, boolean z2, int i2) throws SendBirdException {
        String str2;
        if (z) {
            str2 = String.format(b.OPENCHANNELS_CHANNELURL_METACOUNTER.publicUrl(), new Object[]{b.urlEncodeUTF8(str)});
        } else {
            str2 = String.format(b.GROUPCHANNELS_CHANNELURL_METACOUNTER.publicUrl(), new Object[]{b.urlEncodeUTF8(str)});
        }
        JsonObject jsonObject = new JsonObject();
        JsonObject jsonObject2 = new JsonObject();
        for (Map.Entry next : map.entrySet()) {
            jsonObject2.addProperty((String) next.getKey(), (Number) next.getValue());
        }
        jsonObject.add("metacounter", jsonObject2);
        jsonObject.addProperty("upsert", Boolean.valueOf(z2));
        if (i2 == 0) {
            jsonObject.addProperty("mode", "set");
        } else if (i2 == 1) {
            jsonObject.addProperty("mode", "increase");
        } else if (i2 == 2) {
            jsonObject.addProperty("mode", "decrease");
        }
        return b(str2, jsonObject);
    }

    /* access modifiers changed from: package-private */
    public final JsonElement a(boolean z, String str, Collection<String> collection) throws SendBirdException {
        String str2;
        if (z) {
            str2 = String.format(b.OPENCHANNELS_CHANNELURL_METACOUNTER.publicUrl(), new Object[]{b.urlEncodeUTF8(str)});
        } else {
            str2 = String.format(b.GROUPCHANNELS_CHANNELURL_METACOUNTER.publicUrl(), new Object[]{b.urlEncodeUTF8(str)});
        }
        HashMap hashMap = new HashMap();
        if (collection != null && collection.size() > 0) {
            hashMap.put("keys", collection);
        }
        return a(str2, (Map<String, String>) null, (Map<String, Collection<String>>) hashMap);
    }

    /* access modifiers changed from: package-private */
    public final JsonElement a(boolean z, String str, Map<String, String> map) throws SendBirdException {
        String str2;
        if (z) {
            str2 = String.format(b.OPENCHANNELS_CHANNELURL_METADATA.publicUrl(), new Object[]{b.urlEncodeUTF8(str)});
        } else {
            str2 = String.format(b.GROUPCHANNELS_CHANNELURL_METADATA.publicUrl(), new Object[]{b.urlEncodeUTF8(str)});
        }
        JsonObject jsonObject = new JsonObject();
        JsonObject jsonObject2 = new JsonObject();
        for (Map.Entry next : map.entrySet()) {
            jsonObject2.addProperty((String) next.getKey(), (String) next.getValue());
        }
        jsonObject.add("metadata", jsonObject2);
        return a(str2, (JsonElement) jsonObject);
    }

    /* access modifiers changed from: package-private */
    public final JsonElement b(boolean z, String str, Collection<String> collection) throws SendBirdException {
        String str2;
        if (z) {
            str2 = String.format(b.OPENCHANNELS_CHANNELURL_METADATA.publicUrl(), new Object[]{b.urlEncodeUTF8(str)});
        } else {
            str2 = String.format(b.GROUPCHANNELS_CHANNELURL_METADATA.publicUrl(), new Object[]{b.urlEncodeUTF8(str)});
        }
        HashMap hashMap = new HashMap();
        if (collection != null && collection.size() > 0) {
            hashMap.put("keys", collection);
        }
        return a(str2, (Map<String, String>) null, (Map<String, Collection<String>>) hashMap);
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x003b, code lost:
        r5 = r5.next();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.sendbird.android.shadow.com.google.gson.JsonElement a(java.lang.String r4, int r5, java.util.List<java.lang.String> r6, java.util.Map<java.lang.String, java.util.List<java.lang.String>> r7) throws com.sendbird.android.SendBirdException {
        /*
            r3 = this;
            com.sendbird.android.b r0 = com.sendbird.android.b.USERS
            java.lang.String r0 = r0.publicUrl()
            java.util.HashMap r1 = new java.util.HashMap
            r1.<init>()
            java.lang.String r2 = "token"
            r1.put(r2, r4)
            java.lang.String r4 = java.lang.String.valueOf(r5)
            java.lang.String r5 = "limit"
            r1.put(r5, r4)
            java.util.HashMap r4 = new java.util.HashMap
            r4.<init>()
            if (r6 == 0) goto L_0x002b
            int r5 = r6.size()
            if (r5 <= 0) goto L_0x002b
            java.lang.String r5 = "user_ids"
            r4.put(r5, r6)
        L_0x002b:
            if (r7 == 0) goto L_0x0059
            java.util.Set r5 = r7.keySet()
            java.util.Iterator r5 = r5.iterator()
            boolean r6 = r5.hasNext()
            if (r6 == 0) goto L_0x0059
            java.lang.Object r5 = r5.next()
            java.lang.String r5 = (java.lang.String) r5
            java.lang.Object r6 = r7.get(r5)
            java.util.List r6 = (java.util.List) r6
            if (r6 == 0) goto L_0x0059
            int r7 = r6.size()
            if (r7 <= 0) goto L_0x0059
            java.lang.String r7 = "metadatakey"
            r1.put(r7, r5)
            java.lang.String r5 = "metadatavalues_in"
            r4.put(r5, r6)
        L_0x0059:
            com.sendbird.android.shadow.com.google.gson.JsonElement r4 = r3.a((java.lang.String) r0, (java.util.Map<java.lang.String, java.lang.String>) r1, (java.util.Map<java.lang.String, java.util.Collection<java.lang.String>>) r4)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sendbird.android.APIClient.a(java.lang.String, int, java.util.List, java.util.Map):com.sendbird.android.shadow.com.google.gson.JsonElement");
    }

    static JsonObject e() {
        return new JsonObject();
    }

    /* access modifiers changed from: package-private */
    public final JsonElement a(SendBird.PushTokenType pushTokenType, String str, boolean z, boolean z2, boolean z3) throws SendBirdException {
        if (SendBird.getCurrentUser() != null) {
            String format = String.format(b.USERS_USERID_PUSH_REGISTER.url(z3), new Object[]{b.urlEncodeUTF8(SendBird.getCurrentUser().getUserId()), pushTokenType.getValue()});
            JsonObject jsonObject = new JsonObject();
            int i2 = AnonymousClass3.f43888a[pushTokenType.ordinal()];
            if (i2 == 1) {
                jsonObject.addProperty(StringSet.huawei_device_token, str);
            } else if (i2 == 2 || i2 == 3 || i2 == 4) {
                jsonObject.addProperty(StringSet.gcm_reg_token, str);
            }
            jsonObject.addProperty(StringSet.is_unique, Boolean.valueOf(z));
            jsonObject.addProperty(StringSet.always_push, Boolean.valueOf(z2));
            return a(format, (JsonElement) jsonObject);
        }
        throw u.b();
    }

    /* access modifiers changed from: package-private */
    public final JsonElement f() throws SendBirdException {
        if (SendBird.getCurrentUser() != null) {
            return a(String.format(b.USERS_USERID_PUSH.publicUrl(), new Object[]{b.urlEncodeUTF8(SendBird.getCurrentUser().getUserId())}), (Map<String, Collection<String>>) null, (JsonElement) new JsonObject());
        }
        throw u.b();
    }

    /* access modifiers changed from: package-private */
    public final JsonElement a(List<String> list) throws SendBirdException {
        if (SendBird.getCurrentUser() != null) {
            String format = String.format(b.USERS_USERID_FRIENDS.publicUrl(), new Object[]{b.urlEncodeUTF8(SendBird.getCurrentUser().getUserId())});
            JsonObject jsonObject = new JsonObject();
            JsonArray jsonArray = new JsonArray();
            for (String add : list) {
                jsonArray.add(add);
            }
            jsonObject.add("user_ids", jsonArray);
            return a(format, (JsonElement) jsonObject);
        }
        throw u.b();
    }

    /* access modifiers changed from: package-private */
    public final JsonElement a(boolean z, String str, String str2, String str3, int i2) throws SendBirdException {
        String str4;
        if (z) {
            str4 = String.format(b.OPENCHANNELS_CHANNELURL_BAN.publicUrl(), new Object[]{b.urlEncodeUTF8(str)});
        } else {
            str4 = String.format(b.GROUPCHANNELS_CHANNELURL_BAN.publicUrl(), new Object[]{b.urlEncodeUTF8(str)});
        }
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("user_id", str2);
        if (str3 != null) {
            jsonObject.addProperty(RequestConfirmationDialogFragment.KEY_DESCRIPTION, str3);
        }
        jsonObject.addProperty("seconds", String.valueOf(i2));
        return a(str4, (JsonElement) jsonObject);
    }

    /* access modifiers changed from: package-private */
    public final JsonElement a(boolean z, String str, String str2) throws SendBirdException {
        String str3;
        if (z) {
            str3 = String.format(b.OPENCHANNELS_CHANNELURL_BAN_USERID.publicUrl(), new Object[]{b.urlEncodeUTF8(str), b.urlEncodeUTF8(str2)});
        } else {
            str3 = String.format(b.GROUPCHANNELS_CHANNELURL_BAN_USERID.publicUrl(), new Object[]{b.urlEncodeUTF8(str), b.urlEncodeUTF8(str2)});
        }
        return a(str3, (Map<String, Collection<String>>) null, (JsonElement) new JsonObject());
    }

    /* access modifiers changed from: package-private */
    public final JsonElement a(boolean z, String str, String str2, String str3, Integer num) throws SendBirdException {
        String str4;
        if (z) {
            str4 = String.format(b.OPENCHANNELS_CHANNELURL_MUTE.publicUrl(), new Object[]{b.urlEncodeUTF8(str)});
        } else {
            str4 = String.format(b.GROUPCHANNELS_CHANNELURL_MUTE.publicUrl(), new Object[]{b.urlEncodeUTF8(str)});
        }
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("user_id", str2);
        if (str3 != null) {
            jsonObject.addProperty(RequestConfirmationDialogFragment.KEY_DESCRIPTION, str3);
        }
        if (num != null) {
            jsonObject.addProperty("seconds", String.valueOf(num));
        }
        return a(str4, (JsonElement) jsonObject);
    }

    /* access modifiers changed from: package-private */
    public final JsonElement b(boolean z, String str, String str2) throws SendBirdException {
        String str3;
        if (z) {
            str3 = String.format(b.OPENCHANNELS_CHANNELURL_MUTE_USERID.publicUrl(), new Object[]{b.urlEncodeUTF8(str), b.urlEncodeUTF8(str2)});
        } else {
            str3 = String.format(b.GROUPCHANNELS_CHANNELURL_MUTE_USERID.publicUrl(), new Object[]{b.urlEncodeUTF8(str), b.urlEncodeUTF8(str2)});
        }
        return a(str3, (Map<String, Collection<String>>) null, (JsonElement) new JsonObject());
    }

    /* access modifiers changed from: package-private */
    public final JsonElement a(String str, boolean z) throws SendBirdException {
        String format = String.format(b.GROUPCHANNELS_CHANNELURL_FREEZE.publicUrl(), new Object[]{b.urlEncodeUTF8(str)});
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("freeze", Boolean.valueOf(z));
        return b(format, jsonObject);
    }

    /* access modifiers changed from: package-private */
    public final JsonElement a(Collection<GroupChannel.UnreadItemKey> collection) throws SendBirdException {
        if (SendBird.getCurrentUser() != null) {
            String format = String.format(b.USERS_USERID_UNREADITEMCOUNT.publicUrl(), new Object[]{b.urlEncodeUTF8(SendBird.getCurrentUser().getUserId())});
            HashMap hashMap = new HashMap();
            LinkedHashSet linkedHashSet = new LinkedHashSet();
            for (GroupChannel.UnreadItemKey next : collection) {
                if (next == GroupChannel.UnreadItemKey.GROUP_CHANNEL_UNREAD_MESSAGE_COUNT) {
                    linkedHashSet.add("group_channel_unread_message_count");
                } else if (next == GroupChannel.UnreadItemKey.GROUP_CHANNEL_UNREAD_MENTION_COUNT) {
                    linkedHashSet.add("group_channel_unread_mention_count");
                } else if (next == GroupChannel.UnreadItemKey.GROUP_CHANNEL_INVITATION_COUNT) {
                    linkedHashSet.add("group_channel_invitation_count");
                } else if (next == GroupChannel.UnreadItemKey.NONSUPER_UNREAD_MESSAGE_COUNT) {
                    linkedHashSet.add("non_super_group_channel_unread_message_count");
                } else if (next == GroupChannel.UnreadItemKey.SUPER_UNREAD_MESSAGE_COUNT) {
                    linkedHashSet.add("super_group_channel_unread_message_count");
                } else if (next == GroupChannel.UnreadItemKey.NONSUPER_UNREAD_MENTION_COUNT) {
                    linkedHashSet.add("non_super_group_channel_unread_mention_count");
                } else if (next == GroupChannel.UnreadItemKey.SUPER_UNREAD_MENTION_COUNT) {
                    linkedHashSet.add("super_group_channel_unread_mention_count");
                } else if (next == GroupChannel.UnreadItemKey.NONSUPER_INVITATION_COUNT) {
                    linkedHashSet.add("non_super_group_channel_invitation_count");
                } else if (next == GroupChannel.UnreadItemKey.SUPER_INVITATION_COUNT) {
                    linkedHashSet.add("super_group_channel_invitation_count");
                }
            }
            if (linkedHashSet.size() > 0) {
                hashMap.put("item_keys", linkedHashSet);
            }
            return a(format, (Map<String, String>) null, (Map<String, Collection<String>>) hashMap);
        }
        throw u.b();
    }

    /* access modifiers changed from: package-private */
    public final JsonElement g() throws SendBirdException {
        if (SendBird.getCurrentUser() != null) {
            return a(String.format(b.USERS_USERID_UNREADCHANNELCOUNT.publicUrl(), new Object[]{b.urlEncodeUTF8(SendBird.getCurrentUser().getUserId())}), (Map<String, String>) null, (Map<String, Collection<String>>) null);
        }
        throw u.b();
    }

    /* access modifiers changed from: package-private */
    public final JsonElement a(MessageRetrievalParams messageRetrievalParams) throws SendBirdException {
        String str;
        HashMap hashMap = new HashMap();
        if (messageRetrievalParams.channelType == BaseChannel.ChannelType.OPEN) {
            str = String.format(b.OPENCHANNELS_CHANNELURL_MESSAGES_MESSAGEID.publicUrl(), new Object[]{b.urlEncodeUTF8(messageRetrievalParams.channelUrl), Long.valueOf(messageRetrievalParams.messageId)});
        } else {
            str = String.format(b.GROUPCHANNELS_CHANNELURL_MESSAGES_MESSAGEID.publicUrl(), new Object[]{b.urlEncodeUTF8(messageRetrievalParams.channelUrl), Long.valueOf(messageRetrievalParams.messageId)});
        }
        if (messageRetrievalParams.includeMetaArray) {
            hashMap.put(StringSet.with_sorted_meta_array, "true");
        }
        if (messageRetrievalParams.includeThreadInfo) {
            hashMap.put(StringSet.include_thread_info, "true");
        }
        if (messageRetrievalParams.includeParentMessageText) {
            hashMap.put(StringSet.include_parent_message_text, "true");
        }
        return a(str, (Map<String, String>) hashMap, (Map<String, Collection<String>>) null);
    }

    /* access modifiers changed from: package-private */
    public final JsonElement a(boolean z, String str) throws SendBirdException {
        String str2;
        if (z) {
            str2 = String.format(b.OPENCHANNELS_CHANNELURL.publicUrl(), new Object[]{b.urlEncodeUTF8(str)});
        } else {
            str2 = String.format(b.GROUPCHANNELS_CHANNELURL.publicUrl(), new Object[]{b.urlEncodeUTF8(str)});
        }
        return a(str2, (Map<String, Collection<String>>) null, (JsonElement) new JsonObject());
    }

    /* renamed from: com.sendbird.android.APIClient$3  reason: invalid class name */
    static /* synthetic */ class AnonymousClass3 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f43888a = new int[SendBird.PushTokenType.values().length];

        /* renamed from: b  reason: collision with root package name */
        static final /* synthetic */ int[] f43889b = new int[BaseChannel.ReportCategory.values().length];

        /* JADX WARNING: Can't wrap try/catch for region: R(20:0|1|2|3|(2:5|6)|7|(2:9|10)|11|13|14|15|17|18|19|20|21|22|23|24|26) */
        /* JADX WARNING: Can't wrap try/catch for region: R(21:0|1|2|3|5|6|7|(2:9|10)|11|13|14|15|17|18|19|20|21|22|23|24|26) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x0048 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:21:0x0052 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:23:0x005c */
        static {
            /*
                com.sendbird.android.BaseChannel$ReportCategory[] r0 = com.sendbird.android.BaseChannel.ReportCategory.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f43889b = r0
                r0 = 1
                int[] r1 = f43889b     // Catch:{ NoSuchFieldError -> 0x0014 }
                com.sendbird.android.BaseChannel$ReportCategory r2 = com.sendbird.android.BaseChannel.ReportCategory.SUSPICIOUS     // Catch:{ NoSuchFieldError -> 0x0014 }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0014 }
                r1[r2] = r0     // Catch:{ NoSuchFieldError -> 0x0014 }
            L_0x0014:
                r1 = 2
                int[] r2 = f43889b     // Catch:{ NoSuchFieldError -> 0x001f }
                com.sendbird.android.BaseChannel$ReportCategory r3 = com.sendbird.android.BaseChannel.ReportCategory.HARASSING     // Catch:{ NoSuchFieldError -> 0x001f }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x001f }
                r2[r3] = r1     // Catch:{ NoSuchFieldError -> 0x001f }
            L_0x001f:
                r2 = 3
                int[] r3 = f43889b     // Catch:{ NoSuchFieldError -> 0x002a }
                com.sendbird.android.BaseChannel$ReportCategory r4 = com.sendbird.android.BaseChannel.ReportCategory.SPAM     // Catch:{ NoSuchFieldError -> 0x002a }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x002a }
                r3[r4] = r2     // Catch:{ NoSuchFieldError -> 0x002a }
            L_0x002a:
                r3 = 4
                int[] r4 = f43889b     // Catch:{ NoSuchFieldError -> 0x0035 }
                com.sendbird.android.BaseChannel$ReportCategory r5 = com.sendbird.android.BaseChannel.ReportCategory.INAPPROPRIATE     // Catch:{ NoSuchFieldError -> 0x0035 }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x0035 }
                r4[r5] = r3     // Catch:{ NoSuchFieldError -> 0x0035 }
            L_0x0035:
                com.sendbird.android.SendBird$PushTokenType[] r4 = com.sendbird.android.SendBird.PushTokenType.values()
                int r4 = r4.length
                int[] r4 = new int[r4]
                f43888a = r4
                int[] r4 = f43888a     // Catch:{ NoSuchFieldError -> 0x0048 }
                com.sendbird.android.SendBird$PushTokenType r5 = com.sendbird.android.SendBird.PushTokenType.HMS     // Catch:{ NoSuchFieldError -> 0x0048 }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x0048 }
                r4[r5] = r0     // Catch:{ NoSuchFieldError -> 0x0048 }
            L_0x0048:
                int[] r0 = f43888a     // Catch:{ NoSuchFieldError -> 0x0052 }
                com.sendbird.android.SendBird$PushTokenType r4 = com.sendbird.android.SendBird.PushTokenType.GCM     // Catch:{ NoSuchFieldError -> 0x0052 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0052 }
                r0[r4] = r1     // Catch:{ NoSuchFieldError -> 0x0052 }
            L_0x0052:
                int[] r0 = f43888a     // Catch:{ NoSuchFieldError -> 0x005c }
                com.sendbird.android.SendBird$PushTokenType r1 = com.sendbird.android.SendBird.PushTokenType.APNS     // Catch:{ NoSuchFieldError -> 0x005c }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x005c }
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x005c }
            L_0x005c:
                int[] r0 = f43888a     // Catch:{ NoSuchFieldError -> 0x0066 }
                com.sendbird.android.SendBird$PushTokenType r1 = com.sendbird.android.SendBird.PushTokenType.APNS_VOIP     // Catch:{ NoSuchFieldError -> 0x0066 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0066 }
                r0[r1] = r3     // Catch:{ NoSuchFieldError -> 0x0066 }
            L_0x0066:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.sendbird.android.APIClient.AnonymousClass3.<clinit>():void");
        }
    }

    /* access modifiers changed from: package-private */
    public final JsonElement a(BaseChannel baseChannel, boolean z, Collection<String> collection, boolean z2) throws SendBirdException {
        String str;
        if (SendBird.getCurrentUser() != null) {
            if (baseChannel.isOpenChannel()) {
                str = String.format(b.OPENCHANNELS_CHANNELURL_OPERATORS.publicUrl(), new Object[]{baseChannel.getUrl()});
            } else {
                str = String.format(b.GROUPCHANNELS_CHANNELURL_OPERATORS.publicUrl(), new Object[]{baseChannel.getUrl()});
            }
            JsonObject jsonObject = new JsonObject();
            if (z2) {
                jsonObject.addProperty(StringSet.delete_all, Boolean.TRUE);
            } else if (collection != null && !collection.isEmpty()) {
                JsonArray jsonArray = new JsonArray(collection.size());
                for (String add : collection) {
                    jsonArray.add(add);
                }
                jsonObject.add(StringSet.operator_ids, jsonArray);
            }
            if (z) {
                return a(str, (JsonElement) jsonObject);
            }
            return a(str, (Map<String, Collection<String>>) null, (JsonElement) jsonObject);
        }
        throw u.b();
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x005a, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void b(java.lang.String r4) {
        /*
            r3 = this;
            monitor-enter(r3)
            if (r4 != 0) goto L_0x0005
            monitor-exit(r3)
            return
        L_0x0005:
            java.lang.String r0 = r3.f43883e     // Catch:{ all -> 0x005b }
            if (r0 == 0) goto L_0x0011
            java.lang.String r0 = r3.f43883e     // Catch:{ all -> 0x005b }
            boolean r0 = r0.equals(r4)     // Catch:{ all -> 0x005b }
            if (r0 != 0) goto L_0x0059
        L_0x0011:
            r3.f43883e = r4     // Catch:{ all -> 0x005b }
            com.sendbird.android.User r0 = com.sendbird.android.SendBird.getCurrentUser()     // Catch:{ all -> 0x005b }
            if (r0 == 0) goto L_0x0056
            java.lang.String r0 = r0.getUserId()     // Catch:{ all -> 0x005b }
            boolean r1 = android.text.TextUtils.isEmpty(r0)     // Catch:{ all -> 0x005b }
            if (r1 != 0) goto L_0x0054
            byte[] r0 = r0.getBytes()     // Catch:{ Exception -> 0x0050 }
            r1 = 2
            java.lang.String r0 = android.util.Base64.encodeToString(r0, r1)     // Catch:{ Exception -> 0x0050 }
            android.content.SharedPreferences r1 = com.sendbird.android.t.f45283a     // Catch:{ Exception -> 0x0050 }
            android.content.SharedPreferences$Editor r1 = r1.edit()     // Catch:{ Exception -> 0x0050 }
            java.lang.String r2 = "PREFERENCE_KEY_SEED"
            android.content.SharedPreferences$Editor r1 = r1.putString(r2, r0)     // Catch:{ Exception -> 0x0050 }
            r1.apply()     // Catch:{ Exception -> 0x0050 }
            java.lang.String r4 = com.sendbird.android.a.a(r0, r4)     // Catch:{ Exception -> 0x0050 }
            android.content.SharedPreferences r0 = com.sendbird.android.t.f45283a     // Catch:{ Exception -> 0x0050 }
            android.content.SharedPreferences$Editor r0 = r0.edit()     // Catch:{ Exception -> 0x0050 }
            java.lang.String r1 = "PREFERENCE_KEY_SESSION_KEY"
            android.content.SharedPreferences$Editor r4 = r0.putString(r1, r4)     // Catch:{ Exception -> 0x0050 }
            r4.apply()     // Catch:{ Exception -> 0x0050 }
            monitor-exit(r3)
            return
        L_0x0050:
            r4 = move-exception
            com.sendbird.android.log.Logger.e((java.lang.Throwable) r4)     // Catch:{ all -> 0x005b }
        L_0x0054:
            monitor-exit(r3)
            return
        L_0x0056:
            com.sendbird.android.t.a()     // Catch:{ all -> 0x005b }
        L_0x0059:
            monitor-exit(r3)
            return
        L_0x005b:
            r4 = move-exception
            monitor-exit(r3)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sendbird.android.APIClient.b(java.lang.String):void");
    }

    /* access modifiers changed from: package-private */
    public final synchronized String h() {
        if (TextUtils.isEmpty(this.f43883e)) {
            this.f43883e = t.b();
        }
        return this.f43883e;
    }

    /* access modifiers changed from: package-private */
    public final JsonElement a(String str, Map<String, String> map, Map<String, Collection<String>> map2) throws SendBirdException {
        return new c(a(false)).a(b(str, map, map2));
    }

    /* access modifiers changed from: package-private */
    public final JsonElement a(String str, JsonElement jsonElement) throws SendBirdException {
        String json = f43879a.toJson(jsonElement);
        Logger.d("API request: ".concat(String.valueOf(json)));
        return new c(a(false)).a(str, RequestBody.create(f43880b, json));
    }

    /* access modifiers changed from: package-private */
    public final JsonElement a(String str, Map<String, String> map, String str2, File file) throws SendBirdException {
        boolean z;
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        Iterator<Map.Entry<String, String>> it2 = map.entrySet().iterator();
        while (true) {
            z = true;
            if (!it2.hasNext()) {
                break;
            }
            Map.Entry next = it2.next();
            arrayList.add(Headers.of("Content-Disposition", String.format("form-data; name=\"%s\"", new Object[]{next.getKey()})));
            arrayList2.add(RequestBody.create((MediaType) null, (String) next.getValue()));
        }
        if (!(str2 == null || file == null)) {
            String a2 = a(file, (String) null);
            MediaType parse = MediaType.parse(a2);
            Logger.d("File: ".concat(String.valueOf(file)));
            Logger.d("Mime: ".concat(String.valueOf(a2)));
            arrayList.add(Headers.of("Content-Disposition", String.format("form-data; name=\"%s\"; filename=\"%s\"", new Object[]{str2, b.urlEncodeUTF8(file.getName())}), "Content-Transfer-Encoding", "binary"));
            arrayList2.add(RequestBody.create(parse, file));
        }
        a aVar = new a(arrayList, arrayList2, (APIClientProgressHandler) null, (String) null);
        if (str2 == null || file == null) {
            z = false;
        }
        return new c(a(z)).a(str, aVar);
    }

    /* access modifiers changed from: package-private */
    public final JsonElement a(String str, File file, String str2, List<FileMessage.ThumbnailSize> list, String str3, String str4, APIClientProgressHandler aPIClientProgressHandler) throws SendBirdException {
        String str5 = str3;
        String str6 = str4;
        char c2 = 0;
        Logger.i(">> uploadFILE()", new Object[0]);
        try {
            try {
                c cVar = new c(a(true));
                f43882d.put(str6, cVar);
                String a2 = a(file, str2);
                MediaType parse = MediaType.parse(a2);
                MediaType parse2 = MediaType.parse("text/plain");
                Logger.d("File: ".concat(String.valueOf(file)));
                Logger.d("Mime: ".concat(String.valueOf(a2)));
                ArrayList arrayList = new ArrayList();
                ArrayList arrayList2 = new ArrayList();
                int i2 = 2;
                arrayList.add(Headers.of("Content-Disposition", "form-data; name=\"file\"; filename=\"" + b.urlEncodeUTF8(file.getName()) + "\"", "Content-Transfer-Encoding", "binary"));
                arrayList2.add(RequestBody.create(parse, file));
                if (list != null) {
                    int i3 = 1;
                    for (FileMessage.ThumbnailSize next : list) {
                        String[] strArr = new String[i2];
                        strArr[c2] = "Content-Disposition";
                        strArr[1] = "form-data; name=\"thumbnail" + i3 + "\"";
                        arrayList.add(Headers.of(strArr));
                        arrayList2.add(RequestBody.create(parse2, next.getMaxWidth() + AppConstants.COMMA + next.getMaxHeight()));
                        i3++;
                        c2 = 0;
                        i2 = 2;
                    }
                }
                if (str5 != null) {
                    arrayList.add(Headers.of("Content-Disposition", "form-data; name=\"channel_url\""));
                    arrayList2.add(RequestBody.create(parse2, str5));
                }
                a aVar = new a(arrayList, arrayList2, aPIClientProgressHandler, str6);
                Logger.i("++ requestId : %s", str6);
                JsonElement a3 = cVar.a(str, aVar);
                f43882d.remove(str6);
                return a3;
            } catch (Throwable th) {
                th = th;
                f43882d.remove(str6);
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
            f43882d.remove(str6);
            throw th;
        }
    }

    static String a(File file, String str) throws SendBirdException {
        if (str != null) {
            try {
                if (str.length() > 0) {
                    return str;
                }
            } catch (IOException e2) {
                throw new SendBirdException(e2.getMessage(), SendBirdError.ERR_REQUEST_FAILED);
            } catch (StringIndexOutOfBoundsException unused) {
                return "application/octet-stream";
            }
        }
        return ((URLConnection) FirebasePerfUrlConnection.instrument(file.toURI().toURL().openConnection())).getContentType();
    }

    /* access modifiers changed from: package-private */
    public final JsonElement b(String str, JsonElement jsonElement) throws SendBirdException {
        return new c(a(false)).b(str, RequestBody.create(f43880b, f43879a.toJson(jsonElement)));
    }

    /* access modifiers changed from: package-private */
    public final JsonElement b(String str, Map<String, String> map, String str2, File file) throws SendBirdException {
        boolean z;
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        Iterator<Map.Entry<String, String>> it2 = map.entrySet().iterator();
        while (true) {
            z = true;
            if (!it2.hasNext()) {
                break;
            }
            Map.Entry next = it2.next();
            arrayList.add(Headers.of("Content-Disposition", String.format("form-data; name=\"%s\"", new Object[]{next.getKey()})));
            arrayList2.add(RequestBody.create((MediaType) null, (String) next.getValue()));
        }
        if (!(str2 == null || file == null)) {
            String a2 = a(file, (String) null);
            MediaType parse = MediaType.parse(a2);
            Logger.d("File: ".concat(String.valueOf(file)));
            Logger.d("Mime: ".concat(String.valueOf(a2)));
            arrayList.add(Headers.of("Content-Disposition", String.format("form-data; name=\"%s\"; filename=\"%s\"", new Object[]{str2, b.urlEncodeUTF8(file.getName())}), "Content-Transfer-Encoding", "binary"));
            arrayList2.add(RequestBody.create(parse, file));
        }
        a aVar = new a(arrayList, arrayList2, (APIClientProgressHandler) null, (String) null);
        if (str2 == null || file == null) {
            z = false;
        }
        return new c(a(z)).b(str, aVar);
    }

    /* access modifiers changed from: package-private */
    public final JsonElement a(String str, Map<String, Collection<String>> map, JsonElement jsonElement) throws SendBirdException {
        String b2 = b(str, (Map<String, String>) null, map);
        String json = f43879a.toJson(jsonElement);
        Logger.d("API request: ".concat(String.valueOf(json)));
        return new c(a(false)).c(b2, RequestBody.create(f43880b, json));
    }

    private static String b(String str, Map<String, String> map, Map<String, Collection<String>> map2) {
        HashMap hashMap = new HashMap();
        if (map != null && map.size() > 0) {
            for (Map.Entry next : map.entrySet()) {
                hashMap.put(b.urlEncodeUTF8((String) next.getKey()), b.urlEncodeUTF8((String) next.getValue()));
            }
        }
        if (map2 != null && map2.size() > 0) {
            for (Map.Entry next2 : map2.entrySet()) {
                hashMap.put(b.urlEncodeUTF8((String) next2.getKey()), b.urlEncodeUTF8((Collection<String>) (Collection) next2.getValue()));
            }
        }
        if (hashMap.size() <= 0) {
            return str;
        }
        String a2 = a((Map<String, String>) hashMap);
        return str + "?" + a2;
    }

    private static String a(Map<String, String> map) {
        StringBuilder sb = new StringBuilder();
        if (map.size() > 0) {
            for (Map.Entry next : map.entrySet()) {
                if (sb.length() > 0) {
                    sb.append(AppConstants.AND_SIGN);
                }
                sb.append(String.format("%s=%s", new Object[]{next.getKey(), next.getValue()}));
            }
        }
        return sb.toString();
    }

    static final class a extends RequestBody {

        /* renamed from: a  reason: collision with root package name */
        private static final MediaType f43890a = MediaType.parse("multipart/form-data");

        /* renamed from: b  reason: collision with root package name */
        private static final byte[] f43891b = {58, 32};

        /* renamed from: c  reason: collision with root package name */
        private static final byte[] f43892c = {13, 10};

        /* renamed from: d  reason: collision with root package name */
        private static final byte[] f43893d = {45, 45};

        /* renamed from: e  reason: collision with root package name */
        private final ByteString f43894e = ByteString.encodeUtf8(UUID.randomUUID().toString());

        /* renamed from: f  reason: collision with root package name */
        private final MediaType f43895f = MediaType.parse(f43890a + "; boundary=" + this.f43894e.utf8());

        /* renamed from: g  reason: collision with root package name */
        private final List<Headers> f43896g;

        /* renamed from: h  reason: collision with root package name */
        private final List<RequestBody> f43897h;
        /* access modifiers changed from: private */

        /* renamed from: i  reason: collision with root package name */
        public long f43898i;
        /* access modifiers changed from: private */
        public long j;
        /* access modifiers changed from: private */
        public final APIClientProgressHandler k;
        /* access modifiers changed from: private */
        public final String l;

        a(List<Headers> list, List<RequestBody> list2, APIClientProgressHandler aPIClientProgressHandler, String str) {
            this.f43896g = Util.immutableList(list);
            this.f43897h = Util.immutableList(list2);
            this.f43898i = 0;
            this.j = 0;
            this.k = aPIClientProgressHandler;
            this.l = str;
        }

        public final MediaType contentType() {
            return this.f43895f;
        }

        public final long contentLength() throws IOException {
            int size = this.f43896g.size();
            int i2 = 0;
            for (int i3 = 0; i3 < size; i3++) {
                Headers headers = this.f43896g.get(i3);
                RequestBody requestBody = this.f43897h.get(i3);
                long contentLength = requestBody.contentLength();
                if (contentLength == -1) {
                    return -1;
                }
                int length = i2 + f43893d.length + this.f43894e.size() + f43892c.length;
                if (headers != null) {
                    int size2 = headers.size();
                    int i4 = length;
                    for (int i5 = 0; i5 < size2; i5++) {
                        i4 += headers.name(i5).getBytes(AppConstants.UTF_8).length + f43891b.length + headers.value(i5).getBytes(AppConstants.UTF_8).length + f43892c.length;
                    }
                    length = i4;
                }
                MediaType contentType = requestBody.contentType();
                if (contentType != null) {
                    length += "Content-Type: ".getBytes(AppConstants.UTF_8).length + contentType.toString().getBytes(AppConstants.UTF_8).length + f43892c.length;
                }
                int length2 = "Content-Length: ".getBytes(AppConstants.UTF_8).length + Long.toString(contentLength).getBytes(AppConstants.UTF_8).length;
                byte[] bArr = f43892c;
                i2 = (int) (((long) (length + length2 + bArr.length)) + ((long) bArr.length) + contentLength + ((long) bArr.length));
            }
            long length3 = (long) (i2 + f43893d.length + this.f43894e.size() + f43893d.length + f43892c.length);
            this.j = length3;
            return length3;
        }

        public final void writeTo(BufferedSink bufferedSink) throws IOException {
            BufferedSink buffer = Okio.buffer((Sink) new ForwardingSink(bufferedSink) {
                public final void write(Buffer buffer, long j) throws IOException {
                    super.write(buffer, j);
                    a aVar = a.this;
                    long unused = aVar.f43898i = aVar.f43898i + j;
                    if (a.this.k != null) {
                        a.this.k.onProgress(a.this.l, j, a.this.f43898i, a.this.j);
                    }
                }
            });
            int size = this.f43896g.size();
            for (int i2 = 0; i2 < size; i2++) {
                Headers headers = this.f43896g.get(i2);
                RequestBody requestBody = this.f43897h.get(i2);
                buffer.write(f43893d);
                buffer.write(this.f43894e);
                buffer.write(f43892c);
                if (headers != null) {
                    int size2 = headers.size();
                    for (int i3 = 0; i3 < size2; i3++) {
                        buffer.writeUtf8(headers.name(i3)).write(f43891b).writeUtf8(headers.value(i3)).write(f43892c);
                    }
                }
                MediaType contentType = requestBody.contentType();
                if (contentType != null) {
                    buffer.writeUtf8("Content-Type: ").writeUtf8(contentType.toString()).write(f43892c);
                }
                long contentLength = requestBody.contentLength();
                if (contentLength != -1) {
                    buffer.writeUtf8("Content-Length: ").writeUtf8(Long.toString(contentLength)).write(f43892c);
                }
                buffer.write(f43892c);
                requestBody.writeTo(buffer);
                buffer.write(f43892c);
            }
            buffer.write(f43893d);
            buffer.write(this.f43894e);
            buffer.write(f43893d);
            buffer.write(f43892c);
            buffer.flush();
        }
    }

    static boolean a(String str) {
        try {
            Thread.sleep(100);
        } catch (InterruptedException unused) {
        }
        c remove = f43882d.remove(str);
        Logger.i("++ request : %s, requestId : %s", remove, str);
        if (remove == null) {
            return false;
        }
        Call andSet = remove.f44700b.getAndSet((Object) null);
        Object[] objArr = new Object[2];
        objArr[0] = andSet;
        objArr[1] = andSet != null ? Boolean.valueOf(andSet.isCanceled()) : "call is null";
        Logger.i("++ call : %s, isCanceled : %s", objArr);
        remove.f44699a.set(true);
        if (andSet != null && !andSet.isCanceled()) {
            Logger.i("++ The requested Call is requested to cancel.", new Object[0]);
            andSet.cancel();
        }
        return true;
    }
}
