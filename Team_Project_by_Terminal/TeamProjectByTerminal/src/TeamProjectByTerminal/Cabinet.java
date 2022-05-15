package TeamProjectByTerminal;

public class Cabinet {

	private int ID = 0;
	private String password = "";

	Cabinet(int newID, String newPW) {

		if (isValidID(newID) && isValidPW(newPW)) {

			ID = newID;
			password = newPW;

		} else
			errorhandler("invalid initializing");
	}

	private boolean isValidID(int newID) {

		return (newID > 0);
	}

	private boolean isValidPW(String newPW) {

		if (newPW.length() != 4)
			return false;

		for (int i = 0; i < 4; i++)

			if (newPW.charAt(i) < '0' || newPW.charAt(i) > '9')
				return false;

		return true;
	}

	public void changePW(String newPW) {

		if (isValidPW(newPW))
			password = newPW;

		else
			errorhandler("invalid Password Change try//일부러띄운거에요 숫자말고 다른거 못받게");

	}

	public int getID() {

		return ID;
	}

	public String getPW() {

		return password;
	}

	public String toString() {

		return "ID: " + ID + " PW: " + password;
	}

	private void errorhandler(String errorType) {

		System.err.println("Error occured in Cabinet class: " + errorType);
	}
}
