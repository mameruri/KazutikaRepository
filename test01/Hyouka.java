package test01;

public class Hyouka {

	public int hyouka(String[][] arrayBoard) {

		Hantei hantei = new Hantei(); //hanteiのインスタンス生成

		int cnt = 0;
		int p = 0;
		boolean flag = false;

		/*ほんへ*/
		while (p < 2) {
			for (int i = 0; i < arrayBoard.length; i++) {
				for (int j = 0; j < arrayBoard[i].length; j++) {

					if (arrayBoard[i][j] != "□") { //□じゃなかったら次のマスへ
						continue;
					}

					flag = hantei.hantei(arrayBoard, j, i, p); //i,jが置ける座標ならtrue、置けない座標ならfalseを返す
					/*ボード,列座標,行座標,手番*/

					if (flag == true) { //追加処理

						switch (p) {
						case 0:
							cnt++;
							break;
						default:
							cnt--;
							break;
						}
					}
				}
			}
			p++;
		}

		/*四隅補正*/
		Sumi sumi = new Sumi();

		int[] arraySumi = new int[36];

		/*arraySumi作成*/
		sumi.sumi(arrayBoard, arraySumi);

		int n = 1; //黒or白フラグ 1:白、-1:黒
		int k = 1;//係数
		while (n >= -1) {
			for (int s = 0; s < arraySumi.length; s=s+3) {//s:arraySumiの添え字
				if ((arraySumi[s] == n) && (arraySumi[s + 1] !=n) && (arraySumi[s + 2] !=n)) {//●□□

					cnt = cnt +( 9 * n * k);//●□□

				} else if ((arraySumi[s]!=n) && (arraySumi[s + 1] == n) && (arraySumi[s + 2] !=n)) {//□●□

					cnt = cnt - (15 * n * k);//□●□

				} else if ((arraySumi[s] !=n) && (arraySumi[s + 1]!=n) && (arraySumi[s + 2] == n)) {//□□●

					cnt = cnt + (1 * n * k);//□□●

				} else if ((arraySumi[s] == n) && (arraySumi[s + 1] == n) && (arraySumi[s + 2] !=n)) {//●●□

					cnt = cnt + (10 * n * k);//●●□

				} else if ((arraySumi[s] !=n) && (arraySumi[s + 1] == n) && (arraySumi[s + 2] == n)) {//□●●

					cnt = cnt - (5 * n * k);//□●●

				} else if ((arraySumi[s] == n) && (arraySumi[s + 1] !=n) && (arraySumi[s + 2] == n)) {//●□●

					cnt = cnt + (8 * n * k);//●□●

				} else if ((arraySumi[s] == n) && (arraySumi[s + 1] == n) && (arraySumi[s + 2] == n)) {//●●●

					cnt = cnt + (10 * n * k);//●●●
					
				}
			}
			n = n - 2;
		}

		return cnt;

	}

}
