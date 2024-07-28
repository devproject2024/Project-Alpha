package com.google.c;

import com.google.c.at;

public abstract class b<MessageType extends at> implements bd<MessageType> {

    /* renamed from: a  reason: collision with root package name */
    private static final r f37743a = r.a();

    private MessageType b(j jVar, r rVar) throws ad {
        MessageType messagetype;
        try {
            k newCodedInput = jVar.newCodedInput();
            messagetype = (at) a(newCodedInput, rVar);
            newCodedInput.a(0);
            return messagetype;
        } catch (ad e2) {
            throw e2.setUnfinishedMessage(messagetype);
        } catch (ad e3) {
            throw e3;
        }
    }

    public final /* synthetic */ Object a(j jVar, r rVar) throws ad {
        bs bsVar;
        at b2 = b(jVar, rVar);
        if (b2 == null || b2.i()) {
            return b2;
        }
        if (b2 instanceof a) {
            bsVar = ((a) b2).e();
        } else {
            bsVar = new bs(b2);
        }
        throw bsVar.asInvalidProtocolBufferException().setUnfinishedMessage(b2);
    }
}
