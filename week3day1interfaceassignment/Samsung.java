package week3.week3day1interfaceassignment;

public class Samsung extends AndroidTV {

	@Override
	public void playVideo() {
	System.out.println("Play Video --> Concrete class");
		
	}
public static void main(String[] args) {
	Samsung sam = new Samsung();
	sam.openApp();
	sam.playVideo();
}
}
