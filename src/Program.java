import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;


/*
 * Created by Aaron Fernandes(300773526) on November 2015.
 */


public class Program {
	public static void main(String[] args){
		_nativeLookAndFeel();
		new GpaGui();
	}

	/*
		Sets the native look
	 */
	private static void _nativeLookAndFeel() {
		System.out.print("{{OS NAME: "+System.getProperties().get("os.name")+"}}\n");

		for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
			System.out.print(info.toString()+"\n");
			if ("GTK+".equals(info.getName()) || "Windows".equals(info.getName()) || "Quaqua".equals(info.getName()) || "Macintosh".equals(info.getName())) {
				//"Nimbus".equals(info.getName())
				try {
					UIManager.setLookAndFeel(info.getClassName());
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				} catch (InstantiationException e) {
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					e.printStackTrace();
				} catch (UnsupportedLookAndFeelException e) {
					e.printStackTrace();
				}
				break;
			}//if
		}//loop
	}//native look and feel
}//class25888
