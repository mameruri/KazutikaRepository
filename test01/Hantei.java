package test01;

public class Hantei {

	public boolean hantei(String[][] arrayBoard, int retu, int gyou, int p) { //p:0、AIが置けるかどうか
		/*ボード,列座標,行座標,手番*/ //p:1、プレイヤーが置けるかどうか

		int r;
		int g;
		String[] arrayKoma = { "●", "○" };

		boolean ans = false; //戻り値

		LOOP: while (true) {
			/*左*/
			if (retu > 1) {
				r = retu - 1;

				if (arrayBoard[gyou][r].equals(arrayKoma[p])) { //敵コマが無ければ反転なし
					while (true) {
						r--;
						if (!(arrayBoard[gyou][r].equals(arrayKoma[p]))) {
							if (arrayBoard[gyou][r].equals("□")) {
								break; //反転なし
							} else {
								ans = true; //反転が一度でもあればerrorを0にする
								break LOOP;
							}
						} else if (r == 0) {
							break; //反転なし
						}
					}
				}
			}

			/*右*/
			if (retu < 6) {
				r = retu + 1;

				if (arrayBoard[gyou][r].equals(arrayKoma[p])) { //敵コマが無ければ反転なし
					while (true) {
						r++;
						if (!(arrayBoard[gyou][r].equals(arrayKoma[p]))) {
							if (arrayBoard[gyou][r].equals("□")) {
								break; //反転なし
							} else {
								ans = true;//反転が一度でもあればerrorを0にする
								break LOOP;
							}
						} else if (r == 7) {
							break; //反転なし
						}
					}
				}

			}

			/*上*/
			if (gyou > 1) {
				g = gyou - 1;

				if (arrayBoard[g][retu].equals(arrayKoma[p])) { //敵コマが無ければ反転なし
					while (true) {
						g--;
						if (!(arrayBoard[g][retu].equals(arrayKoma[p]))) {
							if (arrayBoard[g][retu].equals("□")) {
								break; //反転なし
							} else {

								ans = true; //反転が一度でもあればerrorを0にする
								break LOOP;
							}
						} else if (g == 0) {
							break; //反転なし
						}
					}
				}

			}

			/*下*/
			if (gyou < 6) {
				g = gyou + 1;

				if (arrayBoard[g][retu].equals(arrayKoma[p])) { //敵コマが無ければ反転なし
					while (true) {
						g++;
						if (!(arrayBoard[g][retu].equals(arrayKoma[p]))) {
							if (arrayBoard[g][retu].equals("□")) {
								break; //反転なし
							} else {

								ans=true; //反転が一度でもあればerrorを0にする
								break LOOP;
							}
						} else if (g == 7) {
							break; //反転なし
						}
					}
				}

			}

			/*右上*/
			if ((retu < 6) && (gyou > 1)) {
				g = gyou - 1;
				r = retu + 1;

				if (arrayBoard[g][r].equals(arrayKoma[p])) { //敵コマが無ければ反転なし
					while (true) {
						g--;
						r++;
						if (!(arrayBoard[g][r].equals(arrayKoma[p]))) {
							if (arrayBoard[g][r].equals("□")) {
								break; //反転なし
							} else {
								ans=true;
								break LOOP;
							}
						} else if ((g == 0) || (r == 7)) {
							break; //反転なし
						}
					}
				}

			}

			/*左上*/
			if ((retu > 1) && (gyou > 1)) {
				g = gyou - 1;
				r = retu - 1;

				if (arrayBoard[g][r].equals(arrayKoma[p])) { //敵コマが無ければ反転なし
					while (true) {
						g--;
						r--;
						if (!(arrayBoard[g][r].equals(arrayKoma[p]))) {
							if (arrayBoard[g][r].equals("□")) {
								break; //反転なし
							} else {
								ans=true;
								break LOOP;
							}
						} else if ((g == 0) || (r == 0)) {
							break; //反転なし
						}
					}
				}

			}

			/*右下*/

			if ((retu < 6) && (gyou < 6)) {
				g = gyou + 1;
				r = retu + 1;

				if (arrayBoard[g][r].equals(arrayKoma[p])) { //敵コマが無ければ反転なし
					while (true) {
						g++;
						r++;
						if (!(arrayBoard[g][r].equals(arrayKoma[p]))) {
							if (arrayBoard[g][r].equals("□")) {
								break; //反転なし
							} else {
								ans=true;
								break LOOP;
							}
						} else if ((g == 7) || (r == 7)) {
							break; //反転なし
						}
					}
				}

			}

			/*左下*/
			if ((retu > 1) && (gyou < 6)) {
				g = gyou + 1;
				r = retu - 1;

				if (arrayBoard[g][r].equals(arrayKoma[p])) { //敵コマが無ければ反転なし
					while (true) {
						g++;
						r--;
						if (!(arrayBoard[g][r].equals(arrayKoma[p]))) {
							if (arrayBoard[g][r].equals("□")) {
								break; //反転なし
							} else {
								ans=true;
								break LOOP;
							}
						} else if ((g == 7) || (r == 0)) {
							break; //反転なし
						}
					}
				}

			}

			break;
		}

		return ans;

	}

}
