
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.*;

public class SearchClient{

    public static void main(String memberId) throws IOException{

        SearchClient sc = new SearchClient();
        sc.ClientSearch(memberId);
    }

    public void ClientSearch(String memId){

        Socket socket = null;
        OutputStream os = null;
        OutputStreamWriter osw =null;
        BufferedWriter bw = null;

        InputStream is =null;
        InputStreamReader isr = null;
        BufferedReader br = null;

        try{
            socket = new Socket("localhost", 8200);
            os = socket.getOutputStream();
            osw = new OutputStreamWriter(os);
            bw = new BufferedWriter(osw);            //서버로 전송을 위한 OutputStream

            is = socket.getInputStream();
            isr = new InputStreamReader(is);
            br = new BufferedReader(isr);        // 서버로부터 Data를 받음

            bw.write(memId);
            bw.newLine();
            bw.flush();

            String receiveData = "";
            receiveData = br.readLine();        // 서버로부터 데이터 한줄 읽음
            System.out.println("당신에게 맞는 이상형은 " + receiveData + " 입니다");

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
