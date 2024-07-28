package com.sendbird.android;

import com.sendbird.android.constant.StringSet;
import com.sendbird.android.shadow.com.google.gson.JsonElement;
import com.sendbird.android.shadow.com.google.gson.JsonObject;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public final class AppInfo {
    private final long UNIT_MB = 1048576;
    private final List<String> attributesInUse = new ArrayList();
    private final String emojiHash;
    private final List<String> premiumFeatureList = new ArrayList();
    private final long uploadSizeLimit;
    private final boolean useReaction;

    AppInfo(JsonObject jsonObject) {
        this.emojiHash = jsonObject.has(StringSet.emoji_hash) ? jsonObject.get(StringSet.emoji_hash).getAsString() : "";
        this.uploadSizeLimit = jsonObject.has(StringSet.file_upload_size_limit) ? ((long) jsonObject.get(StringSet.file_upload_size_limit).getAsInt()) * 1048576 : Long.MAX_VALUE;
        this.useReaction = jsonObject.has(StringSet.use_reaction) && jsonObject.get(StringSet.use_reaction).getAsBoolean();
        if (jsonObject.has(StringSet.premium_feature_list)) {
            Iterator<JsonElement> it2 = jsonObject.getAsJsonArray(StringSet.premium_feature_list).iterator();
            while (it2.hasNext()) {
                this.premiumFeatureList.add(it2.next().getAsString());
            }
        }
        if (jsonObject.has(StringSet.application_attributes)) {
            Iterator<JsonElement> it3 = jsonObject.getAsJsonArray(StringSet.application_attributes).iterator();
            while (it3.hasNext()) {
                this.attributesInUse.add(it3.next().getAsString());
            }
        }
    }

    public final String getEmojiHash() {
        return this.emojiHash;
    }

    public final long getUploadSizeLimit() {
        return this.uploadSizeLimit;
    }

    public final boolean useReaction() {
        return this.useReaction;
    }

    public final List<String> getPremiumFeatureList() {
        return Collections.unmodifiableList(this.premiumFeatureList);
    }

    public final List<String> getAttributesInUse() {
        return Collections.unmodifiableList(this.attributesInUse);
    }

    public final boolean needUpdateEmoji(String str) {
        String str2 = this.emojiHash;
        return str2 == null || !str2.equals(str);
    }

    public final String toString() {
        return "AppInfo{emojiHash='" + this.emojiHash + '\'' + ", uploadSizeLimit=" + this.uploadSizeLimit + ", useReaction=" + this.useReaction + ", premiumFeatureList=" + this.premiumFeatureList + ", attributesInUse=" + this.attributesInUse + '}';
    }
}
