package test01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Marubatsu_game {

	public static void main(String[] args) throws IOException {
		// TODO 自動生成されたメソッド・スタブ

		/*入力の準備*/
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		String[][] arrayBan = new String[3][3]; //盤面の確保
		String[][] arrayZahyou = { { "a1", "b1", "c1" }, //入力位置判定
				{ "a2", "b2", "c2" },
				{ "a3", "b3", "c3" } };
		String[] arrayKoma = { "○", "×" }; //先手後手判定
		int count = 1; //ターン数カウンタ
		int teban = 0; //先手後手判定の添字
		int owari = 0; //終了判定
		int x = 0; //入力位置判定の添字
		int y = 0;
		int p = 0; //勝敗判定

		LOOP:  //勝敗が決まったらループを抜ける

			/*盤面の初期化*/
			if (count == 1) {
				for (int i = 0; i < arrayBan.length; i++) {
					for (int j = 0; j < arrayBan[i].length; j++) {
						arrayBan[i][j] = "□";
					}
				}
			}

			/*盤面の表示*/
			System.out.println(" a b c");
			for (int i = 0; i < arrayBan.length; i++) {
				System.out.print(i + 1);
				for (int j = 0; j < arrayBan[i].length; j++) {
					System.out.print(arrayBan[i][j]);
				}
				System.out.println();
			}

			/*コンピュータの処理*/
			CP:while (teban == 0) {
				if (count >= 5) { //5ターン目以降は勝てるマスがあれば置く
					for (int i = 0; i < arrayBan.length; i++) { //横列の判定
						p = 0;
						for (int j = 0; j < arrayBan.length; j++) {
							if(arrayBan[i][j].equals(arrayKoma[1])) {
								break;
							}
							if (arrayBan[i][j].equals(arrayKoma[teban])) {
								p++;
								if (p == 2) {
									if (arrayBan[i][0].equals("□")) {
										arrayBan[i][0] = arrayKoma[teban];
									} else if (arrayBan[i][1].equals("□")) {
										arrayBan[i][1] = arrayKoma[teban];
									} else {
										arrayBan[i][2] = arrayKoma[teban];
									}
									break LOOP; //コンピュータの勝ち、ループ抜ける
								}
							}
						}
					}

					for (int j = 0; j < arrayBan.length; j++) { //縦列の判定
						p = 0;
						for (int i = 0; i < arrayBan.length; i++) {
							if(arrayBan[i][j].equals(arrayKoma[1])) {
								break;
							}
							if (arrayBan[i][j].equals(arrayKoma[teban])) {
								p++;
								if (p == 2) {
									if (arrayBan[0][j].equals("□")) {
										arrayBan[0][j] = arrayKoma[teban];
									} else if (arrayBan[1][j].equals("□")) {
										arrayBan[1][j] = arrayKoma[teban];
									} else {
										arrayBan[2][j] = arrayKoma[teban];
									}
									break LOOP;
								}
							}
						}
					}

					p = 0;
					for (int i = 0, j = 0; i < arrayBan.length; i++, j++) { //斜めの判定1
						if(arrayBan[i][j].equals(arrayKoma[1])) {
							break;
						}
						if (arrayBan[i][j].equals(arrayKoma[teban])) {
							p++;
							if (p == 2) {
								if (arrayBan[0][0].equals("□")) {
									arrayBan[0][0] = arrayKoma[teban];
								} else if (arrayBan[1][1].equals("□")) {
									arrayBan[1][1] = arrayKoma[teban];
								} else  {
									arrayBan[2][2] = arrayKoma[teban];
								}
								break LOOP;
							}
						}
					}

					p = 0;
					for (int i = 0, j = 2; i < arrayBan.length; i++, j--) { //斜めの判定2
						if(arrayBan[i][j].equals(arrayKoma[1])) {
							break;
						}
						if (arrayBan[i][j].equals(arrayKoma[teban])) {
							p++;
							if (p == 2) {
								if (arrayBan[0][0].equals("□")) {
									arrayBan[0][0] = arrayKoma[teban];
								} else if (arrayBan[1][1].equals("□")) {
									arrayBan[1][1] = arrayKoma[teban];
								} else {
									arrayBan[2][2] = arrayKoma[teban];
								}
								break LOOP;
							}
						}
					}
					
					/*×がリーチなら防いでbreak CP*/
					for (int i = 0; i < arrayBan.length; i++) { //横列の判定
						p = 0;
						for (int j = 0; j < arrayBan.length; j++) {
							if(arrayBan[i][j].equals(arrayKoma[0])) {
								break;
							}
							if (arrayBan[i][j].equals(arrayKoma[1])) {
								p++;
								if (p == 2) {
									if (arrayBan[i][0].equals("□")) {
										arrayBan[i][0] = arrayKoma[teban];
									} else if (arrayBan[i][1].equals("□")) {
										arrayBan[i][1] = arrayKoma[teban];
									} else {
										arrayBan[i][2] = arrayKoma[teban];
									}
									break CP; //コンピュータの番終わり、CP抜ける
								}
							}
						}
					}

					for (int j = 0; j < arrayBan.length; j++) { //縦列の判定
						p = 0;
						for (int i = 0; i < arrayBan.length; i++) {
							if(arrayBan[i][j].equals(arrayKoma[0])) {
								break;
							}
							if (arrayBan[i][j].equals(arrayKoma[1])) {
								p++;
								if (p == 2) {
									if (arrayBan[0][j].equals("□")) {
										arrayBan[0][j] = arrayKoma[teban];
									} else if (arrayBan[1][j].equals("□")) {
										arrayBan[1][j] = arrayKoma[teban];
									} else {
										arrayBan[2][j] = arrayKoma[teban];
									}
									break CP; //コンピュータの番終わり、CP抜ける
								}
							}
						}
					}

					p = 0;
					for (int i = 0, j = 0; i < arrayBan.length; i++, j++) { //斜めの判定1
						if(arrayBan[i][j].equals(arrayKoma[0])) {
							break;
						}
						if (arrayBan[i][j].equals(arrayKoma[1])) {
							p++;
							if (p == 2) {
								if (arrayBan[0][0].equals("□")) {
									arrayBan[0][0] = arrayKoma[teban];
								} else if (arrayBan[1][1].equals("□")) {
									arrayBan[1][1] = arrayKoma[teban];
								} else  {
									arrayBan[2][2] = arrayKoma[teban];
								}
								break CP; //コンピュータの番終わり、CP抜ける
							}
						}
					}

					p = 0;
					for (int i = 0, j = 2; i < arrayBan.length; i++, j--) { //斜めの判定2
						if(arrayBan[i][j].equals(arrayKoma[0])) {
							break;
						}
						if (arrayBan[i][j].equals(arrayKoma[1])) {
							p++;
							if (p == 2) {
								if (arrayBan[0][0].equals("□")) {
									arrayBan[0][0] = arrayKoma[teban];
								} else if (arrayBan[1][1].equals("□")) {
									arrayBan[1][1] = arrayKoma[teban];
								} else {
									arrayBan[2][2] = arrayKoma[teban];
								}
								break CP; //コンピュータの番終わり、CP抜ける
							}
						}
					}
					
				}
				
				
				if(count==1) { //初手はa1に置く
					arrayBan[0][0]=arrayKoma[teban];
				}
				
				if(count==3) { //3ターン目
					if((arrayBan[0][1].equals(arrayKoma[1]))||(arrayBan[0][2].equals(arrayKoma[1])||(arrayBan[1][2].equals(arrayKoma[1]))||(arrayBan[2][2].equals(arrayKoma[1])))) {
						arrayBan[2][0]=arrayKoma[teban]; //b1,c1,c2,c3に置かれたときa3
					}else if((arrayBan[1][0].equals(arrayKoma[1]))||(arrayBan[2][0].equals(arrayKoma[1])||(arrayBan[2][1].equals(arrayKoma[1])))) {
						arrayBan[0][2]=arrayKoma[teban]; //a2,a3,b3に置かれたときc1
					}else {
						arrayBan[2][2]=arrayKoma[teban];
					}
				}
				
				if(count==5) { //5ターン目
						
					}if((arrayBan[0][2].equals(arrayKoma[1]))||(arrayBan[2][0].equals(arrayKoma[1]))) {
						arrayBan[2][2]=arrayKoma[teban];
					}else {
						arrayBan[1][1]=arrayKoma[teban];
					}
				}
				
			}

	/*コマの入力*/
	if(teban==1)

	{

		System.out.println(arrayKoma[teban] + "の番です");
		if (x == -1) { //エラー時のメッセージ
			System.out.println("そこには打てません");
			System.out.print("もう一度");
		}
		System.out.println("コマを入力してください>");

		String name = br.readLine();
		x = -1; //エラー時はx(y)=-1のままになる
		y = -1;

		for (int i = 0; i < arrayZahyou.length; i++) {
			for (int j = 0; j < arrayZahyou[i].length; j++) {
				if (name.equals(arrayZahyou[i][j])) {
					if (arrayBan[i][j].equals("□")) { //既に打たれた場所には打てない
						x = j; //列をx、行をyへ格納
						y = i;
					}
				}

			}
		}
	}if((x!=-1)&&(teban==1))
	{ //エラー時は以下の処理をとばす

		/*○×入力*/
		arrayBan[y][x] = arrayKoma[teban];
	}
	/*勝敗判定*/
	if(count>=5)
	{//5ターン目以降は勝敗判定を行う
		for (int i = 0; i < arrayBan.length; i++) { //横列の判定
			p = 0;
			for (int j = 0; j < arrayBan.length; j++) {
				if (arrayBan[i][j].equals(arrayKoma[teban])) {
					p++;
					if (p == 3) {
						break LOOP;
					}
				}
			}
		}

		for (int j = 0; j < arrayBan.length; j++) { //縦列の判定
			p = 0;
			for (int i = 0; i < arrayBan.length; i++) {
				if (arrayBan[i][j].equals(arrayKoma[teban])) {
					p++;
					if (p == 3) {
						break LOOP;
					}
				}
			}
		}

		p = 0;
		for (int i = 0, j = 0; i < arrayBan.length; i++, j++) { //斜めの判定1
			if (arrayBan[i][j].equals(arrayKoma[teban])) {
				p++;
				if (p == 3) {
					break LOOP;
				}
			}
		}

		p = 0;
		for (int i = 0, j = 2; i < arrayBan.length; i++, j--) { //斜めの判定2

			if (arrayBan[i][j].equals(arrayKoma[teban])) {
				p++;
				if (p == 3) {
					break LOOP;
				}
			}
		}
	}
	/*先手後手の切り替え*/
	teban^=1;

	/*ターン数カウントアップ*/
	count++;if(count==10)
	{//10になったら1ターン目にリセット
		count = 1;
	}

	/*最終盤面の表示*/
	System.out.println(" a b c");

	for(
	int i = 0;i<arrayBan.length;i++)
	{
		System.out.print(i + 1);
		for (int j = 0; j < arrayBan[i].length; j++) {
			System.out.print(arrayBan[i][j]);
		}
		System.out.println();
	}

	/*結果の表示*/
	System.out.println(arrayKoma[teban]+"の勝ちです");System.out.println("ゲームは終了しました");

}}
