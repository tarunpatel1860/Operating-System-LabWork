#include<iostream>
using namespace std;
int S=1,E=10,F=0;

int wait(int s)
{
	while(s<=0);
	s--;
	
	return s;
}

int signal(int s)
{
	s++;
	return s;
}

void produce()
{
	S=wait(S);
	E=wait(E);
	F=signal(F);
	cout<<"\n Producer is producing item \n";
	S=signal(S);
	
}

void consume()
{
	S=wait(S);
	F=wait(F);
	E=signal(E);
	cout<<"\n Consumer is consuming item \n";
	S=signal(S);
}

int main()
{
	while(1)
	{   int ch;
		cout<<"1.Produce\n2.Consume\n3.Exit\n";
		cout<<"\n ENTER YOUR CHOICE: ";
		cin>>ch;
		
		switch(ch)
		{
			case 1:
				if(S==1 && E!=0)
				{
					produce();
					break;
				}
				else
				{
					cout<<"\nProducer is waiting\n";
					break;
			    }
			case 2:
				if(S==1 && F!=0)
				{
					consume();
					break;
				}
				else
				{
					cout<<"\n No Product to consume\n";
					break;
				}
			case 3:
				exit(0);
			default:
				cout<<"\n Invalid choice";
		}
	}
	
	return 0;
}
