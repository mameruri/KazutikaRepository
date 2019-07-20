package OOPkadai;

import java.awt.Container;
import java.awt.GridBagLayout;

import javax.swing.JFrame;
import javax.swing.JTextField;

public class SwingTest extends JFrame {

	/*フィールド*/
	JFrame frame=new JFrame("ゲーム画面");

	GridBagLayout GridBag;
	Container cntnr;
	JTextField text1;



	public void main() {
		// TODO 自動生成されたメソッド・スタブ

		frame.setSize(900,600);



		cntnr=getContentPane();
		GridBag=new GridBagLayout();

		cntnr.setLayout(GridBag);
		text1=new JTextField(20);

		cntnr.add(text1,1,1);

		frame.setVisible(true);
	}

}
