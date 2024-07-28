package com.paytm.android.chat.data.models.channels;

import com.sendbird.android.BaseChannel;
import com.sendbird.android.shadow.com.google.gson.Gson;
import com.sendbird.android.shadow.com.google.gson.JsonElement;
import kotlin.g.b.g;
import kotlin.g.b.k;

public final class OurBaseChannel extends BaseChannel {
    public static final Companion Companion = new Companion((g) null);

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(g gVar) {
            this();
        }

        public final OurBaseChannel createFromString(String str) {
            k.c(str, "jsonString");
            JsonElement jsonElement = (JsonElement) new Gson().fromJson(str, JsonElement.class);
            k.a((Object) jsonElement, "jsonObject");
            return new OurBaseChannel(jsonElement, (g) null);
        }
    }

    private OurBaseChannel(JsonElement jsonElement) {
        super(jsonElement);
    }

    public /* synthetic */ OurBaseChannel(JsonElement jsonElement, g gVar) {
        this(jsonElement);
    }
}
