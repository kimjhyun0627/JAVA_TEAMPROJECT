package TeamProjectByTerminal;

public class BorrowObj {

	private int ID = 0;
	private Date dateStart;
	private Date dateEnd;
	private String studentID = "";
	private boolean isBorrowing = false;

	BorrowObj(int newID, String newStudID) {

		ID = newID;
		dateStart = new Date(false);
		dateEnd = new Date(false);
		studentID = newStudID;
		isBorrowing = false;
	}

	BorrowObj(int newID, Date newStart, Date newEnd, String newStudID) {

		if (isValid(newID, newStart, newEnd, newStudID)) {

			ID = newID;
			dateStart = new Date(newStart);
			dateEnd = new Date(newEnd);
			studentID = newStudID;
			setObjStatus();

		} else
			errorhandler("invalid initialization");
	}

	private boolean isValid(int newID, Date newStart, Date newEnd, String newStudID) {

		return ((newID > 0) && (newStart.isValidTime()) && (newEnd.isValidTime()) && (newStudID.length() == 10));
	}

	public void updateStart() {

		dateStart.setDate(true);
		setObjStatus();
	}

	public void updateEnd() {

		dateEnd.setDate(true);
		setObjStatus();
	}

	public void setObjStatus() {

		if (dateStart.compareTime(dateEnd) < 0)

			isBorrowing = true;

		else
			isBorrowing = false;
	}

	public int getID() {

		return ID;
	}

	public Date getDateStart() {

		return new Date(dateStart);
	}

	public Date getDateEnd() {

		return new Date(dateEnd);
	}

	public String getStudentID() {

		return studentID;
	}

	public boolean getIsBorrowing() {

		return isBorrowing;
	}

	public String toString() {

		return "ID: " + ID + " Start: " + dateStart.toString() + " End: " + dateEnd.toString() + " StudID: " + studentID
				+ " isBorrowing: " + isBorrowing;
	}

	private void errorhandler(String errorType) {

		System.err.println("Error occured in Abstract BorrowObj class: " + errorType);
	}

}
