package org.apache.xml.security.encryption;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.xml.security.transforms.Transforms;

public class XMLCipher {

    /* renamed from: a  reason: collision with root package name */
    static Class f72614a;

    /* renamed from: b  reason: collision with root package name */
    private static Log f72615b;

    /* renamed from: org.apache.xml.security.encryption.XMLCipher$1  reason: invalid class name */
    class AnonymousClass1 {
    }

    class Factory {

        class AgreementMethodImpl implements AgreementMethod {
        }

        class CipherDataImpl implements CipherData {
        }

        class CipherReferenceImpl implements CipherReference {
        }

        class CipherValueImpl implements CipherValue {
        }

        class EncryptedDataImpl extends EncryptedTypeImpl implements EncryptedData {
        }

        class EncryptedKeyImpl extends EncryptedTypeImpl implements EncryptedKey {
        }

        abstract class EncryptedTypeImpl {
        }

        class EncryptionMethodImpl implements EncryptionMethod {
        }

        class EncryptionPropertiesImpl implements EncryptionProperties {
        }

        class EncryptionPropertyImpl implements EncryptionProperty {
        }

        class ReferenceListImpl implements ReferenceList {

            class DataReference extends ReferenceImpl {
            }

            class KeyReference extends ReferenceImpl {
            }

            abstract class ReferenceImpl implements Reference {
            }
        }

        class TransformsImpl extends Transforms implements Transforms {
            public String d() {
                return "http://www.w3.org/2001/04/xmlenc#";
            }
        }
    }

    class Serializer {
    }

    static {
        Class cls = f72614a;
        if (cls == null) {
            cls = a("org.apache.xml.security.encryption.XMLCipher");
            f72614a = cls;
        }
        f72615b = LogFactory.getLog(cls.getName());
    }

    static Class a(String str) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e2) {
            throw new NoClassDefFoundError().initCause(e2);
        }
    }
}
