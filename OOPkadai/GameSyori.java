package OOPkadai;

import test01.Ai;

/*ゲームループのゲーム処理の部分*/
public class GameSyori extends GameMain {

	/*フィールド*/
	private KeyboardInput input;
	private Ai cp;
	private HantenSyori hanten_syori;
	private OkeruHantei okeru_hantei;

	private int row;//行
	private int col;//列
	private int masu_cnt = 60;//残りマス数
	private StringBuilder log = new StringBuilder(180);//打った位置のログ、0(CP)or1(プレイヤー),行,列]

	/*ゲーム処理*/
	public boolean game_syori() {
		/*インスタンス生成*/
		input = new KeyboardInput();//キーボード入力インスタンス生成
		cp = new Ai();//CPインスタンス生成
		hanten_syori = new HantenSyori();//コマを反転させるためのインスタンス
		okeru_hantei = new OkeruHantei();//指定位置が置ける場所かどうか判定するためのインスタンス

		/*入力処理*/
		while (true) {//置ける位置に入力されるまでループし続ける
			try {
				input_syori();//入力してもらう
			} catch (InputExcep e) {
				continue;
			}

			/*置ける位置かどうか判定*/
			if (okeru_hantei.okeru_hantei(getBoard(), col, row, getTeban())) {
				break;//置けない位置だったらもう一度入力待機
			}
		}

		/*コマ反転処理*/
		hanten_syori.hanten_syori(getBoard(), col, row, getTeban());

		/*打った位置のログ記録、[0(CP)or1(プレイヤー),行,列]*/
		log.append(getTeban());//手番ログ記録
		log.append(row);//行ログ記録
		log.append(col);//列ログ記録

		/*残りマス数を減らす*/
		if (--masu_cnt == 0) {
			return false;//残りマス数0になったらゲームループ抜けるend
		}

		/*次の人がパスかどうか判定*/
		pass_hantei();//passが0(パス無)1(パス有)2(両者パス)になる
		if (getPass() == 2) {
			return false;//両者パス(pass==2)だったらゲームループ抜けるend
		}

		/*手番入れ替え処理*/
		if (getPass() == 0) {//次の人がパスじゃないとき手番入れ替える
			chgTeban();//手番入れ替え
		}

		return true;//ゲームループ抜けないend
	}

	/*入力処理をするメソッド*/
	private void input_syori() throws InputExcep {

		String input_str;//入力された文字列を受け取る変数

		/*入力してもらう*/
		if (getTeban() == 1) {
			input_str = input.inputKeyboard();//プレイヤーに入力してもらう
		} else {
			input_str = cp.ai(getBoard(), getLevel());//CPに入力してもらう
		}

		/*入力文字が二文字以外だったらダメ*/
		if (input_str.length() != 2) {
			throw new InputExcep(getTeban());
		}

		/*入力文字を座標(int)に変換*/
		try {
			row = Integer.parseInt(input_str.substring(1)) - 1;//行を取得
			col = (int) input_str.charAt(0) - 'a';//列を取得
		} catch (NumberFormatException e) {
			throw new InputExcep(getTeban());//NumberFormatException出たらダメ
		}

		/*0～7の範囲じゃないとダメ*/
		if (0 > row || 7 < row || 0 > col || 7 < col) {
			throw new InputExcep(getTeban());
		}
		return;
	}

	/*パスの判定をするメソッド*/
	private void pass_hantei() {

		/*インスタンス生成*/
		okeru_hantei = new OkeruHantei();//指定位置が置けるマスかどうか判定するインスタンス

		setPass(2);//初期化、両者パスならpass==2のままになる
		/*次の人がパスかどうか調べる*/
		LOOP: for (int i = 0; i < getBoard().length; i++) {//□のマス全てを置けるかどうか判定する
			for (int j = 0; j < getBoard()[i].length; j++) {
				if (getBoard()[i][j].equals("□")) {
					/*置ける位置かどうか判定*/
					if (okeru_hantei.okeru_hantei(getBoard(), j, i, getTeban() ^ 1)) {
						setPass(0);//パスなし
						break LOOP;
					}
				}

			}
		}

		/*もし次の人がパスかパスだったら、さらにその次の人もパスかどうか調べる*/
		if (getPass() == 2) {//パス有ならやる
			LOOP: for (int i = 0; i < getBoard().length; i++) {//□のマス全てを置けるかどうか判定する
				for (int j = 0; j < getBoard()[i].length; j++) {
					if (getBoard()[i][j].equals("□")) {
						/*置ける位置かどうか判定*/
						if (okeru_hantei.okeru_hantei(getBoard(), j, i, getTeban())) {
							setPass(1);//パスあり
							break LOOP;
						}
					}

				}
			}
		}
		return;
	}

}
