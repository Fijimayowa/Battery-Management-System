package Battery_simulation;

public class Queue {
    BMSObjects device;
    Queue next = null;
    Queue top = null;

    Queue(BMSObjects device) {
        this.device = device;
    }

    public void Enqueue(Queue object) {
        if (top == null) {
            top = object;
        }
        while (top.next != null) {
            top = top.next;
        }
        top.next = object;
    }

    public Queue Dequeue(Queue object) {
        if (top.next != null) {
            Queue returnTop = top;
            top = top.next;
            return returnTop;

        }
        return top;

    }

}
