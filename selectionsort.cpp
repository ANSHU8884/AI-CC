#include<iostream>
using namespace std;
void swap(int *xp, int *yp)
{
    int temp= *xp;
    *xp = *yp;
    *yp = temp;
}

void selectionSort(int arr[],int n)
{
    int i,j,min_idx;
    for(int i=0;i<n-1;i++)
    {
        min_idx=i;
        for(int j=i+1;j<n;j++)
            if(arr[j]<arr[min_idx])
                min_idx=j;

            swap(&arr[min_idx],&arr[i]);
    }
}
void printArray(int arr[],int size)
{
    int i;
    for(i=0;i<size;i++)
        cout<<arr[i]<<" ";
    cout<<endl;
}

int main()
{
    int arr[]={56,44,78,96,10,4,17,32};
    int n=sizeof(arr)/sizeof(arr[0]);
    selectionSort(arr,n);
    cout<<"sorted array is:\n";
    printArray(arr,n);
    return 0;
}