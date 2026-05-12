package pekan6_2511532010;

public class InsertDLL_2511532010 {
    
    static NodeDLL_2511532010 insertBegin(NodeDLL_2511532010 head_2010, int data_2010) {
        NodeDLL_2511532010 new_node_2010 = new NodeDLL_2511532010(data_2010);
        new_node_2010.next_2010 = head_2010;
        if (head_2010 != null) {
            head_2010.prev_2010 = new_node_2010;
        }
        return new_node_2010;
    }

    public static NodeDLL_2511532010 insertEnd(NodeDLL_2511532010 head_2010, int newData_2010) {
        NodeDLL_2511532010 newNode_2010 = new NodeDLL_2511532010(newData_2010);
        if (head_2010 == null) {
            head_2010 = newNode_2010;
        } else {
            NodeDLL_2511532010 curr_2010 = head_2010;
            while (curr_2010.next_2010 != null) {
                curr_2010 = curr_2010.next_2010;
            }
            curr_2010.next_2010 = newNode_2010;
            newNode_2010.prev_2010 = curr_2010;
        }
        return head_2010;
    }

    public static NodeDLL_2511532010 insertAtPosition(NodeDLL_2511532010 head_2010, int pos_2010, int new_data_2010) {
        NodeDLL_2511532010 new_node_2010 = new NodeDLL_2511532010(new_data_2010);
        if (pos_2010 == 1) {
            new_node_2010.next_2010 = head_2010;
            if (head_2010 != null) {
                head_2010.prev_2010 = new_node_2010;
            }
            head_2010 = new_node_2010;
            return head_2010;
        }

        NodeDLL_2511532010 curr_2010 = head_2010;
        for (int i = 1; i < pos_2010 - 1 && curr_2010 != null; ++i) {
            curr_2010 = curr_2010.next_2010;
        }

        if (curr_2010 == null) {
            System.out.println("Posisi tidak ada");
            return head_2010;
        }

        new_node_2010.prev_2010 = curr_2010;
        new_node_2010.next_2010 = curr_2010.next_2010;
        curr_2010.next_2010 = new_node_2010;

        if (new_node_2010.next_2010 != null) {
            new_node_2010.next_2010.prev_2010 = new_node_2010;
        }

        return head_2010;
    }

   
    public static void printList(NodeDLL_2511532010 head_2010) {
        NodeDLL_2511532010 curr_2010 = head_2010;
        while (curr_2010 != null) {
            System.out.print(curr_2010.data_2010);

            if (curr_2010.next_2010 != null) {
                System.out.print(" <-> ");
            }
            curr_2010 = curr_2010.next_2010;
        }
        System.out.println(); 
    }

    public static void main(String[] args) {
        NodeDLL_2511532010 head_2010 = new NodeDLL_2511532010(2);
        head_2010.next_2010 = new NodeDLL_2511532010(3);
        head_2010.next_2010.prev_2010 = head_2010;
        head_2010.next_2010.next_2010 = new NodeDLL_2511532010(5);
        head_2010.next_2010.next_2010.prev_2010 = head_2010.next_2010;

        System.out.print("DLL Awal: ");
        printList(head_2010);

        head_2010 = insertBegin(head_2010, 1);
        System.out.print("simpul 1 ditambah di awal: ");
        printList(head_2010);

        int data_akhir = 6;
        head_2010 = insertEnd(head_2010, data_akhir);
        System.out.print("simpul 6 ditambah di akhir: ");
        printList(head_2010);

        int data_pos = 4;
        int pos = 4;
        System.out.print("tambah node 4 di posisi 4: ");
        head_2010 = insertAtPosition(head_2010, pos, data_pos);
        printList(head_2010);
    }
}