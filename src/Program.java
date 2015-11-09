import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;


/*
 * Created by Aaron Fernandes(300773526) on November 2015.
 */


public class Program {
	public static void main(String[] args){
		System.out.print(System.getProperties().get("os.name"));

		for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
			if ("GTK+".equals(info.getName()) || "windows".equals(info.getName()) || "substance".equals(info.getName())) {
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
			}
		}


		new GpaGui();
	}
}
