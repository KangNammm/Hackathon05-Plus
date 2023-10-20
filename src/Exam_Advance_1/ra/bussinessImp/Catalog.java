package Exam_Advance_1.ra.bussinessImp;

import Exam_Advance_1.ra.bussiness.IShop;

import java.util.List;
import java.util.Scanner;

public class Catalog implements IShop {
    private int catalogId;
    private String catalogName;
    private int priority;
    private String description;
    private boolean catalogStatus;
    static int count = 1;
    public Catalog(){
        this.catalogId = count++;
    }

    public Catalog(String catalogName, int priority, String description, boolean catalogStatus) {
        this.catalogId = count++;
        this.catalogName = catalogName;
        this.priority = priority;
        this.description = description;
        this.catalogStatus = catalogStatus;
    }

    public int getCatalogId() {
        return catalogId;
    }

    public void setCatalogId(int catalogId) {
        this.catalogId = catalogId;
    }

    public String getCatalogName() {
        return catalogName;
    }

    public void setCatalogName(String catalogName) {
        this.catalogName = catalogName;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isCatalogStatus() {
        return catalogStatus;
    }

    public void setCatalogStatus(boolean catalogStatus) {
        this.catalogStatus = catalogStatus;
    }

    @Override
    public void inputData(List<Catalog> catalogs) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập tên danh muc : ");
        String name = scanner.nextLine().trim();
        while (name.isEmpty()){
            System.out.println("Không được để trống");
            name = scanner.nextLine().trim();
        }
        this.catalogName = name;

        System.out.println("Nhập độ ưu tiên : (1-5)");
        int prio = Integer.parseInt(scanner.nextLine());
        while (prio > 5){
            System.out.println("Không nằm trong phạm vi, mời nhập lại");
            prio = Integer.parseInt(scanner.nextLine());
        }
        this.priority = prio;

        System.out.println("Nhập mô tả : ");
        String des = scanner.nextLine().trim();
        while (des.isEmpty()){
            System.out.println("Không được để trống");
            des = scanner.nextLine().trim();
        }
        this.description = des;

        System.out.println("Nhập trạng thái : (true/false)");
        this.catalogStatus = Boolean.parseBoolean(scanner.nextLine());

    }


    @Override
    public void displayData() {
        System.out.println("Catalog { " +
                "Mã danh mục : " + catalogId +
                ", Tên danh mục : '" + catalogName + '\'' +
                '}');
    }
}