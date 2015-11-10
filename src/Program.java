import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;


/*
 * Created by Aaron Fernandes(300773526) on November 2015.
 */


public class Program {
	public static void main(String[] args){

		// [CurentGPA x CurrentCreditHours + (collum CREDIT x grades)] / [CurrentCreditHours+collum creddit hours]
		System.out.print(System.getProperties().get("os.name"));

		for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
			System.out.print(info.toString()+"\n");
			if ("GTK+".equals(info.getName()) || "Windows".equals(info.getName()) || "Aqua".equals(info.getName()) || "substance".equals(info.getName())) {
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
			}
		}


		new GpaGui();
	}
}
