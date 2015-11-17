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
	private JScrollPane _scrollPane;

	private JPanel _rowPanel;
	private JLabel _titleLbl;
	private GridBagConstraints _gc;

	private GpaCalculator _gpaCalculator;

	//constructor
	GpaGui(){
		super("GPA Calculator");
		this._initFrame();
		this._addActionListeners();
		this._gpaCalculator=new GpaCalculator();
	}

	// set config for frame
	private void _initFrame() {
		setContentPane(this._contentPane);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setIconImage(new ImageIcon(getClass().getResource("/images/edit-text.png")).getImage());
		setMinimumSize(new Dimension(620, 300));
		setSize(600, 450);
		setLocation(400, 100);
		setVisible(true);
	}

	// adds all action Listeners
	private void _addActionListeners() {
		this._exitBtn.addActionListener(this);
		this._numCoursesCbx.addActionListener(this);
		this._calculateBtn.addActionListener(this);
	}

	// dy
	private void _addRows(int numRows){

		// make sure action listeners are removed :)
		for(Component i : this._rowPanel.getComponents()){
			if (i instanceof JTextField){((JTextField) i).removeActionListener(this);}
			else if (i instanceof JComboBox){((JComboBox) i).removeActionListener(this);}
		}

		//Remove all elements
		this._rowPanel.removeAll();

		this._gc.gridx=0;
		this._gc.gridy=0;
		this._rowPanel.add(new JLabel("Nr:"),this._gc);

		this._gc.gridx=1;
		this._gc.gridy=0;
		this._rowPanel.add(new JLabel("Course Code:"),this._gc);

		this._gc.gridx=2;
		this._gc.gridy=0;
		this._rowPanel.add(new JLabel("Credit Hours:"),this._gc);

		this._gc.gridx=3;
		this._gc.gridy=0;
		this._rowPanel.add(new JLabel("Grade:"),this._gc);

		/*
		* This will loop through and add rows
		* based on user selection
		 */
		for (int i=0; i<numRows; i++){
			this._gc.gridx=0;
			this._gc.gridy=i+1;
			this._rowPanel.add(new JLabel((i+1)+". "),this._gc);

			this._gc.gridx=1;
			this._rowPanel.add(new JTextField(),this._gc);

			this._gc.gridx=2;
			this._rowPanel.add(new JComboBox<>(new Integer[]{1,2,3,4,5}),this._gc);

			this._gc.gridx=3;
			this._rowPanel.add(new JComboBox<>(new String[]{"","A+ 90-100%","A 80-89%","B+ 75-79%","B 75-79%","C+ 65-69%","C 60-64%","D+ 55-59%","D 50-54%","F 0-49%"}), this._gc);
		}


		this._rowPanel.revalidate();
		this._rowPanel.repaint();
	}

	private void _calculateBtnAction() {
		Component[] components=this._rowPanel.getComponents();
		/*
		* Loop trough all components and get 
		 */
		for (int i=0;i<components.length;i++){
			if (components[i] instanceof JTextField){
				String hours = ((JComboBox) components[i + 1]).getSelectedItem().toString();
				String grade = (String)((JComboBox) components[i + 2]).getSelectedItem();
				String tmp=(String)((JComboBox) components[i+2]).getSelectedItem();
				if (tmp.isEmpty()){
					JOptionPane.showMessageDialog(null,"No grade selected for "+((JTextField) components[i]).getText());
					return;
				}
				else {
					this._gpaCalculator.addCourse(hours,grade);
				}

			}//if JTextField
		}//components loop
		if(this._checkCurrentFieldsValid()) {
			this._gpaTotalTxt.setText(String.format("Your GPA: %.2f", this._gpaCalculator.getGPA( Double.parseDouble(this._creditHrsTxt.getText()),Double.parseDouble(this._curGPATxt.getText()))));
		}
	}
	
	private boolean _checkCurrentFieldsValid() {
		if (this._creditHrsTxt.getText().isEmpty()){
			JOptionPane.showMessageDialog(null,"Current credit hours is empty");
			return false;
		}
		else if (this._curGPATxt.getText().isEmpty()){
			JOptionPane.showMessageDialog(null,"Current gpa is empty");
			return false;
		}
		else{
			return true;
		}

	}
	
	private void createUIComponents() {
		this._gc=new GridBagConstraints();
		this._gc.anchor=GridBagConstraints.NORTHWEST;
		this._gc.fill=GridBagConstraints.HORIZONTAL;

		this._gc.weightx=1d;
		this._gc.weighty=1d;
		this._gc.insets=new Insets(0,0,0,0);

		this._numCoursesCbx = new JComboBox<>(new String[]{"","1","2","3","4","5","6","7","8","9","10","100"});
		this._numCoursesCbx.setEditable(true);
		this._rowPanel=new JPanel(new GridBagLayout());
	}

	/*
	*  Action Listeners
	*/
	@Override
	public void actionPerformed(ActionEvent actionEvent) {

		if (actionEvent.getSource()==this._exitBtn){
			System.exit(0);
		}
		else if (actionEvent.getSource()==this._numCoursesCbx){

			try {
				int selected = Integer.parseInt(this._numCoursesCbx.getSelectedItem().toString());
				this._addRows(selected);
			} catch (NumberFormatException e) {
				JOptionPane.showMessageDialog(null, "You need to enter the number of courses as an integer");
				e.printStackTrace();
			}

		}
		else if (actionEvent.getSource()==this._calculateBtn){
			this._calculateBtnAction();
		}

	}

}
