package Applet;

import java.awt.*;
import java.util.*;
import java.awt.event.*;
import java.net.URL;
import java.applet.*;

// �⺻���� ��Ű���� appletǥ�� ��Ű�� �׸��� URL�� ���õ� ��Ű���� Import�Ѵ�.


//6-2. 2���� ���(�ѱ�, ����)�� ��ȯ�� ���� ���ڿ��� ������ �Է½�Ų��.


public class NewHtt extends java.applet.Applet
{
   String [] sWords2 = 
   {
      "We wish you a merry Christmas.",
   "And a happy New Year.",
      "We want some figgy pudding.",
   "And a cup of good cheer.",
   "We won't go until we get some.",
   "So bring it out here!",
   "We wish you a Merry Christmas.",
      "And a happy New Year."
   };
   

    String [] sWords = 
   {
      "������ �� ������ ����� ������ �ľ ��ȸ�Ѵ�.",
      "������ �ϴ� �л��� �β������ؼ��� �� �ȴ�.",
      "��ġ�� ������ ��ġ�� �ʴ´�.",
      "���� ���� ������� ��ȸ���� �����ϴ� ���� �ƴϴ�."
   };

// �⺻ ���ڿ� sWords���� �ѱ�, sWords2���� ��� �Է��Ѵ�.
// ������ changeWord()���� words���ڿ��� ���� �����ư��� �Էµȴ�.


//6-3. Ÿ�ڽð���꿡 ���� ������, ������ ��Ʈ, �󺧵��, ��ü �ؽ�Ʈ�ʵ� �׸��� �̹����� �� ȭ�鱸�� �г� ���� �����Ѵ�.

    String cUp;
    String cCenter;
    String cDown;

// Color()�Լ����� �� �г��� ��׶����� �� ������ ���� ���ڿ��̴�.
    String [] words = sWords;

// �ռ� �Է��Ͽ��� sWord�� sWord2�� ���ڿ��� �־ ������� ���ڿ��̴�.

// ��Ʈ ���� : ���߿� �ҷ��� ���� ���Ͽ� �� ������ ������ ���´�.

    Font f = new Font("����", Font.BOLD, 18);
    Font f2 = new Font("���", Font.BOLD,14);
    Font f3 = new Font("���", Font.PLAIN,14);
    Font f4 = new Font("���", Font.PLAIN, 12);

// �� ���� : ȭ�� ���� �� ��������� �� �͵��� �̸� ������ ���� ����Ѵ�.
    Label lb0 = new Label("�ڹٷ� ���� Ÿ�� ���α׷�");
    Label lb1 = new Label("����");
    Label lb2 = new Label("�ְ�");
    Label lb3 = new Label("���");
    Label lb4 = new Label("�ӵ� (Ÿ/��)");

// �� ��ư�� ShowLink()�� �̿��Ͽ� mailto�� ���Ͽ� ���δ�.

    Button lb5 = new Button("����");

// �ؽ�Ʈ�ʵ带 4���� ������ ���߿� �ؽ�Ʈ�� ��ġ������ �����ϰ� ���ش�.

    TextField t1 = new TextField(4);
    TextField t2 = new TextField(4);
    TextField t3 = new TextField(4);

// ȭ�鱸���� ���� �г�

    Panel pTop = new Panel();
    Panel pUp = new Panel();
    Panel pDown1 = new Panel();
    Panel pDown2 = new Panel();
    Panel pDownAll = new Panel();

// �ܹ� ����� ���� �ؽ�Ʈ �ʵ带 �����. �ռ� 4���� ������� ���� �ٸ��� 60���� ������.

    TextField textShort1 = new TextField(60);
    TextField textShort2 = new TextField(60);

// ����, ��� �ٲٱ� ��ư�� ó������ ��ư
    
    Button bWord = new Button("����� �ٲٱ�");
    Button bEnd = new Button("ó������");

// ���Ÿ���� ���� ��������

    int number = 0;
    int count = 0;
    double stime = 0;
    int ctt = 0;
    int mtt = 0;
    int ett = 0;
    int ttt = 0;
    int total = 0;
    boolean sFlag = false;
    
//6-4. �ռ� �����Ͽ��� �� ���� ���� ȭ��� �Ѹ���.

