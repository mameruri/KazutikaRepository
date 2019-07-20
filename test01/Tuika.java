package test01;

public class Tuika {

	public void tuika(String[][] arrayBoard, int[][] arrayTree, int gyou, int retu, int pointer, int p) {
		// TODO 自動生成されたメソッド・スタブ

		Hantei hantei = new Hantei(); //hanteiのインスタンス生成

		boolean flag; //追加フラ

		/*ほんへ*/
		for (int i = 0; i < arrayBoard.length; i++) {
			for (int j = 0; j < arrayBoard[i].length; j++) {

				if (arrayBoard[i][j] != "□") { //□じゃなかったら次のマスへ
					continue;
				}

				flag = hantei.hantei(arrayBoard, j, i, p); //i,jが置ける座標ならtrue、置けない座標ならfalseを返す
				/*ボード,列座標,行座標,手番*/

				if (flag == true) { //追加処理
					arrayTree[gyou][retu] = pointer * 100 + i * 10 + j;
					retu++;
				}

			}
		}
		return;

	}

}
