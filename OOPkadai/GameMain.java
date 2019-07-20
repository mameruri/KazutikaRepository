package OOPkadai;

/*ゲーム部分のメイン的なクラス*/
public class GameMain {

	/*フィールド*/

	private static String[][] board = { { "□", "□", "□", "□", "□", "□", "□", "□" }, //盤面作成、初期化
			{ "□", "□", "□", "□", "□", "□", "□", "□" },
			{ "□", "□", "□", "□", "□", "□", "□", "□" },
			{ "□", "□", "□", "○", "●", "□", "□", "□" },
			{ "□", "□", "□", "●", "○", "□", "□", "□" },
			{ "□", "□", "□", "□", "□", "□", "□", "□" },
			{ "□", "□", "□", "□", "□", "□", "□", "□" },
			{ "□", "□", "□", "□", "□", "□", "□", "□" } };

	private HyouziSyori hyouzi_syori;//表示処理インスタンス用変数
	private GameSyori game_syori;//ゲーム処理インスタンス用変数

	private static int teban = 1;//手番、1:プレイヤー、0:CP
	private static int level;//レベル
	private static int pass;//パスの状態

	/*コンストラクタ*/
	GameMain(int level) {
		this.level = level;//入力されたレベルを格納
	}

	/*書かないとエラーでるから書いたコンストラクタ*/
	GameMain() {

	}

	/*ゲームを始めるメソッド*/
	public void game_start() {
		try {
			hyouzi_syori = new HyouziSyori();//表示処理インスタンス生成
			game_syori = new GameSyori();//ゲーム処理インスタンス生成

			/*ゲームループ*/
			while (true) {

				/*ゲーム処理*/
				if (game_syori.game_syori()) {//決着が付いたらfalseが返ってくる
					/*表示処理*/
					hyouzi_syori.hyouzi_syori();

				} else {//決着が付いたら結果発表して終了
					/*結果発表*/
					hyouzi_syori.result_hyouzi();
					return;//ゲーム終了
				}
			}

		} catch (Exception e) {
			System.out.println("予期せぬエラー:ゲーム中" + e);
			System.exit(1);//強制終了？
		}
	}

	/*setter*/

	protected void setPass(int pass) {
		this.pass = pass;
	}

	/*getter*/

	protected String[][] getBoard() {
		return this.board;
	}

	protected int getTeban() {
		return this.teban;
	}

	protected int getPass() {
		return this.pass;
	}

	protected int getLevel() {
		return this.level;
	}

	/*手番を入れ替えるメソッド*/
	protected void chgTeban() {
		this.teban ^= 1;
	}
//なんか⚠マーク出てるけどstaticにアクセスしたらあかんのんか？
}
