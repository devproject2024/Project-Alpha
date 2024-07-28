package com.sendbird.android;

import com.sendbird.android.constant.StringSet;
import com.sendbird.android.shadow.com.google.gson.JsonArray;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Deprecated
public final class MessageListQuery {
    /* access modifiers changed from: private */
    public BaseChannel mChannel;
    private boolean mLoading = false;

    public interface MessageListQueryResult {
        void onResult(List<BaseMessage> list, SendBirdException sendBirdException);
    }

    MessageListQuery(BaseChannel baseChannel) {
        this.mChannel = baseChannel;
    }

    public final synchronized boolean isLoading() {
        return this.mLoading;
    }

    /* access modifiers changed from: package-private */
    public final synchronized void setLoading(boolean z) {
        this.mLoading = z;
    }

    public final synchronized void next(long j, int i2, boolean z, final MessageListQueryResult messageListQueryResult) {
        if (isLoading()) {
            SendBird.runOnUIThread(new Runnable() {
                public final void run() {
                    MessageListQueryResult messageListQueryResult = messageListQueryResult;
                    if (messageListQueryResult != null) {
                        messageListQueryResult.onResult((List<BaseMessage>) null, new SendBirdException("Query in progress.", SendBirdError.ERR_QUERY_IN_PROGRESS));
                    }
                }
            });
            return;
        }
        setLoading(true);
        final long j2 = j;
        final int i3 = i2;
        final boolean z2 = z;
        final MessageListQueryResult messageListQueryResult2 = messageListQueryResult;
        d.a(new q<List<BaseMessage>>() {
            public final /* synthetic */ void a(Object obj, SendBirdException sendBirdException) {
                List list = (List) obj;
                MessageListQuery.this.setLoading(false);
                MessageListQueryResult messageListQueryResult = messageListQueryResult2;
                if (messageListQueryResult != null) {
                    messageListQueryResult.onResult(list, sendBirdException);
                }
            }

            public final /* synthetic */ Object call() throws Exception {
                JsonArray asJsonArray = APIClient.a().a(MessageListQuery.this.mChannel instanceof OpenChannel, MessageListQuery.this.mChannel.getUrl(), 0, j2, 0, i3, false, z2, (String) null, (String) null, (Collection<String>) null, false, false, false, false, false, false).getAsJsonObject().get(StringSet.messages).getAsJsonArray();
                ArrayList arrayList = new ArrayList();
                for (int i2 = 0; i2 < asJsonArray.size(); i2++) {
                    BaseMessage build = BaseMessage.build(asJsonArray.get(i2), MessageListQuery.this.mChannel.getUrl(), MessageListQuery.this.mChannel.getType());
                    if (build != null) {
                        arrayList.add(build);
                    }
                }
                return arrayList;
            }
        });
    }

    public final synchronized void prev(long j, int i2, boolean z, final MessageListQueryResult messageListQueryResult) {
        if (isLoading()) {
            SendBird.runOnUIThread(new Runnable() {
                public final void run() {
                    MessageListQueryResult messageListQueryResult = messageListQueryResult;
                    if (messageListQueryResult != null) {
                        messageListQueryResult.onResult((List<BaseMessage>) null, new SendBirdException("Query in progress.", SendBirdError.ERR_QUERY_IN_PROGRESS));
                    }
                }
            });
            return;
        }
        setLoading(true);
        final long j2 = j;
        final int i3 = i2;
        final boolean z2 = z;
        final MessageListQueryResult messageListQueryResult2 = messageListQueryResult;
        d.a(new q<List<BaseMessage>>() {
            public final /* synthetic */ void a(Object obj, SendBirdException sendBirdException) {
                List list = (List) obj;
                MessageListQuery.this.setLoading(false);
                MessageListQueryResult messageListQueryResult = messageListQueryResult2;
                if (messageListQueryResult != null) {
                    messageListQueryResult.onResult(list, sendBirdException);
                }
            }

            public final /* synthetic */ Object call() throws Exception {
                JsonArray asJsonArray = APIClient.a().a(MessageListQuery.this.mChannel instanceof OpenChannel, MessageListQuery.this.mChannel.getUrl(), 0, j2, i3, 0, false, z2, (String) null, (String) null, (Collection<String>) null, false, false, false, false, false, false).getAsJsonObject().get(StringSet.messages).getAsJsonArray();
                ArrayList arrayList = new ArrayList();
                for (int i2 = 0; i2 < asJsonArray.size(); i2++) {
                    BaseMessage build = BaseMessage.build(asJsonArray.get(i2), MessageListQuery.this.mChannel.getUrl(), MessageListQuery.this.mChannel.getType());
                    if (build != null) {
                        arrayList.add(build);
                    }
                }
                return arrayList;
            }
        });
    }

    public final synchronized void load(long j, int i2, int i3, boolean z, final MessageListQueryResult messageListQueryResult) {
        if (isLoading()) {
            SendBird.runOnUIThread(new Runnable() {
                public final void run() {
                    MessageListQueryResult messageListQueryResult = messageListQueryResult;
                    if (messageListQueryResult != null) {
                        messageListQueryResult.onResult((List<BaseMessage>) null, new SendBirdException("Query in progress.", SendBirdError.ERR_QUERY_IN_PROGRESS));
                    }
                }
            });
            return;
        }
        setLoading(true);
        final long j2 = j;
        final int i4 = i2;
        final int i5 = i3;
        final boolean z2 = z;
        final MessageListQueryResult messageListQueryResult2 = messageListQueryResult;
        d.a(new q<List<BaseMessage>>() {
            public final /* synthetic */ void a(Object obj, SendBirdException sendBirdException) {
                List list = (List) obj;
                MessageListQuery.this.setLoading(false);
                MessageListQueryResult messageListQueryResult = messageListQueryResult2;
                if (messageListQueryResult != null) {
                    messageListQueryResult.onResult(list, sendBirdException);
                }
            }

            public final /* synthetic */ Object call() throws Exception {
                JsonArray asJsonArray = APIClient.a().a(MessageListQuery.this.mChannel instanceof OpenChannel, MessageListQuery.this.mChannel.getUrl(), 0, j2, i4, i5, true, z2, (String) null, (String) null, (Collection<String>) null, false, false, false, false, false, false).getAsJsonObject().get(StringSet.messages).getAsJsonArray();
                ArrayList arrayList = new ArrayList();
                for (int i2 = 0; i2 < asJsonArray.size(); i2++) {
                    BaseMessage build = BaseMessage.build(asJsonArray.get(i2), MessageListQuery.this.mChannel.getUrl(), MessageListQuery.this.mChannel.getType());
                    if (build != null) {
                        arrayList.add(build);
                    }
                }
                return arrayList;
            }
        });
    }
}
