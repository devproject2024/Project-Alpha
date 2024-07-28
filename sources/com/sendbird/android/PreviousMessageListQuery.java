package com.sendbird.android;

import com.sendbird.android.BaseChannel;
import com.sendbird.android.constant.StringSet;
import com.sendbird.android.shadow.com.google.gson.JsonArray;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;

public class PreviousMessageListQuery {
    /* access modifiers changed from: private */
    public boolean includeParentMessageText = false;
    /* access modifiers changed from: private */
    public boolean includeReplies = false;
    /* access modifiers changed from: private */
    public boolean includeThreadInfo = false;
    /* access modifiers changed from: private */
    public BaseChannel mChannel;
    /* access modifiers changed from: private */
    public String mCustomType;
    /* access modifiers changed from: private */
    public boolean mHasMore = true;
    /* access modifiers changed from: private */
    public boolean mIncludeMetaArray = false;
    /* access modifiers changed from: private */
    public boolean mIncludeReactions = false;
    /* access modifiers changed from: private */
    public int mLimit = 20;
    private boolean mLoading = false;
    /* access modifiers changed from: private */
    public long mMessageTimestamp = Long.MAX_VALUE;
    /* access modifiers changed from: private */
    public BaseChannel.MessageTypeFilter mMessageType = BaseChannel.MessageTypeFilter.ALL;
    /* access modifiers changed from: private */
    public boolean mReverse = false;
    /* access modifiers changed from: private */
    public List<String> mSenderUserIds;
    /* access modifiers changed from: private */
    public boolean showSubchannelMessagesOnly = false;

    public interface MessageListQueryResult {
        void onResult(List<BaseMessage> list, SendBirdException sendBirdException);
    }

    PreviousMessageListQuery(BaseChannel baseChannel) {
        this.mChannel = baseChannel;
    }

    public boolean hasMore() {
        return this.mHasMore;
    }

    public synchronized boolean isLoading() {
        return this.mLoading;
    }

    /* access modifiers changed from: package-private */
    public synchronized void setLoading(boolean z) {
        this.mLoading = z;
    }

    public void setLimit(int i2) {
        this.mLimit = i2;
    }

    public void setReverse(boolean z) {
        this.mReverse = z;
    }

    public void setMessageTypeFilter(BaseChannel.MessageTypeFilter messageTypeFilter) {
        this.mMessageType = messageTypeFilter;
    }

    public void setCustomTypeFilter(String str) {
        this.mCustomType = str;
    }

    public void setSenderUserIdsFilter(List<String> list) {
        this.mSenderUserIds = list;
    }

    public void setIncludeMetaArray(boolean z) {
        this.mIncludeMetaArray = z;
    }

    public void setIncludeReactions(boolean z) {
        this.mIncludeReactions = z;
    }

    public void setIncludeThreadInfo(boolean z) {
        this.includeThreadInfo = z;
    }

    public void setIncludeReplies(boolean z) {
        this.includeReplies = z;
    }

    public void setIncludeParentMessageText(boolean z) {
        this.includeParentMessageText = z;
    }

    public void setShowSubchannelMessagesOnly(boolean z) {
        this.showSubchannelMessagesOnly = z;
    }

    public synchronized void load(MessageListQueryResult messageListQueryResult) {
        load(this.mLimit, this.mReverse, messageListQueryResult);
    }

