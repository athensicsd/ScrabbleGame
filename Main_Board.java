
//icsd18250
//icsd14149


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import static java.lang.Math.abs;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
//import static Game_button.buttons_pressed;

public class Main_Board implements ActionListener {
    //file
    Set<String> dictionary = new HashSet<String>();//periexei tis lekseis
    
    //========
    private static int staticI;
    private static int staticJ;
    
    private int vathmologiaTelikh, lekseisVrhkes, wordFlag, correctWord;
   
    //========
    private String teleutaiaLeksh="";
    private int currentWordScore;
    private boolean doubleWord= false;
    
    //deksi meros voh9eiwn
    private String firstHelp="3" ;
    private String secondHelp="3" ;
    private String thirdHelp="3" ;
    private String fourthHelp="5" ;
    private String fifthHelp="6" ;
    //top right metavlhtes
    private int theRow;//pairnei to textField didagrafhs
    private int rowsLeft;//aristero meros /
    
    private int theColumn;
    private int anadiatakshSthlhsLeft;//textField 3
    private LinkedList<String> allaghGrammhs = new LinkedList<>();//krataei ta grammata gia thn anadiataksh
    private LinkedList<String> allaghSthlhs = new LinkedList<>();//krataei ta grammata gia thn anadiataksh
    private LinkedList<String> grammataTablo = new LinkedList<>();
    
    private int anadiatakshGrammhsLeft;//textField 2
    private int tableLeft;
    private int grammataLeft;
    private int anadiatakshVohtheia=5;
    
    private String ss;
    private Random rand = new Random();
    private Game_Board newBoard = new Game_Board();//dhmiourgia neou board
    private final JPanel topRight = new JPanel(); //voh9eies
    private final JPanel botRight = new JPanel();//stoxos klp
    private final JPanel botLeft = new JPanel();//elegxos leksis k nickname
    private final JPanel button_panel = new JPanel();//tablo
    private final JPanel mainPanel = new JPanel();//se auto 9a mpoun ta alla 4 panel

    //Gia to botright
    private JLabel stoxos = new JLabel();
    private JLabel sunolikhVathmologia = new JLabel();
    private JLabel VathmologiaLekshs = new JLabel();
    private JLabel lekseisVrethikan = new JLabel();
    private JLabel sugxarhthria = new JLabel();

    private JLabel target = new JLabel();
    private JLabel overallScore = new JLabel();
    private JLabel wordScore = new JLabel();
    private JLabel foundWords = new JLabel();
    private JLabel lastFoundWord = new JLabel();

    //gia to top right
    private final JPanel help = new JPanel();
    private final JPanel pDelete = new JPanel();
    private final JPanel pRows = new JPanel();
    private final JPanel pColumns = new JPanel();
    private final JPanel pTable = new JPanel();
    private final JPanel pGrammata = new JPanel();

    private JLabel voh9eies = new JLabel();
    private JButton diagrafh = new JButton();
    private JButton anadiatakshGrammhs = new JButton();
    private JButton anadiatakshSthlhs = new JButton();
    private JButton anadiatakshTablo = new JButton();
    private JButton enallaghGrammatwn = new JButton();

    private JTextField diagrafhs = new JTextField();
    private JLabel delete = new JLabel();
    private JTextField anadadiatakshsGrammhs = new JTextField();
    private JLabel rows = new JLabel();
    private JTextField anadiatakshsSthlhs = new JTextField();
    private JLabel columns = new JLabel();
    private JLabel table = new JLabel();
    private JLabel grammata = new JLabel();

//gia to frame kai to menu
    private final JFrame frame = new JFrame("Βρες την λέξη");//to mainFrame

    private final JLabel paikthStoixeia = new JLabel();
    private String name;

    //gia to botleft
    private JButton elegxos  = new JButton();
    
    private final JMenuBar menuBar;
    private final JMenu menu;
    private final JMenu ergaleia;
    private final JMenuItem newGame;
    private final JMenuItem endGame;
    private final JMenuItem stoixeia;
    private final JMenuItem ru9miseis;
    private final JMenuItem arxeio;
    private final JMenuItem exit;
    private final JMenuItem helps;
    private final JMenuItem about;

