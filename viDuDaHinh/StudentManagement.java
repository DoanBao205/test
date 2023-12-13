package viDuDaHinh;

import java.util.Scanner;
import java.util.Vector;
import java.util.Enumeration;
import java.util.Arrays;

public class StudentManagement {
	Vector list = new Vector();

	public StudentManagement() {
		while (true) {
			System.out.println("*-CHUONG TRINH QUAN LI SINH VIEN-*");
			System.out.println("*-chuc nang chinh cua chuong trinh-*");
			System.out.println("  1. Nhap danh sach sinh vien  ");
			System.out.println("  2. Xem danh sach sinh vien  ");
			System.out.println("  3. Sap xep danh sach sinh vien theo thu tu tang dan diem trung binh  ");
			System.out.println("  4. Tim sih vien theo ten  ");
			System.out.println("  5. Thoat  ");
			System.out.println("  -----------  ");
			
			int num;
			Scanner keyboard = new Scanner(System.in);
			System.out.println("  Nhap mot so de chon chuc nang:  ");
			num = keyboard.nextInt();
			
			switch(num) {
			case 1 : this.input();
			break;
			case 2 : this.view();
			break;
			case 3 : this.sort();
			break;
			case 4 : this.search();
			break;
			case 5 : 
				System.out.println("-----Chuong trinh ket thuc-----");
				break;
			}
			
		}
		}
	public void input() {
		int num;
		Scanner keyboard = new Scanner(System.in);
		System.out.println("Nhap so luong sinh vien: ");
		num = keyboard.nextInt();
		
		for(int i = 0; i <= num; i++) {
			System.out.println("Nhap thong tin cua sinh vien thu "+ i);
			System.out.println("  ID: ");
			int id = Integer.parseInt(keyboard.next());
			keyboard.nextLine();
			System.out.println("  Ten: ");
			String name = keyboard.nextLine();
			
			System.out.println("  Diem Trung Binh: ");
			float aver = keyboard.nextFloat();
			
			Student st = new Student();
			
			list.add(st);
		}
		System.out.println("\n-----------\n");
	}
	
	public void view() {
		System.out.println("  Hien thi thong tin danh sach sinh vien: ");
		Enumeration vEnum = list.elements();
		
		int i = 1;
		while(vEnum.hasMoreElements()) {
			Student sts = (Student)vEnum.nextElement();
			
			System.out.println("   "+i+". ID="+sts.getId()+", Ten="+sts.getName()+", Diem Trung Binh="+ sts.getAver() );
			i++;
		}
		System.out.println("\n----------\n");
	}
	
	public void sort() {
		Student[] sts = new  Student[list.size()];
		int index=0;
		
		Enumeration vEnum = list.elements(); 
		while (vEnum.hasMoreElements()); {
			sts[index] = (Student)vEnum.nextElement();
			index++;
		}
		
		Arrays.sort(sts);
		
		System.out.println("  Danh sach sinh vien sau khi sap xep: ");
		 for(index = 0; index < sts.length; index++) {
			 System.out.println("  "+(index+1)+ ". ID="+sts[index].getId()+ ", Ten="+sts[index].getName()+ ", Diem Trung Binh"+sts[index].getAver());
		 }
		System.out.println("\n---------\n");
		
	}
	public void search() {
		Scanner keyboard = new Scanner(System.in);
		System.out.println("Nhap ten sinh vien can tim: ");
		String name = keyboard.nextLine();
		
		Enumeration vEnum = list.elements();
		
		System.out.println("\n--Thong tin tim kiem duoc--");
		
		while (vEnum.hasMoreElements()) {
			Student sts = (Student)vEnum.nextElement();
			
			if(sts.getName().indexOf(name) != -1) {
				System.out.println("ID = "+sts.getId()+ ", Ten= "+sts.getName()+", Diem Trung Binh="+sts.getAver());	
			}
			System.out.println("\n-------\n");
		}
	}
	
	public static void main(String[] args) {
		new StudentManagement();
	}
}


class Student implements Comparable {
	private int id;
	private String name;
	private float aver;

public Student() {
	name = new String("");
	id = 0;
	aver = 0;
}
public Student(int i, String n, float a) {
	id = i;
	name = n;
	aver = a;
}
public int getId() {
	return id;
}
public String getName() {
	return name;
}
public float getAver() {
	return aver;
}


public int comparateTo(Object other) {
	Student otherRect = (Student)other;
	return (int)(this.aver-otherRect.aver);
}
@Override
public int compareTo(Object o) {
	// TODO Auto-generated method stub
	return 0;
}
}
