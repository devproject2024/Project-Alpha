package net.one97.paytm.nativesdk.common.model;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.SOURCE)
public @interface ONECLICKTYPE {
    public static final Companion Companion = Companion.$$INSTANCE;
    public static final int ENROLLMENT_DEAD = 103;
    public static final int ENROLLMENT_FAILED = 102;
    public static final int ENROLLMENT_LIVE = 105;
    public static final int ENROLLMENT_LIVE_STEP_UP = 104;
    public static final int ENROLLMENT_NOT_REQUESTED = 100;
    public static final int ENROLLMENT_SUCCESS = 101;
    public static final int UNKNOWN = 106;

    public static final class Companion {
        static final /* synthetic */ Companion $$INSTANCE = new Companion();
        public static final int ENROLLMENT_DEAD = 103;
        public static final int ENROLLMENT_FAILED = 102;
        public static final int ENROLLMENT_LIVE = 105;
        public static final int ENROLLMENT_LIVE_STEP_UP = 104;
        public static final int ENROLLMENT_NOT_REQUESTED = 100;
        public static final int ENROLLMENT_SUCCESS = 101;
        public static final int UNKNOWN = 106;

        private Companion() {
        }
    }
}
