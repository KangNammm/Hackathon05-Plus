package Exam_Advance_2;

import java.util.Scanner;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class AdvanceMenu2 {
    static Scanner scanner = new Scanner(System.in);
    static Stack<String> stack = new Stack<>();
    static String sentence = "";

    public static void main(String[] args) {
        int choice = 0;
        while (choice != 3){
            System.out.println("--------------------Danh mục----------------------");
            System.out.println("1. Nhập câu");
            System.out.println("2. Đảo ngược câu");
            System.out.println("3. Thoát");
            choice = Integer.parseInt(scanner.nextLine());
            switch (choice){
                case 1:
                    inputString();
                    break;
                case 2:
                    sortString();
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

    private static void inputString() {
        System.out.print("Nhập câu : ");
        sentence = scanner.nextLine();
    }

    private static void sortString() {
        if (!sentence.isEmpty()) {
            stack.clear();
            String[] words = sentence.split(" ");
            for (String word : words) {
                stack.push(word);
            }

            System.out.print("Câu đảo ngược: ");
            while (!stack.isEmpty()) {
                System.out.print(stack.pop() + " ");
            }
            System.out.println();
        } else {
            System.out.println("Bạn cần nhập câu trước.");
        }
    }
}
