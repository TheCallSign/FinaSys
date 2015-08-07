/*
 * Distributed under GPLv3 License.
 * Copyright (c) St John Giddy
 */
package tools;

import java.math.BigInteger;

/**
 *
 * @author St John Giddy
 */
public class Hash {

    private final byte[] bytes;

    public Hash(byte[] bytes) {
        this.bytes = bytes;
    }

    public byte[] getBytes() {
        return bytes;
    }

    @Override
    public String toString() {
        return new BigInteger(1, bytes).toString(16);
    }

}
