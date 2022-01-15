public class LinkedList
{
    Node first;

    public void append(String x)
    {
        Node newNode = new Node(x);
        if (first == null)
        {
            first = newNode;
        }
        else
        {
        Node i = first;
        while (true)
        {
            if (i.next == null)
            {
                i.next = newNode;
                break;
            }
            i = i.next;
        }  }
    }

    public void prepend(String x) {
        Node node = new Node(x);
        node.next = first;
        first = node;
    }

    public void addByIndexBefore (int index, String value) {
        int currIndex = 0;
        for (Node i = first; i != null; i = i.next) {
            if ((currIndex+1) == index) {
                Node temporary = i.next;
                Node newOne = new Node(value);
                i.next = newOne;
                newOne.next = temporary;
                break;
            }
            currIndex++;
        }
    }

    public void addByIndexAfter (int index, String value) {
        int currIndex = 0;
        for (Node i = first; i != null; i = i.next) {
            if (currIndex == index) {
                Node temp = i.next;
                Node newNode = new Node(value);
                i.next = newNode;
                newNode.next = temp;
                break;
            }
            currIndex++;
        }
    }

    public void addByNodeBefore (Node node, String newValue) {
        for (Node i = first; i != null; i = i.next) {
            if (i.next == node) {
                Node temp = i.next;
                Node newNode = new Node(newValue);
                i.next = newNode;
                newNode.next = temp;
                break;
            }
        }
    }

    public void addByNodeAfter (Node node, String newValue) {
        for (Node i = first; i != null; i = i.next) {
            if (i == node) {
                Node temp = i.next;
                Node newNode = new Node(newValue);
                i.next = newNode;
                newNode.next = temp;
                break;
            }
        }
    }

    public void setValue(int index, String value) {
        int currIndex = 0;
        for (Node i = first; i!=null ; i = i.next) {
            if (index == currIndex){
                i.hodnota = value;
                break;
            }
            currIndex++;
        }
    }

    public int getLength()
    {
        int length = 0;
        for (Node i = first; i != null ; i = i.next)
        {
            length++;
        }
        return length;
    }

    public String getList()
    {
        String res = "";
        for (Node i = first; i != null ; i = i.next)
        {
            res+=i.hodnota +"->";
        }
        if (res.equals(""))
            return "NO DATA";
        else
            return res;
    }

    public String getValueByPointer(Node node) {
        if (node==null) return null;
        for (Node i = first; i != null ; i = i.next)
        {
            if (i.equals(node)) return i.hodnota;
        }
        return "NO DATA";
}

    public String getValueByIndex(int index) {
        int currIndex = 0;
        for (Node i = first; i != null ; i = i.next) {
            if (currIndex == index) return i.hodnota;
            else currIndex++;
        }
        return "NO DATA";
    }

    public Node getNodeByIndex(int index) {
        int currIndex = 0;
        for (Node i = first; i != null; i = i.next) {
            if (currIndex == index) {
                return i;
            }
            currIndex++;
        }
        return null;
    }

    public Node getNodeByValue(String value) {
        for (Node i = first; i != null ; i = i.next) {
            if (i.hodnota.equals(value)) return i;
        }
        return null;
    }

    public int getIndexByValue(String value) {
        int currIndex = 0;
        for (Node i = first; i != null ; i = i.next) {
            if (i.hodnota.equals(value)) return currIndex;
            else currIndex++;
        }
        return -1;
    }

    public int getIndexByPointer(Node node) {
        int currIndex = 0;
        for (Node i = first; i != null ; i = i.next) {
            if (i.equals(node)) return currIndex;
            else currIndex++;
        }
        return -1;
    }

    public void deleteByValue(String value) {
           for (Node i = first; i!=null ; i = i.next)
           {
               if (i.next == null) {
                   break;
               }

               if ((i.next.hodnota.equals(value))) {
                   i.next = i.next.next;
                   break;
               }
           }
    }

    public void deleteByIndex(int index) {
        int currIndex = 0;
        for (Node i = first; i != null; i = i.next) {
            if ((index < 0)) {
                break;
            }

            if ((currIndex == 0) && (currIndex == index)) {
                if (i.next == null) {
                    first = null;
                }
                else {
                    first = first.next;
                }
                break;
            }

            if ((currIndex+1) == index) {
                i.next = i.next.next;
                break;
            }
            currIndex++;
        }
    }

    public void deleteByPointer (Node node) {
        for (Node i = first; i != null; i = i.next) {
            if (i.next == node) {
                i.next = i.next.next;
                break;
            }
        }
    }

    public void changeValueByPointer(Node node, String newValue) {
        if (node.hodnota != null) node.hodnota = newValue;
    }

    public void changeValueByIndex(int index, String newValue) {
        int currIndex = 0;
        for (Node i = first; i != null ; i = i.next) {
            if (currIndex == index) {
                i.hodnota = newValue;
                break;
            }
            else currIndex++;
        }
    }
    @Override
    public String toString()
    {
        return "LinkedList{" +
                "first=" + first +
                '}';
    }
}
