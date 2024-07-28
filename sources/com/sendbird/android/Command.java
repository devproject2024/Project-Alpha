package com.sendbird.android;

import com.business.merchant_payments.utility.StringUtility;
import com.sendbird.android.BaseChannel;
import com.sendbird.android.BaseMessageParams;
import com.sendbird.android.constant.StringSet;
import com.sendbird.android.shadow.com.google.gson.Gson;
import com.sendbird.android.shadow.com.google.gson.JsonArray;
import com.sendbird.android.shadow.com.google.gson.JsonElement;
import com.sendbird.android.shadow.com.google.gson.JsonObject;
import com.sendbird.android.shadow.com.google.gson.JsonParser;
import java.util.List;
import net.one97.paytm.dynamic.module.fastag.helper.ImagePickerUtils;

final class Command {

    /* renamed from: d  reason: collision with root package name */
    private static long f44213d = System.currentTimeMillis();

    /* renamed from: e  reason: collision with root package name */
    private static final Gson f44214e = new Gson();

    /* renamed from: a  reason: collision with root package name */
    m f44215a;

    /* renamed from: b  reason: collision with root package name */
    String f44216b;

    /* renamed from: c  reason: collision with root package name */
    String f44217c;

    public interface SendCommandHandler {
        void onResult(Command command, SendBirdException sendBirdException);
    }

    protected static synchronized String a() {
        String valueOf;
        synchronized (Command.class) {
            long j = f44213d + 1;
            f44213d = j;
            valueOf = String.valueOf(j);
        }
        return valueOf;
    }

    public Command(String str) {
        JsonElement c2;
        if (str == null || str.length() <= 4) {
            this.f44215a = m.NOOP;
            this.f44216b = "{}";
            return;
        }
        String trim = str.trim();
        this.f44215a = m.from(trim.substring(0, 4));
        this.f44216b = trim.substring(4);
        if (h() && (c2 = c()) != null && c2.isJsonObject()) {
            JsonObject asJsonObject = c2.getAsJsonObject();
            this.f44217c = asJsonObject.has("req_id") ? asJsonObject.get("req_id").getAsString() : "";
        }
    }

    private Command(String str, JsonElement jsonElement) {
        this(str, jsonElement, (String) null);
    }

    private Command(String str, JsonElement jsonElement, String str2) {
        this.f44215a = m.from(str);
        this.f44217c = str2;
        if (this.f44217c == null && h()) {
            this.f44217c = a();
        }
        jsonElement.getAsJsonObject().addProperty("req_id", this.f44217c);
        this.f44216b = f44214e.toJson(jsonElement);
    }

    public final String b() {
        return this.f44215a + this.f44216b + StringUtility.NEW_LINE;
    }

    public final JsonElement c() {
        return new JsonParser().parse(this.f44216b);
    }

    static Command a(String str, long j, String str2, String str3, String str4, BaseMessageParams.MentionType mentionType, List<String> list, List<MessageMetaArray> list2, Boolean bool) {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty(StringSet.channel_url, str);
        jsonObject.addProperty(StringSet.msg_id, (Number) Long.valueOf(j));
        if (str2 != null) {
            jsonObject.addProperty("message", str2);
        }
        if (str3 != null) {
            jsonObject.addProperty("data", str3);
        }
        if (str4 != null) {
            jsonObject.addProperty(StringSet.custom_type, str4);
        }
        if (mentionType == BaseMessageParams.MentionType.USERS) {
            jsonObject.addProperty(StringSet.mention_type, StringSet.users);
            if (list != null && list.size() > 0) {
                JsonArray jsonArray = new JsonArray();
                for (String add : list) {
                    jsonArray.add(add);
                }
                jsonObject.add(StringSet.mentioned_user_ids, jsonArray);
            }
        } else if (mentionType == BaseMessageParams.MentionType.CHANNEL) {
            jsonObject.addProperty(StringSet.mention_type, "channel");
        }
        if (list2 != null && list2.size() > 0) {
            JsonObject jsonObject2 = new JsonObject();
            JsonArray jsonArray2 = new JsonArray();
            for (MessageMetaArray json : list2) {
                jsonArray2.add((JsonElement) json.toJson());
            }
            jsonObject2.add("array", jsonArray2);
            if (bool.booleanValue()) {
                jsonObject2.addProperty("mode", "add");
            } else {
                jsonObject2.addProperty("mode", "remove");
            }
            jsonObject2.addProperty("upsert", Boolean.TRUE);
            jsonObject.add("metaarray", jsonObject2);
        }
        return new Command("MEDI", jsonObject);
    }

