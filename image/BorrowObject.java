package TeamProject;

public class BorrowObject {
	protected int objID;
	protected Date dateStart;
	protected Date dateHaveto;
	protected Date dateEnd;
	protected String studentID;
	protected boolean isBorrowing;
	
	protected String ERR_MSG = "Fatal Error.";
	
	public BorrowObject(){
		objID = 0;
		dateStart = new Date(2022,6,1,12,30,10);
		dateHaveto = new Date(2022,6,2,12,30,10);
		dateEnd = new Date(2022,6,1,16,30,10);
		studentID = "1234567890";
		isBorrowing = false;
	}
	
	public BorrowObject(int newobjID, Date newStart, Date newEnd, String newstudentID){
		if(isValid(newobjID, newStart, newEnd, newstudentID)){
			objID = newobjID;
			dateStart = newStart;
			dateHaveto = new Date(setHaveto(dateStart));
			dateEnd = newEnd;
			studentID = newstudentID;
			setObjStatus();
		}else
			errorhandler("invalid initialization");
	}

	public BorrowObject(int newobjID, Date newStart, Date newHaveto, Date newEnd, String newStudID) {
		if (isValid(newobjID, newStart, newHaveto, newEnd, newStudID)) {
			objID = newobjID;
			dateStart = new Date(newStart);
			dateHaveto = new Date(setHaveto(dateStart));
			dateEnd = new Date(newEnd);
			studentID = newStudID;
			setObjStatus();
		} else
			errorhandler("invalid initialization");
	}
	
	public BorrowObject(BorrowObject BObj){
		objID = BObj.objID;
		dateStart = BObj.dateStart;
		dateHaveto = BObj.dateHaveto;
		dateEnd = BObj.dateEnd;
		studentID = BObj.studentID;
		isBorrowing = BObj.isBorrowing;
	}
	
	public int getObjID(){return this.objID;}
	public Date getDateStart(){return this.dateStart;}
	public Date getDateHaveto(){return this.dateHaveto;}
	public Date getDateEnd(){return this.dateEnd;}
	public String getStudentID(){return this.studentID;}
	public boolean getIsBorrowing(){return this.isBorrowing;}
	
	public void updateStart(){
		dateStart.setDate(true);
		dateHaveto = new Date(setHaveto(dateStart));
		setObjStatus();
	}
	public void updateEnd(){
		dateEnd.setDate(true);
		setObjStatus();
	}
	public void setObjStatus(){
		if (dateStart.compareTime(dateEnd) < 0)
			isBorrowing = true;

		else
			isBorrowing = false;
	}
	
	protected Date setHaveto(Date dateStart){
		Date Haveto = null;
		Haveto.AddDate(dateStart);
		return Haveto;
	}
	protected boolean isValid(int newID, Date newStart, Date newEnd, String newStudID) {
		return ((newID > 0) && (newStart.isValidTime()) && (newEnd.isValidTime()) && (newStudID.length() == 10));
	}
	protected boolean isValid(int newID, Date newStart, Date newHaveto, Date newEnd, String newStudID) {
		return ((newID > 0) && (newStart.isValidTime()) && (newHaveto.isValidTime()) && (newEnd.isValidTime()) && (newStudID.length() == 10));
	}
	public void errorhandler(String errorType) {
		System.err.println("Error occured in Abstract BorrowObj class: " + errorType);
	}

}