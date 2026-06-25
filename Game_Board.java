//icsd18250
//icsd14149



import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class Game_Board {
    public Game_button[][] game_Buttons;
    public HashMap<String,Integer> all_the_letters;
    public ArrayList<String> keys = new ArrayList<>();

    public Game_Board(){
  
        all_the_letters = new HashMap<>();
        fill_letters();//gemisma ths listas kai tou hashmap
        game_Buttons = new Game_button[8][8];
        Random rand = new Random();
        int a;
        String s;
        for (int i=0;i<8;i++){
            
            for (int j=0;j<8;j++){//gemisma pinaka buttons
                a = rand.nextInt(26);
                s = keys.get(a);//me tuxaia grammata
                
                game_Buttons[i][j] = new Game_button();//kai arxikopoihsh
                game_Buttons[i][j].setText(s);
                game_Buttons[i][j].setRow(i);
                game_Buttons[i][j].setColumn(j);
                game_Buttons[i][j].setLetter(s);
                game_Buttons[i][j].setValue(all_the_letters.get(s));                       
            }
        }
    }
    public final void fill_letters() {
        
        all_the_letters.put("A", 1);
        all_the_letters.put("B", 8);
        all_the_letters.put("C", 4);
        all_the_letters.put("D", 4);
        all_the_letters.put("E", 1);
        all_the_letters.put("F", 8);
        all_the_letters.put("G", 1);
        all_the_letters.put("H", 8);
        all_the_letters.put("I", 1);
        all_the_letters.put("J", 2);
        all_the_letters.put("K", 3);
        all_the_letters.put("L", 3);
        all_the_letters.put("M", 1);
        all_the_letters.put("N", 10);
        all_the_letters.put("O", 1);
        all_the_letters.put("P", 2);
        all_the_letters.put("Q", 2);
        all_the_letters.put("R", 1);
        all_the_letters.put("S", 1);
        all_the_letters.put("T", 2);
        all_the_letters.put("U", 8);
        all_the_letters.put("V", 10);
        all_the_letters.put("W", 10);
        all_the_letters.put("X", 3);
        all_the_letters.put("Y", 3);
        all_the_letters.put("Z", 3);
        
        keys.add("A");
        keys.add("B");
        keys.add("C");
        keys.add("D");
        keys.add("E");
        keys.add("F");
        keys.add("G");
        keys.add("H");
        keys.add("I");
        keys.add("J");
        keys.add("K");
        keys.add("L");
        keys.add("M");
        keys.add("N");
        keys.add("O");
        keys.add("P");
        keys.add("Q");
        keys.add("R");
        keys.add("S");
        keys.add("T");
        keys.add("U");
        keys.add("V");
        keys.add("W");
        keys.add("X");
        keys.add("Y");
        keys.add("Z");
    }

}