    public void init()
    {
        cUp = getParameter("upcolor");
        cCenter = getParameter("centercolor");
        cDown = getParameter("downcolor");

// ȭ�� ��׶��� ���� ����

// ��Ʈ ���� : �ռ� �����ߴ� �͵��� ������ ����.

        textShort1.setFont(f);
        textShort1.setEditable(false);
        textShort2.setFont(f);
        lb1.setFont(f2);
        lb2.setFont(f2);
        lb3.setFont(f2);
        lb4.setFont(f2);
        lb5.setFont(f4);
        lb0.setFont(f2);
        t1.setFont(f3);
        t2.setFont(f3);
        t3.setFont(f3);
        t1.setEnabled(false);
        t2.setEnabled(false);
        t3.setEnabled(false);

// ȭ�� ���� : ��� �̹����� �� �⺻ ���̾ƿ� ����

        setLayout(new BorderLayout());

// ȭ�� ���� : ȭ�鿡 ������ �������� �ٿ� �ϼ��Ѵ�.

        
        pTop.add(lb0); // �ܹ�����
        pTop.add(bWord); // ����� �ѱ۷� �ٲٱ� ��ư
        pTop.setBackground(Color.white);  // �� �� �г� ����
        pUp.add(textShort1, BorderLayout.NORTH); // �ؽ�Ʈ ���� ���κ�
        pUp.add(textShort2, BorderLayout.SOUTH); // �ؽ�Ʈ ���� �Ʒ��κ�
        pUp.setBackground(Color.white); // ��� ��� ����
        pDown1.add(lb4); // �ӵ�(Ÿ/��)
        pDown1.add(lb1); // ����
        pDown1.add(t1);  // text field 4
        pDown1.add(lb2); // �ְ� 
        pDown1.add(t2);  // text field 4
        pDown1.add(lb3); // ���
        pDown1.add(t3);  // text field 4
        pDown1.add(bEnd); // ��ư : ó������
        pDown2.add(lb5); // ��ư : ������ (���Ϻ�����)
        pDownAll.setLayout(new BorderLayout()); // �ռ� ���س��� �͵��� �гη�
        pDownAll.add(pDown1, BorderLayout.NORTH); 
        pDownAll.add(pDown2, BorderLayout.SOUTH);
        pDownAll.setBackground(Color.white);
        add(pTop, BorderLayout.NORTH); // ���̾ƿ��� 3���� �г��� �־��ش�.
        add(pUp, BorderLayout.CENTER);
        add(pDownAll, BorderLayout.SOUTH);

// nextWord()�Լ��� �̿��Ͽ� �⺻������ ó�� ȭ�鿡 ��µ� ������ ����Ѵ�.


        nextWord();

// ���� �ð��� �޾� �����Ѵ�.
        stime = new Date().getTime();

//6-5. ������ �����ʸ� �����Ѵ�.

//  ������ ���

// ����� �ٲٱ�, �ѱ۷� �ٲٱ� ȣ�� : ChangeWord()

        bWord.addActionListener(new ChangeWord());

// Ÿ�� �Է� �� ��Ÿ�߻�Ȯ�ΰ� ȭ����ȯ ȣ�� : KeyHandler()

        textShort2.addKeyListener(new KeyHandler());

// ó������ �ٽ� ��ư ȣ�� :  ActionHandler()

        bEnd.addActionListener(new ActionHandler());

// ���� ������ ȣ�� : ShowLink()

        lb5.addActionListener(new ShowLink());
    }


//6-6. ��׶��Ʈ Į�� �Լ�, nextWord()�Լ�, callScore()�Լ�
        
    public Color color(String str)
    {
        return new Color(Integer.parseInt(str,16));
    }

// �ռ� �����Ͽ��� cUp,cCenter,cDown�� Į�� �޾� �´�.

// ������ �� ������� �ѷ��ش�. �� ȭ���� ���ŵ� �� �ӵ��� �Բ� ����Ѵ�.

    public void nextWord()
    {
        callScore();

// ���ھ� �Լ��� �����Ѵ�. ù ȭ���� ��쿡�� 0���� ��� ���ŵȴ�.

        count = 0;
        total++;
        sFlag = false;
        number = Math.abs(new Random().nextInt()%words.length);

// �־��� ���� ���ڿ� �߿��� Random�ϰ� ������� �̾Ƴ���.

        textShort1.setText(words[number]);
        textShort2.setText("");
        textShort2.requestFocus();
    }

// Ÿ�ڼӵ��� ����ϴ� �Լ��̴�.

    public void callScore()
    {
        if (total!=0) // ù ������ ��쿡�� 0�̹Ƿ� ������� �ʴ´�.
    
// total�� ��� ������ ��ȭ�� ���� ���ŵǹǷ� �����ȴ�.


    {
            double tTime = (new Date().getTime() - stime)/1000/60;
            ctt = (int)(count/tTime);


// �޾ƿ� �ð����� ������ �ð�(stime)�� �� �� �д� �ð��� �ӵ��� ����Ѵ�.
// �ð��� �ӵ����� ���ڼ�(count)�� �������ָ� �д� Ÿ�ڼ��� ������ �ȴ�.

            if (ctt>mtt)
            {
                mtt = ctt;
            }

// ������ ���� �ӵ��� ���Ͽ� �ְ�ӵ��� �������ش�.

            ttt = ttt + ctt;

// ������ �ӵ��� �����Ѵ�.

            ett = (int)ttt/total;
        }

// �ӵ��� ������ ȭ�� ������ �� (total)�� ������ ��� Ÿ���� ���´�.

        t1.setText(""+ctt);
        t2.setText(""+mtt);
        t3.setText(""+ett);
    }

// ������ �ӵ��� ȭ�鿡 �������ش�.

//6-7. reset()�Լ�, changWord()�Լ�, ChangWord()Ŭ����

// ��� �͵��� �ʱ���·� �������ִ� �Լ��� ���Ѵ�.

