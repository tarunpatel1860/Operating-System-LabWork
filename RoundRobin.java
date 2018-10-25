package oslab;

import java.util.Scanner;

public class RoundRobin {
    public static void main(String[] args) {
        int ar[]={1,2,3,4};
        int bt[]=new int[4];
        int wt[]=new int[4];
        int rbt[]=new int[4];
        int total_wt=0,total_tat=0,tbt=0;
        float awt,atat;
        int tat[]=new int[4];
        Scanner s=new Scanner(System.in);
        System.out.println("Enter Burst Time:");
        for(int i=0;i<ar.length;i++)
        {    
            bt[i]=s.nextInt();
            rbt[i]=bt[i];
            tbt+=bt[i];
        }
        int tq,flag=0,t=0;
        System.out.println("Enter Time Quantum:");
        tq=s.nextInt();
        while(true)
        {
            flag=0;
	    for(int i=0;i<ar.length;i++)
	    {
		if(rbt[i]==0)
                flag=flag+1;
	    }
		if(flag==ar.length)
			break;
            for(int i=0;i<ar.length;i++)
		{
                    if(rbt[i]<=tq && rbt[i]!=0)
		 	{
                            t=t+rbt[i];
                            rbt[i]=0;
		 	    wt[i]=t-bt[i];
		 	    tat[i]=wt[i]+bt[i];
		 	}
		 	else if(rbt[i]>tq)
		 	{
		 		t=t+tq;
		 		rbt[i]=rbt[i]-tq;
			}
		}
		tbt-=tq;
	}
         for(int i=0; i<ar.length;i++)
        {
           total_wt=total_wt+wt[i];
           total_tat=total_tat+tat[i];
            System.out.println(bt[i]+"\t    "+wt[i]+"\t\t  "+tat[i]); 
        }
        awt=total_wt/ar.length;
        atat=total_tat/ar.length;
        System.out.println("Average Waiting Time="+awt);
        System.out.println("Average Turn Around Time="+atat);
        
        
        }    
    }
