import javax.swing.*; //Swing全般
import java.awt.*; //GUI基本クラス
import java.util.ArrayList; //リスト
import java.util.Random; //ランダム

public class BingoCard {
    public static void main(String[] args){
        //JFrameでウィンドウの作成
        JFrame frame = new JFrame("BINGO");
        
        //ウィンドウ設定
        frame.setTitle("BINGO");
        frame.setBounds(500,50,500,650); //サイズと位置
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
        frame.getContentPane().setBackground(Color.ORANGE);

        //各列上のBINGO文字表示
        JLabel label = new JLabel("B  I  N G O");
        label.setFont(new Font("Arial", Font.BOLD, 90));
        label.setForeground(Color.BLUE);
        label.setBounds(22, 10, 500, 100);
        frame.add(label);

        //各列の数を格納したリストを作成
        ArrayList<Integer> col1 = new ArrayList<Integer>();
        for (int i=1; i<=15; i++){col1.add(i);}
        ArrayList<Integer> col2 = new ArrayList<Integer>();
        for (int i=16; i<=30; i++){col2.add(i);}
        ArrayList<Integer> col3 = new ArrayList<Integer>();
        for (int i=31; i<=45; i++){col3.add(i);}
        ArrayList<Integer> col4 = new ArrayList<Integer>();
        for (int i=46; i<=60; i++){col4.add(i);}
        ArrayList<Integer> col5 = new ArrayList<Integer>();
        for (int i=61; i<=75; i++){col5.add(i);}

        Random rdm = new Random();
        JButton[] buttons = new JButton[25]; //ボタン判定用リスト
        boolean[] checked = new boolean[25]; //ボタン状態確認
        JLabel resultLabel = new JLabel(""); //判定表示用ラベル
        resultLabel.setFont(new Font("Arial", Font.BOLD, 30));
        resultLabel.setForeground(Color.RED);
        resultLabel.setBounds(180, 550, 200, 50);
        frame.add(resultLabel);

        //ウィンドウ内に1列分のパネル作成
        JPanel buttonPanel1 = new JPanel();
        buttonPanel1.setLayout(new GridLayout(5, 1));
        buttonPanel1.setBounds(8, 110, 90, 450);
        //パネルにボタン作成
        for (int i = 0; i < 5; i++) {
            JButton button = new JButton();
            button.setFont(new Font("Arial", Font.BOLD, 36));
            buttons[i] = button; //リストに格納
            buttonPanel1.add(button);
            //乱数生成取得
            int makeRandom = rdm.nextInt(col1.size()); //size()でリスト内の要素数
            int randomNum = col1.get(makeRandom);
            col1.remove(Integer.valueOf(randomNum)); //選ばれた数をリストから削除
            button.setText(String.valueOf(randomNum)); //選ばれた数をボタンに表示
            final int index = i;
            //ボタンを押すと○を付け，もう一度押すと戻す
            boolean[] isNumberDisplayed = {true}; //ボタンをbooleanで切り替え
            button.addActionListener(e -> {
                if (isNumberDisplayed[0]) {
                    button.setText("○");
                    button.setForeground(Color.RED);
                    checked[index] = true; //状態チェック
                }
                else {
                    button.setText(String.valueOf(randomNum)); //数字に戻す
                    button.setForeground(Color.BLACK);
                    checked[index] = false;
                }
                isNumberDisplayed[0] = !isNumberDisplayed[0]; //boolean切り替え
                checkBingo(checked, resultLabel);
            });
        }
        JPanel buttonPanel2 = new JPanel(); //2列目
        buttonPanel2.setLayout(new GridLayout(5, 1));
        buttonPanel2.setBounds(103, 110, 90, 450);
        for (int i = 5; i < 10; i++) {
            JButton button = new JButton();
            button.setFont(new Font("Arial", Font.BOLD, 36));
            buttons[i] = button;
            buttonPanel2.add(button);
            int makeRandom = rdm.nextInt(col2.size());
            int randomNum = col2.get(makeRandom);
            col2.remove(Integer.valueOf(randomNum));
            button.setText(String.valueOf(randomNum));
            final int index = i;
            boolean[] isNumberDisplayed = {true};
            button.addActionListener(e -> {
                if (isNumberDisplayed[0]) {
                    button.setText("○");
                    button.setForeground(Color.RED);
                    checked[index] = true;
                }
                else {
                    button.setText(String.valueOf(randomNum));
                    button.setForeground(Color.BLACK);
                    checked[index] = false;
                }
                isNumberDisplayed[0] = !isNumberDisplayed[0];
                checkBingo(checked, resultLabel);
            });
        }
        JPanel buttonPanel3 = new JPanel(); //3列目
        buttonPanel3.setLayout(new GridLayout(5, 1));
        buttonPanel3.setBounds(198, 110, 90, 450);
        for (int i = 10; i < 15; i++) {
            JButton button = new JButton();
            button.setFont(new Font("Arial", Font.BOLD, 36));
            buttons[i] = button;
            buttonPanel3.add(button);
            if(i==12){
                button.setText(String.valueOf("FREE")); //中央をFREEに
                button.setFont(new Font("Arial", Font.BOLD, 21));
                final int index = i;
                boolean[] isNumberDisplayed = {true};
                button.addActionListener(e -> {
                if (isNumberDisplayed[0]) {
                    button.setText("○");
                    button.setForeground(Color.RED);
                    checked[index] = true;
                }
                else {
                    button.setText(String.valueOf("FREE"));
                    button.setForeground(Color.BLACK);
                    checked[index] = false;
                }
                isNumberDisplayed[0] = !isNumberDisplayed[0];
                checkBingo(checked, resultLabel);
                });
            }
            else{
                int makeRandom = rdm.nextInt(col3.size());
                int randomNum = col3.get(makeRandom);
                col3.remove(Integer.valueOf(randomNum));
                button.setText(String.valueOf(randomNum));
                final int index = i;
                boolean[] isNumberDisplayed = {true};
                button.addActionListener(e -> {
                if (isNumberDisplayed[0]) {
                    button.setText("○");
                    button.setForeground(Color.RED);
                    checked[index] = true;
                }
                else {
                    button.setText(String.valueOf(randomNum));
                    button.setForeground(Color.BLACK);
                    checked[index] = false;
                }
                isNumberDisplayed[0] = !isNumberDisplayed[0];
                checkBingo(checked, resultLabel);
                });
            }
        }
        JPanel buttonPanel4 = new JPanel(); //4列目
        buttonPanel4.setLayout(new GridLayout(5, 1));
        buttonPanel4.setBounds(293, 110, 90, 450);
        for (int i = 15; i < 20; i++) {
            JButton button = new JButton();
            button.setFont(new Font("Arial", Font.BOLD, 36));
            buttons[i] = button;
            buttonPanel4.add(button);
            int makeRandom = rdm.nextInt(col4.size());
            int randomNum = col4.get(makeRandom);
            col4.remove(Integer.valueOf(randomNum));
            button.setText(String.valueOf(randomNum));
            final int index = i;
            boolean[] isNumberDisplayed = {true};
            button.addActionListener(e -> {
                if (isNumberDisplayed[0]) {
                    button.setText("○");
                    button.setForeground(Color.RED);
                    checked[index] = true;
                }
                else {
                    button.setText(String.valueOf(randomNum));
                    button.setForeground(Color.BLACK);
                    checked[index] = false;
                }
                isNumberDisplayed[0] = !isNumberDisplayed[0];
                checkBingo(checked, resultLabel);
            });
        }
        JPanel buttonPanel5 = new JPanel(); //5列目
        buttonPanel5.setLayout(new GridLayout(5, 1));
        buttonPanel5.setBounds(388, 110, 90, 450);
        for (int i = 20; i < 25; i++) {
            JButton button = new JButton();
            button.setFont(new Font("Arial", Font.BOLD, 36));
            buttons[i] = button;
            buttonPanel5.add(button);
            int makeRandom = rdm.nextInt(col5.size());
            int randomNum = col5.get(makeRandom);
            col5.remove(Integer.valueOf(randomNum));
            button.setText(String.valueOf(randomNum));
            final int index = i;
            boolean[] isNumberDisplayed = {true};
            button.addActionListener(e -> {
                if (isNumberDisplayed[0]) {
                    button.setText("○");
                    button.setForeground(Color.RED);
                    checked[index] = true;
                }
                else {
                    button.setText(String.valueOf(randomNum));
                    button.setForeground(Color.BLACK);
                    checked[index] = false;
                }
                isNumberDisplayed[0] = !isNumberDisplayed[0];
                checkBingo(checked, resultLabel);
            });
        }
        frame.add(buttonPanel1);
        frame.add(buttonPanel2);
        frame.add(buttonPanel3);
        frame.add(buttonPanel4);
        frame.add(buttonPanel5);
        frame.setVisible(true);
    }

