package etc.demonstrate.examples;

public interface Super2 {
	public String super2Method();
	
	public class Super2Impl implements Super2 {

		@Override
		public String super2Method() {
			return "I'm Super 2 Impl";
		}
		
	}
	
	public class Super2Impl2 implements Super2 {

		@Override
		public String super2Method() {
			return "I'm Super 2 Impl 2";
		}
		
	}
}
