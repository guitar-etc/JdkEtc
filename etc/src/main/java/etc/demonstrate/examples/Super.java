package etc.demonstrate.examples;

public interface Super extends Super2 {
	public default String speak() {
		return "Speaking as Super";
	}
	
	class Raw implements Super {
		@Override
		public String super2Method() {
			return "super2Method in Super.Raw";
		}
	}
	
	class Impl implements Super {
		@Override
		public String speak() {
			return Super.super.speak() + "'s Impl";
		}

		@Override
		public String super2Method() {
			return "super2Method in Super.Impl";
		}
	}
}
