package javacard.framework;

/*
 * Copyright (c) 2013 Yubico AB
 * All rights reserved.
 */

import java.util.Arrays;

public class Util {
	public static short setShort(byte[] buf, short off, short val) {
		buf[off] = (byte) (val >>> 8);
		buf[off + 1] = (byte) val;
		return (short) (off + 2);
	}
	
	public static short arrayCopyNonAtomic(byte[] src, short srcOff, byte[] dest, short destOff,
            short length) throws ArrayIndexOutOfBoundsException, NullPointerException {
		System.arraycopy(src, srcOff, dest, destOff, length);
		return (short) (destOff + length);
	}
	
	public static short arrayCopy(byte[] src, short srcOff, byte[] dest, short destOff, short length)
			throws ArrayIndexOutOfBoundsException, NullPointerException {
		System.arraycopy(src, srcOff, dest, destOff, length);
		return (short) (destOff + length);
	}
	
    public static short makeShort(byte b1, byte b2) {
        return (short) ((b1 << 8) + (b2 & 0xFF));
    }
    
    public static short arrayFillNonAtomic(byte[] bArray, short bOff, short bLen, byte bValue) {
    	Arrays.fill(bArray, bOff, bOff + bLen, bValue);
    	return (short) (bOff + bLen);
    }
    
    public static byte arrayCompare(byte[] src, short srcOff, byte[] dest, short destOff, short length) {
    	if(srcOff + length > src.length || destOff + length > dest.length) {
    		throw new ArrayIndexOutOfBoundsException();
    	}
    	for(int i = 0; i < length; i++) {
    		short thisSrc = (short) (src[srcOff + i] & 0x00ff);
    		short thisDest = (short) (dest[destOff + i] & 0x00ff);
    		if(thisSrc > thisDest) {
    			return 1;
    		} else if(thisSrc < thisDest) {
    			return -1;
    		}
    	}
    	return 0;
    }
}
