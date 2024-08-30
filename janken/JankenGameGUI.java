import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class JankenGameGUI extends JFrame implements ActionListener {

    private JButton rockButton;
    private JButton scissorsButton;
    private JButton paperButton;
    private JLabel resultLabel;
    private JLabel userChoiceLabel;
    private JLabel computerChoiceLabel;

    public JankenGameGUI() {
        setTitle("じゃんけんゲーム");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(5, 1));

        // ボタンを作成
        rockButton = new JButton("グー");
        scissorsButton = new JButton("チョキ");
        paperButton = new JButton("パー");

        // ラベルを作成
        userChoiceLabel = new JLabel("あなたの選択: ");
        computerChoiceLabel = new JLabel("コンピュータの選択: ");
        resultLabel = new JLabel("結果: ");

        // ボタンにリスナーを追加
        rockButton.addActionListener(this);
        scissorsButton.addActionListener(this);
        paperButton.addActionListener(this);

        // コンポーネントをフレームに追加
        add(userChoiceLabel);
        add(computerChoiceLabel);
        add(resultLabel);
        add(rockButton);
        add(scissorsButton);
        add(paperButton);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String[] choices = {"グー", "チョキ", "パー"};
        Random random = new Random();
        int computerChoice = random.nextInt(3);
        String computerChoiceString = choices[computerChoice];

        String userChoiceString = "";

        if (e.getSource() == rockButton) {
            userChoiceString = "グー";
        } else if (e.getSource() == scissorsButton) {
            userChoiceString = "チョキ";
        } else if (e.getSource() == paperButton) {
            userChoiceString = "パー";
        }

        userChoiceLabel.setText("あなたの選択: " + userChoiceString);
        computerChoiceLabel.setText("コンピュータの選択: " + computerChoiceString);

        String result;
        if (userChoiceString.equals(computerChoiceString)) {
            result = "引き分けです！";
        } else if ((userChoiceString.equals("グー") && computerChoiceString.equals("チョキ")) ||
                   (userChoiceString.equals("チョキ") && computerChoiceString.equals("パー")) ||
                   (userChoiceString.equals("パー") && computerChoiceString.equals("グー"))) {
            result = "あなたの勝ちです！";
        } else {
            result = "コンピュータの勝ちです！";
        }

        resultLabel.setText("結果: " + result);
    }

    public static void main(String[] args) {
        JankenGameGUI game = new JankenGameGUI();
        game.setVisible(true);
    }
}
