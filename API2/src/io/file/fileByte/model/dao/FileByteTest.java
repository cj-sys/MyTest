package io.file.fileByte.model.dao;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileByteTest {
	// 여러분은 알게모르게 입출력을 해왔다. System.in, System.out


	public FileByteTest() {
	}

	//바이트 기반스트림으로 바이트단위로 데이터를 전송
	
	//FileInput/OutputStream -> 파일
	//ByteArrayInput/OutputStream -> 메모리(byte배열)
	//PipedInput/OutputStream ->프로세스(프로세스간의 통신)
	//AudioInput/OutputStream ->오디오 장치
	
	
	
	//불어올 파일 없으니 Save부터 해보자
	public void fileSave() {
		
		//자바에서 나가는거죠?? 밖으로 txt 저장, output으로 진행
		File file = new File("test.txt");
		
		
		//FileOutputStream에서 없는 파일일 경우 생성을 해줘서 FileNotFoundException이 안뜨지만
		//여기서 발생하는 경우는 존재하지 않은경로 -> "지정된 경로를 찾을수 없습니다"라고 뜰수있따.
/*		
		try {
			FileOutputStream fout = new FileOutputStream(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
*/		
		//요렇게만 해서 실행함 해보소~
		//파일 성생 된거 확인 되냐??? 아무것도 없느 ㄴ파일  
		//기억 날지 모르겟지만, file대신 'sample.txt'라고도 가능한가??? 가능하죠?? 
		//왜그러냐 하면 ctr 눌러서 코드 들어가보면 new File로 안에서 생성해 주는걸 볼수 있따.
		//그래서 굳이 File 이건 필요 없는것이다. 파일명만 써줘도 생성이 된다!!라고정도만 기억해두자
	
		
		
		// 이렇게 진행해 보자요
		FileOutputStream fout = null;
		//요놈이 try 안에 있으면 에러가난다요!
		
		try {
			fout = new FileOutputStream("sample.txt");
			
			//FileOutputStream이라는 것에 제공해주는 메서드를 사용해보자
			//write3가지 종류가 있는데 첫날이니 다 해봅시다
			
			//write(int) : 주어진값 쓰기
			fout.write(65);	
			//얘도 코드 확인해보면 throws 잇죠?? 캐치 해줘야된다.!
			
			
			//write(byte[]) : 배열에 저장된 모든 내용 쓰기
			byte[] barr = new byte[] {97,98};
			fout.write(barr);	
			
			
			//write(byte[] b, int off, int len) : 주어진배열에서 저장된 내용중 off부터 len개만큼쓰기 
			fout.write(barr, 0, 1);	
			
			//sample.txt 확인 해보면 Aaba 확인 가능
			
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} /*finally {
			try {
				fout.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}*/
	
	}
	
	public void fileRead() {
		
		FileInputStream fis = null;
		
		
		try {
			fis = new FileInputStream("sample.txt");
			
//			System.out.println(fis.read());
//			System.out.println(fis.read());
//			System.out.println(fis.read());
//			System.out.println(fis.read());
//			System.out.println(fis.read());
			//4개 저장했는데 5개까지 출력을 해보자.
			//유니코드롤 출력되고, 마지막에 -1 출력
			//읽고~읽고~읽고~ 없을땐 -1 반환!!
			
			//반복문으로 궈궈
			//(1)
/*			while(fis.read() != -1) {
				System.out.println((char)fis.read());
			}
*/			
			//개똥이다!! aa만출력된다..!!
			//4개중에 1번째를 와일문 조건식때문에 버퍼에 담기고 출력문의 read가 2번째를 담고
			//다시 와일문 조건식에 3번째 데이터를 건들이고 출력문에서 마지막 데이터를 건들이는 것이다!!
			
			//(2) temp에 담아서 temp를 출력
			int temp=0;
			while((temp=fis.read()) != -1) {
				System.out.print((char)temp);
			}
			
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	
	
}