    public static Command a(String str, long j) {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty(StringSet.channel_url, str);
        jsonObject.addProperty("time", (Number) Long.valueOf(j));
        return new Command("TPST", jsonObject);
    }

    public static Command b(String str, long j) {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty(StringSet.channel_url, str);
        jsonObject.addProperty("time", (Number) Long.valueOf(j));
        return new Command("TPEN", jsonObject);
    }

    public static Command a(String str) {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty(StringSet.channel_url, str);
        return new Command("READ", jsonObject);
    }

    public static Command c(String str, long j) {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty(StringSet.channel_url, str);
        jsonObject.addProperty(StringSet.msg_id, (Number) Long.valueOf(j));
        return new Command("MACK", jsonObject);
    }

    public static Command a(String str, long j, String str2, String str3, String str4, String str5, int i2, String str6, String str7, String str8, boolean z, BaseMessageParams.MentionType mentionType, List<String> list, BaseMessageParams.PushNotificationDeliveryOption pushNotificationDeliveryOption, List<MessageMetaArray> list2) {
        String str9 = str8;
        BaseMessageParams.MentionType mentionType2 = mentionType;
        BaseMessageParams.PushNotificationDeliveryOption pushNotificationDeliveryOption2 = pushNotificationDeliveryOption;
        JsonObject jsonObject = new JsonObject();
        String str10 = str2;
        jsonObject.addProperty(StringSet.channel_url, str2);
        if (j > 0) {
            jsonObject.addProperty(StringSet.root_message_id, (Number) Long.valueOf(j));
            jsonObject.addProperty(StringSet.parent_message_id, (Number) Long.valueOf(j));
        }
        String str11 = str3;
        jsonObject.addProperty("url", str3);
        String str12 = str4;
        jsonObject.addProperty("name", str4);
        String str13 = str5;
        jsonObject.addProperty("type", str5);
        jsonObject.addProperty(ImagePickerUtils.IMAGE_PICKER_KEY_SIZE, (Number) Integer.valueOf(i2));
        String str14 = str6;
        jsonObject.addProperty("custom", str6);
        jsonObject.addProperty(StringSet.custom_type, str7);
        if (str9 != null) {
            jsonObject.add("thumbnails", new JsonParser().parse(str9));
        }
        if (z) {
            jsonObject.addProperty("require_auth", Boolean.valueOf(z));
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
        if (pushNotificationDeliveryOption2 != null && pushNotificationDeliveryOption2 == BaseMessageParams.PushNotificationDeliveryOption.SUPPRESS) {
            jsonObject.addProperty("push_option", "suppress");
        }
        if (list2 != null && list2.size() > 0) {
            JsonArray jsonArray2 = new JsonArray();
            for (MessageMetaArray json : list2) {
                jsonArray2.add((JsonElement) json.toJson());
            }
            jsonObject.add("metaarray", jsonArray2);
        }
        String str15 = str;
        return new Command(BaseChannel.MessageTypeFilter.FILE.value(), jsonObject, str);
    }

    public static Command a(String str, long j, String str2, String str3, BaseMessageParams.MentionType mentionType, List<String> list, List<MessageMetaArray> list2, Boolean bool) {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty(StringSet.channel_url, str);
        jsonObject.addProperty(StringSet.msg_id, (Number) Long.valueOf(j));
        if (str2 != null) {
            jsonObject.addProperty("data", str2);
        }
        if (str3 != null) {
            jsonObject.addProperty(StringSet.custom_type, str3);
        }
        if (mentionType == BaseMessageParams.MentionType.USERS) {
            jsonObject.addProperty(StringSet.mention_type, StringSet.users);
            if (list != null && list.size() > 0) {
                JsonArray jsonArray = new JsonArray();
                for (String add : list) {
                    jsonArray.add(add);
                }
                jsonObject.add(StringSet.mentioned_user_ids, jsonArray);
            }
        } else if (mentionType == BaseMessageParams.MentionType.CHANNEL) {
            jsonObject.addProperty(StringSet.mention_type, "channel");
        }
        if (list2 != null && list2.size() > 0) {
            JsonObject jsonObject2 = new JsonObject();
            JsonArray jsonArray2 = new JsonArray();
            for (MessageMetaArray json : list2) {
                jsonArray2.add((JsonElement) json.toJson());
            }
            jsonObject2.add("array", jsonArray2);
            if (bool.booleanValue()) {
                jsonObject2.addProperty("mode", "add");
            } else {
                jsonObject2.addProperty("mode", "remove");
            }
            jsonObject2.addProperty("upsert", Boolean.TRUE);
            jsonObject.add("metaarray", jsonObject2);
        }
        return new Command("FEDI", jsonObject);
    }

    public static Command d() {
        if (SendBird.getInstance() == null) {
            return null;
        }
        JsonObject jsonObject = new JsonObject();
        if (SendBird.getInstance() != null) {
            jsonObject.addProperty("active", (Number) Integer.valueOf(SendBird.getInstance().isActive()));
        }
        return new Command("PING", jsonObject);
    }

    public static Command b(String str) {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty(StringSet.channel_url, str);
        return new Command("ENTR", jsonObject);
    }

    public static Command c(String str) {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty(StringSet.channel_url, str);
        return new Command("EXIT", jsonObject);
    }

    public static Command e() {
        return new Command("UNRD", new JsonObject());
    }

    public final boolean equals(Object obj) {
        if (obj != null && obj.getClass() == getClass()) {
            Command command = (Command) obj;
            if (!this.f44215a.equals(command.f44215a) || !this.f44217c.equals(command.f44217c)) {
                return false;
            }
            return true;
        }
        return false;
    }

    public final String toString() {
        return "Command{command='" + this.f44215a + '\'' + ", payload='" + this.f44216b + '\'' + ", requestId='" + this.f44217c + '\'' + '}';
    }

    /* access modifiers changed from: protected */
    public final boolean f() {
        String str = this.f44217c;
        return str != null && str.length() > 0;
    }

    /* access modifiers changed from: package-private */
    public final String g() {
        if (c() == null || !c().isJsonObject()) {
            return null;
        }
        JsonObject asJsonObject = c().getAsJsonObject();
        switch (this.f44215a) {
            case MESG:
            case FILE:
            case BRDM:
            case ADMM:
            case MEDI:
            case FEDI:
            case AEDI:
            case MRCT:
            case READ:
            case DLVR:
            case SYEV:
            case DELM:
            case MTHD:
                return asJsonObject.has(StringSet.channel_url) ? asJsonObject.get(StringSet.channel_url).getAsString() : "";
            default:
                return null;
        }
    }

    private boolean h() {
        return this.f44215a.isAckRequired() || this.f44215a == m.EROR;
    }

    static Command a(String str, long j, String str2, String str3, String str4, String str5, BaseMessageParams.MentionType mentionType, List<String> list, BaseMessageParams.PushNotificationDeliveryOption pushNotificationDeliveryOption, List<MessageMetaArray> list2, List<String> list3) {
        JsonObject jsonObject = new JsonObject();
        if (j > 0) {
            jsonObject.addProperty(StringSet.root_message_id, (Number) Long.valueOf(j));
            jsonObject.addProperty(StringSet.parent_message_id, (Number) Long.valueOf(j));
        }
        jsonObject.addProperty(StringSet.channel_url, str2);
        jsonObject.addProperty("message", str3);
        jsonObject.addProperty("data", str4);
        jsonObject.addProperty(StringSet.custom_type, str5);
        if (mentionType == BaseMessageParams.MentionType.USERS) {
            jsonObject.addProperty(StringSet.mention_type, StringSet.users);
            if (list != null && list.size() > 0) {
                JsonArray jsonArray = new JsonArray();
                for (String add : list) {
                    jsonArray.add(add);
                }
                jsonObject.add(StringSet.mentioned_user_ids, jsonArray);
            }
        } else if (mentionType == BaseMessageParams.MentionType.CHANNEL) {
            jsonObject.addProperty(StringSet.mention_type, "channel");
        }
        if (pushNotificationDeliveryOption != null && pushNotificationDeliveryOption == BaseMessageParams.PushNotificationDeliveryOption.SUPPRESS) {
            jsonObject.addProperty("push_option", "suppress");
        }
        if (list2 != null && list2.size() > 0) {
            JsonArray jsonArray2 = new JsonArray();
            for (MessageMetaArray json : list2) {
                jsonArray2.add((JsonElement) json.toJson());
            }
            jsonObject.add("metaarray", jsonArray2);
        }
        if (list3 != null && list3.size() > 0) {
            JsonArray jsonArray3 = new JsonArray();
            for (String add2 : list3) {
                jsonArray3.add(add2);
            }
            jsonObject.add("target_langs", jsonArray3);
        }
        return new Command(BaseChannel.MessageTypeFilter.USER.value(), jsonObject, str);
    }

    public final int hashCode() {
        return p.a(this.f44215a, this.f44217c);
    }
}
