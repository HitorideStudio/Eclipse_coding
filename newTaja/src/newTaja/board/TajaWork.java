package newTaja.board;

import java.awt.*;
import java.util.*;
import java.awt.event.*;
import java.net.URL;
import java.applet.*;

// 기본적인 패키지와 applet표현 패키지 그리고 URL에 관련된 패키지를 Import한다.


//6-2. 2가지 언어(한글, 영어)의 교환을 위한 문자열에 문장을 입력시킨다.


public class TajaWork extends java.applet.Applet
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
      "젊었을 때 열심히 배우지 않으면 늙어서 후회한다.",
      "배우려고 하는 학생은 부끄러워해서는 안 된다.",
      "미치지 않으면 미치지 않는다.",
      "공부 잘한 사람만이 사회에서 성공하는 것은 아니다."
   };

// 기본 문자열 sWords에는 한글, sWords2에는 영어를 입력한다.
// 나중의 changeWord()에서 words문자열에 각각 번갈아가며 입력된다.


//6-3. 타자시간계산에 쓰일 변수와, 각각의 폰트, 라벨들과, 전체 텍스트필드 그리고 이미지가 들어갈 화면구성 패널 등을 선언한다.

    String cUp;
    String cCenter;
    String cDown;

// Color()함수에서 각 패널의 백그라운드의 색 지정에 쓰일 문자열이다.
    String [] words = sWords;

// 앞서 입력하였던 sWord와 sWord2의 문자열을 넣어서 출력해줄 문자열이다.

// 폰트 설정 : 나중에 불러다 쓰기 위하여 몇 가지를 지정해 놓는다.

    Font f = new Font("굴림", Font.BOLD, 18);
    Font f2 = new Font("고딕", Font.BOLD,14);
    Font f3 = new Font("고딕", Font.PLAIN,14);
    Font f4 = new Font("고딕", Font.PLAIN, 12);

// 라벨 설정 : 화면 구성 중 문자출력을 할 것들을 미리 저장해 놓고 사용한다.
    Label lb0 = new Label("자바로 만든 타자 프로그램");
    Label lb1 = new Label("현재");
    Label lb2 = new Label("최고");
    Label lb3 = new Label("평균");
    Label lb4 = new Label("속도 (타/분)");

// 이 버튼은 ShowLink()를 이용하여 mailto를 위하여 쓰인다.

    Button lb5 = new Button("제작");

// 텍스트필드를 4개로 나누어 나중에 텍스트의 위치설정을 용이하게 해준다.

    TextField t1 = new TextField(4);
    TextField t2 = new TextField(4);
    TextField t3 = new TextField(4);

// 화면구성을 위한 패널

    Panel pTop = new Panel();
    Panel pUp = new Panel();
    Panel pDown1 = new Panel();
    Panel pDown2 = new Panel();
    Panel pDownAll = new Panel();

// 단문 출력을 위한 텍스트 필드를 만든다. 앞서 4개로 만들었을 때와 다르게 60개로 나누다.

    TextField textShort1 = new TextField(60);
    TextField textShort2 = new TextField(60);

// 영어, 명언 바꾸기 버튼과 처음부터 버튼
    
    Button bWord = new Button("영어로 바꾸기");
    Button bEnd = new Button("처음부터");

// 평균타율을 위한 변수선언

    int number = 0;
    int count = 0;
    double stime = 0;
    int ctt = 0;
    int mtt = 0;
    int ett = 0;
    int ttt = 0;
    int total = 0;
    boolean sFlag = false;
    
