#include <stdio.h>
// USING THRID VARIABLE SWAP IS DONE
void rev_array(int arr[], int n)
{
    int temp;
    for (int i = 0; i < (n / 2); i++)
    {
        temp=arr[i];
        arr[i]=arr[n-1-i];
        arr[n-1-i]=temp;
    }
}

int main()
{
    int n;
    printf("Enter number of elements to be stored in array ");
    scanf("%d", &n);

    int arr[n];

    for (int i = 0; i <= (n - 1); i++)
    {
        printf("Enter element %d : ", i + 1);
        scanf("%d", &arr[i]);
    }

    rev_array(arr, n);

    for (int j = 0; j <= (n - 1); j++)
    {
        printf("Element %d of reversed array is : %d\n", j + 1, arr[j]);
    }

    return 0;
}