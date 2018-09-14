import java.util.Scanner;

class Process{
    int wait;
    int arrtime;
    int burstt;
    int turnAround;
    int completionTime = 0;
    
    Process(int at,int bur){
        arrtime = at;
        burstt = bur;
    }

}
class Fcfs{
    
    public static void main(String[] args){
        int x=0,n;
        float avgwait = 0,avgta=0;
	Scanner input = new Scanner(System.in);
	System.out.println("Enter the number of processes:");
	n = input.nextInt();
        
        Process myProcess[] = new Process[n];
        
        System.out.println("Enter Arrival time and burst time of following processes: ");
        
            for(int i=0;i<n;i++){
		System.out.println("Process "+(i+1)+": ");
		int at  = input.nextInt();
		int bur = input.nextInt();
		myProcess[i] = new Process(at,bur);
	}
            
        for(int i=0;i<myProcess.length;i++){
            x = x + myProcess[i].burstt;
	                myProcess[i].completionTime = x;
			myProcess[i].turnAround = myProcess[i].completionTime - myProcess[i].arrtime;
			myProcess[i].wait = myProcess[i].turnAround - myProcess[i].burstt;
                        avgwait=avgwait + myProcess[i].wait;
                        avgta= avgta + myProcess[i].turnAround;
			System.out.println("Process "+(i+1)+":");
			System.out.println("Turnaround\tCompletion\twaiting");
			System.out.println(myProcess[i].turnAround+"\t\t\t"+myProcess[i].completionTime+"\t\t\t"+myProcess[i].wait);
        }
        
        System.out.println("Average Waiting time : "+ (avgwait)/n );
        System.out.println("Average Turn- Around time : "+ (avgta)/n );
    }
}