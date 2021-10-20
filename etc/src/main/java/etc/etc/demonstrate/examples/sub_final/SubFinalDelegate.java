package etc.etc.demonstrate.examples.sub_final;

import etc.demonstrate.examples.*;

/**
 * Delegate class extends the super's Delegate class to inherit new or modified behaviors.
 * Any new or modified logic will be implemented in this class.
 * 
 * @author pycs9
 *
 */
public class SubFinalDelegate extends _SubFinalDelegate implements EtcSubFinal {
	public SubFinalDelegate(SubFinal base) {
		super(base);
	}

	@Override
	protected SubFinal createDelegateDelegateForInit() {
		// return null if target class is final.
		return null;
	}

	@Override
	public int number() {
		return super.number() + 1000;
	}
}