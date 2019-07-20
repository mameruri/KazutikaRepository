package test01;

public class Ai {

	public String ai(String[][] arrayBoard, int level) {

		int[][] arrayTree = new int[7][]; //木構造
		arrayTree[0] = new int[40];
		arrayTree[1] = new int[800];
		arrayTree[2] = new int[8000];
		arrayTree[3] = new int[80000];
		arrayTree[4] = new int[800000];
		arrayTree[5] = new int[8000000];
		arrayTree[6] = new int[80000000];
		String[][] arrayIfboard1 = new String[8][8];
		String[][] arrayIfboard2 = new String[8][8];
		String[][] arrayIfboard3 = new String[8][8];
		String[][] arrayIfboard4 = new String[8][8];
		String[][] arrayIfboard5 = new String[8][8];
		String[][] arrayIfboard6 = new String[8][8];
		String[][] arrayIfboard7 = new String[8][8];

		Ifboard ifboard = new Ifboard();
		Tuika tuika = new Tuika();
		Hyouka hyouka = new Hyouka();//盤面評価のインスタンス生成
		Toridasi TD = new Toridasi();

		/*木構造の初期化*/
		for (int i = 0; i < arrayTree.length; i++) { //全てのマスを-100にする
			for (int j = 0; j < arrayTree[i].length; j++) {

				arrayTree[i][j] = -100;

			}
		}

		/*クソザコ*/
		int zako;
		switch (level) {
		case 0:
			zako = -1;
			break;
		default:
			zako = 1;
			break;
		}

		/*ほんへ*/
		int a = 0;
		int b = 0;
		int c = 0;
		int d = 0;
		int e = 0;
		int f = 0;

		int[] arrayTen = new int[40];

		/*一手目候補挿入*/
		tuika.tuika(arrayBoard, arrayTree, 0, 0, 0, 0); //木構造追加のインスタンス呼び出し
		/*(Board,Tree,Treeの行，前ポインタ)*/

		for (int i = 0; arrayTree[0][i] != -100; i++) {

			/*一手目を仮入力*/
			ifboard.ifboard(arrayBoard, arrayIfboard1, TD.TD(arrayTree[0][i], 1),
					TD.TD(arrayTree[0][i], 2), 0);//0:白を置く、1:黒を置く

			if (level == 1) {
				arrayTen[i] = hyouka.hyouka(arrayIfboard1);
				continue;
			}

			/*二手目候補挿入*/
			tuika.tuika(arrayIfboard1, arrayTree, 1, a, i, 1); //木構造追加のインスタンス呼び出し
			/*(Board,Tree,Treeの行，前ポインタ)*/

			arrayTen[i] = Integer.MAX_VALUE;

			while (arrayTree[1][a] / 100 == i) {

				//*二手目を仮入力*/
				ifboard.ifboard(arrayIfboard1, arrayIfboard2, TD.TD(arrayTree[1][a], 1),
						TD.TD(arrayTree[1][a], 2), 1);

				if (level == 2) {
					arrayTen[i] = Math.min(arrayTen[i], //評価関数を呼ぶ
							hyouka.hyouka(arrayIfboard2));
					a++;
					continue;
				}

				/*三手目候補挿入*/
				tuika.tuika(arrayIfboard2, arrayTree, 2, b, a, 0); //木構造追加のインスタンス呼び出し
				/*(Board,Tree,Treeの行，前ポインタ)*/

				arrayTree[1][a] = Integer.MIN_VALUE;

				while (arrayTree[2][b] / 100 == a) {

					/*三手目を仮入力*/
					ifboard.ifboard(arrayIfboard2, arrayIfboard3, TD.TD(arrayTree[2][b], 1),
							TD.TD(arrayTree[2][b], 2), 0);//0:白を置く、1:黒を置く

					if (level == 3) {
						arrayTree[1][a] = Math.max(arrayTree[1][a], //評価関数を呼ぶ
								hyouka.hyouka(arrayIfboard3));
						b++;
						continue;
					}

					/*四手目候補挿入*/
					tuika.tuika(arrayIfboard3, arrayTree, 3, c, b, 1); //木構造追加のインスタンス呼び出し
					/*(Board,Tree,Treeの行，前ポインタ)*/

					arrayTree[2][b] = Integer.MAX_VALUE;

					while (arrayTree[3][c] / 100 == b) {

						/*四手目を仮入力*/
						ifboard.ifboard(arrayIfboard3, arrayIfboard4, TD.TD(arrayTree[3][c], 1),
								TD.TD(arrayTree[3][c], 2), 1);
						//0:白を置く、1:黒を置く

						if (level == 4) {
							arrayTree[2][b] = Math.min(arrayTree[2][b], //評価関数を呼ぶ
									hyouka.hyouka(arrayIfboard4));
							c++;
							continue;
						}

						/*五手目候補挿入*/
						tuika.tuika(arrayIfboard4, arrayTree, 4, d, c, 0); //木構造追加のインスタンス呼び出し
						/*(Board,Tree,Treeの行，前ポインタ)*/

						arrayTree[3][c] = Integer.MIN_VALUE;

						while (arrayTree[4][d] / 100 == c) {

							/*五手目を仮入力*/
							ifboard.ifboard(arrayIfboard4, arrayIfboard5, TD.TD(arrayTree[4][d], 1),
									TD.TD(arrayTree[4][d], 2), 0);
							//0:白を置く、1:黒を置く

							if (level == 5) {
								arrayTree[3][c] = Math.max(arrayTree[3][c], //評価関数を呼ぶ
										hyouka.hyouka(arrayIfboard5));
								d++;
								continue;
							}

							/*六手目候補挿入*/
							tuika.tuika(arrayIfboard5, arrayTree, 5, e, d, 1); //木構造追加のインスタンス呼び出し
							/*(Board,Tree,Treeの行，前ポインタ)*/

							arrayTree[4][d] = Integer.MAX_VALUE;

							while (arrayTree[5][e] / 100 == d) {

								/*六手目を仮入力*/
								ifboard.ifboard(arrayIfboard5, arrayIfboard6,
										TD.TD(arrayTree[5][e], 1), TD.TD(arrayTree[5][e], 2),
										1);
								//0:白を置く、1:黒を置く

								if ((level == 6)||(level==0)) {
									arrayTree[4][d] = Math.min(arrayTree[4][d], //評価関数を呼ぶ
											hyouka.hyouka(arrayIfboard6)* zako);
									e++;
									continue;
								}

								/*七手目候補挿入*/
								tuika.tuika(arrayIfboard6, arrayTree, 6, f, e, 0); //木構造追加のインスタンス呼び出し
								/*(Board,Tree,Treeの行，前ポインタ)*/

								arrayTree[5][e] = Integer.MIN_VALUE;

								while (arrayTree[6][f] / 100 == e) {

									/*七手目を仮入力*/
									ifboard.ifboard(arrayIfboard6, arrayIfboard7,
											TD.TD(arrayTree[6][f], 1), TD.TD(arrayTree[6][f], 2),
											0);
									//0:白を置く、1:黒を置く

									/*評価関数を呼ぶ*/
									arrayTree[5][e] = Math.max(arrayTree[5][e],
											hyouka.hyouka(arrayIfboard7) );

									f++;
								}
								arrayTree[4][d] = Math.min(arrayTree[4][d], arrayTree[5][e]);
								e++;
							}
							arrayTree[3][c] = Math.max(arrayTree[3][c], arrayTree[4][d]);
							d++;
						}
						arrayTree[2][b] = Math.min(arrayTree[2][b], arrayTree[3][c]);
						c++;
					}
					arrayTree[1][a] = Math.max(arrayTree[1][a], arrayTree[2][b]);
					b++;
				}
				arrayTen[i] = Math.min(arrayTen[i], arrayTree[1][a]);
				a++;
			}

		}

		/*最終決定*/
		int max = 0;//一つ目の候補をmax(min)に入れる

		for (int i = 0; arrayTree[0][i] != -100; i++) {

			if (arrayTen[max] < arrayTen[i]) {//比較
				max = i;
			}

		}

		int x;
		int y;

		y = TD.TD(arrayTree[0][max], 2);
		x = TD.TD(arrayTree[0][max], 1);

		/*座標を変換*/
		String[][] arrayZahyou = { { "a1", "b1", "c1", "d1", "e1", "f1", "g1", "h1" }, //座標特定用の配列
				{ "a2", "b2", "c2", "d2", "e2", "f2", "g2", "h2" },
				{ "a3", "b3", "c3", "d3", "e3", "f3", "g3", "h3" },
				{ "a4", "b4", "c4", "d4", "e4", "f4", "g4", "h4" },
				{ "a5", "b5", "c5", "d5", "e5", "f5", "g5", "h5" },
				{ "a6", "b6", "c6", "d6", "e6", "f6", "g6", "h6" },
				{ "a7", "b7", "c7", "d7", "e7", "f7", "g7", "h7" },
				{ "a8", "b8", "c8", "d8", "e8", "f8", "g8", "h8" } };

		String ans = arrayZahyou[y][x]; //最終的な入力座標を返す
		System.out.println(ans);
		return ans;

	}

}
