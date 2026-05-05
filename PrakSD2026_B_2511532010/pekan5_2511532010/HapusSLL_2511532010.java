package pekan5_2511532010;

public class HapusSLL_2511532010 {

    public static NodeSLL_2511532010 deteleHead(NodeSLL_2511532010 head_2010) {
        if (head_2010 == null)
            return null;
        head_2010 = head_2010.next_2010;
        return head_2010;
    }

    public static NodeSLL_2511532010 removeLastNode(NodeSLL_2511532010 head_2010) {
        if (head_2010 == null || head_2010.next_2010 == null) {
            return null;
        }
        NodeSLL_2511532010 secondLast_2010 = head_2010;
        while (secondLast_2010.next_2010.next_2010 != null) {
            secondLast_2010 = secondLast_2010.next_2010;
        }
        secondLast_2010.next_2010 = null;
        return head_2010;
    }

    public static NodeSLL_2511532010 deleteNode(NodeSLL_2511532010 head_2010, int position_2010) {
        NodeSLL_2511532010 temp_2010 = head_2010;
        NodeSLL_2511532010 prev_2010 = null;

        if (temp_2010 == null)
            return head_2010;

        if (position_2010 == 1) {
            head_2010 = temp_2010.next_2010;
            return head_2010;
        }

        for (int i = 1; temp_2010 != null && i < position_2010; i++) {
            prev_2010 = temp_2010;
            temp_2010 = temp_2010.next_2010;
        }

        if (temp_2010 != null) {
            prev_2010.next_2010 = temp_2010.next_2010;
        } else {
            System.out.println("Data tidak ada");
        }
        return head_2010;
    }

    public static void printList(NodeSLL_2511532010 head_2010) {
        if (head_2010 == null) {
            System.out.println("List Kosong");
            return;
        }
        NodeSLL_2511532010 curr_2010 = head_2010;
        while (curr_2010.next_2010 != null) {
            System.out.print(curr_2010.data_2010 + "-->");
            curr_2010 = curr_2010.next_2010;
        }
        System.out.println(curr_2010.data_2010);
    }

    public static void main(String[] args) {

        NodeSLL_2511532010 head_2010 = new NodeSLL_2511532010(1);
        head_2010.next_2010 = new NodeSLL_2511532010(2);
        head_2010.next_2010.next_2010 = new NodeSLL_2511532010(3);
        head_2010.next_2010.next_2010.next_2010 = new NodeSLL_2511532010(4);
        head_2010.next_2010.next_2010.next_2010.next_2010 = new NodeSLL_2511532010(5);
        head_2010.next_2010.next_2010.next_2010.next_2010.next_2010 = new NodeSLL_2511532010(6);

        System.out.print("List awal : ");
        printList(head_2010);

        head_2010 = deteleHead(head_2010);
        System.out.print("List setelah head dihapus : ");
        printList(head_2010);

        head_2010 = removeLastNode(head_2010);
        System.out.print("List setelah simpul terakhir dihapus : ");
        printList(head_2010);

        int position_2010 = 2;
        head_2010 = deleteNode(head_2010, position_2010);
        System.out.print("List setelah posisi 2 dihapus : ");
        printList(head_2010);
    }
}