package android.support.v4.media.session;

import android.media.AudioAttributes;
import android.media.MediaMetadata;
import android.media.session.MediaController;
import android.media.session.MediaSession;
import android.media.session.PlaybackState;
import android.os.Bundle;
import java.util.List;

final class c {

    public interface a {
        void a();

        void a(int i2, int i3, int i4, int i5, int i6);

        void a(Object obj);

        void a(List<?> list);

        void b();

        void b(Object obj);

        void c();

        void d();
    }

    static class b<T extends a> extends MediaController.Callback {

        /* renamed from: a  reason: collision with root package name */
        protected final T f909a;

        public b(T t) {
            this.f909a = t;
        }

        public final void onSessionDestroyed() {
            this.f909a.a();
        }

        public final void onSessionEvent(String str, Bundle bundle) {
            MediaSessionCompat.a(bundle);
            this.f909a.b();
        }

        public final void onPlaybackStateChanged(PlaybackState playbackState) {
            this.f909a.a((Object) playbackState);
        }

        public final void onMetadataChanged(MediaMetadata mediaMetadata) {
            this.f909a.b(mediaMetadata);
        }

        public final void onQueueChanged(List<MediaSession.QueueItem> list) {
            this.f909a.a((List<?>) list);
        }

        public final void onQueueTitleChanged(CharSequence charSequence) {
            this.f909a.c();
        }

        public final void onExtrasChanged(Bundle bundle) {
            MediaSessionCompat.a(bundle);
            this.f909a.d();
        }

        public final void onAudioInfoChanged(MediaController.PlaybackInfo playbackInfo) {
            int i2;
            T t = this.f909a;
            int playbackType = playbackInfo.getPlaybackType();
            AudioAttributes audioAttributes = playbackInfo.getAudioAttributes();
            if ((audioAttributes.getFlags() & 1) != 1) {
                if ((audioAttributes.getFlags() & 4) != 4) {
                    switch (audioAttributes.getUsage()) {
                        case 2:
                            i2 = 0;
                            break;
                        case 3:
                            i2 = 8;
                            break;
                        case 4:
                            i2 = 4;
                            break;
                        case 5:
                        case 7:
                        case 8:
                        case 9:
                        case 10:
                            i2 = 5;
                            break;
                        case 6:
                            i2 = 2;
                            break;
                        case 13:
                            i2 = 1;
                            break;
                        default:
                            i2 = 3;
                            break;
                    }
                } else {
                    i2 = 6;
                }
            } else {
                i2 = 7;
            }
            t.a(playbackType, i2, playbackInfo.getVolumeControl(), playbackInfo.getMaxVolume(), playbackInfo.getCurrentVolume());
        }
    }
}
