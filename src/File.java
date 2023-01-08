/* CST8110 - Introduction to Computer Programming
 * Section: 450
 * Semester: 20F
 * Professor: Piyush Jangam
 * Student ID: 41017324
 * Student Email: laba0038@algonquinlive.com
 * Practical Assessment 1
 */

public class File {
	private int numFiles;

	public void File(int num) {
		numFiles = num;
	}
	
	public boolean isEmpty() {
		if (numFiles == 0) {//return if file type is empty
			return true;
		} else return false;
	}
	
	public boolean removeFiles(int num) {
		if(num<1) {//not allow user to remove 0 files
			System.out.println("Sorry, you must remove at least 1 file. Choose again.");
			System.out.println();
			return false;
		} else if ((numFiles/2)<num && numFiles>1) {//not allow user to remove more than 50% of files
			System.out.println("Sorry, that's too many files! Choose again.");
			System.out.println();
			return false;
		} else {
		numFiles = numFiles-num;
		return true;
		}
	}
	
	public int getNumFiles() {
		return numFiles;//return number of files
	}
}
