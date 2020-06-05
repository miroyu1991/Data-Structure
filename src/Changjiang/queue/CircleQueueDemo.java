package Changjiang.queue;

import java.util.Scanner;

public class CircleQueueDemo {
    public static void main(String[] args) {
//test

        //create a new array queue
        CircleQueue circleQueue = new CircleQueue(3);
        char key = ' ';
        Scanner scanner = new Scanner(System.in);
        boolean loop = true;

        while (loop) {
            //menu
            System.out.println("show(s): show the queue");
            System.out.println("add(a): add an element to the queue");
            System.out.println("get(g): get an element from the  queue");
            System.out.println("head(h): show the head of the queue");
            System.out.println("exit(e): exit the loop");

            key = scanner.next().charAt(0);

            switch (key) {
                case 's':
                    circleQueue.showQueue();
                    break;
                case 'a':
                    System.out.println("Please input a number");
                    int num = scanner.nextInt();
                    circleQueue.add(num);
                    break;
                case 'g':
                    try {
                        int result = circleQueue.get();
                        System.out.println("Get number " + result + " from the queue");

                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'h':
                    try {
                        int result = circleQueue.showHead();
                        System.out.println("Queue's head is " + result);

                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'e':
                    scanner.close();
                    loop = false;
                    break;

                default:
                    break;
            }

        }
    }
}

class CircleQueue {

    int[] queue;
    int maxSize;
    //point to the last element
    int rear = 0;
    //point to the head element
    int front = 0;

    //constructor
    public CircleQueue(int maxSize) {
        this.maxSize = maxSize;
        queue = new int[this.maxSize];
    }

    public boolean isFull() {
        return (rear + 1) % maxSize == front;
    }

    public boolean isEmpty() {
        return rear == front;
    }

    //add a new element into the queue
    public void add(int num) {
        if (this.isFull()) {
            System.out.println("Queue is Full, cannot add num " + num);
        } else {
            queue[rear] = num;
            rear = (rear + 1) % maxSize;
        }
    }

    //get the first element in the queue
    public int get() {
        if (this.isEmpty()) {
            throw new RuntimeException("Queue is Empty, cannot get element");
        } else {
            int value = queue[front];
            front = (front + 1) % maxSize;
            return value;
        }
    }

    //show the whole queue
    public void showQueue() {
        if (this.isEmpty()) {
            System.out.println("Queue is Empty");
        } else {
            for (int i = front; i < (front + (rear + maxSize - front) % maxSize); i++) {
                System.out.printf("arr[%d] = %d\n", i % maxSize, queue[i % maxSize]);
            }
        }
    }

    public int showHead() {
        if (this.isEmpty()) {
            throw new RuntimeException("Queue is Empty, cannot get element");
        } else {
            return queue[front];
        }
    }

}
