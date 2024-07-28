package com.paytm.android.chat.network.response;

import com.google.gsonhtcfix.a.b;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;

public class ResponseOfFriends extends ResponseBase implements Serializable {
    public DataOfFriends data;

    public DataOfFriends getData() {
        return this.data;
    }

    public String toString() {
        return super.toString() + "->ResponseOfRegister{data=" + this.data + '}';
    }

    public static class DataOfFriends {
        public List<Friend> friends;
        public String next;
        @b(a = "preview_text")
        public HashMap<String, String> preview_text;

        public String getNext() {
            return this.next;
        }

        public HashMap<String, String> getPreview_text() {
            return this.preview_text;
        }

        public List<Friend> getFriends() {
            return this.friends;
        }
    }

    public static class Friend {
        @b(a = "new")
        public boolean is_new;
        public String name;
        @b(a = "paytm_user_id")
        public String paytm_user_id;
        public String personal_discovery_key;
        public String photo;
        @b(a = "preview_text")
        public String preview_text;
        @b(a = "s_id")
        public String s_id;

        public boolean isNew() {
            return this.is_new;
        }

        public String getPaytmUserId() {
            return this.paytm_user_id;
        }

        public String getSendbirdId() {
            return this.s_id;
        }

        public String getPreviewTextId() {
            return this.preview_text;
        }

        public String getName() {
            return this.name;
        }

        public String getPhoto() {
            return this.photo;
        }

        public String getPersonalDiscoveryKey() {
            return this.personal_discovery_key;
        }
    }
}
