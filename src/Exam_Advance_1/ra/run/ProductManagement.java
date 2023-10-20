package Exam_Advance_1.ra.run;

import Exam_Advance_1.ra.bussinessImp.Catalog;
import Exam_Advance_1.ra.bussinessImp.Product;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class ProductManagement {
    static Scanner scanner = new Scanner(System.in);

    public static List<Catalog> catalogs  = new ArrayList<>();
    public static List<Product> products = new ArrayList<>();
    static {
        catalogs.add(new Catalog("Quần áo nữ", 4, "Toàn hot mới nhập từ Taobao", true));
        catalogs.add(new Catalog("Quần áo nam", 3, "Toàn mới về nhiều mẫu", true));
        catalogs.add( new Catalog("Trang sức nữ", 4, "Được thiết kết từ những thợ thủ công hàng đầu", true));
    }
    static {
        products.add(new Product("Áo dài tay", "Hàng Taobao", "Đẹp khỏi chê", catalogs.get(0),40000, 49000, true));
        products.add(new Product("Vòng cổ hoa hồng", "Trang sức", "Wowww đẹp quá", catalogs.get(2),200000, 260000, true));
        products.add(new Product("Váy công chúa", "Hàng Taobao", "Vừa đẹp, vừa rẻ", catalogs.get(0),60000, 69000, false));
    }

    public static void main(String[] args) {
        int choice = 0;
        while (choice != 5) {
            System.out.println("--------------------Danh mục----------------------");
            showAllCatalog();
            System.out.println("--------------------Sản phẩm----------------------");

            showAllProduct();
            System.out.println("---------------------Product Management----------------------");
            System.out.println("---------------------Danh mục----------------------");
            System.out.println("1. Thêm danh mục sản phẩm");
            System.out.println("2. Thêm sản phẩm");
            System.out.println("3. Sắp xếp sản phẩm theo giá tăng dần");
            System.out.println("4. Tìm kiếm sản phẩm theo danh mục sản phẩm ");
            System.out.println("5. Thoát");
            choice = Integer.parseInt(scanner.nextLine());
            switch (choice){
                case 1:
                    addCatalog();
                    break;
                case 2:
                    addProduct();
                    break;
                case 3:
                    sortProduct();
                    break;
                case 4:
                    findProduct();
                    break;
                case 5:
                    System.out.println("---------------Đã thoát chương trình---------------");
                    break;
                default:
                    System.out.println("---------------Không hợp lệ. Vui lòng chọn lại---------------");
                    break;
            }
        }
    }
    private static void showAllCatalog(){
        for (int i = 0; i < catalogs.size(); i++) {
            catalogs.get(i).displayData();
        }
        System.out.println("--------------------------------------------");
    }
    private static void showAllProduct(){
        for (int i = 0; i < products.size(); i++) {
            products.get(i).displayData();
        }
        System.out.println("--------------------------------------------");
    }

    private static void addCatalog() {
        Catalog catalog = new Catalog();
        catalog.inputData(catalogs);
        catalogs.add(catalog);
        System.out.println("-----------Thêm mới thành công----------");
        System.out.println("----------------------------------------");
    }

    private static void addProduct() {
        Product product = new Product();
        product.inputData(catalogs);
        if (product.getCatalog() == null){
            System.out.println("Không tìm thấy danh mục vừa nhập. Mời thêm mới.");
        } else {
            products.add(product);
            System.out.println("-----------Thêm mới thành công----------");
            System.out.println("----------------------------------------");
        }

    }

    private static void sortProduct() {
        System.out.println("------------------Danh sách theo thứ tự giá tăng dần------------------");
        products.sort(new Comparator<Product>() {
            @Override
            public int compare(Product o1, Product o2) {
                return (int) (o1.getExportPrice() - o2.getExportPrice());

            }
        });
        for (int i = 0; i < products.size(); i++) {
            products.get(i).displayData();
        }
        System.out.println("----------------------------------------");
    }

    private static void findProduct() {
        System.out.println("Nhập tên sản phẩm muốn tìm kiếm : ");
        String name = scanner.nextLine().trim().toLowerCase();
        boolean searchCheck = false;
        for (int i = 0; i < products.size(); i ++) {
            if (products.get(i).getProductName().toLowerCase().contains(name)) {
                if (!searchCheck) {
                    System.out.println("--------------------Kết quả tìm kiếm--------------------");
                    products.get(i).displayData();
                    searchCheck = true;
                }
            }
        }
        if (!searchCheck) {
            System.out.println("Không tìm thấy sản phẩm nào phù hợp với từ khóa tìm kiếm.");
            System.out.println("----------------------------------------");
        }
    }
}
