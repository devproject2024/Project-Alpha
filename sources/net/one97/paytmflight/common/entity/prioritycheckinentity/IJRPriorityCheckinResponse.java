package net.one97.paytmflight.common.entity.prioritycheckinentity;

import com.paytm.network.model.IJRPaytmDataModel;
import kotlin.g.b.g;
import kotlin.g.b.k;

public final class IJRPriorityCheckinResponse extends IJRPaytmDataModel {
    private Body body;
    private Integer code;
    private String error;
    private Meta meta;
    private Status status;

    public IJRPriorityCheckinResponse() {
        this((String) null, (Status) null, (Body) null, (Integer) null, (Meta) null, 31, (g) null);
    }

    public IJRPriorityCheckinResponse(String str, Status status2, Body body2, Integer num, Meta meta2) {
        this.error = str;
        this.status = status2;
        this.body = body2;
        this.code = num;
        this.meta = meta2;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ IJRPriorityCheckinResponse(java.lang.String r5, net.one97.paytmflight.common.entity.prioritycheckinentity.IJRPriorityCheckinResponse.Status r6, net.one97.paytmflight.common.entity.prioritycheckinentity.IJRPriorityCheckinResponse.Body r7, java.lang.Integer r8, net.one97.paytmflight.common.entity.prioritycheckinentity.IJRPriorityCheckinResponse.Meta r9, int r10, kotlin.g.b.g r11) {
        /*
            r4 = this;
            r11 = r10 & 1
            r0 = 0
            if (r11 == 0) goto L_0x0007
            r11 = r0
            goto L_0x0008
        L_0x0007:
            r11 = r5
        L_0x0008:
            r5 = r10 & 2
            if (r5 == 0) goto L_0x000e
            r1 = r0
            goto L_0x000f
        L_0x000e:
            r1 = r6
        L_0x000f:
            r5 = r10 & 4
            if (r5 == 0) goto L_0x0015
            r2 = r0
            goto L_0x0016
        L_0x0015:
            r2 = r7
        L_0x0016:
            r5 = r10 & 8
            if (r5 == 0) goto L_0x001c
            r3 = r0
            goto L_0x001d
        L_0x001c:
            r3 = r8
        L_0x001d:
            r5 = r10 & 16
            if (r5 == 0) goto L_0x0023
            r10 = r0
            goto L_0x0024
        L_0x0023:
            r10 = r9
        L_0x0024:
            r5 = r4
            r6 = r11
            r7 = r1
            r8 = r2
            r9 = r3
            r5.<init>(r6, r7, r8, r9, r10)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.one97.paytmflight.common.entity.prioritycheckinentity.IJRPriorityCheckinResponse.<init>(java.lang.String, net.one97.paytmflight.common.entity.prioritycheckinentity.IJRPriorityCheckinResponse$Status, net.one97.paytmflight.common.entity.prioritycheckinentity.IJRPriorityCheckinResponse$Body, java.lang.Integer, net.one97.paytmflight.common.entity.prioritycheckinentity.IJRPriorityCheckinResponse$Meta, int, kotlin.g.b.g):void");
    }

    public final Body getBody() {
        return this.body;
    }

    public final Integer getCode() {
        return this.code;
    }

    public final String getError() {
        return this.error;
    }

    public final Meta getMeta() {
        return this.meta;
    }

    public final Status getStatus() {
        return this.status;
    }

    public final void setBody(Body body2) {
        this.body = body2;
    }

    public final void setCode(Integer num) {
        this.code = num;
    }

    public final void setError(String str) {
        this.error = str;
    }

    public final void setMeta(Meta meta2) {
        this.meta = meta2;
    }

    public final void setStatus(Status status2) {
        this.status = status2;
    }

    public static final class Status extends IJRPaytmDataModel {
        private final Message message;
        private final String result;

        public Status(String str, Message message2) {
            k.c(str, "result");
            k.c(message2, "message");
            this.result = str;
            this.message = message2;
        }

        public final Message getMessage() {
            return this.message;
        }

        public final String getResult() {
            return this.result;
        }
    }

    public static final class Message extends IJRPaytmDataModel {
        private final String message;
        private final String title;

        public Message(String str, String str2) {
            k.c(str, "title");
            k.c(str2, "message");
            this.title = str;
            this.message = str2;
        }

        public final String getMessage() {
            return this.message;
        }

        public final String getTitle() {
            return this.title;
        }
    }

    public static final class Body extends IJRPaytmDataModel {
        private final boolean is_valid_booking;

        public Body(boolean z) {
            this.is_valid_booking = z;
        }

        public final boolean is_valid_booking() {
            return this.is_valid_booking;
        }
    }

    public static final class Meta extends IJRPaytmDataModel {
        private final Object any;

        public Meta(Object obj) {
            k.c(obj, "any");
            this.any = obj;
        }

        public final Object getAny() {
            return this.any;
        }
    }
}
