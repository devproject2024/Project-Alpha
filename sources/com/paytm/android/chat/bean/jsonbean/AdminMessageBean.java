package com.paytm.android.chat.bean.jsonbean;

import com.google.gsonhtcfix.a.b;
import com.google.gsonhtcfix.c.a;
import com.google.gsonhtcfix.f;
import com.paytm.android.chat.bean.CtaType;
import com.paytm.android.chat.data.models.messages.ChatMessageDataModel;
import java.util.ArrayList;

public class AdminMessageBean extends ChatMessageDataModel {
    private ArrayList<AdminMetaData> metaData;

    public ArrayList<AdminMetaData> getMetaData() {
        return this.metaData;
    }

    public ArrayList<AdminMetaData> parseMetaData(String str) {
        try {
            this.metaData = (ArrayList) new f().a(str, new a<ArrayList<AdminMetaData>>() {
            }.getType());
        } catch (Exception unused) {
        }
        if (this.metaData == null) {
            this.metaData = new ArrayList<>();
        }
        return this.metaData;
    }

    public static class AdminMetaData {
        @b(a = "d")
        private Data data;
        @b(a = "preview_text")
        private String previewText;
        @b(a = "uiInfo")
        private UIInfo uiInfo;
        @b(a = "u_id")
        private String userId;

        public String getUserId() {
            return this.userId;
        }

        public String getPreviewText() {
            return this.previewText;
        }

        public Data getData() {
            return this.data;
        }

        public UIInfo getUiInfo() {
            return this.uiInfo;
        }
    }

    public static class Data {
        @b(a = "cta_d")
        private CTADetail ctaDetail;
        @b(a = "msg")
        private String message;

        public String getMessage() {
            return this.message;
        }

        public CTADetail getCtaDetail() {
            return this.ctaDetail;
        }
    }

    public static class CTADetail {
        @b(a = "btnText")
        private String btnText;
        @b(a = "deeplink")
        private String deeplink;
        @b(a = "d")
        private String description;
        @b(a = "imageUrl")
        private String imageUrl;
        @b(a = "t")
        private String title;
        @b(a = "type")
        private String type;

        public String getTitle() {
            return this.title;
        }

        public String getDescription() {
            return this.description;
        }

        public String getImageUrl() {
            return this.imageUrl;
        }

        public String getBtnText() {
            return this.btnText;
        }

        public String getDeeplink() {
            return this.deeplink;
        }

        public CtaType getType() {
            return CtaType.Companion.fromString(this.type);
        }
    }

    public static class UIInfo {
        @b(a = "left")
        private String left;
        @b(a = "right")
        private String right;

        public String getLeft() {
            return this.left;
        }

        public String getRight() {
            return this.right;
        }
    }
}
