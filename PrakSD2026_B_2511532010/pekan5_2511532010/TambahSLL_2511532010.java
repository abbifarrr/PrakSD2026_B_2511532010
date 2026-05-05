package pekan5_2511532010;

public class TambahSLL_2511532010 {
    public static NodeSLL_2511532010 insertAtFront(NodeSLL_2511532010 head_2010, int value_2010) {
        NodeSLL_2511532010 new_node_2010 = new NodeSLL_2511532010(value_2010);
        new_node_2010.next_2010 = head_2010;
        return new_node_2010;
    }

    public static NodeSLL_2511532010 insertAtEnd(NodeSLL_2511532010 head_2010, int value_2010) {
        NodeSLL_2511532010 newNode_2010 = new NodeSLL_2511532010(value_2010);
        if (head_2010 == null) {
            return newNode_2010;
        }
        NodeSLL_2511532010 last_2010 = head_2010;
        while (last_2010.next_2010 != null) {
            last_2010 = last_2010.next_2010;
        }
        last_2010.next_2010 = newNode_2010;
        return head_2010;
    }

    static NodeSLL_2511532010 GetNode(int data) {
        return new NodeSLL_2511532010(data);
    }

    static NodeSLL_2511532010 insertPos(NodeSLL_2511532010 headNode, int position, int value_2010) {
        NodeSLL_2511532010 head_2010 = headNode;
        if (position < 1) {
            System.out.println("Invalid position");
            return head_2010;
        }
        if (position == 1) {
            NodeSLL_2511532010 new_node_2010 = new NodeSLL_2511532010(value_2010);
            new_node_2010.next_2010 = head_2010;
            return new_node_2010;
        } else {
            // Perbaikan logika traversal agar tidak null pointer
            while (position-- != 0 && headNode != null) {
                if (position == 1) {
                    NodeSLL_2511532010 newNode_2010 = GetNode(value_2010);
                    newNode_2010.next_2010 = headNode.next_2010;
                    headNode.next_2010 = newNode_2010;
                    return head_2010;
                }
                headNode = headNode.next_2010;
            }
            System.out.println("posisi di luar jangkauan");
            return head_2010;
        }
    } // Penutup method insertPos yang benar

    public static void printList(NodeSLL_2511532010 head_2010) {
        if (head_2010 == null) {
            System.out.println("List kosong");
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
    	NodeSLL_2511532010 head_2010 = new NodeSLL_2511532010(2);
    	head_2010.next_2010 = new NodeSLL_2511532010(3);
    	head_2010.next_2010.next_2010 = new NodeSLL_2511532010(5);
    	head_2010.next_2010.next_2010.next_2010 = new NodeSLL_2511532010(6);
    	
    	System.out.print("Senarai berantai awal ; ");
    	printList (head_2010);
    	System.out.print("tambah 1 simpul di depan : ");
    	int data_2010 = 1;
    	head_2010 = insertAtFront (head_2010, data_2010);
    	printList (head_2010);
    	System.out.print ("tambah 1 simpul di belakang :");
    	int data2_2010 = 7;
    	head_2010 = insertAtEnd (head_2010, data2_2010);
    	printList(head_2010);
    	System.out.print ("tambah 1 simpul ke data 4");
    	int data3_2010 = 4;
    	int pos_2010 = 4;
    	head_2010 = insertPos (head_2010, pos_2010, data3_2010);
    	printList(head_2010);
    }
}