    public Main_Board() {
        
        fileWork();//vazei tis lekseis tou arxeiou se HashSet

        paikthStoixeia.setFont(new Font("", Font.BOLD, 20));

        paikthStoixeia.setForeground(new java.awt.Color(255,153,0));
        name = JOptionPane.showInputDialog("Enter your nickname");//zhteite to onoma tou xrhsth kata thn enarksh tou paixnidiou
        paikthStoixeia.setText("     Nickname : " + name);
        
        menuBar = new JMenuBar();
        menu = new JMenu("Μενού");
        ergaleia = new JMenu("Εργαλεία");
        newGame = new JMenuItem("Νέο παιχνίδι");
        endGame = new JMenuItem("Ακύρωση/Τερματισμός παιχνιδιού");
        stoixeia = new JMenuItem("Εισαγωγή στοιχείων παίχτη");
        ru9miseis = new JMenuItem("Ρυθμίσεις βοηθειών");
        arxeio = new JMenuItem("Αναζήτηση αρχείου λέξεων");
        exit = new JMenuItem("Έξοδος");
        helps = new JMenuItem("Βοήθεια");
        about = new JMenuItem("About...");

        newGame.addActionListener(this);
        endGame.addActionListener(this);
        stoixeia.addActionListener(this);
        ru9miseis.addActionListener(this);
        arxeio.addActionListener(this);
        exit.addActionListener(this);
        helps.addActionListener(this);
        about.addActionListener(this);

        menu.add(newGame);
        menu.add(endGame);
        menu.add(stoixeia);
        menu.add(ru9miseis);
        menu.add(arxeio);
        menu.add(exit);
        ergaleia.add(helps);
        ergaleia.add(about);
        menuBar.add(menu);
        menuBar.add(ergaleia);
        
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1000, 1000);
        frame.getContentPane();
        frame.setLayout(new BorderLayout());
        frame.setVisible(true);

        mainPanel.setLayout(new GridLayout(2, 2));

        botLeft.setLayout(new GridLayout(2, 1));
        botLeft.setBackground(new java.awt.Color(0, 102, 102));
        botRight.setLayout(new GridLayout(5, 2));
        botRight.setBackground(new java.awt.Color(128, 128, 128));

        topRight.setBackground(Color.LIGHT_GRAY.darker());
        topRight.setLayout(new GridLayout(6, 1));

        //top right
        FlowLayout flo = new FlowLayout();
        help.setLayout(flo);
        help.setBackground(new java.awt.Color(128, 128, 128));
        pDelete.setLayout(flo);
        pDelete.setBackground(new java.awt.Color(0, 102, 102));
        pRows.setLayout(flo);
        pRows.setBackground(new java.awt.Color(0, 102, 102));
        pColumns.setLayout(flo);
        pColumns.setBackground(new java.awt.Color(0, 102, 102));
        pTable.setLayout(flo);
        pTable.setBackground(new java.awt.Color(0, 102, 102));
        pGrammata.setLayout(flo);
        pGrammata.setBackground(new java.awt.Color(0, 102, 102));

        voh9eies = new JLabel("Βοήθειες:");
        help.add(voh9eies);

        diagrafh = new JButton("Διαγραφή Γραμμής");
        diagrafh.setBackground(new java.awt.Color(204, 0, 153));
        diagrafh.setFocusable(false);
        diagrafh.addActionListener(this);
        pDelete.add(diagrafh);
        diagrafhs = new JTextField(2);
        diagrafhs.setBackground(Color.LIGHT_GRAY);
        diagrafhs.setFont(new Font("Consolas", Font.BOLD, 16));
        diagrafhs.setBounds(400, 400, 300, 50);
        delete = new JLabel("0/3");
        pDelete.add(diagrafhs);
        pDelete.add(delete);

        anadiatakshGrammhs = new JButton("Αναδιάταξη Γραμμής");
        anadiatakshGrammhs.setBackground(new java.awt.Color(204, 0, 153));
        anadiatakshGrammhs.setFocusable(false);
        anadiatakshGrammhs.addActionListener(this);
        pRows.add(anadiatakshGrammhs);
        anadadiatakshsGrammhs = new JTextField(2);
        anadadiatakshsGrammhs.setBackground(Color.LIGHT_GRAY);
        anadadiatakshsGrammhs.setFont(new Font("Consolas", Font.BOLD, 16));
        anadadiatakshsGrammhs.setBounds(220, 20, 200, 30);
        rows = new JLabel("0/3");
        pRows.add(anadadiatakshsGrammhs);
        pRows.add(rows);

