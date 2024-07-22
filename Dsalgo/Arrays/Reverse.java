class Reverse{

static void reverseArray(int[] a)
{
int left =0;
int right = a.length-1;

while(left<right)
{
int temp =a[left];
a[left] = a[right];
a[right] = temp;
left++;
right--;
}
}

public static void main(String[] args)
{

int[] a = {1,2,3};
reverseArray(a);

for(int i:a)
{
    System.out.println(i);
}


}
}