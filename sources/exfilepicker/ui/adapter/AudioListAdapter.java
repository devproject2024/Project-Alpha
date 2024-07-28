package exfilepicker.ui.adapter;

import android.content.Context;
import android.database.Cursor;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.e.h;
import com.bumptech.glide.load.b.j;
import com.business.merchant_payments.common.utility.AppConstants;
import com.paytm.android.chat.R;
import com.paytm.android.chat.utils.FastClickUtil;
import com.paytm.android.chat.utils.ToastUtil;
import exfilepicker.a.b;
import exfilepicker.a.d;
import exfilepicker.ui.view.CircleProgressPlayButton;
import java.util.ArrayList;
import java.util.List;

public final class AudioListAdapter extends RecyclerView.a<a> {

    /* renamed from: a  reason: collision with root package name */
    List<AudioInfo> f46172a;

    /* renamed from: b  reason: collision with root package name */
    public ArrayList<AudioInfo> f46173b = new ArrayList<>();

    /* renamed from: c  reason: collision with root package name */
    public List<b> f46174c = new ArrayList();

    /* renamed from: d  reason: collision with root package name */
    public CircleProgressPlayButton.a f46175d = new CircleProgressPlayButton.a();

    /* renamed from: e  reason: collision with root package name */
    Context f46176e;

    /* renamed from: f  reason: collision with root package name */
    private List<AudioInfo> f46177f = new ArrayList();

    public static class b {
        public void a(ArrayList arrayList) {
        }
    }

    public final long getItemId(int i2) {
        return (long) i2;
    }

    public final /* synthetic */ void onBindViewHolder(RecyclerView.v vVar, int i2) {
        a aVar = (a) vVar;
        AudioInfo audioInfo = this.f46172a.get(i2);
        if (this.f46175d.e()) {
            if (aVar.f46198f.o != null && aVar.f46198f.o.equals(this.f46175d.f46247e)) {
                aVar.f46198f.a();
            } else if (audioInfo.f46185b.equals(this.f46175d.f46247e)) {
                aVar.f46198f.setTimer(this.f46175d);
            }
        }
        aVar.f46200h = this.f46172a.get(i2);
        aVar.f46193a.setText(audioInfo.f46187d);
        TextView textView = aVar.f46194b;
        textView.setText(exfilepicker.a.a.a(audioInfo.j) + " • " + d.a(aVar.f46194b.getContext(), audioInfo.f46186c));
        aVar.f46198f.o = audioInfo.f46185b;
        aVar.f46196d.setVisibility(a(i2) ? 0 : 4);
        h hVar = (h) ((h) new h().l()).a(j.f6879e);
        if (!TextUtils.isEmpty(audioInfo.p)) {
            aVar.f46195c.setVisibility(0);
            com.bumptech.glide.b.a((View) aVar.f46195c).d().b((Object) audioInfo.p).b((com.bumptech.glide.e.a<?>) hVar).a(aVar.f46195c);
            return;
        }
        aVar.f46195c.setVisibility(8);
    }

    public final void a() {
        for (b a2 : this.f46174c) {
            a2.a(this.f46173b);
        }
    }

    public static class AudioInfo implements Parcelable {
        public static final Parcelable.Creator<AudioInfo> CREATOR = new Parcelable.Creator<AudioInfo>() {
            public final /* bridge */ /* synthetic */ Object[] newArray(int i2) {
                return new AudioInfo[i2];
            }

            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                return new AudioInfo(parcel);
            }
        };

        /* renamed from: a  reason: collision with root package name */
        private int f46184a;
        /* access modifiers changed from: private */

        /* renamed from: b  reason: collision with root package name */
        public String f46185b;
        /* access modifiers changed from: private */

        /* renamed from: c  reason: collision with root package name */
        public long f46186c;
        /* access modifiers changed from: private */

        /* renamed from: d  reason: collision with root package name */
        public String f46187d;
        /* access modifiers changed from: private */

        /* renamed from: e  reason: collision with root package name */
        public String f46188e;

        /* renamed from: f  reason: collision with root package name */
        private long f46189f;

        /* renamed from: g  reason: collision with root package name */
        private long f46190g;

        /* renamed from: h  reason: collision with root package name */
        private String f46191h;

        /* renamed from: i  reason: collision with root package name */
        private String f46192i;
        /* access modifiers changed from: private */
        public long j;
        private long k;
        private long l;
        private String m;
        private String n;
        private long o;
        /* access modifiers changed from: private */
        public String p;
        private String q;
        private String r;
        private int s;
        private int t;
        private int u;
        private int v;
        private int w;
        private int x;
        private int y;

        public int describeContents() {
            return 0;
        }

        public final String a() {
            return this.f46185b;
        }

        public final long b() {
            return this.j;
        }