    public synchronized void load(final int i2, final boolean z, final MessageListQueryResult messageListQueryResult) {
        if (isLoading()) {
            SendBird.runOnUIThread(new Runnable() {
                public final void run() {
                    MessageListQueryResult messageListQueryResult = messageListQueryResult;
                    if (messageListQueryResult != null) {
                        messageListQueryResult.onResult((List<BaseMessage>) null, new SendBirdException("Query in progress.", SendBirdError.ERR_QUERY_IN_PROGRESS));
                    }
                }
            });
        } else if (!hasMore()) {
            SendBird.runOnUIThread(new Runnable() {
                public final void run() {
                    MessageListQueryResult messageListQueryResult = messageListQueryResult;
                    if (messageListQueryResult != null) {
                        messageListQueryResult.onResult(new ArrayList(), (SendBirdException) null);
                    }
                }
            });
        } else {
            setLoading(true);
            d.a(new q<List<BaseMessage>>() {
                public final /* synthetic */ void a(Object obj, SendBirdException sendBirdException) {
                    List list = (List) obj;
                    PreviousMessageListQuery.this.setLoading(false);
                    MessageListQueryResult messageListQueryResult = messageListQueryResult;
                    if (messageListQueryResult != null) {
                        messageListQueryResult.onResult(list, sendBirdException);
                    }
                }

                public final /* synthetic */ Object call() throws Exception {
                    int unused = PreviousMessageListQuery.this.mLimit = i2;
                    boolean unused2 = PreviousMessageListQuery.this.mReverse = z;
                    LinkedHashSet linkedHashSet = null;
                    String value = (PreviousMessageListQuery.this.mMessageType == null || PreviousMessageListQuery.this.mMessageType == BaseChannel.MessageTypeFilter.ALL) ? null : PreviousMessageListQuery.this.mMessageType.value();
                    if (PreviousMessageListQuery.this.mSenderUserIds != null) {
                        linkedHashSet = new LinkedHashSet(PreviousMessageListQuery.this.mSenderUserIds);
                    }
                    JsonArray asJsonArray = APIClient.a().a(PreviousMessageListQuery.this.mChannel instanceof OpenChannel, PreviousMessageListQuery.this.mChannel.getUrl(), 0, PreviousMessageListQuery.this.mMessageTimestamp, PreviousMessageListQuery.this.mLimit, 0, false, PreviousMessageListQuery.this.mReverse, value, PreviousMessageListQuery.this.mCustomType, linkedHashSet, PreviousMessageListQuery.this.mIncludeMetaArray, PreviousMessageListQuery.this.mIncludeReactions, PreviousMessageListQuery.this.includeThreadInfo, PreviousMessageListQuery.this.includeReplies, PreviousMessageListQuery.this.includeParentMessageText, PreviousMessageListQuery.this.showSubchannelMessagesOnly).getAsJsonObject().get(StringSet.messages).getAsJsonArray();
                    ArrayList arrayList = new ArrayList();
                    for (int i2 = 0; i2 < asJsonArray.size(); i2++) {
                        BaseMessage build = BaseMessage.build(asJsonArray.get(i2), PreviousMessageListQuery.this.mChannel.getUrl(), PreviousMessageListQuery.this.mChannel.getType());
                        if (build != null) {
                            arrayList.add(build);
                            if (build.getCreatedAt() <= PreviousMessageListQuery.this.mMessageTimestamp) {
                                long unused3 = PreviousMessageListQuery.this.mMessageTimestamp = build.getCreatedAt();
                            }
                        }
                    }
                    if (arrayList.size() < i2) {
                        boolean unused4 = PreviousMessageListQuery.this.mHasMore = false;
                    }
                    return arrayList;
                }
            });
        }
    }

    public BaseChannel getChannel() {
        return this.mChannel;
    }

    public long getMessageTimestamp() {
        return this.mMessageTimestamp;
    }

    public int getLimit() {
        return this.mLimit;
    }

    public boolean shouldReverse() {
        return this.mReverse;
    }

    public BaseChannel.MessageTypeFilter getMessageTypeFilter() {
        return this.mMessageType;
    }

    public String getCustomTypeFilter() {
        return this.mCustomType;
    }

    public List<String> getSenderUserIdsFilter() {
        return this.mSenderUserIds;
    }

    public boolean shouldIncludeMetaArray() {
        return this.mIncludeMetaArray;
    }

    public boolean shouldIncludeReactions() {
        return this.mIncludeReactions;
    }

    public boolean isIncludeThreadInfo() {
        return this.includeThreadInfo;
    }

    public boolean shouldIncludeReplies() {
        return this.includeReplies;
    }

    public boolean shouldIncludeParentMessageText() {
        return this.includeParentMessageText;
    }

    public boolean shouldShowSubchannelMessagesOnly() {
        return this.showSubchannelMessagesOnly;
    }
}
