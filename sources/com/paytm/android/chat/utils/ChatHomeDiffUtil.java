package com.paytm.android.chat.utils;

import androidx.recyclerview.widget.h;
import com.paytm.android.chat.bean.ChatChannelHeader;
import com.paytm.android.chat.bean.ChatContactHeader;
import com.paytm.android.chat.bean.ChatFriendsHeader;
import com.paytm.android.chat.bean.ChatHomeChip;
import com.paytm.android.chat.bean.FriendBean;
import com.paytm.android.chat.bean.SelectContactsBean;
import com.paytm.android.chat.bean.SendContactBean;
import com.paytm.android.chat.data.models.channels.ChatGroupChannelDataModel;
import com.paytm.utility.q;
import java.util.List;
import kotlin.g.b.k;

public final class ChatHomeDiffUtil extends h.a {
    private final List<Object> newList;
    private final List<Object> oldList;

    public ChatHomeDiffUtil(List<? extends Object> list, List<? extends Object> list2) {
        k.c(list, "oldList");
        k.c(list2, "newList");
        this.oldList = list;
        this.newList = list2;
    }

    public final boolean areItemsTheSame(int i2, int i3) {
        Object obj = this.oldList.get(i2);
        Object obj2 = this.newList.get(i3);
        if ((obj instanceof ChatHomeChip) && (obj2 instanceof ChatHomeChip)) {
            return ((ChatHomeChip) obj).getList().size() == ((ChatHomeChip) obj2).getList().size();
        }
        if ((obj instanceof ChatGroupChannelDataModel) && (obj2 instanceof ChatGroupChannelDataModel)) {
            return k.a((Object) ((ChatGroupChannelDataModel) obj).getChannelUrl(), (Object) ((ChatGroupChannelDataModel) obj2).getChannelUrl());
        }
        if ((obj instanceof FriendBean) && (obj2 instanceof FriendBean)) {
            return k.a((Object) ((FriendBean) obj).getSendbirdId(), (Object) ((FriendBean) obj2).getSendbirdId());
        }
        if (!(obj instanceof SelectContactsBean) || !(obj2 instanceof SelectContactsBean)) {
            return (!(obj instanceof ChatChannelHeader) || !(obj2 instanceof ChatChannelHeader)) ? (!(obj instanceof ChatFriendsHeader) || !(obj2 instanceof ChatFriendsHeader)) ? (obj instanceof ChatContactHeader) && (obj2 instanceof ChatContactHeader) && ((ChatContactHeader) obj).getId() == ((ChatContactHeader) obj2).getId() : ((ChatFriendsHeader) obj).getId() == ((ChatFriendsHeader) obj2).getId() : ((ChatChannelHeader) obj).getId() == ((ChatChannelHeader) obj2).getId();
        }
        SendContactBean sendContactBean = ((SelectContactsBean) obj).getSendContactBean();
        k.a((Object) sendContactBean, "oldItem.sendContactBean");
        String contactPhone = sendContactBean.getContactPhone();
        SendContactBean sendContactBean2 = ((SelectContactsBean) obj2).getSendContactBean();
        k.a((Object) sendContactBean2, "newItem.sendContactBean");
        return k.a((Object) contactPhone, (Object) sendContactBean2.getContactPhone());
    }

