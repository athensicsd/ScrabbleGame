//icsd18250
//icsd14149


import java.util.LinkedList;
import java.util.List;
import javax.swing.JButton;


public class Game_button extends JButton{
    public static List<Game_button> buttons_pressed = new LinkedList<>();//krataei ta buttons pou 9a dhmiourghsoun thn leksh
    private int row;
    private int column;
    private String letter;
    private int value;
    

    public Game_button(){
        super();
     
    }
    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getColumn() {
        return column;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    public String getLetter() {
        return letter;
    }

    public void setLetter(String letter) {
        this.letter = letter;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
    
    public static int buttonHash(Game_button a) {//dhmiourgia hash kwdikou
       int x= a.getColumn() + a.getRow() + a.getValue();
       return x;
    }
    
    


}

