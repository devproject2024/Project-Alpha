package com.paytm.android.chat.view;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.paytm.android.chat.R;
import com.paytm.android.chat.utils.ChatMessageState;
import com.sendbird.android.BaseMessage;
import com.sendbird.android.GroupChannel;

public abstract class b extends a {
    public TextView u;
    public TextView v;
    public ImageView w;
    public View x;

    public b(View view) {
        super(view);
        this.u = (TextView) view.findViewById(R.id.text_group_chat_try_again);
        this.v = (TextView) view.findViewById(R.id.text_group_chat_message_delete);
        this.x = view.findViewById(R.id.ll_group_chat_message_fail);
        this.w = (ImageView) view.findViewById(R.id.image_group_chat_read_receipt);
        ImageView imageView = this.w;
        if (imageView != null) {
            imageView.setAlpha(0.6f);
        }
    }

    public final void a(boolean z, GroupChannel groupChannel, BaseMessage baseMessage) {
        if (z) {
            View view = this.x;
            if (view != null) {
                view.setVisibility(0);
            }
        } else {
            View view2 = this.x;
            if (view2 != null) {
                view2.setVisibility(8);
            }
        }
        a(groupChannel, baseMessage);
    }

    public final void a(GroupChannel groupChannel, BaseMessage baseMessage) {
        if (this.w != null) {
            ChatMessageState messageState = ChatMessageState.getMessageState(groupChannel, baseMessage);
            this.w.setVisibility(0);
            if (messageState == ChatMessageState.FAILED) {
                this.w.setImageResource(R.drawable.chat_icon_group_chat_message_state_fail);
            } else if (messageState == ChatMessageState.SENDING) {
                this.w.setImageResource(R.drawable.chat_icon_group_chat_message_state_send);
            } else if (messageState == ChatMessageState.SENT) {
                this.w.setImageResource(R.drawable.chat_icon_group_chat_message_state_sent);
            } else if (messageState == ChatMessageState.DELIVERED) {
                this.w.setImageResource(R.drawable.chat_icon_group_chat_message_state_arravl);
            } else if (messageState == ChatMessageState.READ) {
                this.w.setImageResource(R.drawable.chat_icon_group_chat_message_state_read);
            } else {
                this.w.setVisibility(8);
            }
        }
    }
}
