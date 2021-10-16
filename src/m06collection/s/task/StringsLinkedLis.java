package m06collection.s.task;

/**
 * Добавление элементов в двухсвязный список
 * Создайте класс StringsLinkedLis в котором обявите поля first и last ( оба поля должны быть объявлены с ключевым словом  private)
 * first last указывают соот-но на первый и последний элемент
 *  Необходимо реализовать метод add который должен создавать новый объект класса Node,в который он поместит переданное значение
 *   по списку можно проходить как с первого элементы до последнего , так и  наоборот ( не забывайте менять менять ссылки рядом стоящих элементов)
 *
 *   Node first( Node last) не должны иметь значение, только указывает на первый( последний ) элемент
 *
 */

class Demo {
    public static void main(String[] args) {
        StringsLinkedLis str = new StringsLinkedLis();
        str.add("1");
        str.add("2");
        str.add("3");
        str.add("4");
        str.add("5");
        str.add("6");
        str.add("7");
        str.add("8");
        str.add("9");

        StringsLinkedLis.node nd = str.getFirst();
        System.out.println(nd.getValue());
        nd.getNext();
        System.out.println(nd.getValue());

        nd.getNext();
        System.out.println(nd.getValue());

        nd.getNext();
        System.out.println(nd.getValue());

        nd.getNext();
        System.out.println(nd.getValue());

        nd.getNext();
        System.out.println(nd.getValue());

        nd.getNext();
        System.out.println(nd.getValue());

        System.out.println("-----------------------------------");

        System.out.println(nd.getValue());
        nd.getPrev();
        System.out.println(nd.getValue());
        nd.getPrev();
        System.out.println(nd.getValue());
        nd.getPrev();
        System.out.println(nd.getValue());
        nd.getPrev();
        System.out.println(nd.getValue());
        nd.getPrev();
        System.out.println(nd.getValue());
    }

}


class StringsLinkedLis {


    private node first;
    private node last;

    public void add(String str) {
        if (this.first == null) {
            this.first = this.last = new node(str);
        } else if (this.first == this.last){
            this.last = new node(str);
            this.last.prev = this.first;
            this.first.next = last;
        } else {
            this.last.prev.next = new node(str);
            this.last = this.last.prev.next;
        }
    }

    public StringsLinkedLis() {
    }

    public node getFirst() {
        return first;
    }

    public node getLast() {
        return last;
    }

    class node {
        private node next = null;
        private node prev = null;
        private String value = null;

        public void getNext() {
            if(next != null) {
                prev = this;
                next = next.next;
                value = prev.value;
            }
        }

        public void getPrev() {
            if (prev != null) {
                next = this;
                prev = prev.prev;
                value = next.value;
            }
        }

        public String getValue() {
            return value;
        }

        public node (String val) {
            value = val;
        }

        public node () {
        }

    }


}


