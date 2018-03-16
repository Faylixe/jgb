package fr.faylixe.jgb.memory.bank;


import static org.junit.jupiter.api.Assertions.assertThrows;

import static java.util.stream.IntStream.range;

import org.junit.jupiter.api.Test;

import fr.faylixe.jgb.memory.IMemoryBank;
import fr.faylixe.jgb.memory.IMemoryBankTest;

/**
 * Unit test case for the read only memory bank.
 * 
 * @author fv
 */
public final class ReadOnlyMemoryBankTest implements IMemoryBankTest {

	/** {@inheritDoc} **/
	@Override
	public IMemoryBank getTestMemoryBank() {
		final ReadOnlyMemoryBank bank = new ReadOnlyMemoryBank(
				TEST_SIZE,
				TEST_OFFSET);
		// TODO : Insert data layout into memory.
		return bank;
	}
	
	/**
	 * Performs a writing test for the given <tt>address</tt>.
	 * 
	 * @param address Target address to test writing for.
	 */
	private void verifyWriting(final int address) {
		performBankTest(
				bank -> assertThrows(
						IllegalAccessException.class,
						() -> bank.writeByte((byte) 0, address)));
	}

	/** Ensure writing is always throwing an error. **/
	@Test
	public void testWriting() {
		range(0, 10).forEach(this::verifyWriting);
	}

}