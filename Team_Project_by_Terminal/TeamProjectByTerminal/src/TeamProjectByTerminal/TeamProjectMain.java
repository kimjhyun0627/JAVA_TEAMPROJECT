package TeamProjectByTerminal;

import java.util.ArrayList;
import java.util.Scanner;

public class TeamProjectMain {

	public static void main(String[] args) {

		Date n = new Date();
		System.out.println(n.toString());

		Student s = new Student("2021111873", "김진현", "01023824633", "kimjhyun0627", 82, false);
		System.out.println(s.toString());

		Cabinet c = new Cabinet(82, "0004");
		System.out.println(c.toString());
		
		c.changePW("0627");
		System.out.println(c.toString());
		
		c.changePW("abcd");
		System.out.println(c.toString());//여기서 오류뜨게

		BorrowObj b1 = new BorrowObj(3, new Date(), new Date(2023, 5, 8, 11, 38, 23), "2021111873");
		BorrowObj b2 = new BorrowObj(5, new Date(), new Date(), "1234567890");
		BorrowObj b3 = new BorrowObj(8, "9999911111");

		System.out.println(b1.toString());
		System.out.println(b2.toString());
		System.out.println(b3.toString());

		//테스트 코드임
		Scanner in = new Scanner(System.in);
		
		System.out.println("5번 돗자리) -1:나가기 0:반납시간수정 1:대여시간수정");
		while (true) {

			int i = in.nextInt();
			if (i == 0) {
				b2.updateEnd();
				System.out.println("5번 돗자리 반납시간 수정 : "+b2.toString());
			}
			if (i == 1) {
				b2.updateStart();
				System.out.println("5번 돗자리 대여시간 수정 : "+b2.toString());
			}
			if(i==-1)
				break;
		}
		
		System.out.println("8번 돗자리) -1:나가기 0:반납시간수정 1:대여시간수정");
		while (true) {

			int i = in.nextInt();
			if (i == 0) {
				b3.updateEnd();
				System.out.println("8번 돗자리 반납시간 수정 : "+b3.toString());
			}
			if (i == 1) {
				b3.updateStart();
				System.out.println("8번 돗자리 대여시간 수정 : "+b3.toString());
			}
			if(i==-1)
				break;
		}
		
		in.close();
		
	}

}
