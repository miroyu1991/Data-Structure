package Changjiang.queue;

import java.util.Scanner;

//problem: can only use once, solution is Circle array queue
public class ArrayQueueDemo {
    public static void main(String[] args) {
        //test

        //create a new array queue
        ArrayQueue arrayQueue = new ArrayQueue(3);
        char key = ' ';
        Scanner scanner = new Scanner(System.in);
        boolean loop = true;

        while(loop){
            //menu
            System.out.println("show(s): show the queue");
            System.out.println("add(a): add an element to the queue");
            System.out.println("get(g): get an element from the  queue");
            System.out.println("head(h): show the head of the queue");
            System.out.println("exit(e): exit the loop");

            key = scanner.next().charAt(0);

            switch (key){
                case 's':
                    arrayQueue.showQueue();
                    break;
                case 'a':
                    System.out.println("Please input a number");
                    int num = scanner.nextInt();
                    arrayQueue.add(num);
                    break;
                case 'g':
                    try {
                        int result = arrayQueue.get();
                        System.out.println("Get number + " + result + " from the queue");

                    }catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'h':
                    try {
                        int result = arrayQueue.showHead();
                        System.out.println("Queue's head is + " + result);

                    }catch (Exception e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'e':
                    scanner.close();
                    loop =false;
                    break;

                default:
                    break;
            }

        }
    }
}

class ArrayQueue{

    int[] queue;
    int maxSize;
    //point to the last element
    int rear = -1;
    //point to the first element -1
    int front = -1;

    //constructor
    public ArrayQueue(int maxSize){
        this.maxSize = maxSize;
        queue = new int[this.maxSize];
    }

    public boolean isFull(){
        return rear == maxSize - 1;
    }

    public boolean isEmpty(){
        return rear == front;
    }

    //add a new element into the queue
    public void add(int num){
        if(this.isFull()){
            System.out.println("Queue is Full, cannot add num " + num);
            return;
        }else{
            queue[++rear] = num;
        }
    }

    //get the first element in the queue
    public int get(){
        if(this.isEmpty()){
            throw new RuntimeException("Queue is Empty, cannot get element");
        }else{
            front++;
            return queue[front];
        }
    }

    //show the whole queue
    public void showQueue(){
        if (this.isEmpty()){
            System.out.println("Queue is Empty");
        }else{
            for(int i = 0; i < queue.length; i++){
                System.out.printf("arr[%d] = %d\n", i, queue[i] );
            }
        }
    }

    public int showHead(){
        if(this.isEmpty()){
            throw new RuntimeException("Queue is Empty, cannot get element");
        }else{
            return queue[front+1];
        }
    }
}
