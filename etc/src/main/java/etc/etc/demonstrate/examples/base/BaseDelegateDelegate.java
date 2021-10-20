package etc.etc.demonstrate.examples.base;

/**
 * DelegateDelegate class that extends the Original Type and redirects the method call to the Delegate.
 * This is to inherit super's Etc's behavior. DelegateDelegate already inherits the Original Type so it cannot inherit one more.
 * 
 * This class will be used if the EtcBase needs to be of type Base.
 * 
 * @author pycs9
 *
 */
// Do I need this?
// I decided to not add any new methods to DelegateDelegate so there doesn't seem to be good use for this.
public class BaseDelegateDelegate extends _BaseDelegateDelegate {
	public BaseDelegateDelegate(BaseDelegate delegate) {
		super(delegate);
	}
}