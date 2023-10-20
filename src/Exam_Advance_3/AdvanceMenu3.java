package Exam_Advance_3;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class AdvanceMenu3 {
    static Queue<String> parentList = new LinkedList<>();
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int choice = 0;
        while (choice != 3){
            System.out.println("--------------------Danh mục----------------------");
            System.out.println("1. Nhập tên phụ huynh nộp hồ sơ");
            System.out.println("2. Phụ huynh tiếp theo");
            System.out.println("3. Thoát");
            choice = Integer.parseInt(scanner.nextLine());
            switch (choice){
                case 1:
                    inputNameParent();
                    break;
                case 2:
                    nextParent();
                    break;
                case 3:
                    System.out.println("---------------Đã thoát chương trình---------------");
                    break;
                default:
                    System.out.println("---------------Không hợp lệ. Vui lòng chọn lại---------------");
                    break;
            }
        }
    }

    private static void inputNameParent() {
        System.out.print("Nhập tên phụ huynh: ");
        String parentName = scanner.nextLine();
        parentList.offer(parentName);
    }

    private static void nextParent() {
        if (!parentList.isEmpty()) {
            String next = parentList.poll();
            System.out.println("Phụ huynh tiếp theo: " + next);
        } else {
            System.out.println("Không còn phụ huynh trong danh sách.");
        }
    }

}
