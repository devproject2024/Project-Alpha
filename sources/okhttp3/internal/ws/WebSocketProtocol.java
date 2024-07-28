package okhttp3.internal.ws;

import i.c;
import i.f;

public final class WebSocketProtocol {
    static final String ACCEPT_MAGIC = "258EAFA5-E914-47DA-95CA-C5AB0DC85B11";
    static final int B0_FLAG_FIN = 128;
    static final int B0_FLAG_RSV1 = 64;
    static final int B0_FLAG_RSV2 = 32;
    static final int B0_FLAG_RSV3 = 16;
    static final int B0_MASK_OPCODE = 15;
    static final int B1_FLAG_MASK = 128;
    static final int B1_MASK_LENGTH = 127;
    static final int CLOSE_CLIENT_GOING_AWAY = 1001;
    static final long CLOSE_MESSAGE_MAX = 123;
    static final int CLOSE_NO_STATUS_CODE = 1005;
    static final int OPCODE_BINARY = 2;
    static final int OPCODE_CONTINUATION = 0;
    static final int OPCODE_CONTROL_CLOSE = 8;
    static final int OPCODE_CONTROL_PING = 9;
    static final int OPCODE_CONTROL_PONG = 10;
    static final int OPCODE_FLAG_CONTROL = 8;
    static final int OPCODE_TEXT = 1;
    static final long PAYLOAD_BYTE_MAX = 125;
    static final int PAYLOAD_LONG = 127;
    static final int PAYLOAD_SHORT = 126;
    static final long PAYLOAD_SHORT_MAX = 65535;

    static void toggleMask(c.a aVar, byte[] bArr) {
        int i2;
        int length = bArr.length;
        int i3 = 0;
        do {
            byte[] bArr2 = aVar.f46283d;
            int i4 = aVar.f46284e;
            int i5 = aVar.f46285f;
            while (i4 < i5) {
                int i6 = i3 % length;
                bArr2[i4] = (byte) (bArr2[i4] ^ bArr[i6]);
                i4++;
                i3 = i6 + 1;
            }
            if (aVar.f46282c == aVar.f46280a.f46277b) {
                throw new IllegalStateException();
            } else if (aVar.f46282c == -1) {
                i2 = aVar.a(0);
            } else {
                i2 = aVar.a(aVar.f46282c + ((long) (aVar.f46285f - aVar.f46284e)));
            }
        } while (i2 != -1);
    }

    static String closeCodeExceptionMessage(int i2) {
        if (i2 < 1000 || i2 >= 5000) {
            return "Code must be in range [1000,5000): ".concat(String.valueOf(i2));
        }
        if ((i2 < 1004 || i2 > 1006) && (i2 < 1012 || i2 > 2999)) {
            return null;
        }
        return "Code " + i2 + " is reserved and may not be used.";
    }

    static void validateCloseCode(int i2) {
        String closeCodeExceptionMessage = closeCodeExceptionMessage(i2);
        if (closeCodeExceptionMessage != null) {
            throw new IllegalArgumentException(closeCodeExceptionMessage);
        }
    }

    public static String acceptHeader(String str) {
        return f.encodeUtf8(str + ACCEPT_MAGIC).sha1().base64();
    }

    private WebSocketProtocol() {
        throw new AssertionError("No instances.");
    }
}
