package OOPkadai;

/*ゲームループの表示処理の部分*/
public class HyouziSyori extends GameMain {

	/*フィールド*/
	private int kuro;//黒の数、集計用
	private int siro;//白の数

	/*コンストラクタ*/
	/*ゲーム開始時の表示*/
	HyouziSyori() {

		/*初期盤面表示*/
		board_hyouzi();

		/*初期メッセージ表示*/
		System.out.println("ゲームスタート");
		System.out.println("あなたの番です");
	}

	/*通常の画面表示用のメソッド*/
	public void hyouzi_syori() {

		/*盤面表示*/
		board_hyouzi();

		/*現在のそれぞれのコマ数表示*/
		count();//集計
		System.out.println("\n" + "●:" + kuro + " " + "○:" + siro);//現在のコマ数表示

		/*メッセージ表示*/
		if (getPass() == 1) {//置ける場所がないとき
			System.out.println("置ける場所がないのでパスです");
		}

		if (getTeban() == 1) {//今どっちの番か表示、1のときプレイヤーの番
			System.out.println("あなたの番です");
		} else {
			System.out.println("CPただいま考え中");
		}
		return;
	}

	/*結果表示用のメソッド*/
	public void result_hyouzi() {

		/*最終盤面表示*/
		board_hyouzi();

		if (getPass() == 2) {//両者パスになったとき
			System.out.println("両者とも置ける場所がなくなりました");
		}

		/*最終結果表示*/
		count();//最終コマ数集計
		System.out.println("\n" + "●:" + kuro + " " + "○:" + siro);//最終コマ数表示

		if (kuro > siro) {//勝ち負けを表示
			System.out.println("YOU WIN");//勝ち
			System.out.println("\n" + "やりますねぇ！" + "\n");
		} else if (siro > kuro) {
			System.out.println("YOU LOSE");//負け
			System.out.println("\n" + "オレの勝ち!w" + "\n\n" + "オマエは無価値w" + "\n\n" + "なんで負けたか、明日まで考えといてください(笑)"
					+ "\n");
		} else {
			System.out.println("DRAW");//引き分け
		}

		/*レベル表示*/
		System.out.println("レベル" + getLevel());
		return;
	}

	/*盤面表示するだけのメソッド*/
	private void board_hyouzi() {

		System.out.println(" ａｂｃｄｅｆｇｈ");
		for (int i = 0; i < getBoard().length; i++) {
			System.out.print(i + 1);
			for (int j = 0; j < getBoard()[0].length; j++) {
				System.out.print(getBoard()[i][j]);
			}
			System.out.println();
		}
		return;
	}

	/*それぞれのコマ数を集計するメソッド*/
	private void count() {
		/*初期化*/
		kuro = 0;//黒の数
		siro = 0;//白の数

		/*集計*/
		for (String[] a : getBoard()) {
			for (String b : a) {
				switch (b) {
				case "●":
					kuro++;
					break;
				case "○":
					siro++;
					break;
				}
			}
		}
		return;
	}

}
