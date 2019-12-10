package skillup.day4.libarary.view;

import java.util.Scanner;

import skillup.day4.libarary.controller.LibraryManager;
import skillup.day4.libarary.model.vo.Book;
import skillup.day4.libarary.model.vo.Member;

public class LibraryMenu {
	private LibraryManager lm = new LibraryManager();
	Scanner sc = new Scanner(System.in);

	public LibraryMenu() {}

	public void mainMenu() {

		System.out.print("�̸��� �Է��Ͻÿ� : ");
		String name = sc.next();
		System.out.print("���̸� �Է��Ͻÿ� : ");
		int age = sc.nextInt();
		System.out.print("������ �Է��Ͻÿ�(F/M) : ");
		char gender = sc.next().charAt(0);

		lm.insertMember(new Member(name, age, gender));

		do {
			System.out.print("==== �޴� ====");
			System.out.println();
			System.out.println("1.����������");
			System.out.println("2.������ü��ȸ");
			System.out.println("3.�����˻�");
			System.out.println("4.���� �뿩�ϱ�");
			System.out.println("9.���α׷������ϱ�");
			System.out.print("��ȣ �Է�:");
			int no = sc.nextInt();

			switch (no) {

			case 1:
				System.out.println(lm.myPage());
				break;
			case 2:
				selectAll();
				break;
			case 3:
				searchBook();
				break;
			case 4:
				rentBook();
				break;
			case 9:
				System.out.println("�����ϰڽ��ϴ�.");
				return;
			default:
				System.out.println("�ٽ��Է����ּ���");
			}

		} while (true);

	}
	
	
	

	public void selectAll() {

		// lm�� selectAll()�޼ҵ带 ���� ��ü ���� ��� �޾ƿ���
		Book[] bList = lm.selectAll();

		System.out.println("===== ���� ��� =====");
		// for���� �̿��Ͽ� ��� + i�� �̿��Ͽ� �ε����� ���� ���
		for (int i = 0; i < bList.length; i++) {
			System.out.println(i + "�� ���� : " + bList[i].toString()); // �������̵��̱� ������ �������ε����� ����
		}
	}

	public void searchBook() {
		System.out.print("�˻��� ���� �Է� : ");
		String keyword = sc.next();

		// �Է¹��� �˻� ������ lm�� searchTitle()�޼ҵ�� ����, �� �˻� ��� �˻��� ��������� �޾ƿ�
		Book[] searchList = lm.searchBook(keyword);

		// ���� for��(for~each)�� �̿��Ͽ� ���
		for (Book bk : searchList) {
			if (bk != null) // �̰� ���� ��� NullPointerException �߻�
				System.out.println(bk);
		}
	}

	public void rentBook() {
		System.out.print("�뿩 �� ���� ���� : ");
		int index = sc.nextInt();

		// �߸� �� �ε����� �����ϸ� ���ư���
		if (index < 0 || index > 4)
			return;

		// �뿩�� ���� �ε��� ��ȣ�� lm�� rentBook()�޼ҵ�� �����ϰ� �� ��� ���� �޾ƿ�
		int result = lm.rentBook(index);

		// ������ �ش��ϴ� ��¹��� ����ϱ� ���� result �޾���
		if (result == 0) {
			System.out.println("���������� �뿩�Ǿ����ϴ�.");
		} else if (result == 1) {
			System.out.println("���� �������� �뿩 �Ұ��� �Դϴ�.");
		} else if (result == 2) {
			System.out.println("���������� �뿩�Ǿ����ϴ�. �丮�п� ������ �߱޵Ǿ����ϴ�.");
		}
	}

}
