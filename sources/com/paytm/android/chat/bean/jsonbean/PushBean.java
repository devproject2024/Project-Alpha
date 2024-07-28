package com.paytm.android.chat.bean.jsonbean;

import java.util.List;

public class PushBean {
    private String app_id;
    private String audience_type;
    private String category;
    private ChannelBean channel;
    private String channel_type;
    private long created_at;
    private String custom_type;
    private String data;
    private List<?> files;
    private List<?> mentioned_users;
    private String message;
    private long message_id;
    private String push_alert;
    private String push_sound;
    private RecipientBean recipient;
    private SenderBean sender;
    private TranslationsBean translations;
    private String type;
    private int unread_message_count;

    public static class TranslationsBean {
    }

    public String getData() {
        return this.data;
    }

    public void setData(String str) {
        this.data = str;
    }

    public String getCustom_type() {
        return this.custom_type;
    }

    public void setCustom_type(String str) {
        this.custom_type = str;
    }

    public ChannelBean getChannel() {
        return this.channel;
    }

    public void setChannel(ChannelBean channelBean) {
        this.channel = channelBean;
    }

    public long getCreated_at() {
        return this.created_at;
    }

    public void setCreated_at(long j) {
        this.created_at = j;
    }

    public long getMessage_id() {
        return this.message_id;
    }

    public void setMessage_id(long j) {
        this.message_id = j;
    }

    public String getPush_alert() {
        return this.push_alert;
    }

    public void setPush_alert(String str) {
        this.push_alert = str;
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String str) {
        this.message = str;
    }

    public String getType() {
        return this.type;
    }

    public void setType(String str) {
        this.type = str;
    }

    public int getUnread_message_count() {
        return this.unread_message_count;
    }

    public void setUnread_message_count(int i2) {
        this.unread_message_count = i2;
    }

    public String getAudience_type() {
        return this.audience_type;
    }

    public void setAudience_type(String str) {
        this.audience_type = str;
    }

    public SenderBean getSender() {
        return this.sender;
    }

    public void setSender(SenderBean senderBean) {
        this.sender = senderBean;
    }

    public String getPush_sound() {
        return this.push_sound;
    }

    public void setPush_sound(String str) {
        this.push_sound = str;
    }

    public TranslationsBean getTranslations() {
        return this.translations;
    }

    public void setTranslations(TranslationsBean translationsBean) {
        this.translations = translationsBean;
    }

    public RecipientBean getRecipient() {
        return this.recipient;
    }

    public void setRecipient(RecipientBean recipientBean) {
        this.recipient = recipientBean;
    }

    public String getCategory() {
        return this.category;
    }

    public void setCategory(String str) {
        this.category = str;
    }

    public String getChannel_type() {
        return this.channel_type;
    }

    public void setChannel_type(String str) {
        this.channel_type = str;
    }

    public String getApp_id() {
        return this.app_id;
    }

    public void setApp_id(String str) {
        this.app_id = str;
    }

    public List<?> getFiles() {
        return this.files;
    }

    public void setFiles(List<?> list) {
        this.files = list;
    }

    public List<?> getMentioned_users() {
        return this.mentioned_users;
    }

    public void setMentioned_users(List<?> list) {
        this.mentioned_users = list;
    }

    public static class ChannelBean {
        private String channel_url;
        private String custom_type;
        private String data;
        private String name;

        public String getData() {
            return this.data;
        }

        public void setData(String str) {
            this.data = str;
        }

        public String getCustom_type() {
            return this.custom_type;
        }

        public void setCustom_type(String str) {
            this.custom_type = str;
        }

        public String getName() {
            return this.name;
        }

        public void setName(String str) {
            this.name = str;
        }

        public String getChannel_url() {
            return this.channel_url;
        }

        public void setChannel_url(String str) {
            this.channel_url = str;
        }
    }

    public static class SenderBean {
        private String id;
        private String name;
        private String profile_url;

        public String getProfile_url() {
            return this.profile_url;
        }

        public void setProfile_url(String str) {
            this.profile_url = str;
        }

        public String getName() {
            return this.name;
        }

        public void setName(String str) {
            this.name = str;
        }

        public String getId() {
            return this.id;
        }

        public void setId(String str) {
            this.id = str;
        }
    }

    public static class RecipientBean {
        private String id;
        private String name;
        private String push_template;

        public String getName() {
            return this.name;
        }

        public void setName(String str) {
            this.name = str;
        }

        public String getPush_template() {
            return this.push_template;
        }

        public void setPush_template(String str) {
            this.push_template = str;
        }

        public String getId() {
            return this.id;
        }

        public void setId(String str) {
            this.id = str;
        }
    }
}
