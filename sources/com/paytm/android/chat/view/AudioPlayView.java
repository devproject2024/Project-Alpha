package com.paytm.android.chat.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;
import com.paytm.android.chat.R;
import com.paytm.android.chat.utils.DateUtils;
import com.paytm.android.chat.view.round.RoundAngleFrameLayout;

public class AudioPlayView extends RoundAngleFrameLayout {

    /* renamed from: a  reason: collision with root package name */
    TextView f42437a;

    /* renamed from: b  reason: collision with root package name */
    TextView f42438b;

    /* renamed from: c  reason: collision with root package name */
    ImageView f42439c;

    /* renamed from: d  reason: collision with root package name */
    ImageView f42440d;

    /* renamed from: e  reason: collision with root package name */
    SeekBar f42441e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f42442f;

    public AudioPlayView(Context context) {
        super(context);
    }

    public AudioPlayView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        View view;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.AudioPlayView);
        boolean z = obtainStyledAttributes.getBoolean(R.styleable.AudioPlayView_isSelf, true);
        obtainStyledAttributes.recycle();
        if (z) {
            view = View.inflate(getContext(), R.layout.chat_view_audio_play, this);
        } else {
            view = View.inflate(getContext(), R.layout.chat_view_audio_play_other, this);
        }
        this.f42439c = (ImageView) view.findViewById(R.id.image_group_chat_play_icon);
        this.f42440d = (ImageView) view.findViewById(R.id.image_group_chat_play_bt);
        this.f42437a = (TextView) view.findViewById(R.id.text_group_chat_audio_name);
        this.f42438b = (TextView) view.findViewById(R.id.text_group_chat_audio_time);
        this.f42441e = (SeekBar) view.findViewById(R.id.seekbar_group_chat_audio_time);
    }

    public void setAudioName(String str) {
        this.f42437a.setText(str);
    }

    public ImageView getImagePlay() {
        return this.f42440d;
    }

    public SeekBar getAudioBar() {
        return this.f42441e;
    }

    public void setAudioTime(int i2, int i3) {
        if (i2 > 0) {
            SeekBar seekBar = this.f42441e;
            if (seekBar != null) {
                seekBar.setMax(i3);
                this.f42441e.setProgress(i2);
            }
            TextView textView = this.f42438b;
            if (textView != null) {
                textView.setText(DateUtils.secToTime2((long) i2));
                return;
            }
            return;
        }
        this.f42440d.setImageResource(R.drawable.chat_icon_group_chat_audio_stop);
        SeekBar seekBar2 = this.f42441e;
        if (seekBar2 != null) {
            seekBar2.setMax(i3);
            this.f42441e.setProgress(i2);
        }
        TextView textView2 = this.f42438b;
        if (textView2 != null) {
            textView2.setText(DateUtils.secToTime2((long) i2));
        }
    }

    public void setImagePlay(boolean z) {
        this.f42442f = z;
        if (z) {
            this.f42440d.setImageResource(R.drawable.chat_icon_group_chat_audio_play);
            return;
        }
        if (this.f42441e.getProgress() == this.f42441e.getMax()) {
            this.f42441e.setProgress(0);
            this.f42438b.setText(DateUtils.secToTime2(0));
        }
        this.f42440d.setImageResource(R.drawable.chat_icon_group_chat_audio_stop);
    }
}