        anadiatakshSthlhs = new JButton("Αναδιάταξη Στήλης");
        anadiatakshSthlhs.setBackground(new java.awt.Color(204, 0, 153));
        anadiatakshSthlhs.setFocusable(false);
        anadiatakshSthlhs.addActionListener(this);
        pColumns.add(anadiatakshSthlhs);
        anadiatakshsSthlhs = new JTextField(2);
        anadiatakshsSthlhs.setBackground(Color.LIGHT_GRAY);
        anadiatakshsSthlhs.setFont(new Font("Consolas", Font.BOLD, 16));
        anadiatakshsSthlhs.setBounds(220, 20, 200, 30);
        columns = new JLabel("0/3");
        pColumns.add(anadiatakshsSthlhs);
        pColumns.add(columns);

        anadiatakshTablo = new JButton("Αναδιάταξη Ταμπλό");
        anadiatakshTablo.setBackground(new java.awt.Color(204, 0, 153));
        anadiatakshTablo.setFocusable(false);
        anadiatakshTablo.addActionListener(this);
        pTable.add(anadiatakshTablo);
        table = new JLabel("0/5");
        pTable.add(table);

        enallaghGrammatwn = new JButton("Εναλλαγή Γραμμάτων");
        enallaghGrammatwn.setBackground(new java.awt.Color(204, 0, 153));
        enallaghGrammatwn.setFocusable(false);
        enallaghGrammatwn.addActionListener(this);
        pGrammata.add(enallaghGrammatwn);
        grammata = new JLabel("0/6");
        pGrammata.add(grammata);

        //prosthetoume ta 6 panelakia sto top right
        topRight.add(help);
        topRight.add(pDelete);
        topRight.add(pRows);
        topRight.add(pColumns);
        topRight.add(pTable);
        topRight.add(pGrammata);

        //botright
        stoxos = new JLabel("Στόχος:");
        botRight.add(stoxos);
        target = new JLabel("50");
        botRight.add(target);

        sunolikhVathmologia = new JLabel("Συνολική Βαθμολογία:");
        botRight.add(sunolikhVathmologia);
        overallScore = new JLabel("0");
        botRight.add(overallScore);

        VathmologiaLekshs = new JLabel("Βαθμολογία Λέξης:");
        botRight.add(VathmologiaLekshs);
        wordScore = new JLabel("0");
        botRight.add(wordScore);

        lekseisVrethikan = new JLabel("Λέξεις που βρέθηκαν:");
        botRight.add(lekseisVrethikan);
        foundWords = new JLabel("0");
        botRight.add(foundWords);

        sugxarhthria = new JLabel("Συγχαρητήρια βρήκες την λέξη:");
        botRight.add(sugxarhthria);
        lastFoundWord = new JLabel("_____");
        botRight.add(lastFoundWord);

        //botleft
        elegxos = new JButton("Έλεγχος Λέξης");
        elegxos.setBackground(new java.awt.Color(0,0,0));
        elegxos.setForeground(new java.awt.Color(204, 0, 153));
        elegxos.addActionListener(this);
        botLeft.add(elegxos );
        botLeft.add(paikthStoixeia);

        //topleft
        button_panel.setLayout(new GridLayout(8, 8));
        button_panel.setBackground(new Color(150, 150, 150));
        button_panel.setLayout(new GridLayout(8, 8));
        button_panel.setBackground(new Color(150, 150, 150));

        for(int i=0; i<8; i++){
            for(int j=0; j<8; j++) {
                newBoard.game_Buttons[i][j].addActionListener(this);
                button_panel.add(newBoard.game_Buttons[i][j]);
                newBoard.game_Buttons[i][j].setBackground(Color.white);
                newBoard.game_Buttons[i][j].setFocusable(false);
            }
        }
        