    /* JADX WARNING: Code restructure failed: missing block: B:115:0x027c, code lost:
        if (r0.messageState != r3.messageState) goto L_0x023c;
     */
    /* JADX WARNING: Removed duplicated region for block: B:122:0x028e  */
    /* JADX WARNING: Removed duplicated region for block: B:167:0x0373 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:176:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean areContentsTheSame(int r10, int r11) {
        /*
            r9 = this;
            java.util.List<java.lang.Object> r0 = r9.oldList
            java.lang.Object r10 = r0.get(r10)
            java.util.List<java.lang.Object> r0 = r9.newList
            java.lang.Object r11 = r0.get(r11)
            boolean r0 = r10 instanceof com.paytm.android.chat.bean.ChatHomeChip
            r1 = 1
            r2 = 0
            if (r0 == 0) goto L_0x00fc
            boolean r0 = r11 instanceof com.paytm.android.chat.bean.ChatHomeChip
            if (r0 == 0) goto L_0x00fc
            com.paytm.android.chat.bean.ChatHomeChip r10 = (com.paytm.android.chat.bean.ChatHomeChip) r10
            java.util.List r0 = r10.getList()
            int r0 = r0.size()
            com.paytm.android.chat.bean.ChatHomeChip r11 = (com.paytm.android.chat.bean.ChatHomeChip) r11
            java.util.List r3 = r11.getList()
            int r3 = r3.size()
            if (r0 != r3) goto L_0x0373
            java.util.List r10 = r10.getList()
            java.lang.Iterable r10 = (java.lang.Iterable) r10
            java.util.List r11 = r11.getList()
            java.lang.Iterable r11 = (java.lang.Iterable) r11
            java.lang.String r0 = "$this$zip"
            kotlin.g.b.k.d(r10, r0)
            java.lang.String r0 = "other"
            kotlin.g.b.k.d(r11, r0)
            java.util.Iterator r0 = r10.iterator()
            java.util.Iterator r3 = r11.iterator()
            java.util.ArrayList r4 = new java.util.ArrayList
            int r10 = kotlin.a.k.a(r10)
            int r11 = kotlin.a.k.a(r11)
            int r10 = java.lang.Math.min(r10, r11)
            r4.<init>(r10)
        L_0x005b:
            boolean r10 = r0.hasNext()
            if (r10 == 0) goto L_0x0077
            boolean r10 = r3.hasNext()
            if (r10 == 0) goto L_0x0077
            java.lang.Object r10 = r0.next()
            java.lang.Object r11 = r3.next()
            kotlin.o r10 = kotlin.t.a(r10, r11)
            r4.add(r10)
            goto L_0x005b
        L_0x0077:
            java.util.List r4 = (java.util.List) r4
            java.lang.Iterable r4 = (java.lang.Iterable) r4
            r10 = r4
            java.util.Collection r10 = (java.util.Collection) r10
            boolean r10 = r10.isEmpty()
            if (r10 != 0) goto L_0x00fb
            java.util.Iterator r10 = r4.iterator()
        L_0x0088:
            boolean r11 = r10.hasNext()
            if (r11 == 0) goto L_0x00fb
            java.lang.Object r11 = r10.next()
            kotlin.o r11 = (kotlin.o) r11
            java.lang.Object r0 = r11.component1()
            com.paytm.android.chat.network.response.HomeChips r0 = (com.paytm.android.chat.network.response.HomeChips) r0
            java.lang.Object r11 = r11.component2()
            com.paytm.android.chat.network.response.HomeChips r11 = (com.paytm.android.chat.network.response.HomeChips) r11
            boolean r3 = r0.getShowDot()
            boolean r4 = r11.getShowDot()
            if (r3 != r4) goto L_0x00f6
            java.lang.String r3 = r0.getName()
            java.lang.String r4 = r11.getName()
            boolean r3 = kotlin.g.b.k.a((java.lang.Object) r3, (java.lang.Object) r4)
            if (r3 == 0) goto L_0x00f6
            java.util.ArrayList r3 = r0.getFilter()
            int r3 = r3.size()
            java.util.ArrayList r4 = r11.getFilter()
            int r4 = r4.size()
            if (r3 != r4) goto L_0x00f6
            java.lang.String r3 = r0.getAction()
            java.lang.String r4 = r11.getAction()
            boolean r3 = kotlin.g.b.k.a((java.lang.Object) r3, (java.lang.Object) r4)
            if (r3 == 0) goto L_0x00f6
            java.lang.String r3 = r0.getImage_url()
            java.lang.String r4 = r11.getImage_url()
            boolean r3 = kotlin.g.b.k.a((java.lang.Object) r3, (java.lang.Object) r4)
            if (r3 == 0) goto L_0x00f6
            java.lang.String r0 = r0.getUrl()
            java.lang.String r11 = r11.getUrl()
            boolean r11 = kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.Object) r11)
            if (r11 == 0) goto L_0x00f6
            r11 = 1
            goto L_0x00f7
        L_0x00f6:
            r11 = 0
        L_0x00f7:
            if (r11 != 0) goto L_0x0088
            goto L_0x0373
        L_0x00fb:
            return r1
        L_0x00fc:
            boolean r0 = r10 instanceof com.paytm.android.chat.data.models.channels.ChatGroupChannelDataModel
            if (r0 == 0) goto L_0x02ac
            boolean r0 = r11 instanceof com.paytm.android.chat.data.models.channels.ChatGroupChannelDataModel
            if (r0 == 0) goto L_0x02ac
            com.paytm.android.chat.data.models.channels.ChatGroupChannelDataModel r10 = (com.paytm.android.chat.data.models.channels.ChatGroupChannelDataModel) r10
            boolean r0 = r10.isPushEnabled()
            com.paytm.android.chat.data.models.channels.ChatGroupChannelDataModel r11 = (com.paytm.android.chat.data.models.channels.ChatGroupChannelDataModel) r11
            boolean r3 = r11.isPushEnabled()
            if (r0 == r3) goto L_0x0113
            return r2
        L_0x0113:
            boolean r0 = r10.isPinned()
            boolean r3 = r11.isPinned()
            if (r0 == r3) goto L_0x011e
            return r2
        L_0x011e:
            java.lang.String r0 = r10.getCustomType()
            java.lang.String r3 = r11.getCustomType()
            boolean r0 = kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.Object) r3)
            r0 = r0 ^ r1
            if (r0 == 0) goto L_0x012e
            return r2
        L_0x012e:
            boolean r0 = r10.isFake()
            boolean r3 = r11.isFake()
            if (r0 == r3) goto L_0x0139
            return r2
        L_0x0139:
            long r3 = r10.getMyLastRead()
            long r5 = r11.getMyLastRead()
            int r0 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r0 == 0) goto L_0x0146
            return r2
        L_0x0146:
            boolean r0 = r10.isTyping()
            boolean r3 = r11.isTyping()
            if (r0 == r3) goto L_0x0151
            return r2
        L_0x0151:
            int r0 = r10.getUnreadMessageCount()
            int r3 = r11.getUnreadMessageCount()
            if (r0 == r3) goto L_0x015c
            return r2
        L_0x015c:
            java.lang.String r0 = r10.getDraftMessage()
            java.lang.String r3 = r11.getDraftMessage()
            boolean r0 = com.paytm.android.chat.utils.AppUtilKt.areStringsEqual(r0, r3)
            if (r0 != 0) goto L_0x016b
            return r2
        L_0x016b:
            com.paytm.android.chat.data.models.messages.ChatMessageDataModel r0 = r10.getLastMessage()
            if (r0 == 0) goto L_0x0178
            com.paytm.android.chat.data.models.messages.ChatMessageDataModel r0 = r11.getLastMessage()
            if (r0 != 0) goto L_0x0178
            return r2
        L_0x0178:
            com.paytm.android.chat.data.models.messages.ChatMessageDataModel r0 = r10.getLastMessage()
            if (r0 != 0) goto L_0x0185
            com.paytm.android.chat.data.models.messages.ChatMessageDataModel r0 = r11.getLastMessage()
            if (r0 == 0) goto L_0x0185
            return r2
        L_0x0185:
            com.paytm.android.chat.data.models.messages.MPCMessagePreview r0 = r10.getLastMessagePreview()
            if (r0 == 0) goto L_0x0192
            com.paytm.android.chat.data.models.messages.MPCMessagePreview r0 = r11.getLastMessagePreview()
            if (r0 != 0) goto L_0x0192
            return r2
        L_0x0192:
            com.paytm.android.chat.data.models.messages.MPCMessagePreview r0 = r10.getLastMessagePreview()
            if (r0 != 0) goto L_0x019f
            com.paytm.android.chat.data.models.messages.MPCMessagePreview r0 = r11.getLastMessagePreview()
            if (r0 == 0) goto L_0x019f
            return r2
        L_0x019f:
            com.paytm.android.chat.bean.ReceiverDisplayInfo r0 = r10.getReceiverDisplayInfo()
            java.lang.String r0 = r0.getName()
            com.paytm.android.chat.bean.ReceiverDisplayInfo r3 = r11.getReceiverDisplayInfo()
            java.lang.String r3 = r3.getName()
            boolean r0 = kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.Object) r3)
            r0 = r0 ^ r1
            if (r0 == 0) goto L_0x01b7
            return r2
        L_0x01b7:
            com.paytm.android.chat.bean.ReceiverDisplayInfo r0 = r10.getReceiverDisplayInfo()
            java.lang.String r0 = r0.getPhoneNumber()
            com.paytm.android.chat.bean.ReceiverDisplayInfo r3 = r11.getReceiverDisplayInfo()
            java.lang.String r3 = r3.getPhoneNumber()
            boolean r0 = kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.Object) r3)
            r0 = r0 ^ r1
            if (r0 == 0) goto L_0x01cf
            return r2
        L_0x01cf:
            com.paytm.android.chat.bean.ReceiverDisplayInfo r0 = r10.getReceiverDisplayInfo()
            java.lang.String r0 = r0.getProfileImage()
            com.paytm.android.chat.bean.ReceiverDisplayInfo r3 = r11.getReceiverDisplayInfo()
            java.lang.String r3 = r3.getProfileImage()
            boolean r0 = kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.Object) r3)
            r0 = r0 ^ r1
            if (r0 == 0) goto L_0x01e7
            return r2
        L_0x01e7:
            com.paytm.android.chat.bean.ReceiverDisplayInfo r0 = r10.getReceiverDisplayInfo()
            java.lang.String r0 = r0.getBusinessName()
            com.paytm.android.chat.bean.ReceiverDisplayInfo r3 = r11.getReceiverDisplayInfo()
            java.lang.String r3 = r3.getBusinessName()
            boolean r0 = kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.Object) r3)
            r0 = r0 ^ r1
            if (r0 == 0) goto L_0x01ff
            return r2
        L_0x01ff:
            com.paytm.android.chat.bean.ReceiverDisplayInfo r0 = r10.getReceiverDisplayInfo()
            boolean r0 = r0.isFromContact()
            com.paytm.android.chat.bean.ReceiverDisplayInfo r3 = r11.getReceiverDisplayInfo()
            boolean r3 = r3.isFromContact()
            if (r0 == r3) goto L_0x0212
            return r2
        L_0x0212:
            com.paytm.android.chat.bean.ReceiverDisplayInfo r0 = r10.getReceiverDisplayInfo()
            boolean r0 = r0.isBusinessNameAvailable()
            com.paytm.android.chat.bean.ReceiverDisplayInfo r3 = r11.getReceiverDisplayInfo()
            boolean r3 = r3.isBusinessNameAvailable()
            if (r0 == r3) goto L_0x0225
            return r2
        L_0x0225:
            com.paytm.android.chat.data.models.messages.ChatMessageDataModel r0 = r10.getLastMessage()
            if (r0 == 0) goto L_0x027f
            com.paytm.android.chat.data.models.messages.ChatMessageDataModel r3 = r11.getLastMessage()
            if (r3 == 0) goto L_0x027f
            java.lang.Long r4 = r0.createdAt
            java.lang.Long r5 = r3.createdAt
            boolean r4 = kotlin.g.b.k.a((java.lang.Object) r4, (java.lang.Object) r5)
            r4 = r4 ^ r1
            if (r4 == 0) goto L_0x023e
        L_0x023c:
            r0 = 0
            goto L_0x0280
        L_0x023e:
            java.lang.Long r4 = r0.updatedAt
            java.lang.Long r5 = r3.updatedAt
            boolean r4 = kotlin.g.b.k.a((java.lang.Object) r4, (java.lang.Object) r5)
            r4 = r4 ^ r1
            if (r4 == 0) goto L_0x024a
            goto L_0x023c
        L_0x024a:
            long r4 = r0.messageId
            long r6 = r3.messageId
            int r8 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r8 == 0) goto L_0x0253
            goto L_0x023c
        L_0x0253:
            java.lang.String r4 = r0.messageType
            java.lang.String r5 = r3.messageType
            boolean r4 = kotlin.g.b.k.a((java.lang.Object) r4, (java.lang.Object) r5)
            r4 = r4 ^ r1
            if (r4 == 0) goto L_0x025f
            goto L_0x023c
        L_0x025f:
            com.sendbird.android.BaseMessage r4 = r0.baseMessage
            java.lang.String r5 = "oldLastMessage.baseMessage"
            kotlin.g.b.k.a((java.lang.Object) r4, (java.lang.String) r5)
            com.sendbird.android.BaseMessage$SendingStatus r4 = r4.getSendingStatus()
            com.sendbird.android.BaseMessage r5 = r3.baseMessage
            java.lang.String r6 = "newLastMessage.baseMessage"
            kotlin.g.b.k.a((java.lang.Object) r5, (java.lang.String) r6)
            com.sendbird.android.BaseMessage$SendingStatus r5 = r5.getSendingStatus()
            if (r4 == r5) goto L_0x0278
            goto L_0x023c
        L_0x0278:
            com.paytm.android.chat.utils.ChatMessageState r0 = r0.messageState
            com.paytm.android.chat.utils.ChatMessageState r3 = r3.messageState
            if (r0 == r3) goto L_0x027f
            goto L_0x023c
        L_0x027f:
            r0 = 1
        L_0x0280:
            if (r0 == 0) goto L_0x02ab
            com.paytm.android.chat.data.models.messages.MPCMessagePreview r10 = r10.getLastMessagePreview()
            if (r10 == 0) goto L_0x02ab
            com.paytm.android.chat.data.models.messages.MPCMessagePreview r11 = r11.getLastMessagePreview()
            if (r11 == 0) goto L_0x02ab
            java.lang.String r0 = r10.getPreviewText()
            java.lang.String r3 = r11.getPreviewText()
            boolean r0 = kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.Object) r3)
            r0 = r0 ^ r1
            if (r0 == 0) goto L_0x029f
        L_0x029d:
            r0 = 0
            goto L_0x02ab
        L_0x029f:
            com.paytm.android.chat.data.models.messages.MPCPreviewDrawable r10 = r10.getPreviewDrawable()
            com.paytm.android.chat.data.models.messages.MPCPreviewDrawable r11 = r11.getPreviewDrawable()
            if (r10 == r11) goto L_0x02aa
            goto L_0x029d
        L_0x02aa:
            r0 = 1
        L_0x02ab:
            return r0
        L_0x02ac:
            boolean r0 = r10 instanceof com.paytm.android.chat.bean.FriendBean
            if (r0 == 0) goto L_0x02f0
            boolean r0 = r11 instanceof com.paytm.android.chat.bean.FriendBean
            if (r0 == 0) goto L_0x02f0
            com.paytm.android.chat.bean.FriendBean r10 = (com.paytm.android.chat.bean.FriendBean) r10
            boolean r0 = r10.isNew()
            com.paytm.android.chat.bean.FriendBean r11 = (com.paytm.android.chat.bean.FriendBean) r11
            boolean r3 = r11.isNew()
            if (r0 != r3) goto L_0x0373
            java.lang.String r0 = r10.getName()
            java.lang.String r3 = r11.getName()
            boolean r0 = kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.Object) r3)
            r0 = r0 ^ r1
            if (r0 != 0) goto L_0x0373
            java.lang.String r0 = r10.getPhoto()
            java.lang.String r3 = r11.getPhoto()
            boolean r0 = kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.Object) r3)
            r0 = r0 ^ r1
            if (r0 != 0) goto L_0x0373
            java.lang.String r10 = r10.getPreviewText()
            java.lang.String r11 = r11.getPreviewText()
            boolean r10 = kotlin.g.b.k.a((java.lang.Object) r10, (java.lang.Object) r11)
            r10 = r10 ^ r1
            if (r10 != 0) goto L_0x0373
            return r1
        L_0x02f0:
            boolean r0 = r10 instanceof com.paytm.android.chat.bean.SelectContactsBean
            if (r0 == 0) goto L_0x0358
            boolean r0 = r11 instanceof com.paytm.android.chat.bean.SelectContactsBean
            if (r0 == 0) goto L_0x0358
            com.paytm.android.chat.bean.SelectContactsBean r10 = (com.paytm.android.chat.bean.SelectContactsBean) r10
            com.paytm.android.chat.bean.SendContactBean r0 = r10.getSendContactBean()
            java.lang.String r3 = "oldItem.sendContactBean"
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r3)
            java.lang.String r0 = r0.getContactName()
            com.paytm.android.chat.bean.SelectContactsBean r11 = (com.paytm.android.chat.bean.SelectContactsBean) r11
            com.paytm.android.chat.bean.SendContactBean r4 = r11.getSendContactBean()
            java.lang.String r5 = "newItem.sendContactBean"
            kotlin.g.b.k.a((java.lang.Object) r4, (java.lang.String) r5)
            java.lang.String r4 = r4.getContactName()
            boolean r0 = kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.Object) r4)
            r0 = r0 ^ r1
            if (r0 != 0) goto L_0x0373
            com.paytm.android.chat.bean.SendContactBean r0 = r10.getSendContactBean()
            kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.String) r3)
            java.lang.String r0 = r0.getContactPhone()
            com.paytm.android.chat.bean.SendContactBean r4 = r11.getSendContactBean()
            kotlin.g.b.k.a((java.lang.Object) r4, (java.lang.String) r5)
            java.lang.String r4 = r4.getContactPhone()
            boolean r0 = kotlin.g.b.k.a((java.lang.Object) r0, (java.lang.Object) r4)
            r0 = r0 ^ r1
            if (r0 != 0) goto L_0x0373
            com.paytm.android.chat.bean.SendContactBean r10 = r10.getSendContactBean()
            kotlin.g.b.k.a((java.lang.Object) r10, (java.lang.String) r3)
            java.lang.String r10 = r10.getContactPic()
            com.paytm.android.chat.bean.SendContactBean r11 = r11.getSendContactBean()
            kotlin.g.b.k.a((java.lang.Object) r11, (java.lang.String) r5)
            java.lang.String r11 = r11.getContactPic()
            boolean r10 = kotlin.g.b.k.a((java.lang.Object) r10, (java.lang.Object) r11)
            r10 = r10 ^ r1
            if (r10 != 0) goto L_0x0373
            return r1
        L_0x0358:
            boolean r0 = r10 instanceof com.paytm.android.chat.bean.ChatChannelHeader
            if (r0 == 0) goto L_0x0361
            boolean r0 = r11 instanceof com.paytm.android.chat.bean.ChatChannelHeader
            if (r0 == 0) goto L_0x0361
            return r1
        L_0x0361:
            boolean r0 = r10 instanceof com.paytm.android.chat.bean.ChatFriendsHeader
            if (r0 == 0) goto L_0x036a
            boolean r0 = r11 instanceof com.paytm.android.chat.bean.ChatFriendsHeader
            if (r0 == 0) goto L_0x036a
            return r1
        L_0x036a:
            boolean r10 = r10 instanceof com.paytm.android.chat.bean.ChatContactHeader
            if (r10 == 0) goto L_0x0373
            boolean r10 = r11 instanceof com.paytm.android.chat.bean.ChatContactHeader
            if (r10 == 0) goto L_0x0373
            return r1
        L_0x0373:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.paytm.android.chat.utils.ChatHomeDiffUtil.areContentsTheSame(int, int):boolean");
    }

    public final int getOldListSize() {
        return this.oldList.size();
    }

    public final int getNewListSize() {
        return this.newList.size();
    }

    public final boolean areListSame() {
        if (getOldListSize() != getNewListSize()) {
            return false;
        }
        int oldListSize = getOldListSize();
        for (int i2 = 0; i2 < oldListSize; i2++) {
            if (!areItemsTheSame(i2, i2) || !areContentsTheSame(i2, i2)) {
                q.b("oldItem " + i2 + 10 + this.oldList.get(i2));
                q.b("newItem " + i2 + 10 + this.newList.get(i2));
                return false;
            }
        }
        return true;
    }
}
