#include<bits/stdc++.h>
using namespace std;

int main()
{
    //this pair is used to take input burst time and priority of each process
    pair<int,int>process[100];
    int n,ct[1000],tat[1000],wt[1000];
    cout<<"\t\Priority Scheduling"<<endl;
    cout<<"Enter the no. of process you want to insert"<<endl;
    cout<<"N=";
    cin>>n;
    
    // suppose here arrival time for all process is Zero...
    // this loop is used to inserts the burst time of N processes
    for(int i=0;i<n;i++)
    {
        cout<<"Burst Time["<<i+1<<"]=";
        cin>>process[i].second;
        cout<<"Priority["<<i+1<<"]=";
        cin>>process[i].first;
        cout<<endl;
    }
    float t=0,sum=0;
    //this fucntion used to sort the process according to priorities of process
    sort(process,process+n);
    for(int i=0;i<n;i++)
    {
        t=t+process[i].second;
        ct[i]=t;
        // here arrival time for all process is zero so turn arround time is same of completion time
        tat[i]=ct[i]-0;
        wt[i]=tat[i]-process[i].second;
        sum+=wt[i];
    }
    cout<<"Arrival\tBurst\t   Priority\tCompletion\tTaT\tWaiting"<<endl;
    for(int i=0;i<n;i++)
    {
        cout<<0<<"\t"<<process[i].second<<"\t\t"<<process[i].first<<"\t"<<ct[i]<<"\t\t"<<tat[i]<<"\t"<<wt[i]<<endl;
    }
    float v=sum/n;
    cout<<"Average waiting time is :"<<v<<endl;
    return 0;
}