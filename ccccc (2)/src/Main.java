
import javax.sound.midi.Soundbank;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Main {
	public static void main(String agrs[]) throws IOException{
		Scanner sc = new Scanner(System.in);
        int select;

		while (true) {
            System.out.println("---------------------------------------------");
            System.out.println("1 : 회원가입\n2 : 로그인");
            System.out.println("---------------------------------------------");
            select = sc.nextInt();

            if (select == 1) {
                MemberManageClient.main(null);
                break;
            } else if (select == 2) {

                break;
            } else
                System.out.println("잘못입력했습니다.");
        }

        String myId = getId();

        while(true) {
		    if(select == 1) {

                System.out.println("---------------------------------------------");
                System.out.println("설문지 작성을 시작하겠습니다. ");
                System.out.println("---------------------------------------------");
                QuestionnaireClient.main(myId);
                break;
            }
            else {
                System.out.println("---------------------------------------------");
                System.out.println("설문지를 다시 작성 하실려면 3번을 입력해주세요.");
                System.out.println("이상형을 찾으실거면 4번을 눌려주세요");
                System.out.println("---------------------------------------------");
                break;
            }
        }
        System.out.println("---------------------------------------------");
        System.out.println("이상형 찾기를 시작하겠습니다");
        System.out.println("---------------------------------------------");
		SearchClient.main(myId);

        System.out.println("채팅방에 참여 하시겠습니까? (0: 참여, 1: 종료)");
        select = sc.nextInt();
        if(select == 0) {
            System.out.println("---------------------------------------------");
            System.out.println("채팅방을 열겠습니다. ");
            System.out.println("---------------------------------------------");
            MultiChatClient.main(null);
        }
        else {
        }

    }


	static String getId() {
		try{
			BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\empti\\Desktop\\Member.txt"));
			String s;
			String id = null;
			String[] arr;
			while((s = reader.readLine()) != null) {
				arr = s.split(" ");
				id = arr[0];
			}
			return id;
		} catch(IOException e) {
			e.printStackTrace();
		}
		return null;
	}
}
