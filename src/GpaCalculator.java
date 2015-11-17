import java.util.ArrayList;

/*
 * Created by Aaron Fernandes(300773526) on November 2015.
 */
public class GpaCalculator {

	private ArrayList<String[]> _currentSem;


	GpaCalculator(){
		this._currentSem=new ArrayList<>();
	}

	//Adds a new course to the array list
	public void addCourse(String hours, String grade){
		this._currentSem.add(new String[]{hours,grade});
	}

	//returns the full gpa
	public double getGPA(double curCreditHrs,double curGPA ){
		double hrsTotal=0;
		double gpvTotal=0;
		double semGPA;

		for (String[] i:  this._currentSem){
			double hours = Double.parseDouble(i[0]);
			double grade = this._toPoints(i[1]);
			hrsTotal+=hours;
			gpvTotal+=hours*grade;
		}

		this._currentSem.clear();
		semGPA=gpvTotal/hrsTotal;

		return ((semGPA*hrsTotal)+(curGPA*curCreditHrs))/(hrsTotal+curCreditHrs);
	}


	private double _toPoints(String grade){
		switch (grade){
			case "A+ 90-100%":
				return 4.5;
			case "A 80-89%":
				return 4.0;
			case "B+ 75-79%":
				return 3.5;
			case "B 75-79%":
				return 3.0;
			case "C+ 65-69%":
				return 2.5;
			case "C 60-64%":
				return 2.0;
			case "D+ 55-59%":
				return 1.5;
			case "D 50-54%":
				return 1.0;
			default:
				return 0.0;
		}
	}
}
