package test01;

public class Ai2 {

	public String ai2(String[][] arrayBoard, int nokori, int level) {

		Hyouka2 hyouka2 = new Hyouka2();
		Toridasi TD = new Toridasi();
		Ifboard ifboard = new Ifboard();
		Tuika tuika = new Tuika();

		int[][] arrayTree = new int[12][]; //木構造
		arrayTree[0] = new int[12];
		arrayTree[1] = new int[500];
		arrayTree[2] = new int[5000];
		arrayTree[3] = new int[8000];
		arrayTree[4] = new int[70000];
		arrayTree[5] = new int[90000];
		arrayTree[6] = new int[400000];
		arrayTree[7] = new int[700000];
		arrayTree[8] = new int[9000000];
		arrayTree[9] = new int[10000000];
		arrayTree[10] = new int[30000000];
		arrayTree[11] = new int[90000000];

		String[][] arrayIfboard1 = new String[8][8];
		String[][] arrayIfboard2 = new String[8][8];
		String[][] arrayIfboard3 = new String[8][8];
		String[][] arrayIfboard4 = new String[8][8];
		String[][] arrayIfboard5 = new String[8][8];
		String[][] arrayIfboard6 = new String[8][8];
		String[][] arrayIfboard7 = new String[8][8];
		String[][] arrayIfboard8 = new String[8][8];
		String[][] arrayIfboard9 = new String[8][8];
		String[][] arrayIfboard10 = new String[8][8];
		String[][] arrayIfboard11 = new String[8][8];
		String[][] arrayIfboard12 = new String[8][8];

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
		int g = 0;
		int h = 0;
		int i = 0;
		int j = 0;
		int k = 0;

		int[] arrayTen = new int[40];

		/*一手目候補挿入*/
		tuika.tuika(arrayBoard, arrayTree, 0, 0, 0, 0); //木構造追加のインスタンス呼び出し
		/*(Board,Tree,Treeの行，前ポインタ)*/

		for (int z = 0; arrayTree[0][z] != -100; z++) {

			/*一手目を仮入力*/
			ifboard.ifboard(arrayBoard, arrayIfboard1, TD.TD(arrayTree[0][z], 1),
					TD.TD(arrayTree[0][z], 2), 0);//0:白を置く、1:黒を置く

			if (nokori == 1) {
				arrayTen[z] = hyouka2.hyouka2(arrayIfboard1) * zako;
				continue;
			}

			/*二手目候補挿入*/
			tuika.tuika(arrayIfboard1, arrayTree, 1, a, z, 1); //木構造追加のインスタンス呼び出し
			/*(Board,Tree,Treeの行，前ポインタ)*/

			arrayTen[z] = Integer.MAX_VALUE;

			while (arrayTree[1][a] / 100 == z) {

				//*二手目を仮入力*/
				ifboard.ifboard(arrayIfboard1, arrayIfboard2, TD.TD(arrayTree[1][a], 1),
						TD.TD(arrayTree[1][a], 2), 1);

				if (nokori == 2) {
					arrayTen[z] = Math.min(arrayTen[z], //評価関数を呼ぶ
							hyouka2.hyouka2(arrayIfboard2) * zako);
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

					if (nokori == 3) {
						arrayTree[1][a] = Math.max(arrayTree[1][a], //評価関数を呼ぶ
								hyouka2.hyouka2(arrayIfboard3) * zako);
						b++;
						continue;
					}

					/*四手目候補挿入*/
					tuika.tuika(arrayIfboard3, arrayTree, 3, c, b, 1); //木構造追加のインスタンス呼び出し
					/*(Board,Tree,Treeの行,列，前ポインタ)*/

					arrayTree[2][b] = Integer.MAX_VALUE;

					while (arrayTree[3][c] / 100 == b) {

						/*四手目を仮入力*/
						ifboard.ifboard(arrayIfboard3, arrayIfboard4, TD.TD(arrayTree[3][c], 1),
								TD.TD(arrayTree[3][c], 2), 1);
						//0:白を置く、1:黒を置く

						if (nokori == 4) {
							arrayTree[2][b] = Math.min(arrayTree[2][b], //評価関数を呼ぶ
									hyouka2.hyouka2(arrayIfboard4) * zako);
							c++;
							continue;
						}

						/*五手目候補挿入*/
						tuika.tuika(arrayIfboard4, arrayTree, 4, d, c, 0); //木構造追加のインスタンス呼び出し
						/*(Board,Tree,Treeの行，前ポインタ)*/

						arrayTree[3][c] = Integer.MIN_VALUE;

						while (arrayTree[4][d] / 100 == c) {

							/*五手目を仮入力*/
							ifboard.ifboard(arrayIfboard4, arrayIfboard5, TD.TD(arrayTree[4][d], 0),
									TD.TD(arrayTree[4][d], 2), 0);
							//0:白を置く、1:黒を置く

							if (nokori == 5) {
								arrayTree[3][c] = Math.max(arrayTree[3][c], //評価関数を呼ぶ
										hyouka2.hyouka2(arrayIfboard5) * zako);
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

								if (nokori == 6) {
									arrayTree[4][d] = Math.min(arrayTree[4][d], //評価関数を呼ぶ
											hyouka2.hyouka2(arrayIfboard6) * zako);
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

									if (nokori == 7) {
										arrayTree[5][e] = Math.max(arrayTree[5][e], //評価関数を呼ぶ
												hyouka2.hyouka2(arrayIfboard7) * zako);
										f++;
										continue;
									}

									/*八手目候補挿入*/
									tuika.tuika(arrayIfboard7, arrayTree, 7, g, f, 1); //木構造追加のインスタンス呼び出し
									/*(Board,Tree,Treeの行，前ポインタ)*/

									arrayTree[6][f] = Integer.MAX_VALUE;

									while (arrayTree[7][g] / 100 == f) {

										/*八手目を仮入力*/
										ifboard.ifboard(arrayIfboard7, arrayIfboard8,
												TD.TD(arrayTree[7][g], 1), TD.TD(arrayTree[7][g], 2),
												1);

										if (nokori == 8) {
											arrayTree[6][f] = Math.min(arrayTree[6][f], //評価関数を呼ぶ
													hyouka2.hyouka2(arrayIfboard8) * zako);
											g++;
											continue;
										}

										/*九手目候補挿入*/
										tuika.tuika(arrayIfboard8, arrayTree, 8, h, g, 0); //木構造追加のインスタンス呼び出し
										/*(Board,Tree,Treeの行，前ポインタ)*/

										arrayTree[7][g] = Integer.MIN_VALUE;

										while (arrayTree[8][h] / 100 == g) {

											/*九手目を仮入力*/
											ifboard.ifboard(arrayIfboard8, arrayIfboard9,
													TD.TD(arrayTree[8][h], 1), TD.TD(arrayTree[8][h], 2),
													0);

											if (nokori == 9) {
												arrayTree[7][g] = Math.max(arrayTree[7][g], //評価関数を呼ぶ
														hyouka2.hyouka2(arrayIfboard9) * zako);
												h++;
												continue;
											}

											/*十手目候補挿入*/
											tuika.tuika(arrayIfboard9, arrayTree, 9, i, h, 1); //木構造追加のインスタンス呼び出し
											/*(Board,Tree,Treeの行，前ポインタ)*/

											arrayTree[8][h] = Integer.MAX_VALUE;

											while (arrayTree[9][i] / 100 == h) {

												/*十手目を仮入力*/
												ifboard.ifboard(arrayIfboard9, arrayIfboard10,
														TD.TD(arrayTree[9][i], 1), TD.TD(arrayTree[9][i], 2),
														1);

												if (nokori == 10) {
													arrayTree[8][h] = Math.min(arrayTree[8][h], //評価関数を呼ぶ
															hyouka2.hyouka2(arrayIfboard10) * zako);
													i++;
													continue;
												}

												/*十一手目候補挿入*/
												tuika.tuika(arrayIfboard10, arrayTree, 10, j, i, 0); //木構造追加のインスタンス呼び出し
												/*(Board,Tree,Treeの行，前ポインタ)*/

												arrayTree[9][i] = Integer.MIN_VALUE;

												while (arrayTree[10][j] / 100 == i) {

													/*十一手目を仮入力*/
													ifboard.ifboard(arrayIfboard10, arrayIfboard11,
															TD.TD(arrayTree[10][j], 1), TD.TD(arrayTree[10][j], 2),
															0);

													if (nokori == 11) {
														arrayTree[9][i] = Math.max(arrayTree[9][i], //評価関数を呼ぶ
																hyouka2.hyouka2(arrayIfboard11) * zako);
														j++;
														continue;
													}

													/*十二手目候補挿入*/
													tuika.tuika(arrayIfboard11, arrayTree, 11, k, j, 1); //木構造追加のインスタンス呼び出し
													/*(Board,Tree,Treeの行，前ポインタ)*/

													arrayTree[10][j] = Integer.MAX_VALUE;

													while (arrayTree[11][k] / 100 == j) {

														/*十二手目を仮入力*/
														ifboard.ifboard(arrayIfboard11, arrayIfboard12,
																TD.TD(arrayTree[11][k], 1), TD.TD(arrayTree[11][k], 2),
																1);

														/*評価関数を呼ぶ*/
														arrayTree[10][j] = Math.min(arrayTree[10][j],
																hyouka2.hyouka2(arrayIfboard12) * zako);

														k++;
													}
													arrayTree[9][i] = Math.max(arrayTree[9][i], arrayTree[10][j]);
													j++;
												}
												arrayTree[8][h] = Math.min(arrayTree[8][h], arrayTree[9][i]);
												i++;
											}
											arrayTree[7][g] = Math.max(arrayTree[7][g], arrayTree[8][h]);
											h++;
										}
										arrayTree[6][f] = Math.min(arrayTree[6][f], arrayTree[7][g]);
										g++;
									}
									arrayTree[5][e] = Math.max(arrayTree[5][e], arrayTree[6][f]);
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
				arrayTen[z] = Math.min(arrayTen[z], arrayTree[1][a]);
				a++;
			}

		}

		/*最終決定*/
		int max = 0;//一つ目の候補をmax(min)に入れる

		for (int x = 0; arrayTree[0][x] != -100; x++) {

			if (arrayTen[max] < arrayTen[x]) {//比較
				max = x;
			}

		}

		int y = TD.TD(arrayTree[0][max], 2);
		int x = TD.TD(arrayTree[0][max], 1);

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
