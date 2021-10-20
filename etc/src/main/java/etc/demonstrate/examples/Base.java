package etc.demonstrate.examples;

public class Base implements Super, SuperSibling {
	public String say() {
		return "I'm Base";
	}

	@Override
	public String super2Method() {
		return "super2Method in Base";
	}

	@Override
	public String superSiblingMethod() {
		return "superSiblingMethod in Base";
	}
}
