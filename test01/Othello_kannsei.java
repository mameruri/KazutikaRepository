package test01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Othello_kannsei {

	/**
	 * @param k rが行、kが列
	 * */
	public static void main(String[] args) throws IOException {
		// TODO 自動生成されたメソッド・スタブ

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		/*初期設定*/
		String[][] arrayBan = new String[8][8]; //盤
		String[][] arrayZahyou = { { "a1", "b1", "c1", "d1", "e1", "f1", "g1", "h1" }, //座標特定用の配列
				{ "a2", "b2", "c2", "d2", "e2", "f2", "g2", "h2" },
				{ "a3", "b3", "c3", "d3", "e3", "f3", "g3", "h3" },
				{ "a4", "b4", "c4", "d4", "e4", "f4", "g4", "h4" },
				{ "a5", "b5", "c5", "d5", "e5", "f5", "g5", "h5" },
				{ "a6", "b6", "c6", "d6", "e6", "f6", "g6", "h6" },
				{ "a7", "b7", "c7", "d7", "e7", "f7", "g7", "h7" },
				{ "a8", "b8", "c8", "d8", "e8", "f8", "g8", "h8" } };
		String[] arrayKoma = { "●", "○" }; //手番
		int owari = 0; //終了フラグ
		int nokori = 60; //残りマス数
		int teban = 0;
		int x = 0; //座標
		int y = 0;
		int r; //反転処理での座標ポインタ
		int k; //rが行、kが列
		int p; //敵コマのポインタ
		int flag; //反転フラグ
		int error = 0; //置けるマスがあるかどうかフラグ(ないとき1、あるとき0)
		int pass = 0; //パス判定のカウンター
		String name; //入力文字の変数

		Ai ai = new Ai(); //インスタンス生成
		Ai2 ai2 = new Ai2();

		for (int i = 0; i < arrayBan.length; i++) { //全てのマスに□を入れる
			for (int j = 0; j < arrayBan[0].length; j++) {
				arrayBan[i][j] = "□";
			}
		}
		arrayBan[3][3] = arrayKoma[1]; //初期配置設定
		arrayBan[4][4] = arrayKoma[1];
		arrayBan[3][4] = arrayKoma[0];
		arrayBan[4][3] = arrayKoma[0];

		/*レベルを選択させる*/
		int level;
		while (true) {
			System.out.println("レベル0: どうしても勝ちたい人向け");
			System.out.println("レベル1: 忙しい人向け");
			System.out.println("レベル2: ルールを覚えたばかりの人向け");
			System.out.println("レベル3: オセロが苦手な人向け");
			System.out.println("レベル4: オセロが普通な人向け");
			System.out.println("レベル5: オセロが得意な人向け");
			System.out.println("レベル6: ウェイが苦手な人向け (旧verとほぼ同じ難易度)");
			System.out.println("レベル7: 誰にも向かない （勝てたことない)");
			System.out.println();
			System.out.println("注)レベル7はちょっと遅い");
			System.out.println("レベルを入力して下さい(0～7)>");
			level = Integer.parseInt(br.readLine());
			if ((0 > level) || (7 < level)) {
				System.out.println("注)レベルは0～7までです");
				continue;
			}
			break;
		}

		while ((owari == 0) && (nokori != 0)) { //終了フラグがたつ又は残りマス数がゼロになったら抜ける

			/*盤の表示*/
			System.out.println(" ａｂｃｄｅｆｇｈ");
			for (int i = 0; i < arrayBan.length; i++) {
				System.out.print(i + 1);
				for (int j = 0; j < arrayBan[0].length; j++) {
					System.out.print(arrayBan[i][j]);
				}
				System.out.println();
			}

			if (error == 1) { //置く場所がなければ手番交代
				teban ^= 1;
				System.out.println();
				System.out.println("置ける場所がないのでパスします");
			}

			/*たいようの要望*/
			int kkk=0;
			int sss=0;
			for(int i=0;i<arrayBan.length;i++) {
				for(int j=0;j<arrayBan[i].length;j++) {
					switch(arrayBan[i][j]) {
					case "●":
						kkk++;
						break;
					case "○":
						sss++;
						break;
					default:
						break;
					}
				}
			}
			System.out.println();
			System.out.println("●:"+kkk+"\t"+"○:"+sss);

			/*入力してもらう*/
			System.out.println();
			System.out.println(arrayKoma[teban] + "の番です");
			if (x == -1) { //エラー時のメッセージ
				System.out.println("そこには打てません");
				System.out.print("もう一度");
			}
			System.out.println("コマを入力してください>");

			String log = "0";

			switch (teban) {
			case 0: //プレイヤーの入力処理
				name = br.readLine();
				break;
			default: //コンピュータの入力処理

				if (nokori > 12) {
					name = ai.ai(arrayBan, level);
				} else {
					name = ai2.ai2(arrayBan, nokori, level);

				}

				if (log == name) {
					name=arrayZahyou[(int)Math.random()*7][(int)Math.random()*7];
				}
				log = name;
				break;
			}
			/*座標を特定*/
			x = -1; //エラー時はx(y)=-1のままになる
			y = -1;
			for (int i = 0; i < arrayZahyou.length; i++) {
				for (int j = 0; j < arrayZahyou[0].length; j++) {
					if (name.equals(arrayZahyou[i][j])) {
						if (arrayBan[i][j].equals("□")) { //既に打たれた場所には打てない
							y = i; //列をx、行をyへ格納
							x = j;

						}
					}

				}
			}

			if (x != -1) { //エラー時は以下の処理をとばす

				/*反転処理*/
				flag = 0; //反転フラグ
				p = teban ^ 1; //敵コマのポインタ
				error = 1; //反転が一つもなければerrorが1のままになる
				/*左*/
				if (x > 1) {
					k = x - 1;
					flag = 0;
					if (arrayBan[y][k].equals(arrayKoma[p])) { //敵コマが無ければ反転なし
						while (flag == 0) {
							k--;
							if (!(arrayBan[y][k].equals(arrayKoma[p]))) {
								if (arrayBan[y][k].equals("□")) {
									flag = -1; //反転なし
								} else {
									flag++; //反転あり
									error = 0; //反転が一度でもあればerrorを0にする
								}
							} else if (k == 0) {
								flag = -1; //反転なし
							}
						}
					}

					if (flag == 1) { //flagが1なら反転
						while (k + 1 < x) {
							k++;
							arrayBan[y][k] = arrayKoma[teban];
						}
					}
				}

				/*右*/
				if (x < 6) {
					k = x + 1;
					flag = 0;
					if (arrayBan[y][k].equals(arrayKoma[p])) { //敵コマが無ければ反転なし
						while (flag == 0) {
							k++;
							if (!(arrayBan[y][k].equals(arrayKoma[p]))) {
								if (arrayBan[y][k].equals("□")) {
									flag = -1; //反転なし
								} else {
									flag++; //反転あり
									error = 0; //反転が一度でもあればerrorを0にする
								}
							} else if (k == 7) {
								flag = -1; //反転なし
							}
						}
					}

					if (flag == 1) { //flagが1なら反転
						while (x < k - 1) {
							k--;
							arrayBan[y][k] = arrayKoma[teban];
						}
					}
				}

				/*上*/
				if (y > 1) {
					r = y - 1;
					flag = 0;
					if (arrayBan[r][x].equals(arrayKoma[p])) { //敵コマが無ければ反転なし
						while (flag == 0) {
							r--;
							if (!(arrayBan[r][x].equals(arrayKoma[p]))) {
								if (arrayBan[r][x].equals("□")) {
									flag = -1; //反転なし
								} else {
									flag++; //反転あり
									error = 0; //反転が一度でもあればerrorを0にする
								}
							} else if (r == 0) {
								flag = -1; //反転なし
							}
						}
					}

					if (flag == 1) { //flagが1なら反転
						while (r + 1 < y) {
							r++;
							arrayBan[r][x] = arrayKoma[teban];
						}
					}
				}

				/*下*/
				if (y < 6) {
					r = y + 1;
					flag = 0;
					if (arrayBan[r][x].equals(arrayKoma[p])) { //敵コマが無ければ反転なし
						while (flag == 0) {
							r++;
							if (!(arrayBan[r][x].equals(arrayKoma[p]))) {
								if (arrayBan[r][x].equals("□")) {
									flag--; //反転なし
								} else {
									flag++; //反転あり
									error = 0; //反転が一度でもあればerrorを0にする
								}
							} else if (r == 7) {
								flag--; //反転なし
							}
						}
					}

					if (flag == 1) { //flagが1なら反転
						while (y < r - 1) {
							r--;
							arrayBan[r][x] = arrayKoma[teban];
						}
					}
				}

				/*右上*/
				if ((x < 6) && (y > 1)) {
					r = y - 1;
					k = x + 1;
					flag = 0;
					if (arrayBan[r][k].equals(arrayKoma[p])) { //敵コマが無ければ反転なし
						while (flag == 0) {
							r--;
							k++;
							if (!(arrayBan[r][k].equals(arrayKoma[p]))) {
								if (arrayBan[r][k].equals("□")) {
									flag--; //反転なし
								} else {
									flag++; //反転あり
									error = 0; //反転が一度でもあればerrorを0にする
								}
							} else if ((r == 0) || (k == 7)) {
								flag--; //反転なし
							}
						}
					}

					if (flag == 1) { //flagが1なら反転
						while (x < k - 1) {
							r++;
							k--;
							arrayBan[r][k] = arrayKoma[teban];
						}
					}
				}

				/*左上*/
				if ((x > 1) && (y > 1)) {
					r = y - 1;
					k = x - 1;
					flag = 0;
					if (arrayBan[r][k].equals(arrayKoma[p])) { //敵コマが無ければ反転なし
						while (flag == 0) {
							r--;
							k--;
							if (!(arrayBan[r][k].equals(arrayKoma[p]))) {
								if (arrayBan[r][k].equals("□")) {
									flag = -1; //反転なし
								} else {
									flag++; //反転あり
									error = 0; //反転が一度でもあればerrorを0にする
								}
							} else if ((r == 0) || (k == 0)) {
								flag = -1; //反転なし
							}
						}
					}

					if (flag == 1) { //flagが1なら反転
						while (k + 1 < x) {
							r++;
							k++;
							arrayBan[r][k] = arrayKoma[teban];
						}
					}
				}

				/*右下*/
				if ((x < 6) && (y < 6)) {
					r = y + 1;
					k = x + 1;
					flag = 0;
					if (arrayBan[r][k].equals(arrayKoma[p])) { //敵コマが無ければ反転なし
						while (flag == 0) {
							r++;
							k++;
							if (!(arrayBan[r][k].equals(arrayKoma[p]))) {
								if (arrayBan[r][k].equals("□")) {
									flag = -1; //反転なし
								} else {
									flag++; //反転あり
									error = 0; //反転が一度でもあればerrorを0にする
								}
							} else if ((r == 7) || (k == 7)) {
								flag = -1; //反転なし
							}
						}
					}

					if (flag == 1) { //flagが1なら反転
						while (x < k - 1) {
							r--;
							k--;
							arrayBan[r][k] = arrayKoma[teban];
						}
					}
				}

				/*左下*/
				if ((x > 1) && (y < 6)) {
					r = y + 1;
					k = x - 1;
					flag = 0;
					if (arrayBan[r][k].equals(arrayKoma[p])) { //敵コマが無ければ反転なし
						while (flag == 0) {
							r++;
							k--;
							if (!(arrayBan[r][k].equals(arrayKoma[p]))) {
								if (arrayBan[r][k].equals("□")) {
									flag = -1; //反転なし
								} else {
									flag++; //反転あり
									error = 0; //反転が一度でもあればerrorを0にする
								}
							} else if ((r == 7) || (k == 0)) {
								flag = -1; //反転なし
							}
						}
					}

					if (flag == 1) { //flagが1なら反転
						while (k + 1 < x) {
							r--;
							k++;
							arrayBan[r][k] = arrayKoma[teban];
						}
					}
				}

				if (error == 0) { //反転が一つもなければ飛ばす
					/*特定した座標にコマを入力*/
					arrayBan[y][x] = arrayKoma[teban];

					/*勝敗判定(全て同色になっているかどうか）*/
					owari = 1;
					for (int i = 0; i < arrayBan.length; i++) {
						for (int j = 0; j < arrayBan[0].length; j++) {
							if (arrayBan[i][j].equals(arrayKoma[p])) {
								owari = 0;
							}
						}
					}

					nokori--; //残りマス数-1
					teban ^= 1; //手番入れ替え
				} else {
					x = -1; //エラー時はxに-1を入れる
					error = 0; //errorは0に戻す
				}

				/*置ける場所があるか判定*/
				if (x != -1) { //入力エラー時は飛ばす
					error = 1;
					pass = 0;

					while ((error == 1) && (pass < 2)) {
						p = teban ^ 1; //敵コマのポインタ
						flag = 0; //反転フラグ
						if (pass == 1) {
							p ^= 1;
						}

						for (int i = 0; i < arrayBan.length; i++) { //全てのマスを調べる
							for (int j = 0; j < arrayBan[0].length; j++) {
								x = j;
								y = i;

								if (arrayBan[y][x].equals("□")) {
									/*左*/
									if (x > 1) {
										k = x - 1;
										flag = 0;
										if (arrayBan[y][k].equals(arrayKoma[p])) { //敵コマが無ければ反転なし
											while (flag == 0) {
												k--;
												if (!(arrayBan[y][k].equals(arrayKoma[p]))) {
													if (arrayBan[y][k].equals("□")) {
														flag = -1; //反転なし
													} else {
														flag++; //反転あり
														error = 0; //反転が一度でもあればerrorを0にする
													}
												} else if (k == 0) {
													flag = -1; //反転なし
												}
											}
										}

									}

									/*右*/
									if (x < 6) {
										k = x + 1;
										flag = 0;
										if (arrayBan[y][k].equals(arrayKoma[p])) { //敵コマが無ければ反転なし
											while (flag == 0) {
												k++;
												if (!(arrayBan[y][k].equals(arrayKoma[p]))) {
													if (arrayBan[y][k].equals("□")) {
														flag = -1; //反転なし
													} else {
														flag++; //反転あり
														error = 0; //反転が一度でもあればerrorを0にする
													}
												} else if (k == 7) {
													flag = -1; //反転なし
												}
											}
										}

									}

									/*上*/
									if (y > 1) {
										r = y - 1;
										flag = 0;
										if (arrayBan[r][x].equals(arrayKoma[p])) { //敵コマが無ければ反転なし
											while (flag == 0) {
												r--;
												if (!(arrayBan[r][x].equals(arrayKoma[p]))) {
													if (arrayBan[r][x].equals("□")) {
														flag = -1; //反転なし
													} else {
														flag++; //反転あり
														error = 0; //反転が一度でもあればerrorを0にする
													}
												} else if (r == 0) {
													flag = -1; //反転なし
												}
											}
										}

									}

									/*下*/
									if (y < 6) {
										r = y + 1;
										flag = 0;
										if (arrayBan[r][x].equals(arrayKoma[p])) { //敵コマが無ければ反転なし
											while (flag == 0) {
												r++;
												if (!(arrayBan[r][x].equals(arrayKoma[p]))) {
													if (arrayBan[r][x].equals("□")) {
														flag--; //反転なし
													} else {
														flag++; //反転あり
														error = 0; //反転が一度でもあればerrorを0にする
													}
												} else if (r == 7) {
													flag--; //反転なし
												}
											}
										}

									}

									/*右上*/
									if ((x < 6) && (y > 1)) {
										r = y - 1;
										k = x + 1;
										flag = 0;
										if (arrayBan[r][k].equals(arrayKoma[p])) { //敵コマが無ければ反転なし
											while (flag == 0) {
												r--;
												k++;
												if (!(arrayBan[r][k].equals(arrayKoma[p]))) {
													if (arrayBan[r][k].equals("□")) {
														flag--; //反転なし
													} else {
														flag++; //反転あり
														error = 0; //反転が一度でもあればerrorを0にする
													}
												} else if ((r == 0) || (k == 7)) {
													flag--; //反転なし
												}
											}
										}

									}

									/*左上*/
									if ((x > 1) && (y > 1)) {
										r = y - 1;
										k = x - 1;
										flag = 0;
										if (arrayBan[r][k].equals(arrayKoma[p])) { //敵コマが無ければ反転なし
											while (flag == 0) {
												r--;
												k--;
												if (!(arrayBan[r][k].equals(arrayKoma[p]))) {
													if (arrayBan[r][k].equals("□")) {
														flag = -1; //反転なし
													} else {
														flag++; //反転あり
														error = 0; //反転が一度でもあればerrorを0にする
													}
												} else if ((r == 0) || (k == 0)) {
													flag = -1; //反転なし
												}
											}
										}

									}

									/*右下*/

									if ((x < 6) && (y < 6)) {
										r = y + 1;
										k = x + 1;
										flag = 0;
										if (arrayBan[r][k].equals(arrayKoma[p])) { //敵コマが無ければ反転なし
											while (flag == 0) {
												r++;
												k++;
												if (!(arrayBan[r][k].equals(arrayKoma[p]))) {
													if (arrayBan[r][k].equals("□")) {
														flag = -1; //反転なし
													} else {
														flag++; //反転あり
														error = 0; //反転が一度でもあればerrorを0にする
													}
												} else if ((r == 7) || (k == 7)) {
													flag = -1; //反転なし
												}
											}
										}

									}

									/*左下*/
									if ((x > 1) && (y < 6)) {
										r = y + 1;
										k = x - 1;
										flag = 0;
										if (arrayBan[r][k].equals(arrayKoma[p])) { //敵コマが無ければ反転なし
											while (flag == 0) {
												r++;
												k--;
												if (!(arrayBan[r][k].equals(arrayKoma[p]))) {
													if (arrayBan[r][k].equals("□")) {
														flag = -1; //反転なし
													} else {
														flag++; //反転あり
														error = 0; //反転が一度でもあればerrorを0にする
													}
												} else if ((r == 7) || (k == 0)) {
													flag = -1; //反転なし
												}
											}
										}

									}
								}
							}
						}
						pass++;
						if ((pass == 2) && (error == 1)) {
							owari = 1; //両者ともパスのとき
						} else {
							if (pass == 2) {
								error = 1; //パスするとき
							}
						}
					}
				}
			}
		}

		/*最終盤の表示*/
		System.out.println(" a b c d e f g h");
		for (int i = 0; i < arrayBan.length; i++) {
			System.out.print(i + 1);
			for (int j = 0; j < arrayBan[0].length; j++) {
				System.out.print(arrayBan[i][j]);
			}
			System.out.println();
		}
		System.out.println(); //改行
		if (nokori == 0) {//pass!=2
			int count = 0;
			/*普通に終局*/
			/*勝敗判定2*/
			for (int i = 0; i < arrayBan.length; i++) {
				for (int j = 0; j < arrayBan[0].length; j++) {
					if (arrayBan[i][j].equals(arrayKoma[teban])) {
						count++;
					}
				}
			}

			/*結果発表*/
			if (count > 32) {
				System.out.println(arrayKoma[teban] + " " + count + "\t" + arrayKoma[teban ^ 1] + " " + (64 - count));
				System.out.println(arrayKoma[teban] + "の勝ちです");
			} else if (count < 32) {
				System.out.println(arrayKoma[teban ^ 1] + " " + (64 - count) + "\t" + arrayKoma[teban] + " " + count);
				System.out.println(arrayKoma[teban ^ 1] + "の勝ちです");
			} else {
				System.out.println(arrayKoma[0] + " 32" + "\t" + arrayKoma[1] + " 32");
				System.out.println("引き分けです");
			}
		} else {
			/*両者ともパス*/
			int kuro = 0;
			int shiro = 0;
			/*勝敗判定3*/
			for (int i = 0; i < arrayBan.length; i++) {
				for (int j = 0; j < arrayBan[0].length; j++) {
					if (arrayBan[i][j].equals(arrayKoma[0])) {
						kuro++;
					}
				}
			}
			for (int i = 0; i < arrayBan.length; i++) {
				for (int j = 0; j < arrayBan[0].length; j++) {
					if (arrayBan[i][j].equals(arrayKoma[1])) {
						shiro++;
					}
				}
			}
			/*結果発表2*/
			System.out.println("両者とも置ける場所がなくなりました");
			if (kuro > shiro) {
				System.out.println(arrayKoma[0] + " " + (64 - shiro) + "\t" + arrayKoma[1] + " " + shiro);
				System.out.println(arrayKoma[0] + "の勝ちです");
			} else if (kuro < shiro) {
				System.out.println(arrayKoma[1] + " " + (64 - kuro) + "\t" + arrayKoma[1] + " " + kuro);
				System.out.println(arrayKoma[1] + "の勝ちです");
			} else {
				System.out.println(arrayKoma[0] + " kuro" + "\t" + arrayKoma[1] + " shiro");
				System.out.println("引き分けです");
			}
		}

		System.out.println("ゲームは終了しました");
		System.out.println("(レベル" + level + ")");
	}

}