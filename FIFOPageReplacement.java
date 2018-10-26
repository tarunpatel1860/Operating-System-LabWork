
import java.util.*;


public class FifoPageReplacement
{
    public static void main(String[] args) {
        
        int n,npf,hit=0,miss=0,p=0;
        boolean check;
        Scanner sc=new Scanner(System.in);
        
        System.out.println("Enter No. of Pages: ");
        n=sc.nextInt();
        System.out.println("Enter No. of Page Frames: ");
        npf=sc.nextInt();
        
        int pg[]=new int[n];
        int pf[]=new int[npf];
        
        for(int i=0;i<npf;i++)
            pf[i]=-1;
        
        System.out.println("Enter pages:");
        for(int i=0;i<n;i++)
        {
            check=false;
            pg[i]=sc.nextInt();
            
            for(int k=0;k<npf;k++)
            {
                if(pf[k]==pg[i])
                {
                    hit++;
                    check=true;
                    break;
                }
            }
            
            if(check==false)
            {
                miss++;
                
                pf[p++]=pg[i];
                
                if(p==npf)
                    p=0;
            }
        }
        
        System.out.println("Final Page Frame:");
        for(int i=0;i<npf;i++)
            System.out.println(pf[i]);
        
        System.out.println("Page Hits:"+ hit);
        System.out.println("Page Faults:"+ miss);
   }
}