package android.support.v4.media.session;

import android.media.session.PlaybackState;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.List;

public final class PlaybackStateCompat implements Parcelable {
    public static final Parcelable.Creator<PlaybackStateCompat> CREATOR = new Parcelable.Creator<PlaybackStateCompat>() {
        public final /* bridge */ /* synthetic */ Object[] newArray(int i2) {
            return new PlaybackStateCompat[i2];
        }

        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new PlaybackStateCompat(parcel);
        }
    };

    /* renamed from: a  reason: collision with root package name */
    final int f893a;

    /* renamed from: b  reason: collision with root package name */
    final long f894b;

    /* renamed from: c  reason: collision with root package name */
    final long f895c;

    /* renamed from: d  reason: collision with root package name */
    final float f896d;

    /* renamed from: e  reason: collision with root package name */
    final long f897e;

    /* renamed from: f  reason: collision with root package name */
    final int f898f;

    /* renamed from: g  reason: collision with root package name */
    final CharSequence f899g;

    /* renamed from: h  reason: collision with root package name */
    final long f900h;

    /* renamed from: i  reason: collision with root package name */
    List<CustomAction> f901i;
    final long j;
    final Bundle k;
    private Object l;

    public final int describeContents() {
        return 0;
    }

    private PlaybackStateCompat(int i2, long j2, long j3, float f2, long j4, CharSequence charSequence, long j5, List<CustomAction> list, long j6, Bundle bundle) {
        this.f893a = i2;
        this.f894b = j2;
        this.f895c = j3;
        this.f896d = f2;
        this.f897e = j4;
        this.f898f = 0;
        this.f899g = charSequence;
        this.f900h = j5;
        this.f901i = new ArrayList(list);
        this.j = j6;
        this.k = bundle;
    }

    PlaybackStateCompat(Parcel parcel) {
        this.f893a = parcel.readInt();
        this.f894b = parcel.readLong();
        this.f896d = parcel.readFloat();
        this.f900h = parcel.readLong();
        this.f895c = parcel.readLong();
        this.f897e = parcel.readLong();
        this.f899g = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.f901i = parcel.createTypedArrayList(CustomAction.CREATOR);
        this.j = parcel.readLong();
        this.k = parcel.readBundle(MediaSessionCompat.class.getClassLoader());
        this.f898f = parcel.readInt();
    }

    public final String toString() {
        return "PlaybackState {" + "state=" + this.f893a + ", position=" + this.f894b + ", buffered position=" + this.f895c + ", speed=" + this.f896d + ", updated=" + this.f900h + ", actions=" + this.f897e + ", error code=" + this.f898f + ", error message=" + this.f899g + ", custom actions=" + this.f901i + ", active item id=" + this.j + "}";
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        parcel.writeInt(this.f893a);
        parcel.writeLong(this.f894b);
        parcel.writeFloat(this.f896d);
        parcel.writeLong(this.f900h);
        parcel.writeLong(this.f895c);
        parcel.writeLong(this.f897e);
        TextUtils.writeToParcel(this.f899g, parcel, i2);
        parcel.writeTypedList(this.f901i);
        parcel.writeLong(this.j);
        parcel.writeBundle(this.k);
        parcel.writeInt(this.f898f);
    }

    public static PlaybackStateCompat a(Object obj) {
        ArrayList arrayList;
        Object obj2 = obj;
        Bundle bundle = null;
        if (obj2 == null || Build.VERSION.SDK_INT < 21) {
            return null;
        }
        PlaybackState playbackState = (PlaybackState) obj2;
        List<PlaybackState.CustomAction> customActions = playbackState.getCustomActions();
        if (customActions != null) {
            ArrayList arrayList2 = new ArrayList(customActions.size());
            for (PlaybackState.CustomAction a2 : customActions) {
                arrayList2.add(CustomAction.a(a2));
            }
            arrayList = arrayList2;
        } else {
            arrayList = null;
        }
        if (Build.VERSION.SDK_INT >= 22) {
            bundle = playbackState.getExtras();
        }
        PlaybackStateCompat playbackStateCompat = new PlaybackStateCompat(playbackState.getState(), playbackState.getPosition(), playbackState.getBufferedPosition(), playbackState.getPlaybackSpeed(), playbackState.getActions(), playbackState.getErrorMessage(), playbackState.getLastPositionUpdateTime(), arrayList, playbackState.getActiveQueueItemId(), bundle);
        playbackStateCompat.l = obj2;
        return playbackStateCompat;
    }

    public static final class CustomAction implements Parcelable {
        public static final Parcelable.Creator<CustomAction> CREATOR = new Parcelable.Creator<CustomAction>() {
            public final /* bridge */ /* synthetic */ Object[] newArray(int i2) {
                return new CustomAction[i2];
            }

            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                return new CustomAction(parcel);
            }
        };

        /* renamed from: a  reason: collision with root package name */
        private final String f902a;

        /* renamed from: b  reason: collision with root package name */
        private final CharSequence f903b;

        /* renamed from: c  reason: collision with root package name */
        private final int f904c;

        /* renamed from: d  reason: collision with root package name */
        private final Bundle f905d;

        /* renamed from: e  reason: collision with root package name */
        private Object f906e;

        public final int describeContents() {
            return 0;
        }

        private CustomAction(String str, CharSequence charSequence, int i2, Bundle bundle) {
            this.f902a = str;
            this.f903b = charSequence;
            this.f904c = i2;
            this.f905d = bundle;
        }

        CustomAction(Parcel parcel) {
            this.f902a = parcel.readString();
            this.f903b = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
            this.f904c = parcel.readInt();
            this.f905d = parcel.readBundle(MediaSessionCompat.class.getClassLoader());
        }

        public final void writeToParcel(Parcel parcel, int i2) {
            parcel.writeString(this.f902a);
            TextUtils.writeToParcel(this.f903b, parcel, i2);
            parcel.writeInt(this.f904c);
            parcel.writeBundle(this.f905d);
        }

        public static CustomAction a(Object obj) {
            if (obj == null || Build.VERSION.SDK_INT < 21) {
                return null;
            }
            PlaybackState.CustomAction customAction = (PlaybackState.CustomAction) obj;
            CustomAction customAction2 = new CustomAction(customAction.getAction(), customAction.getName(), customAction.getIcon(), customAction.getExtras());
            customAction2.f906e = obj;
            return customAction2;
        }

        public final String toString() {
            return "Action:mName='" + this.f903b + ", mIcon=" + this.f904c + ", mExtras=" + this.f905d;
        }
    }
}
