package test01;

public class Hyouka2 {

	public int hyouka2(String[][] arrayBoard) {

		int cnt=0;

		for(int i=0;i<arrayBoard.length;i++) {
			for(int j=0;j<arrayBoard[i].length;j++) {

				switch(arrayBoard[i][j]) {
				case "○":
					cnt++;
					break;
				default:
					cnt--;
					break;
				}

			}
		}

		return cnt;

	}

}
