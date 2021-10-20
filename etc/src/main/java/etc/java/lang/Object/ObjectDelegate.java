package etc.java.lang.Object;

public class ObjectDelegate extends _ObjectDelegate implements EtcObject {
	public ObjectDelegate(Object impl) {
		super(impl);
	}

	/**
	 * Should never return null.
	 * 
	 * @return
	 */
	protected Object createDelegateDelegateForInit() {
		return new ObjectDelegateDelegate(this);
	}
}