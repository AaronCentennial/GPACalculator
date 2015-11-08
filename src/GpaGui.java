import javax.swing.*;
import java.awt.*;
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
	private JComboBox<String> _numCoursesCbx;
	private JLabel _courseLbl;
	private JButton _calculateBtn;
	private JLabel _gpaTotalTxt;
	private JButton _exitBtn;
	private JScrollPane _sceoolPane;
	private JLabel _nrLbl;
	private JLabel _courseCodeLbl;
	private JLabel _creditHrsLbl;
	private JLabel _qradeLbl;

	private JPanel _rowPanel;
	private JLabel _titleLbl;
	private GridLayout _grid;

	GpaGui(){
		super("GPA Calculator");
		this._initFrame();
		this._addActionListeners();
	}

	private void _initFrame() {
		setContentPane(this._contentPane);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setIconImage(new ImageIcon(getClass().getResource("/images/edit-text.png")).getImage());
		setMinimumSize(new Dimension(650,300));
		setSize(700,600);
		setLocation(400,100);
		setVisible(true);
	}

	private void _addActionListeners() {
		this._exitBtn.addActionListener(this);
		this._numCoursesCbx.addActionListener(this);
	}

	private void _addRows(int numRows){

		this._grid.setRows(numRows);
		for (int i=0; i<numRows; i++){
			this._rowPanel.add(new JLabel(i+". "));
		}
	}

	@Override
	public void actionPerformed(ActionEvent actionEvent) {

		if (actionEvent.getSource()==this._exitBtn){
			System.exit(0);
		}
		else if (actionEvent.getSource()==this._numCoursesCbx){
			try {
				int selected = Integer.parseInt(this._numCoursesCbx.getSelectedItem().toString());
				this._addRows(selected);
				System.out.printf("%n%d", selected);
			}catch (NumberFormatException e){e.printStackTrace();}


		}

	}

	private void createUIComponents() {
		this._grid = new GridLayout();
		this._numCoursesCbx = new JComboBox<String>(new String[]{"","1","2","3","4","5","6","7","8","9","10"});
		this._rowPanel=new JPanel(this._grid);
	}
}