        mainPanel.add(button_panel);
        mainPanel.add(topRight);
        mainPanel.add(botLeft);
        mainPanel.add(botRight);
        frame.add(mainPanel);
        frame.setJMenuBar(menuBar);
        frame.setLocationRelativeTo(null);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        if (e.getSource() == diagrafh) {
             try{//try catch gia na mhn prospa9ei o xrhsths na parei voh9eia ektos oriwn pinaka
                theRow = Integer.parseInt(diagrafhs.getText());
                for(int i=0; i<8; i++) {
                    ss = newBoard.keys.get(rand.nextInt(26));
                    newBoard.game_Buttons[theRow][i].setText(ss);
                    newBoard.game_Buttons[theRow][i].setLetter(ss);
                    newBoard.game_Buttons[theRow][i].setValue(newBoard.all_the_letters.get(ss));
                }
                    rowsLeft++;
                    delete.setText(rowsLeft+"/"+firstHelp);
                    if(rowsLeft == Integer.parseInt(firstHelp)) {
                        diagrafh.setEnabled(false);
                        delete.setForeground(Color.red);
                        diagrafhs.setEditable(false);
                    }
             }
             catch (ArrayIndexOutOfBoundsException | NumberFormatException outOfBounds) {
                JOptionPane.showMessageDialog(null, "Βγαίνεις έξω από τα όρια του πίνακα",
"Πληροφορίες", JOptionPane.INFORMATION_MESSAGE);
            }

            } else if (e.getSource() == anadiatakshSthlhs) {
                 try {
                    theColumn = Integer.parseInt(anadiatakshsSthlhs.getText());
                for(int i=0; i<8; i++) {
                    allaghSthlhs.add(newBoard.game_Buttons[i][theColumn].getText());
                }
                int temp= 8;
                int randoms;
                for(int i=0; i<8; i++) {
                    randoms = rand.nextInt(temp);
                    newBoard.game_Buttons[i][theColumn].setText(allaghSthlhs.get(randoms));
                    newBoard.game_Buttons[i][theColumn].setLetter(allaghSthlhs.get(randoms));
                    newBoard.game_Buttons[i][theColumn].setValue(newBoard.all_the_letters.get(newBoard.game_Buttons[i][theColumn].getLetter()));
                
                    allaghSthlhs.remove(randoms);
                    temp--;
                }
                anadiatakshSthlhsLeft++;
                columns.setText(anadiatakshSthlhsLeft+"/"+thirdHelp);
                if(anadiatakshSthlhsLeft==Integer.parseInt(thirdHelp)) {
                    anadiatakshSthlhs.setEnabled(false);
                    columns.setForeground(Color.red);
                    anadiatakshsSthlhs.setEditable(false);
                }
                }   
            catch (ArrayIndexOutOfBoundsException | NumberFormatException outOfBounds) {
                JOptionPane.showMessageDialog(null, "Βγαίνεις έξω από τα όρια του πίνακα",
"Πληροφορίες", JOptionPane.INFORMATION_MESSAGE);
            }
            }
            else if (e.getSource() == anadiatakshGrammhs) {
                try{
                theRow = Integer.parseInt(anadadiatakshsGrammhs.getText());
                for (int i=0; i<8; i++) {
                    allaghGrammhs.add(newBoard.game_Buttons[theRow][i].getText());
                }
                int temp = 8;
                int randoms;
                for(int i=0; i<8; i++) {
                    randoms = rand.nextInt(temp);
                    newBoard.game_Buttons[theRow][i].setText(allaghGrammhs.get(randoms));
                    newBoard.game_Buttons[theRow][i].setLetter(allaghGrammhs.get(randoms));
                    newBoard.game_Buttons[theRow][i].setValue(newBoard.all_the_letters.get(newBoard.game_Buttons[theRow][i].getLetter()));
                
                    allaghGrammhs.remove(randoms);
                    temp--;
                }
                anadiatakshGrammhsLeft++;
                rows.setText((anadiatakshGrammhsLeft+"/"+secondHelp));
                if(anadiatakshGrammhsLeft==Integer.parseInt(secondHelp)) {
                    anadiatakshGrammhs.setEnabled(false);
                    rows.setForeground(Color.red);
                    anadadiatakshsGrammhs.setEditable(false);
                }
            }
            catch (ArrayIndexOutOfBoundsException | NumberFormatException outOfBounds) {
                JOptionPane.showMessageDialog(null, "Βγαίνεις έξω από τα όρια του πίνακα",
"Πληροφορίες", JOptionPane.INFORMATION_MESSAGE);
            }
            }
            else if (e.getSource() == anadiatakshTablo) {
                for (int i=0; i<8; i++) {//antigrafh olwn twn grammatwn sthn lista grammataTablo
                    for (int j=0; j<8; j++) {
                        grammataTablo.add(newBoard.game_Buttons[i][j].getText());
                    }
                }
            int randomNum;
            for (int i=0; i<8; i++) {
                for( int j=0; j<8; j++) {
                randomNum=rand.nextInt(grammataTablo.size());
                
                
                newBoard.game_Buttons[i][j].setText(grammataTablo.get(randomNum));
                newBoard.game_Buttons[i][j].setLetter(grammataTablo.get(randomNum));
                newBoard.game_Buttons[i][j].setValue(newBoard.all_the_letters.get(grammataTablo.get(randomNum)));
                
                grammataTablo.remove(randomNum);
            }
            }
            
                tableLeft++;
                table.setText(tableLeft+"/"+anadiatakshVohtheia) ;
                if(tableLeft == anadiatakshVohtheia) {
                anadiatakshTablo.setEnabled(false);
                table.setForeground(Color.red);     
            }
        }
        else if (e.getSource() == exit) {
                System.exit(0);
            } else if (e.getSource() == endGame) {
                JOptionPane.showMessageDialog(null, "Game Over","U LOST !",JOptionPane.ERROR_MESSAGE);
                System.exit(0);
            } else if (e.getSource() == about) {
                JOptionPane.showMessageDialog(null, "Ευχαριστούμε που παιξατε\nΕίμασταν οι 14149, 18250","About Us",JOptionPane.DEFAULT_OPTION);
            } else if (e.getSource() == helps) {
                JOptionPane.showMessageDialog(null, "Κανόνες:\nΠροσπάθησε να συμπληρώσεις τους πόντους επιλέγοντας τα σώστα γραμματα.\nΑν δεν τα καταφέρνεις χρησιμοποίησε τις βοήθειες.","Help",JOptionPane.DEFAULT_OPTION);
            }  else if (e.getSource() == stoixeia) {
                name = JOptionPane.showInputDialog("Enter your nickname");
                paikthStoixeia.setText("     Nickname : "+name);
            }   else if (e.getSource() == ru9miseis) {
                String[] threeHelp = {"1","2","3"};
                String[] fiveHelp = {"1","2","3","4","5"};
                String[] sixHelp = {"1","2","3","4","5","6"};
        
                JComboBox combo1 = new JComboBox(threeHelp);
                JComboBox combo2 = new JComboBox(threeHelp);
                JComboBox combo3 = new JComboBox(threeHelp);
                JComboBox combo4 = new JComboBox(fiveHelp);
                JComboBox combo5 = new JComboBox(sixHelp);
                combo1.setSelectedIndex(2);
                combo2.setSelectedIndex(2);
                combo3.setSelectedIndex(2);
                combo4.setSelectedIndex(4);
                combo5.setSelectedIndex(5);
                
                
                Object[] combos = {
                    "Διαγραφή Γραμμής:",combo1,
                    "Αναδιάταξη Γραμμής:", combo2,
                    "Αναδιάταξη Στήλης", combo3,
                    "Αναδιάταξη Ταμπλό", combo4,
                    "Εναλλαγή Γραμμής", combo5
                };
                JOptionPane.showConfirmDialog(null,combos, "Ρύθμιση Βοηθειών",JOptionPane.OK_CANCEL_OPTION);
                firstHelp = combo1.getSelectedItem().toString();
                delete.setText(rowsLeft+"/"+firstHelp);
                if(rowsLeft> Integer.parseInt(firstHelp)) {
                    diagrafh.setEnabled(false);
                    delete.setForeground(Color.red);
                    diagrafhs.setEditable(false);
                }
                secondHelp = combo2.getSelectedItem().toString();
                rows.setText(anadiatakshGrammhsLeft+"/"+secondHelp);
                if(anadiatakshGrammhsLeft> Integer.parseInt(secondHelp)) {
                    anadiatakshGrammhs.setEnabled(false);
                    rows.setForeground(Color.red);
                    anadadiatakshsGrammhs.setEditable(false);
                }
                thirdHelp = combo3.getSelectedItem().toString();
                columns.setText(anadiatakshSthlhsLeft+"/"+thirdHelp);
                if(anadiatakshSthlhsLeft>Integer.parseInt(thirdHelp)) {
                    anadiatakshSthlhs.setEnabled(false);
                    columns.setForeground(Color.red);
                    anadiatakshsSthlhs.setEditable(false);
                }
                fifthHelp = combo5.getSelectedItem().toString();
                grammata.setText(grammataLeft+"/"+fifthHelp);
                if(grammataLeft>Integer.parseInt(fifthHelp)) {
                    enallaghGrammatwn.setEnabled(false);
                    grammata.setForeground(Color.red);
                    
                }
                
            }
        for (int i=0; i<8; i++) {
            for (int j=0; j<8; j++) {
                if (e.getSource() == newBoard.game_Buttons[i][j]) {
                    
                    staticI = i;
                    staticJ = j;
                    
                    Game_button.buttons_pressed.add(newBoard.game_Buttons[i][j]);//kratame to koumpi
                    teleutaiaLeksh+= newBoard.game_Buttons[i][j].getText();//kratame th leksh
                    if ( newBoard.game_Buttons[i][j].getBackground()== Color.white) {
                        currentWordScore+=newBoard.game_Buttons[i][j].getValue();
                        newBoard.game_Buttons[i][j].setBackground(Color.yellow);
                    } else if ( newBoard.game_Buttons[i][j].getBackground()== Color.red) {
                        currentWordScore += newBoard.game_Buttons[i][j].getValue();
                        newBoard.game_Buttons[i][j].setBackground(Color.yellow);
                    } else if ( newBoard.game_Buttons[i][j].getBackground()== Color.blue) {
                        doubleWord = true;
                        newBoard.game_Buttons[i][j].setBackground(Color.yellow);
                    } else if (Game_button.buttonHash(newBoard.game_Buttons[i][j]) == Game_button.buttonHash(Game_button.buttons_pressed.get(Game_button.buttons_pressed.size()-2))) {
                        newBoard.game_Buttons[i][j].setBackground(Color.white);//an ksanapathsei to teleytaio koumpi
                        currentWordScore -= newBoard.game_Buttons[i][j].getValue();
                        Game_button.buttons_pressed.remove(newBoard.game_Buttons[i][j]);
                        
                    } 
                    wordScore.setText(Integer.toString(currentWordScore));
                }
            }
        }
        if(e.getSource() == elegxos) {//an  pathseis elegxos lekshs
                   for (String str : dictionary){
                       if ( str.equals(teleutaiaLeksh) ) {
                           correctWord=1;
                       }
                   }
                   if (correctWord == 1){
                        for (int i=0; i<8; i++) {
                        for (int j=0; j<8; j++) {
                            if(newBoard.game_Buttons[i][j].getBackground() == Color.yellow) {
                                newBoard.game_Buttons[i][j].setBackground(Color.white);
                                newBoard.game_Buttons[i][j].setText(newBoard.keys.get(rand.nextInt(26)));
                                newBoard.game_Buttons[i][j].setLetter(newBoard.keys.get(rand.nextInt(26)));
                                newBoard.game_Buttons[i][j].setValue(newBoard.all_the_letters.get(newBoard.keys.get(rand.nextInt(26))));
                                wordFlag=1;
                            }
                        }
                    }
                   
                    
                    wordScore.setText("0");
                    vathmologiaTelikh+= currentWordScore;
                    if (wordFlag == 1) {
                        wordFlag = 0 ;
                        lekseisVrhkes++;
                        foundWords.setText(Integer.toString(lekseisVrhkes));
                        lastFoundWord.setText(teleutaiaLeksh);
                        teleutaiaLeksh = "";
                    }
                    overallScore.setText(Integer.toString(vathmologiaTelikh));
                    
                    currentWordScore=0;
                    
                    if (vathmologiaTelikh >= 50) {
                        JOptionPane.showMessageDialog(null, "Winner Winner chicken dinner!",
"Congratulations", JOptionPane.INFORMATION_MESSAGE);
                        System.exit(0);
                    }
                    
                   } else {
                       for (int i=0; i<8; i++) {
                        for (int j=0; j<8; j++) {
                            if(newBoard.game_Buttons[i][j].getBackground() == Color.yellow) {
                                newBoard.game_Buttons[i][j].setBackground(Color.white);
                                currentWordScore=0;
                                teleutaiaLeksh = "";
                            }
                        }
                    }
                   }
                   
                }
            
    }
    
    public boolean check_neighbor() {
        Game_button last_button = new Game_button();//copy the last button pressed
        /*last_button.setRow(Game_button.buttons_pressed.get(buttons_pressed.size()-1).getRow());
        last_button.setColumn(Game_button.buttons_pressed.get(buttons_pressed.size()-1).getColumn());
        last_button.setLetter(Game_button.buttons_pressed.get(buttons_pressed.size()-1).getLetter());
        last_button.setValue(Game_button.buttons_pressed.get(buttons_pressed.size()-1).getValue());*/
        
        //eukleidia apostash 1
        if(abs(newBoard.game_Buttons[staticI][staticJ].getRow()-last_button.getRow())<=1 && abs(newBoard.game_Buttons[staticI][staticJ].getColumn()-last_button.getColumn())<=1) {
            return true;
        }
        return false;
    }
    
    public void fileWork() {
        try {
            Scanner textFile = new Scanner(new File("javaDictionary.txt"));

            while (textFile.hasNext()) {
                dictionary.add(textFile.next().trim());
            }

            textFile.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}