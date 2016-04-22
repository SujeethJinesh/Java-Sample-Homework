import java.util.Iterator;

/**
 * Snaek Linked List implementation of the SinglyLinkedList interface
 * Worked on this with Jared Duncan and Java API.
 * @author Shashank Singh
 * @author Sujeeth Jinesh
 * @author Severus Snaek
 * @version 1.0
 */
public class SnaekLinkedList implements SinglyLinkedList {

    // DO NOT MODIFY THESE VARIABLE NAMES
    private SnaekNode head = null;
    private SnaekNode tail = new SnaekNode(new Position(0, 0));
    private int size;

    /**
     * Iterates through LinkedList
     * @return iterator.
     */
    @Override
    public Iterator<Position> iterator() {
        return new Iterator<Position>() {
            private SnaekNode iter = head;

            @Override
            public boolean hasNext() {
                return iter != null;
            }

            @Override
            public Position next() {
                Position p = iter.getPosition();
                iter = iter.getNext();
                return p;
            }

            @Override
            public void remove() {

            }
        };
    }

    /**
     * Constructor for SnaekLinkedList.
     */
    public SnaekLinkedList() {
        size = 0;
    }

    /**
     * Adds the Position to the front.
     * @param newPos new Position to add
     */
    @Override
    public void addFront(Position newPos) {
        if (newPos != null) {
            SnaekNode tempNode = new SnaekNode(newPos);
            if (head != null) {
                SnaekNode currentFrontNode = head;
                tempNode.setNext(currentFrontNode);
                head = tempNode;
            } else {
                head = tempNode;
                tail = tempNode;
                head.setNext(null);
            }
            size += 1;
        }
    }

    /**
     * Adds the Position to the end
     * @param newPos new Position to add
     */
    @Override
    public void addEnd(Position newPos) {
        if (newPos != null) {
            SnaekNode tempNode = new SnaekNode(newPos);
            if (tail != null) {
                SnaekNode currentBackNode = tail;
                currentBackNode.setNext(tempNode);
                tempNode.setNext(null);
                tail = tempNode;
            } else {
                head = tempNode;
                tail = tempNode;
                head.setNext(null);
            }
            size += 1;
        }
    }

    /**
     * Gets the front node
     * @return gets the front of the linked list.
     */
    @Override
    public Position removeFront() {
        if (this.isEmpty()) {
            return null;
        } else {
            size -= 1;

            Position headPosition = head.getPosition();

            if (size == 1) {
                head = null;
                tail = null;
            } else {
                SnaekNode newHeadPosition = head.getNext();
                head = newHeadPosition;
            }
            return headPosition;
        }
    }

    @Override
    public Position removeEnd() {
        if (this.isEmpty()) {
            return null;
        } else {
            size -= 1;
            SnaekNode currentTail = tail;
            SnaekNode currentTemp = head;
            while (currentTemp.getNext() != tail) {
                currentTemp = currentTemp.getNext();
            }
            tail = currentTemp;
            return currentTail.getPosition();
        }
    }

    @Override
    public Position getFront() {
        if (size == 0) {
            return null;
        }
        return head.getPosition();
    }

    @Override
    public Position getEnd() {
        if (size == 0) {
            return null;
        }
        return tail.getPosition();
    }

    @Override
    public boolean contains(Position other) {
        for (Position position : this) {
            if (position.equals(other)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void clear() {
        size = 0;
        head = null;
        tail = null;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return this.size() == 0;
    }
}
