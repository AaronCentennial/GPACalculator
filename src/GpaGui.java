import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/*
 * Created by Aaron Fernandes(300773526) on November 2015.
 */
public class GpaGui extends JFrame implements ActionListener {
	private JPanel _contentPane;
	private JLabel _hrsEarnedLbl;
	private JTextField _creditHrsTxt;
	private JLabel _currentGPA;
	private JTextField _curGPATxt;
	private JComboBox _courses;
	private JLabel _courseLbl;
	private JPanel _creditPanel;
	private JButton _calculateBtn;
	private JLabel _gpaTotalTxt;
	private JButton _exitBtn;

	GpaGui(){
		super("GPA Calculator");
		this._initFrame();
		this._addActionListeners();
	}

	private void _initFrame() {
		setContentPane(this._contentPane);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(700,600);
		setLocation(400,100);
		setVisible(true);
	}

	private void _addActionListeners() {
		_exitBtn.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent actionEvent) {

		if (actionEvent.getSource()==this._exitBtn){
			System.exit(0);
		}

	}
}
