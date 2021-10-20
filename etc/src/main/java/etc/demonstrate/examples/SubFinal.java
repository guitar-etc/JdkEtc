package etc.demonstrate.examples;

public final class SubFinal extends Base implements SuperSibling2 {
	@Override
	public String say() {
		return super.say() + " I'm SubFinal";
	}
	
	public int number() {
		return 2;
	}
	
	@Override
	public String super2Method() {
		return super.super2Method() + " in SubFinal";
	}
}
