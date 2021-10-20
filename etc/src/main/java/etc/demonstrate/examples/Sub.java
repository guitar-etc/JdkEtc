package etc.demonstrate.examples;

public class Sub extends Base implements SuperSibling2 {
	@Override
	public String say() {
		return super.say() + " I'm Sub";
	}
	
	public int number() {
		return 2;
	}
	
	@Override
	public String super2Method() {
		return super.super2Method() + " in Sub";
	}
}
