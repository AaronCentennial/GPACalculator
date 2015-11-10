import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Objects;

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
	private JScrollPane _scrollPane;

	private JPanel _rowPanel;
	private JLabel _titleLbl;

	private GridLayout _grid;
	private GridBagConstraints _gc;

//	private ArrayList<Component[]> _rowPanelElements;

	GpaGui(){
		super("GPA Calculator");
//		this._rowPanelElements=new ArrayList<>();
		this._initFrame();
		this._addActionListeners();
	}

	private void _initFrame() {
		setContentPane(this._contentPane);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setIconImage(new ImageIcon(getClass().getResource("/images/edit-text.png")).getImage());
		setMinimumSize(new Dimension(650, 300));
		setSize(700, 500);
		setLocation(400, 100);
		setVisible(true);
	}

	private void _addActionListeners() {
		this._exitBtn.addActionListener(this);
		this._numCoursesCbx.addActionListener(this);
		this._calculateBtn.addActionListener(this);
	}

	private void _addRows(int numRows){

		this._rowPanel.removeAll();
		this._rowPanel.revalidate();
		this._rowPanel.validate();

		JLabel l = new JLabel("Nr:");
		this._gc.gridx=0;
		this._gc.gridy=0;
		this._gc.ipadx=0;
		this._gc.ipady=0;
		

		this._rowPanel.add(l,this._gc);

/*
		this._rowPanel.add(new JLabel("Nr:"));
		this._rowPanel.add(new JLabel("Course Code:"));
		this._rowPanel.add(new JLabel("Credit Hours:"));
		this._rowPanel.add(new JLabel("Grade:"));
*/

/*
		for (int i=0; i<numRows; i++){
			this._rowPanel.add(new JLabel((i+1)+". "));
			this._rowPanel.add(new JTextField());
			this._rowPanel.add(new JComboBox<>(new Integer[]{1,2,3,4,5}));
			this._rowPanel.add(new JComboBox<>(new String[]{"","A+ 90-100%","A 80-89%","B+ 75-79%","B 75-79%","C+ 65-69%","C 60-64%","D+ 55-59%","D 50-54%","F 0-49%"}));
		}*/
		this._rowPanel.revalidate();
		this._rowPanel.validate();
//		this.pack();
	}

	private void _calculateBtnAction() {

		Component[] components=this._rowPanel.getComponents();
		for (Component component : components) {
			if (component instanceof JTextField) {
				System.out.print(((JTextField) component).getText() + "\n");
			}

		}
	}

	private void createUIComponents() {
		this._grid = new GridLayout(0,4,4,4);

		this._gc=new GridBagConstraints();


		this._numCoursesCbx = new JComboBox<>(new String[]{"","1","2","3","4","5","6","7","8","9","10","100"});
		this._rowPanel=new JPanel(new GridBagLayout());
//		this._rowPanel=new JPanel(this._grid);
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
			}catch (NumberFormatException e){e.printStackTrace();}
		}
		else if (actionEvent.getSource()==this._calculateBtn){
			this._calculateBtnAction();
		}

	}

}
