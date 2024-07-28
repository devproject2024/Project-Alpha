package com.paytm.android.chat.utils;

import androidx.recyclerview.widget.h;
import com.paytm.android.chat.bean.FriendBean;
import java.util.List;
import kotlin.g.b.g;
import kotlin.g.b.k;

public abstract class ChatHomeListEvent {

    public static final class ChatHomeNormalList extends ChatHomeListEvent {
        private final int channelSize;
        private final h.b diffResult;
        private final List<FriendBean> friendList;
        private final List<Object> list;
        private final int totalUnreadCount;

        public static /* synthetic */ ChatHomeNormalList copy$default(ChatHomeNormalList chatHomeNormalList, List<Object> list2, h.b bVar, int i2, List<FriendBean> list3, int i3, int i4, Object obj) {
            if ((i4 & 1) != 0) {
                list2 = chatHomeNormalList.list;
            }
            if ((i4 & 2) != 0) {
                bVar = chatHomeNormalList.diffResult;
            }
            h.b bVar2 = bVar;
            if ((i4 & 4) != 0) {
                i2 = chatHomeNormalList.totalUnreadCount;
            }
            int i5 = i2;
            if ((i4 & 8) != 0) {
                list3 = chatHomeNormalList.friendList;
            }
            List<FriendBean> list4 = list3;
            if ((i4 & 16) != 0) {
                i3 = chatHomeNormalList.channelSize;
            }
            return chatHomeNormalList.copy(list2, bVar2, i5, list4, i3);
        }

        public final List<Object> component1() {
            return this.list;
        }

        public final h.b component2() {
            return this.diffResult;
        }

        public final int component3() {
            return this.totalUnreadCount;
        }

        public final List<FriendBean> component4() {
            return this.friendList;
        }

        public final int component5() {
            return this.channelSize;
        }

        public final ChatHomeNormalList copy(List<Object> list2, h.b bVar, int i2, List<FriendBean> list3, int i3) {
            k.c(list2, "list");
            k.c(bVar, "diffResult");
            k.c(list3, "friendList");
            return new ChatHomeNormalList(list2, bVar, i2, list3, i3);
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof ChatHomeNormalList)) {
                return false;
            }
            ChatHomeNormalList chatHomeNormalList = (ChatHomeNormalList) obj;
            return k.a((Object) this.list, (Object) chatHomeNormalList.list) && k.a((Object) this.diffResult, (Object) chatHomeNormalList.diffResult) && this.totalUnreadCount == chatHomeNormalList.totalUnreadCount && k.a((Object) this.friendList, (Object) chatHomeNormalList.friendList) && this.channelSize == chatHomeNormalList.channelSize;
        }

        public final int hashCode() {
            List<Object> list2 = this.list;
            int i2 = 0;
            int hashCode = (list2 != null ? list2.hashCode() : 0) * 31;
            h.b bVar = this.diffResult;
            int hashCode2 = (((hashCode + (bVar != null ? bVar.hashCode() : 0)) * 31) + this.totalUnreadCount) * 31;
            List<FriendBean> list3 = this.friendList;
            if (list3 != null) {
                i2 = list3.hashCode();
            }
            return ((hashCode2 + i2) * 31) + this.channelSize;
        }

        public final String toString() {
            return "ChatHomeNormalList(list=" + this.list + ", diffResult=" + this.diffResult + ", totalUnreadCount=" + this.totalUnreadCount + ", friendList=" + this.friendList + ", channelSize=" + this.channelSize + ")";
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public ChatHomeNormalList(List<Object> list2, h.b bVar, int i2, List<FriendBean> list3, int i3) {
            super((g) null);
            k.c(list2, "list");
            k.c(bVar, "diffResult");
            k.c(list3, "friendList");
            this.list = list2;
            this.diffResult = bVar;
            this.totalUnreadCount = i2;
            this.friendList = list3;
            this.channelSize = i3;
        }

        public final int getChannelSize() {
            return this.channelSize;
        }

        public final h.b getDiffResult() {
            return this.diffResult;
        }

        public final List<FriendBean> getFriendList() {
            return this.friendList;
        }

        public final List<Object> getList() {
            return this.list;
        }

        public final int getTotalUnreadCount() {
            return this.totalUnreadCount;
        }
    }

    private ChatHomeListEvent() {
    }

    public /* synthetic */ ChatHomeListEvent(g gVar) {
        this();
    }

    public static final class ChatHomeSearchList extends ChatHomeListEvent {
        private final h.b diffResult;
        private final List<Object> list;
        private final String query;

        public static /* synthetic */ ChatHomeSearchList copy$default(ChatHomeSearchList chatHomeSearchList, List<Object> list2, h.b bVar, String str, int i2, Object obj) {
            if ((i2 & 1) != 0) {
                list2 = chatHomeSearchList.list;
            }
            if ((i2 & 2) != 0) {
                bVar = chatHomeSearchList.diffResult;
            }
            if ((i2 & 4) != 0) {
                str = chatHomeSearchList.query;
            }
            return chatHomeSearchList.copy(list2, bVar, str);
        }

        public final List<Object> component1() {
            return this.list;
        }

        public final h.b component2() {
            return this.diffResult;
        }

        public final String component3() {
            return this.query;
        }

        public final ChatHomeSearchList copy(List<Object> list2, h.b bVar, String str) {
            k.c(list2, "list");
            k.c(bVar, "diffResult");
            return new ChatHomeSearchList(list2, bVar, str);
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof ChatHomeSearchList)) {
                return false;
            }
            ChatHomeSearchList chatHomeSearchList = (ChatHomeSearchList) obj;
            return k.a((Object) this.list, (Object) chatHomeSearchList.list) && k.a((Object) this.diffResult, (Object) chatHomeSearchList.diffResult) && k.a((Object) this.query, (Object) chatHomeSearchList.query);
        }

        public final int hashCode() {
            List<Object> list2 = this.list;
            int i2 = 0;
            int hashCode = (list2 != null ? list2.hashCode() : 0) * 31;
            h.b bVar = this.diffResult;
            int hashCode2 = (hashCode + (bVar != null ? bVar.hashCode() : 0)) * 31;
            String str = this.query;
            if (str != null) {
                i2 = str.hashCode();
            }
            return hashCode2 + i2;
        }

        public final String toString() {
            return "ChatHomeSearchList(list=" + this.list + ", diffResult=" + this.diffResult + ", query=" + this.query + ")";
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public ChatHomeSearchList(List<Object> list2, h.b bVar, String str) {
            super((g) null);
            k.c(list2, "list");
            k.c(bVar, "diffResult");
            this.list = list2;
            this.diffResult = bVar;
            this.query = str;
        }

        public final h.b getDiffResult() {
            return this.diffResult;
        }

        public final List<Object> getList() {
            return this.list;
        }

        public final String getQuery() {
            return this.query;
        }
    }
}
