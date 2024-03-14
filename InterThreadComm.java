class Data{
    int val;
    boolean flag;
    public Data(){
        val = 0;
        flag = true;
    }
    synchronized public void setVal(int val) {
        while(flag != true){
            try { wait();} catch (Exception e) {
                System.out.println(e);
            }
        }
        this.val = val;
        flag = false;
        notify();
    }
    synchronized public int getVal()  {
        int value = 0;
        while(flag != false){
            try { wait();} catch (Exception e) {}
        }
        value = val;
        flag = true;
        notify();
        return value;
    }
}

class Producer extends Thread{
    Data d;
    public Producer(Data d){
        this.d = d;
    }
    public void run(){
        int i = 1;
        while(true){
            d.setVal(i);
            System.out.println("Producer " + i);
            i++;
        }
    }
}

class Consumer extends Thread {
    Data d;
    public Consumer(Data d){
        this.d = d;
    }
    public void run(){
        while(true){
            try { System.out.println("Consumer " + d.getVal()); } catch (Exception e) {}
        }
    }
}
public class ProducerConsumer {
    public static void main(String[] args) {
        Data d = new Data();
        Producer p = new Producer(d);
        Consumer c = new Consumer(d);
        p.start();
        c.start();
    }
}