//6-4. 앞서 선언하였던 것 들을 실제 화면상에 뿌린다.

    public void init()
    {
        cUp = getParameter("upcolor");
        cCenter = getParameter("centercolor");
        cDown = getParameter("downcolor");

// 화면 백그라운드 색깔 설정

// 폰트 설정 : 앞서 선언했던 것들을 가져다 쓴다.

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

// 화면 구성 : 모든 이미지가 들어갈 기본 레이아웃 구성

        setLayout(new BorderLayout());

// 화면 구성 : 화면에 각각의 구성들을 붙여 완성한다.

        
        pTop.add(lb0); // 단문연습
        pTop.add(bWord); // 영어와 한글로 바꾸기 버튼
        pTop.setBackground(Color.white);  // 젤 윗 패널 색상
        pUp.add(textShort1, BorderLayout.NORTH); // 텍스트 영역 윗부분
        pUp.add(textShort2, BorderLayout.SOUTH); // 텍스트 영역 아랫부분
        pUp.setBackground(Color.white); // 가운데 펴널 색상
        pDown1.add(lb4); // 속도(타/분)
        pDown1.add(lb1); // 현재
        pDown1.add(t1);  // text field 4
        pDown1.add(lb2); // 최고 
        pDown1.add(t2);  // text field 4
        pDown1.add(lb3); // 평균
        pDown1.add(t3);  // text field 4
        pDown1.add(bEnd); // 버튼 : 처음부터
        pDown2.add(lb5); // 버튼 : 제작자 (메일보내기)
        pDownAll.setLayout(new BorderLayout()); // 앞서 정해놓은 것들을 패널로
        pDownAll.add(pDown1, BorderLayout.NORTH); 
        pDownAll.add(pDown2, BorderLayout.SOUTH);
        pDownAll.setBackground(Color.white);
        add(pTop, BorderLayout.NORTH); // 레이아웃에 3개의 패널을 넣어준다.
        add(pUp, BorderLayout.CENTER);
        add(pDownAll, BorderLayout.SOUTH);

// nextWord()함수를 이용하여 기본적으로 처음 화면에 출력될 문장을 출력한다.


        nextWord();

// 시작 시간을 받아 저장한다.
        stime = new Date().getTime();

//6-5. 각각의 리스너를 실행한다.

//  리스너 등록

// 영어로 바꾸기, 한글로 바꾸기 호출 : ChangeWord()

        bWord.addActionListener(new ChangeWord());

// 타자 입력 시 오타발생확인과 화면전환 호출 : KeyHandler()

        textShort2.addKeyListener(new KeyHandler());

// 처음부터 다시 버튼 호출 :  ActionHandler()

        bEnd.addActionListener(new ActionHandler());

// 메일 보내기 호출 : ShowLink()

        lb5.addActionListener(new ShowLink());
    }


//6-6. 백그라운트 칼라 함수, nextWord()함수, callScore()함수
        
    public Color color(String str)
    {
        return new Color(Integer.parseInt(str,16));
    }

// 앞서 선언하였던 cUp,cCenter,cDown의 칼라를 받아 온다.

// 다음에 올 문장들을 뿌려준다. 각 화면이 갱신될 때 속도를 함께 계산한다.

    public void nextWord()
    {
        callScore();

// 스코어 함수를 실행한다. 첫 화면일 경우에는 0으로 모두 갱신된다.

        count = 0;
        total++;
        sFlag = false;
        number = Math.abs(new Random().nextInt()%words.length);

// 주어진 문장 문자열 중에서 Random하게 문장들을 뽑아낸다.

        textShort1.setText(words[number]);
        textShort2.setText("");
        textShort2.requestFocus();
    }

// 타자속도를 계산하는 함수이다.

    public void callScore()
    {
        if (total!=0) // 첫 실행일 경우에는 0이므로 실행되지 않는다.
    
// total이 계속 문장의 변화에 따라 갱신되므로 누적된다.


    {
            double tTime = (new Date().getTime() - stime)/1000/60;
            ctt = (int)(count/tTime);


// 받아온 시간에서 시작한 시간(stime)을 뺀 후 분당 시간의 속도를 계산한다.
// 시간의 속도에서 글자수(count)를 나누어주면 분당 타자수가 나오게 된다.

            if (ctt>mtt)
            {
                mtt = ctt;
            }

// 각각의 나온 속도를 비교하여 최고속도를 지정해준다.

            ttt = ttt + ctt;

// 각각의 속도를 누적한다.

            ett = (int)ttt/total;
        }

// 속도의 누적을 화면 갱신의 수 (total)로 나누면 평균 타율이 나온다.

        t1.setText(""+ctt);
        t2.setText(""+mtt);
        t3.setText(""+ett);
    }

