package Week6.FruitShop;
import java.util.*;
 public class FruitShop {
     
    private List<Fruit> fruits = new ArrayList<>();
    private List<Order> orders = new ArrayList<>();
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
        Order order1 = new Order("Hung");//Hung la ten khach hang
        
        List<OrderDetail> bag = new ArrayList<>();   
            Fruit item1 = fruits.get(1);
            int qty1 = 10;
            item1.setQuantity(item1.getQuantity() - qty1);
            bag.add(new OrderDetail(item1, qty1));
            Fruit item2 = fruits.get(2);
            int qty2 = 10;
            item2.setQuantity(item2.getQuantity() - qty2);
            bag.add(new OrderDetail(item2, qty2));             
        for (OrderDetail od : bag) {
            order1.addDetail(od);
        }
        orders.add(order1);
        while (true) {
            showFruits();
            System.out.print("chon (1-" + fruits.size() + ") de ket thuc ");
            String choice = sc.nextLine().trim();
            if (choice.equalsIgnoreCase("x")) break;

            int idx;
            try {
                idx = Integer.parseInt(choice);
            } catch (NumberFormatException e) {
                System.out.println("Nhập không hợp lệ.");
                continue;
            }
            if (idx < 1 || idx > fruits.size()) {
                System.out.println("Mục không hợp lệ.");
                continue;
            }

    }


    private void viewOrders() {
          System.out.println("danh sach chi tiet mua hang :");
           for (Order o : orders) {
            System.out.println(o);
        }
    }
}


//
//
//   List<OrderDetail> bag2 = new ArrayList<>();      
//            Fruit item3 = fruits.get(0);
//            int qty3 = 5;
//            item3.setQuantity(item3.getQuantity() - qty3);
//            bag2.add(new OrderDetail(item3, qty3));
//            
//            Fruit item4 = fruits.get(2);
//            int qty4 = 10;
//            item4.setQuantity(item4.getQuantity() - qty4);
//            bag2.add(new OrderDetail(item4, qty2));
//            //...
//               
//        for (OrderDetail od : bag2) {
//            order2.addDetail(od);
//        }