    public void reset()
    {
        ctt = 0;
        mtt = 0;
        ett = 0;
        ttt = 0;
        total = 0;
    }

// ������ ��ռӵ��� ��� �������ش�.

// �� ���� ��� ����� ���(�ѱ�)�� ��ȯ�� ����Ѵ�.

    public void changeWord()
    {
        if (bWord.getLabel().equals("����� �ٲٱ�"))
        {
            words = sWords2;
            bWord.setLabel("������� �ٲٱ�");
        }

// �⺻�����δ� ������� �Ǿ������� ��ư�� ������ ��쿡 ȭ���� text�� ������ �ٲ��.

        else 
        {
            words = sWords;
            bWord.setLabel("����� �ٲٱ�");
        }
    }

    public class ChangeWord implements ActionListener
    {
        public void actionPerformed(ActionEvent ae)
        {
            reset();
            changeWord();
            nextWord();
        }
    }

// �ռ� �������� ChangeWord()�� �����Ű�� reset()�� �ٷ� ���� changeWord()��
// nextWord()�� �����Ų��.
  
//6-8. ShowLink()�� mailto�� �����Ѵ�.
      
    public class ShowLink implements ActionListener
    {
        public void actionPerformed(ActionEvent ae)
        {
            try
            {
                URL u = new URL("");
                AppletContext text = getAppletContext(); 
                text.showDocument(u);
            }catch(Exception e) 
            { 
                showStatus("Error : " + e); 
            }

        }
    }

// action �̺�Ʈ�� ���Ͽ� kimwindow1@hotmail.com�� mailto�� �����Ѵ�.

//6-9. Ÿ�� �Է� �� ��Ÿ����� Ÿ�� �� �׸��� �ܹ���ȯ�� �þ��ϴ� �κ��̴�.

    private class KeyHandler implements KeyListener
    {
                
        public void keyPressed(KeyEvent ke)
        {
                        
            if (sFlag==false) // ù �Է������� �Ǻ��Ѵ�.
            {
                stime = new Date().getTime(); // Ÿ�� ����� ���� �ʱ� �ð��Է�
                sFlag = true; // ù �Է��� �ƴ϶�� ǥ�ø� ���ش�.
            }
            if ((ke.getKeyCode()
            		==ke.VK_ENTER)&&(textShort1.getText().equals(textShort2.getText().trim()))) 

// ������ �ؽ�Ʈ�� �Է� �ؽ�Ʈ�� �񱳸� �Ѵ�.

            {
                nextWord(); // �Է��� ���� �� ���� �������� ��ȯ
            }
                        
            if (ke.getKeyCode()==ke.VK_BACK_SPACE)
            {
                count--; // �� �����̽��� ���� �� Ÿ�� ���� ���ҽ����ش�.
            }
        }

        public void keyReleased(KeyEvent ke)
        {
            if ((ke.getKeyCode()==
            		ke.VK_SPACE)&&(textShort1.getText().equals(textShort2.getText().trim())))


// ������ �ؽ�Ʈ�� �Է� �ؽ�Ʈ�� �񱳸� �Ѵ�. ���ʹ�� �����̽��� ��뵵 �㰡�Ѵ�.

            {
                nextWord(); // �Է��� ���� �� ���� �������� ��ȯ
            }
            
            count++;

// ���ڰ� �ԷµǸ� ������ �Ǿ� Ÿ�ڼ��� ��� �������� �ش�.


            if ( textShort2.getText().substring(0, textShort2.getText().length()-1)
               .equals(textShort1.getText().substring
            		   (0, textShort2.getText().length()-1) )) {

                textShort1.setForeground(Color.black);
            }else {
                textShort1.setForeground(Color.red);}
        }

// ���ڰ� �Է� �� ���� Ʋ�� ��쿡�� �������� �Է��� �ش�.
// ��Ȯ�� ��쿡�� �������� �Է��� �ش�.

        public void keyTyped(KeyEvent ke)
        {
            
        }
    }

// �⺻������ 2���� �������� �����Ǿ� �ֱ� ������ �⺻������ �ȴ�.

//6-10. ó������ ���ư��� reset()�� ���� �κ��̴�.

    private class ActionHandler implements ActionListener
    {
        public void actionPerformed(ActionEvent ae)
        {
            reset();

// �ռ� �ٷ���� Ÿ�� �ӵ��� ���� �������� �ʱ�ȭ ���ش�.

            nextWord();

// ���� �����ϱ� ���Ͽ� �ٸ� ������ ������ش�.
        }
    }  
}

