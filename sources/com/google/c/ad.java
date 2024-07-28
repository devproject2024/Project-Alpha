package com.google.c;

import java.io.IOException;

public class ad extends IOException {
    private static final long serialVersionUID = -1616151763072450476L;
    private at unfinishedMessage = null;

    public ad(String str) {
        super(str);
    }

    public ad(IOException iOException) {
        super(iOException.getMessage(), iOException);
    }

    public ad(String str, IOException iOException) {
        super(str, iOException);
    }

    public ad setUnfinishedMessage(at atVar) {
        this.unfinishedMessage = atVar;
        return this;
    }

    public at getUnfinishedMessage() {
        return this.unfinishedMessage;
    }

    public IOException unwrapIOException() {
        return getCause() instanceof IOException ? (IOException) getCause() : this;
    }

    static ad truncatedMessage() {
        return new ad("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
    }

    static ad negativeSize() {
        return new ad("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
    }

    static ad malformedVarint() {
        return new ad("CodedInputStream encountered a malformed varint.");
    }

    static ad invalidTag() {
        return new ad("Protocol message contained an invalid tag (zero).");
    }

    static ad invalidEndTag() {
        return new ad("Protocol message end-group tag did not match expected tag.");
    }

    static a invalidWireType() {
        return new a("Protocol message tag had invalid wire type.");
    }

    public static class a extends ad {
        private static final long serialVersionUID = 3283890091615336259L;

        public a(String str) {
            super(str);
        }
    }

    static ad recursionLimitExceeded() {
        return new ad("Protocol message had too many levels of nesting.  May be malicious.  Use CodedInputStream.setRecursionLimit() to increase the depth limit.");
    }

    static ad sizeLimitExceeded() {
        return new ad("Protocol message was too large.  May be malicious.  Use CodedInputStream.setSizeLimit() to increase the size limit.");
    }

    static ad parseFailure() {
        return new ad("Failed to parse the message.");
    }

    static ad invalidUtf8() {
        return new ad("Protocol message had invalid UTF-8.");
    }
}