    //リーチとビンゴ判定用の関数
    public static void checkBingo(boolean[] checked, JLabel resultLabel) {
        boolean bingo = false;
        boolean reach = false;

        int[][] bingoPatterns = {
            {0, 1, 2, 3, 4}, {5, 6, 7, 8, 9}, {10, 11, 12, 13, 14},
            {15, 16, 17, 18, 19}, {20, 21, 22, 23, 24},  //横
            {0, 5, 10, 15, 20}, {1, 6, 11, 16, 21}, {2, 7, 12, 17, 22}, 
            {3, 8, 13, 18, 23}, {4, 9, 14, 19, 24},  //縦
            {0, 6, 12, 18, 24}, {4, 8, 12, 16, 20}   //斜め
        };

        //パターンごとに判定
        for (int[] pattern : bingoPatterns) {
            int count = 0;
            for (int i : pattern) {
                if (checked[i]) count++;
            }
            if (count == 4) reach = true;
            if (count == 5) bingo = true;
        }

        //判定表示
        if (bingo) {
            resultLabel.setText("ビンゴ！");
        } else if (reach) {
            resultLabel.setText("リーチ！");
        } else {
            resultLabel.setText("");
        }
        resultLabel.setFont(new Font("MS Gothic", Font.BOLD, 30));  //文字化け防止
    }
}