// 각각의 속도를 화면에 갱신해준다.

//6-7. reset()함수, changWord()함수, ChangWord()클래스

// 모든 것들을 초기상태로 리셋해주는 함수를 말한다.

    public void reset()
    {
        ctt = 0;
        mtt = 0;
        ett = 0;
        ttt = 0;
        total = 0;
    }

// 각각의 평균속도를 모두 리셋해준다.

// 두 가지 언어 영어와 명언(한글)의 전환을 담당한다.

    public void changeWord()
    {
        if (bWord.getLabel().equals("영어로 바꾸기"))
        {
            words = sWords2;
            bWord.setLabel("명언으로 바꾸기");
        }

// 기본적으로는 명언으로 되어있으며 버튼이 눌려질 경우에 화면의 text와 문장이 바뀐다.

        else 
        {
            words = sWords;
            bWord.setLabel("영어로 바꾸기");
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

// 앞서 리스너의 ChangeWord()를 실행시키면 reset()과 바로 위의 changeWord()와
// nextWord()를 실행시킨다.
  
//6-8. ShowLink()로 mailto를 실행한다.
      
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

// action 이벤트를 통하여 kimwindow1@hotmail.com로 mailto를 실행한다.

//6-9. 타자 입력 시 오타검출과 타자 수 그리고 단문전환을 맡아하는 부분이다.

    private class KeyHandler implements KeyListener
    {
                
        public void keyPressed(KeyEvent ke)
        {
                        
            if (sFlag==false) // 첫 입력인지를 판별한다.
            {
                stime = new Date().getTime(); // 타율 계산을 위한 초기 시간입력
                sFlag = true; // 첫 입력이 아니라고 표시를 해준다.
            }
            if ((ke.getKeyCode()
            		==ke.VK_ENTER)&&(textShort1.getText().equals(textShort2.getText().trim()))) 

// 보기의 텍스트와 입력 텍스트의 비교를 한다.

            {
                nextWord(); // 입력이 맞을 시 다음 문장으로 전환
            }
                        
            if (ke.getKeyCode()==ke.VK_BACK_SPACE)
            {
                count--; // 백 스페이스로 지울 시 타자 수를 감소시켜준다.
            }
        }

        public void keyReleased(KeyEvent ke)
        {
            if ((ke.getKeyCode()==
            		ke.VK_SPACE)&&(textShort1.getText().equals(textShort2.getText().trim())))


// 보기의 텍스트와 입력 텍스트의 비교를 한다. 엔터대신 스페이스의 사용도 허가한다.

            {
                nextWord(); // 입력이 맞을 시 다음 문장으로 전환
            }
            
            count++;

// 글자가 입력되면 실행이 되어 타자수를 계속 증가시켜 준다.


            if ( textShort2.getText().substring(0, textShort2.getText().length()-1)
               .equals(textShort1.getText().substring
            		   (0, textShort2.getText().length()-1) )) {

                textShort1.setForeground(Color.black);
            }else {
                textShort1.setForeground(Color.red);}
        }

// 글자가 입력 된 것이 틀릴 경우에는 빨간색을 입력해 준다.
// 정확할 경우에는 검은색을 입력해 준다.

        public void keyTyped(KeyEvent ke)
        {
            
        }
    }

// 기본적으로 2벌식 자판으로 설정되어 있기 때문에 기본세팅이 된다.

//6-10. 처음으로 돌아가는 reset()의 실행 부분이다.

    private class ActionHandler implements ActionListener
    {
        public void actionPerformed(ActionEvent ae)
        {
            reset();

// 앞서 다루었던 타자 속도에 쓰인 변수들을 초기화 해준다.

            nextWord();

// 새로 시작하기 위하여 다른 문장을 출력해준다.
        }
    }  
}