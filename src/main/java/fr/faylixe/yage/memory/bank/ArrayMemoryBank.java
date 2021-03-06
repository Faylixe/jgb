package fr.faylixe.yage.memory.bank;

import java.util.Arrays;

/**
 * Memory bank implementation using a simple
 * byte array as storage data structure.
 * 
 * @author fv
 */
public final class ArrayMemoryBank extends AbstractMemoryBank {
	
	/** Data this memory bank can hold. **/
	private final byte[] data;

	/**
	 * Default constructor.
	 * 
	 * @param size Size of this memory bank (in bytes).
	 * @param offset Starting address offset.
	 */
	public ArrayMemoryBank(final int size, final int offset) {
		super(size, offset);
		this.data = new byte[size];
	}

	/** {@inheritDoc} **/
	@Override
	public byte readByte(final int address) throws IllegalAccessException {
		verifyAddress(address);
		return data[address - getOffset()];
	}

	/** {@inheritDoc} **/
	@Override
	public byte[] readBytes(final int address, final int length) throws IllegalAccessException {
		verifyAddress(address);
		verifyAddress(address + length - 1);
		return Arrays.copyOfRange(data, address - getOffset(), length);
	}

	/** {@inheritDoc} **/
	@Override
	public void writeByte(final byte value, final int address) throws IllegalAccessException {
		verifyAddress(address);
		data[address - getOffset()] = value;
	}

	/** {@inheritDoc} **/
	@Override
	public void writeBytes(final byte[] values, final int address) throws IllegalAccessException {
		verifyAddress(address);
		verifyAddress(address + values.length - 1);
		System.arraycopy(values, 0, data, address - getOffset(), values.length);
	}

}