        public AudioInfo(Cursor cursor, Context context) {
            String str;
            this.f46184a = cursor.getInt(cursor.getColumnIndex("_id"));
            this.f46185b = cursor.getString(cursor.getColumnIndex("_data"));
            this.f46186c = cursor.getLong(cursor.getColumnIndex("_size"));
            this.f46187d = cursor.getString(cursor.getColumnIndex("_display_name"));
            this.f46188e = cursor.getString(cursor.getColumnIndex("title"));
            this.f46189f = cursor.getLong(cursor.getColumnIndex("date_added"));
            this.f46190g = cursor.getLong(cursor.getColumnIndex("date_modified"));
            this.f46191h = cursor.getString(cursor.getColumnIndex("mime_type"));
            this.f46192i = cursor.getString(cursor.getColumnIndex("title_key"));
            this.j = cursor.getLong(cursor.getColumnIndex(AppConstants.DURATION));
            this.k = cursor.getLong(cursor.getColumnIndex("bookmark"));
            this.l = cursor.getLong(cursor.getColumnIndex("artist_id"));
            this.m = cursor.getString(cursor.getColumnIndex("artist"));
            this.n = cursor.getString(cursor.getColumnIndex("artist_key"));
            this.o = cursor.getLong(cursor.getColumnIndex("album_id"));
            this.q = cursor.getString(cursor.getColumnIndex("album"));
            this.r = cursor.getString(cursor.getColumnIndex("album_key"));
            this.s = cursor.getInt(cursor.getColumnIndex("track"));
            this.t = cursor.getInt(cursor.getColumnIndex("year"));
            this.u = cursor.getInt(cursor.getColumnIndex("is_music"));
            this.v = cursor.getInt(cursor.getColumnIndex("is_podcast"));
            this.w = cursor.getInt(cursor.getColumnIndex("is_ringtone"));
            this.x = cursor.getInt(cursor.getColumnIndex("is_alarm"));
            this.y = cursor.getInt(cursor.getColumnIndex("is_notification"));
            long j2 = this.o;
            Cursor query = context.getContentResolver().query(Uri.parse("content://media/external/audio/albums" + "/" + j2), new String[]{"album_art"}, (String) null, (String[]) null, (String) null);
            if (query.getCount() <= 0 || query.getColumnCount() <= 0) {
                str = null;
            } else {
                query.moveToNext();
                str = query.getString(0);
            }
            query.close();
            this.p = str == null ? null : str;
        }

        protected AudioInfo(Parcel parcel) {
            this.f46184a = parcel.readInt();
            this.f46185b = parcel.readString();
            this.f46186c = parcel.readLong();
            this.f46187d = parcel.readString();
            this.f46188e = parcel.readString();
            this.f46189f = parcel.readLong();
            this.f46190g = parcel.readLong();
            this.f46191h = parcel.readString();
            this.f46192i = parcel.readString();
            this.j = parcel.readLong();
            this.k = parcel.readLong();
            this.l = parcel.readLong();
            this.m = parcel.readString();
            this.n = parcel.readString();
            this.o = parcel.readLong();
            this.p = parcel.readString();
            this.q = parcel.readString();
            this.r = parcel.readString();
            this.s = parcel.readInt();
            this.t = parcel.readInt();
            this.u = parcel.readInt();
            this.v = parcel.readInt();
            this.w = parcel.readInt();
            this.x = parcel.readInt();
            this.y = parcel.readInt();
        }

        public String toString() {
            return "AudioInfo{id=" + this.f46184a + ", data='" + this.f46185b + '\'' + ", size=" + this.f46186c + ", displayName='" + this.f46187d + '\'' + ", title='" + this.f46188e + '\'' + ", dateAdded=" + this.f46189f + ", dateModified=" + this.f46190g + ", mimeType='" + this.f46191h + '\'' + ", titleKey='" + this.f46192i + '\'' + ", duration=" + this.j + ", bookmark=" + this.k + ", artistId=" + this.l + ", artist='" + this.m + '\'' + ", artistKey='" + this.n + '\'' + ", albumId=" + this.o + ", album='" + this.q + '\'' + ", albumKey='" + this.r + '\'' + ", track=" + this.s + ", year=" + this.t + ", isMusic=" + this.u + ", isPodcast=" + this.v + ", isRingtone=" + this.w + ", isAlarm=" + this.x + ", isNotification=" + this.y + '}';
        }

