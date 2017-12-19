
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.*;

public class QuestionnaireClient{

    public static void main(String memberId) throws IOException{

        Scanner sc = new Scanner(System.in);
        String[][] questionnaire = new String[7][22];
        int[] answer = new int[22];

        questionnaire[0][0] = ("당신의 성별은?");
        questionnaire[1][0] = ("1. 남자");
        questionnaire[2][0] = ("2. 여자");

        questionnaire[0][1] = ("당신의 나이는?");
        questionnaire[1][1] = ("1. 10대");
        questionnaire[2][1] = ("2. 20대");
        questionnaire[3][1] = ("3. 30대");
        questionnaire[4][1] = ("4. 40대");
        questionnaire[5][1] = ("5. 50대");

        questionnaire[0][2] = ("당신의 얼굴형은?");
        questionnaire[1][2] = ("1. 계란형");
        questionnaire[2][2] = ("2. 원형");
        questionnaire[3][2] = ("3. 각진형");
        questionnaire[4][2] = ("4. 볼살 많은형");
        questionnaire[5][2] = ("5. 긴형");

        questionnaire[0][3] = ("당신의 헤어성향은?");
        questionnaire[1][3] = ("1. 곱슬");
        questionnaire[2][3] = ("2. 반곱");
        questionnaire[3][3] = ("3. 생머리");

        questionnaire[0][4] = ("당신의 헤어스타일은?");
        questionnaire[1][4] = ("1. 일반적인 스포츠컷");
        questionnaire[2][4] = ("2. 다운펌");
        questionnaire[3][4] = ("3. 폼하드");
        questionnaire[4][4] = ("4. 투블럭");
        questionnaire[5][4] = ("5. 기타");

        questionnaire[0][5] = ("당신의 키는?");
        questionnaire[1][5] = ("1. 150 미만");
        questionnaire[2][5] = ("2. 150 ~ 159");
        questionnaire[3][5] = ("3. 160 ~ 169");
        questionnaire[4][5] = ("4. 170 ~ 179");
        questionnaire[5][5] = ("5. 180 ~ 189");
        questionnaire[6][5] = ("6. 190 이상");

        questionnaire[0][6] = ("당신의 피부색은?");
        questionnaire[1][6] = ("1. 하얀색");
        questionnaire[2][6] = ("2. 황색");
        questionnaire[3][6] = ("3. 구리빛");
        questionnaire[4][6] = ("4. 기타");

        questionnaire[0][7] = ("당신의 체형은?");
        questionnaire[1][7] = ("1. 마른");
        questionnaire[2][7] = ("2. 통통한");
        questionnaire[3][7] = ("3. 뚱뚱한");
        questionnaire[4][7] = ("4. 근육질");

        questionnaire[0][8] = ("당신의 안경 착용 유무?");
        questionnaire[1][8] = ("1. 착용");
        questionnaire[2][8] = ("2. 미착용");
        questionnaire[3][8] = ("3. 착용할 때 있고 미착용 할 때 있다.");

        questionnaire[0][9] = ("당신의 혈액형?");
        questionnaire[1][9] = ("1. A");
        questionnaire[2][9] = ("2. B");
        questionnaire[3][9] = ("3. AB");
        questionnaire[4][9] = ("4. O");

        questionnaire[0][10] = ("당신의 흡연 유무?");
        questionnaire[1][10] = ("1. 흡연");
        questionnaire[2][10] = ("2. 비흡연");

        questionnaire[0][11] = ("당신의 좋아하는 계절?");
        questionnaire[1][11] = ("1. 봄");
        questionnaire[2][11] = ("2. 여름");
        questionnaire[3][11] = ("3. 가을");
        questionnaire[4][11] = ("4. 겨울");

        questionnaire[0][12] = ("당신의 좋아하는 장소?");
        questionnaire[1][12] = ("1. 바다");
        questionnaire[2][12] = ("2. 산");
        questionnaire[3][12] = ("3. 도심지");
        questionnaire[4][12] = ("4. 시골");
        questionnaire[5][12] = ("5. 기타");

        questionnaire[0][13] = ("당신이 좋아하는  영화 장르");
        questionnaire[1][13] = ("1. 액션(SF)");
        questionnaire[2][13] = ("2. 공포, 스릴러");
        questionnaire[3][13] = ("3. 코미디");
        questionnaire[4][13] = ("4. 액션");
        questionnaire[5][13] = ("5. 기타");

        questionnaire[0][14] = ("당신이 좋아하는 음악 장르");
        questionnaire[1][14] = ("1. 발라드");
        questionnaire[2][14] = ("2. 댄스");
        questionnaire[3][14] = ("3. 힙합");
        questionnaire[4][14] = ("4. 기타");

        questionnaire[0][13] = ("이상형과 같이 하고 싶은 음식 성향?");
        questionnaire[1][13] = ("1. 한식");
        questionnaire[2][13] = ("2. 일식");
        questionnaire[3][13] = ("3. 중식");
        questionnaire[4][13] = ("4. 양식");
        questionnaire[5][13] = ("5. 기타");

        // 이상형
        questionnaire[0][14] = ("이상형과 같이 하고 싶은 엔터테인먼트?");
        questionnaire[1][14] = ("1. 영화");
        questionnaire[2][14] = ("2. 음악");
        questionnaire[3][14] = ("3. 게임");
        questionnaire[4][14] = ("4. 여행");

        questionnaire[0][15] = ("이성의 선호 나이는?");
        questionnaire[1][15] = ("1. 10대");
        questionnaire[2][15] = ("2. 20대");
        questionnaire[3][15] = ("3. 30대");
        questionnaire[4][15] = ("4. 40대");
        questionnaire[5][15] = ("5. 50대");

        questionnaire[0][16] = ("이성의 선호 얼굴형은?");
        questionnaire[1][16] = ("1. 계란형");
        questionnaire[2][16] = ("2. 원형");
        questionnaire[3][16] = ("3. 긴 형");
        questionnaire[4][16] = ("4. 각진 형");
        questionnaire[5][16] = ("5. 볼살 많은 형");

        questionnaire[0][17] = ("이성의 선호 헤어성향은?");
        questionnaire[1][17] = ("1. 곱슬");
        questionnaire[2][17] = ("2. 반곱슬");
        questionnaire[3][17] = ("3. 생머리");

        questionnaire[0][18] = ("이성의 선호 헤어스타일은?");
        questionnaire[1][18] = ("1. 일반적인 단발");
        questionnaire[2][18] = ("2. 일반적인 긴생머리");
        questionnaire[3][18] = ("3. 파마된 머리");
        questionnaire[4][18] = ("4. 긴머리에 웨이브가 들어간 스타일");
        questionnaire[5][18] = ("5. 기타");

        questionnaire[0][19] = ("이성의 선호 키는?");
        questionnaire[1][19] = ("1. 150 미만");
        questionnaire[2][19] = ("2. 150 ~ 159");
        questionnaire[3][19] = ("3. 160 ~ 169");
        questionnaire[4][19] = ("4. 170 ~ 179");
        questionnaire[5][19] = ("5. 180 ~ 189");
        questionnaire[6][19] = ("6. 190 이상");

        questionnaire[0][20] = ("이성의 선호 피부색은?");
        questionnaire[1][20] = ("1. 하얀색");
        questionnaire[2][20] = ("2. 황색");
        questionnaire[3][20] = ("3. 구리빛");
        questionnaire[4][20] = ("4. 기타");

        questionnaire[0][21] = "이상형의 체형은?";
        questionnaire[1][21] = "1. 마른";
        questionnaire[2][21] = "2. 통통한";
        questionnaire[3][21] = "3. 뚱뚱한";
        questionnaire[4][21] = "4. 글래머한";

        for (int j = 0; j < 22; j++) {
            for (int i = 0; i < 7; i++) {
                if (questionnaire[i][j] != null)
                    System.out.println(questionnaire[i][j]);
            }
            while (true) {
                answer[j] = sc.nextInt();
                if (questionnaire[answer[j]][j] == null) {
                    System.out.println("잘못 입력하셨습니다.");
                } else
                    break;
            }
        }
        String s = "";
        for(int i=0; i<22; i++) {
            s = s + answer[i] + " ";
        }
        s += memberId;
        System.out.println("설문조사가 완료되었습니다.");

        QuestionnaireClient qc = new QuestionnaireClient();
        qc.ClientQuestionnarie(s);
    }

    public void ClientQuestionnarie(String data){

        Socket socket = null;
        OutputStream os = null;
        OutputStreamWriter osw =null;
        BufferedWriter bw = null;

        InputStream is =null;
        InputStreamReader isr = null;
        BufferedReader br = null;

        try{
            socket = new Socket("localhost", 6200);
            os = socket.getOutputStream();
            osw = new OutputStreamWriter(os);
            bw = new BufferedWriter(osw);            //서버로 전송을 위한 OutputStream

            is = socket.getInputStream();
            isr = new InputStreamReader(is);
            br = new BufferedReader(isr);        // 서버로부터 Data를 받음

            bw.write(data);
            bw.newLine();
            bw.flush();

            //String receiveData = "";
            //receiveData = br.readLine();        // 서버로부터 데이터 한줄 읽음
            //System.out.println("서버로부터 받은 데이터 : " + receiveData);
        }catch(Exception e){
            e.printStackTrace();
        }finally {
            try{
                osw.close();
                os.close();
                br.close();
                isr.close();
                is.close();
                bw.close();
            }catch(Exception e){
                e.printStackTrace();
            }
        }

    }

}
