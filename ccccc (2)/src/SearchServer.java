/**
 * Created by empti on 2017-12-11.
 */

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class SearchServer {

    public static void main(String[] args) throws IOException{

        SearchServer ss = new SearchServer();
        ss.ServerRun();
    }

    public void ServerRun() throws IOException{

        ServerSocket server = null;
        int port = 8200;
        Socket socket = null;

        InputStream is = null;
        InputStreamReader isr = null;
        BufferedReader br = null;

        try{
            server = new ServerSocket(port);
            while(true){
                System.out.println("-------접속 대기중------");
                socket = server.accept();         // 클라이언트가 접속하면 통신할 수 있는 소켓 반환
                System.out.println(socket.getInetAddress() + "로 부터 연결요청이 들어옴");

                is = socket.getInputStream();
                isr = new InputStreamReader(is);
                br = new BufferedReader(isr);
                // 클라이언트로부터 데이터를 받기 위한 InputStream 선언

                String data=null;
                data=br.readLine();     // data : member의 id
                BufferedReader bufReader1 = new BufferedReader(new FileReader("C:\\Users\\empti\\Desktop\\Questionnaire.txt"));
                BufferedReader bufReader2 = new BufferedReader(new FileReader("C:\\Users\\empti\\Desktop\\Questionnaire.txt"));
                String temp;
                String[] userAnswers = new String[23];
                String[] otherAnswers = new String[23];

                while((temp = bufReader1.readLine()) != null) {
                    userAnswers = temp.split(" ");
                    if(data.equals(userAnswers[22]))
                        break;
                }

                int MaxPoint = 0;
                while((temp = bufReader2.readLine()) != null) {
                    int point = 0;
                    otherAnswers = temp.split(" ");
                    if(!(userAnswers[0].equals(otherAnswers[0])) && (!userAnswers[22].equals(otherAnswers[22]))) {      // 성별이 다르고, 다른사람이라면
                        for(int i=1; i<22; i++) {
                            if(userAnswers[i].equals(otherAnswers[i])) {
                                point++;
                            }
                        }
                    }
                    if(point >= MaxPoint) {
                        MaxPoint = point;
                        data = otherAnswers[22];
                    }
                }

                bufReader1.close();
                bufReader2.close();

                receiveData(data, socket);         // 받은 데이터를 그대로 다시 보내기
                System.out.println("****** 전송 완료 ****");
            }
        }catch (Exception e) {
            e.printStackTrace();
        }finally {
            try{
                br.close();
                isr.close();
                is.close();
                server.close();
            }catch(Exception e){
                e.printStackTrace();
            }
        }
    }


    public void receiveData(String data, Socket socket){
        OutputStream os = null;
        OutputStreamWriter osw = null;
        BufferedWriter bw = null;

        try{
            os = socket.getOutputStream();
            osw = new OutputStreamWriter(os);
            bw = new BufferedWriter(osw);
            // 클라이언트로부터 데이터를 보내기 위해 OutputStream 선언

            bw.write(data);            // 클라이언트로 데이터 전송
            bw.flush();
        }catch(Exception e1){
            e1.printStackTrace();
        }finally {
            try{
                bw.close();
                osw.close();
                os.close();
                socket.close();
            }catch(Exception e1){
                e1.printStackTrace();
            }
        }
    }
}



