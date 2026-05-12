package pekan6_2511532010;

// Struktur Node untuk Doubly Linked List


public class HapusDLL_2511532010 {


    public static NodeDLL_2511532010 delHead(NodeDLL_2511532010 head_2010) {
        if (head_2010 == null) {
            return null;
        }
        head_2010 = head_2010.next_2010;
        if (head_2010 != null) {
            head_2010.prev_2010 = null;
        }
        return head_2010;
    }


    public static NodeDLL_2511532010 delLast(NodeDLL_2511532010 head_2010) {
        if (head_2010 == null || head_2010.next_2010 == null) {
            return null;
        }
        
        NodeDLL_2511532010 curr_2010 = head_2010;
        while (curr_2010.next_2010 != null) {
            curr_2010 = curr_2010.next_2010;
        }

        if (curr_2010.prev_2010 != null) {
            curr_2010.prev_2010.next_2010 = null;
        }
        return head_2010;
    }

    // Method menghapus node pada posisi tertentu
    public static NodeDLL_2511532010 delPos(NodeDLL_2511532010 head_2010, int pos_2010) {
        if (head_2010 == null) {
            return head_2010;
        }
        
        NodeDLL_2511532010 curr_2010 = head_2010;
        for (int i = 1; curr_2010 != null && i < pos_2010; i++) {
            curr_2010 = curr_2010.next_2010;
        }

        if (curr_2010 == null) {
            return head_2010;
        }

        if (curr_2010.prev_2010 != null) {
            curr_2010.prev_2010.next_2010 = curr_2010.next_2010;
        }
        if (curr_2010.next_2010 != null) {
            curr_2010.next_2010.prev_2010 = curr_2010.prev_2010;
        }
        

        if (head_2010 == curr_2010) {
            head_2010 = curr_2010.next_2010;
        }
        
        return head_2010;
    }


    public static void printList_2010(NodeDLL_2511532010 head_2010) {
        NodeDLL_2511532010 curr_2010 = head_2010;
        while (curr_2010 != null) {
            System.out.print(curr_2010.data_2010 + " ");
            curr_2010 = curr_2010.next_2010;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        NodeDLL_2511532010 head_2010 = new NodeDLL_2511532010(1);
        head_2010.next_2010 = new NodeDLL_2511532010(2);
        head_2010.next_2010.prev_2010 = head_2010;
        
        head_2010.next_2010.next_2010 = new NodeDLL_2511532010(3);
        head_2010.next_2010.next_2010.prev_2010 = head_2010.next_2010;
        
        head_2010.next_2010.next_2010.next_2010 = new NodeDLL_2511532010(4);
        head_2010.next_2010.next_2010.next_2010.prev_2010 = head_2010.next_2010.next_2010;
        
        head_2010.next_2010.next_2010.next_2010.next_2010 = new NodeDLL_2511532010(5);
        head_2010.next_2010.next_2010.next_2010.next_2010.prev_2010 = head_2010.next_2010.next_2010.next_2010;

        System.out.print("DLL Awal: ");
        printList_2010(head_2010);

        System.out.print("Setelah head dihapus: ");
        head_2010 = delHead(head_2010);
        printList_2010(head_2010);

        System.out.print("Setelah node terakhir dihapus: ");
        head_2010 = delLast(head_2010);
        printList_2010(head_2010);

        System.out.print("Menghapus node ke-2: ");
        head_2010 = delPos(head_2010, 2);
        printList_2010(head_2010);
    }
}