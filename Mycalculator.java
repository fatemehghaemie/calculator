
import java.awt.event.*;
import java.awt.*;
import java.lang.*;
import javax.swing.*;
class Mycalculator implements ActionListener {//https://www.youtube.com/watch?v=dfhmTyRTCSQ از ویدیو ی پیشنهاد شده در داک ماشین حساب استفاده کردم :)))
    JFrame frame = new JFrame("Calculator");;
    JTextField textfield;
    JButton[] numberButtons = new JButton[10];
    JButton[] functionButtons = new JButton[9];
    JPanel newpanel = new JPanel();
    JButton jam = new JButton("+");
    JButton tafrigh = new JButton("-");
    JButton zarb = new JButton("*");
    JButton taghsim = new JButton("/");
    JButton  decButton = new JButton(".");
    JButton mosavi = new JButton("=");
    JButton delete = new JButton("Delete");
    JButton CLR = new JButton("Clear");
    JButton negButton = new JButton("(-)");

    Font font = new Font("Comic Sans MS",Font.TRUETYPE_FONT,20);
    double number1 = 0,number2=0,natigheh =0;
    char character;
    Mycalculator(){
        frame = new JFrame("Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400,600);
        frame.setLayout(null);

        textfield = new JTextField();
        textfield.setBounds(50,25,300,50);
        textfield.setFont( font);
        textfield.setEditable(false);

        functionButtons[0] = tafrigh;
        functionButtons[1] = jam;
        functionButtons[2] =taghsim;
        functionButtons[3] = zarb;
        functionButtons[4] = decButton;
        functionButtons[5] = mosavi;
        functionButtons[6] =delete;
        functionButtons[7] =CLR;
        functionButtons[8] = negButton;
        for(int i =0; i <9;i++){
            functionButtons[i].addActionListener(this);
            functionButtons[i].setFont( font);
            functionButtons[i].setFocusable(false);
        }
        for(int i =0; i <10;i++){
            numberButtons[i] = new JButton(String.valueOf(i));
            numberButtons[i].addActionListener(this);
            numberButtons[i].setFont( font);
            numberButtons[i].setFocusable(false);
        }
        negButton.setBounds(50,440,110,60);
        delete.setBounds(160,440,110,60);
        CLR.setBounds(270,440,110,60);
        newpanel= new JPanel();
        newpanel.setLayout(new GridLayout(4,4,10,10));
        newpanel.setBounds(50,100,300,300);
        for (int t=0  ;t<=9 ;t++ ){
            newpanel.add(numberButtons[t]);
        }
        newpanel.add(tafrigh);
        newpanel.add(jam);
        newpanel.add(decButton);
        newpanel.add(zarb);
        newpanel.add(taghsim);
        newpanel.add(mosavi);

        frame.add(newpanel);
        frame.add(negButton);
        frame.add(delete);
        frame.add(CLR);
        frame.add(textfield);
        frame.setVisible(true);
    }
    public static void main(String[] args) {
        Mycalculator calc = new  Mycalculator() ;

    }
    @Override
    public void actionPerformed(ActionEvent e) {
        for(int j = 0;j<10;j++) {
            if (e.getSource() == numberButtons[j]) {
                textfield.setText(textfield.getText().concat(String.valueOf(j)));
            }
        }
        if(e.getSource() == decButton) {
            textfield.setText(textfield.getText().concat("."));
        }
        if(e.getSource() == zarb) {
            number1 = Double.parseDouble(textfield.getText());
            character = '*';
            textfield.setText("");
        }
        if(e.getSource() == tafrigh) {
            number1 = Double.parseDouble(textfield.getText());
            character = '-';
            textfield.setText("");
        }
        if(e.getSource() == jam) {
            number1 = Double.parseDouble(textfield.getText());
            character = '+';
            textfield.setText("");
        }
        if(e.getSource() == taghsim) {
            number1 = Double.parseDouble(textfield.getText());
            character = '/';
            textfield.setText("");
        }
        if(e.getSource() == mosavi) {
            number2 = Double.parseDouble(textfield.getText());
            switch (character) {
                case '-':
                    natigheh = number1 - number2;
                    break;
                case '+':
                    natigheh = number1 + number2;
                    break;
                case '*':
                    natigheh = number1 * number2;
                    break;
                case '/':
                    natigheh = number1 / number2;
                    break;
            }
            textfield.setText(String.valueOf(natigheh));
            number1 = natigheh;
        }
        if(e.getSource() == negButton) {
            Double temp = Double.parseDouble(textfield.getText());
            temp *=-1;
            textfield.setText(String.valueOf(temp));
        }
        if(e.getSource() == delete) {
            String string = textfield.getText();
            textfield.setText("");
            for(int m=0;m <string.length()-1;m++) {
                textfield.setText(textfield.getText()+string.charAt(m));
            }
        }
        if(e.getSource() == CLR) {
            textfield.setText("");
        }


    }

}

