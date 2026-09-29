import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class FortuneTellerFrame extends JFrame {
  JPanel mainPnl;
  JPanel topPnl;
  JPanel middlePnl;
  JPanel bottomPnl;

  JLabel titleLbl;
  ImageIcon image;
  JTextArea textArea;
  JScrollPane scroll;
  JButton fortuneBtn;
  JButton quitBtn;
  int newIndex;
  int currentFortune = -1;
  Random rnd = new Random();

  String fortunes[] = new String[12];

  public FortuneTellerFrame(){
      loadFortunes();
      setTitle("Fortune Teller");
      mainPnl = new JPanel();
      mainPnl.setLayout(new BorderLayout());
      add(mainPnl);
      createTopPnl();
      createMiddlePnl();
      createBottomPnl();

      Toolkit kit = Toolkit.getDefaultToolkit();
      Dimension screenSize = kit.getScreenSize();
      int width = (int) (screenSize.width * 0.75);
      int height = (int) (screenSize.height * 0.75);
      setSize(width, height);
      setLocationRelativeTo(null);

      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setVisible(true);
  }

  public void createTopPnl() {
      topPnl = new JPanel();
      image = new ImageIcon("src/FortuneTeller.jpg");
      image = new ImageIcon(image.getImage().getScaledInstance(300, 300, 4));
      titleLbl = new JLabel(image);
      titleLbl.setText("Fortune Teller!");
      Font titleFont = new Font("Serif", Font.BOLD, 48);
      titleLbl.setFont(titleFont);
      titleLbl.setHorizontalTextPosition(JLabel.CENTER);
      titleLbl.setVerticalTextPosition(JLabel.TOP);
      topPnl.add(titleLbl);
      mainPnl.add(topPnl, BorderLayout.NORTH);
  }

  public void createMiddlePnl() {
      middlePnl = new JPanel();
      textArea = new JTextArea(10,40);
      textArea.setEditable(false);
      textArea.setFocusable(false);
      textArea.setLineWrap(true);
      Font textFont = new Font("SansSerif", Font.PLAIN, 18);
      textArea.setFont(textFont);
      scroll = new JScrollPane(textArea);
      middlePnl.add(scroll);
      mainPnl.add(middlePnl, BorderLayout.CENTER);
  }

  public void createBottomPnl() {
      bottomPnl = new JPanel();
      fortuneBtn = new JButton();
      quitBtn = new JButton();
      bottomPnl.setLayout(new GridLayout(1,2));
      fortuneBtn.setText("Read my Fortune");
      quitBtn.setText("Quit");
      Font btnFont = new Font("SansSerif", Font.BOLD, 18);
      fortuneBtn.setFont(btnFont);
      quitBtn.setFont(btnFont);
      fortuneBtn.addActionListener(e -> displayNextFortune());
      quitBtn.addActionListener(e -> System.exit(0));
      bottomPnl.add(fortuneBtn);
      bottomPnl.add(quitBtn);
      mainPnl.add(bottomPnl, BorderLayout.SOUTH);
  }

  private void loadFortunes(){
      fortunes[0] = "A pleasant surprise will be waiting for you!";
      fortunes[1] = "Today is not your day";
      fortunes[2] = "You will receive good news soon";
      fortunes[3] = "You will lose your prized possession";
      fortunes[4] = "The truth will come out when you least expect it";
      fortunes[5] = "ERROR 404: Fortune Not Found";
      fortunes[6] = "Your career will start to lift off";
      fortunes[7] = "Watch your back...";
      fortunes[8] = "You will find $100 on the ground";
      fortunes[9] = "You will forget your password";
      fortunes[10] = "You make people smile without even trying";
      fortunes[11] = "Bad things are coming your way very soon...";
  }
  private void displayNextFortune(){
      do{
          newIndex = rnd.nextInt(fortunes.length);
      }
      while (newIndex == currentFortune);
      currentFortune = newIndex;
      textArea.append(fortunes[currentFortune] + "\n");
  }
}