        public void writeToParcel(Parcel parcel, int i2) {
            parcel.writeInt(this.f46184a);
            parcel.writeString(this.f46185b);
            parcel.writeLong(this.f46186c);
            parcel.writeString(this.f46187d);
            parcel.writeString(this.f46188e);
            parcel.writeLong(this.f46189f);
            parcel.writeLong(this.f46190g);
            parcel.writeString(this.f46191h);
            parcel.writeString(this.f46192i);
            parcel.writeLong(this.j);
            parcel.writeLong(this.k);
            parcel.writeLong(this.l);
            parcel.writeString(this.m);
            parcel.writeString(this.n);
            parcel.writeLong(this.o);
            parcel.writeString(this.p);
            parcel.writeString(this.q);
            parcel.writeString(this.r);
            parcel.writeInt(this.s);
            parcel.writeInt(this.t);
            parcel.writeInt(this.u);
            parcel.writeInt(this.v);
            parcel.writeInt(this.w);
            parcel.writeInt(this.x);
            parcel.writeInt(this.y);
        }
    }

    public static class a extends RecyclerView.v {

        /* renamed from: a  reason: collision with root package name */
        TextView f46193a;

        /* renamed from: b  reason: collision with root package name */
        TextView f46194b;

        /* renamed from: c  reason: collision with root package name */
        ImageView f46195c;

        /* renamed from: d  reason: collision with root package name */
        View f46196d;

        /* renamed from: e  reason: collision with root package name */
        View f46197e;

        /* renamed from: f  reason: collision with root package name */
        public CircleProgressPlayButton f46198f;

        /* renamed from: g  reason: collision with root package name */
        ViewGroup f46199g;

        /* renamed from: h  reason: collision with root package name */
        AudioInfo f46200h;

        public a(View view) {
            super(view);
            this.f46193a = (TextView) view.findViewById(R.id.tv_artist);
            this.f46194b = (TextView) view.findViewById(R.id.tv_duration);
            this.f46195c = (ImageView) view.findViewById(R.id.thumbnail);
            this.f46196d = view.findViewById(R.id.icon_checked);
            this.f46198f = (CircleProgressPlayButton) view.findViewById(R.id.play_button);
            this.f46199g = (ViewGroup) view.findViewById(R.id.play_button_wrap);
            this.f46197e = view;
        }
    }

    public AudioListAdapter(List<AudioInfo> list, Context context) {
        this.f46172a = list;
        this.f46176e = context;
        exfilepicker.a.b.a(this.f46172a, this.f46177f, (b.a) null);
    }

    public final int getItemCount() {
        return this.f46172a.size();
    }

    public final boolean a(int i2) {
        return this.f46173b.contains(this.f46172a.get(i2));
    }

    public final void a(final String str) {
        this.f46172a.clear();
        exfilepicker.a.b.a(this.f46177f, this.f46172a, (b.a) null);
        if (!TextUtils.isEmpty(str)) {
            exfilepicker.a.b.a(this.f46172a, new b.a<AudioInfo>() {
                public final /* synthetic */ boolean a(Object obj) {
                    return ((AudioInfo) obj).f46188e.toUpperCase().indexOf(str.toUpperCase()) == -1;
                }
            });
        }
        notifyDataSetChanged();
    }

    public final void b() {
        this.f46175d.b();
        a();
    }

    public final /* synthetic */ RecyclerView.v onCreateViewHolder(ViewGroup viewGroup, int i2) {
        final a aVar = new a(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.chat_local_audio_list_item, viewGroup, false));
        aVar.f46198f.f46231a = this.f46175d;
        aVar.f46199g.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                if (FastClickUtil.isFastClick()) {
                    CircleProgressPlayButton.a aVar = AudioListAdapter.this.f46175d;
                    String a2 = aVar.f46200h.f46185b;
                    a aVar2 = aVar;
                    if (!a2.equals(aVar.f46247e)) {
                        aVar.b();
                        aVar.f46250h = aVar2;
                        aVar.f46247e = a2;
                        try {
                            if (aVar.f46249g != null) {
                                aVar.f46249g.release();
                            }
                            aVar.f46249g = new MediaPlayer();
                            aVar.f46249g.setDataSource(a2);
                            aVar.f46249g.prepare();
                        } catch (Exception unused) {
                        }
                        aVar.a();
                    } else if (aVar.f46248f.equals(CircleProgressPlayButton.a.f46244b)) {
                        aVar.c();
                    } else {
                        aVar.a();
                    }
                }
            }
        });
        aVar.f46197e.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                if (FastClickUtil.isFastClick()) {
                    int adapterPosition = aVar.getAdapterPosition();
                    AudioListAdapter audioListAdapter = AudioListAdapter.this;
                    boolean z = !audioListAdapter.a(adapterPosition);
                    AudioInfo audioInfo = audioListAdapter.f46172a.get(adapterPosition);
                    int i2 = 0;
                    if (!z) {
                        audioListAdapter.f46173b.remove(audioInfo);
                    } else if (audioInfo.f46186c > 20971520) {
                        ToastUtil.showMsg(audioListAdapter.f46176e.getString(R.string.chat_module_error_gif, new Object[]{"20"}));
                    } else {
                        audioListAdapter.f46173b.add(audioInfo);
                    }
                    View view2 = aVar.f46196d;
                    if (!AudioListAdapter.this.a(adapterPosition)) {
                        i2 = 4;
                    }
                    view2.setVisibility(i2);
                    AudioListAdapter.this.a();
                }
            }
        });
        return aVar;
    }
}
