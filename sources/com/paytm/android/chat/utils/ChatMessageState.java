package com.paytm.android.chat.utils;

import com.sendbird.android.BaseMessage;
import com.sendbird.android.GroupChannel;
import kotlin.g.b.g;

public enum ChatMessageState {
    UNKNOWN(0),
    SENDING(1),
    FAILED(2),
    SENT(3),
    CANCELED(4),
    DELIVERED(5),
    READ(6);
    
    public static final Companion Companion = null;
    private final int value;

    public static final ChatMessageState getMessageState(GroupChannel groupChannel, BaseMessage baseMessage) {
        return Companion.getMessageState(groupChannel, baseMessage);
    }

    private ChatMessageState(int i2) {
        this.value = i2;
    }

    public final int getValue() {
        return this.value;
    }

    static {
        Companion = new Companion((g) null);
    }

    public static final class Companion {

        public final /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0 = null;

            static {
                int[] iArr = new int[BaseMessage.SendingStatus.values().length];
                $EnumSwitchMapping$0 = iArr;
                iArr[BaseMessage.SendingStatus.NONE.ordinal()] = 1;
                $EnumSwitchMapping$0[BaseMessage.SendingStatus.FAILED.ordinal()] = 2;
                $EnumSwitchMapping$0[BaseMessage.SendingStatus.PENDING.ordinal()] = 3;
                $EnumSwitchMapping$0[BaseMessage.SendingStatus.CANCELED.ordinal()] = 4;
                $EnumSwitchMapping$0[BaseMessage.SendingStatus.SUCCEEDED.ordinal()] = 5;
            }
        }

        private Companion() {
        }

        public /* synthetic */ Companion(g gVar) {
            this();
        }

        public final ChatMessageState getMessageState(GroupChannel groupChannel, BaseMessage baseMessage) {
            if (groupChannel == null || baseMessage == null) {
                return ChatMessageState.UNKNOWN;
            }
            BaseMessage.SendingStatus sendingStatus = baseMessage.getSendingStatus();
            if (sendingStatus != null) {
                int i2 = WhenMappings.$EnumSwitchMapping$0[sendingStatus.ordinal()];
                if (i2 == 1) {
                    return ChatMessageState.UNKNOWN;
                }
                if (i2 == 2) {
                    return ChatMessageState.FAILED;
                }
                if (i2 == 3) {
                    return ChatMessageState.SENDING;
                }
                if (i2 == 4) {
                    return ChatMessageState.CANCELED;
                }
                if (i2 == 5) {
                    int undeliveredMemberCount = groupChannel.getUndeliveredMemberCount(baseMessage);
                    if (groupChannel.getUnreadMemberCount(baseMessage) == 0) {
                        return ChatMessageState.READ;
                    }
                    if (undeliveredMemberCount == 0) {
                        return ChatMessageState.DELIVERED;
                    }
                    return ChatMessageState.SENT;
                }
            }
            return ChatMessageState.UNKNOWN;
        }

        public final ChatMessageState fromInt(Integer num) {
            ChatMessageState chatMessageState;
            ChatMessageState[] values = ChatMessageState.values();
            int length = values.length;
            int i2 = 0;
            while (true) {
                if (i2 >= length) {
                    chatMessageState = null;
                    break;
                }
                chatMessageState = values[i2];
                if (num != null && chatMessageState.getValue() == num.intValue()) {
                    break;
                }
                i2++;
            }
            return chatMessageState == null ? ChatMessageState.UNKNOWN : chatMessageState;
        }
    }
}
