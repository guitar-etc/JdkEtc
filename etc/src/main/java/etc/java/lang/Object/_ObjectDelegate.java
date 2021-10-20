package etc.java.lang.Object;

import static java.util.Objects.*;

abstract class _ObjectDelegate {
	private Object impl;
	
	/**
	 * Current usecase: If target class is final, delegateDelegate should be null and if so, return impl. otherwise return null.
	 * 
	 * Operations made on this impl object will not go through the delegates.
	 * @return
	 */
	public Object impl() {
		if (delegateDelegate != null) {
			throw new UnsupportedOperationException("use unEtc()");
		}
		return impl;
	}

	private Object delegateDelegate;

	public Object unEtc() {
		if (delegateDelegate == null) {
			throw new UnsupportedOperationException("use impl()");
		}
		return delegateDelegate;
	}

	public _ObjectDelegate(Object impl) {
		this.impl = requireNonNull(impl);
		// not null checking for protected method.
		// Also, for target class that is final, I can't create a DelegateDelegate.
		this.delegateDelegate = createDelegateDelegateForInit();
	}

	protected abstract Object createDelegateDelegateForInit();

	@Override
	public int hashCode() {
		return impl.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		return this.impl.equals(obj);
	}

	@Override
	public String toString() {
		return getClass().getSimpleName() + " [impl=" + impl + "]";
	}
	
}