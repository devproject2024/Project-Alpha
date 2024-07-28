package com.paytm.android.chat.data.models.messages;

import com.paytm.android.chat.bean.CTA;
import java.io.Serializable;
import java.util.List;

public final class ChatGenericMessageDataModel extends ChatMessageDataModel {
    private GenericDataBean data;

    public final GenericDataBean getData() {
        return this.data;
    }

    public final void setData(GenericDataBean genericDataBean) {
        this.data = genericDataBean;
    }

    public static final class GenericDataBean implements Serializable {
        private List<CTA> cta;
        private String desc;
        private String imageUrl;
        private String preview_text;
        private String title;

        public final String getTitle() {
            return this.title;
        }

        public final void setTitle(String str) {
            this.title = str;
        }

        public final String getDesc() {
            return this.desc;
        }

        public final void setDesc(String str) {
            this.desc = str;
        }

        public final List<CTA> getCta() {
            return this.cta;
        }

        public final void setCta(List<CTA> list) {
            this.cta = list;
        }

        public final String getPreview_text() {
            return this.preview_text;
        }

        public final void setPreview_text(String str) {
            this.preview_text = str;
        }

        public final String getImageUrl() {
            return this.imageUrl;
        }

        public final void setImageUrl(String str) {
            this.imageUrl = str;
        }
    }
}
