package com.zhihu.matisse.internal.ui.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.paytm.android.chat.R;
import com.zhihu.matisse.internal.entity.Item;

public class MediaGrid extends SquareFrameLayout implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public ImageView f45865a;

    /* renamed from: b  reason: collision with root package name */
    public CheckView f45866b;

    /* renamed from: c  reason: collision with root package name */
    public ImageView f45867c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f45868d;

    /* renamed from: e  reason: collision with root package name */
    public View f45869e;

    /* renamed from: f  reason: collision with root package name */
    public Item f45870f;

    /* renamed from: g  reason: collision with root package name */
    public b f45871g;

    /* renamed from: h  reason: collision with root package name */
    private View f45872h;

    /* renamed from: i  reason: collision with root package name */
    private a f45873i;

    public interface a {
        void a(Item item, RecyclerView.v vVar);

        void b(Item item, RecyclerView.v vVar);
    }

    public MediaGrid(Context context) {
        super(context);
        a(context);
    }

    public MediaGrid(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context);
    }

    private void a(Context context) {
        LayoutInflater.from(context).inflate(R.layout.chat_media_grid_content, this, true);
        this.f45865a = (ImageView) findViewById(R.id.media_thumbnail);
        this.f45866b = (CheckView) findViewById(R.id.check_view);
        this.f45867c = (ImageView) findViewById(R.id.gif);
        this.f45868d = (TextView) findViewById(R.id.video_duration);
        this.f45869e = findViewById(R.id.video_duration_layout);
        this.f45872h = findViewById(R.id.cover);
        this.f45865a.setOnClickListener(this);
        this.f45866b.setOnClickListener(this);
    }

    public void onClick(View view) {
        a aVar = this.f45873i;
        if (aVar == null) {
            return;
        }
        if (view == this.f45865a) {
            aVar.a(this.f45870f, this.f45871g.f45877d);
        } else if (view == this.f45866b) {
            aVar.b(this.f45870f, this.f45871g.f45877d);
        }
    }

    public Item getMedia() {
        return this.f45870f;
    }

    public void setCheckEnabled(boolean z) {
        this.f45866b.setEnabled(z);
    }

    public void setCheckedNum(int i2) {
        this.f45866b.setCheckedNum(i2);
        this.f45872h.setVisibility(i2 > 0 ? 0 : 8);
    }

    public void setChecked(boolean z) {
        this.f45866b.setChecked(z);
    }

    public void setOnMediaGridClickListener(a aVar) {
        this.f45873i = aVar;
    }

    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public int f45874a;

        /* renamed from: b  reason: collision with root package name */
        public Drawable f45875b;

        /* renamed from: c  reason: collision with root package name */
        public boolean f45876c;

        /* renamed from: d  reason: collision with root package name */
        RecyclerView.v f45877d;

        public b(int i2, Drawable drawable, boolean z, RecyclerView.v vVar) {
            this.f45874a = i2;
            this.f45875b = drawable;
            this.f45876c = z;
            this.f45877d = vVar;
        }
    }
}
