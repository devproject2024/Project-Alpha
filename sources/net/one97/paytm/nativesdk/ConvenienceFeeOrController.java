package net.one97.paytm.nativesdk;

import kotlin.g.b.g;
import kotlin.g.b.k;

public final class ConvenienceFeeOrController extends ConvenienceFeeController {
    public static final Companion Companion = new Companion((g) null);
    /* access modifiers changed from: private */
    public static ConvenienceFeeOrController INSTANCE;

    public static final void destroyInstance() {
        Companion.destroyInstance();
    }

    public static final ConvenienceFeeOrController getInstance() {
        return Companion.getInstance();
    }

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(g gVar) {
            this();
        }

        public final ConvenienceFeeOrController getInstance() {
            if (ConvenienceFeeOrController.INSTANCE == null) {
                ConvenienceFeeOrController.INSTANCE = new ConvenienceFeeOrController();
            }
            ConvenienceFeeOrController access$getINSTANCE$cp = ConvenienceFeeOrController.INSTANCE;
            if (access$getINSTANCE$cp == null) {
                k.a();
            }
            return access$getINSTANCE$cp;
        }

        public final void destroyInstance() {
            ConvenienceFeeOrController.INSTANCE = null;
        }
    }
}
