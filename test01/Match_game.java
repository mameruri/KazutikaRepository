package test01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Match_game {

	public static void main(String[] args) throws IOException {
		// TODO 自動生成されたメソッド・スタブ

		/*入力の準備*/
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int cnt = 23;
		int name = 0;
		String[] arrayP = { "1P", "2P" };
		int t = 0;
		boolean error = false;

		while (true) {

			if (error == true) {
				System.out.println("【エラー】1か2を入力してください");
				error = false;
			}
			System.out.println("1:コンピューターと対戦");
			System.out.println("2:二人で対戦");
			name = Integer.parseInt(br.readLine());
			if (name == 2) {

				while (true) {

					for (int i = 0; i < cnt; i++) {
						System.out.print("□");
					}
					System.out.println();

					if (error == true) {
						System.out.println("【エラー】1～3の整数を入力してください");
						error = false;
					}

					System.out.println(arrayP[t] + "さん入力してください");
					name = Integer.parseInt(br.readLine());

					if (name == 1 || name == 2 || name == 3) {
						cnt -= name;
						t ^= 1;
						if (cnt <= 0) {
							break;
						}
					} else {
						error = true;
					}
				}

				System.out.println(arrayP[t] + "の勝ちです");
				break;
			} else if (name == 1) {

				while (true) {

					for (int i = 0; i < cnt; i++) {
						System.out.print("□");
					}
					System.out.println();

					if (t == 0) {

						if (error == true) {
							System.out.println("【エラー】1～3の整数を入力してください");
							error = false;
						}

						System.out.println("入力してください");
						name = Integer.parseInt(br.readLine());
					}else {
						name=3;
					}

					if (name == 1 || name == 2 || name == 3) {
						cnt -= name;
						t ^= 1;
						if (cnt <= 0) {
							break;
						}
					} else {
						error = true;
					}

				}

				if(t==0) {
					System.out.println("あなたの勝ちです");
				}else {
					System.out.println("あなたの負けです");
				}
				
				break;

			} else {
				error = true;
			}
		}
	}

}
