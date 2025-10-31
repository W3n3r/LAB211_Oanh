package Week6.FruitShop;
import java.util.*;

public class FruitShop {
     
    private List<Fruit> fruits = new ArrayList<>();
    private List<Order> orders = new ArrayList<>();
    private Scanner sc = new Scanner(System.in);

    public void run() {   
        addFruits();
        showFruits();
        shopping();
        viewOrders();
        showFruits();
        
    }
    private void addFruits() {  
        fruits.add(new Fruit("01", "banana", 3.0, 12,  "VN"));
        fruits.add(new Fruit("02", "orange", 3.5, 120, "VN"));
        fruits.add(new Fruit("03", "apple", 1.5, 100,  "VN"));
    }
    private void showFruits() {
        System.out.println("danh muc kho :");
        System.out.println("| Item | Fruit Name | Origin | Price | Quantity |");
        int i = 1;
        for (Fruit f : fruits) {
            System.out.printf("%-5d | %-10s | %-10s | %.2f$ | %d\n",
                    i++, f.getName(), f.getOrigin(), f.getPrice(), f.getQuantity());
        }
    }

    private void shopping() {
        System.out.print("Enter customer name: ");
        String customer = sc.nextLine().trim();
        if (customer.isEmpty()) customer = "Guest";
        Order order = new Order(customer);// tên khách hàng

        // Dùng LinkedHashMap để giữ thứ tự chọn
        Map<String, OrderDetail> bag = new LinkedHashMap<>();

        while (true) {
            showFruits();
            System.out.print("Chọn số mục (1-" + fruits.size() + ") hoặc gõ 'x' để kết thúc: ");
            String choice = sc.nextLine().trim();
            if (choice.equalsIgnoreCase("x")) {
                break;
            }
            int idx;
            try {
                idx = Integer.parseInt(choice);
            } catch (NumberFormatException e) {
                System.out.println("Vui lòng nhập một số hợp lệ hoặc 'x'.");
                continue;
            }
            if (idx < 1 || idx > fruits.size()) {
                System.out.println("Mục không hợp lệ.");
                continue;
            }
            Fruit selected = fruits.get(idx - 1);
            System.out.print("Nhập số kg muốn mua cho " + selected.getName() + ": ");
            String sQty = sc.nextLine().trim();
            int qty;
            try {
                qty = Integer.parseInt(sQty);
            } catch (NumberFormatException e) {
                System.out.println("Số lượng không hợp lệ.");
                continue;
            }
            if (qty <= 0) {
                System.out.println("Số lượng phải lớn hơn 0.");
                continue;
            }
            if (qty > selected.getQuantity()) {
                System.out.println("Không đủ hàng. Tồn kho hiện tại: " + selected.getQuantity());
                continue;
            }

            // trừ tồn kho ngay khi xác nhận mua
            selected.setQuantity(selected.getQuantity() - qty);

            // gom vào bag: nếu đã có thì tăng số lượng, nếu chưa thì thêm mới
            OrderDetail od = bag.get(selected.getId());
            if (od == null) {
                od = new OrderDetail(selected, qty);
                bag.put(selected.getId(), od);
            } else {
                od.increaseQuantity(qty);
            }

            System.out.print("Tiếp tục mua (y/n)? ");
            String more = sc.nextLine().trim();
            if (more.equalsIgnoreCase("n") || more.equalsIgnoreCase("no")) {
                break;
            }
        }

        // Thêm các chi tiết vào đơn hàng (mỗi sản phẩm 1 dòng, đã gom số lượng)
        for (OrderDetail od : bag.values()) {
            order.addDetail(od);
        }
        if (!order.getDetails().isEmpty()) {
            orders.add(order);
            System.out.println("Đã thêm đơn hàng cho khách: " + customer);
        } else {
            System.out.println("Không có sản phẩm nào được mua.");
        }
    }


    private void viewOrders() {
          System.out.println("danh sach chi tiet mua hang :");
           for (Order o : orders) {
            System.out.println(o);
        }
    }
}