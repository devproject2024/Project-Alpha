package android.support.v4.media.session;

import android.media.session.MediaSession;
import android.os.Build;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.ResultReceiver;
import android.support.v4.media.MediaDescriptionCompat;
import java.util.ArrayList;
import java.util.List;

public class MediaSessionCompat {
    public static void a(Bundle bundle) {
        if (bundle != null) {
            bundle.setClassLoader(MediaSessionCompat.class.getClassLoader());
        }
    }

    public static final class Token implements Parcelable {
        public static final Parcelable.Creator<Token> CREATOR = new Parcelable.Creator<Token>() {
            public final /* bridge */ /* synthetic */ Object[] newArray(int i2) {
                return new Token[i2];
            }

            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                Object obj;
                if (Build.VERSION.SDK_INT >= 21) {
                    obj = parcel.readParcelable((ClassLoader) null);
                } else {
                    obj = parcel.readStrongBinder();
                }
                return new Token(obj);
            }
        };

        /* renamed from: a  reason: collision with root package name */
        final Object f885a;

        /* renamed from: b  reason: collision with root package name */
        b f886b;

        /* renamed from: c  reason: collision with root package name */
        Bundle f887c;

        public final int describeContents() {
            return 0;
        }

        Token(Object obj) {
            this(obj, (b) null, (byte) 0);
        }

        private Token(Object obj, b bVar) {
            this(obj, bVar, (byte) 0);
        }

        private Token(Object obj, b bVar, byte b2) {
            this.f885a = obj;
            this.f886b = bVar;
            this.f887c = null;
        }

        public static Token a(Object obj) {
            return a(obj, (b) null);
        }

        public static Token a(Object obj, b bVar) {
            if (obj == null || Build.VERSION.SDK_INT < 21) {
                return null;
            }
            return new Token(d.a(obj), bVar);
        }

        public final void writeToParcel(Parcel parcel, int i2) {
            if (Build.VERSION.SDK_INT >= 21) {
                parcel.writeParcelable((Parcelable) this.f885a, i2);
            } else {
                parcel.writeStrongBinder((IBinder) this.f885a);
            }
        }

        public final int hashCode() {
            Object obj = this.f885a;
            if (obj == null) {
                return 0;
            }
            return obj.hashCode();
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Token)) {
                return false;
            }
            Token token = (Token) obj;
            Object obj2 = this.f885a;
            if (obj2 == null) {
                return token.f885a == null;
            }
            Object obj3 = token.f885a;
            if (obj3 == null) {
                return false;
            }
            return obj2.equals(obj3);
        }
    }

    public static final class QueueItem implements Parcelable {
        public static final Parcelable.Creator<QueueItem> CREATOR = new Parcelable.Creator<QueueItem>() {
            public final /* bridge */ /* synthetic */ Object[] newArray(int i2) {
                return new QueueItem[i2];
            }

            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                return new QueueItem(parcel);
            }
        };

        /* renamed from: a  reason: collision with root package name */
        private final MediaDescriptionCompat f881a;

        /* renamed from: b  reason: collision with root package name */
        private final long f882b;

        /* renamed from: c  reason: collision with root package name */
        private Object f883c;

        public final int describeContents() {
            return 0;
        }

        private QueueItem(Object obj, MediaDescriptionCompat mediaDescriptionCompat, long j) {
            if (mediaDescriptionCompat == null) {
                throw new IllegalArgumentException("Description cannot be null.");
            } else if (j != -1) {
                this.f881a = mediaDescriptionCompat;
                this.f882b = j;
                this.f883c = obj;
            } else {
                throw new IllegalArgumentException("Id cannot be QueueItem.UNKNOWN_ID");
            }
        }

        QueueItem(Parcel parcel) {
            this.f881a = MediaDescriptionCompat.CREATOR.createFromParcel(parcel);
            this.f882b = parcel.readLong();
        }

        public final void writeToParcel(Parcel parcel, int i2) {
            this.f881a.writeToParcel(parcel, i2);
            parcel.writeLong(this.f882b);
        }

        public static List<QueueItem> a(List<?> list) {
            QueueItem queueItem;
            if (list == null || Build.VERSION.SDK_INT < 21) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            for (Object next : list) {
                if (next == null || Build.VERSION.SDK_INT < 21) {
                    queueItem = null;
                } else {
                    MediaSession.QueueItem queueItem2 = (MediaSession.QueueItem) next;
                    queueItem = new QueueItem(next, MediaDescriptionCompat.a(queueItem2.getDescription()), queueItem2.getQueueId());
                }
                arrayList.add(queueItem);
            }
            return arrayList;
        }

        public final String toString() {
            return "MediaSession.QueueItem {Description=" + this.f881a + ", Id=" + this.f882b + " }";
        }
    }

    public static final class ResultReceiverWrapper implements Parcelable {
        public static final Parcelable.Creator<ResultReceiverWrapper> CREATOR = new Parcelable.Creator<ResultReceiverWrapper>() {
            public final /* bridge */ /* synthetic */ Object[] newArray(int i2) {
                return new ResultReceiverWrapper[i2];
            }

            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                return new ResultReceiverWrapper(parcel);
            }
        };

        /* renamed from: a  reason: collision with root package name */
        ResultReceiver f884a;

        public final int describeContents() {
            return 0;
        }

        ResultReceiverWrapper(Parcel parcel) {
            this.f884a = (ResultReceiver) ResultReceiver.CREATOR.createFromParcel(parcel);
        }

        public final void writeToParcel(Parcel parcel, int i2) {
            this.f884a.writeToParcel(parcel, i2);
        }
    }
}
