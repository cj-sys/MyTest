package io.data.test.controller;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class SungjukProcess {
	Scanner sc = new Scanner(System.in);

	public void sungjukSave() {
		int num = 0;

		try (DataOutputStream dos = new DataOutputStream(new FileOutputStream("score.txt"))) {
			while (true) {
				System.out.println("======다음의 성적들을 입력하시오======");
				System.out.print("국어 : ");
				int kor = sc.nextInt();
				System.out.print("영어 : ");
				int eng = sc.nextInt();
				System.out.print("수학 : ");
				int mat = sc.nextInt();

				int sum = kor + eng + mat;
				double avg = sum / 3.0;

				dos.writeInt(kor);
				dos.writeInt(eng);
				dos.writeInt(mat);
				dos.writeInt(sum);
				dos.writeDouble(avg);

				num++;
				System.out.println(num + "번째 학생 정보 기록");

				String ans = "";
				//계속입력할지 그만입력할지
				//y,n 이외에 다른걸 입력할경우 계속 입력받기 위해.
				while (true) {
					System.out.print("계속 저장하시겠습니까? (y/n)");
					ans = sc.next();
					if (ans.equalsIgnoreCase("y") || ans.equalsIgnoreCase("n")) {
						break;
					} else {
						System.out.println("잘못 입력하셨습니다. 다시 입력해주세요.");
						continue;
					}
				}
				if (ans.equalsIgnoreCase("y")) {
					continue;
				} else if (ans.equalsIgnoreCase("n")) {
					System.out.println("score.txt 파일에 저장 완료");
					break;
				}
			}

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public void scoreRead() {
		int kor = 0, eng = 0, mat = 0, sum = 0, sumS = 0;
		double avg = 0.0, avgS = 0.0;
		int count = 0;

		try (DataInputStream dis = new DataInputStream(new FileInputStream("score.txt"))) {

			while (true) {

				kor = dis.readInt();
				eng = dis.readInt();
				mat = dis.readInt();
				sum = dis.readInt();
				avg = dis.readDouble();

				sumS += sum;
				avgS += avg;

				count++;
				System.out.println(count + "번째 학생");
				System.out.printf("국\t영\t수\t총점\t평균\n");
				System.out.printf("%d\t%d\t%d\t%d\t%.2f\n", kor, eng, mat, sum, avg);

			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (EOFException e) {

			System.out.println("읽은 횟수\t전체 총점\t전체 평균");
			System.out.printf("%d\t%.2f  \t%.2f\n", count, sumS / (double) count, avgS / (double) count);

			System.out.println("score.dat 파일 읽기 완료!");

		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
