package test01;

public class Ifboard {

	public void ifboard(String[][] arrayOriginal, String[][] arrayBan, int retu, int gyou,int p) {//0:白を置く、1:黒を置く
		// TODO 自動生成されたメソッド・スタブ

		String[] arrayKoma = { "●", "○" }; //手番
		int flag;
		int r;
		int g;

		/*盤面のコピー*/
		for (int i = 0; i < arrayOriginal.length; i++) { //全てのマスを調べる
			for (int j = 0; j < arrayOriginal[0].length; j++) {

				arrayBan[i][j]=arrayOriginal[i][j];

			}
		}

		/*tebanの決定*/
		int teban=p^1;

		/*反転処理*/
		flag = 0; //反転フラグ

		/*左*/
		if (retu > 1) {
			r = retu - 1;
			flag = 0;
			if (arrayBan[gyou][r].equals(arrayKoma[p])) { //敵コマが無ければ反転なし
				while (true) {
					r--;
					if (!(arrayBan[gyou][r].equals(arrayKoma[p]))) {
						if (arrayBan[gyou][r].equals("□")) {

							break;
						} else {
							flag++; //反転あり
							break;
						}
					} else if (r == 0) {

						break;
					}

				}
			}

			if (flag == 1) { //flagが1なら反転
				while (r + 1 < retu) {
					r++;
					arrayBan[gyou][r] = arrayKoma[teban];
				}
			}
		}

		/*右*/
		if (retu < 6) {
			r = retu + 1;
			flag = 0;
			if (arrayBan[gyou][r].equals(arrayKoma[p])) { //敵コマが無ければ反転なし
				while (true) {
					r++;
					if (!(arrayBan[gyou][r].equals(arrayKoma[p]))) {
						if (arrayBan[gyou][r].equals("□")) {
							break;
						} else {
							flag++; //反転あり
							break;
						}
					} else if (r == 7) {
						break;
					}
				}
			}

			if (flag == 1) { //flagが1なら反転
				while (retu < r - 1) {
					r--;
					arrayBan[gyou][r] = arrayKoma[teban];
				}
			}
		}

		/*上*/
		if (gyou > 1) {
			g = gyou - 1;
			flag = 0;
			if (arrayBan[g][retu].equals(arrayKoma[p])) { //敵コマが無ければ反転なし
				while (true) {
					g--;
					if (!(arrayBan[g][retu].equals(arrayKoma[p]))) {
						if (arrayBan[g][retu].equals("□")) {
							break;
						} else {
							flag++; //反転あり
							break;
						}
					} else if (g == 0) {
						break; //反転なし
					}
				}
			}

			if (flag == 1) { //flagが1なら反転
				while (g + 1 < gyou) {
					g++;
					arrayBan[g][retu] = arrayKoma[teban];
				}
			}
		}

		/*下*/
		if (gyou < 6) {
			g = gyou + 1;
			flag = 0;
			if (arrayBan[g][retu].equals(arrayKoma[p])) { //敵コマが無ければ反転なし
				while (true) {
					g++;
					if (!(arrayBan[g][retu].equals(arrayKoma[p]))) {
						if (arrayBan[g][retu].equals("□")) {
							break;
						} else {
							flag++; //反転あり
							break;
						}
					} else if (g == 7) {
						break; //反転なし
					}
				}
			}

			if (flag == 1) { //flagが1なら反転
				while (gyou < g - 1) {
					g--;
					arrayBan[g][retu] = arrayKoma[teban];
				}
			}
		}

		/*右上*/
		if ((retu < 6) && (gyou > 1)) {
			g = gyou - 1;
			r = retu + 1;
			flag = 0;
			if (arrayBan[g][r].equals(arrayKoma[p])) { //敵コマが無ければ反転なし
				while (true) {
					g--;
					r++;
					if (!(arrayBan[g][r].equals(arrayKoma[p]))) {
						if (arrayBan[g][r].equals("□")) {
							break;
						} else {
							flag++; //反転あり
							break;
						}
					} else if ((g == 0) || (r == 7)) {
						break; //反転なし
					}
				}
			}

			if (flag == 1) { //flagが1なら反転
				while (retu < r - 1) {
					g++;
					r--;
					arrayBan[g][r] = arrayKoma[teban];
				}
			}
		}

		/*左上*/
		if ((retu > 1) && (gyou > 1)) {
			g = gyou - 1;
			r = retu - 1;
			flag = 0;
			if (arrayBan[g][r].equals(arrayKoma[p])) { //敵コマが無ければ反転なし
				while (true) {
					g--;
					r--;
					if (!(arrayBan[g][r].equals(arrayKoma[p]))) {
						if (arrayBan[g][r].equals("□")) {
							break;
						} else {
							flag++; //反転あり
							break;
						}
					} else if ((g == 0) || (r == 0)) {
						break; //反転なし
					}
				}
			}

			if (flag == 1) { //flagが1なら反転
				while (r + 1 < retu) {
					g++;
					r++;
					arrayBan[g][r] = arrayKoma[teban];
				}
			}
		}

		/*右下*/
		if ((retu < 6) && (gyou < 6)) {
			g = gyou + 1;
			r = retu + 1;
			flag = 0;
			if (arrayBan[g][r].equals(arrayKoma[p])) { //敵コマが無ければ反転なし
				while (true) {
					g++;
					r++;
					if (!(arrayBan[g][r].equals(arrayKoma[p]))) {
						if (arrayBan[g][r].equals("□")) {
							break;
						} else {
							flag++; //反転あり
							break;
						}
					} else if ((g == 7) || (r == 7)) {
						break; //反転なし
					}
				}
			}

			if (flag == 1) { //flagが1なら反転
				while (retu < r - 1) {
					g--;
					r--;
					arrayBan[g][r] = arrayKoma[teban];
				}
			}
		}

		/*左下*/
		if ((retu > 1) && (gyou < 6)) {
			g = gyou + 1;
			r = retu - 1;
			flag = 0;
			if (arrayBan[g][r].equals(arrayKoma[p])) { //敵コマが無ければ反転なし
				while (true) {
					g++;
					r--;
					if (!(arrayBan[g][r].equals(arrayKoma[p]))) {
						if (arrayBan[g][r].equals("□")) {
							break;
						} else {
							flag++; //反転あり
							break;
						}
					} else if ((g == 7) || (r == 0)) {
						break; //反転なし
					}
				}
			}

			if (flag == 1) { //flagが1なら反転
				while (r + 1 < retu) {
					g--;
					r++;
					arrayBan[g][r] = arrayKoma[teban];
				}
			}
		}


			/*特定した座標にコマを入力*/
			arrayBan[gyou][retu] = arrayKoma[teban];


		return;

	}

}
