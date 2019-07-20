package test01;

public class Sumi {

	public void sumi(String[][] arrayBoard,int[] arraySumi) {
		
		int sumi=0;
		int i = 0;
		/*横左*/
		while (i <= 7) {
			for (int j = 0; j <= 2; j++) {

				switch (arrayBoard[i][j]) {
				case "○":
					arraySumi[sumi] = 1;//1:白
					sumi++;
					break;
				case "●":
					arraySumi[sumi] = -1;//-1:黒
					sumi++;
					break;
				default:
					sumi++;
					break;
				}

			}
			i = i + 7;
		}

		/*横右*/
		i = 0;
		while (i <= 7) {
			for (int j = 7; j >= 5; j--) {

				switch (arrayBoard[i][j]) {
				case "○":
					arraySumi[sumi] = 1;//1:白
					sumi++;
					break;
				case "●":
					arraySumi[sumi] = -1;//-1:黒
					sumi++;
					break;
				default:
					
					sumi++;
					break;
				}

			}
			i = i + 7;
		}

		/*縦上*/
		i = 0;
		while (i <= 7) {
			for (int j = 0; j <= 2; j++) {

				switch (arrayBoard[j][i]) {
				case "○":
					arraySumi[sumi] = 1;//1:白
					sumi++;
					break;
				case "●":
					arraySumi[sumi] = -1;//-1:黒
					sumi++;
					break;
				default:
					
					sumi++;
					break;
				}

			}
			i = i + 7;
		}

		/*縦下*/
		i = 0;
		while (i <= 7) {
			for (int j = 7; j >= 5; j--) {

				switch (arrayBoard[j][i]) {
				case "○":
					arraySumi[sumi] = 1;//1:白
					sumi++;
					break;
				case "●":
					arraySumi[sumi] = -1;//-1:黒
					sumi++;
					break;
				default:
					
					sumi++;
					break;
				}

			}
			i = i + 7;
		}

		/*斜左上*/
		for (int j = 0; j <= 2; j++) {

			switch (arrayBoard[j][j]) {
			case "○":
				arraySumi[sumi] = 1;//1:白
				sumi++;
				break;
			case "●":
				arraySumi[sumi] = -1;//-1:黒
				sumi++;
				break;
			default:
				
				sumi++;
				break;
			}

		}

		/*斜右下*/
		for (int j = 7; j >= 5; j--) {

			switch (arrayBoard[j][j]) {
			case "○":
				arraySumi[sumi] = 1;//1:白
				sumi++;
				break;
			case "●":
				arraySumi[sumi] = -1;//-1:黒
				sumi++;
				break;
			default:
				
				sumi++;
				break;
			}

		}

		/*斜右上*/
		for (int j = 7,a=0; j >=5; j--,a++) {

			switch (arrayBoard[a][j]) {
			case "○":
				arraySumi[sumi] = 1;//1:白
				sumi++;
				break;
			case "●":
				arraySumi[sumi] = -1;//-1:黒
				sumi++;
				break;
			default:
				
				sumi++;
				break;
			}

		}
		
		/*斜左下*/
		for (int j = 7,a=0; j >=5; j--,a++) {

			switch (arrayBoard[j][a]) {
			case "○":
				arraySumi[sumi] = 1;//1:白
				sumi++;
				break;
			case "●":
				arraySumi[sumi] = -1;//-1:黒
				sumi++;
				break;
			default:
				
				sumi++;
				break;
			}

		}
		
		return;

	}

}
