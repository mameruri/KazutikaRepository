package OOPkadai;

/*例外発生を通知するクラス*/
public class InputExcep extends Exception {

	/*コンストラクタ*/
	InputExcep(int teban) {
		if (teban == 1) {//GUI化したらこれが出ることはないはず
			System.out.println("規定値外の値が入力されました");
			System.out.println("↑GUI化したらこれは出ないと思う");
		} else {//AI部分がちゃんと動かなかったときに出る、もし出てもなおしたくない
			System.out.println("AI部分が正常に動作しませんでした");
			System.out.println("ゲーム続行不能");
			System.exit(1);
		}
	}

}
