
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.*;

public class MemberManageClient{

    public static void main(String[] args) throws IOException{
        Scanner input = new Scanner(System.in);
        String id, pw, name;
        int sex;
        MemberManageClient cm = new MemberManageClient();
        System.out.println("Id 입력하세요: ");
        id = input.next();
        System.out.println("pw 입력하세요: ");
        pw = input.next();
        System.out.println("name 입력하세요: ");
        name = input.next();
        System.out.println("성별 입력하세요 (0: 남자, 1: 여자) : ");
        sex = input.nextInt();
        cm.ClientRegister(id + " " + pw + " " + name + " " + sex);

    }

    public void ClientRegister(String data){

        Socket socket = null;
        OutputStream os = null;
        OutputStreamWriter osw =null;
        BufferedWriter bw = null;

        InputStream is =null;
        InputStreamReader isr = null;
        BufferedReader br = null;

        try{
            socket = new Socket("localhost", 4200);
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
                bw.close();
                osw.close();
                os.close();
                br.close();
                isr.close();
                is.close();
            }catch(Exception e){
                e.printStackTrace();
            }
        }

    }

}
